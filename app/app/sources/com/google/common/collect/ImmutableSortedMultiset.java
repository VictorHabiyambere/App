package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    public static <E> ImmutableSortedMultiset<E> of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E element) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(element), new long[]{0, 1}, 0, 1);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3, e4}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(new Comparable[]{e1, e2, e3, e4, e5}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E... remaining) {
        List<E> all = Lists.newArrayListWithCapacity(remaining.length + 6);
        Collections.addAll(all, new Comparable[]{e1, e2, e3, e4, e5, e6});
        Collections.addAll(all, remaining);
        return copyOf(Ordering.natural(), all);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] elements) {
        return copyOf(Ordering.natural(), Arrays.asList(elements));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> elements) {
        return copyOf(Ordering.natural(), elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> elements) {
        return copyOf(Ordering.natural(), elements);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> elements) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) elements).build();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        if (elements instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> multiset = (ImmutableSortedMultiset) elements;
            if (comparator.equals(multiset.comparator())) {
                if (multiset.isPartialView()) {
                    return copyOfSortedEntries(comparator, multiset.entrySet().asList());
                }
                return multiset;
            }
        }
        return new Builder(comparator).addAll((Iterable) elements).build();
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> entries) {
        if (entries.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder<E> elementsBuilder = new ImmutableList.Builder<>(entries.size());
        long[] cumulativeCounts = new long[(entries.size() + 1)];
        int i = 0;
        for (Multiset.Entry<E> entry : entries) {
            elementsBuilder.add((Object) entry.getElement());
            cumulativeCounts[i + 1] = cumulativeCounts[i] + ((long) entry.getCount());
            i++;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(elementsBuilder.build(), comparator), cumulativeCounts, 0, entries.size());
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    ImmutableSortedMultiset() {
    }

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset;
        ImmutableSortedMultiset<E> result = this.descendingMultiset;
        if (result != null) {
            return result;
        }
        if (isEmpty()) {
            immutableSortedMultiset = emptyMultiset(Ordering.from(comparator()).reverse());
        } else {
            immutableSortedMultiset = new DescendingImmutableSortedMultiset<>(this);
        }
        this.descendingMultiset = immutableSortedMultiset;
        return immutableSortedMultiset;
    }

    @CheckForNull
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMultiset<E> subMultiset(E lowerBound, BoundType lowerBoundType, E upperBound, BoundType upperBoundType) {
        Preconditions.checkArgument(comparator().compare(lowerBound, upperBound) <= 0, "Expected lowerBound <= upperBound but %s > %s", (Object) lowerBound, (Object) upperBound);
        return tailMultiset(lowerBound, lowerBoundType).headMultiset(upperBound, upperBoundType);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> comparator;
        private int[] counts = new int[4];
        E[] elements = new Object[4];
        private boolean forceCopyElements;
        private int length;

        public Builder(Comparator<? super E> comparator2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        private void maintenance() {
            if (this.length == this.elements.length) {
                dedupAndCoalesce(true);
            } else if (this.forceCopyElements) {
                this.elements = Arrays.copyOf(this.elements, this.elements.length);
            }
            this.forceCopyElements = false;
        }

        private void dedupAndCoalesce(boolean maybeExpand) {
            if (this.length != 0) {
                E[] sortedElements = Arrays.copyOf(this.elements, this.length);
                Arrays.sort(sortedElements, this.comparator);
                int uniques = 1;
                for (int i = 1; i < sortedElements.length; i++) {
                    if (this.comparator.compare(sortedElements[uniques - 1], sortedElements[i]) < 0) {
                        sortedElements[uniques] = sortedElements[i];
                        uniques++;
                    }
                }
                Arrays.fill(sortedElements, uniques, this.length, (Object) null);
                if (maybeExpand && uniques * 4 > this.length * 3) {
                    sortedElements = Arrays.copyOf(sortedElements, IntMath.saturatedAdd(this.length, (this.length / 2) + 1));
                }
                int[] sortedCounts = new int[sortedElements.length];
                for (int i2 = 0; i2 < this.length; i2++) {
                    int index = Arrays.binarySearch(sortedElements, 0, uniques, this.elements[i2], this.comparator);
                    if (this.counts[i2] >= 0) {
                        sortedCounts[index] = sortedCounts[index] + this.counts[i2];
                    } else {
                        sortedCounts[index] = ~this.counts[i2];
                    }
                }
                this.elements = sortedElements;
                this.counts = sortedCounts;
                this.length = uniques;
            }
        }

        public Builder<E> add(E element) {
            return addCopies((Object) element, 1);
        }

        public Builder<E> add(E... elements2) {
            for (E element : elements2) {
                add((Object) element);
            }
            return this;
        }

        public Builder<E> addCopies(E element, int occurrences) {
            Preconditions.checkNotNull(element);
            CollectPreconditions.checkNonnegative(occurrences, "occurrences");
            if (occurrences == 0) {
                return this;
            }
            maintenance();
            this.elements[this.length] = element;
            this.counts[this.length] = occurrences;
            this.length++;
            return this;
        }

        public Builder<E> setCount(E element, int count) {
            Preconditions.checkNotNull(element);
            CollectPreconditions.checkNonnegative(count, "count");
            maintenance();
            this.elements[this.length] = element;
            this.counts[this.length] = ~count;
            this.length++;
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> elements2) {
            if (elements2 instanceof Multiset) {
                for (Multiset.Entry<? extends E> entry : ((Multiset) elements2).entrySet()) {
                    addCopies((Object) entry.getElement(), entry.getCount());
                }
            } else {
                for (E e : elements2) {
                    add((Object) e);
                }
            }
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> elements2) {
            while (elements2.hasNext()) {
                add((Object) elements2.next());
            }
            return this;
        }

        private void dedupAndCoalesceAndDeleteEmpty() {
            dedupAndCoalesce(false);
            int size = 0;
            for (int i = 0; i < this.length; i++) {
                if (this.counts[i] > 0) {
                    this.elements[size] = this.elements[i];
                    this.counts[size] = this.counts[i];
                    size++;
                }
            }
            Arrays.fill(this.elements, size, this.length, (Object) null);
            Arrays.fill(this.counts, size, this.length, 0);
            this.length = size;
        }

        public ImmutableSortedMultiset<E> build() {
            dedupAndCoalesceAndDeleteEmpty();
            if (this.length == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.comparator);
            }
            RegularImmutableSortedSet<E> elementSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.comparator, this.length, this.elements);
            long[] cumulativeCounts = new long[(this.length + 1)];
            for (int i = 0; i < this.length; i++) {
                cumulativeCounts[i + 1] = cumulativeCounts[i] + ((long) this.counts[i]);
            }
            this.forceCopyElements = true;
            return new RegularImmutableSortedMultiset(elementSet, cumulativeCounts, 0, this.length);
        }
    }

    private static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(SortedMultiset<E> multiset) {
            this.comparator = multiset.comparator();
            int n = multiset.entrySet().size();
            this.elements = new Object[n];
            this.counts = new int[n];
            int i = 0;
            for (Multiset.Entry<E> entry : multiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            int n = this.elements.length;
            Builder<E> builder = new Builder<>(this.comparator);
            for (int i = 0; i < n; i++) {
                builder.addCopies((Object) this.elements[i], this.counts[i]);
            }
            return builder.build();
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
