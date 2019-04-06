package com.uframe.generator.util.typemapping;

public enum JdbcType
{
    BIT("BIT", 0, -7), 
    TINYINT("TINYINT", 1, -6), 
    SMALLINT("SMALLINT", 2, 5), 
    INTEGER("INTEGER", 3, 4), 
    BIGINT("BIGINT", 4, -5), 
    FLOAT("FLOAT", 5, 6), 
    REAL("REAL", 6, 7), 
    DOUBLE("DOUBLE", 7, 8), 
    NUMERIC("NUMERIC", 8, 2), 
    DECIMAL("DECIMAL", 9, 3), 
    CHAR("CHAR", 10, 1), 
    VARCHAR("VARCHAR", 11, 12), 
    LONGVARCHAR("LONGVARCHAR", 12, -1), 
    DATE("DATE", 13, 91), 
    TIME("TIME", 14, 92), 
    TIMESTAMP("TIMESTAMP", 15, 93), 
    BINARY("BINARY", 16, -2), 
    VARBINARY("VARBINARY", 17, -3), 
    LONGVARBINARY("LONGVARBINARY", 18, -4), 
    NULL("NULL", 19, 0), 
    OTHER("OTHER", 20, 1111), 
    BLOB("BLOB", 21, 2004), 
    CLOB("CLOB", 22, 2005), 
    BOOLEAN("BOOLEAN", 23, 16), 
    CURSOR("CURSOR", 24, -10), 
    UNDEFINED("UNDEFINED", 25, -2147482648), 
    NVARCHAR("NVARCHAR", 26, -9), 
    NCHAR("NCHAR", 27, -15), 
    NCLOB("NCLOB", 28, 2011);
    
    public final int TYPE_CODE;
    
    private JdbcType(final String s, final int n, final int code) {
        this.TYPE_CODE = code;
    }
    
    public static String getJdbcSqlTypeName(final int code) {
        JdbcType[] values;
        for (int length = (values = values()).length, i = 0; i < length; ++i) {
            final JdbcType type = values[i];
            if (type.TYPE_CODE == code) {
                return type.name();
            }
        }
        return null;
    }
}
