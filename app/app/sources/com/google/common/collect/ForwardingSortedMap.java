package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {
    /* access modifiers changed from: protected */
    public abstract SortedMap<K, V> delegate();

    protected ForwardingSortedMap() {
    }

    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(@ParametricNullness K toKey) {
        return delegate().headMap(toKey);
    }

    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    public SortedMap<K, V> subMap(@ParametricNullness K fromKey, @ParametricNullness K toKey) {
        return delegate().subMap(fromKey, toKey);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K fromKey) {
        return delegate().tailMap(fromKey);
    }

    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet(ForwardingSortedMap this$0) {
            super(this$0);
        }
    }

    static int unsafeCompare(@CheckForNull Comparator<?> comparator, @CheckForNull Object o1, @CheckForNull Object o2) {
        if (comparator == null) {
            return ((Comparable) o1).compareTo(o2);
        }
        return comparator.compare(o1, o2);
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsKey(@CheckForNull Object key) {
        try {
            if (unsafeCompare(comparator(), tailMap(key).firstKey(), key) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardSubMap(K fromKey, K toKey) {
        Preconditions.checkArgument(unsafeCompare(comparator(), fromKey, toKey) <= 0, "fromKey must be <= toKey");
        return tailMap(fromKey).headMap(toKey);
    }
}
