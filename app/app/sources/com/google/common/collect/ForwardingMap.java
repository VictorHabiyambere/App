package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    /* access modifiers changed from: protected */
    public abstract Map<K, V> delegate();

    protected ForwardingMap() {
    }

    public int size() {
        return delegate().size();
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CheckForNull
    public V remove(@CheckForNull Object key) {
        return delegate().remove(key);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean containsKey(@CheckForNull Object key) {
        return delegate().containsKey(key);
    }

    public boolean containsValue(@CheckForNull Object value) {
        return delegate().containsValue(value);
    }

    @CheckForNull
    public V get(@CheckForNull Object key) {
        return delegate().get(key);
    }

    @CheckForNull
    public V put(@ParametricNullness K key, @ParametricNullness V value) {
        return delegate().put(key, value);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(@CheckForNull Object object) {
        return object == this || delegate().equals(object);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.putAllImpl(this, map);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public V standardRemove(@CheckForNull Object key) {
        Iterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<K, V> entry = entryIterator.next();
            if (Objects.equal(entry.getKey(), key)) {
                V value = entry.getValue();
                entryIterator.remove();
                return value;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    protected class StandardKeySet extends Maps.KeySet<K, V> {
        public StandardKeySet(ForwardingMap this$0) {
            super(this$0);
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsKey(@CheckForNull Object key) {
        return Maps.containsKeyImpl(this, key);
    }

    protected class StandardValues extends Maps.Values<K, V> {
        public StandardValues(ForwardingMap this$0) {
            super(this$0);
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsValue(@CheckForNull Object value) {
        return Maps.containsValueImpl(this, value);
    }

    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        protected StandardEntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> map() {
            return ForwardingMap.this;
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object object) {
        return Maps.equalsImpl(this, object);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return Maps.toStringImpl(this);
    }
}
