package com.google.common.collect;

import java.util.Arrays;

@ElementTypesAreNonnullByDefault
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    transient long[] links;

    static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int expectedSize) {
        return new ObjectCountLinkedHashMap<>(expectedSize);
    }

    ObjectCountLinkedHashMap() {
        this(3);
    }

    ObjectCountLinkedHashMap(int expectedSize) {
        this(expectedSize, 1.0f);
    }

    ObjectCountLinkedHashMap(int expectedSize, float loadFactor) {
        super(expectedSize, loadFactor);
    }

    ObjectCountLinkedHashMap(ObjectCountHashMap<K> map) {
        init(map.size(), 1.0f);
        int i = map.firstIndex();
        while (i != -1) {
            put(map.getKey(i), map.getValue(i));
            i = map.nextIndex(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize, float loadFactor) {
        super.init(expectedSize, loadFactor);
        this.firstEntry = -2;
        this.lastEntry = -2;
        this.links = new long[expectedSize];
        Arrays.fill(this.links, -1);
    }

    /* access modifiers changed from: package-private */
    public int firstIndex() {
        if (this.firstEntry == -2) {
            return -1;
        }
        return this.firstEntry;
    }

    /* access modifiers changed from: package-private */
    public int nextIndex(int index) {
        int result = getSuccessor(index);
        if (result == -2) {
            return -1;
        }
        return result;
    }

    /* access modifiers changed from: package-private */
    public int nextIndexAfterRemove(int oldNextIndex, int removedIndex) {
        return oldNextIndex == size() ? removedIndex : oldNextIndex;
    }

    private int getPredecessor(int entry) {
        return (int) (this.links[entry] >>> 32);
    }

    private int getSuccessor(int entry) {
        return (int) this.links[entry];
    }

    private void setSuccessor(int entry, int succ) {
        this.links[entry] = (this.links[entry] & (~4294967295L)) | (((long) succ) & 4294967295L);
    }

    private void setPredecessor(int entry, int pred) {
        this.links[entry] = (this.links[entry] & (~-4294967296L)) | (((long) pred) << 32);
    }

    private void setSucceeds(int pred, int succ) {
        if (pred == -2) {
            this.firstEntry = succ;
        } else {
            setSuccessor(pred, succ);
        }
        if (succ == -2) {
            this.lastEntry = pred;
        } else {
            setPredecessor(succ, pred);
        }
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int entryIndex, @ParametricNullness K key, int value, int hash) {
        super.insertEntry(entryIndex, key, value, hash);
        setSucceeds(this.lastEntry, entryIndex);
        setSucceeds(entryIndex, -2);
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int dstIndex) {
        int srcIndex = size() - 1;
        setSucceeds(getPredecessor(dstIndex), getSuccessor(dstIndex));
        if (dstIndex < srcIndex) {
            setSucceeds(getPredecessor(srcIndex), dstIndex);
            setSucceeds(dstIndex, getSuccessor(srcIndex));
        }
        super.moveLastEntry(dstIndex);
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        super.resizeEntries(newCapacity);
        int oldCapacity = this.links.length;
        this.links = Arrays.copyOf(this.links, newCapacity);
        Arrays.fill(this.links, oldCapacity, newCapacity, -1);
    }

    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }
}
