package com.uframe.generator.util;

import java.util.*;

public class ListHashtable extends Hashtable
{
    protected List orderedKeys;
    
    public ListHashtable() {
        this.orderedKeys = new ArrayList();
    }
    
    @Override
    public synchronized void clear() {
        super.clear();
        this.orderedKeys = new ArrayList();
    }
    
    @Override
    public synchronized Object put(final Object aKey, final Object aValue) {
        if (this.orderedKeys.contains(aKey)) {
            final int pos = this.orderedKeys.indexOf(aKey);
            this.orderedKeys.remove(pos);
            this.orderedKeys.add(pos, aKey);
        }
        else if (aKey instanceof Integer) {
            final Integer key = (Integer)aKey;
            final int pos2 = this.getFirstKeyGreater(key);
            if (pos2 >= 0) {
                this.orderedKeys.add(pos2, aKey);
            }
            else {
                this.orderedKeys.add(aKey);
            }
        }
        else {
            this.orderedKeys.add(aKey);
        }
        return super.put(aKey, aValue);
    }
    
    private int getFirstKeyGreater(final int aKey) {
        int pos = 0;
        final int numKeys = this.getOrderedKeys().size();
        for (int i = 0; i < numKeys; ++i) {
            final Integer key = (Integer)this.getOrderedKey(i);
            final int keyval = key;
            if (keyval >= aKey) {
                break;
            }
            ++pos;
        }
        if (pos >= numKeys) {
            pos = -1;
        }
        return pos;
    }
    
    @Override
    public synchronized Object remove(final Object aKey) {
        if (this.orderedKeys.contains(aKey)) {
            final int pos = this.orderedKeys.indexOf(aKey);
            this.orderedKeys.remove(pos);
        }
        return super.remove(aKey);
    }
    
    public void reorderIntegerKeys() {
        final List keys = this.getOrderedKeys();
        final int numKeys = keys.size();
        if (numKeys <= 0) {
            return;
        }
        if (!(this.getOrderedKey(0) instanceof Integer)) {
            return;
        }
        final List newKeys = new ArrayList();
        final List newValues = new ArrayList();
        for (int i = 0; i < numKeys; ++i) {
            final Integer key = (Integer)this.getOrderedKey(i);
            final Object val = this.getOrderedValue(i);
            final int numNew = newKeys.size();
            int pos = 0;
            for (int j = 0; j < numNew; ++j) {
                final Integer newKey = (Integer) newKeys.get(j);
                if (newKey >= key) {
                    break;
                }
                ++pos;
            }
            if (pos >= numKeys) {
                newKeys.add(key);
                newValues.add(val);
            }
            else {
                newKeys.add(pos, key);
                newValues.add(pos, val);
            }
        }
        this.clear();
        for (int l = 0; l < numKeys; ++l) {
            this.put(newKeys.get(l), newValues.get(l));
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer x = new StringBuffer();
        x.append("Ordered Keys: ");
        final int numKeys = this.orderedKeys.size();
        x.append("[");
        for (int i = 0; i < numKeys; ++i) {
            x.append(this.orderedKeys.get(i) + " ");
        }
        x.append("]\n");
        x.append("Ordered Values: ");
        x.append("[");
        for (int j = 0; j < numKeys; ++j) {
            x.append(this.getOrderedValue(j) + " ");
        }
        x.append("]\n");
        return x.toString();
    }
    
    public void merge(final ListHashtable newTable) {
        for (int num = newTable.size(), i = 0; i < num; ++i) {
            final Object aKey = newTable.getOrderedKey(i);
            final Object aVal = newTable.getOrderedValue(i);
            this.put(aKey, aVal);
        }
    }
    
    public List getOrderedKeys() {
        return this.orderedKeys;
    }
    
    public Object getOrderedKey(final int i) {
        return this.getOrderedKeys().get(i);
    }
    
    public Object getKeyForValue(final Object aValue) {
        for (int num = this.getOrderedValues().size(), i = 0; i < num; ++i) {
            final Object tmpVal = this.getOrderedValue(i);
            if (tmpVal.equals(aValue)) {
                return this.getOrderedKey(i);
            }
        }
        return null;
    }
    
    public List getOrderedValues() {
        final List values = new ArrayList();
        for (int numKeys = this.orderedKeys.size(), i = 0; i < numKeys; ++i) {
            values.add(this.get(this.getOrderedKey(i)));
        }
        return values;
    }
    
    public Object getOrderedValue(final int i) {
        return this.get(this.getOrderedKey(i));
    }
}
