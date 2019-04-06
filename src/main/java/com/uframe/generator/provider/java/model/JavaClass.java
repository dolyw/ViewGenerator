package com.uframe.generator.provider.java.model;

import com.uframe.generator.util.*;
import java.lang.reflect.*;
import java.util.*;
import java.beans.*;
import com.uframe.generator.util.typemapping.*;

public class JavaClass
{
    private Class clazz;
    
    public JavaClass(final Class clazz) {
        this.clazz = clazz;
    }
    
    public String getClassName() {
        return this.getSimpleJavaType();
    }
    
    public String getPackageName() {
        return this.clazz.getPackage().getName();
    }
    
    public String getLastPackageName() {
        return StringHelper.getExtension(this.getPackageName());
    }
    
    public String getLastPackageNameFirstUpper() {
        return (this.getLastPackageName() == null) ? "" : StringHelper.capitalize(this.getLastPackageName());
    }
    
    public boolean isHasDefaultConstructor() {
        if (this.clazz.isInterface() || this.clazz.isAnnotation() || this.clazz.isEnum() || Modifier.isAbstract(this.clazz.getModifiers())) {
            return false;
        }
        Constructor[] constructors;
        for (int length = (constructors = this.clazz.getConstructors()).length, i = 0; i < length; ++i) {
            final Constructor c = constructors[i];
            if (Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0) {
                return true;
            }
        }
        return false;
    }
    
    public Set<JavaClass> getImportClasses() {
        final Set<JavaClass> set = new LinkedHashSet<JavaClass>();
        Method[] methods;
        for (int length = (methods = this.clazz.getMethods()).length, i = 0; i < length; ++i) {
            final Method m = methods[i];
            final Class[] clazzes = { m.getReturnType() };
            JavaImport.addImportClass(set, clazzes);
            JavaImport.addImportClass(set, (Class[])m.getParameterTypes());
            JavaImport.addImportClass(set, (Class[])m.getExceptionTypes());
        }
        if (this.clazz.isMemberClass()) {
            final Class[] clazzes2 = { this.clazz };
            JavaImport.addImportClass(set, clazzes2);
        }
        Field[] fields;
        for (int length2 = (fields = this.clazz.getFields()).length, j = 0; j < length2; ++j) {
            final Field f = fields[j];
            final Class[] clazzes = { f.getType() };
            JavaImport.addImportClass(set, clazzes);
        }
        Constructor[] constructors;
        for (int length3 = (constructors = this.clazz.getConstructors()).length, k = 0; k < length3; ++k) {
            final Constructor c = constructors[k];
            JavaImport.addImportClass(set, (Class[])c.getExceptionTypes());
            JavaImport.addImportClass(set, (Class[])c.getParameterTypes());
        }
        return set;
    }
    
    public Set<JavaClass> getPropertiesImportClasses() throws Exception {
        final Set<JavaClass> set = this.getImportClasses();
        JavaProperty[] properties;
        for (int length = (properties = this.getProperties()).length, i = 0; i < length; ++i) {
            final JavaProperty prop = properties[i];
            set.addAll(prop.getPropertyType().getImportClasses());
        }
        return set;
    }
    
    public String getSuperclassName() {
        return (this.clazz.getSuperclass() != null) ? this.clazz.getSuperclass().getName() : null;
    }
    
    public JavaMethod[] getMethods() {
        return this.toJavaMethods(this.clazz.getDeclaredMethods());
    }
    
    public JavaMethod[] getPublicMethods() {
        final Method[] methods = this.clazz.getDeclaredMethods();
        return this.toJavaMethods(this.filterByModifiers(methods, 1));
    }
    
    public JavaMethod[] getPublicStaticMethods() {
        final Method[] methods = this.clazz.getDeclaredMethods();
        return this.toJavaMethods(this.filterByModifiers(methods, 1, 8));
    }
    
    public JavaMethod[] getPublicNotStaticMethods() {
        final Method[] staticMethods = this.filterByModifiers(this.clazz.getDeclaredMethods(), 8);
        final Method[] publicMethods = this.filterByModifiers(this.clazz.getDeclaredMethods(), 1);
        final Method[] filtered = this.exclude(publicMethods, staticMethods).toArray(new Method[0]);
        return this.toJavaMethods(filtered);
    }
    
    public JavaProperty[] getReadProperties() throws Exception {
        final List result = new ArrayList();
        JavaProperty[] properties;
        for (int length = (properties = this.getProperties()).length, i = 0; i < length; ++i) {
            final JavaProperty p = properties[i];
            if (p.isHasReadMethod()) {
                result.add(p);
            }
        }
        return (JavaProperty[]) result.toArray(new JavaProperty[0]);
    }
    
    public JavaProperty[] getWriteProperties() throws Exception {
        final List result = new ArrayList();
        JavaProperty[] properties;
        for (int length = (properties = this.getProperties()).length, i = 0; i < length; ++i) {
            final JavaProperty p = properties[i];
            if (p.isHasWriteMethod()) {
                result.add(p);
            }
        }
        return (JavaProperty[]) result.toArray(new JavaProperty[0]);
    }
    
    public JavaProperty[] getProperties() throws Exception {
        final List<JavaProperty> result = new ArrayList<JavaProperty>();
        final BeanInfo beanInfo = Introspector.getBeanInfo(this.clazz);
        final PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        PropertyDescriptor[] array;
        for (int length = (array = pds).length, i = 0; i < length; ++i) {
            final PropertyDescriptor pd = array[i];
            if (!"class".equalsIgnoreCase(pd.getName())) {
                result.add(new JavaProperty(pd, this));
            }
        }
        return result.toArray(new JavaProperty[0]);
    }
    
    public List<JavaField> getFields() {
        final Field[] fields = this.clazz.getDeclaredFields();
        final List result = new ArrayList();
        Field[] array;
        for (int length = (array = fields).length, i = 0; i < length; ++i) {
            final Field f = array[i];
            result.add(new JavaField(f, this));
        }
        return (List<JavaField>)result;
    }
    
    public String getPackagePath() {
        return this.getPackageName().replace(".", "/");
    }
    
    public String getParentPackageName() {
        return this.getPackageName().substring(0, this.getPackageName().lastIndexOf("."));
    }
    
    public String getParentPackagePath() {
        return this.getParentPackageName().replace(".", "/");
    }
    
    public String getClassFile() {
        return this.clazz.getClassLoader().getResource(String.valueOf(this.clazz.getName().replace('.', '/')) + ".class").getFile();
    }
    
    public String getJavaSourceFile() {
        return String.valueOf(this.clazz.getName().replace('.', '/')) + ".java";
    }
    
    public String getMavenJavaTestSourceFile() {
        this.clazz.getResource("");
        final String f = this.getClassFile();
        return getMavenJavaTestSourceFile(f);
    }
    
    public static String getMavenJavaTestSourceFile(String clazzFile) {
        if (clazzFile == null) {
            return null;
        }
        clazzFile = clazzFile.replace('\\', '/');
        if (clazzFile.indexOf("target/classes") >= 0) {
            final String result = StringHelper.replace(clazzFile, "target/classes", "src/test/java");
            return StringHelper.replace(result, ".class", "Test.java");
        }
        return null;
    }
    
    public String getLoadedClasspath() {
        return this.getClassFile().substring(0, this.getClassFile().length() - (String.valueOf(this.clazz.getName()) + ".class").length());
    }
    
    public String getAsType() {
        return ActionScriptDataTypesUtils.getPreferredAsType(this.getJavaType());
    }
    
    public String getJavaType() {
        if (this.isArray()) {
            return this.clazz.getComponentType().getName().replace("$", ".");
        }
        return this.clazz.getName().replace("$", ".");
    }
    
    public String getPrimitiveJavaType() {
        return JavaPrimitiveTypeMapping.getPrimitiveType(this.getJavaType());
    }
    
    public String getSimpleJavaType() {
        if (this.isArray()) {
            return this.clazz.getComponentType().getSimpleName();
        }
        return this.clazz.getSimpleName();
    }
    
    public String getNullValue() {
        return JavaPrimitiveTypeMapping.getDefaultValue(this.getJavaType());
    }
    
    public String getCanonicalName() {
        return this.clazz.getCanonicalName();
    }
    
    public JavaField getField(final String name) throws NoSuchFieldException, SecurityException {
        return new JavaField(this.clazz.getField(name), this);
    }
    
    public JavaClass getSuperclass() {
        return new JavaClass(this.clazz.getSuperclass());
    }
    
    public boolean isAnnotation() {
        return this.clazz.isAnnotation();
    }
    
    public boolean isAnonymousClass() {
        return this.clazz.isAnonymousClass();
    }
    
    public boolean isArray() {
        return this.clazz.isArray();
    }
    
    public boolean isBooleanType() {
        return "boolean".equals(this.clazz.getName()) || "Boolean".equals(this.clazz.getSimpleName());
    }
    
    public boolean isEnum() {
        return this.clazz.isEnum();
    }
    
    public boolean isInstance(final Object obj) {
        return this.clazz.isInstance(obj);
    }
    
    public boolean isInterface() {
        return this.clazz.isInterface();
    }
    
    public boolean isLocalClass() {
        return this.clazz.isLocalClass();
    }
    
    public boolean isMemberClass() {
        return this.clazz.isMemberClass();
    }
    
    public boolean isPrimitive() {
        return this.clazz.isPrimitive();
    }
    
    public boolean isSynthetic() {
        return this.clazz.isSynthetic();
    }
    
    public Class getClazz() {
        return this.clazz;
    }
    
    private Method[] filterByModifiers(final Method[] methods, final int... filteredModifiers) {
        final List<Method> filtered = new ArrayList<Method>();
        for (int i = 0; i < methods.length; ++i) {
            for (int j = 0; j < filteredModifiers.length; ++j) {
                if ((filteredModifiers[j] & methods[i].getModifiers()) != 0x0) {
                    filtered.add(methods[i]);
                }
            }
        }
        return filtered.toArray(new Method[0]);
    }
    
    private JavaMethod[] toJavaMethods(final Method[] declaredMethods) {
        final JavaMethod[] methods = new JavaMethod[declaredMethods.length];
        for (int i = 0; i < declaredMethods.length; ++i) {
            methods[i] = new JavaMethod(declaredMethods[i], this);
        }
        return methods;
    }
    
    private <T> List<T> exclude(final T[] methods, final T[] excludeMethods) {
        final List<T> result = new ArrayList<T>();
    Label_0068:
        for (int i = 0; i < methods.length; ++i) {
            for (int j = 0; j < excludeMethods.length; ++j) {
                if (methods[i].equals(excludeMethods[j])) {
                    break Label_0068;
                }
            }
            result.add(methods[i]);
        }
        return result;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = 31 * result + ((this.clazz == null) ? 0 : this.clazz.hashCode());
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
        final JavaClass other = (JavaClass)obj;
        if (this.clazz == null) {
            if (other.clazz != null) {
                return false;
            }
        }
        else if (!this.clazz.equals(other.clazz)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "JavaClass:" + this.clazz.getName();
    }
}
