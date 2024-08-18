package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public transient ValueEntry<K, V> multimapHeaderEntry;
    transient int valueSetCapacity = 2;

    private interface ValueSetLink<K, V> {
        ValueSetLink<K, V> getPredecessorInValueSet();

        ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink);

        void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink);
    }

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean containsKey(@CheckForNull Object obj) {
        return super.containsKey(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@CheckForNull Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj) {
        return super.get(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    public /* bridge */ /* synthetic */ boolean put(@ParametricNullness Object obj, @ParametricNullness Object obj2) {
        return super.put(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Set removeAll(@CheckForNull Object obj) {
        return super.removeAll(obj);
    }

    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int expectedKeys, int expectedValuesPerKey) {
        return new LinkedHashMultimap<>(Maps.capacity(expectedKeys), Maps.capacity(expectedValuesPerKey));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> result = create(multimap.keySet().size(), 2);
        result.putAll(multimap);
        return result;
    }

    /* access modifiers changed from: private */
    public static <K, V> void succeedsInValueSet(ValueSetLink<K, V> pred, ValueSetLink<K, V> succ) {
        pred.setSuccessorInValueSet(succ);
        succ.setPredecessorInValueSet(pred);
    }

    /* access modifiers changed from: private */
    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> pred, ValueEntry<K, V> succ) {
        pred.setSuccessorInMultimap(succ);
        succ.setPredecessorInMultimap(pred);
    }

    /* access modifiers changed from: private */
    public static <K, V> void deleteFromValueSet(ValueSetLink<K, V> entry) {
        succeedsInValueSet(entry.getPredecessorInValueSet(), entry.getSuccessorInValueSet());
    }

    /* access modifiers changed from: private */
    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> entry) {
        succeedsInMultimap(entry.getPredecessorInMultimap(), entry.getSuccessorInMultimap());
    }

    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
        @CheckForNull
        ValueEntry<K, V> nextInValueBucket;
        @CheckForNull
        ValueEntry<K, V> predecessorInMultimap;
        @CheckForNull
        ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;
        @CheckForNull
        ValueEntry<K, V> successorInMultimap;
        @CheckForNull
        ValueSetLink<K, V> successorInValueSet;

        ValueEntry(@ParametricNullness K key, @ParametricNullness V value, int smearedValueHash2, @CheckForNull ValueEntry<K, V> nextInValueBucket2) {
            super(key, value);
            this.smearedValueHash = smearedValueHash2;
            this.nextInValueBucket = nextInValueBucket2;
        }

        static <K, V> ValueEntry<K, V> newHeader() {
            return new ValueEntry<>((Object) null, (Object) null, 0, (ValueEntry) null);
        }

        /* access modifiers changed from: package-private */
        public boolean matchesValue(@CheckForNull Object v, int smearedVHash) {
            return this.smearedValueHash == smearedVHash && Objects.equal(getValue(), v);
        }

        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return (ValueSetLink) java.util.Objects.requireNonNull(this.predecessorInValueSet);
        }

        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return (ValueSetLink) java.util.Objects.requireNonNull(this.successorInValueSet);
        }

        public void setPredecessorInValueSet(ValueSetLink<K, V> entry) {
            this.predecessorInValueSet = entry;
        }

        public void setSuccessorInValueSet(ValueSetLink<K, V> entry) {
            this.successorInValueSet = entry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return (ValueEntry) java.util.Objects.requireNonNull(this.predecessorInMultimap);
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return (ValueEntry) java.util.Objects.requireNonNull(this.successorInMultimap);
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> multimapSuccessor) {
            this.successorInMultimap = multimapSuccessor;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> multimapPredecessor) {
            this.predecessorInMultimap = multimapPredecessor;
        }
    }

    private LinkedHashMultimap(int keyCapacity, int valueSetCapacity2) {
        super(Platform.newLinkedHashMapWithExpectedSize(keyCapacity));
        CollectPreconditions.checkNonnegative(valueSetCapacity2, "expectedValuesPerKey");
        this.valueSetCapacity = valueSetCapacity2;
        this.multimapHeaderEntry = ValueEntry.newHeader();
        succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    /* access modifiers changed from: package-private */
    public Set<V> createCollection() {
        return Platform.newLinkedHashSetWithExpectedSize(this.valueSetCapacity);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createCollection(@ParametricNullness K key) {
        return new ValueSet(key, this.valueSetCapacity);
    }

    public Set<V> replaceValues(@ParametricNullness K key, Iterable<? extends V> values) {
        return super.replaceValues((Object) key, (Iterable) values);
    }

    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    public Set<K> keySet() {
        return super.keySet();
    }

    public Collection<V> values() {
        return super.values();
    }

    final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        /* access modifiers changed from: private */
        public ValueSetLink<K, V> firstEntry;
        ValueEntry<K, V>[] hashTable;
        @ParametricNullness
        private final K key;
        private ValueSetLink<K, V> lastEntry;
        /* access modifiers changed from: private */
        public int modCount = 0;
        private int size = 0;

        ValueSet(@ParametricNullness K key2, int expectedValues) {
            this.key = key2;
            this.firstEntry = this;
            this.lastEntry = this;
            this.hashTable = new ValueEntry[Hashing.closedTableSize(expectedValues, 1.0d)];
        }

        private int mask() {
            return this.hashTable.length - 1;
        }

        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        public void setPredecessorInValueSet(ValueSetLink<K, V> entry) {
            this.lastEntry = entry;
        }

        public void setSuccessorInValueSet(ValueSetLink<K, V> entry) {
            this.firstEntry = entry;
        }

        public Iterator<V> iterator() {
            return new Iterator<V>() {
                int expectedModCount = ValueSet.this.modCount;
                ValueSetLink<K, V> nextEntry = ValueSet.this.firstEntry;
                @CheckForNull
                ValueEntry<K, V> toRemove;

                private void checkForComodification() {
                    if (ValueSet.this.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    checkForComodification();
                    return this.nextEntry != ValueSet.this;
                }

                @ParametricNullness
                public V next() {
                    if (hasNext()) {
                        ValueEntry<K, V> entry = (ValueEntry) this.nextEntry;
                        V result = entry.getValue();
                        this.toRemove = entry;
                        this.nextEntry = entry.getSuccessorInValueSet();
                        return result;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    checkForComodification();
                    Preconditions.checkState(this.toRemove != null, "no calls to next() since the last call to remove()");
                    ValueSet.this.remove(this.toRemove.getValue());
                    this.expectedModCount = ValueSet.this.modCount;
                    this.toRemove = null;
                }
            };
        }

        public int size() {
            return this.size;
        }

        public boolean contains(@CheckForNull Object o) {
            int smearedHash = Hashing.smearedHash(o);
            for (ValueEntry<K, V> entry = this.hashTable[mask() & smearedHash]; entry != null; entry = entry.nextInValueBucket) {
                if (entry.matchesValue(o, smearedHash)) {
                    return true;
                }
            }
            return false;
        }

        public boolean add(@ParametricNullness V value) {
            int smearedHash = Hashing.smearedHash(value);
            int bucket = mask() & smearedHash;
            ValueEntry<K, V> rowHead = this.hashTable[bucket];
            for (ValueEntry<K, V> entry = rowHead; entry != null; entry = entry.nextInValueBucket) {
                if (entry.matchesValue(value, smearedHash)) {
                    return false;
                }
            }
            ValueEntry<K, V> newEntry = new ValueEntry<>(this.key, value, smearedHash, rowHead);
            LinkedHashMultimap.succeedsInValueSet(this.lastEntry, newEntry);
            LinkedHashMultimap.succeedsInValueSet(newEntry, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), newEntry);
            LinkedHashMultimap.succeedsInMultimap(newEntry, LinkedHashMultimap.this.multimapHeaderEntry);
            this.hashTable[bucket] = newEntry;
            this.size++;
            this.modCount++;
            rehashIfNecessary();
            return true;
        }

        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0d)) {
                ValueEntry<K, V>[] hashTable2 = new ValueEntry[(this.hashTable.length * 2)];
                this.hashTable = hashTable2;
                int mask = hashTable2.length - 1;
                for (ValueSetLink<K, V> entry = this.firstEntry; entry != this; entry = entry.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) entry;
                    int bucket = valueEntry.smearedValueHash & mask;
                    valueEntry.nextInValueBucket = hashTable2[bucket];
                    hashTable2[bucket] = valueEntry;
                }
            }
        }

        public boolean remove(@CheckForNull Object o) {
            int smearedHash = Hashing.smearedHash(o);
            int bucket = mask() & smearedHash;
            ValueEntry<K, V> prev = null;
            for (ValueEntry<K, V> entry = this.hashTable[bucket]; entry != null; entry = entry.nextInValueBucket) {
                if (entry.matchesValue(o, smearedHash)) {
                    if (prev == null) {
                        this.hashTable[bucket] = entry.nextInValueBucket;
                    } else {
                        prev.nextInValueBucket = entry.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(entry);
                    LinkedHashMultimap.deleteFromMultimap(entry);
                    this.size--;
                    this.modCount++;
                    return true;
                }
                prev = entry;
            }
            return false;
        }

        public void clear() {
            Arrays.fill(this.hashTable, (Object) null);
            this.size = 0;
            for (ValueSetLink<K, V> entry = this.firstEntry; entry != this; entry = entry.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) entry);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.modCount++;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new Iterator<Map.Entry<K, V>>() {
            ValueEntry<K, V> nextEntry = LinkedHashMultimap.this.multimapHeaderEntry.getSuccessorInMultimap();
            @CheckForNull
            ValueEntry<K, V> toRemove;

            public boolean hasNext() {
                return this.nextEntry != LinkedHashMultimap.this.multimapHeaderEntry;
            }

            public Map.Entry<K, V> next() {
                if (hasNext()) {
                    ValueEntry<K, V> result = this.nextEntry;
                    this.toRemove = result;
                    this.nextEntry = this.nextEntry.getSuccessorInMultimap();
                    return result;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Preconditions.checkState(this.toRemove != null, "no calls to next() since the last call to remove()");
                LinkedHashMultimap.this.remove(this.toRemove.getKey(), this.toRemove.getValue());
                this.toRemove = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valueIterator() {
        return Maps.valueIterator(entryIterator());
    }

    public void clear() {
        super.clear();
        succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(keySet().size());
        for (K key : keySet()) {
            stream.writeObject(key);
        }
        stream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.multimapHeaderEntry = ValueEntry.newHeader();
        succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
        this.valueSetCapacity = 2;
        int distinctKeys = stream.readInt();
        Map<K, Collection<V>> map = Platform.newLinkedHashMapWithExpectedSize(12);
        for (int i = 0; i < distinctKeys; i++) {
            K key = stream.readObject();
            map.put(key, createCollection(key));
        }
        int entries = stream.readInt();
        for (int i2 = 0; i2 < entries; i2++) {
            K key2 = stream.readObject();
            ((Collection) java.util.Objects.requireNonNull(map.get(key2))).add(stream.readObject());
        }
        setMap(map);
    }
}
