package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T nextOrNull;

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract T computeNext(T t);

    protected AbstractSequentialIterator(@CheckForNull T firstOrNull) {
        this.nextOrNull = firstOrNull;
    }

    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    public final T next() {
        if (this.nextOrNull != null) {
            T oldNext = this.nextOrNull;
            this.nextOrNull = computeNext(oldNext);
            return oldNext;
        }
        throw new NoSuchElementException();
    }
}
