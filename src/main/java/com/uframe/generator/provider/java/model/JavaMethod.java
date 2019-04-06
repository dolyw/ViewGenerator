package com.uframe.generator.provider.java.model;

import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import com.uframe.generator.util.typemapping.*;
import com.uframe.generator.util.*;

public class JavaMethod
{
    Method method;
    private JavaClass clazz;
    
    public JavaMethod(final Method method, final JavaClass clazz) {
        if (method == null) {
            throw new IllegalArgumentException("method must be not null");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("clazz must be not null");
        }
        this.method = method;
        this.clazz = clazz;
    }
    
    public JavaClass getClazz() {
        return this.clazz;
    }
    
    public String getMethodName() {
        return this.method.getName();
    }
    
    public JavaClass getReturnType() {
        return new JavaClass(this.method.getReturnType());
    }
    
    public Annotation[] getAnnotations() {
        return this.method.getAnnotations();
    }
    
    public boolean isBridge() {
        return this.method.isBridge();
    }
    
    public List<JavaClass> getExceptionTypes() {
        final List<JavaClass> result = new ArrayList<JavaClass>();
        Class<?>[] exceptionTypes;
        for (int length = (exceptionTypes = this.method.getExceptionTypes()).length, i = 0; i < length; ++i) {
            final Class c = exceptionTypes[i];
            result.add(new JavaClass(c));
        }
        return result;
    }
    
    public boolean isSynthetic() {
        return this.method.isSynthetic();
    }
    
    public boolean isVarArgs() {
        return this.method.isVarArgs();
    }
    
    public Set<JavaClass> getImportClasses() {
        final Set<JavaClass> set = new LinkedHashSet<JavaClass>();
        JavaImport.addImportClass(set, (Class[])this.method.getParameterTypes());
        JavaImport.addImportClass(set, (Class[])this.method.getExceptionTypes());
        JavaImport.addImportClass(set, this.method.getReturnType());
        return set;
    }
    
    public List<MethodParameter> getParameters() {
        final Class[] parameters = this.method.getParameterTypes();
        final List<MethodParameter> results = new ArrayList<MethodParameter>();
        for (int i = 0; i < parameters.length; ++i) {
            results.add(new MethodParameter(i + 1, this, new JavaClass(parameters[i])));
        }
        return results;
    }
    
    public String getMethodNameUpper() {
        return StringHelper.capitalize(this.getMethodName());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.method == null) ? 0 : this.method.hashCode());
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
        final JavaMethod other = (JavaMethod)obj;
        if (this.method == null) {
            if (other.method != null) {
                return false;
            }
        }
        else if (!this.method.equals(other.method)) {
            return false;
        }
        return true;
    }
    
    public boolean isPropertyMethod() {
        return this.getMethodName().startsWith("set") || this.getMethodName().startsWith("get") || (this.getMethodName().startsWith("is") && this.getReturnType().isBooleanType());
    }
    
    @Override
    public String toString() {
        return "JavaClass:" + this.clazz + " JavaMethod:" + this.getMethodName();
    }
}
