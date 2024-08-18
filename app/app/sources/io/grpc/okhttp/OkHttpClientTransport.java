package io.grpc.okhttp;

import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Grpc;
import io.grpc.HttpConnectProxiedSocketAddress;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcAttributes;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.InUseStateAggregator;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Credentials;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import io.grpc.okhttp.internal.proxy.HttpUrl;
import io.grpc.okhttp.internal.proxy.Request;
import io.perfmark.PerfMark;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

class OkHttpClientTransport implements ConnectionClientTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    /* access modifiers changed from: private */
    public final InetSocketAddress address;
    /* access modifiers changed from: private */
    public Attributes attributes;
    /* access modifiers changed from: private */
    public ClientFrameHandler clientFrameHandler;
    SettableFuture<Void> connectedFuture;
    Runnable connectingCallback;
    /* access modifiers changed from: private */
    public final ConnectionSpec connectionSpec;
    /* access modifiers changed from: private */
    public int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public ExceptionHandlingFrameWriter frameWriter;
    private boolean goAwaySent;
    /* access modifiers changed from: private */
    public Status goAwayStatus;
    private boolean hasStream;
    /* access modifiers changed from: private */
    public HostnameVerifier hostnameVerifier;
    private final InUseStateAggregator<OkHttpClientStream> inUseState;
    /* access modifiers changed from: private */
    public final int initialWindowSize;
    /* access modifiers changed from: private */
    public KeepAliveManager keepAliveManager;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    /* access modifiers changed from: private */
    public ManagedClientTransport.Listener listener;
    /* access modifiers changed from: private */
    public final Object lock;
    private final InternalLogId logId;
    /* access modifiers changed from: private */
    public int maxConcurrentStreams;
    /* access modifiers changed from: private */
    public final int maxInboundMetadataSize;
    private final int maxMessageSize;
    private int nextStreamId;
    /* access modifiers changed from: private */
    public OutboundFlowController outboundFlow;
    private final Deque<OkHttpClientStream> pendingStreams;
    /* access modifiers changed from: private */
    public Http2Ping ping;
    @Nullable
    final HttpConnectProxiedSocketAddress proxiedAddr;
    int proxySocketTimeout;
    private final Random random;
    private final ScheduledExecutorService scheduler;
    /* access modifiers changed from: private */
    public InternalChannelz.Security securityInfo;
    private final SerializingExecutor serializingExecutor;
    /* access modifiers changed from: private */
    public Socket socket;
    /* access modifiers changed from: private */
    public final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public SSLSocketFactory sslSocketFactory;
    private boolean stopped;
    private final Supplier<Stopwatch> stopwatchFactory;
    /* access modifiers changed from: private */
    public final Map<Integer, OkHttpClientStream> streams;
    /* access modifiers changed from: private */
    public final Runnable tooManyPingsRunnable;
    private final TransportTracer transportTracer;
    private final boolean useGetForSafeMethods;
    private final String userAgent;
    /* access modifiers changed from: private */
    public final Variant variant;

    static /* synthetic */ int access$2412(OkHttpClientTransport x0, int x1) {
        int i = x0.connectionUnacknowledgedBytesRead + x1;
        x0.connectionUnacknowledgedBytesRead = i;
        return i;
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        Map<ErrorCode, Status> errorToStatus = new EnumMap<>(ErrorCode.class);
        errorToStatus.put(ErrorCode.NO_ERROR, Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
        errorToStatus.put(ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("Protocol error"));
        errorToStatus.put(ErrorCode.INTERNAL_ERROR, Status.INTERNAL.withDescription("Internal error"));
        errorToStatus.put(ErrorCode.FLOW_CONTROL_ERROR, Status.INTERNAL.withDescription("Flow control error"));
        errorToStatus.put(ErrorCode.STREAM_CLOSED, Status.INTERNAL.withDescription("Stream closed"));
        errorToStatus.put(ErrorCode.FRAME_TOO_LARGE, Status.INTERNAL.withDescription("Frame too large"));
        errorToStatus.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
        errorToStatus.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
        errorToStatus.put(ErrorCode.COMPRESSION_ERROR, Status.INTERNAL.withDescription("Compression error"));
        errorToStatus.put(ErrorCode.CONNECT_ERROR, Status.INTERNAL.withDescription("Connect error"));
        errorToStatus.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        errorToStatus.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(errorToStatus);
    }

    public OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory transportFactory, InetSocketAddress address2, String authority, @Nullable String userAgent2, Attributes eagAttrs, @Nullable HttpConnectProxiedSocketAddress proxiedAddr2, Runnable tooManyPingsRunnable2) {
        this(transportFactory, address2, authority, userAgent2, eagAttrs, GrpcUtil.STOPWATCH_SUPPLIER, new Http2(), proxiedAddr2, tooManyPingsRunnable2);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Object, com.google.common.base.Supplier<com.google.common.base.Stopwatch>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OkHttpClientTransport(io.grpc.okhttp.OkHttpChannelBuilder.OkHttpTransportFactory r3, java.net.InetSocketAddress r4, java.lang.String r5, @javax.annotation.Nullable java.lang.String r6, io.grpc.Attributes r7, com.google.common.base.Supplier<com.google.common.base.Stopwatch> r8, io.grpc.okhttp.internal.framed.Variant r9, @javax.annotation.Nullable io.grpc.HttpConnectProxiedSocketAddress r10, java.lang.Runnable r11) {
        /*
            r2 = this;
            r2.<init>()
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r2.random = r0
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.lock = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2.streams = r0
            r0 = 0
            r2.maxConcurrentStreams = r0
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r2.pendingStreams = r0
            io.grpc.okhttp.OkHttpClientTransport$1 r0 = new io.grpc.okhttp.OkHttpClientTransport$1
            r0.<init>()
            r2.inUseState = r0
            r0 = 30000(0x7530, float:4.2039E-41)
            r2.proxySocketTimeout = r0
            java.lang.String r0 = "address"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r4, r0)
            java.net.InetSocketAddress r0 = (java.net.InetSocketAddress) r0
            r2.address = r0
            r2.defaultAuthority = r5
            int r0 = r3.maxMessageSize
            r2.maxMessageSize = r0
            int r0 = r3.flowControlWindow
            r2.initialWindowSize = r0
            java.util.concurrent.Executor r0 = r3.executor
            java.lang.String r1 = "executor"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0
            r2.executor = r0
            io.grpc.internal.SerializingExecutor r0 = new io.grpc.internal.SerializingExecutor
            java.util.concurrent.Executor r1 = r3.executor
            r0.<init>(r1)
            r2.serializingExecutor = r0
            java.util.concurrent.ScheduledExecutorService r0 = r3.scheduledExecutorService
            java.lang.String r1 = "scheduledExecutorService"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0
            r2.scheduler = r0
            r0 = 3
            r2.nextStreamId = r0
            javax.net.SocketFactory r0 = r3.socketFactory
            if (r0 != 0) goto L_0x006e
            javax.net.SocketFactory r0 = javax.net.SocketFactory.getDefault()
            goto L_0x0070
        L_0x006e:
            javax.net.SocketFactory r0 = r3.socketFactory
        L_0x0070:
            r2.socketFactory = r0
            javax.net.ssl.SSLSocketFactory r0 = r3.sslSocketFactory
            r2.sslSocketFactory = r0
            javax.net.ssl.HostnameVerifier r0 = r3.hostnameVerifier
            r2.hostnameVerifier = r0
            io.grpc.okhttp.internal.ConnectionSpec r0 = r3.connectionSpec
            java.lang.String r1 = "connectionSpec"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0, r1)
            io.grpc.okhttp.internal.ConnectionSpec r0 = (io.grpc.okhttp.internal.ConnectionSpec) r0
            r2.connectionSpec = r0
            java.lang.String r0 = "stopwatchFactory"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r8, r0)
            com.google.common.base.Supplier r0 = (com.google.common.base.Supplier) r0
            r2.stopwatchFactory = r0
            java.lang.String r0 = "variant"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r9, r0)
            io.grpc.okhttp.internal.framed.Variant r0 = (io.grpc.okhttp.internal.framed.Variant) r0
            r2.variant = r0
            java.lang.String r0 = "okhttp"
            java.lang.String r0 = io.grpc.internal.GrpcUtil.getGrpcUserAgent(r0, r6)
            r2.userAgent = r0
            r2.proxiedAddr = r10
            java.lang.String r0 = "tooManyPingsRunnable"
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r11, r0)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r2.tooManyPingsRunnable = r0
            int r0 = r3.maxInboundMetadataSize
            r2.maxInboundMetadataSize = r0
            io.grpc.internal.TransportTracer$Factory r0 = r3.transportTracerFactory
            io.grpc.internal.TransportTracer r0 = r0.create()
            r2.transportTracer = r0
            java.lang.Class r0 = r2.getClass()
            java.lang.String r1 = r4.toString()
            io.grpc.InternalLogId r0 = io.grpc.InternalLogId.allocate((java.lang.Class<?>) r0, (java.lang.String) r1)
            r2.logId = r0
            io.grpc.Attributes$Builder r0 = io.grpc.Attributes.newBuilder()
            io.grpc.Attributes$Key<io.grpc.Attributes> r1 = io.grpc.internal.GrpcAttributes.ATTR_CLIENT_EAG_ATTRS
            io.grpc.Attributes$Builder r0 = r0.set(r1, r7)
            io.grpc.Attributes r0 = r0.build()
            r2.attributes = r0
            boolean r0 = r3.useGetForSafeMethods
            r2.useGetForSafeMethods = r0
            r2.initTransportTracer()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.<init>(io.grpc.okhttp.OkHttpChannelBuilder$OkHttpTransportFactory, java.net.InetSocketAddress, java.lang.String, java.lang.String, io.grpc.Attributes, com.google.common.base.Supplier, io.grpc.okhttp.internal.framed.Variant, io.grpc.HttpConnectProxiedSocketAddress, java.lang.Runnable):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    OkHttpClientTransport(OkHttpChannelBuilder.OkHttpTransportFactory transportFactory, String userAgent2, Supplier<Stopwatch> stopwatchFactory2, Variant variant2, @Nullable Runnable connectingCallback2, SettableFuture<Void> connectedFuture2, Runnable tooManyPingsRunnable2) {
        this(transportFactory, new InetSocketAddress("127.0.0.1", 80), "notarealauthority:80", userAgent2, Attributes.EMPTY, stopwatchFactory2, variant2, (HttpConnectProxiedSocketAddress) null, tooManyPingsRunnable2);
        this.connectingCallback = connectingCallback2;
        this.connectedFuture = (SettableFuture) Preconditions.checkNotNull(connectedFuture2, "connectedFuture");
    }

    /* access modifiers changed from: package-private */
    public boolean isUsingPlaintext() {
        return this.sslSocketFactory == null;
    }

    private void initTransportTracer() {
        synchronized (this.lock) {
            this.transportTracer.setFlowControlWindowReader(new TransportTracer.FlowControlReader() {
                public TransportTracer.FlowControlWindows read() {
                    TransportTracer.FlowControlWindows flowControlWindows;
                    synchronized (OkHttpClientTransport.this.lock) {
                        flowControlWindows = new TransportTracer.FlowControlWindows(OkHttpClientTransport.this.outboundFlow == null ? -1 : (long) OkHttpClientTransport.this.outboundFlow.windowUpdate((OutboundFlowController.StreamState) null, 0), (long) (((float) OkHttpClientTransport.this.initialWindowSize) * 0.5f));
                    }
                    return flowControlWindows;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void enableKeepAlive(boolean enable, long keepAliveTimeNanos2, long keepAliveTimeoutNanos2, boolean keepAliveWithoutCalls2) {
        this.enableKeepAlive = enable;
        this.keepAliveTimeNanos = keepAliveTimeNanos2;
        this.keepAliveTimeoutNanos = keepAliveTimeoutNanos2;
        this.keepAliveWithoutCalls = keepAliveWithoutCalls2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        r3.addCallback(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ping(io.grpc.internal.ClientTransport.PingCallback r10, java.util.concurrent.Executor r11) {
        /*
            r9 = this;
            r0 = 0
            java.lang.Object r2 = r9.lock
            monitor-enter(r2)
            io.grpc.okhttp.ExceptionHandlingFrameWriter r3 = r9.frameWriter     // Catch:{ all -> 0x0058 }
            r4 = 0
            if (r3 == 0) goto L_0x000c
            r3 = 1
            goto L_0x000d
        L_0x000c:
            r3 = r4
        L_0x000d:
            com.google.common.base.Preconditions.checkState(r3)     // Catch:{ all -> 0x0058 }
            boolean r3 = r9.stopped     // Catch:{ all -> 0x0058 }
            if (r3 == 0) goto L_0x001d
            java.lang.Throwable r3 = r9.getPingFailure()     // Catch:{ all -> 0x0058 }
            io.grpc.internal.Http2Ping.notifyFailed(r10, r11, r3)     // Catch:{ all -> 0x0058 }
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            return
        L_0x001d:
            io.grpc.internal.Http2Ping r3 = r9.ping     // Catch:{ all -> 0x0058 }
            if (r3 == 0) goto L_0x0025
            io.grpc.internal.Http2Ping r3 = r9.ping     // Catch:{ all -> 0x0058 }
            r5 = 0
            goto L_0x0046
        L_0x0025:
            java.util.Random r3 = r9.random     // Catch:{ all -> 0x0058 }
            long r5 = r3.nextLong()     // Catch:{ all -> 0x0058 }
            r0 = r5
            com.google.common.base.Supplier<com.google.common.base.Stopwatch> r3 = r9.stopwatchFactory     // Catch:{ all -> 0x0058 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0058 }
            com.google.common.base.Stopwatch r3 = (com.google.common.base.Stopwatch) r3     // Catch:{ all -> 0x0058 }
            r3.start()     // Catch:{ all -> 0x0058 }
            io.grpc.internal.Http2Ping r5 = new io.grpc.internal.Http2Ping     // Catch:{ all -> 0x0058 }
            r5.<init>(r0, r3)     // Catch:{ all -> 0x0058 }
            r9.ping = r5     // Catch:{ all -> 0x0058 }
            r6 = 1
            io.grpc.internal.TransportTracer r7 = r9.transportTracer     // Catch:{ all -> 0x0058 }
            r7.reportKeepAliveSent()     // Catch:{ all -> 0x0058 }
            r3 = r5
            r5 = r6
        L_0x0046:
            if (r5 == 0) goto L_0x0053
            io.grpc.okhttp.ExceptionHandlingFrameWriter r6 = r9.frameWriter     // Catch:{ all -> 0x0058 }
            r7 = 32
            long r7 = r0 >>> r7
            int r7 = (int) r7     // Catch:{ all -> 0x0058 }
            int r8 = (int) r0     // Catch:{ all -> 0x0058 }
            r6.ping(r4, r7, r8)     // Catch:{ all -> 0x0058 }
        L_0x0053:
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            r3.addCallback(r10, r11)
            return
        L_0x0058:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0058 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.ping(io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor):void");
    }

    public OkHttpClientStream newStream(MethodDescriptor<?, ?> method, Metadata headers, CallOptions callOptions, ClientStreamTracer[] tracers) {
        Object obj;
        Metadata metadata = headers;
        Preconditions.checkNotNull(method, "method");
        Preconditions.checkNotNull(metadata, "headers");
        StatsTraceContext statsTraceContext = StatsTraceContext.newClientContext(tracers, getAttributes(), metadata);
        Object obj2 = this.lock;
        synchronized (obj2) {
            try {
                ExceptionHandlingFrameWriter exceptionHandlingFrameWriter = this.frameWriter;
                OutboundFlowController outboundFlowController = this.outboundFlow;
                Object obj3 = this.lock;
                int i = this.maxMessageSize;
                int i2 = this.initialWindowSize;
                String str = this.defaultAuthority;
                String str2 = this.userAgent;
                TransportTracer transportTracer2 = this.transportTracer;
                obj = obj2;
                OkHttpClientStream okHttpClientStream = new OkHttpClientStream(method, headers, exceptionHandlingFrameWriter, this, outboundFlowController, obj3, i, i2, str, str2, statsTraceContext, transportTracer2, callOptions, this.useGetForSafeMethods);
                return okHttpClientStream;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void streamReadyToStart(OkHttpClientStream clientStream) {
        if (this.goAwayStatus != null) {
            clientStream.transportState().transportReportStatus(this.goAwayStatus, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
        } else if (this.streams.size() >= this.maxConcurrentStreams) {
            this.pendingStreams.add(clientStream);
            setInUse(clientStream);
        } else {
            startStream(clientStream);
        }
    }

    private void startStream(OkHttpClientStream stream) {
        Preconditions.checkState(stream.transportState().id() == -1, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), stream);
        setInUse(stream);
        stream.transportState().start(this.nextStreamId);
        if (!(stream.getType() == MethodDescriptor.MethodType.UNARY || stream.getType() == MethodDescriptor.MethodType.SERVER_STREAMING) || stream.useGet()) {
            this.frameWriter.flush();
        }
        if (this.nextStreamId >= 2147483645) {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
            return;
        }
        this.nextStreamId += 2;
    }

    /* access modifiers changed from: private */
    public boolean startPendingStreams() {
        boolean hasStreamStarted = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            hasStreamStarted = true;
        }
        return hasStreamStarted;
    }

    /* access modifiers changed from: package-private */
    public void removePendingStream(OkHttpClientStream pendingStream) {
        this.pendingStreams.remove(pendingStream);
        maybeClearInUse(pendingStream);
    }

    /* JADX INFO: finally extract failed */
    public Runnable start(ManagedClientTransport.Listener listener2) {
        this.listener = (ManagedClientTransport.Listener) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.enableKeepAlive) {
            this.keepAliveManager = new KeepAliveManager(new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
            this.keepAliveManager.onTransportStarted();
        }
        final AsyncSink asyncSink = AsyncSink.sink(this.serializingExecutor, this, 10000);
        FrameWriter rawFrameWriter = asyncSink.limitControlFramesWriter(this.variant.newWriter(Okio.buffer((Sink) asyncSink), true));
        synchronized (this.lock) {
            this.frameWriter = new ExceptionHandlingFrameWriter(this, rawFrameWriter);
            this.outboundFlow = new OutboundFlowController(this, this.frameWriter);
        }
        final CountDownLatch latch = new CountDownLatch(1);
        this.serializingExecutor.execute(new Runnable() {
            public void run() {
                Socket sock;
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                BufferedSource source = Okio.buffer((Source) new Source() {
                    public long read(Buffer sink, long byteCount) {
                        return -1;
                    }

                    public Timeout timeout() {
                        return Timeout.NONE;
                    }

                    public void close() {
                    }
                });
                SSLSession sslSession = null;
                try {
                    if (OkHttpClientTransport.this.proxiedAddr == null) {
                        sock = OkHttpClientTransport.this.socketFactory.createSocket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                    } else if (OkHttpClientTransport.this.proxiedAddr.getProxyAddress() instanceof InetSocketAddress) {
                        sock = OkHttpClientTransport.this.createHttpProxySocket(OkHttpClientTransport.this.proxiedAddr.getTargetAddress(), (InetSocketAddress) OkHttpClientTransport.this.proxiedAddr.getProxyAddress(), OkHttpClientTransport.this.proxiedAddr.getUsername(), OkHttpClientTransport.this.proxiedAddr.getPassword());
                    } else {
                        throw Status.INTERNAL.withDescription("Unsupported SocketAddress implementation " + OkHttpClientTransport.this.proxiedAddr.getProxyAddress().getClass()).asException();
                    }
                    if (OkHttpClientTransport.this.sslSocketFactory != null) {
                        SSLSocket sslSocket = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, sock, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                        sslSession = sslSocket.getSession();
                        sock = sslSocket;
                    }
                    sock.setTcpNoDelay(true);
                    BufferedSource source2 = Okio.buffer(Okio.source(sock));
                    asyncSink.becomeConnected(Okio.sink(sock), sock);
                    Attributes unused = OkHttpClientTransport.this.attributes = OkHttpClientTransport.this.attributes.toBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, sock.getRemoteSocketAddress()).set(Grpc.TRANSPORT_ATTR_LOCAL_ADDR, sock.getLocalSocketAddress()).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sslSession).set(GrpcAttributes.ATTR_SECURITY_LEVEL, sslSession == null ? SecurityLevel.NONE : SecurityLevel.PRIVACY_AND_INTEGRITY).build();
                    ClientFrameHandler unused2 = OkHttpClientTransport.this.clientFrameHandler = new ClientFrameHandler(OkHttpClientTransport.this.variant.newReader(source2, true));
                    synchronized (OkHttpClientTransport.this.lock) {
                        Socket unused3 = OkHttpClientTransport.this.socket = (Socket) Preconditions.checkNotNull(sock, "socket");
                        if (sslSession != null) {
                            InternalChannelz.Security unused4 = OkHttpClientTransport.this.securityInfo = new InternalChannelz.Security(new InternalChannelz.Tls(sslSession));
                        }
                    }
                } catch (StatusException e2) {
                    OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, e2.getStatus());
                    ClientFrameHandler unused5 = OkHttpClientTransport.this.clientFrameHandler = new ClientFrameHandler(OkHttpClientTransport.this.variant.newReader(source, true));
                } catch (Exception e3) {
                    OkHttpClientTransport.this.onException(e3);
                    ClientFrameHandler unused6 = OkHttpClientTransport.this.clientFrameHandler = new ClientFrameHandler(OkHttpClientTransport.this.variant.newReader(source, true));
                } catch (Throwable th) {
                    ClientFrameHandler unused7 = OkHttpClientTransport.this.clientFrameHandler = new ClientFrameHandler(OkHttpClientTransport.this.variant.newReader(source, true));
                    throw th;
                }
            }
        });
        try {
            sendConnectionPrefaceAndSettings();
            latch.countDown();
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    if (OkHttpClientTransport.this.connectingCallback != null) {
                        OkHttpClientTransport.this.connectingCallback.run();
                    }
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        int unused = OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        boolean unused2 = OkHttpClientTransport.this.startPendingStreams();
                    }
                    if (OkHttpClientTransport.this.connectedFuture != null) {
                        OkHttpClientTransport.this.connectedFuture.set(null);
                    }
                }
            });
            return null;
        } catch (Throwable th) {
            latch.countDown();
            throw th;
        }
    }

    private void sendConnectionPrefaceAndSettings() {
        synchronized (this.lock) {
            this.frameWriter.connectionPreface();
            Settings settings = new Settings();
            OkHttpSettingsUtil.set(settings, 7, this.initialWindowSize);
            this.frameWriter.settings(settings);
            if (this.initialWindowSize > 65535) {
                this.frameWriter.windowUpdate(0, (long) (this.initialWindowSize - 65535));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.Socket createHttpProxySocket(java.net.InetSocketAddress r17, java.net.InetSocketAddress r18, java.lang.String r19, java.lang.String r20) throws io.grpc.StatusException {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "\r\n"
            r2 = 0
            java.net.InetAddress r3 = r18.getAddress()     // Catch:{ IOException -> 0x011c }
            if (r3 == 0) goto L_0x001b
            javax.net.SocketFactory r3 = r1.socketFactory     // Catch:{ IOException -> 0x011c }
            java.net.InetAddress r4 = r18.getAddress()     // Catch:{ IOException -> 0x011c }
            int r5 = r18.getPort()     // Catch:{ IOException -> 0x011c }
            java.net.Socket r3 = r3.createSocket(r4, r5)     // Catch:{ IOException -> 0x011c }
            r2 = r3
            goto L_0x002a
        L_0x001b:
            javax.net.SocketFactory r3 = r1.socketFactory     // Catch:{ IOException -> 0x011c }
            java.lang.String r4 = r18.getHostName()     // Catch:{ IOException -> 0x011c }
            int r5 = r18.getPort()     // Catch:{ IOException -> 0x011c }
            java.net.Socket r3 = r3.createSocket(r4, r5)     // Catch:{ IOException -> 0x011c }
            r2 = r3
        L_0x002a:
            r3 = 1
            r2.setTcpNoDelay(r3)     // Catch:{ IOException -> 0x011c }
            int r3 = r1.proxySocketTimeout     // Catch:{ IOException -> 0x011c }
            r2.setSoTimeout(r3)     // Catch:{ IOException -> 0x011c }
            okio.Source r3 = okio.Okio.source((java.net.Socket) r2)     // Catch:{ IOException -> 0x011c }
            okio.Sink r4 = okio.Okio.sink((java.net.Socket) r2)     // Catch:{ IOException -> 0x011c }
            okio.BufferedSink r4 = okio.Okio.buffer((okio.Sink) r4)     // Catch:{ IOException -> 0x011c }
            r5 = r17
            r6 = r19
            r7 = r20
            io.grpc.okhttp.internal.proxy.Request r8 = r1.createHttpProxyRequest(r5, r6, r7)     // Catch:{ IOException -> 0x011a }
            io.grpc.okhttp.internal.proxy.HttpUrl r9 = r8.httpUrl()     // Catch:{ IOException -> 0x011a }
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ IOException -> 0x011a }
            java.lang.String r11 = "CONNECT %s:%d HTTP/1.1"
            java.lang.String r12 = r9.host()     // Catch:{ IOException -> 0x011a }
            int r13 = r9.port()     // Catch:{ IOException -> 0x011a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x011a }
            java.lang.Object[] r12 = new java.lang.Object[]{r12, r13}     // Catch:{ IOException -> 0x011a }
            java.lang.String r10 = java.lang.String.format(r10, r11, r12)     // Catch:{ IOException -> 0x011a }
            okio.BufferedSink r11 = r4.writeUtf8(r10)     // Catch:{ IOException -> 0x011a }
            r11.writeUtf8(r0)     // Catch:{ IOException -> 0x011a }
            r11 = 0
            io.grpc.okhttp.internal.Headers r12 = r8.headers()     // Catch:{ IOException -> 0x011a }
            int r12 = r12.size()     // Catch:{ IOException -> 0x011a }
        L_0x0075:
            if (r11 >= r12) goto L_0x009b
            io.grpc.okhttp.internal.Headers r13 = r8.headers()     // Catch:{ IOException -> 0x011a }
            java.lang.String r13 = r13.name(r11)     // Catch:{ IOException -> 0x011a }
            okio.BufferedSink r13 = r4.writeUtf8(r13)     // Catch:{ IOException -> 0x011a }
            java.lang.String r14 = ": "
            okio.BufferedSink r13 = r13.writeUtf8(r14)     // Catch:{ IOException -> 0x011a }
            io.grpc.okhttp.internal.Headers r14 = r8.headers()     // Catch:{ IOException -> 0x011a }
            java.lang.String r14 = r14.value(r11)     // Catch:{ IOException -> 0x011a }
            okio.BufferedSink r13 = r13.writeUtf8(r14)     // Catch:{ IOException -> 0x011a }
            r13.writeUtf8(r0)     // Catch:{ IOException -> 0x011a }
            int r11 = r11 + 1
            goto L_0x0075
        L_0x009b:
            r4.writeUtf8(r0)     // Catch:{ IOException -> 0x011a }
            r4.flush()     // Catch:{ IOException -> 0x011a }
            java.lang.String r0 = readUtf8LineStrictUnbuffered(r3)     // Catch:{ IOException -> 0x011a }
            io.grpc.okhttp.internal.StatusLine r0 = io.grpc.okhttp.internal.StatusLine.parse(r0)     // Catch:{ IOException -> 0x011a }
            r11 = r0
        L_0x00aa:
            java.lang.String r0 = readUtf8LineStrictUnbuffered(r3)     // Catch:{ IOException -> 0x011a }
            java.lang.String r12 = ""
            boolean r0 = r0.equals(r12)     // Catch:{ IOException -> 0x011a }
            if (r0 != 0) goto L_0x00b7
            goto L_0x00aa
        L_0x00b7:
            int r0 = r11.code     // Catch:{ IOException -> 0x011a }
            r12 = 200(0xc8, float:2.8E-43)
            if (r0 < r12) goto L_0x00c8
            int r0 = r11.code     // Catch:{ IOException -> 0x011a }
            r12 = 300(0x12c, float:4.2E-43)
            if (r0 >= r12) goto L_0x00c8
            r0 = 0
            r2.setSoTimeout(r0)     // Catch:{ IOException -> 0x011a }
            return r2
        L_0x00c8:
            okio.Buffer r0 = new okio.Buffer     // Catch:{ IOException -> 0x011a }
            r0.<init>()     // Catch:{ IOException -> 0x011a }
            r12 = r0
            r2.shutdownOutput()     // Catch:{ IOException -> 0x00d7 }
            r13 = 1024(0x400, double:5.06E-321)
            r3.read(r12, r13)     // Catch:{ IOException -> 0x00d7 }
            goto L_0x00f2
        L_0x00d7:
            r0 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x011a }
            r13.<init>()     // Catch:{ IOException -> 0x011a }
            java.lang.String r14 = "Unable to read body: "
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x011a }
            java.lang.String r14 = r0.toString()     // Catch:{ IOException -> 0x011a }
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch:{ IOException -> 0x011a }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x011a }
            r12.writeUtf8((java.lang.String) r13)     // Catch:{ IOException -> 0x011a }
        L_0x00f2:
            r2.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
            r0 = move-exception
        L_0x00f7:
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ IOException -> 0x011a }
            java.lang.String r13 = "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s"
            int r14 = r11.code     // Catch:{ IOException -> 0x011a }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ IOException -> 0x011a }
            java.lang.String r15 = r11.message     // Catch:{ IOException -> 0x011a }
            java.lang.String r1 = r12.readUtf8()     // Catch:{ IOException -> 0x011a }
            java.lang.Object[] r1 = new java.lang.Object[]{r14, r15, r1}     // Catch:{ IOException -> 0x011a }
            java.lang.String r0 = java.lang.String.format(r0, r13, r1)     // Catch:{ IOException -> 0x011a }
            io.grpc.Status r1 = io.grpc.Status.UNAVAILABLE     // Catch:{ IOException -> 0x011a }
            io.grpc.Status r1 = r1.withDescription(r0)     // Catch:{ IOException -> 0x011a }
            io.grpc.StatusException r1 = r1.asException()     // Catch:{ IOException -> 0x011a }
            throw r1     // Catch:{ IOException -> 0x011a }
        L_0x011a:
            r0 = move-exception
            goto L_0x0123
        L_0x011c:
            r0 = move-exception
            r5 = r17
            r6 = r19
            r7 = r20
        L_0x0123:
            if (r2 == 0) goto L_0x0128
            io.grpc.internal.GrpcUtil.closeQuietly((java.io.Closeable) r2)
        L_0x0128:
            io.grpc.Status r1 = io.grpc.Status.UNAVAILABLE
            java.lang.String r3 = "Failed trying to connect with proxy"
            io.grpc.Status r1 = r1.withDescription(r3)
            io.grpc.Status r1 = r1.withCause(r0)
            io.grpc.StatusException r1 = r1.asException()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.createHttpProxySocket(java.net.InetSocketAddress, java.net.InetSocketAddress, java.lang.String, java.lang.String):java.net.Socket");
    }

    private Request createHttpProxyRequest(InetSocketAddress address2, String proxyUsername, String proxyPassword) {
        HttpUrl tunnelUrl = new HttpUrl.Builder().scheme(ProxyConfig.MATCH_HTTPS).host(address2.getHostName()).port(address2.getPort()).build();
        Request.Builder request = new Request.Builder().url(tunnelUrl).header(HttpHeaders.HOST, tunnelUrl.host() + ":" + tunnelUrl.port()).header(HttpHeaders.USER_AGENT, this.userAgent);
        if (!(proxyUsername == null || proxyPassword == null)) {
            request.header(HttpHeaders.PROXY_AUTHORIZATION, Credentials.basic(proxyUsername, proxyPassword));
        }
        return request.build();
    }

    private static String readUtf8LineStrictUnbuffered(Source source) throws IOException {
        Buffer buffer = new Buffer();
        while (source.read(buffer, 1) != -1) {
            if (buffer.getByte(buffer.size() - 1) == 10) {
                return buffer.readUtf8LineStrict();
            }
        }
        throw new EOFException("\\n not found: " + buffer.readByteString().hex());
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("logId", this.logId.getId()).add("address", (Object) this.address).toString();
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    /* access modifiers changed from: package-private */
    public String getOverridenHost() {
        URI uri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (uri.getHost() != null) {
            return uri.getHost();
        }
        return this.defaultAuthority;
    }

    /* access modifiers changed from: package-private */
    public int getOverridenPort() {
        URI uri = GrpcUtil.authorityToUri(this.defaultAuthority);
        if (uri.getPort() != -1) {
            return uri.getPort();
        }
        return this.address.getPort();
    }

    public void shutdown(Status reason) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = reason;
                this.listener.transportShutdown(this.goAwayStatus);
                stopIfNecessary();
            }
        }
    }

    public void shutdownNow(Status reason) {
        shutdown(reason);
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> entry = it.next();
                it.remove();
                entry.getValue().transportState().transportReportStatus(reason, false, new Metadata());
                maybeClearInUse(entry.getValue());
            }
            for (OkHttpClientStream stream : this.pendingStreams) {
                stream.transportState().transportReportStatus(reason, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                maybeClearInUse(stream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public OutboundFlowController.StreamState[] getActiveStreams() {
        OutboundFlowController.StreamState[] flowStreams;
        synchronized (this.lock) {
            flowStreams = new OutboundFlowController.StreamState[this.streams.size()];
            int i = 0;
            for (OkHttpClientStream stream : this.streams.values()) {
                flowStreams[i] = stream.transportState().getOutboundFlowState();
                i++;
            }
        }
        return flowStreams;
    }

    /* access modifiers changed from: package-private */
    public ClientFrameHandler getHandler() {
        return this.clientFrameHandler;
    }

    /* access modifiers changed from: package-private */
    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* access modifiers changed from: package-private */
    public int getPendingStreamSize() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public void setNextStreamId(int nextStreamId2) {
        synchronized (this.lock) {
            this.nextStreamId = nextStreamId2;
        }
    }

    public void onException(Throwable failureCause) {
        Preconditions.checkNotNull(failureCause, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(failureCause));
    }

    /* access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String moreDetail) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(moreDetail));
    }

    /* access modifiers changed from: private */
    public void startGoAway(int lastKnownStreamId, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> entry = it.next();
                if (entry.getKey().intValue() > lastKnownStreamId) {
                    it.remove();
                    entry.getValue().transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.REFUSED, false, new Metadata());
                    maybeClearInUse(entry.getValue());
                }
            }
            for (OkHttpClientStream stream : this.pendingStreams) {
                stream.transportState().transportReportStatus(status, ClientStreamListener.RpcProgress.MISCARRIED, true, new Metadata());
                maybeClearInUse(stream);
            }
            this.pendingStreams.clear();
            stopIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public void finishStream(int streamId, @Nullable Status status, ClientStreamListener.RpcProgress rpcProgress, boolean stopDelivery, @Nullable ErrorCode errorCode, @Nullable Metadata trailers) {
        synchronized (this.lock) {
            OkHttpClientStream stream = this.streams.remove(Integer.valueOf(streamId));
            if (stream != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                }
                if (status != null) {
                    stream.transportState().transportReportStatus(status, rpcProgress, stopDelivery, trailers != null ? trailers : new Metadata());
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse(stream);
                }
            }
        }
    }

    private void stopIfNecessary() {
        if (this.goAwayStatus != null && this.streams.isEmpty() && this.pendingStreams.isEmpty() && !this.stopped) {
            this.stopped = true;
            if (this.keepAliveManager != null) {
                this.keepAliveManager.onTransportTermination();
            }
            if (this.ping != null) {
                this.ping.failed(getPingFailure());
                this.ping = null;
            }
            if (!this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
            }
            this.frameWriter.close();
        }
    }

    private void maybeClearInUse(OkHttpClientStream stream) {
        if (this.hasStream && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.hasStream = false;
            if (this.keepAliveManager != null) {
                this.keepAliveManager.onTransportIdle();
            }
        }
        if (stream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(stream, false);
        }
    }

    private void setInUse(OkHttpClientStream stream) {
        if (!this.hasStream) {
            this.hasStream = true;
            if (this.keepAliveManager != null) {
                this.keepAliveManager.onTransportActive();
            }
        }
        if (stream.shouldBeCountedForInUse()) {
            this.inUseState.updateObjectInUse(stream, true);
        }
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                StatusException asException = this.goAwayStatus.asException();
                return asException;
            }
            StatusException asException2 = Status.UNAVAILABLE.withDescription("Connection closed").asException();
            return asException2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean mayHaveCreatedStream(int streamId) {
        boolean z;
        synchronized (this.lock) {
            if (streamId < this.nextStreamId) {
                z = true;
                if ((streamId & 1) == 1) {
                }
            }
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public OkHttpClientStream getStream(int streamId) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(streamId));
        }
        return okHttpClientStream;
    }

    static Status toGrpcStatus(ErrorCode code) {
        Status status = ERROR_CODE_TO_STATUS.get(code);
        return status != null ? status : Status.UNKNOWN.withDescription("Unknown http2 error code: " + code.httpCode);
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        SettableFuture<InternalChannelz.SocketStats> ret = SettableFuture.create();
        synchronized (this.lock) {
            if (this.socket == null) {
                ret.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), (SocketAddress) null, (SocketAddress) null, new InternalChannelz.SocketOptions.Builder().build(), (InternalChannelz.Security) null));
            } else {
                ret.set(new InternalChannelz.SocketStats(this.transportTracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.getSocketOptions(this.socket), this.securityInfo));
            }
        }
        return ret;
    }

    class ClientFrameHandler implements FrameReader.Handler, Runnable {
        boolean firstSettings = true;
        FrameReader frameReader;
        private final OkHttpFrameLogger logger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpClientTransport.class);

        ClientFrameHandler(FrameReader frameReader2) {
            this.frameReader = frameReader2;
        }

        public void run() {
            String str;
            Status status;
            String threadName = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.frameReader.nextFrame(this)) {
                try {
                    if (OkHttpClientTransport.this.keepAliveManager != null) {
                        OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                    }
                } catch (Throwable t) {
                    try {
                        OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("error in frame handler").withCause(t));
                    } finally {
                        try {
                            this.frameReader.close();
                        } catch (IOException ex) {
                            str = "Exception closing frame reader";
                            OkHttpClientTransport.log.log(Level.INFO, str, ex);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        Thread.currentThread().setName(threadName);
                    }
                }
            }
            synchronized (OkHttpClientTransport.this.lock) {
                status = OkHttpClientTransport.this.goAwayStatus;
            }
            if (status == null) {
                status = Status.UNAVAILABLE.withDescription("End of stream or IOException");
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, status);
            try {
                this.frameReader.close();
            } catch (IOException e) {
                ex = e;
            }
        }

        public void data(boolean inFinished, int streamId, BufferedSource in, int length) throws IOException {
            this.logger.logData(OkHttpFrameLogger.Direction.INBOUND, streamId, in.getBuffer(), length, inFinished);
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(streamId);
            if (stream != null) {
                in.require((long) length);
                Buffer buf = new Buffer();
                buf.write(in.getBuffer(), (long) length);
                PerfMark.event("OkHttpClientTransport$ClientFrameHandler.data", stream.transportState().tag());
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportState().transportDataReceived(buf, inFinished);
                }
            } else if (OkHttpClientTransport.this.mayHaveCreatedStream(streamId)) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.rstStream(streamId, ErrorCode.STREAM_CLOSED);
                }
                in.skip((long) length);
            } else {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + streamId);
                return;
            }
            OkHttpClientTransport.access$2412(OkHttpClientTransport.this, length);
            if (((float) OkHttpClientTransport.this.connectionUnacknowledgedBytesRead) >= ((float) OkHttpClientTransport.this.initialWindowSize) * 0.5f) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.windowUpdate(0, (long) OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                }
                int unused = OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        public void headers(boolean outFinished, boolean inFinished, int streamId, int associatedStreamId, List<Header> headerBlock, HeadersMode headersMode) {
            int metadataSize;
            this.logger.logHeaders(OkHttpFrameLogger.Direction.INBOUND, streamId, headerBlock, inFinished);
            boolean unknownStream = false;
            Status failedStatus = null;
            if (OkHttpClientTransport.this.maxInboundMetadataSize != Integer.MAX_VALUE && (metadataSize = headerBlockSize(headerBlock)) > OkHttpClientTransport.this.maxInboundMetadataSize) {
                failedStatus = Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "Response %s metadata larger than %d: %d", new Object[]{inFinished ? "trailer" : "header", Integer.valueOf(OkHttpClientTransport.this.maxInboundMetadataSize), Integer.valueOf(metadataSize)}));
            }
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream stream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(streamId));
                if (stream == null) {
                    if (OkHttpClientTransport.this.mayHaveCreatedStream(streamId)) {
                        OkHttpClientTransport.this.frameWriter.rstStream(streamId, ErrorCode.STREAM_CLOSED);
                    } else {
                        unknownStream = true;
                    }
                } else if (failedStatus == null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.headers", stream.transportState().tag());
                    stream.transportState().transportHeadersReceived(headerBlock, inFinished);
                } else {
                    if (!inFinished) {
                        OkHttpClientTransport.this.frameWriter.rstStream(streamId, ErrorCode.CANCEL);
                    }
                    stream.transportState().transportReportStatus(failedStatus, false, new Metadata());
                }
            }
            if (unknownStream) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + streamId);
            }
        }

        private int headerBlockSize(List<Header> headerBlock) {
            long size = 0;
            for (int i = 0; i < headerBlock.size(); i++) {
                Header header = headerBlock.get(i);
                size += (long) (header.name.size() + 32 + header.value.size());
            }
            return (int) Math.min(size, 2147483647L);
        }

        public void rstStream(int streamId, ErrorCode errorCode) {
            this.logger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, streamId, errorCode);
            Status status = OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream");
            boolean stopDelivery = status.getCode() == Status.Code.CANCELLED || status.getCode() == Status.Code.DEADLINE_EXCEEDED;
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream stream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(streamId));
                if (stream != null) {
                    PerfMark.event("OkHttpClientTransport$ClientFrameHandler.rstStream", stream.transportState().tag());
                    OkHttpClientTransport.this.finishStream(streamId, status, errorCode == ErrorCode.REFUSED_STREAM ? ClientStreamListener.RpcProgress.REFUSED : ClientStreamListener.RpcProgress.PROCESSED, stopDelivery, (ErrorCode) null, (Metadata) null);
                }
            }
        }

        public void settings(boolean clearPrevious, Settings settings) {
            this.logger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            boolean outboundWindowSizeIncreased = false;
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    int unused = OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    outboundWindowSizeIncreased = OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                }
                if (this.firstSettings != 0) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.firstSettings = false;
                }
                OkHttpClientTransport.this.frameWriter.ackSettings(settings);
                if (outboundWindowSizeIncreased) {
                    OkHttpClientTransport.this.outboundFlow.writeStreams();
                }
                boolean unused2 = OkHttpClientTransport.this.startPendingStreams();
            }
        }

        public void ping(boolean ack, int payload1, int payload2) {
            long ackPayload = (((long) payload1) << 32) | (((long) payload2) & 4294967295L);
            this.logger.logPing(OkHttpFrameLogger.Direction.INBOUND, ackPayload);
            if (!ack) {
                synchronized (OkHttpClientTransport.this.lock) {
                    OkHttpClientTransport.this.frameWriter.ping(true, payload1, payload2);
                }
                return;
            }
            Http2Ping p = null;
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == ackPayload) {
                    p = OkHttpClientTransport.this.ping;
                    Http2Ping unused = OkHttpClientTransport.this.ping = null;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", new Object[]{Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(ackPayload)}));
                }
            }
            if (p != null) {
                p.complete();
            }
        }

        public void ackSettings() {
        }

        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            this.logger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, lastGoodStreamId, errorCode, debugData);
            if (errorCode == ErrorCode.ENHANCE_YOUR_CALM) {
                String data = debugData.utf8();
                OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", new Object[]{this, data}));
                if ("too_many_pings".equals(data)) {
                    OkHttpClientTransport.this.tooManyPingsRunnable.run();
                }
            }
            Status status = GrpcUtil.Http2Error.statusForCode((long) errorCode.httpCode).augmentDescription("Received Goaway");
            if (debugData.size() > 0) {
                status = status.augmentDescription(debugData.utf8());
            }
            OkHttpClientTransport.this.startGoAway(lastGoodStreamId, (ErrorCode) null, status);
        }

        public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) throws IOException {
            this.logger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, streamId, promisedStreamId, requestHeaders);
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.this.frameWriter.rstStream(streamId, ErrorCode.PROTOCOL_ERROR);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
            if (r0 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
            io.grpc.okhttp.OkHttpClientTransport.access$2300(r10.this$0, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void windowUpdate(int r11, long r12) {
            /*
                r10 = this;
                io.grpc.okhttp.OkHttpFrameLogger r0 = r10.logger
                io.grpc.okhttp.OkHttpFrameLogger$Direction r1 = io.grpc.okhttp.OkHttpFrameLogger.Direction.INBOUND
                r0.logWindowsUpdate(r1, r11, r12)
                r0 = 0
                int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r0 != 0) goto L_0x002c
                java.lang.String r0 = "Received 0 flow control window increment."
                if (r11 != 0) goto L_0x0019
                io.grpc.okhttp.OkHttpClientTransport r1 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                r1.onError(r2, r0)
                goto L_0x002b
            L_0x0019:
                io.grpc.okhttp.OkHttpClientTransport r3 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.Status r1 = io.grpc.Status.INTERNAL
                io.grpc.Status r5 = r1.withDescription(r0)
                io.grpc.internal.ClientStreamListener$RpcProgress r6 = io.grpc.internal.ClientStreamListener.RpcProgress.PROCESSED
                io.grpc.okhttp.internal.framed.ErrorCode r8 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                r7 = 0
                r9 = 0
                r4 = r11
                r3.finishStream(r4, r5, r6, r7, r8, r9)
            L_0x002b:
                return
            L_0x002c:
                r0 = 0
                io.grpc.okhttp.OkHttpClientTransport r1 = io.grpc.okhttp.OkHttpClientTransport.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                if (r11 != 0) goto L_0x0043
                io.grpc.okhttp.OkHttpClientTransport r2 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x008f }
                io.grpc.okhttp.OutboundFlowController r2 = r2.outboundFlow     // Catch:{ all -> 0x008f }
                r3 = 0
                int r4 = (int) r12     // Catch:{ all -> 0x008f }
                r2.windowUpdate(r3, r4)     // Catch:{ all -> 0x008f }
                monitor-exit(r1)     // Catch:{ all -> 0x008f }
                return
            L_0x0043:
                io.grpc.okhttp.OkHttpClientTransport r2 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x008f }
                java.util.Map r2 = r2.streams     // Catch:{ all -> 0x008f }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x008f }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x008f }
                io.grpc.okhttp.OkHttpClientStream r2 = (io.grpc.okhttp.OkHttpClientStream) r2     // Catch:{ all -> 0x008f }
                if (r2 == 0) goto L_0x0068
                io.grpc.okhttp.OkHttpClientTransport r3 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x008f }
                io.grpc.okhttp.OutboundFlowController r3 = r3.outboundFlow     // Catch:{ all -> 0x008f }
                io.grpc.okhttp.OkHttpClientStream$TransportState r4 = r2.transportState()     // Catch:{ all -> 0x008f }
                io.grpc.okhttp.OutboundFlowController$StreamState r4 = r4.getOutboundFlowState()     // Catch:{ all -> 0x008f }
                int r5 = (int) r12     // Catch:{ all -> 0x008f }
                r3.windowUpdate(r4, r5)     // Catch:{ all -> 0x008f }
                goto L_0x0071
            L_0x0068:
                io.grpc.okhttp.OkHttpClientTransport r3 = io.grpc.okhttp.OkHttpClientTransport.this     // Catch:{ all -> 0x008f }
                boolean r3 = r3.mayHaveCreatedStream(r11)     // Catch:{ all -> 0x008f }
                if (r3 != 0) goto L_0x0071
                r0 = 1
            L_0x0071:
                monitor-exit(r1)     // Catch:{ all -> 0x008f }
                if (r0 == 0) goto L_0x008e
                io.grpc.okhttp.OkHttpClientTransport r1 = io.grpc.okhttp.OkHttpClientTransport.this
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "Received window_update for unknown stream: "
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.StringBuilder r3 = r3.append(r11)
                java.lang.String r3 = r3.toString()
                r1.onError(r2, r3)
            L_0x008e:
                return
            L_0x008f:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008f }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientTransport.ClientFrameHandler.windowUpdate(int, long):void");
        }

        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
        }
    }
}
