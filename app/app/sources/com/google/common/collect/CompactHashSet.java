package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    @CheckForNull
    transient Object[] elements;
    @CheckForNull
    private transient int[] entries;
    /* access modifiers changed from: private */
    public transient int metadata;
    private transient int size;
    @CheckForNull
    private transient Object table;

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> set = createWithExpectedSize(collection.size());
        set.addAll(collection);
        return set;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... elements2) {
        CompactHashSet<E> set = createWithExpectedSize(elements2.length);
        Collections.addAll(set, elements2);
        return set;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int expectedSize) {
        return new CompactHashSet<>(expectedSize);
    }

    CompactHashSet() {
        init(3);
    }

    CompactHashSet(int expectedSize) {
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
        this.elements = new Object[expectedSize];
        return expectedSize;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public Set<E> delegateOrNull() {
        if (this.table instanceof Set) {
            return (Set) this.table;
        }
        return null;
    }

    private Set<E> createHashFloodingResistantDelegate(int tableSize) {
        return new LinkedHashSet(tableSize, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> newDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int i = firstEntryIndex();
        while (i >= 0) {
            newDelegate.add(element(i));
            i = getSuccessor(i);
        }
        this.table = newDelegate;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return newDelegate;
    }

    /* access modifiers changed from: package-private */
    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    private void setHashTableMask(int mask) {
        this.metadata = CompactHashing.maskCombine(this.metadata, 32 - Integer.numberOfLeadingZeros(mask), 31);
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* access modifiers changed from: package-private */
    public void incrementModCount() {
        this.metadata += 32;
    }

    public boolean add(@ParametricNullness E object) {
        int entryIndex;
        int entry;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.add(object);
        }
        int[] entries2 = requireEntries();
        Object[] elements2 = requireElements();
        int newEntryIndex = this.size;
        int newSize = newEntryIndex + 1;
        int hash = Hashing.smearedHash(object);
        int mask = hashTableMask();
        int tableIndex = hash & mask;
        int next = CompactHashing.tableGet(requireTable(), tableIndex);
        if (next != 0) {
            int hashPrefix = CompactHashing.getHashPrefix(hash, mask);
            int bucketLength = 0;
            do {
                entryIndex = next - 1;
                entry = entries2[entryIndex];
                if (CompactHashing.getHashPrefix(entry, mask) == hashPrefix && Objects.equal(object, elements2[entryIndex])) {
                    return false;
                }
                next = CompactHashing.getNext(entry, mask);
                bucketLength++;
            } while (next != 0);
            if (bucketLength >= 9) {
                return convertToHashFloodingResistantImplementation().add(object);
            }
            if (newSize > mask) {
                mask = resizeTable(mask, CompactHashing.newCapacity(mask), hash, newEntryIndex);
            } else {
                entries2[entryIndex] = CompactHashing.maskCombine(entry, newEntryIndex + 1, mask);
            }
        } else if (newSize > mask) {
            mask = resizeTable(mask, CompactHashing.newCapacity(mask), hash, newEntryIndex);
        } else {
            CompactHashing.tableSet(requireTable(), tableIndex, newEntryIndex + 1);
        }
        resizeMeMaybe(newSize);
        insertEntry(newEntryIndex, object, hash, mask);
        this.size = newSize;
        incrementModCount();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, @ParametricNullness E object, int hash, int mask) {
        setEntry(entryIndex, CompactHashing.maskCombine(hash, 0, mask));
        setElement(entryIndex, object);
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
        this.elements = Arrays.copyOf(requireElements(), newCapacity);
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

    public boolean contains(@CheckForNull Object object) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.contains(object);
        }
        int hash = Hashing.smearedHash(object);
        int mask = hashTableMask();
        int next = CompactHashing.tableGet(requireTable(), hash & mask);
        if (next == 0) {
            return false;
        }
        int hashPrefix = CompactHashing.getHashPrefix(hash, mask);
        do {
            int entryIndex = next - 1;
            int entry = entry(entryIndex);
            if (CompactHashing.getHashPrefix(entry, mask) == hashPrefix && Objects.equal(object, element(entryIndex))) {
                return true;
            }
            next = CompactHashing.getNext(entry, mask);
        } while (next != 0);
        return false;
    }

    public boolean remove(@CheckForNull Object object) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.remove(object);
        }
        int mask = hashTableMask();
        int index = CompactHashing.remove(object, (Object) null, mask, requireTable(), requireEntries(), requireElements(), (Object[]) null);
        if (index == -1) {
            return false;
        }
        moveLastEntry(index, mask);
        this.size--;
        incrementModCount();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int dstIndex, int mask) {
        int entryIndex;
        int entry;
        Object table2 = requireTable();
        int[] entries2 = requireEntries();
        Object[] elements2 = requireElements();
        int srcIndex = size() - 1;
        if (dstIndex < srcIndex) {
            Object object = elements2[srcIndex];
            elements2[dstIndex] = object;
            elements2[srcIndex] = null;
            entries2[dstIndex] = entries2[srcIndex];
            entries2[srcIndex] = 0;
            int tableIndex = Hashing.smearedHash(object) & mask;
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
        elements2[dstIndex] = null;
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

    public Iterator<E> iterator() {
        Set<E> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.iterator();
        }
        return new Iterator<E>() {
            int currentIndex = CompactHashSet.this.firstEntryIndex();
            int expectedMetadata = CompactHashSet.this.metadata;
            int indexToRemove = -1;

            public boolean hasNext() {
                return this.currentIndex >= 0;
            }

            @ParametricNullness
            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    this.indexToRemove = this.currentIndex;
                    E result = CompactHashSet.this.element(this.currentIndex);
                    this.currentIndex = CompactHashSet.this.getSuccessor(this.currentIndex);
                    return result;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                incrementExpectedModCount();
                CompactHashSet.this.remove(CompactHashSet.this.element(this.indexToRemove));
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }

            /* access modifiers changed from: package-private */
            public void incrementExpectedModCount() {
                this.expectedMetadata += 32;
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.metadata != this.expectedMetadata) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    public int size() {
        Set<E> delegate = delegateOrNull();
        return delegate != null ? delegate.size() : this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegate = delegateOrNull();
        return delegate != null ? delegate.toArray() : Arrays.copyOf(requireElements(), this.size);
    }

    public <T> T[] toArray(T[] a) {
        if (needsAllocArrays()) {
            if (a.length > 0) {
                a[0] = null;
            }
            return a;
        }
        Set<E> delegate = delegateOrNull();
        if (delegate != null) {
            return delegate.toArray(a);
        }
        return ObjectArrays.toArrayImpl(requireElements(), 0, this.size, a);
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            Set<E> delegate = delegateOrNull();
            if (delegate != null) {
                Set<E> newDelegate = createHashFloodingResistantDelegate(size());
                newDelegate.addAll(delegate);
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
            Set<E> delegate = delegateOrNull();
            if (delegate != null) {
                this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                delegate.clear();
                this.table = null;
                this.size = 0;
                return;
            }
            Arrays.fill(requireElements(), 0, this.size, (Object) null);
            CompactHashing.tableClear(requireTable());
            Arrays.fill(requireEntries(), 0, this.size, 0);
            this.size = 0;
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            stream.writeObject(it.next());
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int elementCount = stream.readInt();
        if (elementCount >= 0) {
            init(elementCount);
            for (int i = 0; i < elementCount; i++) {
                add(stream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + elementCount);
    }

    private Object requireTable() {
        return java.util.Objects.requireNonNull(this.table);
    }

    private int[] requireEntries() {
        return (int[]) java.util.Objects.requireNonNull(this.entries);
    }

    private Object[] requireElements() {
        return (Object[]) java.util.Objects.requireNonNull(this.elements);
    }

    /* access modifiers changed from: private */
    public E element(int i) {
        return requireElements()[i];
    }

    private int entry(int i) {
        return requireEntries()[i];
    }

    private void setElement(int i, E value) {
        requireElements()[i] = value;
    }

    private void setEntry(int i, int value) {
        requireEntries()[i] = value;
    }
}
