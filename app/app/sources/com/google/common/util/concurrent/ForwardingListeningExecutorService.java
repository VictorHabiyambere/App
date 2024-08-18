package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
    /* access modifiers changed from: protected */
    public abstract ListeningExecutorService delegate();

    protected ForwardingListeningExecutorService() {
    }

    public <T> ListenableFuture<T> submit(Callable<T> task) {
        return delegate().submit(task);
    }

    public ListenableFuture<?> submit(Runnable task) {
        return delegate().submit(task);
    }

    public <T> ListenableFuture<T> submit(Runnable task, @ParametricNullness T result) {
        return delegate().submit(task, result);
    }
}
