package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedSet<E> extends ForwardingSet<E> implements SortedSet<E> {
    /* access modifiers changed from: protected */
    public abstract SortedSet<E> delegate();

    protected ForwardingSortedSet() {
    }

    @CheckForNull
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @ParametricNullness
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(@ParametricNullness E toElement) {
        return delegate().headSet(toElement);
    }

    @ParametricNullness
    public E last() {
        return delegate().last();
    }

    public SortedSet<E> subSet(@ParametricNullness E fromElement, @ParametricNullness E toElement) {
        return delegate().subSet(fromElement, toElement);
    }

    public SortedSet<E> tailSet(@ParametricNullness E fromElement) {
        return delegate().tailSet(fromElement);
    }

    /* access modifiers changed from: protected */
    public boolean standardContains(@CheckForNull Object object) {
        try {
            if (ForwardingSortedMap.unsafeCompare(comparator(), tailSet(object).first(), object) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardRemove(@CheckForNull Object object) {
        try {
            Iterator<?> iterator = tailSet(object).iterator();
            if (iterator.hasNext()) {
                if (ForwardingSortedMap.unsafeCompare(comparator(), iterator.next(), object) == 0) {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public SortedSet<E> standardSubSet(@ParametricNullness E fromElement, @ParametricNullness E toElement) {
        return tailSet(fromElement).headSet(toElement);
    }
}
