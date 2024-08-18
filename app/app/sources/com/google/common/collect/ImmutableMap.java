package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableMap.of or another implementation")
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<K> keySet;
    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<K, V> multimapView;
    @CheckForNull
    @LazyInit
    private transient ImmutableCollection<V> values;

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<K> createKeySet();

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<V> createValues();

    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    public static <K, V> ImmutableMap<K, V> of() {
        return RegularImmutableMap.EMPTY;
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        return RegularImmutableMap.create(1, new Object[]{k1, v1});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        return RegularImmutableMap.create(2, new Object[]{k1, v1, k2, v2});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        return RegularImmutableMap.create(3, new Object[]{k1, v1, k2, v2, k3, v3});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        return RegularImmutableMap.create(4, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        return RegularImmutableMap.create(5, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        return RegularImmutableMap.create(6, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        return RegularImmutableMap.create(7, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        return RegularImmutableMap.create(8, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        return RegularImmutableMap.create(9, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9});
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10) {
        CollectPreconditions.checkEntryNotNull(k1, v1);
        CollectPreconditions.checkEntryNotNull(k2, v2);
        CollectPreconditions.checkEntryNotNull(k3, v3);
        CollectPreconditions.checkEntryNotNull(k4, v4);
        CollectPreconditions.checkEntryNotNull(k5, v5);
        CollectPreconditions.checkEntryNotNull(k6, v6);
        CollectPreconditions.checkEntryNotNull(k7, v7);
        CollectPreconditions.checkEntryNotNull(k8, v8);
        CollectPreconditions.checkEntryNotNull(k9, v9);
        CollectPreconditions.checkEntryNotNull(k10, v10);
        return RegularImmutableMap.create(10, new Object[]{k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8, k9, v9, k10, v10});
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        return copyOf(Arrays.asList(entries));
    }

    static <K, V> Map.Entry<K, V> entryOf(K key, V value) {
        CollectPreconditions.checkEntryNotNull(key, value);
        return new AbstractMap.SimpleImmutableEntry(key, value);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int expectedSize) {
        CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
        return new Builder<>(expectedSize);
    }

    static void checkNoConflict(boolean safe, String conflictDescription, Object entry1, Object entry2) {
        if (!safe) {
            throw conflictException(conflictDescription, entry1, entry2);
        }
    }

    static IllegalArgumentException conflictException(String conflictDescription, Object entry1, Object entry2) {
        return new IllegalArgumentException("Multiple entries with same " + conflictDescription + ": " + entry1 + " and " + entry2);
    }

    @DoNotMock
    public static class Builder<K, V> {
        Object[] alternatingKeysAndValues;
        DuplicateKey duplicateKey;
        boolean entriesUsed;
        int size;
        @CheckForNull
        Comparator<? super V> valueComparator;

        public Builder() {
            this(4);
        }

        Builder(int initialCapacity) {
            this.alternatingKeysAndValues = new Object[(initialCapacity * 2)];
            this.size = 0;
            this.entriesUsed = false;
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity * 2 > this.alternatingKeysAndValues.length) {
                this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, ImmutableCollection.Builder.expandedCapacity(this.alternatingKeysAndValues.length, minCapacity * 2));
                this.entriesUsed = false;
            }
        }

        public Builder<K, V> put(K key, V value) {
            ensureCapacity(this.size + 1);
            CollectPreconditions.checkEntryNotNull(key, value);
            this.alternatingKeysAndValues[this.size * 2] = key;
            this.alternatingKeysAndValues[(this.size * 2) + 1] = value;
            this.size++;
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            return putAll(map.entrySet());
        }

        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            if (entries instanceof Collection) {
                ensureCapacity(this.size + ((Collection) entries).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                put(entry);
            }
            return this;
        }

        public Builder<K, V> orderEntriesByValue(Comparator<? super V> valueComparator2) {
            Preconditions.checkState(this.valueComparator == null, "valueComparator was already set");
            this.valueComparator = (Comparator) Preconditions.checkNotNull(valueComparator2, "valueComparator");
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V> combine(Builder<K, V> other) {
            Preconditions.checkNotNull(other);
            ensureCapacity(this.size + other.size);
            System.arraycopy(other.alternatingKeysAndValues, 0, this.alternatingKeysAndValues, this.size * 2, other.size * 2);
            this.size += other.size;
            return this;
        }

        private ImmutableMap<K, V> build(boolean throwIfDuplicateKeys) {
            Object[] localAlternatingKeysAndValues;
            if (!throwIfDuplicateKeys || this.duplicateKey == null) {
                int localSize = this.size;
                if (this.valueComparator == null) {
                    localAlternatingKeysAndValues = this.alternatingKeysAndValues;
                } else {
                    if (this.entriesUsed) {
                        this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, this.size * 2);
                    }
                    localAlternatingKeysAndValues = this.alternatingKeysAndValues;
                    if (!throwIfDuplicateKeys) {
                        localAlternatingKeysAndValues = lastEntryForEachKey(localAlternatingKeysAndValues, this.size);
                        if (localAlternatingKeysAndValues.length < this.alternatingKeysAndValues.length) {
                            localSize = localAlternatingKeysAndValues.length >>> 1;
                        }
                    }
                    sortEntries(localAlternatingKeysAndValues, localSize, this.valueComparator);
                }
                this.entriesUsed = true;
                ImmutableMap<K, V> map = RegularImmutableMap.create(localSize, localAlternatingKeysAndValues, this);
                if (!throwIfDuplicateKeys || this.duplicateKey == null) {
                    return map;
                }
                throw this.duplicateKey.exception();
            }
            throw this.duplicateKey.exception();
        }

        public ImmutableMap<K, V> build() {
            return buildOrThrow();
        }

        public ImmutableMap<K, V> buildOrThrow() {
            return build(true);
        }

        public ImmutableMap<K, V> buildKeepingLast() {
            return build(false);
        }

        static <V> void sortEntries(Object[] alternatingKeysAndValues2, int size2, Comparator<? super V> valueComparator2) {
            Map.Entry<Object, V>[] entries = new Map.Entry[size2];
            for (int i = 0; i < size2; i++) {
                entries[i] = new AbstractMap.SimpleImmutableEntry<>(Objects.requireNonNull(alternatingKeysAndValues2[i * 2]), Objects.requireNonNull(alternatingKeysAndValues2[(i * 2) + 1]));
            }
            Arrays.sort(entries, 0, size2, Ordering.from(valueComparator2).onResultOf(Maps.valueFunction()));
            for (int i2 = 0; i2 < size2; i2++) {
                alternatingKeysAndValues2[i2 * 2] = entries[i2].getKey();
                alternatingKeysAndValues2[(i2 * 2) + 1] = entries[i2].getValue();
            }
        }

        private Object[] lastEntryForEachKey(Object[] localAlternatingKeysAndValues, int size2) {
            Set<Object> seenKeys = new HashSet<>();
            BitSet dups = new BitSet();
            for (int i = size2 - 1; i >= 0; i--) {
                if (!seenKeys.add(Objects.requireNonNull(localAlternatingKeysAndValues[i * 2]))) {
                    dups.set(i);
                }
            }
            if (dups.isEmpty() != 0) {
                return localAlternatingKeysAndValues;
            }
            Object[] newAlternatingKeysAndValues = new Object[((size2 - dups.cardinality()) * 2)];
            int inI = 0;
            int outI = 0;
            while (inI < size2 * 2) {
                if (dups.get(inI >>> 1)) {
                    inI += 2;
                } else {
                    int outI2 = outI + 1;
                    int inI2 = inI + 1;
                    newAlternatingKeysAndValues[outI] = Objects.requireNonNull(localAlternatingKeysAndValues[inI]);
                    outI = outI2 + 1;
                    inI = inI2 + 1;
                    newAlternatingKeysAndValues[outI2] = Objects.requireNonNull(localAlternatingKeysAndValues[inI2]);
                }
            }
            return newAlternatingKeysAndValues;
        }

        static final class DuplicateKey {
            private final Object key;
            private final Object value1;
            private final Object value2;

            DuplicateKey(Object key2, Object value12, Object value22) {
                this.key = key2;
                this.value1 = value12;
                this.value2 = value22;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException exception() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.key + "=" + this.value1 + " and " + this.key + "=" + this.value2);
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> kvMap = (ImmutableMap) map;
            if (!kvMap.isPartialView()) {
                return kvMap;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        int initialCapacity;
        if (entries instanceof Collection) {
            initialCapacity = ((Collection) entries).size();
        } else {
            initialCapacity = 4;
        }
        Builder<K, V> builder = new Builder<>(initialCapacity);
        builder.putAll(entries);
        return builder.build();
    }

    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        /* access modifiers changed from: package-private */
        public abstract UnmodifiableIterator<Map.Entry<K, V>> entryIterator();

        IteratorBasedImmutableMap() {
        }

        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        /* access modifiers changed from: package-private */
        public ImmutableCollection<V> createValues() {
            return new ImmutableMapValues(this);
        }
    }

    ImmutableMap() {
    }

    @CheckForNull
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object o) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@CheckForNull Object key) {
        return get(key) != null;
    }

    public boolean containsValue(@CheckForNull Object value) {
        return values().contains(value);
    }

    @CheckForNull
    public final V getOrDefault(@CheckForNull Object key, @CheckForNull V defaultValue) {
        V result = get(key);
        if (result != null) {
            return result;
        }
        return defaultValue;
    }

    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> result = this.entrySet;
        if (result != null) {
            return result;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> result = this.keySet;
        if (result != null) {
            return result;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<K> keyIterator() {
        final UnmodifiableIterator<Map.Entry<K, V>> entryIterator = entrySet().iterator();
        return new UnmodifiableIterator<K>(this) {
            public boolean hasNext() {
                return entryIterator.hasNext();
            }

            public K next() {
                return ((Map.Entry) entryIterator.next()).getKey();
            }
        };
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> result = this.values;
        if (result != null) {
            return result;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> result = this.multimapView;
        if (result != null) {
            return result;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(), size(), (Comparator) null);
        this.multimapView = immutableSetMultimap;
        return immutableSetMultimap;
    }

    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        private MapViewOfValuesAsSingletonSets() {
        }

        public int size() {
            return ImmutableMap.this.size();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> createKeySet() {
            return ImmutableMap.this.keySet();
        }

        public boolean containsKey(@CheckForNull Object key) {
            return ImmutableMap.this.containsKey(key);
        }

        @CheckForNull
        public ImmutableSet<V> get(@CheckForNull Object key) {
            V outerValue = ImmutableMap.this.get(key);
            if (outerValue == null) {
                return null;
            }
            return ImmutableSet.of(outerValue);
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        public boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        /* access modifiers changed from: package-private */
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            final Iterator<Map.Entry<K, V>> backingIterator = ImmutableMap.this.entrySet().iterator();
            return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(this) {
                public boolean hasNext() {
                    return backingIterator.hasNext();
                }

                public Map.Entry<K, ImmutableSet<V>> next() {
                    final Map.Entry<K, V> backingEntry = (Map.Entry) backingIterator.next();
                    return new AbstractMapEntry<K, ImmutableSet<V>>(this) {
                        public K getKey() {
                            return backingEntry.getKey();
                        }

                        public ImmutableSet<V> getValue() {
                            return ImmutableSet.of(backingEntry.getValue());
                        }
                    };
                }
            };
        }
    }

    public boolean equals(@CheckForNull Object object) {
        return Maps.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    static class SerializedForm<K, V> implements Serializable {
        private static final boolean USE_LEGACY_SERIALIZATION = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        SerializedForm(ImmutableMap<K, V> map) {
            Object[] keys2 = new Object[map.size()];
            Object[] values2 = new Object[map.size()];
            int i = 0;
            UnmodifiableIterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<? extends Object, ? extends Object> entry = it.next();
                keys2[i] = entry.getKey();
                values2[i] = entry.getValue();
                i++;
            }
            this.keys = keys2;
            this.values = values2;
        }

        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            if (!(this.keys instanceof ImmutableSet)) {
                return legacyReadResolve();
            }
            ImmutableSet<K> keySet = (ImmutableSet) this.keys;
            Builder<K, V> builder = makeBuilder(keySet.size());
            UnmodifiableIterator<K> keyIter = keySet.iterator();
            UnmodifiableIterator<V> valueIter = ((ImmutableCollection) this.values).iterator();
            while (keyIter.hasNext()) {
                builder.put(keyIter.next(), valueIter.next());
            }
            return builder.buildOrThrow();
        }

        /* access modifiers changed from: package-private */
        public final Object legacyReadResolve() {
            K[] keys2 = (Object[]) this.keys;
            V[] values2 = (Object[]) this.values;
            Builder<K, V> builder = makeBuilder(keys2.length);
            for (int i = 0; i < keys2.length; i++) {
                builder.put(keys2[i], values2[i]);
            }
            return builder.buildOrThrow();
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V> makeBuilder(int size) {
            return new Builder<>(size);
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }
}
