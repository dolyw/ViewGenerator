package com.uframe.generator;

import com.uframe.generator.util.*;
import java.io.*;
import com.uframe.generator.util.typemapping.*;
import java.util.*;

public class GeneratorProperties
{
    static PropertyPlaceholderHelper helper;
    static final String[] PROPERTIES_FILE_NAMES;
    static PropertiesHelper props;

    static {
        GeneratorProperties.helper = new PropertyPlaceholderHelper("${", "}", ":", false);
        PROPERTIES_FILE_NAMES = new String[] { "config/generator.properties"/*, "config/generator.xml"*/ };
        GeneratorProperties.props = new PropertiesHelper(new Properties(), true);
        reload();
    }
    
    private GeneratorProperties() {
    }
    
    public static void reload() {
        try {
            GLogger.println("Start Load GeneratorPropeties from classpath:" + Arrays.toString(GeneratorProperties.PROPERTIES_FILE_NAMES));
            final Properties p = new Properties();
            final String[] loadedFiles = PropertiesHelper.loadAllPropertiesFromClassLoader(p, GeneratorProperties.PROPERTIES_FILE_NAMES);
            GLogger.println("GeneratorPropeties Load Success,files:" + Arrays.toString(loadedFiles));
            setSepicalProperties(p, loadedFiles);
            setProperties(p);
        }
        catch (IOException e) {
            throw new RuntimeException("Load " + GeneratorProperties.PROPERTIES_FILE_NAMES + " error", e);
        }
    }
    
    private static void setSepicalProperties(final Properties p, final String[] loadedFiles) {
        ((Hashtable<String, String>) (Map) p).put("databaseType", getDatabaseType(p, "databaseType"));
        if (loadedFiles != null && loadedFiles.length > 0) {
            final String basedir = p.getProperty("basedir");
            if (basedir != null && basedir.startsWith(".")) {
                p.setProperty("basedir", new File(new File(loadedFiles[0]).getParent(), basedir).getAbsolutePath());
            }
        }
    }
    
    private static String getDatabaseType(final Properties p, final String key) {
        final String databaseType = DatabaseTypeUtils.getDatabaseTypeByJdbcDriver(p.getProperty("jdbc.driver"));
        return p.getProperty(key, (databaseType == null) ? "" : databaseType);
    }
    
    private static Properties autoReplacePropertiesValue2DirValue(final Properties props) {
        final Properties autoReplaceProperties = new Properties();
        for (final Object key : ((Hashtable<Object, Object>)getProperties()).keySet()) {
            final String dir_key = String.valueOf(key.toString()) + "_dir";
            final String value = props.getProperty(key.toString());
            final String dir_value = value.toString().replace('.', '/');
            ((Hashtable<String, String>) (Map) autoReplaceProperties).put(dir_key, dir_value);
        }
        return autoReplaceProperties;
    }
    
    public static Properties getProperties() {
        return getHelper().getProperties();
    }
    
    private static PropertiesHelper getHelper() {
        return GeneratorProperties.props;
    }
    
    public static String getProperty(final String key, final String defaultValue) {
        return getHelper().getProperty(key, defaultValue);
    }
    
    public static String getProperty(final String key) {
        return getHelper().getProperty(key);
    }
    
    public static String getRequiredProperty(final String key) {
        return getHelper().getRequiredProperty(key);
    }
    
    public static int getRequiredInt(final String key) {
        return getHelper().getRequiredInt(key);
    }
    
    public static boolean getRequiredBoolean(final String key) {
        return getHelper().getRequiredBoolean(key);
    }
    
    public static String getNullIfBlank(final String key) {
        return getHelper().getNullIfBlank(key);
    }
    
    public static void setProperty(String key, String value) {
        value = resolveProperty(value, getProperties());
        key = resolveProperty(key, getProperties());
        GLogger.println("[setProperty()] " + key + "=" + value);
        getHelper().setProperty(key, value);
        final String dir_value = value.toString().replace('.', '/');
        ((Hashtable<String, String>) (Map) getHelper().getProperties()).put(String.valueOf(key) + "_dir", dir_value);
    }
    
    private static Properties resolveProperties(final Properties props) {
        final Properties result = new Properties();
        for (final Object s : ((Hashtable<Object, Object>)props).keySet()) {
            final String sourceKey = s.toString();
            final String key = resolveProperty(sourceKey, props);
            final String value = resolveProperty(props.getProperty(sourceKey), props);
            result.setProperty(key, value);
        }
        return result;
    }
    
    private static String resolveProperty(final String v, final Properties props) {
        final PropertyPlaceholderHelper.PropertyPlaceholderConfigurerResolver propertyPlaceholderConfigurerResolver = new PropertyPlaceholderHelper.PropertyPlaceholderConfigurerResolver(props);
        return GeneratorProperties.helper.replacePlaceholders(v, propertyPlaceholderConfigurerResolver);
    }
    
    public static void setProperties(final Properties inputProps) {
        GeneratorProperties.props = new PropertiesHelper(resolveProperties(inputProps), true);
        for (final Map.Entry entry : GeneratorProperties.props.entrySet()) {
            GLogger.println("[Property] " + entry.getKey() + "=" + entry.getValue());
        }
        GLogger.println("");
        GLogger.println("[Auto Replace] [.] => [/] on generator.properties, key=source_key+'_dir', For example: pkg=com.company ==> pkg_dir=com/company  \n");
        final Properties dirProperties = autoReplacePropertiesValue2DirValue(GeneratorProperties.props.getProperties());
        GeneratorProperties.props.getProperties().putAll(dirProperties);
    }
}
