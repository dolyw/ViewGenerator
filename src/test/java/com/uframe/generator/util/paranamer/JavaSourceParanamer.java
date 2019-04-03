package com.uframe.generator.util.paranamer;

import java.lang.reflect.*;
import java.io.*;
import java.util.regex.*;
import java.util.*;
import com.uframe.generator.util.*;

public class JavaSourceParanamer implements Paranamer
{
    private ClassLoader classLoader;
    
    public JavaSourceParanamer(final ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("'classLoader' must be not null");
        }
        this.classLoader = classLoader;
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor) {
        return this.lookupParameterNames(methodOrConstructor, true);
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor, final boolean throwExceptionIfMissing) {
        try {
            final JavaSourceFileMethodParametersParser parser = new JavaSourceFileMethodParametersParser();
            String javaSource = null;
            if (methodOrConstructor instanceof Method) {
                final Method m = (Method)methodOrConstructor;
                javaSource = String.valueOf(m.getDeclaringClass().getName().replace('.', '/')) + ".java";
            }
            else {
                if (!(methodOrConstructor instanceof Constructor)) {
                    throw new IllegalArgumentException("unknow AccessibleObject" + methodOrConstructor + ",must be Method or Constructor");
                }
                final Constructor c = (Constructor)methodOrConstructor;
                javaSource = String.valueOf(c.getDeclaringClass().getName().replace('.', '/')) + ".java";
            }
            final InputStream javaSourceInputStream = this.classLoader.getResourceAsStream(javaSource);
            try {
                if (javaSourceInputStream != null) {
                    return parser.parseJavaFileForParamNames(methodOrConstructor, IOHelper.toString(javaSourceInputStream));
                }
                return Paranamer.EMPTY_NAMES;
            }
            finally {
                if (javaSourceInputStream != null) {
                    javaSourceInputStream.close();
                }
            }
        }
        catch (IOException e) {
            if (throwExceptionIfMissing) {
                throw new RuntimeException("IOException while reading javasource,method:" + methodOrConstructor, e);
            }
            return Paranamer.EMPTY_NAMES;
        }
    }
    
    public static class JavaSourceFileMethodParametersParser
    {
        public String[] parseJavaFileForParamNames(final Constructor<?> constructor, final String content) {
            return this.parseJavaFileForParamNames(content, constructor.getName(), constructor.getParameterTypes());
        }
        
        public String[] parseJavaFileForParamNames(final Method method, final String content) {
            return this.parseJavaFileForParamNames(content, method.getName(), method.getParameterTypes());
        }
        
        public String[] parseJavaFileForParamNames(final AccessibleObject methodOrConstructor, final String content) {
            if (methodOrConstructor instanceof Method) {
                return this.parseJavaFileForParamNames((Method)methodOrConstructor, content);
            }
            if (methodOrConstructor instanceof Constructor) {
                return this.parseJavaFileForParamNames((Constructor<?>)methodOrConstructor, content);
            }
            throw new IllegalArgumentException("unknow AccessibleObject" + methodOrConstructor + ",must be Method or Constructor");
        }
        
        private String[] parseJavaFileForParamNames(final String content, final String name, final Class<?>[] parameterTypes) {
            final Pattern methodPattern = Pattern.compile("(?s)" + name + "\\s*\\(" + this.getParamsPattern(parameterTypes) + "\\)\\s*\\{");
            final Matcher m = methodPattern.matcher(content);
            final List<String> paramNames = new ArrayList<String>();
            if (m.find()) {
                for (int i = 1; i <= parameterTypes.length; ++i) {
                    paramNames.add(m.group(i));
                }
                return paramNames.toArray(new String[0]);
            }
            return null;
        }
        
        private String getParamsPattern(final Class<?>[] parameterTypes) {
            final List paramPatterns = new ArrayList();
            for (int i = 0; i < parameterTypes.length; ++i) {
                final Class type = parameterTypes[i];
                final String paramPattern = ".*" + type.getSimpleName() + ".*\\s+(\\w+).*";
                paramPatterns.add(paramPattern);
            }
            return StringHelper.join(paramPatterns, ",");
        }
    }
}
