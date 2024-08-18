package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import java.util.concurrent.Executor;

class FailingClientTransport implements ClientTransport {
    final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;

    FailingClientTransport(Status error2, ClientStreamListener.RpcProgress rpcProgress2) {
        Preconditions.checkArgument(!error2.isOk(), "error must not be OK");
        this.error = error2;
        this.rpcProgress = rpcProgress2;
    }

    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata headers, CallOptions callOptions, ClientStreamTracer[] tracers) {
        return new FailingClientStream(this.error, this.rpcProgress, tracers);
    }

    public void ping(final ClientTransport.PingCallback callback, Executor executor) {
        executor.execute(new Runnable() {
            public void run() {
                callback.onFailure(FailingClientTransport.this.error.asException());
            }
        });
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        ret.set(null);
        return ret;
    }

    public InternalLogId getLogId() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
