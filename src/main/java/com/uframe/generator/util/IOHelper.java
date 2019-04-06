package com.uframe.generator.util;

import java.util.*;
import java.io.*;

public class IOHelper
{
    public static Writer NULL_WRITER;
    
    static {
        IOHelper.NULL_WRITER = new NullWriter();
    }
    
    public static void copy(final Reader reader, final Writer writer) throws IOException {
        final char[] buf = new char[8192];
        int n = 0;
        while ((n = reader.read(buf)) != -1) {
            writer.write(buf, 0, n);
        }
    }
    
    public static void copy(final InputStream in, final OutputStream out) throws IOException {
        final byte[] buf = new byte[8192];
        int n = 0;
        while ((n = in.read(buf)) != -1) {
            out.write(buf, 0, n);
        }
    }
    
    public static List readLines(final Reader input) throws IOException {
        final BufferedReader reader = new BufferedReader(input);
        final List list = new ArrayList();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            list.add(line);
        }
        return list;
    }
    
    public static String readFile(final File file) throws IOException {
        final Reader in = new FileReader(file);
        final StringWriter out = new StringWriter();
        copy(in, out);
        in.close();
        return out.toString();
    }
    
    public static String readFile(final File file, final String encoding) throws IOException {
        final InputStream inputStream = new FileInputStream(file);
        try {
            return toString(encoding, inputStream);
        }
        finally {
            inputStream.close();
        }
    }
    
    public static String toString(final InputStream inputStream) throws UnsupportedEncodingException, IOException {
        final Reader reader = new InputStreamReader(inputStream);
        final StringWriter writer = new StringWriter();
        copy(reader, writer);
        return writer.toString();
    }
    
    public static String toString(final String encoding, final InputStream inputStream) throws UnsupportedEncodingException, IOException {
        final Reader reader = new InputStreamReader(inputStream, encoding);
        final StringWriter writer = new StringWriter();
        copy(reader, writer);
        return writer.toString();
    }
    
    public static void saveFile(final File file, final String content) {
        saveFile(file, content, null, false);
    }
    
    public static void saveFile(final File file, final String content, final boolean append) {
        saveFile(file, content, null, append);
    }
    
    public static void saveFile(final File file, final String content, final String encoding) {
        saveFile(file, content, encoding, false);
    }
    
    public static void saveFile(final File file, final String content, final String encoding, final boolean append) {
        try {
            final FileOutputStream output = new FileOutputStream(file, append);
            final Writer writer = StringHelper.isBlank(encoding) ? new OutputStreamWriter(output) : new OutputStreamWriter(output, encoding);
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void copyAndClose(final InputStream in, final OutputStream out) throws IOException {
        try {
            copy(in, out);
        }
        finally {
            close(in, out);
        }
        close(in, out);
    }
    
    public static void close(final InputStream in, final OutputStream out) {
        try {
            if (in != null) {
                in.close();
            }
        }
        catch (Exception ex) {}
        try {
            if (out != null) {
                out.close();
            }
        }
        catch (Exception ex2) {}
    }
    
    private static class NullWriter extends Writer
    {
        @Override
        public void close() throws IOException {
        }
        
        @Override
        public void flush() throws IOException {
        }
        
        @Override
        public void write(final char[] cbuf, final int off, final int len) throws IOException {
        }
    }
}
