package com.uframe.generator.provider.db.sql.model;

import com.uframe.generator.provider.db.table.model.*;
import com.uframe.generator.util.*;
import java.util.*;
import com.uframe.generator.util.sqlparse.*;

public class Sql
{
    public static String MULTIPLICITY_ONE;
    public static String MULTIPLICITY_MANY;
    public static String MULTIPLICITY_PAGING;
    String tableSqlName;
    String operation;
    String resultClass;
    String parameterClass;
    String remarks;
    String multiplicity;
    boolean paging;
    String sqlmap;
    LinkedHashSet<Column> columns;
    LinkedHashSet<SqlParameter> params;
    String sourceSql;
    String executeSql;
    private String paramType;
    private String ibatisSql;
    private String ibatis3Sql;
    
    static {
        Sql.MULTIPLICITY_ONE = "one";
        Sql.MULTIPLICITY_MANY = "many";
        Sql.MULTIPLICITY_PAGING = "paging";
    }
    
    public Sql() {
        this.tableSqlName = null;
        this.operation = null;
        this.multiplicity = Sql.MULTIPLICITY_ONE;
        this.paging = false;
        this.columns = new LinkedHashSet<Column>();
        this.params = new LinkedHashSet<SqlParameter>();
        this.paramType = "primitive";
    }
    
    public Sql(final Sql sql) {
        this.tableSqlName = null;
        this.operation = null;
        this.multiplicity = Sql.MULTIPLICITY_ONE;
        this.paging = false;
        this.columns = new LinkedHashSet<Column>();
        this.params = new LinkedHashSet<SqlParameter>();
        this.paramType = "primitive";
        this.tableSqlName = sql.tableSqlName;
        this.operation = sql.operation;
        this.parameterClass = sql.parameterClass;
        this.resultClass = sql.resultClass;
        this.multiplicity = sql.multiplicity;
        this.columns = sql.columns;
        this.params = sql.params;
        this.sourceSql = sql.sourceSql;
        this.executeSql = sql.executeSql;
        this.remarks = sql.remarks;
    }
    
    public boolean isColumnsInSameTable() {
        if (this.columns == null || this.columns.isEmpty()) {
            return false;
        }
        final Column firstTable = this.columns.iterator().next();
        if (this.columns.size() == 1) {
            return true;
        }
        if (firstTable.getTable() == null) {
            return false;
        }
        final String preTableName = firstTable.getTable().getSqlName();
        for (final Column c : this.columns) {
            final Table table = c.getTable();
            if (table == null) {
                return false;
            }
            if (preTableName.equalsIgnoreCase(table.getSqlName())) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    public String getResultClass() {
        if (StringHelper.isNotBlank(this.resultClass)) {
            return this.resultClass;
        }
        if (this.columns.size() == 1) {
            return this.columns.iterator().next().getSimpleJavaType();
        }
        if (this.isColumnsInSameTable()) {
            return this.columns.iterator().next().getTable().getClassName();
        }
        if (this.operation == null) {
            return null;
        }
        return String.valueOf(StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(this.operation))) + System.getProperty("generator.sql.resultClass.suffix", "Result");
    }
    
    public void setResultClass(final String queryResultClass) {
        this.resultClass = queryResultClass;
    }
    
    public String getResultClassName() {
        final int lastIndexOf = this.getResultClass().lastIndexOf(".");
        return (lastIndexOf >= 0) ? this.getResultClass().substring(lastIndexOf + 1) : this.getResultClass();
    }
    
    public String getParameterClass() {
        if (StringHelper.isNotBlank(this.parameterClass)) {
            return this.parameterClass;
        }
        if (StringHelper.isBlank(this.operation)) {
            return null;
        }
        if (this.isSelectSql()) {
            return String.valueOf(StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(this.operation))) + "Query";
        }
        return String.valueOf(StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(this.operation))) + "Parameter";
    }
    
    public void setParameterClass(final String parameterClass) {
        this.parameterClass = parameterClass;
    }
    
    public String getParameterClassName() {
        final int lastIndexOf = this.getParameterClass().lastIndexOf(".");
        return (lastIndexOf >= 0) ? this.getParameterClass().substring(lastIndexOf + 1) : this.getParameterClass();
    }
    
    public int getColumnsCount() {
        return this.columns.size();
    }
    
    public void addColumn(final Column c) {
        this.columns.add(c);
    }
    
    public String getOperation() {
        return this.operation;
    }
    
    public void setOperation(final String operation) {
        this.operation = operation;
    }
    
    public String getOperationFirstUpper() {
        return StringHelper.capitalize(this.getOperation());
    }
    
    public String getMultiplicity() {
        return this.multiplicity;
    }
    
    public void setMultiplicity(final String multiplicity) {
        this.multiplicity = multiplicity;
    }
    
    public LinkedHashSet<Column> getColumns() {
        return this.columns;
    }
    
    public void setColumns(final LinkedHashSet<Column> columns) {
        this.columns = columns;
    }
    
    public LinkedHashSet<SqlParameter> getParams() {
        return this.params;
    }
    
    public void setParams(final LinkedHashSet<SqlParameter> params) {
        this.params = params;
    }
    
    public SqlParameter getParam(final String paramName) {
        for (final SqlParameter p : this.getParams()) {
            if (p.getParamName().equals(paramName)) {
                return p;
            }
        }
        return null;
    }
    
    public String getSourceSql() {
        return this.sourceSql;
    }
    
    public void setSourceSql(final String sourceSql) {
        this.sourceSql = sourceSql;
    }
    
    public String getSqlmap() {
        return this.sqlmap;
    }
    
    public void setSqlmap(String sqlmap) {
        if (StringHelper.isNotBlank(sqlmap)) {
            sqlmap = StringHelper.replace(sqlmap, "${cdata-start}", "<![CDATA[");
            sqlmap = StringHelper.replace(sqlmap, "${cdata-end}", "]]>");
        }
        this.sqlmap = sqlmap;
    }
    
    public String getSqlmap(final List<String> params) {
        if (params == null || params.size() == 0) {
            return this.sqlmap;
        }
        String result = this.sqlmap;
        if (params.size() == 1) {
            return StringHelper.replace(result, "${param1}", "value");
        }
        for (int i = 0; i < params.size(); ++i) {
            result = StringHelper.replace(result, "${param" + (i + 1) + "}", params.get(i));
        }
        return result;
    }
    
    public boolean isHasSqlMap() {
        return StringHelper.isNotBlank(this.sqlmap);
    }
    
    public String getExecuteSql() {
        return this.executeSql;
    }
    
    public void setExecuteSql(final String executeSql) {
        this.executeSql = executeSql;
    }
    
    public String getCountHql() {
        return this.toCountSqlForPaging(this.getHql());
    }
    
    public String getCountSql() {
        return this.toCountSqlForPaging(this.getSql());
    }
    
    public String getIbatisCountSql() {
        return this.toCountSqlForPaging(this.getIbatisSql());
    }
    
    public String getIbatis3CountSql() {
        return this.toCountSqlForPaging(this.getIbatis3Sql());
    }
    
    public String getSqlmapCountSql() {
        return this.toCountSqlForPaging(this.getSqlmap());
    }
    
    public String getSql() {
        return this.replaceWildcardWithColumnsSqlName(this.sourceSql);
    }
    
    public String toCountSqlForPaging(final String sql) {
        if (sql == null) {
            return null;
        }
        if (this.isSelectSql()) {
            return SqlParseHelper.toCountSqlForPaging(sql, "select count(*) ");
        }
        return sql;
    }
    
    public String getSpringJdbcSql() {
        return SqlParseHelper.convert2NamedParametersSql(this.getSql(), ":", "");
    }
    
    public String getHql() {
        return SqlParseHelper.convert2NamedParametersSql(this.getSql(), ":", "");
    }
    
    public String getIbatisSql() {
        return StringHelper.isBlank(this.ibatisSql) ? SqlParseHelper.convert2NamedParametersSql(this.getSql(), "#", "#") : this.ibatisSql;
    }
    
    public String getIbatis3Sql() {
        return StringHelper.isBlank(this.ibatis3Sql) ? SqlParseHelper.convert2NamedParametersSql(this.getSql(), "#{", "}") : this.ibatis3Sql;
    }
    
    public void setIbatisSql(final String ibatisSql) {
        this.ibatisSql = ibatisSql;
    }
    
    public void setIbatis3Sql(final String ibatis3Sql) {
        this.ibatis3Sql = ibatis3Sql;
    }
    
    private String joinColumnsSqlName() {
        final StringBuffer sb = new StringBuffer();
        final Iterator<Column> it = this.columns.iterator();
        while (it.hasNext()) {
            final Column c = it.next();
            sb.append(c.getSqlName());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    
    public String replaceWildcardWithColumnsSqlName(final String sql) {
        if (SqlTypeChecker.isSelectSql(sql) && SqlParseHelper.getSelect(SqlParseHelper.removeSqlComments(sql)).indexOf("*") >= 0 && SqlParseHelper.getSelect(SqlParseHelper.removeSqlComments(sql)).indexOf("count(") < 0) {
            return SqlParseHelper.getPrettySql("select " + this.joinColumnsSqlName() + " " + SqlParseHelper.removeSelect(sql));
        }
        return sql;
    }
    
    public boolean isSelectSql() {
        return SqlTypeChecker.isSelectSql(this.sourceSql);
    }
    
    public boolean isUpdateSql() {
        return SqlTypeChecker.isUpdateSql(this.sourceSql);
    }
    
    public boolean isDeleteSql() {
        return SqlTypeChecker.isDeleteSql(this.sourceSql);
    }
    
    public boolean isInsertSql() {
        return SqlTypeChecker.isInsertSql(this.sourceSql);
    }
    
    public String getTableSqlName() {
        return this.tableSqlName;
    }
    
    public void setTableSqlName(final String tableName) {
        this.tableSqlName = tableName;
    }
    
    public String getRemarks() {
        return this.remarks;
    }
    
    public String getParamType() {
        return this.paramType;
    }
    
    public void setParamType(final String paramType) {
        this.paramType = paramType;
    }
    
    public void setRemarks(final String comments) {
        this.remarks = comments;
    }
    
    public boolean isPaging() {
        return Sql.MULTIPLICITY_PAGING.equalsIgnoreCase(this.multiplicity) || this.paging;
    }
    
    public void setPaging(final boolean paging) {
        this.paging = paging;
    }
    
    public String getTableClassName() {
        if (StringHelper.isBlank(this.tableSqlName)) {
            return null;
        }
        final String removedPrefixSqlName = Table.removeTableSqlNamePrefix(this.tableSqlName);
        return StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(removedPrefixSqlName));
    }
    
    public Column getColumnBySqlName(final String sqlName) {
        for (final Column c : this.getColumns()) {
            if (c.getSqlName().equalsIgnoreCase(sqlName)) {
                return c;
            }
        }
        return null;
    }
    
    public Column getColumnByName(final String name) {
        Column c = this.getColumnBySqlName(name);
        if (c == null) {
            c = this.getColumnBySqlName(StringHelper.toUnderscoreName(name));
        }
        return c;
    }
    
    @Override
    public String toString() {
        return "sourceSql:\n" + this.sourceSql + "\nsql:" + this.getSql();
    }
}
