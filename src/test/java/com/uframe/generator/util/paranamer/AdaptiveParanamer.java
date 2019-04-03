package com.uframe.generator.util.paranamer;

import java.lang.reflect.*;

public class AdaptiveParanamer implements Paranamer
{
    public static final String __PARANAMER_DATA = "v1.0 \ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer delegate,fallback\ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer,com.thoughtworks.paranamer.Paranamer delegate,fallback,reserve\ncom.thoughtworks.paranamer.AdaptiveParanamer AdaptiveParanamer com.thoughtworks.paranamer.Paranamer[] paranamers\ncom.thoughtworks.paranamer.AdaptiveParanamer lookupParameterNames java.lang.AccessibleObject methodOrConstructor \ncom.thoughtworks.paranamer.AdaptiveParanamer lookupParameterNames java.lang.AccessibleObject,boolean methodOrCtor,throwExceptionIfMissing \n";
    private final Paranamer[] paranamers;
    
    public AdaptiveParanamer() {
        this(new Paranamer[] { new DefaultParanamer(), new BytecodeReadingParanamer() });
    }
    
    public AdaptiveParanamer(final Paranamer... paranamers) {
        this.paranamers = paranamers;
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrConstructor) {
        return this.lookupParameterNames(methodOrConstructor, true);
    }
    
    @Override
    public String[] lookupParameterNames(final AccessibleObject methodOrCtor, final boolean throwExceptionIfMissing) {
        for (int i = 0; i < this.paranamers.length; ++i) {
            final Paranamer paranamer = this.paranamers[i];
            final String[] names = paranamer.lookupParameterNames(methodOrCtor, i + 1 >= this.paranamers.length && throwExceptionIfMissing);
            if (names != Paranamer.EMPTY_NAMES) {
                return names;
            }
        }
        return Paranamer.EMPTY_NAMES;
    }
}
