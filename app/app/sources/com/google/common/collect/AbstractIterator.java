package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T next;
    private State state = State.NOT_READY;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract T computeNext();

    protected AbstractIterator() {
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        Preconditions.checkState(this.state != State.FAILED);
        switch (this.state) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return tryToComputeNext();
        }
    }

    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = computeNext();
        if (this.state == State.DONE) {
            return false;
        }
        this.state = State.READY;
        return true;
    }

    @ParametricNullness
    public final T next() {
        if (hasNext()) {
            this.state = State.NOT_READY;
            T result = NullnessCasts.uncheckedCastNullableTToT(this.next);
            this.next = null;
            return result;
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public final T peek() {
        if (hasNext()) {
            return NullnessCasts.uncheckedCastNullableTToT(this.next);
        }
        throw new NoSuchElementException();
    }
}
