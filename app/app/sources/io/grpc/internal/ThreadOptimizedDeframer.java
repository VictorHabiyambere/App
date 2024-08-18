package io.grpc.internal;

public interface ThreadOptimizedDeframer extends Deframer {
    void request(int i);
}
