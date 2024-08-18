package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* access modifiers changed from: protected */
    public abstract List<E> delegate();

    protected ForwardingList() {
    }

    public void add(int index, @ParametricNullness E element) {
        delegate().add(index, element);
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        return delegate().addAll(index, elements);
    }

    @ParametricNullness
    public E get(int index) {
        return delegate().get(index);
    }

    public int indexOf(@CheckForNull Object element) {
        return delegate().indexOf(element);
    }

    public int lastIndexOf(@CheckForNull Object element) {
        return delegate().lastIndexOf(element);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return delegate().listIterator(index);
    }

    @ParametricNullness
    public E remove(int index) {
        return delegate().remove(index);
    }

    @ParametricNullness
    public E set(int index, @ParametricNullness E element) {
        return delegate().set(index, element);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return delegate().subList(fromIndex, toIndex);
    }

    public boolean equals(@CheckForNull Object object) {
        return object == this || delegate().equals(object);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean standardAdd(@ParametricNullness E element) {
        add(size(), element);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean standardAddAll(int index, Iterable<? extends E> elements) {
        return Lists.addAllImpl(this, index, elements);
    }

    /* access modifiers changed from: protected */
    public int standardIndexOf(@CheckForNull Object element) {
        return Lists.indexOfImpl(this, element);
    }

    /* access modifiers changed from: protected */
    public int standardLastIndexOf(@CheckForNull Object element) {
        return Lists.lastIndexOfImpl(this, element);
    }

    /* access modifiers changed from: protected */
    public Iterator<E> standardIterator() {
        return listIterator();
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    /* access modifiers changed from: protected */
    public ListIterator<E> standardListIterator(int start) {
        return Lists.listIteratorImpl(this, start);
    }

    /* access modifiers changed from: protected */
    public List<E> standardSubList(int fromIndex, int toIndex) {
        return Lists.subListImpl(this, fromIndex, toIndex);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(@CheckForNull Object object) {
        return Lists.equalsImpl(this, object);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}
