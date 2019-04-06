package com.uframe.generator.util.typemapping;

import java.util.*;

public class ActionScriptDataTypesUtils
{
    private static final Map<String, String> preferredAsTypeForJavaType;
    
    static {
        (preferredAsTypeForJavaType = new HashMap<String, String>()).put("Short", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Short", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("short", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Integer", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Integer", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("int", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Long", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Long", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("long", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Float", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Float", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("float", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Double", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Double", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("double", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Byte", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Byte", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("byte", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.math.BigDecimal", "Number");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("Boolean", "Boolean");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.Boolean", "Boolean");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("boolen", "Boolean");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("char", "String");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("char[]", "String");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.String", "String");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Clob", "String");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("byte[]", "flash.utils.ByteArray");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Blob", "flash.utils.ByteArray");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Array", "Array");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.lang.reflect.Array", "Array");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.Collection", "mx.collections.ArrayCollection");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.List", "mx.collections.ArrayCollection");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.ArrayList", "mx.collections.ArrayCollection");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.ArrayList", "mx.collections.ArrayCollection");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.Set", "Object");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.HashSet", "Object");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.Map", "Object");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.HashMap", "Object");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Date", "Date");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Time", "Date");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.util.Date", "Date");
        ActionScriptDataTypesUtils.preferredAsTypeForJavaType.put("java.sql.Timestamp", "Date");
    }
    
    public static String getPreferredAsType(final String javaType) {
        String result = ActionScriptDataTypesUtils.preferredAsTypeForJavaType.get(javaType);
        if (result == null) {
            result = javaType;
        }
        return result;
    }
    
    public static void main(final String[] args) {
        final String bb = getPreferredAsType(List.class.getName());
        System.out.println(bb);
    }
}
