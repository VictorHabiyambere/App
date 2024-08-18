package io.grpc.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

public final class MaxConnectionIdleManager {
    private static final Ticker systemTicker = new Ticker() {
        public long nanoTime() {
            return System.nanoTime();
        }
    };
    /* access modifiers changed from: private */
    public boolean isActive;
    private final long maxConnectionIdleInNanos;
    /* access modifiers changed from: private */
    public long nextIdleMonitorTime;
    private ScheduledExecutorService scheduler;
    /* access modifiers changed from: private */
    public boolean shutdownDelayed;
    /* access modifiers changed from: private */
    @CheckForNull
    public ScheduledFuture<?> shutdownFuture;
    /* access modifiers changed from: private */
    public Runnable shutdownTask;
    /* access modifiers changed from: private */
    public final Ticker ticker;

    public interface Ticker {
        long nanoTime();
    }

    public MaxConnectionIdleManager(long maxConnectionIdleInNanos2) {
        this(maxConnectionIdleInNanos2, systemTicker);
    }

    public MaxConnectionIdleManager(long maxConnectionIdleInNanos2, Ticker ticker2) {
        this.maxConnectionIdleInNanos = maxConnectionIdleInNanos2;
        this.ticker = ticker2;
    }

    public void start(final Runnable closeJob, final ScheduledExecutorService scheduler2) {
        this.scheduler = scheduler2;
        this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        this.shutdownTask = new LogExceptionRunnable(new Runnable() {
            public void run() {
                if (!MaxConnectionIdleManager.this.shutdownDelayed) {
                    closeJob.run();
                    ScheduledFuture unused = MaxConnectionIdleManager.this.shutdownFuture = null;
                } else if (!MaxConnectionIdleManager.this.isActive) {
                    ScheduledFuture unused2 = MaxConnectionIdleManager.this.shutdownFuture = scheduler2.schedule(MaxConnectionIdleManager.this.shutdownTask, MaxConnectionIdleManager.this.nextIdleMonitorTime - MaxConnectionIdleManager.this.ticker.nanoTime(), TimeUnit.NANOSECONDS);
                    boolean unused3 = MaxConnectionIdleManager.this.shutdownDelayed = false;
                }
            }
        });
        this.shutdownFuture = scheduler2.schedule(this.shutdownTask, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
    }

    public void onTransportActive() {
        this.isActive = true;
        this.shutdownDelayed = true;
    }

    public void onTransportIdle() {
        this.isActive = false;
        if (this.shutdownFuture != null) {
            if (this.shutdownFuture.isDone()) {
                this.shutdownDelayed = false;
                this.shutdownFuture = this.scheduler.schedule(this.shutdownTask, this.maxConnectionIdleInNanos, TimeUnit.NANOSECONDS);
                return;
            }
            this.nextIdleMonitorTime = this.ticker.nanoTime() + this.maxConnectionIdleInNanos;
        }
    }

    public void onTransportTermination() {
        if (this.shutdownFuture != null) {
            this.shutdownFuture.cancel(false);
            this.shutdownFuture = null;
        }
    }
}
