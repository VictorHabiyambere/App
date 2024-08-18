package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {
    /* access modifiers changed from: protected */
    public abstract NavigableMap<K, V> delegate();

    protected ForwardingNavigableMap() {
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K key) {
        return delegate().lowerEntry(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardLowerEntry(@ParametricNullness K key) {
        return headMap(key, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K key) {
        return delegate().lowerKey(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardLowerKey(@ParametricNullness K key) {
        return Maps.keyOrNull(lowerEntry(key));
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K key) {
        return delegate().floorEntry(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardFloorEntry(@ParametricNullness K key) {
        return headMap(key, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K key) {
        return delegate().floorKey(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardFloorKey(@ParametricNullness K key) {
        return Maps.keyOrNull(floorEntry(key));
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K key) {
        return delegate().ceilingEntry(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardCeilingEntry(@ParametricNullness K key) {
        return tailMap(key, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K key) {
        return delegate().ceilingKey(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardCeilingKey(@ParametricNullness K key) {
        return Maps.keyOrNull(ceilingEntry(key));
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K key) {
        return delegate().higherEntry(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardHigherEntry(@ParametricNullness K key) {
        return tailMap(key, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K key) {
        return delegate().higherKey(key);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K standardHigherKey(@ParametricNullness K key) {
        return Maps.keyOrNull(higherEntry(key));
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K standardFirstKey() {
        Map.Entry<K, V> entry = firstEntry();
        if (entry != null) {
            return entry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K standardLastKey() {
        Map.Entry<K, V> entry = lastEntry();
        if (entry != null) {
            return entry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }

        /* access modifiers changed from: protected */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() {
                @CheckForNull
                private Map.Entry<K, V> nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                @CheckForNull
                private Map.Entry<K, V> toRemove = null;

                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                public Map.Entry<K, V> next() {
                    if (this.nextOrNull != null) {
                        try {
                            return this.nextOrNull;
                        } finally {
                            this.toRemove = this.nextOrNull;
                            this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                        }
                    } else {
                        throw new NoSuchElementException();
                    }
                }

                public void remove() {
                    if (this.toRemove != null) {
                        StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                        this.toRemove = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
            };
        }
    }

    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap this$0) {
            super(this$0);
        }
    }

    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    /* access modifiers changed from: protected */
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardSubMap(@ParametricNullness K fromKey, @ParametricNullness K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    public NavigableMap<K, V> subMap(@ParametricNullness K fromKey, boolean fromInclusive, @ParametricNullness K toKey, boolean toInclusive) {
        return delegate().subMap(fromKey, fromInclusive, toKey, toInclusive);
    }

    public NavigableMap<K, V> headMap(@ParametricNullness K toKey, boolean inclusive) {
        return delegate().headMap(toKey, inclusive);
    }

    public NavigableMap<K, V> tailMap(@ParametricNullness K fromKey, boolean inclusive) {
        return delegate().tailMap(fromKey, inclusive);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardHeadMap(@ParametricNullness K toKey) {
        return headMap(toKey, false);
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> standardTailMap(@ParametricNullness K fromKey) {
        return tailMap(fromKey, true);
    }
}
