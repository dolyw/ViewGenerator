package com.uframe.generator.util;

public class ArrayHelper
{
    public static String getValue(final String[] array, final int indexOf) {
        return getValue(array, indexOf, null);
    }
    
    public static String getValue(final String[] array, final int indexOf, final String defaultValue) {
        if (array.length - 1 >= indexOf) {
            return array[indexOf];
        }
        return defaultValue;
    }
}
