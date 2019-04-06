package com.uframe.generator.util.typemapping;

import com.uframe.generator.util.StringHelper;

import java.util.*;

public class OracleDataTypeForJdbcAndJava
{
    private static final Map _preferredSqlTypeForDataType;
    private static final Map _preferredJavaTypeForDataType;
    
    static {
        _preferredSqlTypeForDataType = new HashMap();
        _preferredJavaTypeForDataType = new HashMap();
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("blob", "BLOB");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("clob", "CLOB");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("date", "TIMESTAMP");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("number", "DECIMAL");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("long", "VARBINARY");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("timestamp", "TIMESTAMP");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("varchar2", "VARCHAR");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("varchar", "VARCHAR");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("nvarchar2", "VARCHAR");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("nclob", "OTHER");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("smallint", "SMALLINT");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("char", "CHAR");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("raw", "VARBINARY");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("float", "FLOAT");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("integer", "INTEGER");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("double", "DOUBLE");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("real", "REAL");
        OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.put("ref cursor", "ORACLECURSOR");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("blob", "byte[]");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("clob", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("date", "java.sql.Date");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("number", "java.math.BigDecimal");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("long", "java.math.BigDecimal");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("timestamp", "java.sql.Timestamp");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("varchar2", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("varchar", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("nvarchar2", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("nclob", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("smallint", "java.lang.Short");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("char", "java.lang.String");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("raw", "byte[]");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("float", "java.lang.Double");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("integer", "java.lang.Integer");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("double", "java.lang.Double");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("real", "java.lang.Float");
        OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.put("ref cursor", "cursor");
    }
    
    public static String getPreferredJdbcType(final String dataType) {
        final String jdbcType = StringHelper.convertType(OracleDataTypeForJdbcAndJava._preferredSqlTypeForDataType.get(dataType));
        return jdbcType;
    }
    
    public static String getPreferredJavaType(final String dataType) {
        final String javaType = StringHelper.convertType(OracleDataTypeForJdbcAndJava._preferredJavaTypeForDataType.get(dataType));
        return javaType;
    }
    
    public static String getPreferredParameterKind(final String dataType) {
        return null;
    }
    
    public static boolean isBaseDataType(final String dataType) {
        return "char".equals(dataType) || "nchar".equals(dataType) || "varchar2".equals(dataType) || "nvarchar2".equals(dataType) || "date".equals(dataType) || "long".equals(dataType) || "raw".equals(dataType) || "blob".equals(dataType) || "clob".equals(dataType) || "nclob".equals(dataType) || "bfile".equals(dataType) || "rowid".equals(dataType) || "nrowid".equals(dataType) || "number".equals(dataType) || "decimal".equals(dataType) || "integer".equals(dataType) || "float".equals(dataType) || "real".equals(dataType) || "timestamp".equals(dataType) || "binary_double".equals(dataType) || "smallint".equals(dataType) || "ref".equals(dataType) || "varchar".equals(dataType) || "binary_float".equals(dataType);
    }
}
