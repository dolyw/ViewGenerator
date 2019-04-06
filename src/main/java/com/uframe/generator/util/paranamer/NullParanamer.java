package com.uframe.generator.util.paranamer;

import java.lang.reflect.*;

public class NullParanamer implements Paranamer
{
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor) {
        return new String[0];
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor, final boolean throwExceptionIfMissing) {
        if (throwExceptionIfMissing) {
            throw new ParameterNamesNotFoundException("NullParanamer implementation predictably finds no parameter names");
        }
        return new String[0];
    }
}
