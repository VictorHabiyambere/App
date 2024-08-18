package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    @CheckForNull
    transient long[] links;

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int expectedSize) {
        return new CompactLinkedHashMap<>(expectedSize);
    }

    CompactLinkedHashMap() {
        this(3);
    }

    CompactLinkedHashMap(int expectedSize) {
        this(expectedSize, false);
    }

    CompactLinkedHashMap(int expectedSize, boolean accessOrder2) {
        super(expectedSize);
        this.accessOrder = accessOrder2;
    }

    /* access modifiers changed from: package-private */
    public void init(int expectedSize) {
        super.init(expectedSize);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    /* access modifiers changed from: package-private */
    public int allocArrays() {
        int expectedSize = super.allocArrays();
        this.links = new long[expectedSize];
        return expectedSize;
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> createHashFloodingResistantDelegate(int tableSize) {
        return new LinkedHashMap(tableSize, 1.0f, this.accessOrder);
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> result = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return result;
    }

    private int getPredecessor(int entry) {
        return ((int) (link(entry) >>> 32)) - 1;
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int entry) {
        return ((int) link(entry)) - 1;
    }

    private void setSuccessor(int entry, int succ) {
        setLink(entry, (link(entry) & (~4294967295L)) | (((long) (succ + 1)) & 4294967295L));
    }

    private void setPredecessor(int entry, int pred) {
        setLink(entry, (link(entry) & (~-4294967296L)) | (((long) (pred + 1)) << 32));
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
    public void insertEntry(int entryIndex, @ParametricNullness K key, @ParametricNullness V value, int hash, int mask) {
        super.insertEntry(entryIndex, key, value, hash, mask);
        setSucceeds(this.lastEntry, entryIndex);
        setSucceeds(entryIndex, -2);
    }

    /* access modifiers changed from: package-private */
    public void accessEntry(int index) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(index), getSuccessor(index));
            setSucceeds(this.lastEntry, index);
            setSucceeds(index, -2);
            incrementModCount();
        }
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int dstIndex, int mask) {
        int srcIndex = size() - 1;
        super.moveLastEntry(dstIndex, mask);
        setSucceeds(getPredecessor(dstIndex), getSuccessor(dstIndex));
        if (dstIndex < srcIndex) {
            setSucceeds(getPredecessor(srcIndex), dstIndex);
            setSucceeds(dstIndex, getSuccessor(srcIndex));
        }
        setLink(srcIndex, 0);
    }

    /* access modifiers changed from: package-private */
    public void resizeEntries(int newCapacity) {
        super.resizeEntries(newCapacity);
        this.links = Arrays.copyOf(requireLinks(), newCapacity);
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return this.firstEntry;
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove >= size() ? indexRemoved : indexBeforeRemove;
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            if (this.links != null) {
                Arrays.fill(this.links, 0, size(), 0);
            }
            super.clear();
        }
    }

    private long[] requireLinks() {
        return (long[]) Objects.requireNonNull(this.links);
    }

    private long link(int i) {
        return requireLinks()[i];
    }

    private void setLink(int i, long value) {
        requireLinks()[i] = value;
    }
}
