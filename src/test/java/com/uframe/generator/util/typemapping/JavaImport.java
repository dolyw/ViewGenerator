package com.uframe.generator.util.typemapping;

import java.util.*;
import com.uframe.generator.provider.java.model.*;
import com.uframe.generator.util.*;

public class JavaImport
{
    TreeSet<String> imports;
    
    public JavaImport() {
        this.imports = new TreeSet<String>();
    }
    
    public void addImport(final String javaType) {
        if (isNeedImport(javaType)) {
            this.imports.add(javaType.replace("$", "."));
        }
    }
    
    public void addImport(final JavaImport javaImport) {
        if (javaImport != null) {
            this.imports.addAll(javaImport.getImports());
        }
    }
    
    public TreeSet<String> getImports() {
        return this.imports;
    }
    
    public static void addImportClass(final Set<JavaClass> set, final Class... clazzes) {
        if (clazzes == null) {
            return;
        }
        for (final Class c : clazzes) {
            if (c != null) {
                if (!c.getName().startsWith("java.lang.")) {
                    if (!c.isPrimitive()) {
                        if (!"void".equals(c.getName())) {
                            if (isNeedImport(c.getName())) {
                                set.add(new JavaClass(c));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static boolean isNeedImport(final String type) {
        return !StringHelper.isBlank(type) && !"void".equals(type) && !type.startsWith("java.lang.") && JavaPrimitiveTypeMapping.getPrimitiveTypeOrNull(type) == null && type.indexOf(".") >= 0 && !Character.isLowerCase(StringHelper.getJavaClassSimpleName(type).charAt(0));
    }
}
