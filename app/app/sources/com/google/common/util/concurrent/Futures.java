package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {
    private Futures() {
    }

    public static <V> ListenableFuture<V> immediateFuture(@ParametricNullness V value) {
        if (value == null) {
            return ImmediateFuture.NULL;
        }
        return new ImmediateFuture(value);
    }

    public static ListenableFuture<Void> immediateVoidFuture() {
        return ImmediateFuture.NULL;
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        return new ImmediateFuture.ImmediateFailedFuture(throwable);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        ListenableFuture<Object> instance = ImmediateFuture.ImmediateCancelledFuture.INSTANCE;
        if (instance != null) {
            return instance;
        }
        return new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static <O> ListenableFuture<O> submit(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask<O> task = TrustedListenableFutureTask.create(callable);
        executor.execute(task);
        return task;
    }

    public static ListenableFuture<Void> submit(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask<Void> task = TrustedListenableFutureTask.create(runnable, null);
        executor.execute(task);
        return task;
    }

    public static <O> ListenableFuture<O> submitAsync(AsyncCallable<O> callable, Executor executor) {
        TrustedListenableFutureTask<O> task = TrustedListenableFutureTask.create(callable);
        executor.execute(task);
        return task;
    }

    public static <O> ListenableFuture<O> scheduleAsync(AsyncCallable<O> callable, long delay, TimeUnit timeUnit, ScheduledExecutorService executorService) {
        TrustedListenableFutureTask<O> task = TrustedListenableFutureTask.create(callable);
        task.addListener(new Futures$$ExternalSyntheticLambda1(executorService.schedule(task, delay, timeUnit)), MoreExecutors.directExecutor());
        return task;
    }

    public static <V, X extends Throwable> ListenableFuture<V> catching(ListenableFuture<? extends V> input, Class<X> exceptionType, Function<? super X, ? extends V> fallback, Executor executor) {
        return AbstractCatchingFuture.create(input, exceptionType, fallback, executor);
    }

    public static <V, X extends Throwable> ListenableFuture<V> catchingAsync(ListenableFuture<? extends V> input, Class<X> exceptionType, AsyncFunction<? super X, ? extends V> fallback, Executor executor) {
        return AbstractCatchingFuture.create(input, exceptionType, fallback, executor);
    }

    public static <V> ListenableFuture<V> withTimeout(ListenableFuture<V> delegate, long time, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        if (delegate.isDone()) {
            return delegate;
        }
        return TimeoutFuture.create(delegate, time, unit, scheduledExecutor);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(input, function, executor);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.create(input, function, executor);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> input, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(input);
        Preconditions.checkNotNull(function);
        return new Future<O>() {
            public boolean cancel(boolean mayInterruptIfRunning) {
                return input.cancel(mayInterruptIfRunning);
            }

            public boolean isCancelled() {
                return input.isCancelled();
            }

            public boolean isDone() {
                return input.isDone();
            }

            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(input.get());
            }

            public O get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(input.get(timeout, unit));
            }

            private O applyTransformation(I input) throws ExecutionException {
                try {
                    return function.apply(input);
                } catch (Error | RuntimeException t) {
                    throw new ExecutionException(t);
                }
            }
        };
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... futures) {
        return new CollectionFuture.ListFuture<>(ImmutableList.copyOf((E[]) futures), true);
    }

    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new CollectionFuture.ListFuture<>(ImmutableList.copyOf(futures), true);
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllComplete(ListenableFuture<? extends V>... futures) {
        return new FutureCombiner<>(false, ImmutableList.copyOf((E[]) futures));
    }

    public static <V> FutureCombiner<V> whenAllComplete(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new FutureCombiner<>(false, ImmutableList.copyOf(futures));
    }

    @SafeVarargs
    public static <V> FutureCombiner<V> whenAllSucceed(ListenableFuture<? extends V>... futures) {
        return new FutureCombiner<>(true, ImmutableList.copyOf((E[]) futures));
    }

    public static <V> FutureCombiner<V> whenAllSucceed(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new FutureCombiner<>(true, ImmutableList.copyOf(futures));
    }

    public static final class FutureCombiner<V> {
        private final boolean allMustSucceed;
        private final ImmutableList<ListenableFuture<? extends V>> futures;

        private FutureCombiner(boolean allMustSucceed2, ImmutableList<ListenableFuture<? extends V>> futures2) {
            this.allMustSucceed = allMustSucceed2;
            this.futures = futures2;
        }

        public <C> ListenableFuture<C> callAsync(AsyncCallable<C> combiner, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.futures, this.allMustSucceed, executor, combiner);
        }

        public <C> ListenableFuture<C> call(Callable<C> combiner, Executor executor) {
            return new CombinedFuture((ImmutableCollection<? extends ListenableFuture<?>>) this.futures, this.allMustSucceed, executor, combiner);
        }

        public ListenableFuture<?> run(final Runnable combiner, Executor executor) {
            return call(new Callable<Void>(this) {
                @CheckForNull
                public Void call() throws Exception {
                    combiner.run();
                    return null;
                }
            }, executor);
        }
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> future) {
        if (future.isDone()) {
            return future;
        }
        NonCancellationPropagatingFuture<V> output = new NonCancellationPropagatingFuture<>(future);
        future.addListener(output, MoreExecutors.directExecutor());
        return output;
    }

    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        @CheckForNull
        private ListenableFuture<V> delegate;

        NonCancellationPropagatingFuture(ListenableFuture<V> delegate2) {
            this.delegate = delegate2;
        }

        public void run() {
            ListenableFuture<V> localDelegate = this.delegate;
            if (localDelegate != null) {
                setFuture(localDelegate);
            }
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public String pendingToString() {
            ListenableFuture<V> localDelegate = this.delegate;
            if (localDelegate != null) {
                return "delegate=[" + localDelegate + "]";
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void afterDone() {
            this.delegate = null;
        }
    }

    @SafeVarargs
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... futures) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf((E[]) futures), false);
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new CollectionFuture.ListFuture(ImmutableList.copyOf(futures), false);
    }

    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> futures) {
        ListenableFuture<? extends T>[] copy = gwtCompatibleToArray(futures);
        InCompletionOrderState<T> state = new InCompletionOrderState<>(copy);
        ImmutableList.Builder<AbstractFuture<T>> delegatesBuilder = ImmutableList.builderWithExpectedSize(copy.length);
        for (int i = 0; i < copy.length; i++) {
            delegatesBuilder.add((Object) new InCompletionOrderFuture(state));
        }
        ImmutableList<ListenableFuture<T>> delegates = delegatesBuilder.build();
        for (int i2 = 0; i2 < copy.length; i2++) {
            copy[i2].addListener(new Futures$$ExternalSyntheticLambda0(state, delegates, i2), MoreExecutors.directExecutor());
        }
        return delegates;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.google.common.util.concurrent.ListenableFuture<? extends T>[] gwtCompatibleToArray(java.lang.Iterable<? extends com.google.common.util.concurrent.ListenableFuture<? extends T>> r2) {
        /*
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0008
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            goto L_0x000c
        L_0x0008:
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.copyOf(r2)
        L_0x000c:
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture[] r1 = new com.google.common.util.concurrent.ListenableFuture[r1]
            java.lang.Object[] r1 = r0.toArray(r1)
            com.google.common.util.concurrent.ListenableFuture[] r1 = (com.google.common.util.concurrent.ListenableFuture[]) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.gwtCompatibleToArray(java.lang.Iterable):com.google.common.util.concurrent.ListenableFuture[]");
    }

    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        @CheckForNull
        private InCompletionOrderState<T> state;

        private InCompletionOrderFuture(InCompletionOrderState<T> state2) {
            this.state = state2;
        }

        public boolean cancel(boolean interruptIfRunning) {
            InCompletionOrderState<T> localState = this.state;
            if (!super.cancel(interruptIfRunning)) {
                return false;
            }
            ((InCompletionOrderState) Objects.requireNonNull(localState)).recordOutputCancellation(interruptIfRunning);
            return true;
        }

        /* access modifiers changed from: protected */
        public void afterDone() {
            this.state = null;
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public String pendingToString() {
            InCompletionOrderState<T> localState = this.state;
            if (localState != null) {
                return "inputCount=[" + localState.inputFutures.length + "], remaining=[" + localState.incompleteOutputCount.get() + "]";
            }
            return null;
        }
    }

    private static final class InCompletionOrderState<T> {
        private volatile int delegateIndex;
        /* access modifiers changed from: private */
        public final AtomicInteger incompleteOutputCount;
        /* access modifiers changed from: private */
        public final ListenableFuture<? extends T>[] inputFutures;
        private boolean shouldInterrupt;
        private boolean wasCancelled;

        private InCompletionOrderState(ListenableFuture<? extends T>[] inputFutures2) {
            this.wasCancelled = false;
            this.shouldInterrupt = true;
            this.delegateIndex = 0;
            this.inputFutures = inputFutures2;
            this.incompleteOutputCount = new AtomicInteger(inputFutures2.length);
        }

        /* access modifiers changed from: private */
        public void recordOutputCancellation(boolean interruptIfRunning) {
            this.wasCancelled = true;
            if (!interruptIfRunning) {
                this.shouldInterrupt = false;
            }
            recordCompletion();
        }

        /* access modifiers changed from: private */
        public void recordInputCompletion(ImmutableList<AbstractFuture<T>> delegates, int inputFutureIndex) {
            ListenableFuture<? extends T> inputFuture = (ListenableFuture) Objects.requireNonNull(this.inputFutures[inputFutureIndex]);
            this.inputFutures[inputFutureIndex] = null;
            for (int i = this.delegateIndex; i < delegates.size(); i++) {
                if (((AbstractFuture) delegates.get(i)).setFuture(inputFuture)) {
                    recordCompletion();
                    this.delegateIndex = i + 1;
                    return;
                }
            }
            this.delegateIndex = delegates.size();
        }

        private void recordCompletion() {
            if (this.incompleteOutputCount.decrementAndGet() == 0 && this.wasCancelled) {
                for (ListenableFuture<? extends T> toCancel : this.inputFutures) {
                    if (toCancel != null) {
                        toCancel.cancel(this.shouldInterrupt);
                    }
                }
            }
        }
    }

    public static <V> void addCallback(ListenableFuture<V> future, FutureCallback<? super V> callback, Executor executor) {
        Preconditions.checkNotNull(callback);
        future.addListener(new CallbackListener(future, callback), executor);
    }

    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> future2, FutureCallback<? super V> callback2) {
            this.future = future2;
            this.callback = callback2;
        }

        public void run() {
            Throwable failure;
            if (!(this.future instanceof InternalFutureFailureAccess) || (failure = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess) this.future)) == null) {
                try {
                    this.callback.onSuccess(Futures.getDone(this.future));
                } catch (ExecutionException e) {
                    this.callback.onFailure(e.getCause());
                } catch (Error | RuntimeException e2) {
                    this.callback.onFailure(e2);
                }
            } else {
                this.callback.onFailure(failure);
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper((Object) this).addValue((Object) this.callback).toString();
        }
    }

    @ParametricNullness
    public static <V> V getDone(Future<V> future) throws ExecutionException {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", (Object) future);
        return Uninterruptibles.getUninterruptibly(future);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> exceptionClass) throws Exception {
        return FuturesGetChecked.getChecked(future, exceptionClass);
    }

    @ParametricNullness
    public static <V, X extends Exception> V getChecked(Future<V> future, Class<X> exceptionClass, long timeout, TimeUnit unit) throws Exception {
        return FuturesGetChecked.getChecked(future, exceptionClass, timeout, unit);
    }

    @ParametricNullness
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }

    private static void wrapAndThrowUnchecked(Throwable cause) {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        }
        throw new UncheckedExecutionException(cause);
    }
}
