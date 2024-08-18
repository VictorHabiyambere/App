package com.google.common.collect;

import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;

    SingletonImmutableSet(E element2) {
        this.element = Preconditions.checkNotNull(element2);
    }

    public int size() {
        return 1;
    }

    public boolean contains(@CheckForNull Object target) {
        return this.element.equals(target);
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public ImmutableList<E> asList() {
        return ImmutableList.of(this.element);
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] dst, int offset) {
        dst[offset] = this.element;
        return offset + 1;
    }

    public final int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        return '[' + this.element.toString() + ']';
    }
}
