package com.uframe.generator.util.typemapping;

import java.util.*;
import com.uframe.generator.util.*;

public class JavaPrimitiveTypeMapping
{
    static Map<String, String> wraper2primitive;
    static Map<String, String> primitive2wraper;
    
    static {
        JavaPrimitiveTypeMapping.wraper2primitive = new HashMap<String, String>();
        JavaPrimitiveTypeMapping.primitive2wraper = new HashMap<String, String>();
        JavaPrimitiveTypeMapping.wraper2primitive.put("Byte", "byte");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Short", "short");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Integer", "int");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Long", "long");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Float", "float");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Double", "double");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Boolean", "boolean");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Integer", "int");
        JavaPrimitiveTypeMapping.wraper2primitive.put("Character", "char");
        for (final String key : JavaPrimitiveTypeMapping.wraper2primitive.keySet()) {
            JavaPrimitiveTypeMapping.primitive2wraper.put(JavaPrimitiveTypeMapping.wraper2primitive.get(key), key);
        }
    }
    
    public static String getPrimitiveTypeOrNull(final String clazz) {
        final String className = StringHelper.getJavaClassSimpleName(clazz);
        return JavaPrimitiveTypeMapping.wraper2primitive.get(className);
    }
    
    public static String getPrimitiveType(final String clazz) {
        final String className = StringHelper.getJavaClassSimpleName(clazz);
        final String result = JavaPrimitiveTypeMapping.wraper2primitive.get(className);
        return (result == null) ? clazz : result;
    }
    
    public static String getWrapperTypeOrNull(final String clazz) {
        final String result = JavaPrimitiveTypeMapping.primitive2wraper.get(clazz);
        return result;
    }
    
    public static String getWrapperType(final String clazz) {
        final String result = JavaPrimitiveTypeMapping.primitive2wraper.get(clazz);
        return (result == null) ? clazz : result;
    }
    
    public static String getDefaultValue(final String type) {
        if (StringHelper.isBlank(type)) {
            return "null";
        }
        if (type.endsWith("Money")) {
            return "0";
        }
        if (type.lastIndexOf(".") > 0) {
            return "null";
        }
        if (Character.isUpperCase(type.charAt(0))) {
            return "null";
        }
        if ("boolean".equals(type)) {
            return "false";
        }
        if (getWrapperTypeOrNull(type) != null) {
            return "0";
        }
        return "null";
    }
}
