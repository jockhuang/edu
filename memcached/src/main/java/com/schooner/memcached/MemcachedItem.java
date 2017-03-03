package com.schooner.memcached;

/**
 * MemcachedItem is used to hold casUnique and related memcached value.
 * 
 */
public final class MemcachedItem {
    public long casUnique;
    public Object value;

    public long getCasUnique() {
        return casUnique;
    }

    public Object getValue() {
        return value;
    }

}
