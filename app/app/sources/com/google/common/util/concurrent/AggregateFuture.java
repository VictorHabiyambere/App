package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    @CheckForNull
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    /* access modifiers changed from: package-private */
    public abstract void collectOneValue(int i, @ParametricNullness InputT inputt);

    /* access modifiers changed from: package-private */
    public abstract void handleAllCompleted();

    AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures2, boolean allMustSucceed2, boolean collectsValues2) {
        super(futures2.size());
        this.futures = (ImmutableCollection) Preconditions.checkNotNull(futures2);
        this.allMustSucceed = allMustSucceed2;
        this.collectsValues = collectsValues2;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean wasInterrupted = wasInterrupted();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        if (immutableCollection != null) {
            return "futures=" + immutableCollection;
        }
        return super.pendingToString();
    }

    /* access modifiers changed from: package-private */
    public final void init() {
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty()) {
            handleAllCompleted();
        } else if (this.allMustSucceed) {
            int index = 0;
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
            while (it.hasNext()) {
                ListenableFuture<? extends InputT> future = (ListenableFuture) it.next();
                future.addListener(new AggregateFuture$$ExternalSyntheticLambda0(this, future, index), MoreExecutors.directExecutor());
                index++;
            }
        } else {
            Runnable listener = new AggregateFuture$$ExternalSyntheticLambda1(this, this.collectsValues ? this.futures : null);
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
            while (it2.hasNext()) {
                ((ListenableFuture) it2.next()).addListener(listener, MoreExecutors.directExecutor());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$com-google-common-util-concurrent-AggregateFuture  reason: not valid java name */
    public /* synthetic */ void m2054lambda$init$0$comgooglecommonutilconcurrentAggregateFuture(ListenableFuture future, int index) {
        try {
            if (future.isCancelled()) {
                this.futures = null;
                cancel(false);
            } else {
                collectValueFromNonCancelledFuture(index, future);
            }
        } finally {
            m2055lambda$init$1$comgooglecommonutilconcurrentAggregateFuture((ImmutableCollection) null);
        }
    }

    private void handleException(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        if (this.allMustSucceed && !setException(throwable) && addCausalChain(getOrInitSeenExceptions(), throwable)) {
            log(throwable);
        } else if (throwable instanceof Error) {
            log(throwable);
        }
    }

    private static void log(Throwable throwable) {
        String message;
        if (throwable instanceof Error) {
            message = "Input Future failed with Error";
        } else {
            message = "Got more than one input Future failure. Logging failures after the first";
        }
        logger.log(Level.SEVERE, message, throwable);
    }

    /* access modifiers changed from: package-private */
    public final void addInitialException(Set<Throwable> seen) {
        Preconditions.checkNotNull(seen);
        if (!isCancelled()) {
            addCausalChain(seen, (Throwable) Objects.requireNonNull(tryInternalFastPathGetFailure()));
        }
    }

    private void collectValueFromNonCancelledFuture(int index, Future<? extends InputT> future) {
        try {
            collectOneValue(index, Futures.getDone(future));
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Error | RuntimeException t) {
            handleException(t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: decrementCountAndMaybeComplete */
    public void m2055lambda$init$1$comgooglecommonutilconcurrentAggregateFuture(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> futuresIfNeedToCollectAtCompletion) {
        int newRemaining = decrementRemainingAndGet();
        Preconditions.checkState(newRemaining >= 0, "Less than 0 remaining futures");
        if (newRemaining == 0) {
            processCompleted(futuresIfNeedToCollectAtCompletion);
        }
    }

    private void processCompleted(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> futuresIfNeedToCollectAtCompletion) {
        if (futuresIfNeedToCollectAtCompletion != null) {
            int i = 0;
            UnmodifiableIterator<? extends Future<? extends InputT>> it = futuresIfNeedToCollectAtCompletion.iterator();
            while (it.hasNext()) {
                Future<? extends InputT> future = (Future) it.next();
                if (!future.isCancelled()) {
                    collectValueFromNonCancelledFuture(i, future);
                }
                i++;
            }
        }
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    /* access modifiers changed from: package-private */
    public void releaseResources(ReleaseResourcesReason reason) {
        Preconditions.checkNotNull(reason);
        this.futures = null;
    }

    private static boolean addCausalChain(Set<Throwable> seen, Throwable param) {
        for (Throwable t = param; t != null; t = t.getCause()) {
            if (!seen.add(t)) {
                return false;
            }
        }
        return true;
    }
}
