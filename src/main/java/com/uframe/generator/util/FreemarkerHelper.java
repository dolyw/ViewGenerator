package com.uframe.generator.util;

import java.util.*;
import java.io.*;
import freemarker.template.*;

public class FreemarkerHelper
{
    public static List<String> getAvailableAutoInclude(final Configuration conf, final List<String> autoIncludes) {
        final List<String> results = new ArrayList<String>();
        for (final String autoInclude : autoIncludes) {
            try {
                final Template t = new Template("__auto_include_test__", (Reader)new StringReader("1"), conf);
                conf.setAutoIncludes((List)Arrays.asList(autoInclude));
                t.process((Object)new HashMap(), (Writer)new StringWriter());
                results.add(autoInclude);
            }
            catch (Exception ex) {}
        }
        return results;
    }
    
    public static void processTemplate(final Template template, final Map model, final File outputFile, final String encoding) throws IOException, TemplateException {
        final Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), encoding));
        template.process((Object)model, out);
        out.close();
    }
    
    public static String processTemplateString(final String templateString, final Map model, final Configuration conf) {
        final StringWriter out = new StringWriter();
        try {
            final Template template = new Template("templateString...", (Reader)new StringReader(templateString), conf);
            template.process((Object)model, (Writer)out);
            return out.toString();
        }
        catch (Exception e) {
            throw new IllegalStateException("cannot process templateString:" + templateString + " cause:" + e, e);
        }
    }
}
