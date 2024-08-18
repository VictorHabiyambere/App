package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {
    /* access modifiers changed from: private */
    public final Map<K, V> backingMap;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile transient Map.Entry<K, V> cacheEntry;

    MapIteratorCache(Map<K, V> backingMap2) {
        this.backingMap = (Map) Preconditions.checkNotNull(backingMap2);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V put(K key, V value) {
        Preconditions.checkNotNull(key);
        Preconditions.checkNotNull(value);
        clearCache();
        return this.backingMap.put(key, value);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V remove(Object key) {
        Preconditions.checkNotNull(key);
        clearCache();
        return this.backingMap.remove(key);
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        clearCache();
        this.backingMap.clear();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V get(Object key) {
        Preconditions.checkNotNull(key);
        V value = getIfCached(key);
        if (value == null) {
            return getWithoutCaching(key);
        }
        return value;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V getWithoutCaching(Object key) {
        Preconditions.checkNotNull(key);
        return this.backingMap.get(key);
    }

    /* access modifiers changed from: package-private */
    public final boolean containsKey(@CheckForNull Object key) {
        return getIfCached(key) != null || this.backingMap.containsKey(key);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> entryIterator = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return entryIterator.hasNext();
                    }

                    public K next() {
                        Map.Entry<K, V> entry = (Map.Entry) entryIterator.next();
                        Map.Entry unused = MapIteratorCache.this.cacheEntry = entry;
                        return entry.getKey();
                    }
                };
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public boolean contains(@CheckForNull Object key) {
                return MapIteratorCache.this.containsKey(key);
            }
        };
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V getIfCached(@CheckForNull Object key) {
        Map.Entry<K, V> entry = this.cacheEntry;
        if (entry == null || entry.getKey() != key) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.cacheEntry = null;
    }
}
