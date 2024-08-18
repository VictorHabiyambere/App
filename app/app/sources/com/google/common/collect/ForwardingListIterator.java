package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    /* access modifiers changed from: protected */
    public abstract ListIterator<E> delegate();

    protected ForwardingListIterator() {
    }

    public void add(@ParametricNullness E element) {
        delegate().add(element);
    }

    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    public int nextIndex() {
        return delegate().nextIndex();
    }

    @ParametricNullness
    public E previous() {
        return delegate().previous();
    }

    public int previousIndex() {
        return delegate().previousIndex();
    }

    public void set(@ParametricNullness E element) {
        delegate().set(element);
    }
}
