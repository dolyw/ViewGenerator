package com.uframe.generator.provider.db.table.model.util;

import com.uframe.generator.provider.db.table.model.*;
import com.uframe.generator.util.typemapping.*;

public class ColumnHelper
{
    public static String[] removeHibernateValidatorSpecialTags(final String str) {
        if (str == null || str.trim().length() == 0) {
            return new String[0];
        }
        return str.trim().replaceAll("@", "").replaceAll("\\(.*?\\)", "").trim().split("\\s+");
    }
    
    public static String getHibernateValidatorExpression(final Column c) {
        if (c.isPk() || c.isNullable()) {
            return getNotRequiredHibernateValidatorExpression(c);
        }
        if (DatabaseDataTypesUtils.isString(c.getJavaType())) {
            return "@NotBlank " + getNotRequiredHibernateValidatorExpression(c);
        }
        return "@NotNull " + getNotRequiredHibernateValidatorExpression(c);
    }
    
    public static String getNotRequiredHibernateValidatorExpression(final Column c) {
        String result = "";
        if (c.getSqlName().indexOf("mail") >= 0) {
            result = String.valueOf(result) + "@Email ";
        }
        if (DatabaseDataTypesUtils.isString(c.getJavaType())) {
            result = String.valueOf(result) + String.format("@Length(max=%s)", c.getSize());
        }
        if (DatabaseDataTypesUtils.isIntegerNumber(c.getJavaType())) {
            final String javaType = DatabaseDataTypesUtils.getPreferredJavaType(c.getSqlType(), c.getSize(), c.getDecimalDigits());
            if (javaType.toLowerCase().indexOf("short") >= 0) {
                result = String.valueOf(result) + " @Max(32767)";
            }
            else if (javaType.toLowerCase().indexOf("byte") >= 0) {
                result = String.valueOf(result) + " @Max(127)";
            }
        }
        return result.trim();
    }
    
    public static String getRapidValidation(final Column c) {
        String result = "";
        if (c.getSqlName().indexOf("mail") >= 0) {
            result = String.valueOf(result) + "validate-email ";
        }
        if (DatabaseDataTypesUtils.isFloatNumber(c.getJavaType())) {
            result = String.valueOf(result) + "validate-number ";
        }
        if (DatabaseDataTypesUtils.isIntegerNumber(c.getJavaType())) {
            result = String.valueOf(result) + "validate-integer ";
            if (c.getJavaType().toLowerCase().indexOf("short") >= 0) {
                result = String.valueOf(result) + "max-value-32767";
            }
            else if (c.getJavaType().toLowerCase().indexOf("integer") >= 0) {
                result = String.valueOf(result) + "max-value-2147483647";
            }
            else if (c.getJavaType().toLowerCase().indexOf("byte") >= 0) {
                result = String.valueOf(result) + "max-value-127";
            }
        }
        return result;
    }
}
