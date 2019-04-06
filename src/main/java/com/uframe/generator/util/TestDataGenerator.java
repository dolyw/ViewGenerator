package com.uframe.generator.util;

import java.sql.*;

public class TestDataGenerator
{
    public String getDBUnitTestData(final String columnName, final String javaType, int size) {
        if (size <= 0) {
            size = 2;
        }
        final int MAX_SIZE = 3;
        if (javaType.indexOf("Boolean") >= 0) {
            return "0";
        }
        if (javaType.indexOf("Timestamp") >= 0) {
            return new Timestamp(System.currentTimeMillis()).toString();
        }
        if (javaType.indexOf("java.sql.Date") >= 0) {
            return new Date(System.currentTimeMillis()).toString();
        }
        if (javaType.indexOf("java.sql.Time") >= 0) {
            return new Time(System.currentTimeMillis()).toString();
        }
        if (javaType.indexOf("java.util.Date") >= 0) {
            return new Timestamp(System.currentTimeMillis()).toString();
        }
        if (javaType.indexOf("String") >= 0) {
            if (size > columnName.length()) {
                final int tempSize = Math.min(size - columnName.length(), MAX_SIZE);
                return String.valueOf(columnName) + StringHelper.randomNumeric(tempSize);
            }
            return StringHelper.randomNumeric(Math.min(size, MAX_SIZE));
        }
        else {
            if (isNumberType(javaType)) {
                return StringHelper.randomNumeric(Math.min(size, MAX_SIZE));
            }
            return "";
        }
    }
    
    private static boolean isNumberType(String javaType) {
        javaType = javaType.toLowerCase();
        return javaType.indexOf("byte") >= 0 || javaType.indexOf("short") >= 0 || javaType.indexOf("integer") >= 0 || javaType.indexOf("int") >= 0 || javaType.indexOf("long") >= 0 || javaType.indexOf("double") >= 0 || javaType.indexOf("bigdecimal") >= 0 || javaType.indexOf("float") >= 0;
    }
}
