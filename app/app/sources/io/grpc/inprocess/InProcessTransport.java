package io.grpc.inprocess;

import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.InsightBuilder;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

final class InProcessTransport implements ServerTransport, ConnectionClientTransport {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    /* access modifiers changed from: private */
    public final SocketAddress address;
    /* access modifiers changed from: private */
    public final Attributes attributes;
    private final String authority;
    /* access modifiers changed from: private */
    public final int clientMaxInboundMetadataSize;
    /* access modifiers changed from: private */
    public ManagedClientTransport.Listener clientTransportListener;
    /* access modifiers changed from: private */
    public final InUseStateAggregator<InProcessStream> inUseState;
    /* access modifiers changed from: private */
    public final boolean includeCauseWithStatus;
    private final InternalLogId logId;
    private final Optional<ServerListener> optionalServerListener;
    private int serverMaxInboundMetadataSize;
    private ScheduledExecutorService serverScheduler;
    private ObjectPool<ScheduledExecutorService> serverSchedulerPool;
    /* access modifiers changed from: private */
    public Attributes serverStreamAttributes;
    /* access modifiers changed from: private */
    public List<ServerStreamTracer.Factory> serverStreamTracerFactories;
    /* access modifiers changed from: private */
    public ServerTransportListener serverTransportListener;
    /* access modifiers changed from: private */
    public boolean shutdown;
    private Status shutdownStatus;
    /* access modifiers changed from: private */
    public final Set<InProcessStream> streams;
    private boolean terminated;
    /* access modifiers changed from: private */
    public Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final String userAgent;

    private InProcessTransport(SocketAddress address2, int maxInboundMetadataSize, String authority2, String userAgent2, Attributes eagAttrs, Optional<ServerListener> optionalServerListener2, boolean includeCauseWithStatus2) {
        this.streams = Collections.newSetFromMap(new IdentityHashMap());
        this.uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    throw new Error(e);
                }
                throw new RuntimeException(e);
            }
        };
        this.inUseState = new InUseStateAggregator<InProcessStream>() {
            /* access modifiers changed from: protected */
            public void handleInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(true);
            }

            /* access modifiers changed from: protected */
            public void handleNotInUse() {
                InProcessTransport.this.clientTransportListener.transportInUse(false);
            }
        };
        this.address = address2;
        this.clientMaxInboundMetadataSize = maxInboundMetadataSize;
        this.authority = authority2;
        this.userAgent = GrpcUtil.getGrpcUserAgent("inprocess", userAgent2);
        Preconditions.checkNotNull(eagAttrs, "eagAttrs");
        this.attributes = Attributes.newBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(GrpcAttributes.ATTR_CLIENT_EAG_ATTRS, eagAttrs).set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, address2).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, address2).build();
        this.optionalServerListener = optionalServerListener2;
        this.logId = InternalLogId.allocate(getClass(), address2.toString());
        this.includeCauseWithStatus = includeCauseWithStatus2;
    }

    public InProcessTransport(SocketAddress address2, int maxInboundMetadataSize, String authority2, String userAgent2, Attributes eagAttrs, boolean includeCauseWithStatus2) {
        this(address2, maxInboundMetadataSize, authority2, userAgent2, eagAttrs, Optional.absent(), includeCauseWithStatus2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    InProcessTransport(String name, int maxInboundMetadataSize, String authority2, String userAgent2, Attributes eagAttrs, ObjectPool<ScheduledExecutorService> serverSchedulerPool2, List<ServerStreamTracer.Factory> serverStreamTracerFactories2, ServerListener serverListener, boolean includeCauseWithStatus2) {
        this(new InProcessSocketAddress(name), maxInboundMetadataSize, authority2, userAgent2, eagAttrs, Optional.of(serverListener), includeCauseWithStatus2);
        String str = name;
        this.serverMaxInboundMetadataSize = maxInboundMetadataSize;
        this.serverSchedulerPool = serverSchedulerPool2;
        this.serverStreamTracerFactories = serverStreamTracerFactories2;
    }

    @CheckReturnValue
    public synchronized Runnable start(ManagedClientTransport.Listener listener) {
        this.clientTransportListener = listener;
        if (this.optionalServerListener.isPresent()) {
            this.serverScheduler = this.serverSchedulerPool.getObject();
            this.serverTransportListener = this.optionalServerListener.get().transportCreated(this);
        } else {
            InProcessServer server = InProcessServer.findServer(this.address);
            if (server != null) {
                this.serverMaxInboundMetadataSize = server.getMaxInboundMetadataSize();
                this.serverSchedulerPool = server.getScheduledExecutorServicePool();
                this.serverScheduler = this.serverSchedulerPool.getObject();
                this.serverStreamTracerFactories = server.getStreamTracerFactories();
                this.serverTransportListener = server.register(this);
            }
        }
        if (this.serverTransportListener == null) {
            this.shutdownStatus = Status.UNAVAILABLE.withDescription("Could not find server: " + this.address);
            final Status localShutdownStatus = this.shutdownStatus;
            return new Runnable() {
                public void run() {
                    synchronized (InProcessTransport.this) {
                        InProcessTransport.this.notifyShutdown(localShutdownStatus);
                        InProcessTransport.this.notifyTerminated();
                    }
                }
            };
        }
        return new Runnable() {
            public void run() {
                synchronized (InProcessTransport.this) {
                    Attributes unused = InProcessTransport.this.serverStreamAttributes = InProcessTransport.this.serverTransportListener.transportReady(Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, InProcessTransport.this.address).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, InProcessTransport.this.address).build());
                    InProcessTransport.this.clientTransportListener.transportReady();
                }
            }
        };
    }

    public synchronized ClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions, ClientStreamTracer[] tracers) {
        int metadataSize;
        StatsTraceContext statsTraceContext = StatsTraceContext.newClientContext(tracers, getAttributes(), headers);
        if (this.shutdownStatus != null) {
            return failedClientStream(statsTraceContext, this.shutdownStatus);
        }
        headers.put(GrpcUtil.USER_AGENT_KEY, this.userAgent);
        if (this.serverMaxInboundMetadataSize == Integer.MAX_VALUE || (metadataSize = metadataSize(headers)) <= this.serverMaxInboundMetadataSize) {
            return new InProcessStream(method, headers, callOptions, this.authority, statsTraceContext).clientStream;
        }
        return failedClientStream(statsTraceContext, Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "Request metadata larger than %d: %d", new Object[]{Integer.valueOf(this.serverMaxInboundMetadataSize), Integer.valueOf(metadataSize)})));
    }

    private ClientStream failedClientStream(final StatsTraceContext statsTraceCtx, final Status status) {
        return new NoopClientStream() {
            public void start(ClientStreamListener listener) {
                statsTraceCtx.clientOutboundHeaders();
                statsTraceCtx.streamClosed(status);
                listener.closed(status, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            }
        };
    }

    public synchronized void ping(final ClientTransport.PingCallback callback, Executor executor) {
        if (this.terminated) {
            final Status shutdownStatus2 = this.shutdownStatus;
            executor.execute(new Runnable() {
                public void run() {
                    callback.onFailure(shutdownStatus2.asRuntimeException());
                }
            });
        } else {
            executor.execute(new Runnable() {
                public void run() {
                    callback.onSuccess(0);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void shutdown(io.grpc.Status r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.shutdown     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r1.shutdownStatus = r2     // Catch:{ all -> 0x0019 }
            r1.notifyShutdown(r2)     // Catch:{ all -> 0x0019 }
            java.util.Set<io.grpc.inprocess.InProcessTransport$InProcessStream> r0 = r1.streams     // Catch:{ all -> 0x0019 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            r1.notifyTerminated()     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.shutdown(io.grpc.Status):void");
    }

    public synchronized void shutdown() {
        shutdown(Status.UNAVAILABLE.withDescription("InProcessTransport shutdown by the server-side"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1.hasNext() == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0021, code lost:
        io.grpc.inprocess.InProcessTransport.InProcessStream.access$700(r1.next()).cancel(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r1 = r0.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdownNow(io.grpc.Status r5) {
        /*
            r4 = this;
            java.lang.String r0 = "reason"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            monitor-enter(r4)
            r4.shutdown(r5)     // Catch:{ all -> 0x0030 }
            boolean r0 = r4.terminated     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            return
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0030 }
            java.util.Set<io.grpc.inprocess.InProcessTransport$InProcessStream> r1 = r4.streams     // Catch:{ all -> 0x0030 }
            r0.<init>(r1)     // Catch:{ all -> 0x0030 }
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            java.util.Iterator r1 = r0.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r1.next()
            io.grpc.inprocess.InProcessTransport$InProcessStream r2 = (io.grpc.inprocess.InProcessTransport.InProcessStream) r2
            io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r3 = r2.clientStream
            r3.cancel(r5)
            goto L_0x001b
        L_0x002f:
            return
        L_0x0030:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.shutdownNow(io.grpc.Status):void");
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("address", (Object) this.address).toString();
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.serverScheduler;
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        ret.set(null);
        return ret;
    }

    /* access modifiers changed from: private */
    public synchronized void notifyShutdown(Status s) {
        if (!this.shutdown) {
            this.shutdown = true;
            this.clientTransportListener.transportShutdown(s);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void notifyTerminated() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.terminated     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            r2.terminated = r0     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r0 = r2.serverScheduler     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001a
            io.grpc.internal.ObjectPool<java.util.concurrent.ScheduledExecutorService> r0 = r2.serverSchedulerPool     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r1 = r2.serverScheduler     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.returnObject(r1)     // Catch:{ all -> 0x002a }
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0     // Catch:{ all -> 0x002a }
            r2.serverScheduler = r0     // Catch:{ all -> 0x002a }
        L_0x001a:
            io.grpc.internal.ManagedClientTransport$Listener r0 = r2.clientTransportListener     // Catch:{ all -> 0x002a }
            r0.transportTerminated()     // Catch:{ all -> 0x002a }
            io.grpc.internal.ServerTransportListener r0 = r2.serverTransportListener     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0028
            io.grpc.internal.ServerTransportListener r0 = r2.serverTransportListener     // Catch:{ all -> 0x002a }
            r0.transportTerminated()     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r2)
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.notifyTerminated():void");
    }

    /* access modifiers changed from: private */
    public static int metadataSize(Metadata metadata) {
        byte[][] serialized = InternalMetadata.serialize(metadata);
        if (serialized == null) {
            return 0;
        }
        long size = 0;
        for (int i = 0; i < serialized.length; i += 2) {
            size += (long) (serialized[i].length + 32 + serialized[i + 1].length);
        }
        return (int) Math.min(size, 2147483647L);
    }

    private class InProcessStream {
        /* access modifiers changed from: private */
        public volatile String authority;
        private final CallOptions callOptions;
        /* access modifiers changed from: private */
        public final InProcessClientStream clientStream;
        /* access modifiers changed from: private */
        public final Metadata headers;
        /* access modifiers changed from: private */
        public final MethodDescriptor<?, ?> method;
        /* access modifiers changed from: private */
        public final InProcessServerStream serverStream;

        private InProcessStream(MethodDescriptor<?, ?> method2, Metadata headers2, CallOptions callOptions2, String authority2, StatsTraceContext statsTraceContext) {
            this.method = (MethodDescriptor) Preconditions.checkNotNull(method2, "method");
            this.headers = (Metadata) Preconditions.checkNotNull(headers2, "headers");
            this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions2, "callOptions");
            this.authority = authority2;
            this.clientStream = new InProcessClientStream(callOptions2, statsTraceContext);
            this.serverStream = new InProcessServerStream(method2, headers2);
        }

        /* access modifiers changed from: private */
        public void streamClosed() {
            synchronized (InProcessTransport.this) {
                boolean justRemovedAnElement = InProcessTransport.this.streams.remove(this);
                if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                    InProcessTransport.this.inUseState.updateObjectInUse(this, false);
                }
                if (InProcessTransport.this.streams.isEmpty() && justRemovedAnElement && InProcessTransport.this.shutdown) {
                    InProcessTransport.this.notifyTerminated();
                }
            }
        }

        private class InProcessServerStream implements ServerStream {
            private Status clientNotifyStatus;
            private Metadata clientNotifyTrailers;
            private ArrayDeque<StreamListener.MessageProducer> clientReceiveQueue = new ArrayDeque<>();
            private int clientRequested;
            private ClientStreamListener clientStreamListener;
            private boolean closed;
            private int outboundSeqNo;
            final StatsTraceContext statsTraceCtx;
            private final SynchronizationContext syncContext = new SynchronizationContext(InProcessTransport.this.uncaughtExceptionHandler);

            InProcessServerStream(MethodDescriptor<?, ?> method, Metadata headers) {
                this.statsTraceCtx = StatsTraceContext.newServerContext(InProcessTransport.this.serverStreamTracerFactories, method.getFullMethodName(), headers);
            }

            /* access modifiers changed from: private */
            public synchronized void setListener(ClientStreamListener listener) {
                this.clientStreamListener = listener;
            }

            public void setListener(ServerStreamListener serverStreamListener) {
                InProcessStream.this.clientStream.setListener(serverStreamListener);
            }

            public void request(int numMessages) {
                if (InProcessStream.this.clientStream.serverRequested(numMessages)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.syncContext.executeLater(new InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda6(this));
                        }
                    }
                }
                this.syncContext.drain();
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$request$0$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m285lambda$request$0$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream() {
                this.clientStreamListener.onReady();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
                r7.syncContext.drain();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
                if (r0 != false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x007e, code lost:
                if (r3 == false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                return true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
                return false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                return false;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean clientRequested(int r8) {
                /*
                    r7 = this;
                    monitor-enter(r7)
                    boolean r0 = r7.closed     // Catch:{ all -> 0x0082 }
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    monitor-exit(r7)     // Catch:{ all -> 0x0082 }
                    return r1
                L_0x0008:
                    int r0 = r7.clientRequested     // Catch:{ all -> 0x0082 }
                    r2 = 1
                    if (r0 <= 0) goto L_0x000f
                    r0 = r2
                    goto L_0x0010
                L_0x000f:
                    r0 = r1
                L_0x0010:
                    int r3 = r7.clientRequested     // Catch:{ all -> 0x0082 }
                    int r3 = r3 + r8
                    r7.clientRequested = r3     // Catch:{ all -> 0x0082 }
                L_0x0015:
                    int r3 = r7.clientRequested     // Catch:{ all -> 0x0082 }
                    if (r3 <= 0) goto L_0x0039
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r7.clientReceiveQueue     // Catch:{ all -> 0x0082 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0082 }
                    if (r3 != 0) goto L_0x0039
                    int r3 = r7.clientRequested     // Catch:{ all -> 0x0082 }
                    int r3 = r3 - r2
                    r7.clientRequested = r3     // Catch:{ all -> 0x0082 }
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r7.clientReceiveQueue     // Catch:{ all -> 0x0082 }
                    java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0082 }
                    io.grpc.internal.StreamListener$MessageProducer r3 = (io.grpc.internal.StreamListener.MessageProducer) r3     // Catch:{ all -> 0x0082 }
                    io.grpc.SynchronizationContext r4 = r7.syncContext     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda0 r5 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda0     // Catch:{ all -> 0x0082 }
                    r5.<init>(r7, r3)     // Catch:{ all -> 0x0082 }
                    r4.executeLater(r5)     // Catch:{ all -> 0x0082 }
                    goto L_0x0015
                L_0x0039:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r7.clientReceiveQueue     // Catch:{ all -> 0x0082 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0082 }
                    if (r3 == 0) goto L_0x006f
                    io.grpc.Status r3 = r7.clientNotifyStatus     // Catch:{ all -> 0x0082 }
                    if (r3 == 0) goto L_0x006f
                    r7.closed = r2     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r3 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r3 = r3.clientStream     // Catch:{ all -> 0x0082 }
                    io.grpc.internal.StatsTraceContext r3 = r3.statsTraceCtx     // Catch:{ all -> 0x0082 }
                    io.grpc.Metadata r4 = r7.clientNotifyTrailers     // Catch:{ all -> 0x0082 }
                    r3.clientInboundTrailers(r4)     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r3 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r3 = r3.clientStream     // Catch:{ all -> 0x0082 }
                    io.grpc.internal.StatsTraceContext r3 = r3.statsTraceCtx     // Catch:{ all -> 0x0082 }
                    io.grpc.Status r4 = r7.clientNotifyStatus     // Catch:{ all -> 0x0082 }
                    r3.streamClosed(r4)     // Catch:{ all -> 0x0082 }
                    io.grpc.Status r3 = r7.clientNotifyStatus     // Catch:{ all -> 0x0082 }
                    io.grpc.Metadata r4 = r7.clientNotifyTrailers     // Catch:{ all -> 0x0082 }
                    io.grpc.SynchronizationContext r5 = r7.syncContext     // Catch:{ all -> 0x0082 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda1 r6 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0082 }
                    r6.<init>(r7, r3, r4)     // Catch:{ all -> 0x0082 }
                    r5.executeLater(r6)     // Catch:{ all -> 0x0082 }
                L_0x006f:
                    int r3 = r7.clientRequested     // Catch:{ all -> 0x0082 }
                    if (r3 <= 0) goto L_0x0075
                    r3 = r2
                    goto L_0x0076
                L_0x0075:
                    r3 = r1
                L_0x0076:
                    monitor-exit(r7)     // Catch:{ all -> 0x0082 }
                    io.grpc.SynchronizationContext r4 = r7.syncContext
                    r4.drain()
                    if (r0 != 0) goto L_0x0081
                    if (r3 == 0) goto L_0x0081
                    r1 = r2
                L_0x0081:
                    return r1
                L_0x0082:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x0082 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessServerStream.clientRequested(int):boolean");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$clientRequested$1$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m281lambda$clientRequested$1$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(StreamListener.MessageProducer producer) {
                this.clientStreamListener.messagesAvailable(producer);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$clientRequested$2$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m282lambda$clientRequested$2$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(Status notifyStatus, Metadata notifyTrailers) {
                this.clientStreamListener.closed(notifyStatus, ClientStreamListener.RpcProgress.PROCESSED, notifyTrailers);
            }

            /* access modifiers changed from: private */
            public void clientCancelled(Status status) {
                internalCancel(status);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
                r8.syncContext.drain();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeMessage(java.io.InputStream r9) {
                /*
                    r8 = this;
                    monitor-enter(r8)
                    boolean r0 = r8.closed     // Catch:{ all -> 0x0064 }
                    if (r0 == 0) goto L_0x0007
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    return
                L_0x0007:
                    io.grpc.internal.StatsTraceContext r0 = r8.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r0.outboundMessage(r1)     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r2 = r8.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r3 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r4 = -1
                    r6 = -1
                    r2.outboundMessageSent(r3, r4, r6)     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r0.inboundMessage(r1)     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r0 = r0.clientStream     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r1 = r0.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r2 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r3 = -1
                    r5 = -1
                    r1.inboundMessageRead(r2, r3, r5)     // Catch:{ all -> 0x0064 }
                    int r0 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    int r0 = r0 + 1
                    r8.outboundSeqNo = r0     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$SingleMessageProducer r0 = new io.grpc.inprocess.InProcessTransport$SingleMessageProducer     // Catch:{ all -> 0x0064 }
                    r1 = 0
                    r0.<init>(r9)     // Catch:{ all -> 0x0064 }
                    int r1 = r8.clientRequested     // Catch:{ all -> 0x0064 }
                    if (r1 <= 0) goto L_0x0058
                    int r1 = r8.clientRequested     // Catch:{ all -> 0x0064 }
                    int r1 = r1 + -1
                    r8.clientRequested = r1     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r1 = r8.syncContext     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda4 r2 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda4     // Catch:{ all -> 0x0064 }
                    r2.<init>(r8, r0)     // Catch:{ all -> 0x0064 }
                    r1.executeLater(r2)     // Catch:{ all -> 0x0064 }
                    goto L_0x005d
                L_0x0058:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r1 = r8.clientReceiveQueue     // Catch:{ all -> 0x0064 }
                    r1.add(r0)     // Catch:{ all -> 0x0064 }
                L_0x005d:
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r0 = r8.syncContext
                    r0.drain()
                    return
                L_0x0064:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessServerStream.writeMessage(java.io.InputStream):void");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$writeMessage$3$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m287lambda$writeMessage$3$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(StreamListener.MessageProducer producer) {
                this.clientStreamListener.messagesAvailable(producer);
            }

            public void flush() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x000e, code lost:
                return r1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized boolean isReady() {
                /*
                    r2 = this;
                    monitor-enter(r2)
                    boolean r0 = r2.closed     // Catch:{ all -> 0x000f }
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    monitor-exit(r2)
                    return r1
                L_0x0008:
                    int r0 = r2.clientRequested     // Catch:{ all -> 0x000f }
                    if (r0 <= 0) goto L_0x000d
                    r1 = 1
                L_0x000d:
                    monitor-exit(r2)
                    return r1
                L_0x000f:
                    r0 = move-exception
                    monitor-exit(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessServerStream.isReady():boolean");
            }

            public void writeHeaders(Metadata headers) {
                int metadataSize;
                if (InProcessTransport.this.clientMaxInboundMetadataSize == Integer.MAX_VALUE || (metadataSize = InProcessTransport.metadataSize(headers)) <= InProcessTransport.this.clientMaxInboundMetadataSize) {
                    synchronized (this) {
                        if (!this.closed) {
                            InProcessStream.this.clientStream.statsTraceCtx.clientInboundHeaders();
                            this.syncContext.executeLater(new InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda3(this, headers));
                            this.syncContext.drain();
                            return;
                        }
                        return;
                    }
                }
                Status serverStatus = Status.CANCELLED.withDescription("Client cancelled the RPC");
                InProcessStream.this.clientStream.serverClosed(serverStatus, serverStatus);
                notifyClientClose(Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "Response header metadata larger than %d: %d", new Object[]{Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize)})), new Metadata());
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$writeHeaders$4$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m286lambda$writeHeaders$4$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(Metadata headers) {
                this.clientStreamListener.headersRead(headers);
            }

            public void close(Status status, Metadata trailers) {
                InProcessStream.this.clientStream.serverClosed(Status.OK, status);
                if (InProcessTransport.this.clientMaxInboundMetadataSize != Integer.MAX_VALUE) {
                    int metadataSize = InProcessTransport.metadataSize(trailers) + (status.getDescription() == null ? 0 : status.getDescription().length());
                    if (metadataSize > InProcessTransport.this.clientMaxInboundMetadataSize) {
                        status = Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "Response header metadata larger than %d: %d", new Object[]{Integer.valueOf(InProcessTransport.this.clientMaxInboundMetadataSize), Integer.valueOf(metadataSize)}));
                        trailers = new Metadata();
                    }
                }
                notifyClientClose(status, trailers);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
                r3.syncContext.drain();
                io.grpc.inprocess.InProcessTransport.InProcessStream.access$2100(r3.this$1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private void notifyClientClose(io.grpc.Status r4, io.grpc.Metadata r5) {
                /*
                    r3 = this;
                    io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport.InProcessStream.this
                    io.grpc.inprocess.InProcessTransport r0 = io.grpc.inprocess.InProcessTransport.this
                    boolean r0 = r0.includeCauseWithStatus
                    io.grpc.Status r0 = io.grpc.inprocess.InProcessTransport.cleanStatus(r4, r0)
                    monitor-enter(r3)
                    boolean r1 = r3.closed     // Catch:{ all -> 0x004f }
                    if (r1 == 0) goto L_0x0013
                    monitor-exit(r3)     // Catch:{ all -> 0x004f }
                    return
                L_0x0013:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r1 = r3.clientReceiveQueue     // Catch:{ all -> 0x004f }
                    boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004f }
                    if (r1 == 0) goto L_0x003f
                    r1 = 1
                    r3.closed = r1     // Catch:{ all -> 0x004f }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r1 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x004f }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r1 = r1.clientStream     // Catch:{ all -> 0x004f }
                    io.grpc.internal.StatsTraceContext r1 = r1.statsTraceCtx     // Catch:{ all -> 0x004f }
                    r1.clientInboundTrailers(r5)     // Catch:{ all -> 0x004f }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r1 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x004f }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream r1 = r1.clientStream     // Catch:{ all -> 0x004f }
                    io.grpc.internal.StatsTraceContext r1 = r1.statsTraceCtx     // Catch:{ all -> 0x004f }
                    r1.streamClosed(r0)     // Catch:{ all -> 0x004f }
                    io.grpc.SynchronizationContext r1 = r3.syncContext     // Catch:{ all -> 0x004f }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda5 r2 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda5     // Catch:{ all -> 0x004f }
                    r2.<init>(r3, r0, r5)     // Catch:{ all -> 0x004f }
                    r1.executeLater(r2)     // Catch:{ all -> 0x004f }
                    goto L_0x0043
                L_0x003f:
                    r3.clientNotifyStatus = r0     // Catch:{ all -> 0x004f }
                    r3.clientNotifyTrailers = r5     // Catch:{ all -> 0x004f }
                L_0x0043:
                    monitor-exit(r3)     // Catch:{ all -> 0x004f }
                    io.grpc.SynchronizationContext r1 = r3.syncContext
                    r1.drain()
                    io.grpc.inprocess.InProcessTransport$InProcessStream r1 = io.grpc.inprocess.InProcessTransport.InProcessStream.this
                    r1.streamClosed()
                    return
                L_0x004f:
                    r1 = move-exception
                    monitor-exit(r3)     // Catch:{ all -> 0x004f }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessServerStream.notifyClientClose(io.grpc.Status, io.grpc.Metadata):void");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$notifyClientClose$5$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m284lambda$notifyClientClose$5$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(Status clientStatus, Metadata trailers) {
                this.clientStreamListener.closed(clientStatus, ClientStreamListener.RpcProgress.PROCESSED, trailers);
            }

            public void cancel(Status status) {
                if (internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                    InProcessStream.this.clientStream.serverClosed(status, status);
                    InProcessStream.this.streamClosed();
                }
            }

            private boolean internalCancel(Status clientStatus) {
                synchronized (this) {
                    if (this.closed) {
                        return false;
                    }
                    this.closed = true;
                    while (true) {
                        StreamListener.MessageProducer poll = this.clientReceiveQueue.poll();
                        StreamListener.MessageProducer producer = poll;
                        if (poll != null) {
                            while (true) {
                                InputStream next = producer.next();
                                InputStream message = next;
                                if (next == null) {
                                    break;
                                }
                                try {
                                    message.close();
                                } catch (Throwable t) {
                                    InProcessTransport.log.log(Level.WARNING, "Exception closing stream", t);
                                }
                            }
                        } else {
                            InProcessStream.this.clientStream.statsTraceCtx.streamClosed(clientStatus);
                            this.syncContext.executeLater(new InProcessTransport$InProcessStream$InProcessServerStream$$ExternalSyntheticLambda2(this, clientStatus));
                            this.syncContext.drain();
                            return true;
                        }
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$internalCancel$6$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessServerStream  reason: not valid java name */
            public /* synthetic */ void m283lambda$internalCancel$6$iogrpcinprocessInProcessTransport$InProcessStream$InProcessServerStream(Status clientStatus) {
                this.clientStreamListener.closed(clientStatus, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            }

            public void setMessageCompression(boolean enable) {
            }

            public void optimizeForDirectExecutor() {
            }

            public void setCompressor(Compressor compressor) {
            }

            public void setDecompressor(Decompressor decompressor) {
            }

            public Attributes getAttributes() {
                return InProcessTransport.this.serverStreamAttributes;
            }

            public String getAuthority() {
                return InProcessStream.this.authority;
            }

            public StatsTraceContext statsTraceContext() {
                return this.statsTraceCtx;
            }

            public int streamId() {
                return -1;
            }
        }

        private class InProcessClientStream implements ClientStream {
            final CallOptions callOptions;
            private boolean closed;
            private int outboundSeqNo;
            private boolean serverNotifyHalfClose;
            private ArrayDeque<StreamListener.MessageProducer> serverReceiveQueue = new ArrayDeque<>();
            private int serverRequested;
            private ServerStreamListener serverStreamListener;
            final StatsTraceContext statsTraceCtx;
            private final SynchronizationContext syncContext = new SynchronizationContext(InProcessTransport.this.uncaughtExceptionHandler);

            InProcessClientStream(CallOptions callOptions2, StatsTraceContext statsTraceContext) {
                this.callOptions = callOptions2;
                this.statsTraceCtx = statsTraceContext;
            }

            /* access modifiers changed from: private */
            public synchronized void setListener(ServerStreamListener listener) {
                this.serverStreamListener = listener;
            }

            public void request(int numMessages) {
                if (InProcessStream.this.serverStream.clientRequested(numMessages)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.syncContext.executeLater(new InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda0(this));
                        }
                    }
                    this.syncContext.drain();
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$request$0$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m277lambda$request$0$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream() {
                this.serverStreamListener.onReady();
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
                r6.syncContext.drain();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
                if (r0 != false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
                if (r3 == false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                return true;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
                return false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                return false;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean serverRequested(int r7) {
                /*
                    r6 = this;
                    monitor-enter(r6)
                    boolean r0 = r6.closed     // Catch:{ all -> 0x0064 }
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                    return r1
                L_0x0008:
                    int r0 = r6.serverRequested     // Catch:{ all -> 0x0064 }
                    r2 = 1
                    if (r0 <= 0) goto L_0x000f
                    r0 = r2
                    goto L_0x0010
                L_0x000f:
                    r0 = r1
                L_0x0010:
                    int r3 = r6.serverRequested     // Catch:{ all -> 0x0064 }
                    int r3 = r3 + r7
                    r6.serverRequested = r3     // Catch:{ all -> 0x0064 }
                L_0x0015:
                    int r3 = r6.serverRequested     // Catch:{ all -> 0x0064 }
                    if (r3 <= 0) goto L_0x0039
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r6.serverReceiveQueue     // Catch:{ all -> 0x0064 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0064 }
                    if (r3 != 0) goto L_0x0039
                    int r3 = r6.serverRequested     // Catch:{ all -> 0x0064 }
                    int r3 = r3 - r2
                    r6.serverRequested = r3     // Catch:{ all -> 0x0064 }
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r6.serverReceiveQueue     // Catch:{ all -> 0x0064 }
                    java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StreamListener$MessageProducer r3 = (io.grpc.internal.StreamListener.MessageProducer) r3     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r4 = r6.syncContext     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda4 r5 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda4     // Catch:{ all -> 0x0064 }
                    r5.<init>(r6, r3)     // Catch:{ all -> 0x0064 }
                    r4.executeLater(r5)     // Catch:{ all -> 0x0064 }
                    goto L_0x0015
                L_0x0039:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r3 = r6.serverReceiveQueue     // Catch:{ all -> 0x0064 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0064 }
                    if (r3 == 0) goto L_0x0051
                    boolean r3 = r6.serverNotifyHalfClose     // Catch:{ all -> 0x0064 }
                    if (r3 == 0) goto L_0x0051
                    r6.serverNotifyHalfClose = r1     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r3 = r6.syncContext     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda5 r4 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda5     // Catch:{ all -> 0x0064 }
                    r4.<init>(r6)     // Catch:{ all -> 0x0064 }
                    r3.executeLater(r4)     // Catch:{ all -> 0x0064 }
                L_0x0051:
                    int r3 = r6.serverRequested     // Catch:{ all -> 0x0064 }
                    if (r3 <= 0) goto L_0x0057
                    r3 = r2
                    goto L_0x0058
                L_0x0057:
                    r3 = r1
                L_0x0058:
                    monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r4 = r6.syncContext
                    r4.drain()
                    if (r0 != 0) goto L_0x0063
                    if (r3 == 0) goto L_0x0063
                    r1 = r2
                L_0x0063:
                    return r1
                L_0x0064:
                    r0 = move-exception
                    monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessClientStream.serverRequested(int):boolean");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$serverRequested$1$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m278lambda$serverRequested$1$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream(StreamListener.MessageProducer producer) {
                this.serverStreamListener.messagesAvailable(producer);
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$serverRequested$2$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m279lambda$serverRequested$2$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream() {
                this.serverStreamListener.halfClosed();
            }

            /* access modifiers changed from: private */
            public void serverClosed(Status serverListenerStatus, Status serverTracerStatus) {
                internalCancel(serverListenerStatus, serverTracerStatus);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
                r8.syncContext.drain();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0063, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void writeMessage(java.io.InputStream r9) {
                /*
                    r8 = this;
                    monitor-enter(r8)
                    boolean r0 = r8.closed     // Catch:{ all -> 0x0064 }
                    if (r0 == 0) goto L_0x0007
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    return
                L_0x0007:
                    io.grpc.internal.StatsTraceContext r0 = r8.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r0.outboundMessage(r1)     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r2 = r8.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r3 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r4 = -1
                    r6 = -1
                    r2.outboundMessageSent(r3, r4, r6)     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream r0 = r0.serverStream     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r0 = r0.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r1 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r0.inboundMessage(r1)     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream r0 = io.grpc.inprocess.InProcessTransport.InProcessStream.this     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessServerStream r0 = r0.serverStream     // Catch:{ all -> 0x0064 }
                    io.grpc.internal.StatsTraceContext r1 = r0.statsTraceCtx     // Catch:{ all -> 0x0064 }
                    int r2 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    r3 = -1
                    r5 = -1
                    r1.inboundMessageRead(r2, r3, r5)     // Catch:{ all -> 0x0064 }
                    int r0 = r8.outboundSeqNo     // Catch:{ all -> 0x0064 }
                    int r0 = r0 + 1
                    r8.outboundSeqNo = r0     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$SingleMessageProducer r0 = new io.grpc.inprocess.InProcessTransport$SingleMessageProducer     // Catch:{ all -> 0x0064 }
                    r1 = 0
                    r0.<init>(r9)     // Catch:{ all -> 0x0064 }
                    int r1 = r8.serverRequested     // Catch:{ all -> 0x0064 }
                    if (r1 <= 0) goto L_0x0058
                    int r1 = r8.serverRequested     // Catch:{ all -> 0x0064 }
                    int r1 = r1 + -1
                    r8.serverRequested = r1     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r1 = r8.syncContext     // Catch:{ all -> 0x0064 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda1 r2 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0064 }
                    r2.<init>(r8, r0)     // Catch:{ all -> 0x0064 }
                    r1.executeLater(r2)     // Catch:{ all -> 0x0064 }
                    goto L_0x005d
                L_0x0058:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r1 = r8.serverReceiveQueue     // Catch:{ all -> 0x0064 }
                    r1.add(r0)     // Catch:{ all -> 0x0064 }
                L_0x005d:
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    io.grpc.SynchronizationContext r0 = r8.syncContext
                    r0.drain()
                    return
                L_0x0064:
                    r0 = move-exception
                    monitor-exit(r8)     // Catch:{ all -> 0x0064 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessClientStream.writeMessage(java.io.InputStream):void");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$writeMessage$3$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m280lambda$writeMessage$3$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream(StreamListener.MessageProducer producer) {
                this.serverStreamListener.messagesAvailable(producer);
            }

            public void flush() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x000e, code lost:
                return r1;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public synchronized boolean isReady() {
                /*
                    r2 = this;
                    monitor-enter(r2)
                    boolean r0 = r2.closed     // Catch:{ all -> 0x000f }
                    r1 = 0
                    if (r0 == 0) goto L_0x0008
                    monitor-exit(r2)
                    return r1
                L_0x0008:
                    int r0 = r2.serverRequested     // Catch:{ all -> 0x000f }
                    if (r0 <= 0) goto L_0x000d
                    r1 = 1
                L_0x000d:
                    monitor-exit(r2)
                    return r1
                L_0x000f:
                    r0 = move-exception
                    monitor-exit(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessClientStream.isReady():boolean");
            }

            public void cancel(Status reason) {
                Status serverStatus = InProcessTransport.cleanStatus(reason, InProcessTransport.this.includeCauseWithStatus);
                if (internalCancel(serverStatus, serverStatus)) {
                    InProcessStream.this.serverStream.clientCancelled(reason);
                    InProcessStream.this.streamClosed();
                }
            }

            private boolean internalCancel(Status serverListenerStatus, Status serverTracerStatus) {
                synchronized (this) {
                    if (this.closed) {
                        return false;
                    }
                    this.closed = true;
                    while (true) {
                        StreamListener.MessageProducer poll = this.serverReceiveQueue.poll();
                        StreamListener.MessageProducer producer = poll;
                        if (poll != null) {
                            while (true) {
                                InputStream next = producer.next();
                                InputStream message = next;
                                if (next == null) {
                                    break;
                                }
                                try {
                                    message.close();
                                } catch (Throwable t) {
                                    InProcessTransport.log.log(Level.WARNING, "Exception closing stream", t);
                                }
                            }
                        } else {
                            InProcessStream.this.serverStream.statsTraceCtx.streamClosed(serverTracerStatus);
                            this.syncContext.executeLater(new InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda2(this, serverListenerStatus));
                            this.syncContext.drain();
                            return true;
                        }
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$internalCancel$4$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m276lambda$internalCancel$4$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream(Status serverListenerStatus) {
                this.serverStreamListener.closed(serverListenerStatus);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
                r2.syncContext.drain();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void halfClose() {
                /*
                    r2 = this;
                    monitor-enter(r2)
                    boolean r0 = r2.closed     // Catch:{ all -> 0x0024 }
                    if (r0 == 0) goto L_0x0007
                    monitor-exit(r2)     // Catch:{ all -> 0x0024 }
                    return
                L_0x0007:
                    java.util.ArrayDeque<io.grpc.internal.StreamListener$MessageProducer> r0 = r2.serverReceiveQueue     // Catch:{ all -> 0x0024 }
                    boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
                    if (r0 == 0) goto L_0x001a
                    io.grpc.SynchronizationContext r0 = r2.syncContext     // Catch:{ all -> 0x0024 }
                    io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda3 r1 = new io.grpc.inprocess.InProcessTransport$InProcessStream$InProcessClientStream$$ExternalSyntheticLambda3     // Catch:{ all -> 0x0024 }
                    r1.<init>(r2)     // Catch:{ all -> 0x0024 }
                    r0.executeLater(r1)     // Catch:{ all -> 0x0024 }
                    goto L_0x001d
                L_0x001a:
                    r0 = 1
                    r2.serverNotifyHalfClose = r0     // Catch:{ all -> 0x0024 }
                L_0x001d:
                    monitor-exit(r2)     // Catch:{ all -> 0x0024 }
                    io.grpc.SynchronizationContext r0 = r2.syncContext
                    r0.drain()
                    return
                L_0x0024:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0024 }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: io.grpc.inprocess.InProcessTransport.InProcessStream.InProcessClientStream.halfClose():void");
            }

            /* access modifiers changed from: package-private */
            /* renamed from: lambda$halfClose$5$io-grpc-inprocess-InProcessTransport$InProcessStream$InProcessClientStream  reason: not valid java name */
            public /* synthetic */ void m275lambda$halfClose$5$iogrpcinprocessInProcessTransport$InProcessStream$InProcessClientStream() {
                this.serverStreamListener.halfClosed();
            }

            public void setMessageCompression(boolean enable) {
            }

            public void setAuthority(String string) {
                String unused = InProcessStream.this.authority = string;
            }

            public void start(ClientStreamListener listener) {
                InProcessStream.this.serverStream.setListener(listener);
                synchronized (InProcessTransport.this) {
                    this.statsTraceCtx.clientOutboundHeaders();
                    InProcessTransport.this.streams.add(InProcessStream.this);
                    if (GrpcUtil.shouldBeCountedForInUse(this.callOptions)) {
                        InProcessTransport.this.inUseState.updateObjectInUse(InProcessStream.this, true);
                    }
                    InProcessTransport.this.serverTransportListener.streamCreated(InProcessStream.this.serverStream, InProcessStream.this.method.getFullMethodName(), InProcessStream.this.headers);
                }
            }

            public Attributes getAttributes() {
                return InProcessTransport.this.attributes;
            }

            public void optimizeForDirectExecutor() {
            }

            public void setCompressor(Compressor compressor) {
            }

            public void setFullStreamDecompression(boolean fullStreamDecompression) {
            }

            public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
            }

            public void setMaxInboundMessageSize(int maxSize) {
            }

            public void setMaxOutboundMessageSize(int maxSize) {
            }

            public void setDeadline(Deadline deadline) {
                InProcessStream.this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
                InProcessStream.this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(Math.max(0, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
            }

            public void appendTimeoutInsight(InsightBuilder insight) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status cleanStatus(Status status, boolean includeCauseWithStatus2) {
        if (status == null) {
            return null;
        }
        Status clientStatus = Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
        if (includeCauseWithStatus2) {
            return clientStatus.withCause(status.getCause());
        }
        return clientStatus;
    }

    private static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        private SingleMessageProducer(InputStream message2) {
            this.message = message2;
        }

        @Nullable
        public InputStream next() {
            InputStream messageToReturn = this.message;
            this.message = null;
            return messageToReturn;
        }
    }
}
