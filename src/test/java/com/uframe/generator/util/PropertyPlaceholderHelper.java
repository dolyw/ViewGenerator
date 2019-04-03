package com.uframe.generator.util;

import java.util.*;

public class PropertyPlaceholderHelper
{
    private final String placeholderPrefix;
    private final String placeholderSuffix;
    private final String valueSeparator;
    private final boolean ignoreUnresolvablePlaceholders;
    
    public PropertyPlaceholderHelper(final String placeholderPrefix, final String placeholderSuffix) {
        this(placeholderPrefix, placeholderSuffix, null, true);
    }
    
    public PropertyPlaceholderHelper(final String placeholderPrefix, final String placeholderSuffix, final String valueSeparator, final boolean ignoreUnresolvablePlaceholders) {
        if (placeholderPrefix == null) {
            throw new IllegalArgumentException("placeholderPrefix must not be null");
        }
        if (placeholderSuffix == null) {
            throw new IllegalArgumentException("placeholderSuffix must not be null");
        }
        this.placeholderPrefix = placeholderPrefix;
        this.placeholderSuffix = placeholderSuffix;
        this.valueSeparator = valueSeparator;
        this.ignoreUnresolvablePlaceholders = ignoreUnresolvablePlaceholders;
    }
    
    public String replacePlaceholders(final String value, final Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Argument 'properties' must not be null.");
        }
        return this.replacePlaceholders(value, new PlaceholderResolver() {
            @Override
            public String resolvePlaceholder(final String placeholderName) {
                return properties.getProperty(placeholderName);
            }
        });
    }
    
    public String replacePlaceholders(final String value, final PlaceholderResolver placeholderResolver) {
        if (value == null) {
            throw new IllegalArgumentException("Argument 'value' must not be null.");
        }
        return this.parseStringValue(value, placeholderResolver, new HashSet<String>());
    }
    
    protected String parseStringValue(final String strVal, final PlaceholderResolver placeholderResolver, final Set<String> visitedPlaceholders) {
        final StringBuilder buf = new StringBuilder(strVal);
        int startIndex = strVal.indexOf(this.placeholderPrefix);
        while (startIndex != -1) {
            final int endIndex = this.findPlaceholderEndIndex(buf, startIndex);
            if (endIndex != -1) {
                String placeholder = buf.substring(startIndex + this.placeholderPrefix.length(), endIndex);
                if (!visitedPlaceholders.add(placeholder)) {
                    throw new IllegalArgumentException("Circular placeholder reference '" + placeholder + "' in property definitions");
                }
                placeholder = this.parseStringValue(placeholder, placeholderResolver, visitedPlaceholders);
                String propVal = placeholderResolver.resolvePlaceholder(placeholder);
                if (propVal == null && this.valueSeparator != null) {
                    final int separatorIndex = placeholder.indexOf(this.valueSeparator);
                    if (separatorIndex != -1) {
                        final String actualPlaceholder = placeholder.substring(0, separatorIndex);
                        final String defaultValue = placeholder.substring(separatorIndex + this.valueSeparator.length());
                        propVal = placeholderResolver.resolvePlaceholder(actualPlaceholder);
                        if (propVal == null) {
                            propVal = defaultValue;
                        }
                    }
                }
                if (propVal != null) {
                    propVal = this.parseStringValue(propVal, placeholderResolver, visitedPlaceholders);
                    buf.replace(startIndex, endIndex + this.placeholderSuffix.length(), propVal);
                    GLogger.trace("Resolved placeholder '" + placeholder + "'");
                    startIndex = buf.indexOf(this.placeholderPrefix, startIndex + propVal.length());
                }
                else {
                    if (!this.ignoreUnresolvablePlaceholders) {
                        throw new IllegalArgumentException("Could not resolve placeholder '" + placeholder + "'");
                    }
                    startIndex = buf.indexOf(this.placeholderPrefix, endIndex + this.placeholderSuffix.length());
                }
                visitedPlaceholders.remove(placeholder);
            }
            else {
                startIndex = -1;
            }
        }
        return buf.toString();
    }
    
    private int findPlaceholderEndIndex(final CharSequence buf, final int startIndex) {
        int index = startIndex + this.placeholderPrefix.length();
        int withinNestedPlaceholder = 0;
        while (index < buf.length()) {
            if (StringHelper.substringMatch(buf, index, this.placeholderSuffix)) {
                if (withinNestedPlaceholder <= 0) {
                    return index;
                }
                --withinNestedPlaceholder;
                index = index + this.placeholderPrefix.length() - 1;
            }
            else if (StringHelper.substringMatch(buf, index, this.placeholderPrefix)) {
                ++withinNestedPlaceholder;
                index += this.placeholderPrefix.length();
            }
            else {
                ++index;
            }
        }
        return -1;
    }
    
    public static class PropertyPlaceholderConfigurerResolver implements PlaceholderResolver
    {
        private final Properties props;
        
        public PropertyPlaceholderConfigurerResolver(final Properties props) {
            this.props = props;
        }
        
        @Override
        public String resolvePlaceholder(final String placeholderName) {
            String value = this.props.getProperty(placeholderName);
            if (value == null) {
                value = System.getProperty(placeholderName);
                if (value == null && placeholderName.startsWith("env.")) {
                    value = System.getenv(placeholderName.substring("env.".length()));
                }
            }
            return value;
        }
    }
    
    public interface PlaceholderResolver
    {
        String resolvePlaceholder(final String p0);
    }
}
