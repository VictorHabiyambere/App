package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @CheckForNull
    private volatile transient CacheEntry<K, V> cacheEntry1;
    @CheckForNull
    private volatile transient CacheEntry<K, V> cacheEntry2;

    MapRetrievalCache(Map<K, V> backingMap) {
        super(backingMap);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V get(Object key) {
        Preconditions.checkNotNull(key);
        V value = getIfCached(key);
        if (value != null) {
            return value;
        }
        V value2 = getWithoutCaching(key);
        if (value2 != null) {
            addToCache(key, value2);
        }
        return value2;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V getIfCached(@CheckForNull Object key) {
        V value = super.getIfCached(key);
        if (value != null) {
            return value;
        }
        CacheEntry<K, V> entry = this.cacheEntry1;
        if (entry != null && entry.key == key) {
            return entry.value;
        }
        CacheEntry<K, V> entry2 = this.cacheEntry2;
        if (entry2 == null || entry2.key != key) {
            return null;
        }
        addToCache(entry2);
        return entry2.value;
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(K key, V value) {
        addToCache(new CacheEntry(key, value));
    }

    private void addToCache(CacheEntry<K, V> entry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = entry;
    }

    private static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K key2, V value2) {
            this.key = key2;
            this.value = value2;
        }
    }
}
