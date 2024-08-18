package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {
    /* access modifiers changed from: protected */
    public abstract NavigableSet<E> delegate();

    protected ForwardingNavigableSet() {
    }

    @CheckForNull
    public E lower(@ParametricNullness E e) {
        return delegate().lower(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardLower(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    @CheckForNull
    public E floor(@ParametricNullness E e) {
        return delegate().floor(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardFloor(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e) {
        return delegate().ceiling(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardCeiling(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e) {
        return delegate().higher(e);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardHigher(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    protected class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet this$0) {
            super(this$0);
        }
    }

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> subSet(@ParametricNullness E fromElement, boolean fromInclusive, @ParametricNullness E toElement, boolean toInclusive) {
        return delegate().subSet(fromElement, fromInclusive, toElement, toInclusive);
    }

    /* access modifiers changed from: protected */
    public NavigableSet<E> standardSubSet(@ParametricNullness E fromElement, boolean fromInclusive, @ParametricNullness E toElement, boolean toInclusive) {
        return tailSet(fromElement, fromInclusive).headSet(toElement, toInclusive);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardSubSet(@ParametricNullness E fromElement, @ParametricNullness E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    public NavigableSet<E> headSet(@ParametricNullness E toElement, boolean inclusive) {
        return delegate().headSet(toElement, inclusive);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardHeadSet(@ParametricNullness E toElement) {
        return headSet(toElement, false);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E fromElement, boolean inclusive) {
        return delegate().tailSet(fromElement, inclusive);
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardTailSet(@ParametricNullness E fromElement) {
        return tailSet(fromElement, true);
    }
}
