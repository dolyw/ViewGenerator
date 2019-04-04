package com.uframe.generator.provider.java.model;

import com.uframe.generator.util.paranamer.*;
import java.lang.reflect.*;
import com.uframe.generator.util.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class MethodParameter
{
    int paramIndex;
    String paramName;
    JavaClass paramClass;
    JavaMethod method;
    public static Paranamer paranamer;
    
    static {
        MethodParameter.paranamer = setParanamer(Thread.currentThread().getContextClassLoader());
    }
    
    public MethodParameter(final int paramIndex, final JavaMethod method, final JavaClass paramClazz) {
        this.paramIndex = -1;
        this.method = method;
        this.paramIndex = paramIndex;
        this.paramClass = paramClazz;
    }
    
    public JavaMethod getMethod() {
        return this.method;
    }
    
    public String getName() {
        if (this.paramIndex < 0) {
            return null;
        }
        final String[] parameterNames = this.lookupParameterNamesByParanamer();
        if (parameterNames != null && parameterNames.length != 0) {
            return parameterNames[this.paramIndex - 1];
        }
        if (StringHelper.isNotBlank(this.paramName)) {
            return this.paramName;
        }
        if (this.paramClass.getClazz().isPrimitive() || this.paramClass.getClazz().getName().startsWith("java.")) {
            return "param" + this.paramIndex;
        }
        return StringHelper.uncapitalize(this.paramClass.getClassName());
    }
    
    public static Paranamer setParanamer(final ClassLoader classLoader) {
        return MethodParameter.paranamer = new CachingParanamer(new AdaptiveParanamer(new Paranamer[] { new DefaultParanamer(), new BytecodeReadingParanamer(), new JavaSourceParanamer(classLoader) }));
    }
    
    private String[] lookupParameterNamesByParanamer() {
        return MethodParameter.paranamer.lookupParameterNames(this.method.method, false);
    }
    
    public int getParamIndex() {
        return this.paramIndex;
    }
    
    public String getAsType() {
        return this.paramClass.getAsType();
    }
    
    public String getClassName() {
        return this.paramClass.getClassName();
    }
    
    public String getJavaType() {
        return this.paramClass.getJavaType();
    }
    
    public String getPackageName() {
        return this.paramClass.getPackageName();
    }
    
    public String getPackagePath() {
        return this.paramClass.getPackagePath();
    }
    
    public String getParentPackageName() {
        return this.paramClass.getParentPackageName();
    }
    
    public String getParentPackagePath() {
        return this.paramClass.getParentPackagePath();
    }
    
    public boolean isArray() {
        return this.paramClass.isArray();
    }
    
    public String getCanonicalName() {
        return this.paramClass.getCanonicalName();
    }
    
    public List<JavaField> getFields() {
        return this.paramClass.getFields();
    }
    
    public JavaMethod[] getMethods() {
        return this.paramClass.getMethods();
    }
    
    public boolean isAnnotation() {
        return this.paramClass.isAnnotation();
    }
    
    public boolean isAnonymousClass() {
        return this.paramClass.isAnonymousClass();
    }
    
    public boolean isEnum() {
        return this.paramClass.isEnum();
    }
    
    public boolean isInterface() {
        return this.paramClass.isInterface();
    }
    
    public boolean isLocalClass() {
        return this.paramClass.isLocalClass();
    }
    
    public boolean isMemberClass() {
        return this.paramClass.isMemberClass();
    }
    
    public boolean isPrimitive() {
        return this.paramClass.isPrimitive();
    }
    
    public boolean isSynthetic() {
        return this.paramClass.isSynthetic();
    }
    
    public JavaProperty[] getProperties() throws Exception {
        return this.paramClass.getProperties();
    }
    
    public String getSuperclassName() {
        return this.paramClass.getSuperclassName();
    }
    
    public JavaClass getParamClass() {
        return this.paramClass;
    }
    
    public static String[] parseJavaFileForParamNames(final Method method, final File javaFile) throws IOException {
        final String content = IOHelper.readFile(javaFile);
        return new JavaSourceFileMethodParametersParser().parseJavaFileForParamNames(method, content);
    }
    
    @Override
    public String toString() {
        return "MethodParameter:" + this.getName() + "=" + this.getJavaType();
    }
    
    public static class JavaSourceFileMethodParametersParser
    {
        public String[] parseJavaFileForParamNames(final Method method, final String content) {
            final Pattern methodPattern = Pattern.compile("(?s)" + method.getName() + "\\s*\\(" + this.getParamsPattern(method) + "\\)\\s*\\{");
            final Matcher m = methodPattern.matcher(content);
            final List paramNames = new ArrayList();
            if (m.find()) {
                for (int i = 1; i <= method.getParameterTypes().length; ++i) {
                    paramNames.add(m.group(i));
                }
                return (String[]) paramNames.toArray(new String[0]);
            }
            return null;
        }
        
        private String getParamsPattern(final Method method) {
            final List paramPatterns = new ArrayList();
            for (int i = 0; i < method.getParameterTypes().length; ++i) {
                final Class type = method.getParameterTypes()[i];
                final String paramPattern = ".*" + type.getSimpleName() + ".*\\s+(\\w+).*";
                paramPatterns.add(paramPattern);
            }
            return StringHelper.join(paramPatterns, ",");
        }
    }
}
