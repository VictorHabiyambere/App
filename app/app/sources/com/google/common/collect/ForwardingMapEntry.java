package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    /* access modifiers changed from: protected */
    public abstract Map.Entry<K, V> delegate();

    protected ForwardingMapEntry() {
    }

    @ParametricNullness
    public K getKey() {
        return delegate().getKey();
    }

    @ParametricNullness
    public V getValue() {
        return delegate().getValue();
    }

    @ParametricNullness
    public V setValue(@ParametricNullness V value) {
        return delegate().setValue(value);
    }

    public boolean equals(@CheckForNull Object object) {
        return delegate().equals(object);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> that = (Map.Entry) object;
        if (!Objects.equal(getKey(), that.getKey()) || !Objects.equal(getValue(), that.getValue())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        K k = getKey();
        V v = getValue();
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        if (v != null) {
            i = v.hashCode();
        }
        return i ^ hashCode;
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return getKey() + "=" + getValue();
    }
}
