package com.uframe.generator.provider.java.model;

import java.beans.*;
import com.uframe.generator.util.typemapping.*;
import java.lang.reflect.*;
import java.lang.annotation.*;

public class JavaProperty
{
    PropertyDescriptor propertyDescriptor;
    JavaClass clazz;
    
    public JavaProperty(final PropertyDescriptor pd, final JavaClass javaClass) {
        this.propertyDescriptor = pd;
        this.clazz = javaClass;
    }
    
    public String getName() {
        return this.propertyDescriptor.getName();
    }
    
    public String getJavaType() {
        return this.propertyDescriptor.getPropertyType().getName();
    }
    
    public String getPrimitiveJavaType() {
        return JavaPrimitiveTypeMapping.getPrimitiveType(this.getJavaType());
    }
    
    public JavaClass getPropertyType() {
        return new JavaClass(this.propertyDescriptor.getPropertyType());
    }
    
    public String getDisplayName() {
        return this.propertyDescriptor.getDisplayName();
    }
    
    public JavaMethod getReadMethod() {
        return new JavaMethod(this.propertyDescriptor.getReadMethod(), this.clazz);
    }
    
    public JavaMethod getWriteMethod() {
        return new JavaMethod(this.propertyDescriptor.getWriteMethod(), this.clazz);
    }
    
    public boolean isHasReadMethod() {
        return this.propertyDescriptor.getReadMethod() != null;
    }
    
    public boolean isHasWriteMethod() {
        return this.propertyDescriptor.getWriteMethod() != null;
    }
    
    public String getAsType() {
        return ActionScriptDataTypesUtils.getPreferredAsType(this.propertyDescriptor.getPropertyType().getName());
    }
    
    public boolean isPk() {
        return JPAUtils.isPk(this.propertyDescriptor.getReadMethod());
    }
    
    public JavaClass getClazz() {
        return this.clazz;
    }
    
    @Override
    public String toString() {
        return "JavaClass:" + this.clazz + " JavaProperty:" + this.getName();
    }
    
    public static class JPAUtils
    {
        private static boolean isJPAClassAvaiable;
        
        static {
            JPAUtils.isJPAClassAvaiable = false;
            try {
                Class.forName("javax.persistence.Table");
                JPAUtils.isJPAClassAvaiable = true;
            }
            catch (ClassNotFoundException ex) {}
        }
        
        public static boolean isPk(final Method readMethod) {
            return JPAUtils.isJPAClassAvaiable && readMethod != null && readMethod.isAnnotationPresent(classForName("javax.persistence.Id"));
        }
        
        private static Class classForName(final String clazz) {
            try {
                return Class.forName(clazz);
            }
            catch (ClassNotFoundException e) {
                return null;
            }
        }
    }
}
