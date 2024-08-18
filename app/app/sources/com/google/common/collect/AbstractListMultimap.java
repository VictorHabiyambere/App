package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    /* access modifiers changed from: package-private */
    public abstract List<V> createCollection();

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(@ParametricNullness K key, Collection<V> collection) {
        return wrapList(key, (List) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    public List<V> get(@ParametricNullness K key) {
        return (List) super.get(key);
    }

    public List<V> removeAll(@CheckForNull Object key) {
        return (List) super.removeAll(key);
    }

    public List<V> replaceValues(@ParametricNullness K key, Iterable<? extends V> values) {
        return (List) super.replaceValues(key, values);
    }

    public boolean put(@ParametricNullness K key, @ParametricNullness V value) {
        return super.put(key, value);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean equals(@CheckForNull Object object) {
        return super.equals(object);
    }
}
