package com.uframe.generator.util.typemapping;

import com.uframe.generator.util.StringHelper;

import java.util.*;

public class DatabaseDataTypesUtils
{
    private static final IntStringMap _preferredJavaTypeForSqlType;
    
    static {
        (_preferredJavaTypeForSqlType = new IntStringMap()).put(-6, "java.lang.Byte");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(5, "java.lang.Short");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(4, "java.lang.Integer");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-5, "java.math.BigInteger");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(7, "java.lang.Float");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(6, "java.lang.Double");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(8, "java.lang.Double");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(3, "java.math.BigDecimal");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2, "java.math.BigDecimal");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-7, "java.lang.Boolean");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(16, "java.lang.Boolean");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(1, "java.lang.String");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(12, "java.lang.String");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-1, "java.lang.String");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-2, "byte[]");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-3, "byte[]");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(-4, "byte[]");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(91, "java.sql.Date");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(92, "java.sql.Time");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(93, "java.sql.Timestamp");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2005, "java.sql.Clob");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2004, "java.sql.Blob");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2003, "java.sql.Array");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2006, "java.sql.Ref");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2002, "java.lang.Object");
        DatabaseDataTypesUtils._preferredJavaTypeForSqlType.put(2000, "java.lang.Object");
    }
    
    public static boolean isFloatNumber(final String javaType) {
        return javaType.endsWith("Float") || javaType.endsWith("Double") || javaType.endsWith("BigDecimal") || javaType.endsWith("BigInteger") || (javaType.endsWith("float") || javaType.endsWith("double") || javaType.endsWith("BigDecimal") || javaType.endsWith("BigInteger"));
    }
    
    public static boolean isIntegerNumber(final String javaType) {
        return javaType.endsWith("Long") || javaType.endsWith("Integer") || javaType.endsWith("Short") || javaType.endsWith("Byte") || (javaType.endsWith("long") || javaType.endsWith("int") || javaType.endsWith("short") || javaType.endsWith("byte"));
    }
    
    public static boolean isDate(final String javaType) {
        return javaType.endsWith("Date") || javaType.endsWith("Timestamp") || javaType.endsWith("Time");
    }
    
    public static boolean isString(final String javaType) {
        return javaType.endsWith("String");
    }
    
    public static String getPreferredJavaType(final int sqlType, final int size, final int decimalDigits) {
        if ((sqlType != 3 && sqlType != 2) || decimalDigits != 0) {
            String result = DatabaseDataTypesUtils._preferredJavaTypeForSqlType.getString(sqlType);
            if (result == null) {
                result = "java.lang.Object";
            }
            return result;
        }
        if (size == 1) {
            return "java.lang.Integer";
        }
        if (size < 3) {
            return "java.lang.Byte";
        }
        if (size < 5) {
            return "java.lang.Short";
        }
        if (size < 10) {
            return "java.lang.Integer";
        }
        if (size < 19) {
            return "java.lang.Long";
        }
        return "java.math.BigDecimal";
    }
    
    private static class IntStringMap extends HashMap
    {
        public String getString(final int i) {
            return StringHelper.convertType(this.get(new Integer(i)));
        }
        
        public String[] getStrings(final int i) {
            return (String[]) this.get(new Integer(i));
        }
        
        public void put(final int i, final String s) {
            this.put(new Integer(i), s);
        }
        
        public void put(final int i, final String[] sa) {
            this.put(new Integer(i), sa);
        }
    }
}
