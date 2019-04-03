package com.uframe.generator.util;

import java.beans.*;
import java.util.*;
import java.lang.reflect.*;
import java.math.*;

public class BeanHelper
{
    public static Map describe(final Object obj) {
        if (obj instanceof Map) {
            return (Map)obj;
        }
        final Map map = new HashMap();
        final PropertyDescriptor[] descriptors = getPropertyDescriptors(obj.getClass());
        for (int i = 0; i < descriptors.length; ++i) {
            final String name = descriptors[i].getName();
            final Method readMethod = descriptors[i].getReadMethod();
            if (readMethod != null) {
                try {
                    final long start = System.currentTimeMillis();
                    map.put(name, readMethod.invoke(obj, new Object[0]));
                    final long cost = start - System.currentTimeMillis();
                }
                catch (Exception e) {
                    GLogger.warn("error get property value,name:" + name + " on bean:" + obj, e);
                }
            }
        }
        return map;
    }
    
    public static PropertyDescriptor getPropertyDescriptor(final Class beanClass, final String propertyName) {
        PropertyDescriptor[] propertyDescriptors;
        for (int length = (propertyDescriptors = getPropertyDescriptors(beanClass)).length, i = 0; i < length; ++i) {
            final PropertyDescriptor pd = propertyDescriptors[i];
            if (pd.getName().equals(propertyName)) {
                return pd;
            }
        }
        return null;
    }
    
    public static PropertyDescriptor[] getPropertyDescriptors(final Class beanClass) {
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        }
        catch (IntrospectionException e) {
            return new PropertyDescriptor[0];
        }
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        if (descriptors == null) {
            descriptors = new PropertyDescriptor[0];
        }
        return descriptors;
    }
    
    public static PropertyDescriptor getPropertyDescriptors(final Class beanClass, final String name) {
        PropertyDescriptor[] propertyDescriptors;
        for (int length = (propertyDescriptors = getPropertyDescriptors(beanClass)).length, i = 0; i < length; ++i) {
            final PropertyDescriptor pd = propertyDescriptors[i];
            if (pd.getName().equals(name)) {
                return pd;
            }
        }
        return null;
    }
    
    public static void copyProperties(final Object target, final Object source) {
        copyProperties(target, source, null);
    }
    
    public static void copyProperties(final Object target, final Object source, final String[] ignoreProperties) {
        if (target instanceof Map) {
            throw new UnsupportedOperationException("target is Map unsuported");
        }
        final PropertyDescriptor[] targetPds = getPropertyDescriptors(target.getClass());
        final List ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;
        for (int i = 0; i < targetPds.length; ++i) {
            final PropertyDescriptor targetPd = targetPds[i];
            if (targetPd.getWriteMethod() != null) {
                if (ignoreProperties != null) {
                    if (ignoreList.contains(targetPd.getName())) {
                        continue;
                    }
                }
                try {
                    if (source instanceof Map) {
                        final Map map = (Map)source;
                        if (map.containsKey(targetPd.getName())) {
                            final Object value = map.get(targetPd.getName());
                            setProperty(target, targetPd, value);
                        }
                    }
                    else {
                        final PropertyDescriptor sourcePd = getPropertyDescriptors(source.getClass(), targetPd.getName());
                        if (sourcePd != null && sourcePd.getReadMethod() != null) {
                            final Object value = getProperty(source, sourcePd);
                            setProperty(target, targetPd, value);
                        }
                    }
                }
                catch (Throwable ex) {
                    throw new IllegalArgumentException("Could not copy properties on:" + targetPd.getDisplayName(), ex);
                }
            }
        }
    }
    
    private static Object getProperty(final Object source, final PropertyDescriptor sourcePd) throws IllegalAccessException, InvocationTargetException {
        final Method readMethod = sourcePd.getReadMethod();
        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
            readMethod.setAccessible(true);
        }
        final Object value = readMethod.invoke(source, new Object[0]);
        return value;
    }
    
    public static void setProperty(final Object target, final String propertyName, final Object value) {
        final PropertyDescriptor pd = getPropertyDescriptor(target.getClass(), propertyName);
        if (pd == null) {
            throw new IllegalArgumentException("not found property:" + propertyName + " on class:" + target.getClass());
        }
        setProperty(target, pd, value);
    }
    
    public static <T> T newInstance(final Class<T> clazz) {
        try {
            return clazz.newInstance();
        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }
    
    private static void setProperty(final Object target, final PropertyDescriptor targetPd, final Object value) {
        final Method writeMethod = targetPd.getWriteMethod();
        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
            writeMethod.setAccessible(true);
        }
        try {
            writeMethod.invoke(target, convert(value, writeMethod.getParameterTypes()[0]));
        }
        catch (Exception e) {
            throw new RuntimeException("error set property:" + targetPd.getName() + " on class:" + target.getClass(), e);
        }
    }
    
    private static Object convert(final Object value, final Class<?> targetType) {
        if (value == null) {
            return null;
        }
        if (targetType == String.class) {
            return value.toString();
        }
        return convert(value.toString(), targetType);
    }
    
    private static Object convert(final String value, final Class<?> targetType) {
        if (targetType == Byte.class || targetType == Byte.TYPE) {
            return new Byte(value);
        }
        if (targetType == Short.class || targetType == Short.TYPE) {
            return new Short(value);
        }
        if (targetType == Integer.class || targetType == Integer.TYPE) {
            return new Integer(value);
        }
        if (targetType == Long.class || targetType == Long.TYPE) {
            return new Long(value);
        }
        if (targetType == Float.class || targetType == Float.TYPE) {
            return new Float(value);
        }
        if (targetType == Double.class || targetType == Double.TYPE) {
            return new Double(value);
        }
        if (targetType == BigDecimal.class) {
            return new BigDecimal(value);
        }
        if (targetType == BigInteger.class) {
            return BigInteger.valueOf(Long.parseLong(value));
        }
        if (targetType == Boolean.class || targetType == Boolean.TYPE) {
            return new Boolean(value);
        }
        if (targetType == Boolean.TYPE) {
            return new Boolean(value);
        }
        if (targetType == Character.TYPE) {
            return value.charAt(0);
        }
        if (DateHelper.isDateType(targetType)) {
            return DateHelper.parseDate(value, targetType, "yyyyMMdd", "yyyy-MM-dd", "yyyyMMddHHmmSS", "yyyy-MM-dd HH:mm:ss", "HH:mm:ss");
        }
        throw new IllegalArgumentException("cannot convert value:" + value + " to targetType:" + targetType);
    }
}
