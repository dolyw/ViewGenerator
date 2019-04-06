package com.uframe.generator.util.sqlparse;

import java.sql.Date;
import java.util.regex.*;
import java.io.*;
import com.uframe.generator.provider.db.table.*;
import java.util.*;
import java.sql.*;
import com.uframe.generator.util.*;

public class SqlParseHelper
{
    static Pattern fromRegex;
    static Pattern join;
    static Pattern update;
    static Pattern insert;
    public static long startTimes;
    
    static {
        SqlParseHelper.fromRegex = Pattern.compile("(\\sfrom\\s+)([,\\w]+)", 2);
        SqlParseHelper.join = Pattern.compile("(join\\s+)(\\w+)(as)?(\\w*)", 2);
        SqlParseHelper.update = Pattern.compile("(\\s*update\\s+)(\\w+)", 2);
        SqlParseHelper.insert = Pattern.compile("(\\s*insert\\s+into\\s+)(\\w+)", 2);
        SqlParseHelper.startTimes = System.currentTimeMillis();
    }
    
    public static Set<NameWithAlias> getTableNamesByQuery(String sql) {
        sql = sql.trim();
        final Set<NameWithAlias> result = new LinkedHashSet<NameWithAlias>();
        Matcher m = SqlParseHelper.fromRegex.matcher(sql);
        if (m.find()) {
            final String from = getFromClauses(sql);
            if (from.matches("(?ims).*\\sfrom\\s.*")) {
                return getTableNamesByQuery(from);
            }
            if (from.indexOf(44) >= 0) {
                final String[] array = StringHelper.tokenizeToStringArray(from, ",");
                String[] array2;
                for (int length = (array2 = array).length, i = 0; i < length; ++i) {
                    final String s = array2[i];
                    result.add(parseTableSqlAlias(s));
                }
            }
            else if (from.indexOf("join") >= 0) {
                final String removedFrom = StringHelper.removeMany(from.toLowerCase(), "inner", "full", "left", "right", "outer");
                final String[] joins = removedFrom.split("join");
                String[] array3;
                for (int length2 = (array3 = joins).length, j = 0; j < length2; ++j) {
                    final String s2 = array3[j];
                    result.add(parseTableSqlAlias(s2));
                }
            }
            else {
                result.add(parseTableSqlAlias(from));
            }
        }
        m = SqlParseHelper.update.matcher(sql);
        if (m.find()) {
            result.add(new NameWithAlias(m.group(2), null));
        }
        m = SqlParseHelper.insert.matcher(sql);
        if (m.find()) {
            result.add(new NameWithAlias(m.group(2), null));
        }
        return result;
    }
    
    public static NameWithAlias parseTableSqlAlias(String str) {
        try {
            str = str.trim();
            String[] array = str.split("\\sas\\s");
            if (array.length >= 2 && str.matches("^[\\w_]+\\s+as\\s+[_\\w]+.*")) {
                return new NameWithAlias(array[0], StringHelper.tokenizeToStringArray(array[1], " \n\t")[0]);
            }
            array = StringHelper.tokenizeToStringArray(str, " \n\t");
            if (array.length >= 2 && str.matches("^[\\w_]+\\s+[_\\w]+.*")) {
                return new NameWithAlias(array[0], array[1]);
            }
            return new NameWithAlias(StringHelper.getByRegex(str.trim(), "^[\\w_]+"), StringHelper.getByRegex(str.trim(), "^[\\w_]+\\s+([\\w_]+)", 1));
        }
        catch (Exception e) {
            throw new IllegalArgumentException("parseTableSqlAlias error,str:" + str, e);
        }
    }
    
    public static String getParameterClassName(final String sql, final String paramName) {
        final Pattern p = Pattern.compile("(:)(" + paramName + ")(\\|?)([\\w.]+)");
        final Matcher m = p.matcher(sql);
        if (m.find()) {
            return m.group(4);
        }
        return null;
    }
    
    public static String getColumnNameByRightCondition(final String sql, final String column) {
        final String operator = "[=<>!]{1,2}";
        String result = getColumnNameByRightCondition(sql, column, operator);
        if (result == null) {
            result = getColumnNameByRightCondition(sql, column, "\\s+like\\s+");
        }
        if (result == null) {
            result = getColumnNameByRightCondition(sql, column, "\\s+between\\s+");
        }
        if (result == null) {
            result = getColumnNameByRightCondition(sql, column, "\\s+between\\s.+\\sand\\s+");
        }
        if (result == null) {
            result = getColumnNameByRightCondition(sql, column, "\\s+not\\s+in\\s*\\(");
        }
        if (result == null) {
            result = getColumnNameByRightCondition(sql, column, "\\s+in\\s*\\(");
        }
        if (result == null) {
            result = getColumnNameByRightConditionWithFunction(sql, column, operator);
        }
        return result;
    }
    
    private static String getColumnNameByRightConditionWithFunction(final String sql, final String column, final String operator) {
        final Pattern p = Pattern.compile("(\\w+)\\s*" + operator + "\\s*\\w+\\([,\\w]*[:#$&]\\{?" + column + "[\\}#$]?[,\\w]*\\)", 34);
        final Matcher m = p.matcher(sql);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
    
    private static String getColumnNameByRightCondition(final String sql, final String column, final String operator) {
        final Pattern p = Pattern.compile("(\\w+)\\s*" + operator + "\\s*[:#$&]\\{?" + column + "[\\}#$]?", 34);
        final Matcher m = p.matcher(sql);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
    
    public static String convert2NamedParametersSql(final String sql, final String prefix, final String suffix) {
        return new NamedSqlConverter(prefix, suffix).convert2NamedParametersSql(sql);
    }
    
    public static String getPrettySql(final String sql) {
        try {
            if (IOHelper.readLines(new StringReader(sql)).size() > 1) {
                return sql;
            }
            return StringHelper.replace(StringHelper.replace(sql, "from", "\n\tfrom"), "where", "\n\twhere");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String removeSelect(final String sql) {
        if (StringHelper.isBlank(sql)) {
            throw new IllegalArgumentException("sql must be not empty");
        }
        final int beginPos = StringHelper.indexOfByRegex(sql.toLowerCase(), "\\sfrom\\s");
        if (beginPos == -1) {
            throw new IllegalArgumentException(" sql : " + sql + " must has a keyword 'from'");
        }
        return sql.substring(beginPos);
    }
    
    public static String toCountSqlForPaging(final String sql, final String countQueryPrefix) {
        if (StringHelper.isBlank(sql)) {
            throw new IllegalArgumentException("sql must be not empty");
        }
        if (StringHelper.indexOfByRegex(sql.toLowerCase(), "\\sgroup\\s+by\\s") >= 0) {
            return String.valueOf(countQueryPrefix) + " from (" + sql + " ) forGroupByCountTable";
        }
        final int selectBeginOps = StringHelper.indexOfByRegex(sql.toLowerCase(), "select\\s");
        final int fromBeingOps = StringHelper.indexOfByRegex(sql.toLowerCase(), "\\sfrom\\s");
        if (fromBeingOps == -1) {
            throw new IllegalArgumentException(" sql : " + sql + " must has a keyword 'from'");
        }
        return String.valueOf(sql.substring(0, selectBeginOps)) + countQueryPrefix + sql.substring(fromBeingOps);
    }
    
    public static String getSelect(final String sql) {
        if (StringHelper.isBlank(sql)) {
            throw new IllegalArgumentException("sql must be not empty");
        }
        final int beginPos = StringHelper.indexOfByRegex(sql.toLowerCase(), "\\sfrom\\s");
        if (beginPos == -1) {
            throw new IllegalArgumentException(" sql : " + sql + " must has a keyword 'from'");
        }
        return sql.substring(0, beginPos);
    }
    
    public static String getFromClauses(final String sql) {
        final String lowerSql = sql.toLowerCase();
        final int fromBegin = StringHelper.indexOfByRegex(lowerSql, "\\sfrom\\s");
        if (fromBegin <= 0) {
            throw new IllegalArgumentException("error from begin:" + fromBegin);
        }
        int fromEnd = lowerSql.indexOf("where");
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sgroup\\s+by\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\shaving\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sorder\\s+by\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sunion\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sintersect\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sminus\\s");
        }
        if (fromEnd == -1) {
            fromEnd = StringHelper.indexOfByRegex(lowerSql, "\\sexcept\\s");
        }
        if (fromEnd == -1) {
            fromEnd = sql.length();
        }
        return sql.substring(fromBegin + " from ".length(), fromEnd);
    }
    
    public static String removeSqlComments(final String sql) {
        if (sql == null) {
            return null;
        }
        return sql.replaceAll("(?s)/\\*.*?\\*/", "").replaceAll("--.*", "");
    }
    
    public static String removeOrders(final String sql) {
        return sql.replaceAll("(?is)order\\s+by[\\w|\\W|\\s|\\S]*", "");
    }
    
    public static String replaceWhere(final String sql) {
        return sql.toString().replaceAll("(?i)\\swhere\\s+(and|or)", " WHERE");
    }
    
    public static void setRandomParamsValueForPreparedStatement(final String sql, final PreparedStatement ps) throws SQLException {
        final int count = StringHelper.containsCount(sql, "?");
        if (TableFactory.DatabaseMetaDataUtils.isOracleDataBase(ps.getConnection().getMetaData()) && SqlTypeChecker.isSelectSql(sql)) {
            for (int i = 1; i <= count; ++i) {
                ps.setObject(i, null);
            }
            return;
        }
        for (int i = 1; i <= count; ++i) {
            final long random = new Random(System.currentTimeMillis() + SqlParseHelper.startTimes++).nextInt() * 30 + System.currentTimeMillis() + SqlParseHelper.startTimes;
            try {
                ps.setLong(i, random);
            }
            catch (SQLException e) {
                try {
                    ps.setInt(i, (int)random % Integer.MAX_VALUE);
                }
                catch (SQLException e2) {
                    try {
                        ps.setString(i, new StringBuilder().append(random).toString());
                    }
                    catch (SQLException e3) {
                        try {
                            ps.setTimestamp(i, new Timestamp(random));
                        }
                        catch (SQLException e4) {
                            try {
                                ps.setDate(i, new Date(random));
                            }
                            catch (SQLException e5) {
                                try {
                                    ps.setString(i, new StringBuilder().append((int)random).toString());
                                }
                                catch (SQLException e6) {
                                    try {
                                        ps.setString(i, new StringBuilder().append((short)random).toString());
                                    }
                                    catch (SQLException e7) {
                                        try {
                                            ps.setString(i, new StringBuilder().append((byte)random).toString());
                                        }
                                        catch (SQLException e8) {
                                            try {
                                                ps.setNull(i, 1111);
                                            }
                                            catch (SQLException error) {
                                                warn(sql, i, error);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void warn(final String sql, final int i, final SQLException error) {
        GLogger.warn("error on set parametet index:" + i + " cause:" + error + " sql:" + sql);
    }
    
    public static class NameWithAlias
    {
        private String name;
        private String alias;
        
        public NameWithAlias(final String name, final String alias) {
            if (name == null) {
                throw new IllegalArgumentException("name must be not null");
            }
            if (name.trim().indexOf(32) >= 0) {
                throw new IllegalArgumentException("error name:" + name);
            }
            if (alias != null && alias.trim().indexOf(32) >= 0) {
                throw new IllegalArgumentException("error alias:" + alias);
            }
            this.name = name.trim();
            this.alias = ((alias == null) ? null : alias.trim());
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getAlias() {
            return StringHelper.isBlank(this.alias) ? this.getName() : this.alias;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = 31 * result + ((this.name == null) ? 0 : this.name.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            final NameWithAlias other = (NameWithAlias)obj;
            if (this.name == null) {
                if (other.name != null) {
                    return false;
                }
            }
            else if (!this.name.equals(other.name)) {
                return false;
            }
            return true;
        }
        
        @Override
        public String toString() {
            return StringHelper.isBlank(this.alias) ? this.name : (String.valueOf(this.name) + " as " + this.alias);
        }
    }
    
    public static class NamedSqlConverter
    {
        private String prefix;
        private String suffix;
        
        public NamedSqlConverter(final String prefix, final String suffix) {
            if (prefix == null) {
                throw new NullPointerException("'prefix' must be not null");
            }
            if (suffix == null) {
                throw new NullPointerException("'suffix' must be not null");
            }
            this.prefix = prefix;
            this.suffix = suffix;
        }
        
        public String convert2NamedParametersSql(final String sql) {
            if (sql.trim().toLowerCase().matches("(?is)\\s*insert\\s+into\\s+.*")) {
                return this.replace2NamedParameters(this.replaceInsertSql2NamedParameters(sql));
            }
            return this.replace2NamedParameters(sql);
        }
        
        private String replace2NamedParameters(final String sql) {
            String replacedSql = this.replace2NamedParametersByOperator(sql, "[=<>!]{1,2}");
            replacedSql = this.replace2NamedParametersByOperator(replacedSql, "\\s+like\\s+");
            return replacedSql;
        }
        
        private String replaceInsertSql2NamedParameters(final String sql) {
            if (sql.matches("(?is)\\s*insert\\s+into\\s+\\w+\\s+values\\s*\\(.*\\).*")) {
                if (sql.indexOf("?") >= 0) {
                    throw new IllegalArgumentException("\u65e0\u6cd5\u89e3\u6790\u7684insert sql:" + sql + ",values()\u6bb5\u4e0d\u80fd\u5305\u542b\u7591\u95ee\u53f7?");
                }
                return sql;
            }
            else {
                final Pattern p = Pattern.compile("\\s*insert\\s+into.*\\((.*?)\\).*values.*?\\((.*)\\).*", 34);
                final Matcher m = p.matcher(sql);
                if (!m.find()) {
                    throw new IllegalArgumentException("\u65e0\u6cd5\u89e3\u6790\u7684sql:" + sql + ",\u4e0d\u5339\u914d\u6b63\u5219\u8868\u8fbe\u5f0f:" + p.pattern());
                }
                final String[] columns = StringHelper.tokenizeToStringArray(m.group(1), ", \t\n\r\f");
                final String[] values = StringHelper.tokenizeToStringArray(m.group(2), ", \t\n\r\f");
                if (columns.length != values.length) {
                    throw new IllegalArgumentException("insert \u8bed\u53e5\u7684\u63d2\u5165\u5217\u4e0e\u503c\u5217\u6570\u76ee\u4e0d\u76f8\u7b49,sql:" + sql + " columns:" + StringHelper.join(columns, ",") + " values:" + StringHelper.join(values, ","));
                }
                for (int i = 0; i < columns.length; ++i) {
                    final String column = columns[i];
                    final String paranName = StringHelper.uncapitalize(StringHelper.makeAllWordFirstLetterUpperCase(column));
                    values[i] = values[i].replace("?", String.valueOf(this.prefix) + paranName + this.suffix);
                }
                return StringHelper.replace(m.start(2), m.end(2), sql, StringHelper.join(values, ","));
            }
        }
        
        private String replace2NamedParametersByOperator(final String sql, final String operator) {
            final Pattern p = Pattern.compile("(\\w+)\\s*" + operator + "\\s*\\?", 34);
            final Matcher m = p.matcher(sql);
            final StringBuffer sb = new StringBuffer();
            while (m.find()) {
                final String segment = m.group(0);
                final String columnSqlName = m.group(1);
                final String paramName = StringHelper.uncapitalize(StringHelper.makeAllWordFirstLetterUpperCase(columnSqlName));
                final String replacedSegment = segment.replace("?", String.valueOf(this.prefix) + paramName + this.suffix);
                m.appendReplacement(sb, replacedSegment);
            }
            m.appendTail(sb);
            return sb.toString();
        }
    }
}
