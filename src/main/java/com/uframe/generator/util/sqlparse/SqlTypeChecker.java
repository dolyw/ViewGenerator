package com.uframe.generator.util.sqlparse;

public class SqlTypeChecker
{
    public static boolean isSelectSql(final String sourceSql) {
        return SqlParseHelper.removeSqlComments(sourceSql).trim().toLowerCase().matches("(?is)\\s*select\\s.*\\sfrom\\s+.*");
    }
    
    public static boolean isUpdateSql(final String sourceSql) {
        return SqlParseHelper.removeSqlComments(sourceSql).trim().toLowerCase().matches("(?is)\\s*update\\s+.*");
    }
    
    public static boolean isDeleteSql(final String sourceSql) {
        return SqlParseHelper.removeSqlComments(sourceSql).trim().toLowerCase().matches("(?is)\\s*delete\\s+from\\s.*");
    }
    
    public static boolean isInsertSql(final String sourceSql) {
        return SqlParseHelper.removeSqlComments(sourceSql).trim().toLowerCase().matches("(?is)\\s*insert\\s+into\\s+.*");
    }
}
