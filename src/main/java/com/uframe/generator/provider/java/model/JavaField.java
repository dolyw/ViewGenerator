package com.uframe.generator.provider.java.model;

import java.lang.reflect.*;
import com.uframe.generator.util.typemapping.*;
import java.lang.annotation.*;

public class JavaField
{
    private Field field;
    private JavaClass clazz;
    
    public JavaField(final Field field, final JavaClass clazz) {
        this.field = field;
        this.clazz = clazz;
    }
    
    public String getFieldName() {
        return this.field.getName();
    }
    
    public boolean isAccessible() {
        return this.field.isAccessible();
    }
    
    public boolean isEnumConstant() {
        return this.field.isEnumConstant();
    }
    
    public String toGenericString() {
        return this.field.toGenericString();
    }
    
    public JavaClass getClazz() {
        return this.clazz;
    }
    
    public String getJavaType() {
        return this.field.getType().getName();
    }
    
    public String getAsType() {
        return ActionScriptDataTypesUtils.getPreferredAsType(this.getJavaType());
    }
    
    public Annotation[] getAnnotations() {
        return this.field.getAnnotations();
    }
    
    public boolean getIsDateTimeField() {
        return this.getJavaType().equalsIgnoreCase("java.util.Date") || this.getJavaType().equalsIgnoreCase("java.sql.Date") || this.getJavaType().equalsIgnoreCase("java.sql.Timestamp") || this.getJavaType().equalsIgnoreCase("java.sql.Time");
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.field == null) ? 0 : this.field.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final JavaField other = (JavaField)obj;
        if (this.field == null) {
            if (other.field != null) {
                return false;
            }
        }
        else if (!this.field.equals(other.field)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "JavaClass:" + this.clazz + " JavaField:" + this.getFieldName();
    }
}
