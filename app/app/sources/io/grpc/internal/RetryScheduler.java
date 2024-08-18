package io.grpc.internal;

public interface RetryScheduler {
    void reset();

    void schedule(Runnable runnable);
}
