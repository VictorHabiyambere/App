package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final transient AvlNode<E> header;
    /* access modifiers changed from: private */
    public final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    private enum Aggregate {
        SIZE {
            /* access modifiers changed from: package-private */
            public int nodeAggregate(AvlNode<?> node) {
                return node.elemCount;
            }

            /* access modifiers changed from: package-private */
            public long treeAggregate(@CheckForNull AvlNode<?> root) {
                if (root == null) {
                    return 0;
                }
                return root.totalCount;
            }
        },
        DISTINCT {
            /* access modifiers changed from: package-private */
            public int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            /* access modifiers changed from: package-private */
            public long treeAggregate(@CheckForNull AvlNode<?> root) {
                if (root == null) {
                    return 0;
                }
                return (long) root.distinctElements;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int nodeAggregate(AvlNode<?> avlNode);

        /* access modifiers changed from: package-private */
        public abstract long treeAggregate(@CheckForNull AvlNode<?> avlNode);
    }

    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> elements) {
        TreeMultiset<E> multiset = create();
        Iterables.addAll(multiset, elements);
        return multiset;
    }

    TreeMultiset(Reference<AvlNode<E>> rootReference2, GeneralRange<E> range2, AvlNode<E> endLink) {
        super(range2.comparator());
        this.rootReference = rootReference2;
        this.range = range2;
        this.header = endLink;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        this.header = new AvlNode<>();
        successor(this.header, this.header);
        this.rootReference = new Reference<>();
    }

    private long aggregateForEntries(Aggregate aggr) {
        AvlNode<E> root = this.rootReference.get();
        long total = aggr.treeAggregate(root);
        if (this.range.hasLowerBound()) {
            total -= aggregateBelowRange(aggr, root);
        }
        if (this.range.hasUpperBound()) {
            return total - aggregateAboveRange(aggr, root);
        }
        return total;
    }

    private long aggregateBelowRange(Aggregate aggr, @CheckForNull AvlNode<E> node) {
        if (node == null) {
            return 0;
        }
        int cmp = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint()), node.getElement());
        if (cmp < 0) {
            return aggregateBelowRange(aggr, node.left);
        }
        if (cmp != 0) {
            return aggr.treeAggregate(node.left) + ((long) aggr.nodeAggregate(node)) + aggregateBelowRange(aggr, node.right);
        }
        switch (this.range.getLowerBoundType()) {
            case OPEN:
                return ((long) aggr.nodeAggregate(node)) + aggr.treeAggregate(node.left);
            case CLOSED:
                return aggr.treeAggregate(node.left);
            default:
                throw new AssertionError();
        }
    }

    private long aggregateAboveRange(Aggregate aggr, @CheckForNull AvlNode<E> node) {
        if (node == null) {
            return 0;
        }
        int cmp = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint()), node.getElement());
        if (cmp > 0) {
            return aggregateAboveRange(aggr, node.right);
        }
        if (cmp != 0) {
            return aggr.treeAggregate(node.right) + ((long) aggr.nodeAggregate(node)) + aggregateAboveRange(aggr, node.left);
        }
        switch (this.range.getUpperBoundType()) {
            case OPEN:
                return ((long) aggr.nodeAggregate(node)) + aggr.treeAggregate(node.right);
            case CLOSED:
                return aggr.treeAggregate(node.right);
            default:
                throw new AssertionError();
        }
    }

    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    /* access modifiers changed from: package-private */
    public int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    static int distinctElements(@CheckForNull AvlNode<?> node) {
        if (node == null) {
            return 0;
        }
        return node.distinctElements;
    }

    public int count(@CheckForNull Object element) {
        Object obj = element;
        try {
            AvlNode<E> root = this.rootReference.get();
            if (this.range.contains(obj)) {
                if (root != null) {
                    return root.count(comparator(), obj);
                }
            }
            return 0;
        } catch (ClassCastException | NullPointerException e) {
            return 0;
        }
    }

    public int add(@ParametricNullness E element, int occurrences) {
        CollectPreconditions.checkNonnegative(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(this.range.contains(element));
        AvlNode<E> root = this.rootReference.get();
        if (root == null) {
            int compare = comparator().compare(element, element);
            AvlNode<E> newRoot = new AvlNode<>(element, occurrences);
            successor(this.header, newRoot, this.header);
            this.rootReference.checkAndSet(root, newRoot);
            return 0;
        }
        int[] result = new int[1];
        this.rootReference.checkAndSet(root, root.add(comparator(), element, occurrences, result));
        return result[0];
    }

    public int remove(@CheckForNull Object element, int occurrences) {
        CollectPreconditions.checkNonnegative(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        AvlNode<E> root = this.rootReference.get();
        int[] result = new int[1];
        Object obj = element;
        try {
            if (this.range.contains(obj)) {
                if (root != null) {
                    this.rootReference.checkAndSet(root, root.remove(comparator(), obj, occurrences, result));
                    return result[0];
                }
            }
            return 0;
        } catch (ClassCastException | NullPointerException e) {
            return 0;
        }
    }

    public int setCount(@ParametricNullness E element, int count) {
        CollectPreconditions.checkNonnegative(count, "count");
        boolean z = true;
        if (!this.range.contains(element)) {
            if (count != 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return 0;
        }
        AvlNode<E> root = this.rootReference.get();
        if (root == null) {
            if (count > 0) {
                add(element, count);
            }
            return 0;
        }
        int[] result = new int[1];
        this.rootReference.checkAndSet(root, root.setCount(comparator(), element, count, result));
        return result[0];
    }

    public boolean setCount(@ParametricNullness E element, int oldCount, int newCount) {
        CollectPreconditions.checkNonnegative(newCount, "newCount");
        CollectPreconditions.checkNonnegative(oldCount, "oldCount");
        Preconditions.checkArgument(this.range.contains(element));
        AvlNode<E> root = this.rootReference.get();
        if (root != null) {
            int[] result = new int[1];
            this.rootReference.checkAndSet(root, root.setCount(comparator(), element, oldCount, newCount, result));
            if (result[0] == oldCount) {
                return true;
            }
            return false;
        } else if (oldCount != 0) {
            return false;
        } else {
            if (newCount > 0) {
                add(element, newCount);
            }
            return true;
        }
    }

    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> current = this.header.succ();
        while (current != this.header) {
            AvlNode<E> next = current.succ();
            int unused = current.elemCount = 0;
            AvlNode unused2 = current.left = null;
            AvlNode unused3 = current.right = null;
            AvlNode unused4 = current.pred = null;
            AvlNode unused5 = current.succ = null;
            current = next;
        }
        successor(this.header, this.header);
        this.rootReference.clear();
    }

    /* access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> baseEntry) {
        return new Multisets.AbstractEntry<E>() {
            @ParametricNullness
            public E getElement() {
                return baseEntry.getElement();
            }

            public int getCount() {
                int result = baseEntry.getCount();
                if (result == 0) {
                    return TreeMultiset.this.count(getElement());
                }
                return result;
            }
        };
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> firstNode() {
        AvlNode<E> node;
        AvlNode<E> root = this.rootReference.get();
        if (root == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E endpoint = NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint());
            node = root.ceiling(comparator(), endpoint);
            if (node == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(endpoint, node.getElement()) == 0) {
                node = node.succ();
            }
        } else {
            node = this.header.succ();
        }
        if (node == this.header || !this.range.contains(node.getElement())) {
            return null;
        }
        return node;
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> lastNode() {
        AvlNode<E> node;
        AvlNode<E> root = this.rootReference.get();
        if (root == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E endpoint = NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint());
            node = root.floor(comparator(), endpoint);
            if (node == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(endpoint, node.getElement()) == 0) {
                node = node.pred();
            }
        } else {
            node = this.header.pred();
        }
        if (node == this.header || !this.range.contains(node.getElement())) {
            return null;
        }
        return node;
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new Iterator<Multiset.Entry<E>>() {
            @CheckForNull
            AvlNode<E> current = TreeMultiset.this.firstNode();
            @CheckForNull
            Multiset.Entry<E> prevEntry;

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Multiset.Entry<E> result = TreeMultiset.this.wrapEntry((AvlNode) Objects.requireNonNull(this.current));
                    this.prevEntry = result;
                    if (this.current.succ() == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.succ();
                    }
                    return result;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Iterator<Multiset.Entry<E>>() {
            @CheckForNull
            AvlNode<E> current = TreeMultiset.this.lastNode();
            @CheckForNull
            Multiset.Entry<E> prevEntry = null;

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Objects.requireNonNull(this.current);
                    Multiset.Entry<E> result = TreeMultiset.this.wrapEntry(this.current);
                    this.prevEntry = result;
                    if (this.current.pred() == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.pred();
                    }
                    return result;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public SortedMultiset<E> headMultiset(@ParametricNullness E upperBound, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), upperBound, boundType)), this.header);
    }

    public SortedMultiset<E> tailMultiset(@ParametricNullness E lowerBound, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), lowerBound, boundType)), this.header);
    }

    private static final class Reference<T> {
        @CheckForNull
        private T value;

        private Reference() {
        }

        @CheckForNull
        public T get() {
            return this.value;
        }

        public void checkAndSet(@CheckForNull T expected, @CheckForNull T newValue) {
            if (this.value == expected) {
                this.value = newValue;
                return;
            }
            throw new ConcurrentModificationException();
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.value = null;
        }
    }

    private static final class AvlNode<E> {
        /* access modifiers changed from: private */
        public int distinctElements;
        @CheckForNull
        private final E elem;
        /* access modifiers changed from: private */
        public int elemCount;
        private int height;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> left;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> pred;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> right;
        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> succ;
        /* access modifiers changed from: private */
        public long totalCount;

        AvlNode(@ParametricNullness E elem2, int elemCount2) {
            Preconditions.checkArgument(elemCount2 > 0);
            this.elem = elem2;
            this.elemCount = elemCount2;
            this.totalCount = (long) elemCount2;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        AvlNode() {
            this.elem = null;
            this.elemCount = 1;
        }

        /* access modifiers changed from: private */
        public AvlNode<E> pred() {
            return (AvlNode) Objects.requireNonNull(this.pred);
        }

        /* access modifiers changed from: private */
        public AvlNode<E> succ() {
            return (AvlNode) Objects.requireNonNull(this.succ);
        }

        /* access modifiers changed from: package-private */
        public int count(Comparator<? super E> comparator, @ParametricNullness E e) {
            int cmp = comparator.compare(e, getElement());
            if (cmp < 0) {
                if (this.left == null) {
                    return 0;
                }
                return this.left.count(comparator, e);
            } else if (cmp <= 0) {
                return this.elemCount;
            } else {
                if (this.right == null) {
                    return 0;
                }
                return this.right.count(comparator, e);
            }
        }

        private AvlNode<E> addRightChild(@ParametricNullness E e, int count) {
            this.right = new AvlNode<>(e, count);
            TreeMultiset.successor(this, this.right, succ());
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) count;
            return this;
        }

        private AvlNode<E> addLeftChild(@ParametricNullness E e, int count) {
            this.left = new AvlNode<>(e, count);
            TreeMultiset.successor(pred(), this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) count;
            return this;
        }

        /* access modifiers changed from: package-private */
        public AvlNode<E> add(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int cmp = comparator.compare(e, getElement());
            boolean z = true;
            if (cmp < 0) {
                AvlNode<E> initLeft = this.left;
                if (initLeft == null) {
                    result[0] = 0;
                    return addLeftChild(e, count);
                }
                int initHeight = initLeft.height;
                this.left = initLeft.add(comparator, e, count, result);
                if (result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) count;
                return this.left.height == initHeight ? this : rebalance();
            } else if (cmp > 0) {
                AvlNode<E> initRight = this.right;
                if (initRight == null) {
                    result[0] = 0;
                    return addRightChild(e, count);
                }
                int initHeight2 = initRight.height;
                this.right = initRight.add(comparator, e, count, result);
                if (result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) count;
                return this.right.height == initHeight2 ? this : rebalance();
            } else {
                result[0] = this.elemCount;
                if (((long) this.elemCount) + ((long) count) > 2147483647L) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                this.elemCount += count;
                this.totalCount += (long) count;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> remove(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int cmp = comparator.compare(e, getElement());
            if (cmp < 0) {
                AvlNode<E> initLeft = this.left;
                if (initLeft == null) {
                    result[0] = 0;
                    return this;
                }
                this.left = initLeft.remove(comparator, e, count, result);
                if (result[0] > 0) {
                    if (count >= result[0]) {
                        this.distinctElements--;
                        this.totalCount -= (long) result[0];
                    } else {
                        this.totalCount -= (long) count;
                    }
                }
                return result[0] == 0 ? this : rebalance();
            } else if (cmp > 0) {
                AvlNode<E> initRight = this.right;
                if (initRight == null) {
                    result[0] = 0;
                    return this;
                }
                this.right = initRight.remove(comparator, e, count, result);
                if (result[0] > 0) {
                    if (count >= result[0]) {
                        this.distinctElements--;
                        this.totalCount -= (long) result[0];
                    } else {
                        this.totalCount -= (long) count;
                    }
                }
                return rebalance();
            } else {
                result[0] = this.elemCount;
                if (count >= this.elemCount) {
                    return deleteMe();
                }
                this.elemCount -= count;
                this.totalCount -= (long) count;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int cmp = comparator.compare(e, getElement());
            if (cmp < 0) {
                AvlNode<E> initLeft = this.left;
                if (initLeft == null) {
                    result[0] = 0;
                    return count > 0 ? addLeftChild(e, count) : this;
                }
                this.left = initLeft.setCount(comparator, e, count, result);
                if (count == 0 && result[0] != 0) {
                    this.distinctElements--;
                } else if (count > 0 && result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (count - result[0]);
                return rebalance();
            } else if (cmp > 0) {
                AvlNode<E> initRight = this.right;
                if (initRight == null) {
                    result[0] = 0;
                    return count > 0 ? addRightChild(e, count) : this;
                }
                this.right = initRight.setCount(comparator, e, count, result);
                if (count == 0 && result[0] != 0) {
                    this.distinctElements--;
                } else if (count > 0 && result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (count - result[0]);
                return rebalance();
            } else {
                result[0] = this.elemCount;
                if (count == 0) {
                    return deleteMe();
                }
                this.totalCount += (long) (count - this.elemCount);
                this.elemCount = count;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e, int expectedCount, int newCount, int[] result) {
            int cmp = comparator.compare(e, getElement());
            if (cmp < 0) {
                AvlNode<E> initLeft = this.left;
                if (initLeft == null) {
                    result[0] = 0;
                    if (expectedCount != 0 || newCount <= 0) {
                        return this;
                    }
                    return addLeftChild(e, newCount);
                }
                this.left = initLeft.setCount(comparator, e, expectedCount, newCount, result);
                if (result[0] == expectedCount) {
                    if (newCount == 0 && result[0] != 0) {
                        this.distinctElements--;
                    } else if (newCount > 0 && result[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (newCount - result[0]);
                }
                return rebalance();
            } else if (cmp > 0) {
                AvlNode<E> initRight = this.right;
                if (initRight == null) {
                    result[0] = 0;
                    if (expectedCount != 0 || newCount <= 0) {
                        return this;
                    }
                    return addRightChild(e, newCount);
                }
                this.right = initRight.setCount(comparator, e, expectedCount, newCount, result);
                if (result[0] == expectedCount) {
                    if (newCount == 0 && result[0] != 0) {
                        this.distinctElements--;
                    } else if (newCount > 0 && result[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (newCount - result[0]);
                }
                return rebalance();
            } else {
                result[0] = this.elemCount;
                if (expectedCount == this.elemCount) {
                    if (newCount == 0) {
                        return deleteMe();
                    }
                    this.totalCount += (long) (newCount - this.elemCount);
                    this.elemCount = newCount;
                }
                return this;
            }
        }

        @CheckForNull
        private AvlNode<E> deleteMe() {
            int oldElemCount = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(pred(), succ());
            if (this.left == null) {
                return this.right;
            }
            if (this.right == null) {
                return this.left;
            }
            if (this.left.height >= this.right.height) {
                AvlNode<E> newTop = pred();
                newTop.left = this.left.removeMax(newTop);
                newTop.right = this.right;
                newTop.distinctElements = this.distinctElements - 1;
                newTop.totalCount = this.totalCount - ((long) oldElemCount);
                return newTop.rebalance();
            }
            AvlNode<E> newTop2 = succ();
            newTop2.right = this.right.removeMin(newTop2);
            newTop2.left = this.left;
            newTop2.distinctElements = this.distinctElements - 1;
            newTop2.totalCount = this.totalCount - ((long) oldElemCount);
            return newTop2.rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMin(AvlNode<E> node) {
            if (this.left == null) {
                return this.right;
            }
            this.left = this.left.removeMin(node);
            this.distinctElements--;
            this.totalCount -= (long) node.elemCount;
            return rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMax(AvlNode<E> node) {
            if (this.right == null) {
                return this.left;
            }
            this.right = this.right.removeMax(node);
            this.distinctElements--;
            this.totalCount -= (long) node.elemCount;
            return rebalance();
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = ((long) this.elemCount) + totalCount(this.left) + totalCount(this.right);
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private AvlNode<E> rebalance() {
            switch (balanceFactor()) {
                case -2:
                    Objects.requireNonNull(this.right);
                    if (this.right.balanceFactor() > 0) {
                        this.right = this.right.rotateRight();
                    }
                    return rotateLeft();
                case 2:
                    Objects.requireNonNull(this.left);
                    if (this.left.balanceFactor() < 0) {
                        this.left = this.left.rotateLeft();
                    }
                    return rotateRight();
                default:
                    recomputeHeight();
                    return this;
            }
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> newTop = this.right;
            this.right = newTop.left;
            newTop.left = this;
            newTop.totalCount = this.totalCount;
            newTop.distinctElements = this.distinctElements;
            recompute();
            newTop.recomputeHeight();
            return newTop;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> newTop = this.left;
            this.left = newTop.right;
            newTop.right = this;
            newTop.totalCount = this.totalCount;
            newTop.distinctElements = this.distinctElements;
            recompute();
            newTop.recomputeHeight();
            return newTop;
        }

        private static long totalCount(@CheckForNull AvlNode<?> node) {
            if (node == null) {
                return 0;
            }
            return node.totalCount;
        }

        private static int height(@CheckForNull AvlNode<?> node) {
            if (node == null) {
                return 0;
            }
            return node.height;
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> ceiling(Comparator<? super E> comparator, @ParametricNullness E e) {
            int cmp = comparator.compare(e, getElement());
            if (cmp < 0) {
                return this.left == null ? this : (AvlNode) MoreObjects.firstNonNull(this.left.ceiling(comparator, e), this);
            }
            if (cmp == 0) {
                return this;
            }
            if (this.right == null) {
                return null;
            }
            return this.right.ceiling(comparator, e);
        }

        /* access modifiers changed from: private */
        @CheckForNull
        public AvlNode<E> floor(Comparator<? super E> comparator, @ParametricNullness E e) {
            int cmp = comparator.compare(e, getElement());
            if (cmp > 0) {
                return this.right == null ? this : (AvlNode) MoreObjects.firstNonNull(this.right.floor(comparator, e), this);
            }
            if (cmp == 0) {
                return this;
            }
            if (this.left == null) {
                return null;
            }
            return this.left.floor(comparator, e);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public E getElement() {
            return NullnessCasts.uncheckedCastNullableTToT(this.elem);
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.elemCount;
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }
    }

    /* access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> a, AvlNode<T> b) {
        AvlNode unused = a.succ = b;
        AvlNode unused2 = b.pred = a;
    }

    /* access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> a, AvlNode<T> b, AvlNode<T> c) {
        successor(a, b);
        successor(b, c);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, stream);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Comparator<? super E> comparator = (Comparator) stream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, (Object) comparator);
        Class<TreeMultiset> cls = TreeMultiset.class;
        Serialization.getFieldSetter(cls, "range").set(this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(cls, "rootReference").set(this, (Object) new Reference());
        AvlNode<E> header2 = new AvlNode<>();
        Serialization.getFieldSetter(cls, "header").set(this, (Object) header2);
        successor(header2, header2);
        Serialization.populateMultiset(this, stream);
    }
}
