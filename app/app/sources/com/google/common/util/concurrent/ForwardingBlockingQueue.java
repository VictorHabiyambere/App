package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    /* access modifiers changed from: protected */
    public abstract BlockingQueue<E> delegate();

    protected ForwardingBlockingQueue() {
    }

    public int drainTo(Collection<? super E> c, int maxElements) {
        return delegate().drainTo(c, maxElements);
    }

    public int drainTo(Collection<? super E> c) {
        return delegate().drainTo(c);
    }

    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offer(e, timeout, unit);
    }

    @CheckForNull
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().poll(timeout, unit);
    }

    public void put(E e) throws InterruptedException {
        delegate().put(e);
    }

    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    public E take() throws InterruptedException {
        return delegate().take();
    }
}
