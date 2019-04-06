package com.uframe.generator.util.paranamer;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class BytecodeReadingParanamer implements Paranamer
{
    private static final Map<String, String> primitives;
    
    static {
        primitives = new HashMap<String, String>() {
            {
                this.put("int", "I");
                this.put("boolean", "Z");
                this.put("char", "C");
                this.put("short", "B");
                this.put("float", "F");
                this.put("long", "J");
                this.put("double", "D");
            }
        };
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor) {
        return this.lookupParameterNames(methodOrConstructor, true);
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrCtor, final boolean throwExceptionIfMissing) {
        Class[] types = null;
        Class<?> declaringClass = null;
        String name = null;
        if (methodOrCtor instanceof Method) {
            final Method method = (Method)methodOrCtor;
            types = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
        }
        else {
            final Constructor<?> constructor = (Constructor<?>)methodOrCtor;
            types = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            name = "<init>";
        }
        if (types.length == 0) {
            return BytecodeReadingParanamer.EMPTY_NAMES;
        }
        final InputStream byteCodeStream = this.getClassAsStream(declaringClass);
        if (byteCodeStream == null) {
            if (throwExceptionIfMissing) {
                throw new ParameterNamesNotFoundException("Unable to get class bytes");
            }
            return Paranamer.EMPTY_NAMES;
        }
        else {
            try {
                final ClassReader reader = new ClassReader(byteCodeStream);
                final TypeCollector visitor = new TypeCollector(name, types, throwExceptionIfMissing);
                reader.accept(visitor);
                final String[] parameterNamesForMethod = visitor.getParameterNamesForMethod();
                try {
                    byteCodeStream.close();
                }
                catch (IOException ex) {}
                return parameterNamesForMethod;
            }
            catch (IOException e) {
                if (throwExceptionIfMissing) {
                    throw new ParameterNamesNotFoundException("IoException while reading class bytes", e);
                }
                return Paranamer.EMPTY_NAMES;
            }
        }
    }
    
    private InputStream getClassAsStream(final Class<?> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return this.getClassAsStream(classLoader, clazz.getName());
    }
    
    private InputStream getClassAsStream(final ClassLoader classLoader, final String className) {
        final String name = String.valueOf(className.replace('.', '/')) + ".class";
        InputStream asStream = classLoader.getResourceAsStream(name);
        if (asStream == null) {
            asStream = BytecodeReadingParanamer.class.getResourceAsStream(name);
        }
        return asStream;
    }
    
    private static class TypeCollector
    {
        private static final String COMMA = ",";
        private final String methodName;
        private final Class<?>[] parameterTypes;
        private final boolean throwExceptionIfMissing;
        private MethodCollector collector;
        
        private TypeCollector(final String methodName, final Class<?>[] parameterTypes, final boolean throwExceptionIfMissing) {
            this.methodName = methodName;
            this.parameterTypes = parameterTypes;
            this.throwExceptionIfMissing = throwExceptionIfMissing;
            this.collector = null;
        }
        
        public MethodCollector visitMethod(final int access, final String name, final String desc) {
            if (this.collector != null) {
                return null;
            }
            if (!name.equals(this.methodName)) {
                return null;
            }
            final Type[] argumentTypes = Type.getArgumentTypes(desc);
            int longOrDoubleQuantity = 0;
            Type[] array;
            for (int length = (array = argumentTypes).length, j = 0; j < length; ++j) {
                final Type t = array[j];
                if (t.getClassName().equals("long") || t.getClassName().equals("double")) {
                    ++longOrDoubleQuantity;
                }
            }
            final int paramCount = argumentTypes.length;
            if (paramCount != this.parameterTypes.length) {
                return null;
            }
            for (int i = 0; i < argumentTypes.length; ++i) {
                if (!this.correctTypeName(argumentTypes, i).equals(this.parameterTypes[i].getName())) {
                    return null;
                }
            }
            return this.collector = new MethodCollector(Modifier.isStatic(access) ? 0 : 1, argumentTypes.length + longOrDoubleQuantity);
        }
        
        private String correctTypeName(final Type[] argumentTypes, final int i) {
            String s = argumentTypes[i].getClassName();
            if (s.endsWith("[]")) {
                final String prefix = s.substring(0, s.length() - 2);
                if (BytecodeReadingParanamer.primitives.containsKey(prefix)) {
                    s = "[" + BytecodeReadingParanamer.primitives.get(prefix);
                }
                else {
                    s = "[L" + prefix + ";";
                }
            }
            return s;
        }
        
        private String[] getParameterNamesForMethod() {
            if (this.collector == null) {
                return Paranamer.EMPTY_NAMES;
            }
            if (this.collector.isDebugInfoPresent()) {
                return this.collector.getResult().split(",");
            }
            if (this.throwExceptionIfMissing) {
                throw new ParameterNamesNotFoundException("Parameter names not found for " + this.methodName);
            }
            return Paranamer.EMPTY_NAMES;
        }
    }
    
    private static class MethodCollector
    {
        private final int paramCount;
        private final int ignoreCount;
        private int currentParameter;
        private final StringBuffer result;
        private boolean debugInfoPresent;
        
        private MethodCollector(final int ignoreCount, final int paramCount) {
            this.ignoreCount = ignoreCount;
            this.paramCount = paramCount;
            this.result = new StringBuffer();
            this.currentParameter = 0;
            this.debugInfoPresent = (paramCount == 0);
        }
        
        public void visitLocalVariable(final String name, final int index) {
            if (index >= this.ignoreCount && index < this.ignoreCount + this.paramCount) {
                if (!name.equals("arg" + this.currentParameter)) {
                    this.debugInfoPresent = true;
                }
                this.result.append(',');
                this.result.append(name);
                ++this.currentParameter;
            }
        }
        
        private String getResult() {
            return (this.result.length() != 0) ? this.result.substring(1) : "";
        }
        
        private boolean isDebugInfoPresent() {
            return this.debugInfoPresent;
        }
    }
    
    private static class ClassReader
    {
        public final byte[] b;
        private final int[] items;
        private final String[] strings;
        private final int maxStringLength;
        public final int header;
        static final int FIELD = 9;
        static final int METH = 10;
        static final int IMETH = 11;
        static final int INT = 3;
        static final int FLOAT = 4;
        static final int LONG = 5;
        static final int DOUBLE = 6;
        static final int NAME_TYPE = 12;
        static final int UTF8 = 1;
        
        private ClassReader(final byte[] b) {
            this(b, 0);
        }
        
        private ClassReader(final byte[] b, final int off) {
            this.b = b;
            this.items = new int[this.readUnsignedShort(off + 8)];
            final int n = this.items.length;
            this.strings = new String[n];
            int max = 0;
            int index = off + 10;
            for (int i = 1; i < n; ++i) {
                this.items[i] = index + 1;
                int size = 0;
                switch (b[index]) {
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12: {
                        size = 5;
                        break;
                    }
                    case 5:
                    case 6: {
                        size = 9;
                        ++i;
                        break;
                    }
                    case 1: {
                        size = 3 + this.readUnsignedShort(index + 1);
                        if (size > max) {
                            max = size;
                            break;
                        }
                        break;
                    }
                    default: {
                        size = 3;
                        break;
                    }
                }
                index += size;
            }
            this.maxStringLength = max;
            this.header = index;
        }
        
        private ClassReader(final InputStream is) throws IOException {
            this(readClass(is));
        }
        
        private static byte[] readClass(final InputStream is) throws IOException {
            if (is == null) {
                throw new IOException("Class not found");
            }
            byte[] b = new byte[is.available()];
            int len = 0;
            while (true) {
                final int n = is.read(b, len, b.length - len);
                if (n == -1) {
                    if (len < b.length) {
                        final byte[] c = new byte[len];
                        System.arraycopy(b, 0, c, 0, len);
                        b = c;
                    }
                    return b;
                }
                len += n;
                if (len != b.length) {
                    continue;
                }
                final int last = is.read();
                if (last < 0) {
                    return b;
                }
                final byte[] c2 = new byte[b.length + 1000];
                System.arraycopy(b, 0, c2, 0, len);
                c2[len++] = (byte)last;
                b = c2;
            }
        }
        
        private void accept(final TypeCollector classVisitor) {
            final char[] c = new char[this.maxStringLength];
            final int anns = 0;
            final int ianns = 0;
            int u = this.header;
            int v = this.items[this.readUnsignedShort(u + 4)];
            final int len = this.readUnsignedShort(u + 6);
            final int w = 0;
            u += 8;
            for (int i = 0; i < len; ++i) {
                u += 2;
            }
            v = u;
            int i = this.readUnsignedShort(v);
            v += 2;
            while (i > 0) {
                int j = this.readUnsignedShort(v + 6);
                v += 8;
                while (j > 0) {
                    v += 6 + this.readInt(v + 2);
                    --j;
                }
                --i;
            }
            i = this.readUnsignedShort(v);
            v += 2;
            while (i > 0) {
                int j = this.readUnsignedShort(v + 6);
                v += 8;
                while (j > 0) {
                    v += 6 + this.readInt(v + 2);
                    --j;
                }
                --i;
            }
            i = this.readUnsignedShort(v);
            v += 2;
            while (i > 0) {
                v += 6 + this.readInt(v + 2);
                --i;
            }
            i = this.readUnsignedShort(u);
            u += 2;
            while (i > 0) {
                int j = this.readUnsignedShort(u + 6);
                u += 8;
                while (j > 0) {
                    u += 6 + this.readInt(u + 2);
                    --j;
                }
                --i;
            }
            i = this.readUnsignedShort(u);
            u += 2;
            while (i > 0) {
                u = this.readMethod(classVisitor, c, u);
                --i;
            }
        }
        
        private int readMethod(final TypeCollector classVisitor, final char[] c, int u) {
            final int access = this.readUnsignedShort(u);
            final String name = this.readUTF8(u + 2, c);
            final String desc = this.readUTF8(u + 4, c);
            int v = 0;
            int w = 0;
            int j = this.readUnsignedShort(u + 6);
            u += 8;
            while (j > 0) {
                final String attrName = this.readUTF8(u, c);
                final int attrSize = this.readInt(u + 2);
                u += 6;
                if (attrName.equals("Code")) {
                    v = u;
                }
                u += attrSize;
                --j;
            }
            if (w != 0) {
                for (w += 2, j = 0; j < this.readUnsignedShort(w); w += 2, ++j) {}
            }
            final MethodCollector mv = classVisitor.visitMethod(access, name, desc);
            if (mv != null && v != 0) {
                final int codeLength = this.readInt(v + 4);
                v += 8;
                final int codeStart = v;
                final int codeEnd = v += codeLength;
                j = this.readUnsignedShort(v);
                v += 2;
                while (j > 0) {
                    v += 8;
                    --j;
                }
                int varTable = 0;
                int varTypeTable = 0;
                j = this.readUnsignedShort(v);
                v += 2;
                while (j > 0) {
                    final String attrName = this.readUTF8(v, c);
                    if (attrName.equals("LocalVariableTable")) {
                        varTable = v + 6;
                    }
                    else if (attrName.equals("LocalVariableTypeTable")) {
                        varTypeTable = v + 6;
                    }
                    v += 6 + this.readInt(v + 2);
                    --j;
                }
                v = codeStart;
                if (varTable != 0) {
                    if (varTypeTable != 0) {
                        int k = this.readUnsignedShort(varTypeTable) * 3;
                        w = varTypeTable + 2;
                        for (int[] typeTable = new int[k]; k > 0; typeTable[--k] = w + 6, typeTable[--k] = this.readUnsignedShort(w + 8), typeTable[--k] = this.readUnsignedShort(w), w += 10) {}
                    }
                    int k = this.readUnsignedShort(varTable);
                    w = varTable + 2;
                    while (k > 0) {
                        final int index = this.readUnsignedShort(w + 8);
                        mv.visitLocalVariable(this.readUTF8(w + 4, c), index);
                        w += 10;
                        --k;
                    }
                }
            }
            return u;
        }
        
        private int readUnsignedShort(final int index) {
            final byte[] b = this.b;
            return (b[index] & 0xFF) << 8 | (b[index + 1] & 0xFF);
        }
        
        private int readInt(final int index) {
            final byte[] b = this.b;
            return (b[index] & 0xFF) << 24 | (b[index + 1] & 0xFF) << 16 | (b[index + 2] & 0xFF) << 8 | (b[index + 3] & 0xFF);
        }
        
        private String readUTF8(int index, final char[] buf) {
            final int item = this.readUnsignedShort(index);
            final String s = this.strings[item];
            if (s != null) {
                return s;
            }
            index = this.items[item];
            return this.strings[item] = this.readUTF(index + 2, this.readUnsignedShort(index), buf);
        }
        
        private String readUTF(int index, final int utfLen, final char[] buf) {
            final int endIndex = index + utfLen;
            final byte[] b = this.b;
            int strLen = 0;
            int st = 0;
            char cc = '\0';
            while (index < endIndex) {
                int c = b[index++];
                switch (st) {
                    case 0: {
                        c &= 0xFF;
                        if (c < 128) {
                            buf[strLen++] = (char)c;
                            continue;
                        }
                        if (c < 224 && c > 191) {
                            cc = (char)(c & 0x1F);
                            st = 1;
                            continue;
                        }
                        cc = (char)(c & 0xF);
                        st = 2;
                        continue;
                    }
                    default: {
                        continue;
                    }
                    case 1: {
                        buf[strLen++] = (char)(cc << 6 | (c & 0x3F));
                        st = 0;
                        continue;
                    }
                    case 2: {
                        cc = (char)(cc << 6 | (c & 0x3F));
                        st = 1;
                        continue;
                    }
                }
            }
            return new String(buf, 0, strLen);
        }
    }
    
    private static class Type
    {
        private static final int VOID = 0;
        private static final int BOOLEAN = 1;
        private static final int CHAR = 2;
        private static final int BYTE = 3;
        private static final int SHORT = 4;
        private static final int INT = 5;
        private static final int FLOAT = 6;
        private static final int LONG = 7;
        private static final int DOUBLE = 8;
        private static final int ARRAY = 9;
        private static final int OBJECT = 10;
        private static final Type VOID_TYPE;
        private static final Type BOOLEAN_TYPE;
        private static final Type CHAR_TYPE;
        private static final Type BYTE_TYPE;
        private static final Type SHORT_TYPE;
        private static final Type INT_TYPE;
        private static final Type FLOAT_TYPE;
        private static final Type LONG_TYPE;
        private static final Type DOUBLE_TYPE;
        private final int sort;
        private char[] buf;
        private int off;
        private final int len;
        
        static {
            VOID_TYPE = new Type(0, null, 1443168256, 1);
            BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
            CHAR_TYPE = new Type(2, null, 1124075009, 1);
            BYTE_TYPE = new Type(3, null, 1107297537, 1);
            SHORT_TYPE = new Type(4, null, 1392510721, 1);
            INT_TYPE = new Type(5, null, 1224736769, 1);
            FLOAT_TYPE = new Type(6, null, 1174536705, 1);
            LONG_TYPE = new Type(7, null, 1241579778, 1);
            DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
        }
        
        private Type(final int sort) {
            this.sort = sort;
            this.len = 1;
        }
        
        private Type(final int sort, final char[] buf, final int off, final int len) {
            this.sort = sort;
            this.buf = buf;
            this.off = off;
            this.len = len;
        }
        
        public static Type[] getArgumentTypes(final String methodDescriptor) {
            final char[] buf = methodDescriptor.toCharArray();
            int off = 1;
            int size = 0;
            while (true) {
                final char car = buf[off++];
                if (car == ')') {
                    break;
                }
                if (car == 'L') {
                    while (buf[off++] != ';') {}
                    ++size;
                }
                else {
                    if (car == '[') {
                        continue;
                    }
                    ++size;
                }
            }
            Type[] args;
            for (args = new Type[size], off = 1, size = 0; buf[off] != ')'; off += args[size].len + ((args[size].sort == 10) ? 2 : 0), ++size) {
                args[size] = getType(buf, off);
            }
            return args;
        }
        
        private static Type getType(final char[] buf, final int off) {
            switch (buf[off]) {
                case 'V': {
                    return Type.VOID_TYPE;
                }
                case 'Z': {
                    return Type.BOOLEAN_TYPE;
                }
                case 'C': {
                    return Type.CHAR_TYPE;
                }
                case 'B': {
                    return Type.BYTE_TYPE;
                }
                case 'S': {
                    return Type.SHORT_TYPE;
                }
                case 'I': {
                    return Type.INT_TYPE;
                }
                case 'F': {
                    return Type.FLOAT_TYPE;
                }
                case 'J': {
                    return Type.LONG_TYPE;
                }
                case 'D': {
                    return Type.DOUBLE_TYPE;
                }
                case '[': {
                    int len;
                    for (len = 1; buf[off + len] == '['; ++len) {}
                    if (buf[off + len] == 'L') {
                        ++len;
                        while (buf[off + len] != ';') {
                            ++len;
                        }
                    }
                    return new Type(9, buf, off, len + 1);
                }
                default: {
                    int len;
                    for (len = 1; buf[off + len] != ';'; ++len) {}
                    return new Type(10, buf, off + 1, len - 1);
                }
            }
        }
        
        private int getDimensions() {
            int i;
            for (i = 1; this.buf[this.off + i] == '['; ++i) {}
            return i;
        }
        
        private Type getElementType() {
            return getType(this.buf, this.off + this.getDimensions());
        }
        
        private String getClassName() {
            switch (this.sort) {
                case 0: {
                    return "void";
                }
                case 1: {
                    return "boolean";
                }
                case 2: {
                    return "char";
                }
                case 3: {
                    return "byte";
                }
                case 4: {
                    return "short";
                }
                case 5: {
                    return "int";
                }
                case 6: {
                    return "float";
                }
                case 7: {
                    return "long";
                }
                case 8: {
                    return "double";
                }
                case 9: {
                    final StringBuffer b = new StringBuffer(this.getElementType().getClassName());
                    for (int i = this.getDimensions(); i > 0; --i) {
                        b.append("[]");
                    }
                    return b.toString();
                }
                default: {
                    return new String(this.buf, this.off, this.len).replace('/', '.');
                }
            }
        }
    }
}
