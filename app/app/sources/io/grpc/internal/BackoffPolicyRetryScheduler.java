package io.grpc.internal;

import io.grpc.SynchronizationContext;
import io.grpc.internal.BackoffPolicy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class BackoffPolicyRetryScheduler implements RetryScheduler {
    private static final Logger logger = Logger.getLogger(BackoffPolicyRetryScheduler.class.getName());
    private BackoffPolicy policy;
    private final BackoffPolicy.Provider policyProvider;
    private final ScheduledExecutorService scheduledExecutorService;
    private SynchronizationContext.ScheduledHandle scheduledHandle;
    private final SynchronizationContext syncContext;

    BackoffPolicyRetryScheduler(BackoffPolicy.Provider policyProvider2, ScheduledExecutorService scheduledExecutorService2, SynchronizationContext syncContext2) {
        this.policyProvider = policyProvider2;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.syncContext = syncContext2;
    }

    public void schedule(Runnable retryOperation) {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        if (this.policy == null) {
            this.policy = this.policyProvider.get();
        }
        if (this.scheduledHandle == null || !this.scheduledHandle.isPending()) {
            long delayNanos = this.policy.nextBackoffNanos();
            this.scheduledHandle = this.syncContext.schedule(retryOperation, delayNanos, TimeUnit.NANOSECONDS, this.scheduledExecutorService);
            logger.log(Level.FINE, "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(delayNanos));
        }
    }

    public void reset() {
        this.syncContext.throwIfNotInThisSynchronizationContext();
        this.syncContext.execute(new BackoffPolicyRetryScheduler$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$reset$0$io-grpc-internal-BackoffPolicyRetryScheduler  reason: not valid java name */
    public /* synthetic */ void m288lambda$reset$0$iogrpcinternalBackoffPolicyRetryScheduler() {
        if (this.scheduledHandle != null && this.scheduledHandle.isPending()) {
            this.scheduledHandle.cancel();
        }
        this.policy = null;
    }
}
