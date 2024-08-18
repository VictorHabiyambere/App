package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    /* access modifiers changed from: private */
    public static final Object NOT_FOUND = new Object();
    @CheckForNull
    transient int[] entries;
    @CheckForNull
    private transient Set<Map.Entry<K, V>> entrySetView;
    @CheckForNull
    private transient Set<K> keySetView;
    @CheckForNull
    transient Object[] keys;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @CheckForNull
    private transient Object table;
    @CheckForNull
    transient Object[] values;
    @CheckForNull
    private transient Collection<V> valuesView;

    static /* synthetic */ int access$1210(CompactHashMap x0) {
        int i = x0.size;
        x0.size = i - 1;
        return i;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int expectedSize) {
        return new CompactHashMap<>(expectedSize);
    }

    CompactHashMap() {
        init(3);
    }

    CompactHashMap(int expectedSize) {
        init(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize) {
        Preconditions.checkArgument(expectedSize >= 0, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(expectedSize, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* access modifiers changed from: package-private */
    public boolean needsAllocArrays() {
        return this.table == null;
    }

    /* access modifiers changed from: package-private */
    public int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int expectedSize = this.metadata;
        int buckets = CompactHashing.tableSize(expectedSize);
        this.table = CompactHashing.createTable(buckets);
        setHashTableMask(buckets - 1);
        this.entries = new int[expectedSize];
        this.keys = new Object[expectedSize];
        this.values = new Object[expectedSize];
        return expectedSize;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Map<K, V> delegateOrNull() {
        if (this.table instanceof Map) {
            return (Map) this.table;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> createHashFloodingResistantDelegate(int tableSize) {
        return new LinkedHashMap(tableSize, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> newDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int i = firstEntryIndex();
        while (i >= 0) {
            newDelegate.put(key(i), value(i));
            i = getSuccessor(i);
        }
        this.table = newDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return newDelegate;
    }

    private void setHashTableMask(int mask) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(mask), 31);
    }

    /* access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* access modifiers changed from: package-private */
    public void incrementModCount() {
        this.metadata += 32;
    }

    /* access modifiers changed from: package-private */
    public void accessEntry(int index) {
    }

    @CheckForNull
    public V put(@ParametricNullness K key, @ParametricNullness V value) {
        int hashPrefix;
        K k = key;
        V v = value;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.put(k, v);
        }
        int[] entries2 = requireEntries();
        Object[] keys2 = requireKeys();
        V[] values2 = requireValues();
        int newEntryIndex = this.size;
        int newSize = newEntryIndex + 1;
        int hash = Hashing.smearedHash(key);
        int mask = hashTableMask();
        int next = hash & mask;
        int entry = CompactHashing.tableGet(requireTable(), next);
        if (entry != 0) {
            int hashPrefix2 = CompactHashing.getHashPrefix(hash, mask);
            int bucketLength = 0;
            while (true) {
                int entryIndex = entry - 1;
                int i = entry;
                int next2 = entries2[entryIndex];
                int tableIndex = next;
                if (CompactHashing.getHashPrefix(next2, mask) != hashPrefix2 || !Objects.equal(k, keys2[entryIndex])) {
                    int next3 = CompactHashing.getNext(next2, mask);
                    bucketLength++;
                    if (next3 == 0) {
                        int i2 = hashPrefix2;
                        if (bucketLength >= 9) {
                            return convertToHashFloodingResistantImplementation().put(k, v);
                        }
                        if (newSize > mask) {
                            hashPrefix = resizeTable(mask, CompactHashing.newCapacity(mask), hash, newEntryIndex);
                            int i3 = next3;
                        } else {
                            entries2[entryIndex] = CompactHashing.maskCombine(next2, newEntryIndex + 1, mask);
                            hashPrefix = mask;
                            int i4 = next3;
                        }
                    } else {
                        int mask2 = hashPrefix2;
                        entry = next3;
                        next = tableIndex;
                    }
                } else {
                    V oldValue = values2[entryIndex];
                    values2[entryIndex] = v;
                    accessEntry(entryIndex);
                    return oldValue;
                }
            }
        } else if (newSize > mask) {
            hashPrefix = resizeTable(mask, CompactHashing.newCapacity(mask), hash, newEntryIndex);
            int i5 = entry;
            int i6 = next;
        } else {
            CompactHashing.tableSet(requireTable(), next, newEntryIndex + 1);
            hashPrefix = mask;
            int i7 = entry;
            int i8 = next;
        }
        resizeMeMaybe(newSize);
        insertEntry(newEntryIndex, key, value, hash, hashPrefix);
        this.size = newSize;
        incrementModCount();
        return null;
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, @ParametricNullness K key, @ParametricNullness V value, int hash, int mask) {
        setEntry(entryIndex, CompactHashing.maskCombine(hash, 0, mask));
        setKey(entryIndex, key);
        setValue(entryIndex, value);
    }

    private void resizeMeMaybe(int newSize) {
        int newCapacity;
        int entriesSize = requireEntries().length;
        if (newSize > entriesSize && (newCapacity = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, entriesSize >>> 1) + entriesSize) | 1)) != entriesSize) {
            resizeEntries(newCapacity);
        }
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        this.entries = Arrays.copyOf(requireEntries(), newCapacity);
        this.keys = Arrays.copyOf(requireKeys(), newCapacity);
        this.values = Arrays.copyOf(requireValues(), newCapacity);
    }

    private int resizeTable(int oldMask, int newCapacity, int targetHash, int targetEntryIndex) {
        int i = oldMask;
        Object newTable = CompactHashing.createTable(newCapacity);
        int newMask = newCapacity - 1;
        if (targetEntryIndex != 0) {
            CompactHashing.tableSet(newTable, targetHash & newMask, targetEntryIndex + 1);
        }
        Object oldTable = requireTable();
        int[] entries2 = requireEntries();
        for (int oldTableIndex = 0; oldTableIndex <= i; oldTableIndex++) {
            int oldNext = CompactHashing.tableGet(oldTable, oldTableIndex);
            while (oldNext != 0) {
                int entryIndex = oldNext - 1;
                int oldEntry = entries2[entryIndex];
                int hash = CompactHashing.getHashPrefix(oldEntry, oldMask) | oldTableIndex;
                int newTableIndex = hash & newMask;
                int newNext = CompactHashing.tableGet(newTable, newTableIndex);
                CompactHashing.tableSet(newTable, newTableIndex, oldNext);
                entries2[entryIndex] = CompactHashing.maskCombine(hash, newNext, newMask);
                oldNext = CompactHashing.getNext(oldEntry, oldMask);
            }
        }
        this.table = newTable;
        setHashTableMask(newMask);
        return newMask;
    }

    /* access modifiers changed from: private */
    public int indexOf(@CheckForNull Object key) {
        if (needsAllocArrays()) {
            return -1;
        }
        int hash = Hashing.smearedHash(key);
        int mask = hashTableMask();
        int next = CompactHashing.tableGet(requireTable(), hash & mask);
        if (next == 0) {
            return -1;
        }
        int hashPrefix = CompactHashing.getHashPrefix(hash, mask);
        do {
            int entryIndex = next - 1;
            int entry = entry(entryIndex);
            if (CompactHashing.getHashPrefix(entry, mask) == hashPrefix && Objects.equal(key, key(entryIndex))) {
                return entryIndex;
            }
            next = CompactHashing.getNext(entry, mask);
        } while (next != 0);
        return -1;
    }

    public boolean containsKey(@CheckForNull Object key) {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.containsKey(key);
        }
        return indexOf(key) != -1;
    }

    @CheckForNull
    public V get(@CheckForNull Object key) {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.get(key);
        }
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        accessEntry(index);
        return value(index);
    }

    @CheckForNull
    public V remove(@CheckForNull Object key) {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.remove(key);
        }
        Object oldValue = removeHelper(key);
        if (oldValue == NOT_FOUND) {
            return null;
        }
        return oldValue;
    }

    /* access modifiers changed from: private */
    public Object removeHelper(@CheckForNull Object key) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int mask = hashTableMask();
        int index = CompactHashing.remove(key, (Object) null, mask, requireTable(), requireEntries(), requireKeys(), (Object[]) null);
        if (index == -1) {
            return NOT_FOUND;
        }
        Object oldValue = value(index);
        moveLastEntry(index, mask);
        this.size--;
        incrementModCount();
        return oldValue;
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int dstIndex, int mask) {
        int entryIndex;
        int entry;
        Object table2 = requireTable();
        int[] entries2 = requireEntries();
        Object[] keys2 = requireKeys();
        Object[] values2 = requireValues();
        int srcIndex = size() - 1;
        if (dstIndex < srcIndex) {
            Object key = keys2[srcIndex];
            keys2[dstIndex] = key;
            values2[dstIndex] = values2[srcIndex];
            keys2[srcIndex] = null;
            values2[srcIndex] = null;
            entries2[dstIndex] = entries2[srcIndex];
            entries2[srcIndex] = 0;
            int tableIndex = Hashing.smearedHash(key) & mask;
            int next = CompactHashing.tableGet(table2, tableIndex);
            int srcNext = srcIndex + 1;
            if (next == srcNext) {
                CompactHashing.tableSet(table2, tableIndex, dstIndex + 1);
                return;
            }
            do {
                entryIndex = next - 1;
                entry = entries2[entryIndex];
                next = CompactHashing.getNext(entry, mask);
            } while (next != srcNext);
            entries2[entryIndex] = CompactHashing.maskCombine(entry, dstIndex + 1, mask);
            return;
        }
        keys2[dstIndex] = null;
        values2[dstIndex] = null;
        entries2[dstIndex] = 0;
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int entryIndex) {
        if (entryIndex + 1 < this.size) {
            return entryIndex + 1;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    private abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedMetadata;
        int indexToRemove;

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract T getOutput(int i);

        private Itr() {
            this.expectedMetadata = CompactHashMap.this.metadata;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        @ParametricNullness
        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                this.indexToRemove = this.currentIndex;
                T result = getOutput(this.currentIndex);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            incrementExpectedModCount();
            CompactHashMap.this.remove(CompactHashMap.this.key(this.indexToRemove));
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }

        /* access modifiers changed from: package-private */
        public void incrementExpectedModCount() {
            this.expectedMetadata += 32;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.metadata != this.expectedMetadata) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public Set<K> keySet() {
        if (this.keySetView != null) {
            return this.keySetView;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new KeySetView();
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public boolean contains(@CheckForNull Object o) {
            return CompactHashMap.this.containsKey(o);
        }

        public boolean remove(@CheckForNull Object o) {
            Map<K, V> delegate = CompactHashMap.this.delegateOrNull();
            if (delegate != null) {
                return delegate.keySet().remove(o);
            }
            return CompactHashMap.this.removeHelper(o) != CompactHashMap.NOT_FOUND;
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> keySetIterator() {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.keySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<K>() {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public K getOutput(int entry) {
                return CompactHashMap.this.key(entry);
            }
        };
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySetView != null) {
            return this.entrySetView;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public boolean contains(@CheckForNull Object o) {
            Map<K, V> delegate = CompactHashMap.this.delegateOrNull();
            if (delegate != null) {
                return delegate.entrySet().contains(o);
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            int index = CompactHashMap.this.indexOf(entry.getKey());
            if (index == -1 || !Objects.equal(CompactHashMap.this.value(index), entry.getValue())) {
                return false;
            }
            return true;
        }

        public boolean remove(@CheckForNull Object o) {
            Map<K, V> delegate = CompactHashMap.this.delegateOrNull();
            if (delegate != null) {
                return delegate.entrySet().remove(o);
            }
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int mask = CompactHashMap.this.hashTableMask();
            int index = CompactHashing.remove(entry.getKey(), entry.getValue(), mask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (index == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(index, mask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.entrySet().iterator();
        }
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            /* access modifiers changed from: package-private */
            public Map.Entry<K, V> getOutput(int entry) {
                return new MapEntry(entry);
            }
        };
    }

    final class MapEntry extends AbstractMapEntry<K, V> {
        @ParametricNullness
        private final K key;
        private int lastKnownIndex;

        MapEntry(int index) {
            this.key = CompactHashMap.this.key(index);
            this.lastKnownIndex = index;
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            if (this.lastKnownIndex == -1 || this.lastKnownIndex >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.key(this.lastKnownIndex))) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        @ParametricNullness
        public V getValue() {
            Map<K, V> delegate = CompactHashMap.this.delegateOrNull();
            if (delegate != null) {
                return NullnessCasts.uncheckedCastNullableTToT(delegate.get(this.key));
            }
            updateLastKnownIndex();
            return this.lastKnownIndex == -1 ? NullnessCasts.unsafeNull() : CompactHashMap.this.value(this.lastKnownIndex);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V value) {
            Map<K, V> delegate = CompactHashMap.this.delegateOrNull();
            if (delegate != null) {
                return NullnessCasts.uncheckedCastNullableTToT(delegate.put(this.key, value));
            }
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                CompactHashMap.this.put(this.key, value);
                return NullnessCasts.unsafeNull();
            }
            V old = CompactHashMap.this.value(this.lastKnownIndex);
            CompactHashMap.this.setValue(this.lastKnownIndex, value);
            return old;
        }
    }

    public int size() {
        Map<K, V> delegate = delegateOrNull();
        return delegate != null ? delegate.size() : this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsValue(@CheckForNull Object value) {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.containsValue(value);
        }
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(value, value(i))) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        if (this.valuesView != null) {
            return this.valuesView;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new ValuesView();
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        public int size() {
            return CompactHashMap.this.size();
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valuesIterator() {
        Map<K, V> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.values().iterator();
        }
        return new CompactHashMap<K, V>.Itr<V>() {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public V getOutput(int entry) {
                return CompactHashMap.this.value(entry);
            }
        };
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Map<K, V> delegate = delegateOrNull();
            if (delegate != null) {
                Map<K, V> newDelegate = createHashFloodingResistantDelegate(size());
                newDelegate.putAll(delegate);
                this.table = newDelegate;
                return;
            }
            int size2 = this.size;
            if (size2 < requireEntries().length) {
                resizeEntries(size2);
            }
            int minimumTableSize = CompactHashing.tableSize(size2);
            int mask = hashTableMask();
            if (minimumTableSize < mask) {
                resizeTable(mask, minimumTableSize, 0, 0);
            }
        }
    }

    public void clear() {
        if (!needsAllocArrays()) {
            incrementModCount();
            Map<K, V> delegate = delegateOrNull();
            if (delegate != null) {
                this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                delegate.clear();
                this.table = null;
                this.size = 0;
                return;
            }
            Arrays.fill(requireKeys(), 0, this.size, (Object) null);
            Arrays.fill(requireValues(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
            this.size = 0;
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator<Map.Entry<K, V>> entryIterator = entrySetIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<K, V> e = entryIterator.next();
            stream.writeObject(e.getKey());
            stream.writeObject(e.getValue());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int elementCount = stream.readInt();
        if (elementCount >= 0) {
            init(elementCount);
            for (int i = 0; i < elementCount; i++) {
                put(stream.readObject(), stream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + elementCount);
    }

    /* access modifiers changed from: private */
    public Object requireTable() {
        return java.util.Objects.requireNonNull(this.table);
    }

    /* access modifiers changed from: private */
    public int[] requireEntries() {
        return (int[]) java.util.Objects.requireNonNull(this.entries);
    }

    /* access modifiers changed from: private */
    public Object[] requireKeys() {
        return (Object[]) java.util.Objects.requireNonNull(this.keys);
    }

    /* access modifiers changed from: private */
    public Object[] requireValues() {
        return (Object[]) java.util.Objects.requireNonNull(this.values);
    }

    /* access modifiers changed from: private */
    public K key(int i) {
        return requireKeys()[i];
    }

    /* access modifiers changed from: private */
    public V value(int i) {
        return requireValues()[i];
    }

    private int entry(int i) {
        return requireEntries()[i];
    }

    private void setKey(int i, K key) {
        requireKeys()[i] = key;
    }

    /* access modifiers changed from: private */
    public void setValue(int i, V value) {
        requireValues()[i] = value;
    }

    private void setEntry(int i, int value) {
        requireEntries()[i] = value;
    }
}
