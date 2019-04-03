package com.uframe.generator.util;

import com.uframe.generator.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class PropertiesHelper
{
    boolean isSearchSystemProperty;
    Properties p;
    
    public PropertiesHelper(final Properties p) {
        this.isSearchSystemProperty = false;
        this.p = p;
    }
    
    public PropertiesHelper(final Properties p, final boolean isSearchSystemProperty) {
        this.isSearchSystemProperty = false;
        this.p = p;
        this.isSearchSystemProperty = isSearchSystemProperty;
    }
    
    public Properties getProperties() {
        return this.p;
    }
    
    public String getProperty(final String key, final String defaultValue) {
        String value = null;
        if (this.isSearchSystemProperty) {
            value = System.getProperty(key);
        }
        if (value == null || "".equals(value.trim())) {
            value = this.getProperties().getProperty(key);
        }
        return (value == null || "".equals(value.trim())) ? defaultValue : value;
    }
    
    public String getProperty(final String key) {
        return this.getProperty(key, null);
    }
    
    public String getRequiredProperty(final String key) {
        final String value = this.getProperty(key);
        if (value == null || "".equals(value.trim())) {
            throw new IllegalStateException("required property is blank by key=" + key);
        }
        return value;
    }
    
    public Integer getInt(final String key) {
        if (this.getProperty(key) == null) {
            return null;
        }
        return Integer.parseInt(this.getRequiredProperty(key));
    }
    
    public int getInt(final String key, final int defaultValue) {
        if (this.getProperty(key) == null) {
            return defaultValue;
        }
        return Integer.parseInt(this.getRequiredProperty(key));
    }
    
    public int getRequiredInt(final String key) {
        return Integer.parseInt(this.getRequiredProperty(key));
    }
    
    public Boolean getBoolean(final String key) {
        if (this.getProperty(key) == null) {
            return null;
        }
        return Boolean.parseBoolean(this.getRequiredProperty(key));
    }
    
    public boolean getBoolean(final String key, final boolean defaultValue) {
        if (this.getProperty(key) == null) {
            return defaultValue;
        }
        return Boolean.parseBoolean(this.getRequiredProperty(key));
    }
    
    public boolean getRequiredBoolean(final String key) {
        return Boolean.parseBoolean(this.getRequiredProperty(key));
    }
    
    public String getNullIfBlank(final String key) {
        final String value = this.getProperty(key);
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        return value;
    }
    
    public PropertiesHelper setProperty(final String key, final String value) {
        this.p.setProperty(key, value);
        return this;
    }
    
    public void clear() {
        this.p.clear();
    }
    
    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.p.entrySet();
    }
    
    public Enumeration<?> propertyNames() {
        return this.p.propertyNames();
    }
    
    public static String[] loadAllPropertiesFromClassLoader(final Properties properties, final String... resourceNames) throws IOException {
        final List successLoadProperties = new ArrayList();
        for (final String resourceName : resourceNames) {
            final Enumeration urls = GeneratorProperties.class.getClassLoader().getResources(resourceName);
            while (urls.hasMoreElements()) {
                final URL url = (URL) urls.nextElement();
                successLoadProperties.add(url.getFile());
                InputStream input = null;
                try {
                    final URLConnection con = url.openConnection();
                    con.setUseCaches(false);
                    input = con.getInputStream();
                    if (resourceName.endsWith(".xml")) {
                        properties.loadFromXML(input);
                    }
                    else {
                        properties.load(input);
                    }
                }
                finally {
                    if (input != null) {
                        input.close();
                    }
                }
                if (input != null) {
                    input.close();
                }
            }
        }
        return (String[]) successLoadProperties.toArray(new String[0]);
    }
}
