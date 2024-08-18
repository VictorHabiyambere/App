package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
public final class Callables {
    private Callables() {
    }

    static /* synthetic */ Object lambda$returning$0(Object value) throws Exception {
        return value;
    }

    public static <T> Callable<T> returning(@ParametricNullness T value) {
        return new Callables$$ExternalSyntheticLambda2(value);
    }

    public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new Callables$$ExternalSyntheticLambda1(listeningExecutorService, callable);
    }

    static <T> Callable<T> threadRenaming(Callable<T> callable, Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(callable);
        return new Callables$$ExternalSyntheticLambda0(nameSupplier, callable);
    }

    static /* synthetic */ Object lambda$threadRenaming$2(Supplier nameSupplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        boolean restoreName = trySetName((String) nameSupplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (restoreName) {
                trySetName(oldName, currentThread);
            }
        }
    }

    static Runnable threadRenaming(Runnable task, Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(task);
        return new Callables$$ExternalSyntheticLambda3(nameSupplier, task);
    }

    static /* synthetic */ void lambda$threadRenaming$3(Supplier nameSupplier, Runnable task) {
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        boolean restoreName = trySetName((String) nameSupplier.get(), currentThread);
        try {
            task.run();
        } finally {
            if (restoreName) {
                trySetName(oldName, currentThread);
            }
        }
    }

    private static boolean trySetName(String threadName, Thread currentThread) {
        try {
            currentThread.setName(threadName);
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }
}
