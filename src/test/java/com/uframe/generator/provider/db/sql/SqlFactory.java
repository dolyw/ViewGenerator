package com.uframe.generator.provider.db.sql;

import com.uframe.generator.provider.db.sql.model.*;
import com.uframe.generator.provider.db.*;
import com.uframe.generator.provider.db.table.*;
import java.sql.*;
import com.uframe.generator.util.sqlparse.*;
import com.uframe.generator.provider.db.table.model.*;
import com.uframe.generator.util.*;
import com.uframe.generator.util.typemapping.*;
import java.util.*;

public class SqlFactory
{
    private List<SqlParameter> customParameters;
    
    public SqlFactory() {
        this.customParameters = new ArrayList<SqlParameter>();
    }
    
    public SqlFactory(final List<SqlParameter> customParameters) {
        this.customParameters = new ArrayList<SqlParameter>();
        this.customParameters = customParameters;
    }
    
    public Sql parseSql(final String sourceSql) {
        if (StringHelper.isBlank(sourceSql)) {
            throw new IllegalArgumentException("sourceSql must be not empty");
        }
        final String beforeProcessedSql = this.beforeParseSql(sourceSql);
        final String namedSql = SqlParseHelper.convert2NamedParametersSql(beforeProcessedSql, ":", "");
        final ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(namedSql);
        final String executeSql = new BasicSqlFormatter().format(NamedParameterUtils.substituteNamedParameters(parsedSql));
        final Sql sql = new Sql();
        sql.setSourceSql(sourceSql);
        sql.setExecuteSql(executeSql);
        GLogger.debug("\n*******************************");
        GLogger.debug("sourceSql  :" + sql.getSourceSql());
        GLogger.debug("namedSql  :" + namedSql);
        GLogger.debug("executeSql :" + sql.getExecuteSql());
        GLogger.debug("*********************************");
        final Connection conn = DataSourceProvider.getConnection();
        try {
            if (!TableFactory.DatabaseMetaDataUtils.isHsqlDataBase(conn.getMetaData())) {
                conn.setReadOnly(true);
            }
            conn.setAutoCommit(false);
            final PreparedStatement ps = conn.prepareStatement(SqlParseHelper.removeOrders(executeSql));
            final ResultSetMetaData resultSetMetaData = this.executeForResultSetMetaData(executeSql, ps);
            sql.setColumns(new SelectColumnsParser().convert2Columns(sql, resultSetMetaData));
            sql.setParams(new SqlParametersParser().parseForSqlParameters(parsedSql, sql));
            return this.afterProcessedSql(sql);
        }
        catch (SQLException e) {
            throw new RuntimeException("execute sql occer error,\nexecutedSql:" + SqlParseHelper.removeOrders(executeSql), e);
        }
        catch (Exception e2) {
            throw new RuntimeException("sql parse error,\nexecutedSql:" + SqlParseHelper.removeOrders(executeSql), e2);
        }
        finally {
            try {
                conn.rollback();
                conn.close();
            }
            catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }
    
    protected Sql afterProcessedSql(final Sql sql) {
        return sql;
    }
    
    protected String beforeParseSql(final String sourceSql) {
        return sourceSql;
    }
    
    private ResultSetMetaData executeForResultSetMetaData(final String executeSql, final PreparedStatement ps) throws SQLException {
        SqlParseHelper.setRandomParamsValueForPreparedStatement(SqlParseHelper.removeOrders(executeSql), ps);
        ps.setMaxRows(3);
        ps.setFetchSize(3);
        ps.setQueryTimeout(20);
        try {
            final ResultSet rs = ps.executeQuery();
            return rs.getMetaData();
        }
        catch (SQLException e) {
            try {
                return ps.getMetaData();
            }
            catch (SQLException ee) {
                throw e;
            }
        }
    }
    
    public static void main(final String[] args) throws Exception {
        final Sql n2 = new SqlFactory().parseSql("select user_info.username,password pwd from user_info where username=:username and password =:password");
        final Sql n3 = new SqlFactory().parseSql("select username,password,role.role_name,role_desc from user_info,role where user_info.user_id = role.user_id and username=:username and password =:password");
        final Sql n4 = new SqlFactory().parseSql("select count(*) cnt from user_info,role where user_info.user_id = role.user_id and username=:username and password =:password");
        final Sql n5 = new SqlFactory().parseSql("select sum(age) from user_info,role where user_info.user_id = role.user_id and username=:username and password =:password");
        final Sql n6 = new SqlFactory().parseSql("select username,password,count(role_desc) role_desc_cnt from user_info,role where user_info.user_id = role.user_id group by username");
        final Sql n7 = new SqlFactory().parseSql("select username,password,count(role_desc) role_desc_cnt from user_info,role where user_info.user_id = :userId group by username");
        new SqlFactory().parseSql("select username,password,role_desc from user_info,role where user_info.user_id = role.user_id and username=:username and password =:password and birth_date between :birthDateBegin and :birthDateEnd");
        new SqlFactory().parseSql("select username,password,role_desc from user_info,role where user_info.user_id = role.user_id and username=:username and password =:password and birth_date between :birthDateBegin and :birthDateEnd limit :offset,:limit");
    }
    
    public class SelectColumnsParser
    {
        private LinkedHashSet<Column> convert2Columns(final Sql sql, final ResultSetMetaData metadata) throws SQLException, Exception {
            if (metadata == null) {
                return new LinkedHashSet<Column>();
            }
            final LinkedHashSet<Column> columns = new LinkedHashSet<Column>();
            for (int i = 1; i <= metadata.getColumnCount(); ++i) {
                final Column c = this.convert2Column(sql, metadata, i);
                if (c == null) {
                    throw new IllegalStateException("column must be not null");
                }
                columns.add(c);
            }
            return columns;
        }
        
        private Column convert2Column(final Sql sql, final ResultSetMetaData metadata, final int i) throws SQLException, Exception {
            final ResultSetMetaDataHolder m = new ResultSetMetaDataHolder(metadata, i);
            if (!StringHelper.isNotBlank(m.getTableName())) {
                return this.newColumn(null, m);
            }
            final Table table = this.foundTableByTableNameOrTableAlias(sql, m.getTableName());
            if (table == null) {
                return this.newColumn(null, m);
            }
            Column column = table.getColumnBySqlName(m.getColumnNameOrLabel());
            if (column == null || column.getSqlType() != m.getColumnType()) {
                column = this.newColumn(table, m);
                GLogger.trace("not found column:" + m.getColumnNameOrLabel() + " on table:" + table.getSqlName() + " " + BeanHelper.describe(column));
            }
            else {
                GLogger.trace("found column:" + m.getColumnNameOrLabel() + " on table:" + table.getSqlName() + " " + BeanHelper.describe(column));
            }
            return column;
        }
        
        private Column newColumn(final Table table, final ResultSetMetaDataHolder m) {
            final Column column = new Column(null, m.getColumnType(), m.getColumnTypeName(), m.getColumnNameOrLabel(), m.getColumnDisplaySize(), m.getScale(), false, false, false, false, null, null);
            GLogger.trace("not found on table by table emtpty:" + BeanHelper.describe(column));
            return column;
        }
        
        private Table foundTableByTableNameOrTableAlias(final Sql sql, final String tableNameId) throws Exception {
            try {
                return TableFactory.getInstance().getTable(tableNameId);
            }
            catch (TableFactory.NotFoundTableException e) {
                final Set<SqlParseHelper.NameWithAlias> tableNames = SqlParseHelper.getTableNamesByQuery(sql.getExecuteSql());
                for (final SqlParseHelper.NameWithAlias tableName : tableNames) {
                    if (tableName.getAlias().equalsIgnoreCase(tableNameId)) {
                        return TableFactory.getInstance().getTable(tableName.getName());
                    }
                }
                return null;
            }
        }
    }
    
    public class SqlParametersParser
    {
        Map<String, Column> specialParametersMapping;
        
        public SqlParametersParser() {
            (this.specialParametersMapping = new HashMap<String, Column>()).put("offset", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "offset", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("limit", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "limit", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("pageSize", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "pageSize", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("pageNo", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "pageNo", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("pageNumber", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "pageNumber", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("page", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "page", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("beginRow", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "beginRow", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("beginRows", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "beginRows", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("startRow", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "startRow", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("startRows", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "startRows", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("endRow", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "endRow", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("endRows", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "endRows", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("lastRow", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "lastRow", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("lastRows", new Column(null, JdbcType.INTEGER.TYPE_CODE, "INTEGER", "lastRows", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("orderBy", new Column(null, JdbcType.VARCHAR.TYPE_CODE, "VARCHAR", "orderBy", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("orderby", new Column(null, JdbcType.VARCHAR.TYPE_CODE, "VARCHAR", "orderby", 0, 0, false, false, false, false, null, null));
            this.specialParametersMapping.put("sortColumns", new Column(null, JdbcType.VARCHAR.TYPE_CODE, "VARCHAR", "sortColumns", 0, 0, false, false, false, false, null, null));
        }
        
        private LinkedHashSet<SqlParameter> parseForSqlParameters(final ParsedSql parsedSql, final Sql sql) throws Exception {
            final LinkedHashSet<SqlParameter> result = new LinkedHashSet<SqlParameter>();
            final long start = System.currentTimeMillis();
            for (int i = 0; i < parsedSql.getParameterNames().size(); ++i) {
                final String paramName = parsedSql.getParameterNames().get(i);
                Column column = this.findColumnByParamName(parsedSql, sql, paramName);
                if (column == null) {
                    column = this.specialParametersMapping.get(paramName);
                    if (column == null) {
                        column = new Column(null, JdbcType.UNDEFINED.TYPE_CODE, "UNDEFINED", paramName, 0, 0, false, false, false, false, null, null);
                    }
                }
                final SqlParameter param = new SqlParameter(column);
                param.setParamName(paramName);
                if (this.isMatchListParam(sql.getSourceSql(), paramName)) {
                    param.setListParam(true);
                }
                result.add(param);
            }
            GLogger.perf("parseForSqlParameters() cost:" + (System.currentTimeMillis() - start));
            return result;
        }
        
        public boolean isMatchListParam(final String sql, final String paramName) {
            return sql.matches("(?s).*\\sin\\s*\\([:#\\$&]\\{?" + paramName + "\\}?[$#}]?\\).*") || sql.matches("(?s).*[#$]" + paramName + "\\[]\\.?\\w*[#$].*") || sql.matches("(?s).*[#$]\\{" + paramName + "\\[[$\\{\\}\\w]+]\\}*.*");
        }
        
        private Column findColumnByParamName(final ParsedSql parsedSql, final Sql sql, final String paramName) throws Exception {
            for (final SqlParameter customParam : SqlFactory.this.customParameters) {
                if (customParam.getParamName().equals(paramName)) {
                    return customParam;
                }
            }
            Column column = sql.getColumnByName(paramName);
            if (column == null) {
                column = this.findColumnByParseSql(parsedSql, SqlParseHelper.getColumnNameByRightCondition(parsedSql.toString(), paramName));
            }
            if (column == null) {
                column = this.findColumnByParseSql(parsedSql, paramName);
            }
            return column;
        }
        
        private Column findColumnByParseSql(final ParsedSql sql, final String paramName) throws Exception {
            final Collection<SqlParseHelper.NameWithAlias> tableNames = SqlParseHelper.getTableNamesByQuery(sql.toString());
            for (final SqlParseHelper.NameWithAlias tableName : tableNames) {
                final Table t = TableFactory.getInstance().getTable(tableName.getName());
                if (t != null) {
                    final Column column = t.getColumnByName(paramName);
                    if (column != null) {
                        return column;
                    }
                    continue;
                }
            }
            return null;
        }
    }
}
