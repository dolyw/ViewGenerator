package com.uframe.generator.util;

import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class DateHelper
{
    public static Date parseDate(final String value, final Class targetType, final String... formats) {
        final int length = formats.length;
        int i = 0;
        while (i < length) {
            final String format = formats[i];
            try {
                final long v = new SimpleDateFormat(format).parse(value).getTime();
                return (Date) targetType.getConstructor(Long.TYPE).newInstance(v);
            }
            catch (ParseException ex) {
                try {
                    return (Date) targetType.getConstructor(String.class).newInstance(value);
                }
                catch (Exception ex2) {
                    ++i;
                }
            }
            catch (Exception ex3) {}
        }
        throw new IllegalArgumentException("cannot parse:" + value + " for date by formats:" + Arrays.asList(formats));
    }
    
    public static boolean isDateType(final Class<?> targetType) {
        return targetType != null && (targetType == Date.class || targetType == Timestamp.class || targetType == java.sql.Date.class || targetType == Time.class);
    }
}
