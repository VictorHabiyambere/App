package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    ForwardingManagedChannel(ManagedChannel delegate2) {
        this.delegate = delegate2;
    }

    public ManagedChannel shutdown() {
        return this.delegate.shutdown();
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public ManagedChannel shutdownNow() {
        return this.delegate.shutdownNow();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.awaitTermination(timeout, unit);
    }

    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    public String authority() {
        return this.delegate.authority();
    }

    public ConnectivityState getState(boolean requestConnection) {
        return this.delegate.getState(requestConnection);
    }

    public void notifyWhenStateChanged(ConnectivityState source, Runnable callback) {
        this.delegate.notifyWhenStateChanged(source, callback);
    }

    public void resetConnectBackoff() {
        this.delegate.resetConnectBackoff();
    }

    public void enterIdle() {
        this.delegate.enterIdle();
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("delegate", (Object) this.delegate).toString();
    }
}
