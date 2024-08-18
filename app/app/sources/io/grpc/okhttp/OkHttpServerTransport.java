package io.grpc.okhttp;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.ServerStreamTracer;
import io.grpc.Status;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveEnforcer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.MaxConnectionIdleManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.OkHttpFrameLogger;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import io.grpc.okhttp.internal.framed.Variant;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

final class OkHttpServerTransport implements ServerTransport, ExceptionHandlingFrameWriter.TransportExceptionHandler, OutboundFlowController.Transport {
    /* access modifiers changed from: private */
    public static final ByteString AUTHORITY = ByteString.encodeUtf8(":authority");
    /* access modifiers changed from: private */
    public static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
    /* access modifiers changed from: private */
    public static final ByteString CONNECT_METHOD = ByteString.encodeUtf8("CONNECT");
    /* access modifiers changed from: private */
    public static final ByteString CONTENT_LENGTH = ByteString.encodeUtf8("content-length");
    /* access modifiers changed from: private */
    public static final ByteString CONTENT_TYPE = ByteString.encodeUtf8("content-type");
    private static final int GRACEFUL_SHUTDOWN_PING = 4369;
    private static final long GRACEFUL_SHUTDOWN_PING_TIMEOUT_NANOS = TimeUnit.SECONDS.toNanos(1);
    /* access modifiers changed from: private */
    public static final ByteString HOST = ByteString.encodeUtf8("host");
    /* access modifiers changed from: private */
    public static final ByteString HTTP_METHOD = ByteString.encodeUtf8(":method");
    private static final int KEEPALIVE_PING = 57005;
    /* access modifiers changed from: private */
    public static final ByteString PATH = ByteString.encodeUtf8(":path");
    /* access modifiers changed from: private */
    public static final ByteString POST_METHOD = ByteString.encodeUtf8("POST");
    /* access modifiers changed from: private */
    public static final ByteString SCHEME = ByteString.encodeUtf8(":scheme");
    /* access modifiers changed from: private */
    public static final ByteString TE = ByteString.encodeUtf8("te");
    /* access modifiers changed from: private */
    public static final ByteString TE_TRAILERS = ByteString.encodeUtf8(GrpcUtil.TE_TRAILERS);
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(OkHttpServerTransport.class.getName());
    private boolean abruptShutdown;
    /* access modifiers changed from: private */
    public Attributes attributes;
    /* access modifiers changed from: private */
    public final Config config;
    private ScheduledFuture<?> forcefulCloseTimer;
    /* access modifiers changed from: private */
    public ExceptionHandlingFrameWriter frameWriter;
    /* access modifiers changed from: private */
    public Status goAwayStatus;
    /* access modifiers changed from: private */
    public int goAwayStreamId = Integer.MAX_VALUE;
    private boolean gracefulShutdown;
    private Long gracefulShutdownPeriod = null;
    private boolean handshakeShutdown;
    /* access modifiers changed from: private */
    public final KeepAliveEnforcer keepAliveEnforcer;
    /* access modifiers changed from: private */
    public KeepAliveManager keepAliveManager;
    /* access modifiers changed from: private */
    public int lastStreamId;
    /* access modifiers changed from: private */
    public ServerTransportListener listener;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final InternalLogId logId;
    private ScheduledFuture<?> maxConnectionAgeMonitor;
    /* access modifiers changed from: private */
    public MaxConnectionIdleManager maxConnectionIdleManager;
    /* access modifiers changed from: private */
    public OutboundFlowController outboundFlow;
    private ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture<?> secondGoawayTimer;
    private InternalChannelz.Security securityInfo;
    /* access modifiers changed from: private */
    public Socket socket;
    /* access modifiers changed from: private */
    public final Map<Integer, StreamState> streams = new TreeMap();
    /* access modifiers changed from: private */
    public final TransportTracer tracer;
    private Executor transportExecutor;
    private final Variant variant = new Http2();

    interface StreamState {
        OutboundFlowController.StreamState getOutboundFlowState();

        boolean hasReceivedEndOfStream();

        void inboundDataReceived(Buffer buffer, int i, boolean z);

        void inboundRstReceived(Status status);

        int inboundWindowAvailable();

        void transportReportStatus(Status status);
    }

    public OkHttpServerTransport(Config config2, Socket bareSocket) {
        this.config = (Config) Preconditions.checkNotNull(config2, "config");
        this.socket = (Socket) Preconditions.checkNotNull(bareSocket, "bareSocket");
        this.tracer = config2.transportTracerFactory.create();
        this.tracer.setFlowControlWindowReader(new OkHttpServerTransport$$ExternalSyntheticLambda4(this));
        this.logId = InternalLogId.allocate(getClass(), this.socket.getRemoteSocketAddress().toString());
        this.transportExecutor = config2.transportExecutorPool.getObject();
        this.scheduledExecutorService = config2.scheduledExecutorServicePool.getObject();
        this.keepAliveEnforcer = new KeepAliveEnforcer(config2.permitKeepAliveWithoutCalls, config2.permitKeepAliveTimeInNanos, TimeUnit.NANOSECONDS);
    }

    public void start(ServerTransportListener listener2) {
        this.listener = (ServerTransportListener) Preconditions.checkNotNull(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SerializingExecutor serializingExecutor = new SerializingExecutor(this.transportExecutor);
        serializingExecutor.execute(new OkHttpServerTransport$$ExternalSyntheticLambda5(this, serializingExecutor));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b0, code lost:
        if (r1.config.keepAliveTimeNanos == Long.MAX_VALUE) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b2, code lost:
        r21 = r8;
        r1.keepAliveManager = new io.grpc.internal.KeepAliveManager(new io.grpc.okhttp.OkHttpServerTransport.KeepAlivePinger(r1, (io.grpc.okhttp.OkHttpServerTransport.AnonymousClass1) null), r1.scheduledExecutorService, r1.config.keepAliveTimeNanos, r1.config.keepAliveTimeoutNanos, true);
        r1.keepAliveManager.onTransportStarted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d8, code lost:
        r21 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e0, code lost:
        if (r1.config.maxConnectionIdleNanos == Long.MAX_VALUE) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e2, code lost:
        r1.maxConnectionIdleManager = new io.grpc.internal.MaxConnectionIdleManager(r1.config.maxConnectionIdleNanos);
        r1.maxConnectionIdleManager.start(new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda1(r1), r1.scheduledExecutorService);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ff, code lost:
        if (r1.config.maxConnectionAgeInNanos == Long.MAX_VALUE) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0101, code lost:
        r1.maxConnectionAgeMonitor = r1.scheduledExecutorService.schedule(new io.grpc.internal.LogExceptionRunnable(new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda2(r1)), (long) (((java.lang.Math.random() * 0.2d) + 0.9d) * ((double) r1.config.maxConnectionAgeInNanos)), java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012d, code lost:
        r1.transportExecutor.execute(new io.grpc.okhttp.OkHttpServerTransport.FrameHandler(r1, r1.variant.newReader(okio.Okio.buffer(okio.Okio.source(r1.socket)), false)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0162, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
     */
    /* renamed from: startIo */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m292lambda$start$0$iogrpcokhttpOkHttpServerTransport(io.grpc.internal.SerializingExecutor r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.Object r2 = r1.lock     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            monitor-enter(r2)     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            java.net.Socket r0 = r1.socket     // Catch:{ all -> 0x0157 }
            r3 = 1
            r0.setTcpNoDelay(r3)     // Catch:{ all -> 0x0157 }
            monitor-exit(r2)     // Catch:{ all -> 0x0157 }
            io.grpc.okhttp.OkHttpServerTransport$Config r0 = r1.config     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            io.grpc.okhttp.HandshakerSocketFactory r0 = r0.handshakerSocketFactory     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            java.net.Socket r2 = r1.socket     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            io.grpc.Attributes r3 = io.grpc.Attributes.EMPTY     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            io.grpc.okhttp.HandshakerSocketFactory$HandshakeResult r0 = r0.handshake(r2, r3)     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            r2 = r0
            java.lang.Object r3 = r1.lock     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            monitor-enter(r3)     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            java.net.Socket r0 = r2.socket     // Catch:{ all -> 0x0150 }
            r1.socket = r0     // Catch:{ all -> 0x0150 }
            monitor-exit(r3)     // Catch:{ all -> 0x0150 }
            io.grpc.Attributes r0 = r2.attributes     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            r1.attributes = r0     // Catch:{ Error -> 0x0168, IOException -> 0x0166, RuntimeException -> 0x0164 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r4 = r23
            io.grpc.okhttp.AsyncSink r0 = io.grpc.okhttp.AsyncSink.sink(r4, r1, r3)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r5 = r0
            java.net.Socket r0 = r1.socket     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            okio.Sink r0 = okio.Okio.sink((java.net.Socket) r0)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.net.Socket r6 = r1.socket     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r5.becomeConnected(r0, r6)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.internal.framed.Variant r0 = r1.variant     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            okio.BufferedSink r6 = okio.Okio.buffer((okio.Sink) r5)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r7 = 0
            io.grpc.okhttp.internal.framed.FrameWriter r0 = r0.newWriter(r6, r7)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.internal.framed.FrameWriter r0 = r5.limitControlFramesWriter(r0)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r6 = r0
            io.grpc.okhttp.OkHttpServerTransport$1 r0 = new io.grpc.okhttp.OkHttpServerTransport$1     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r0.<init>(r6)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r8 = r0
            java.lang.Object r9 = r1.lock     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            monitor-enter(r9)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.InternalChannelz$Security r0 = r2.securityInfo     // Catch:{ all -> 0x0149 }
            r1.securityInfo = r0     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r0 = new io.grpc.okhttp.ExceptionHandlingFrameWriter     // Catch:{ all -> 0x0149 }
            r0.<init>(r1, r8)     // Catch:{ all -> 0x0149 }
            r1.frameWriter = r0     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.OutboundFlowController r0 = new io.grpc.okhttp.OutboundFlowController     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r10 = r1.frameWriter     // Catch:{ all -> 0x0149 }
            r0.<init>(r1, r10)     // Catch:{ all -> 0x0149 }
            r1.outboundFlow = r0     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r0 = r1.frameWriter     // Catch:{ all -> 0x0149 }
            r0.connectionPreface()     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.internal.framed.Settings r0 = new io.grpc.okhttp.internal.framed.Settings     // Catch:{ all -> 0x0149 }
            r0.<init>()     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.OkHttpServerTransport$Config r10 = r1.config     // Catch:{ all -> 0x0149 }
            int r10 = r10.flowControlWindow     // Catch:{ all -> 0x0149 }
            r11 = 7
            io.grpc.okhttp.OkHttpSettingsUtil.set(r0, r11, r10)     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.OkHttpServerTransport$Config r10 = r1.config     // Catch:{ all -> 0x0149 }
            int r10 = r10.maxInboundMetadataSize     // Catch:{ all -> 0x0149 }
            r11 = 6
            io.grpc.okhttp.OkHttpSettingsUtil.set(r0, r11, r10)     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r10 = r1.frameWriter     // Catch:{ all -> 0x0149 }
            r10.settings(r0)     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.OkHttpServerTransport$Config r10 = r1.config     // Catch:{ all -> 0x0149 }
            int r10 = r10.flowControlWindow     // Catch:{ all -> 0x0149 }
            r11 = 65535(0xffff, float:9.1834E-41)
            if (r10 <= r11) goto L_0x009f
            io.grpc.okhttp.ExceptionHandlingFrameWriter r10 = r1.frameWriter     // Catch:{ all -> 0x009a }
            io.grpc.okhttp.OkHttpServerTransport$Config r12 = r1.config     // Catch:{ all -> 0x009a }
            int r12 = r12.flowControlWindow     // Catch:{ all -> 0x009a }
            int r12 = r12 - r11
            long r11 = (long) r12     // Catch:{ all -> 0x009a }
            r10.windowUpdate(r7, r11)     // Catch:{ all -> 0x009a }
            goto L_0x009f
        L_0x009a:
            r0 = move-exception
            r21 = r8
            goto L_0x014c
        L_0x009f:
            io.grpc.okhttp.ExceptionHandlingFrameWriter r10 = r1.frameWriter     // Catch:{ all -> 0x0149 }
            r10.flush()     // Catch:{ all -> 0x0149 }
            monitor-exit(r9)     // Catch:{ all -> 0x0149 }
            io.grpc.okhttp.OkHttpServerTransport$Config r0 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r9 = r0.keepAliveTimeNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x00d8
            io.grpc.internal.KeepAliveManager r0 = new io.grpc.internal.KeepAliveManager     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$KeepAlivePinger r14 = new io.grpc.okhttp.OkHttpServerTransport$KeepAlivePinger     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r9 = 0
            r14.<init>()     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.util.concurrent.ScheduledExecutorService r15 = r1.scheduledExecutorService     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$Config r9 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r9 = r9.keepAliveTimeNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$Config r13 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r21 = r8
            long r7 = r13.keepAliveTimeoutNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r20 = 1
            r13 = r0
            r16 = r9
            r18 = r7
            r13.<init>(r14, r15, r16, r18, r20)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r1.keepAliveManager = r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.internal.KeepAliveManager r0 = r1.keepAliveManager     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r0.onTransportStarted()     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            goto L_0x00da
        L_0x00d8:
            r21 = r8
        L_0x00da:
            io.grpc.okhttp.OkHttpServerTransport$Config r0 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r7 = r0.maxConnectionIdleNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x00f9
            io.grpc.internal.MaxConnectionIdleManager r0 = new io.grpc.internal.MaxConnectionIdleManager     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$Config r7 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r7 = r7.maxConnectionIdleNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r0.<init>(r7)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r1.maxConnectionIdleManager = r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.internal.MaxConnectionIdleManager r0 = r1.maxConnectionIdleManager     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda1 r7 = new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda1     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r7.<init>(r1)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.util.concurrent.ScheduledExecutorService r8 = r1.scheduledExecutorService     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r0.start(r7, r8)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
        L_0x00f9:
            io.grpc.okhttp.OkHttpServerTransport$Config r0 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r7 = r0.maxConnectionAgeInNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x012d
            double r7 = java.lang.Math.random()     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r9 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            double r7 = r7 * r9
            r9 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r7 = r7 + r9
            io.grpc.okhttp.OkHttpServerTransport$Config r0 = r1.config     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            long r9 = r0.maxConnectionAgeInNanos     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            double r9 = (double) r9     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            double r7 = r7 * r9
            long r7 = (long) r7     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.util.concurrent.ScheduledExecutorService r0 = r1.scheduledExecutorService     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.internal.LogExceptionRunnable r9 = new io.grpc.internal.LogExceptionRunnable     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda2 r10 = new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda2     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r10.<init>(r1)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r9.<init>(r10)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r9, r7, r10)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r1.maxConnectionAgeMonitor = r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
        L_0x012d:
            java.util.concurrent.Executor r0 = r1.transportExecutor     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.OkHttpServerTransport$FrameHandler r7 = new io.grpc.okhttp.OkHttpServerTransport$FrameHandler     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            io.grpc.okhttp.internal.framed.Variant r8 = r1.variant     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            java.net.Socket r9 = r1.socket     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            okio.Source r9 = okio.Okio.source((java.net.Socket) r9)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            okio.BufferedSource r9 = okio.Okio.buffer((okio.Source) r9)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r10 = 0
            io.grpc.okhttp.internal.framed.FrameReader r8 = r8.newReader(r9, r10)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r7.<init>(r8)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            r0.execute(r7)     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
            goto L_0x0185
        L_0x0149:
            r0 = move-exception
            r21 = r8
        L_0x014c:
            monitor-exit(r9)     // Catch:{ all -> 0x014e }
            throw r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
        L_0x014e:
            r0 = move-exception
            goto L_0x014c
        L_0x0150:
            r0 = move-exception
            r4 = r23
        L_0x0153:
            monitor-exit(r3)     // Catch:{ all -> 0x0155 }
            throw r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
        L_0x0155:
            r0 = move-exception
            goto L_0x0153
        L_0x0157:
            r0 = move-exception
            r4 = r23
        L_0x015a:
            monitor-exit(r2)     // Catch:{ all -> 0x0162 }
            throw r0     // Catch:{ Error -> 0x0160, IOException -> 0x015e, RuntimeException -> 0x015c }
        L_0x015c:
            r0 = move-exception
            goto L_0x016b
        L_0x015e:
            r0 = move-exception
            goto L_0x016b
        L_0x0160:
            r0 = move-exception
            goto L_0x016b
        L_0x0162:
            r0 = move-exception
            goto L_0x015a
        L_0x0164:
            r0 = move-exception
            goto L_0x0169
        L_0x0166:
            r0 = move-exception
            goto L_0x0169
        L_0x0168:
            r0 = move-exception
        L_0x0169:
            r4 = r23
        L_0x016b:
            r2 = r0
            java.lang.Object r3 = r1.lock
            monitor-enter(r3)
            boolean r0 = r1.handshakeShutdown     // Catch:{ all -> 0x0186 }
            if (r0 != 0) goto L_0x017c
            java.util.logging.Logger r0 = log     // Catch:{ all -> 0x0186 }
            java.util.logging.Level r5 = java.util.logging.Level.INFO     // Catch:{ all -> 0x0186 }
            java.lang.String r6 = "Socket failed to handshake"
            r0.log(r5, r6, r2)     // Catch:{ all -> 0x0186 }
        L_0x017c:
            monitor-exit(r3)     // Catch:{ all -> 0x0186 }
            java.net.Socket r0 = r1.socket
            io.grpc.internal.GrpcUtil.closeQuietly((java.io.Closeable) r0)
            r22.terminated()
        L_0x0185:
            return
        L_0x0186:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0186 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerTransport.m292lambda$start$0$iogrpcokhttpOkHttpServerTransport(io.grpc.internal.SerializingExecutor):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$startIo$1$io-grpc-okhttp-OkHttpServerTransport  reason: not valid java name */
    public /* synthetic */ void m293lambda$startIo$1$iogrpcokhttpOkHttpServerTransport() {
        shutdown(Long.valueOf(this.config.maxConnectionAgeGraceInNanos));
    }

    public void shutdown() {
        shutdown((Long) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void shutdown(@javax.annotation.Nullable java.lang.Long r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            boolean r1 = r6.gracefulShutdown     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0049
            boolean r1 = r6.abruptShutdown     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x000c
            goto L_0x0049
        L_0x000c:
            r1 = 1
            r6.gracefulShutdown = r1     // Catch:{ all -> 0x004b }
            r6.gracefulShutdownPeriod = r7     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r2 = r6.frameWriter     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x001d
            r6.handshakeShutdown = r1     // Catch:{ all -> 0x004b }
            java.net.Socket r1 = r6.socket     // Catch:{ all -> 0x004b }
            io.grpc.internal.GrpcUtil.closeQuietly((java.io.Closeable) r1)     // Catch:{ all -> 0x004b }
            goto L_0x0047
        L_0x001d:
            java.util.concurrent.ScheduledExecutorService r1 = r6.scheduledExecutorService     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda3 r2 = new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda3     // Catch:{ all -> 0x004b }
            r2.<init>(r6)     // Catch:{ all -> 0x004b }
            long r3 = GRACEFUL_SHUTDOWN_PING_TIMEOUT_NANOS     // Catch:{ all -> 0x004b }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x004b }
            java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r3, r5)     // Catch:{ all -> 0x004b }
            r6.secondGoawayTimer = r1     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.NO_ERROR     // Catch:{ all -> 0x004b }
            r3 = 0
            byte[] r4 = new byte[r3]     // Catch:{ all -> 0x004b }
            r5 = 2147483647(0x7fffffff, float:NaN)
            r1.goAway(r5, r2, r4)     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004b }
            r2 = 4369(0x1111, float:6.122E-42)
            r1.ping(r3, r3, r2)     // Catch:{ all -> 0x004b }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004b }
            r1.flush()     // Catch:{ all -> 0x004b }
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x004b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerTransport.shutdown(java.lang.Long):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void triggerGracefulSecondGoaway() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            java.util.concurrent.ScheduledFuture<?> r1 = r6.secondGoawayTimer     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return
        L_0x0009:
            java.util.concurrent.ScheduledFuture<?> r1 = r6.secondGoawayTimer     // Catch:{ all -> 0x004f }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x004f }
            r1 = 0
            r6.secondGoawayTimer = r1     // Catch:{ all -> 0x004f }
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004f }
            int r3 = r6.lastStreamId     // Catch:{ all -> 0x004f }
            io.grpc.okhttp.internal.framed.ErrorCode r4 = io.grpc.okhttp.internal.framed.ErrorCode.NO_ERROR     // Catch:{ all -> 0x004f }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x004f }
            r1.goAway(r3, r4, r2)     // Catch:{ all -> 0x004f }
            int r1 = r6.lastStreamId     // Catch:{ all -> 0x004f }
            r6.goAwayStreamId = r1     // Catch:{ all -> 0x004f }
            java.util.Map<java.lang.Integer, io.grpc.okhttp.OkHttpServerTransport$StreamState> r1 = r6.streams     // Catch:{ all -> 0x004f }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x002f
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004f }
            r1.close()     // Catch:{ all -> 0x004f }
            goto L_0x0034
        L_0x002f:
            io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r6.frameWriter     // Catch:{ all -> 0x004f }
            r1.flush()     // Catch:{ all -> 0x004f }
        L_0x0034:
            java.lang.Long r1 = r6.gracefulShutdownPeriod     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.ScheduledExecutorService r1 = r6.scheduledExecutorService     // Catch:{ all -> 0x004f }
            io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda0 r2 = new io.grpc.okhttp.OkHttpServerTransport$$ExternalSyntheticLambda0     // Catch:{ all -> 0x004f }
            r2.<init>(r6)     // Catch:{ all -> 0x004f }
            java.lang.Long r3 = r6.gracefulShutdownPeriod     // Catch:{ all -> 0x004f }
            long r3 = r3.longValue()     // Catch:{ all -> 0x004f }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x004f }
            java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r3, r5)     // Catch:{ all -> 0x004f }
            r6.forcefulCloseTimer = r1     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return
        L_0x004f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerTransport.triggerGracefulSecondGoaway():void");
    }

    public void shutdownNow(Status reason) {
        synchronized (this.lock) {
            if (this.frameWriter == null) {
                this.handshakeShutdown = true;
                GrpcUtil.closeQuietly((Closeable) this.socket);
                return;
            }
            abruptShutdown(ErrorCode.NO_ERROR, "", reason, true);
        }
    }

    public void onException(Throwable failureCause) {
        Preconditions.checkNotNull(failureCause, "failureCause");
        abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", Status.UNAVAILABLE.withCause(failureCause), false);
    }

    /* access modifiers changed from: private */
    public void abruptShutdown(ErrorCode errorCode, String moreDetail, Status reason, boolean rstStreams) {
        synchronized (this.lock) {
            if (!this.abruptShutdown) {
                this.abruptShutdown = true;
                this.goAwayStatus = reason;
                if (this.secondGoawayTimer != null) {
                    this.secondGoawayTimer.cancel(false);
                    this.secondGoawayTimer = null;
                }
                for (Map.Entry<Integer, StreamState> entry : this.streams.entrySet()) {
                    if (rstStreams) {
                        this.frameWriter.rstStream(entry.getKey().intValue(), ErrorCode.CANCEL);
                    }
                    entry.getValue().transportReportStatus(reason);
                }
                this.streams.clear();
                this.frameWriter.goAway(this.lastStreamId, errorCode, moreDetail.getBytes(GrpcUtil.US_ASCII));
                this.goAwayStreamId = this.lastStreamId;
                this.frameWriter.close();
                this.forcefulCloseTimer = this.scheduledExecutorService.schedule(new OkHttpServerTransport$$ExternalSyntheticLambda0(this), 1, TimeUnit.SECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    public void triggerForcefulClose() {
        GrpcUtil.closeQuietly((Closeable) this.socket);
    }

    /* access modifiers changed from: private */
    public void terminated() {
        synchronized (this.lock) {
            if (this.forcefulCloseTimer != null) {
                this.forcefulCloseTimer.cancel(false);
                this.forcefulCloseTimer = null;
            }
        }
        if (this.keepAliveManager != null) {
            this.keepAliveManager.onTransportTermination();
        }
        if (this.maxConnectionIdleManager != null) {
            this.maxConnectionIdleManager.onTransportTermination();
        }
        if (this.maxConnectionAgeMonitor != null) {
            this.maxConnectionAgeMonitor.cancel(false);
        }
        this.transportExecutor = this.config.transportExecutorPool.returnObject(this.transportExecutor);
        this.scheduledExecutorService = this.config.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
        this.listener.transportTerminated();
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return this.scheduledExecutorService;
    }

    public ListenableFuture<InternalChannelz.SocketStats> getStats() {
        ListenableFuture<InternalChannelz.SocketStats> immediateFuture;
        synchronized (this.lock) {
            immediateFuture = Futures.immediateFuture(new InternalChannelz.SocketStats(this.tracer.getStats(), this.socket.getLocalSocketAddress(), this.socket.getRemoteSocketAddress(), Utils.getSocketOptions(this.socket), this.securityInfo));
        }
        return immediateFuture;
    }

    /* access modifiers changed from: private */
    public TransportTracer.FlowControlWindows readFlowControlWindow() {
        TransportTracer.FlowControlWindows flowControlWindows;
        synchronized (this.lock) {
            flowControlWindows = new TransportTracer.FlowControlWindows(this.outboundFlow == null ? -1 : (long) this.outboundFlow.windowUpdate((OutboundFlowController.StreamState) null, 0), (long) (((float) this.config.flowControlWindow) * 0.5f));
        }
        return flowControlWindows;
    }

    public InternalLogId getLogId() {
        return this.logId;
    }

    public OutboundFlowController.StreamState[] getActiveStreams() {
        OutboundFlowController.StreamState[] flowStreams;
        synchronized (this.lock) {
            flowStreams = new OutboundFlowController.StreamState[this.streams.size()];
            int i = 0;
            for (StreamState stream : this.streams.values()) {
                flowStreams[i] = stream.getOutboundFlowState();
                i++;
            }
        }
        return flowStreams;
    }

    /* access modifiers changed from: package-private */
    public void streamClosed(int streamId, boolean flush) {
        synchronized (this.lock) {
            this.streams.remove(Integer.valueOf(streamId));
            if (this.streams.isEmpty()) {
                this.keepAliveEnforcer.onTransportIdle();
                if (this.maxConnectionIdleManager != null) {
                    this.maxConnectionIdleManager.onTransportIdle();
                }
            }
            if (this.gracefulShutdown && this.streams.isEmpty()) {
                this.frameWriter.close();
            } else if (flush) {
                this.frameWriter.flush();
            }
        }
    }

    /* access modifiers changed from: private */
    public static String asciiString(ByteString value) {
        for (int i = 0; i < value.size(); i++) {
            if (value.getByte(i) < 0) {
                return value.string(GrpcUtil.US_ASCII);
            }
        }
        return value.utf8();
    }

    /* access modifiers changed from: private */
    public static int headerFind(List<Header> header, ByteString key, int startIndex) {
        for (int i = startIndex; i < header.size(); i++) {
            if (header.get(i).name.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static boolean headerContains(List<Header> header, ByteString key) {
        return headerFind(header, key, 0) != -1;
    }

    /* access modifiers changed from: private */
    public static void headerRemove(List<Header> header, ByteString key) {
        int i = 0;
        while (true) {
            int headerFind = headerFind(header, key, i);
            i = headerFind;
            if (headerFind != -1) {
                header.remove(i);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static ByteString headerGetRequiredSingle(List<Header> header, ByteString key) {
        int i = headerFind(header, key, 0);
        if (i != -1 && headerFind(header, key, i + 1) == -1) {
            return header.get(i).value;
        }
        return null;
    }

    static final class Config {
        final int flowControlWindow;
        final HandshakerSocketFactory handshakerSocketFactory;
        final long keepAliveTimeNanos;
        final long keepAliveTimeoutNanos;
        final long maxConnectionAgeGraceInNanos;
        final long maxConnectionAgeInNanos;
        final long maxConnectionIdleNanos;
        final int maxInboundMessageSize;
        final int maxInboundMetadataSize;
        final long permitKeepAliveTimeInNanos;
        final boolean permitKeepAliveWithoutCalls;
        final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
        final List<? extends ServerStreamTracer.Factory> streamTracerFactories;
        final ObjectPool<Executor> transportExecutorPool;
        final TransportTracer.Factory transportTracerFactory;

        public Config(OkHttpServerBuilder builder, List<? extends ServerStreamTracer.Factory> streamTracerFactories2) {
            this.streamTracerFactories = (List) Preconditions.checkNotNull(streamTracerFactories2, "streamTracerFactories");
            this.transportExecutorPool = (ObjectPool) Preconditions.checkNotNull(builder.transportExecutorPool, "transportExecutorPool");
            this.scheduledExecutorServicePool = (ObjectPool) Preconditions.checkNotNull(builder.scheduledExecutorServicePool, "scheduledExecutorServicePool");
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(builder.transportTracerFactory, "transportTracerFactory");
            this.handshakerSocketFactory = (HandshakerSocketFactory) Preconditions.checkNotNull(builder.handshakerSocketFactory, "handshakerSocketFactory");
            this.keepAliveTimeNanos = builder.keepAliveTimeNanos;
            this.keepAliveTimeoutNanos = builder.keepAliveTimeoutNanos;
            this.flowControlWindow = builder.flowControlWindow;
            this.maxInboundMessageSize = builder.maxInboundMessageSize;
            this.maxInboundMetadataSize = builder.maxInboundMetadataSize;
            this.maxConnectionIdleNanos = builder.maxConnectionIdleInNanos;
            this.permitKeepAliveWithoutCalls = builder.permitKeepAliveWithoutCalls;
            this.permitKeepAliveTimeInNanos = builder.permitKeepAliveTimeInNanos;
            this.maxConnectionAgeInNanos = builder.maxConnectionAgeInNanos;
            this.maxConnectionAgeGraceInNanos = builder.maxConnectionAgeGraceInNanos;
        }
    }

    class FrameHandler implements FrameReader.Handler, Runnable {
        private int connectionUnacknowledgedBytesRead;
        private final OkHttpFrameLogger frameLogger = new OkHttpFrameLogger(Level.FINE, (Class<?>) OkHttpServerTransport.class);
        private final FrameReader frameReader;
        private boolean receivedSettings;

        public FrameHandler(FrameReader frameReader2) {
            this.frameReader = frameReader2;
        }

        public void run() {
            Status status;
            String threadName = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpServerTransport");
            try {
                this.frameReader.readConnectionPreface();
                if (!this.frameReader.nextFrame(this)) {
                    connectionError(ErrorCode.INTERNAL_ERROR, "Failed to read initial SETTINGS");
                    try {
                        GrpcUtil.exhaust(OkHttpServerTransport.this.socket.getInputStream());
                    } catch (IOException e) {
                    }
                    GrpcUtil.closeQuietly((Closeable) OkHttpServerTransport.this.socket);
                    OkHttpServerTransport.this.terminated();
                    Thread.currentThread().setName(threadName);
                } else if (!this.receivedSettings) {
                    connectionError(ErrorCode.PROTOCOL_ERROR, "First HTTP/2 frame must be SETTINGS. RFC7540 section 3.5");
                    try {
                        GrpcUtil.exhaust(OkHttpServerTransport.this.socket.getInputStream());
                    } catch (IOException e2) {
                    }
                    GrpcUtil.closeQuietly((Closeable) OkHttpServerTransport.this.socket);
                    OkHttpServerTransport.this.terminated();
                    Thread.currentThread().setName(threadName);
                } else {
                    while (this.frameReader.nextFrame(this)) {
                        if (OkHttpServerTransport.this.keepAliveManager != null) {
                            OkHttpServerTransport.this.keepAliveManager.onDataReceived();
                        }
                    }
                    synchronized (OkHttpServerTransport.this.lock) {
                        status = OkHttpServerTransport.this.goAwayStatus;
                    }
                    if (status == null) {
                        status = Status.UNAVAILABLE.withDescription("TCP connection closed or IOException");
                    }
                    OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "I/O failure", status, false);
                    try {
                        GrpcUtil.exhaust(OkHttpServerTransport.this.socket.getInputStream());
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable t) {
                try {
                    OkHttpServerTransport.log.log(Level.WARNING, "Error decoding HTTP/2 frames", t);
                    OkHttpServerTransport.this.abruptShutdown(ErrorCode.INTERNAL_ERROR, "Error in frame decoder", Status.INTERNAL.withDescription("Error decoding HTTP/2 frames").withCause(t), false);
                } finally {
                    try {
                        GrpcUtil.exhaust(OkHttpServerTransport.this.socket.getInputStream());
                    } catch (IOException e4) {
                    }
                    GrpcUtil.closeQuietly((Closeable) OkHttpServerTransport.this.socket);
                    OkHttpServerTransport.this.terminated();
                    Thread.currentThread().setName(threadName);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:0x01d5, code lost:
            if (r11.getByte(0) == 47) goto L_0x01df;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d7, code lost:
            r28 = r11;
            r29 = r12;
            r30 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x01df, code lost:
            r10 = io.grpc.okhttp.OkHttpServerTransport.access$2300(r11).substring(1);
            r23 = io.grpc.okhttp.OkHttpServerTransport.access$2500(r14, io.grpc.okhttp.OkHttpServerTransport.access$2400());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ef, code lost:
            if (r23 != null) goto L_0x0201;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f1, code lost:
            respondWithHttpError(r34, r33, 415, io.grpc.Status.Code.INTERNAL, "Content-Type is missing or duplicated");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0200, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0201, code lost:
            r9 = io.grpc.okhttp.OkHttpServerTransport.access$2300(r23);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0209, code lost:
            if (io.grpc.internal.GrpcUtil.isGrpcContentType(r9) != false) goto L_0x022c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x020b, code lost:
            respondWithHttpError(r34, r33, 415, io.grpc.Status.Code.INTERNAL, "Content-Type is not supported: " + r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x022b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0234, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$2600().equals(r12) != false) goto L_0x025b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0236, code lost:
            respondWithHttpError(r34, r33, 405, io.grpc.Status.Code.INTERNAL, "HTTP Method is not supported: " + io.grpc.okhttp.OkHttpServerTransport.access$2300(r12));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x025a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x025b, code lost:
            r1 = io.grpc.okhttp.OkHttpServerTransport.access$2500(r14, io.grpc.okhttp.OkHttpServerTransport.access$2700());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x026b, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$2800().equals(r1) != false) goto L_0x028e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x026d, code lost:
            r0 = io.grpc.Status.Code.INTERNAL;
            r3 = io.grpc.okhttp.OkHttpServerTransport.access$2300(io.grpc.okhttp.OkHttpServerTransport.access$2800());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0279, code lost:
            if (r1 != null) goto L_0x027e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x027b, code lost:
            r4 = "<missing>";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x027e, code lost:
            r4 = io.grpc.okhttp.OkHttpServerTransport.access$2300(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x0282, code lost:
            respondWithGrpcError(r15, r8, r0, java.lang.String.format("Expected header TE: %s, but %s is received. Some intermediate proxy may not support trailers", new java.lang.Object[]{r3, r4}));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x028d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x028e, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$1200(r14, io.grpc.okhttp.OkHttpServerTransport.access$2900());
            r3 = io.grpc.okhttp.Utils.convertHeaders(r36);
            r4 = io.grpc.internal.StatsTraceContext.newServerContext(io.grpc.okhttp.OkHttpServerTransport.access$1100(r7.this$0).streamTracerFactories, r10, r3);
            r5 = io.grpc.okhttp.OkHttpServerTransport.access$300(r7.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02ab, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x02b8, code lost:
            r24 = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x02c0, code lost:
            r16 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x02de, code lost:
            r26 = r16;
            r9 = r9;
            r27 = r10;
            r28 = r11;
            r29 = r12;
            r30 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
            r9 = new io.grpc.okhttp.OkHttpServerStream.TransportState(r7.this$0, r34, io.grpc.okhttp.OkHttpServerTransport.access$1100(r7.this$0).maxInboundMessageSize, r4, io.grpc.okhttp.OkHttpServerTransport.access$300(r7.this$0), io.grpc.okhttp.OkHttpServerTransport.access$3000(r7.this$0), io.grpc.okhttp.OkHttpServerTransport.access$3100(r7.this$0), io.grpc.okhttp.OkHttpServerTransport.access$1100(r7.this$0).flowControlWindow, io.grpc.okhttp.OkHttpServerTransport.access$3200(r7.this$0), r27);
            r16 = io.grpc.okhttp.OkHttpServerTransport.access$3300(r7.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x0304, code lost:
            if (r22 != null) goto L_0x0308;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x0306, code lost:
            r2 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x0308, code lost:
            r2 = io.grpc.okhttp.OkHttpServerTransport.access$2300(r22);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:139:0x030c, code lost:
            r14 = new io.grpc.okhttp.OkHttpServerStream(r9, r16, r2, r4, io.grpc.okhttp.OkHttpServerTransport.access$3200(r7.this$0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x0325, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$2000(r7.this$0).isEmpty() == false) goto L_0x0346;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$000(r7.this$0).onTransportActive();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x0336, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$3400(r7.this$0) == null) goto L_0x0346;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0338, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$3400(r7.this$0).onTransportActive();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0342, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0343, code lost:
            r6 = r27;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$2000(r7.this$0).put(java.lang.Integer.valueOf(r34), r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$3500(r7.this$0).streamCreated(r14, r27, r3);
            r9.onStreamAllocated();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0361, code lost:
            if (r8 == false) goto L_0x036c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x0363, code lost:
            r9.inboundDataReceived(new okio.Buffer(), 0, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x036c, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x036d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x036e, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x036f, code lost:
            r6 = r27;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x0372, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x0373, code lost:
            r6 = r10;
            r28 = r11;
            r29 = r12;
            r30 = r13;
            r26 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x037d, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x037e, code lost:
            r26 = r9;
            r6 = r10;
            r28 = r11;
            r29 = r12;
            r30 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0388, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0389, code lost:
            r24 = r1;
            r26 = r9;
            r6 = r10;
            r28 = r11;
            r29 = r12;
            r30 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0394, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x0395, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0396, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0398, code lost:
            r28 = r11;
            r29 = r12;
            r30 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x039e, code lost:
            respondWithHttpError(r34, r33, 404, io.grpc.Status.Code.UNIMPLEMENTED, "Expected path to start with /: " + io.grpc.okhttp.OkHttpServerTransport.access$2300(r28));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x03c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
            r13 = headerBlockSize(r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
            if (r13 <= io.grpc.okhttp.OkHttpServerTransport.access$1100(r7.this$0).maxInboundMetadataSize) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
            respondWithHttpError(r34, r33, 431, io.grpc.Status.Code.RESOURCE_EXHAUSTED, java.lang.String.format(java.util.Locale.US, "Request metadata larger than %d: %d", new java.lang.Object[]{java.lang.Integer.valueOf(io.grpc.okhttp.OkHttpServerTransport.access$1100(r7.this$0).maxInboundMetadataSize), java.lang.Integer.valueOf(r13)}));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x007a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$1200(r14, okio.ByteString.EMPTY);
            r12 = null;
            r21 = null;
            r11 = null;
            r9 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
            if (r36.size() <= 0) goto L_0x00f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x009d, code lost:
            if (r14.get(0).name.getByte(0) != 58) goto L_0x00f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
            r0 = r14.remove(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00af, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1300().equals(r0.name) == false) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b1, code lost:
            if (r12 != null) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b3, code lost:
            r12 = r0.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c1, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1400().equals(r0.name) == false) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
            if (r21 != null) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c5, code lost:
            r21 = r0.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d4, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1500().equals(r0.name) == false) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
            if (r11 != null) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d8, code lost:
            r11 = r0.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e6, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1600().equals(r0.name) == false) goto L_0x00ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e8, code lost:
            if (r9 != null) goto L_0x00ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ea, code lost:
            r9 = r0.value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ee, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Unexpected pseudo header. RFC7540 section 8.1.2.1");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f5, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
            r0 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fb, code lost:
            if (r0 >= r36.size()) goto L_0x0116;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0109, code lost:
            if (r14.get(r0).name.getByte(0) != 58) goto L_0x0113;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x010b, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Pseudo header not before regular headers. RFC7540 section 8.1.2.1");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0113, code lost:
            r0 = r0 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x011e, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1700().equals(r12) != false) goto L_0x0130;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0120, code lost:
            if (r20 == false) goto L_0x0130;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0122, code lost:
            if (r12 == null) goto L_0x0128;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0124, code lost:
            if (r21 == null) goto L_0x0128;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0126, code lost:
            if (r11 != null) goto L_0x0130;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0128, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Missing required pseudo header. RFC7540 section 8.1.2.3");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x012f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0138, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$1900(r14, io.grpc.okhttp.OkHttpServerTransport.access$1800()) == false) goto L_0x0142;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x013a, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Connection-specific headers not permitted. RFC7540 section 8.1.2.2");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0141, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0142, code lost:
            if (r20 != false) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0144, code lost:
            if (r8 == false) goto L_0x0184;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x0146, code lost:
            r1 = io.grpc.okhttp.OkHttpServerTransport.access$300(r7.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x014c, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
            r0 = (io.grpc.okhttp.OkHttpServerTransport.StreamState) io.grpc.okhttp.OkHttpServerTransport.access$2000(r7.this$0).get(java.lang.Integer.valueOf(r34));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x015d, code lost:
            if (r0 != null) goto L_0x0168;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x015f, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED, "Received headers for closed stream");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0166, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0167, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x016c, code lost:
            if (r0.hasReceivedEndOfStream() == false) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x016e, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED, "Received HEADERS for half-closed (remote) stream. RFC7540 section 5.1");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0175, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0176, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x0177, code lost:
            r0.inboundDataReceived(new okio.Buffer(), 0, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x017f, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x0180, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0184, code lost:
            streamError(r15, io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR, "Headers disallowed in the middle of the stream. RFC7540 section 8.1");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x018b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x018c, code lost:
            if (r9 != null) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x018e, code lost:
            r0 = io.grpc.okhttp.OkHttpServerTransport.access$2200(r14, io.grpc.okhttp.OkHttpServerTransport.access$2100(), 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0197, code lost:
            if (r0 == -1) goto L_0x01c0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01a3, code lost:
            if (io.grpc.okhttp.OkHttpServerTransport.access$2200(r14, io.grpc.okhttp.OkHttpServerTransport.access$2100(), r0 + 1) == -1) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01a5, code lost:
            respondWithHttpError(r34, r33, com.google.logging.type.LogSeverity.WARNING_VALUE, io.grpc.Status.Code.INTERNAL, "Multiple host headers disallowed. RFC7230 section 5.4");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x01b4, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x01b5, code lost:
            r22 = r14.get(r0).value;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c0, code lost:
            r22 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c2, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$1200(r14, io.grpc.okhttp.OkHttpServerTransport.access$2100());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cd, code lost:
            if (r11.size() == 0) goto L_0x0398;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r32, boolean r33, int r34, int r35, java.util.List<io.grpc.okhttp.internal.framed.Header> r36, io.grpc.okhttp.internal.framed.HeadersMode r37) {
            /*
                r31 = this;
                r7 = r31
                r8 = r33
                r15 = r34
                r14 = r36
                io.grpc.okhttp.OkHttpFrameLogger r0 = r7.frameLogger
                io.grpc.okhttp.OkHttpFrameLogger$Direction r1 = io.grpc.okhttp.OkHttpFrameLogger.Direction.INBOUND
                r0.logHeaders(r1, r15, r14, r8)
                r0 = r15 & 1
                if (r0 != 0) goto L_0x001b
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Clients cannot open even numbered streams. RFC7540 section 5.1.1"
                r7.connectionError(r0, r1)
                return
            L_0x001b:
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                java.lang.Object r1 = r0.lock
                monitor-enter(r1)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x03c3 }
                int r0 = r0.goAwayStreamId     // Catch:{ all -> 0x03c3 }
                if (r15 <= r0) goto L_0x002c
                monitor-exit(r1)     // Catch:{ all -> 0x03c3 }
                return
            L_0x002c:
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x03c3 }
                int r0 = r0.lastStreamId     // Catch:{ all -> 0x03c3 }
                r2 = 0
                r3 = 1
                if (r15 <= r0) goto L_0x0038
                r0 = r3
                goto L_0x0039
            L_0x0038:
                r0 = r2
            L_0x0039:
                r20 = r0
                if (r20 == 0) goto L_0x0042
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x03c3 }
                int unused = r0.lastStreamId = r15     // Catch:{ all -> 0x03c3 }
            L_0x0042:
                monitor-exit(r1)     // Catch:{ all -> 0x03c3 }
                int r13 = r7.headerBlockSize(r14)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                io.grpc.okhttp.OkHttpServerTransport$Config r0 = r0.config
                int r0 = r0.maxInboundMetadataSize
                if (r13 <= r0) goto L_0x007b
                io.grpc.Status$Code r5 = io.grpc.Status.Code.RESOURCE_EXHAUSTED
                java.util.Locale r0 = java.util.Locale.US
                java.lang.String r1 = "Request metadata larger than %d: %d"
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this
                io.grpc.okhttp.OkHttpServerTransport$Config r2 = r2.config
                int r2 = r2.maxInboundMetadataSize
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
                java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
                java.lang.String r6 = java.lang.String.format(r0, r1, r2)
                r4 = 431(0x1af, float:6.04E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x007b:
                okio.ByteString r0 = okio.ByteString.EMPTY
                io.grpc.okhttp.OkHttpServerTransport.headerRemove(r14, r0)
                r0 = 0
                r1 = 0
                r4 = 0
                r5 = 0
                r12 = r0
                r21 = r1
                r11 = r4
                r9 = r5
            L_0x0089:
                int r0 = r36.size()
                r1 = 58
                if (r0 <= 0) goto L_0x00f6
                java.lang.Object r0 = r14.get(r2)
                io.grpc.okhttp.internal.framed.Header r0 = (io.grpc.okhttp.internal.framed.Header) r0
                okio.ByteString r0 = r0.name
                byte r0 = r0.getByte(r2)
                if (r0 != r1) goto L_0x00f6
                java.lang.Object r0 = r14.remove(r2)
                io.grpc.okhttp.internal.framed.Header r0 = (io.grpc.okhttp.internal.framed.Header) r0
                okio.ByteString r1 = io.grpc.okhttp.OkHttpServerTransport.HTTP_METHOD
                okio.ByteString r4 = r0.name
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x00b7
                if (r12 != 0) goto L_0x00b7
                okio.ByteString r1 = r0.value
                r12 = r1
                goto L_0x00ed
            L_0x00b7:
                okio.ByteString r1 = io.grpc.okhttp.OkHttpServerTransport.SCHEME
                okio.ByteString r4 = r0.name
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x00ca
                if (r21 != 0) goto L_0x00ca
                okio.ByteString r1 = r0.value
                r21 = r1
                goto L_0x00ed
            L_0x00ca:
                okio.ByteString r1 = io.grpc.okhttp.OkHttpServerTransport.PATH
                okio.ByteString r4 = r0.name
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x00dc
                if (r11 != 0) goto L_0x00dc
                okio.ByteString r1 = r0.value
                r11 = r1
                goto L_0x00ed
            L_0x00dc:
                okio.ByteString r1 = io.grpc.okhttp.OkHttpServerTransport.AUTHORITY
                okio.ByteString r4 = r0.name
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x00ee
                if (r9 != 0) goto L_0x00ee
                okio.ByteString r1 = r0.value
                r9 = r1
            L_0x00ed:
                goto L_0x0089
            L_0x00ee:
                io.grpc.okhttp.internal.framed.ErrorCode r1 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r2 = "Unexpected pseudo header. RFC7540 section 8.1.2.1"
                r7.streamError(r15, r1, r2)
                return
            L_0x00f6:
                r0 = 0
            L_0x00f7:
                int r4 = r36.size()
                if (r0 >= r4) goto L_0x0116
                java.lang.Object r4 = r14.get(r0)
                io.grpc.okhttp.internal.framed.Header r4 = (io.grpc.okhttp.internal.framed.Header) r4
                okio.ByteString r4 = r4.name
                byte r4 = r4.getByte(r2)
                if (r4 != r1) goto L_0x0113
                io.grpc.okhttp.internal.framed.ErrorCode r1 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r2 = "Pseudo header not before regular headers. RFC7540 section 8.1.2.1"
                r7.streamError(r15, r1, r2)
                return
            L_0x0113:
                int r0 = r0 + 1
                goto L_0x00f7
            L_0x0116:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.CONNECT_METHOD
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x0130
                if (r20 == 0) goto L_0x0130
                if (r12 == 0) goto L_0x0128
                if (r21 == 0) goto L_0x0128
                if (r11 != 0) goto L_0x0130
            L_0x0128:
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Missing required pseudo header. RFC7540 section 8.1.2.3"
                r7.streamError(r15, r0, r1)
                return
            L_0x0130:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.CONNECTION
                boolean r0 = io.grpc.okhttp.OkHttpServerTransport.headerContains(r14, r0)
                if (r0 == 0) goto L_0x0142
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Connection-specific headers not permitted. RFC7540 section 8.1.2.2"
                r7.streamError(r15, r0, r1)
                return
            L_0x0142:
                if (r20 != 0) goto L_0x018c
                if (r8 == 0) goto L_0x0184
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                java.lang.Object r1 = r0.lock
                monitor-enter(r1)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0181 }
                java.util.Map r0 = r0.streams     // Catch:{ all -> 0x0181 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r34)     // Catch:{ all -> 0x0181 }
                java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0181 }
                io.grpc.okhttp.OkHttpServerTransport$StreamState r0 = (io.grpc.okhttp.OkHttpServerTransport.StreamState) r0     // Catch:{ all -> 0x0181 }
                if (r0 != 0) goto L_0x0168
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED     // Catch:{ all -> 0x0181 }
                java.lang.String r3 = "Received headers for closed stream"
                r7.streamError(r15, r2, r3)     // Catch:{ all -> 0x0181 }
                monitor-exit(r1)     // Catch:{ all -> 0x0181 }
                return
            L_0x0168:
                boolean r4 = r0.hasReceivedEndOfStream()     // Catch:{ all -> 0x0181 }
                if (r4 == 0) goto L_0x0177
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED     // Catch:{ all -> 0x0181 }
                java.lang.String r3 = "Received HEADERS for half-closed (remote) stream. RFC7540 section 5.1"
                r7.streamError(r15, r2, r3)     // Catch:{ all -> 0x0181 }
                monitor-exit(r1)     // Catch:{ all -> 0x0181 }
                return
            L_0x0177:
                okio.Buffer r4 = new okio.Buffer     // Catch:{ all -> 0x0181 }
                r4.<init>()     // Catch:{ all -> 0x0181 }
                r0.inboundDataReceived(r4, r2, r3)     // Catch:{ all -> 0x0181 }
                monitor-exit(r1)     // Catch:{ all -> 0x0181 }
                return
            L_0x0181:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0181 }
                throw r0
            L_0x0184:
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Headers disallowed in the middle of the stream. RFC7540 section 8.1"
                r7.streamError(r15, r0, r1)
                return
            L_0x018c:
                if (r9 != 0) goto L_0x01c0
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.HOST
                int r0 = io.grpc.okhttp.OkHttpServerTransport.headerFind(r14, r0, r2)
                r1 = -1
                if (r0 == r1) goto L_0x01c0
                okio.ByteString r4 = io.grpc.okhttp.OkHttpServerTransport.HOST
                int r5 = r0 + 1
                int r4 = io.grpc.okhttp.OkHttpServerTransport.headerFind(r14, r4, r5)
                if (r4 == r1) goto L_0x01b5
                io.grpc.Status$Code r5 = io.grpc.Status.Code.INTERNAL
                java.lang.String r6 = "Multiple host headers disallowed. RFC7230 section 5.4"
                r4 = 400(0x190, float:5.6E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x01b5:
                java.lang.Object r1 = r14.get(r0)
                io.grpc.okhttp.internal.framed.Header r1 = (io.grpc.okhttp.internal.framed.Header) r1
                okio.ByteString r9 = r1.value
                r22 = r9
                goto L_0x01c2
            L_0x01c0:
                r22 = r9
            L_0x01c2:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.HOST
                io.grpc.okhttp.OkHttpServerTransport.headerRemove(r14, r0)
                int r0 = r11.size()
                if (r0 == 0) goto L_0x0398
                byte r0 = r11.getByte(r2)
                r1 = 47
                if (r0 == r1) goto L_0x01df
                r28 = r11
                r29 = r12
                r30 = r13
                goto L_0x039e
            L_0x01df:
                java.lang.String r0 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r11)
                java.lang.String r10 = r0.substring(r3)
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.CONTENT_TYPE
                okio.ByteString r23 = io.grpc.okhttp.OkHttpServerTransport.headerGetRequiredSingle(r14, r0)
                if (r23 != 0) goto L_0x0201
                io.grpc.Status$Code r5 = io.grpc.Status.Code.INTERNAL
                java.lang.String r6 = "Content-Type is missing or duplicated"
                r4 = 415(0x19f, float:5.82E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x0201:
                java.lang.String r9 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r23)
                boolean r0 = io.grpc.internal.GrpcUtil.isGrpcContentType(r9)
                if (r0 != 0) goto L_0x022c
                io.grpc.Status$Code r5 = io.grpc.Status.Code.INTERNAL
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Content-Type is not supported: "
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r9)
                java.lang.String r6 = r0.toString()
                r4 = 415(0x19f, float:5.82E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x022c:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.POST_METHOD
                boolean r0 = r0.equals(r12)
                if (r0 != 0) goto L_0x025b
                io.grpc.Status$Code r5 = io.grpc.Status.Code.INTERNAL
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "HTTP Method is not supported: "
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r12)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r6 = r0.toString()
                r4 = 405(0x195, float:5.68E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x025b:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.TE
                okio.ByteString r1 = io.grpc.okhttp.OkHttpServerTransport.headerGetRequiredSingle(r14, r0)
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.TE_TRAILERS
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x028e
                io.grpc.Status$Code r0 = io.grpc.Status.Code.INTERNAL
                java.lang.String r2 = "Expected header TE: %s, but %s is received. Some intermediate proxy may not support trailers"
                okio.ByteString r3 = io.grpc.okhttp.OkHttpServerTransport.TE_TRAILERS
                java.lang.String r3 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r3)
                if (r1 != 0) goto L_0x027e
                java.lang.String r4 = "<missing>"
                goto L_0x0282
            L_0x027e:
                java.lang.String r4 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r1)
            L_0x0282:
                java.lang.Object[] r3 = new java.lang.Object[]{r3, r4}
                java.lang.String r2 = java.lang.String.format(r2, r3)
                r7.respondWithGrpcError(r15, r8, r0, r2)
                return
            L_0x028e:
                okio.ByteString r0 = io.grpc.okhttp.OkHttpServerTransport.CONTENT_LENGTH
                io.grpc.okhttp.OkHttpServerTransport.headerRemove(r14, r0)
                io.grpc.Metadata r3 = io.grpc.okhttp.Utils.convertHeaders(r36)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                io.grpc.okhttp.OkHttpServerTransport$Config r0 = r0.config
                java.util.List<? extends io.grpc.ServerStreamTracer$Factory> r0 = r0.streamTracerFactories
                io.grpc.internal.StatsTraceContext r4 = io.grpc.internal.StatsTraceContext.newServerContext(r0, r10, r3)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                java.lang.Object r5 = r0.lock
                monitor-enter(r5)
                io.grpc.okhttp.OkHttpServerStream$TransportState r0 = new io.grpc.okhttp.OkHttpServerStream$TransportState     // Catch:{ all -> 0x0388 }
                io.grpc.okhttp.OkHttpServerTransport r6 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0388 }
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0388 }
                io.grpc.okhttp.OkHttpServerTransport$Config r2 = r2.config     // Catch:{ all -> 0x0388 }
                int r2 = r2.maxInboundMessageSize     // Catch:{ all -> 0x0388 }
                r24 = r1
                io.grpc.okhttp.OkHttpServerTransport r1 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x037d }
                java.lang.Object r1 = r1.lock     // Catch:{ all -> 0x037d }
                r16 = r9
                io.grpc.okhttp.OkHttpServerTransport r9 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0372 }
                io.grpc.okhttp.ExceptionHandlingFrameWriter r17 = r9.frameWriter     // Catch:{ all -> 0x0372 }
                io.grpc.okhttp.OkHttpServerTransport r9 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0372 }
                io.grpc.okhttp.OutboundFlowController r18 = r9.outboundFlow     // Catch:{ all -> 0x0372 }
                io.grpc.okhttp.OkHttpServerTransport r9 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0372 }
                io.grpc.okhttp.OkHttpServerTransport$Config r9 = r9.config     // Catch:{ all -> 0x0372 }
                int r9 = r9.flowControlWindow     // Catch:{ all -> 0x0372 }
                r19 = r9
                io.grpc.okhttp.OkHttpServerTransport r9 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0372 }
                io.grpc.internal.TransportTracer r25 = r9.tracer     // Catch:{ all -> 0x0372 }
                r26 = r16
                r9 = r0
                r27 = r10
                r10 = r6
                r28 = r11
                r11 = r34
                r29 = r12
                r12 = r2
                r30 = r13
                r13 = r4
                r14 = r1
                r15 = r17
                r16 = r18
                r17 = r19
                r18 = r25
                r19 = r27
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x036e }
                io.grpc.okhttp.OkHttpServerStream r1 = new io.grpc.okhttp.OkHttpServerStream     // Catch:{ all -> 0x036e }
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x036e }
                io.grpc.Attributes r16 = r2.attributes     // Catch:{ all -> 0x036e }
                if (r22 != 0) goto L_0x0308
                r2 = 0
                goto L_0x030c
            L_0x0308:
                java.lang.String r2 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r22)     // Catch:{ all -> 0x036e }
            L_0x030c:
                r17 = r2
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x036e }
                io.grpc.internal.TransportTracer r19 = r2.tracer     // Catch:{ all -> 0x036e }
                r14 = r1
                r15 = r0
                r18 = r4
                r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x036e }
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x036e }
                java.util.Map r2 = r2.streams     // Catch:{ all -> 0x036e }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x036e }
                if (r2 == 0) goto L_0x0346
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0342 }
                io.grpc.internal.KeepAliveEnforcer r2 = r2.keepAliveEnforcer     // Catch:{ all -> 0x0342 }
                r2.onTransportActive()     // Catch:{ all -> 0x0342 }
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0342 }
                io.grpc.internal.MaxConnectionIdleManager r2 = r2.maxConnectionIdleManager     // Catch:{ all -> 0x0342 }
                if (r2 == 0) goto L_0x0346
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x0342 }
                io.grpc.internal.MaxConnectionIdleManager r2 = r2.maxConnectionIdleManager     // Catch:{ all -> 0x0342 }
                r2.onTransportActive()     // Catch:{ all -> 0x0342 }
                goto L_0x0346
            L_0x0342:
                r0 = move-exception
                r6 = r27
                goto L_0x0394
            L_0x0346:
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x036e }
                java.util.Map r2 = r2.streams     // Catch:{ all -> 0x036e }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r34)     // Catch:{ all -> 0x036e }
                r2.put(r6, r0)     // Catch:{ all -> 0x036e }
                io.grpc.okhttp.OkHttpServerTransport r2 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x036e }
                io.grpc.internal.ServerTransportListener r2 = r2.listener     // Catch:{ all -> 0x036e }
                r6 = r27
                r2.streamCreated(r1, r6, r3)     // Catch:{ all -> 0x0396 }
                r0.onStreamAllocated()     // Catch:{ all -> 0x0396 }
                if (r8 == 0) goto L_0x036c
                okio.Buffer r2 = new okio.Buffer     // Catch:{ all -> 0x0396 }
                r2.<init>()     // Catch:{ all -> 0x0396 }
                r9 = 0
                r0.inboundDataReceived(r2, r9, r8)     // Catch:{ all -> 0x0396 }
            L_0x036c:
                monitor-exit(r5)     // Catch:{ all -> 0x0396 }
                return
            L_0x036e:
                r0 = move-exception
                r6 = r27
                goto L_0x0394
            L_0x0372:
                r0 = move-exception
                r6 = r10
                r28 = r11
                r29 = r12
                r30 = r13
                r26 = r16
                goto L_0x0394
            L_0x037d:
                r0 = move-exception
                r26 = r9
                r6 = r10
                r28 = r11
                r29 = r12
                r30 = r13
                goto L_0x0394
            L_0x0388:
                r0 = move-exception
                r24 = r1
                r26 = r9
                r6 = r10
                r28 = r11
                r29 = r12
                r30 = r13
            L_0x0394:
                monitor-exit(r5)     // Catch:{ all -> 0x0396 }
                throw r0
            L_0x0396:
                r0 = move-exception
                goto L_0x0394
            L_0x0398:
                r28 = r11
                r29 = r12
                r30 = r13
            L_0x039e:
                io.grpc.Status$Code r5 = io.grpc.Status.Code.UNIMPLEMENTED
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Expected path to start with /: "
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r1 = io.grpc.okhttp.OkHttpServerTransport.asciiString(r28)
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r6 = r0.toString()
                r4 = 404(0x194, float:5.66E-43)
                r1 = r31
                r2 = r34
                r3 = r33
                r1.respondWithHttpError(r2, r3, r4, r5, r6)
                return
            L_0x03c3:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x03c3 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerTransport.FrameHandler.headers(boolean, boolean, int, int, java.util.List, io.grpc.okhttp.internal.framed.HeadersMode):void");
        }

        private int headerBlockSize(List<Header> headerBlock) {
            long size = 0;
            for (int i = 0; i < headerBlock.size(); i++) {
                Header header = headerBlock.get(i);
                size += (long) (header.name.size() + 32 + header.value.size());
            }
            return (int) Math.min(size, 2147483647L);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
            r6.connectionUnacknowledgedBytesRead += r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
            if (((float) r6.connectionUnacknowledgedBytesRead) < (((float) io.grpc.okhttp.OkHttpServerTransport.access$1100(r6.this$0).flowControlWindow) * 0.5f)) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
            r0 = io.grpc.okhttp.OkHttpServerTransport.access$300(r6.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a3, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            io.grpc.okhttp.OkHttpServerTransport.access$3000(r6.this$0).windowUpdate(0, (long) r6.connectionUnacknowledgedBytesRead);
            io.grpc.okhttp.OkHttpServerTransport.access$3000(r6.this$0).flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
            r6.connectionUnacknowledgedBytesRead = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void data(boolean r7, int r8, okio.BufferedSource r9, int r10) throws java.io.IOException {
            /*
                r6 = this;
                io.grpc.okhttp.OkHttpFrameLogger r0 = r6.frameLogger
                io.grpc.okhttp.OkHttpFrameLogger$Direction r1 = io.grpc.okhttp.OkHttpFrameLogger.Direction.INBOUND
                okio.Buffer r3 = r9.getBuffer()
                r2 = r8
                r4 = r10
                r5 = r7
                r0.logData(r1, r2, r3, r4, r5)
                if (r8 != 0) goto L_0x0018
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Stream 0 is reserved for control messages. RFC7540 section 5.1.1"
                r6.connectionError(r0, r1)
                return
            L_0x0018:
                r0 = r8 & 1
                if (r0 != 0) goto L_0x0024
                io.grpc.okhttp.internal.framed.ErrorCode r0 = io.grpc.okhttp.internal.framed.ErrorCode.PROTOCOL_ERROR
                java.lang.String r1 = "Clients cannot open even numbered streams. RFC7540 section 5.1.1"
                r6.connectionError(r0, r1)
                return
            L_0x0024:
                long r0 = (long) r10
                r9.require(r0)
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                io.grpc.okhttp.OkHttpServerTransport r1 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x00c2 }
                java.util.Map r1 = r1.streams     // Catch:{ all -> 0x00c2 }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00c2 }
                java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00c2 }
                io.grpc.okhttp.OkHttpServerTransport$StreamState r1 = (io.grpc.okhttp.OkHttpServerTransport.StreamState) r1     // Catch:{ all -> 0x00c2 }
                if (r1 != 0) goto L_0x004e
                long r2 = (long) r10     // Catch:{ all -> 0x00c2 }
                r9.skip(r2)     // Catch:{ all -> 0x00c2 }
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED     // Catch:{ all -> 0x00c2 }
                java.lang.String r3 = "Received data for closed stream"
                r6.streamError(r8, r2, r3)     // Catch:{ all -> 0x00c2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
                return
            L_0x004e:
                boolean r2 = r1.hasReceivedEndOfStream()     // Catch:{ all -> 0x00c2 }
                if (r2 == 0) goto L_0x0061
                long r2 = (long) r10     // Catch:{ all -> 0x00c2 }
                r9.skip(r2)     // Catch:{ all -> 0x00c2 }
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.STREAM_CLOSED     // Catch:{ all -> 0x00c2 }
                java.lang.String r3 = "Received DATA for half-closed (remote) stream. RFC7540 section 5.1"
                r6.streamError(r8, r2, r3)     // Catch:{ all -> 0x00c2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
                return
            L_0x0061:
                int r2 = r1.inboundWindowAvailable()     // Catch:{ all -> 0x00c2 }
                if (r2 >= r10) goto L_0x0074
                long r2 = (long) r10     // Catch:{ all -> 0x00c2 }
                r9.skip(r2)     // Catch:{ all -> 0x00c2 }
                io.grpc.okhttp.internal.framed.ErrorCode r2 = io.grpc.okhttp.internal.framed.ErrorCode.FLOW_CONTROL_ERROR     // Catch:{ all -> 0x00c2 }
                java.lang.String r3 = "Received DATA size exceeded window size. RFC7540 section 6.9"
                r6.streamError(r8, r2, r3)     // Catch:{ all -> 0x00c2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
                return
            L_0x0074:
                okio.Buffer r2 = new okio.Buffer     // Catch:{ all -> 0x00c2 }
                r2.<init>()     // Catch:{ all -> 0x00c2 }
                okio.Buffer r3 = r9.getBuffer()     // Catch:{ all -> 0x00c2 }
                long r4 = (long) r10     // Catch:{ all -> 0x00c2 }
                r2.write((okio.Buffer) r3, (long) r4)     // Catch:{ all -> 0x00c2 }
                r1.inboundDataReceived(r2, r10, r7)     // Catch:{ all -> 0x00c2 }
                monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
                int r0 = r6.connectionUnacknowledgedBytesRead
                int r0 = r0 + r10
                r6.connectionUnacknowledgedBytesRead = r0
                int r0 = r6.connectionUnacknowledgedBytesRead
                float r0 = (float) r0
                io.grpc.okhttp.OkHttpServerTransport r1 = io.grpc.okhttp.OkHttpServerTransport.this
                io.grpc.okhttp.OkHttpServerTransport$Config r1 = r1.config
                int r1 = r1.flowControlWindow
                float r1 = (float) r1
                r2 = 1056964608(0x3f000000, float:0.5)
                float r1 = r1 * r2
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L_0x00c1
                io.grpc.okhttp.OkHttpServerTransport r0 = io.grpc.okhttp.OkHttpServerTransport.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                io.grpc.okhttp.OkHttpServerTransport r1 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x00be }
                io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r1.frameWriter     // Catch:{ all -> 0x00be }
                int r2 = r6.connectionUnacknowledgedBytesRead     // Catch:{ all -> 0x00be }
                long r2 = (long) r2     // Catch:{ all -> 0x00be }
                r4 = 0
                r1.windowUpdate(r4, r2)     // Catch:{ all -> 0x00be }
                io.grpc.okhttp.OkHttpServerTransport r1 = io.grpc.okhttp.OkHttpServerTransport.this     // Catch:{ all -> 0x00be }
                io.grpc.okhttp.ExceptionHandlingFrameWriter r1 = r1.frameWriter     // Catch:{ all -> 0x00be }
                r1.flush()     // Catch:{ all -> 0x00be }
                monitor-exit(r0)     // Catch:{ all -> 0x00be }
                r6.connectionUnacknowledgedBytesRead = r4
                goto L_0x00c1
            L_0x00be:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00be }
                throw r1
            L_0x00c1:
                return
            L_0x00c2:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerTransport.FrameHandler.data(boolean, int, okio.BufferedSource, int):void");
        }

        public void rstStream(int streamId, ErrorCode errorCode) {
            this.frameLogger.logRstStream(OkHttpFrameLogger.Direction.INBOUND, streamId, errorCode);
            if (!ErrorCode.NO_ERROR.equals(errorCode) && !ErrorCode.CANCEL.equals(errorCode) && !ErrorCode.STREAM_CLOSED.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.INFO, "Received RST_STREAM: " + errorCode);
            }
            Status status = GrpcUtil.Http2Error.statusForCode((long) errorCode.httpCode).withDescription("RST_STREAM");
            synchronized (OkHttpServerTransport.this.lock) {
                StreamState stream = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(streamId));
                if (stream != null) {
                    stream.inboundRstReceived(status);
                    OkHttpServerTransport.this.streamClosed(streamId, false);
                }
            }
        }

        public void settings(boolean clearPrevious, Settings settings) {
            this.frameLogger.logSettings(OkHttpFrameLogger.Direction.INBOUND, settings);
            synchronized (OkHttpServerTransport.this.lock) {
                boolean outboundWindowSizeIncreased = false;
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    outboundWindowSizeIncreased = OkHttpServerTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                }
                OkHttpServerTransport.this.frameWriter.ackSettings(settings);
                OkHttpServerTransport.this.frameWriter.flush();
                if (!this.receivedSettings) {
                    this.receivedSettings = true;
                    Attributes unused = OkHttpServerTransport.this.attributes = OkHttpServerTransport.this.listener.transportReady(OkHttpServerTransport.this.attributes);
                }
                if (outboundWindowSizeIncreased) {
                    OkHttpServerTransport.this.outboundFlow.writeStreams();
                }
            }
        }

        public void ping(boolean ack, int payload1, int payload2) {
            if (!OkHttpServerTransport.this.keepAliveEnforcer.pingAcceptable()) {
                OkHttpServerTransport.this.abruptShutdown(ErrorCode.ENHANCE_YOUR_CALM, "too_many_pings", Status.RESOURCE_EXHAUSTED.withDescription("Too many pings from client"), false);
                return;
            }
            long payload = (((long) payload1) << 32) | (((long) payload2) & 4294967295L);
            if (!ack) {
                this.frameLogger.logPing(OkHttpFrameLogger.Direction.INBOUND, payload);
                synchronized (OkHttpServerTransport.this.lock) {
                    OkHttpServerTransport.this.frameWriter.ping(true, payload1, payload2);
                    OkHttpServerTransport.this.frameWriter.flush();
                }
                return;
            }
            this.frameLogger.logPingAck(OkHttpFrameLogger.Direction.INBOUND, payload);
            if (57005 != payload) {
                if (4369 == payload) {
                    OkHttpServerTransport.this.triggerGracefulSecondGoaway();
                } else {
                    OkHttpServerTransport.log.log(Level.INFO, "Received unexpected ping ack: " + payload);
                }
            }
        }

        public void ackSettings() {
        }

        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            this.frameLogger.logGoAway(OkHttpFrameLogger.Direction.INBOUND, lastGoodStreamId, errorCode, debugData);
            Status status = GrpcUtil.Http2Error.statusForCode((long) errorCode.httpCode).withDescription(String.format("Received GOAWAY: %s '%s'", new Object[]{errorCode, debugData.utf8()}));
            if (!ErrorCode.NO_ERROR.equals(errorCode)) {
                OkHttpServerTransport.log.log(Level.WARNING, "Received GOAWAY: {0} {1}", new Object[]{errorCode, debugData.utf8()});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                Status unused = OkHttpServerTransport.this.goAwayStatus = status;
            }
        }

        public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) throws IOException {
            this.frameLogger.logPushPromise(OkHttpFrameLogger.Direction.INBOUND, streamId, promisedStreamId, requestHeaders);
            connectionError(ErrorCode.PROTOCOL_ERROR, "PUSH_PROMISE only allowed on peer-initiated streams. RFC7540 section 6.6");
        }

        public void windowUpdate(int streamId, long delta) {
            this.frameLogger.logWindowsUpdate(OkHttpFrameLogger.Direction.INBOUND, streamId, delta);
            synchronized (OkHttpServerTransport.this.lock) {
                if (streamId == 0) {
                    OkHttpServerTransport.this.outboundFlow.windowUpdate((OutboundFlowController.StreamState) null, (int) delta);
                } else {
                    StreamState stream = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(streamId));
                    if (stream != null) {
                        OkHttpServerTransport.this.outboundFlow.windowUpdate(stream.getOutboundFlowState(), (int) delta);
                    }
                }
            }
        }

        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
            this.frameLogger.logPriority(OkHttpFrameLogger.Direction.INBOUND, streamId, streamDependency, weight, exclusive);
        }

        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
        }

        private void connectionError(ErrorCode errorCode, String moreDetail) {
            OkHttpServerTransport.this.abruptShutdown(errorCode, moreDetail, GrpcUtil.Http2Error.statusForCode((long) errorCode.httpCode).withDescription(String.format("HTTP2 connection error: %s '%s'", new Object[]{errorCode, moreDetail})), false);
        }

        private void streamError(int streamId, ErrorCode errorCode, String reason) {
            if (errorCode == ErrorCode.PROTOCOL_ERROR) {
                OkHttpServerTransport.log.log(Level.FINE, "Responding with RST_STREAM {0}: {1}", new Object[]{errorCode, reason});
            }
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.rstStream(streamId, errorCode);
                OkHttpServerTransport.this.frameWriter.flush();
                StreamState stream = (StreamState) OkHttpServerTransport.this.streams.get(Integer.valueOf(streamId));
                if (stream != null) {
                    stream.transportReportStatus(Status.INTERNAL.withDescription(String.format("Responded with RST_STREAM %s: %s", new Object[]{errorCode, reason})));
                    OkHttpServerTransport.this.streamClosed(streamId, false);
                }
            }
        }

        private void respondWithHttpError(int streamId, boolean inFinished, int httpCode, Status.Code statusCode, String msg) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, statusCode.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, msg);
            List<Header> headers = Headers.createHttpResponseHeaders(httpCode, "text/plain; charset=utf-8", metadata);
            Buffer data = new Buffer().writeUtf8(msg);
            synchronized (OkHttpServerTransport.this.lock) {
                Http2ErrorStreamState stream = new Http2ErrorStreamState(streamId, OkHttpServerTransport.this.lock, OkHttpServerTransport.this.outboundFlow, OkHttpServerTransport.this.config.flowControlWindow);
                if (OkHttpServerTransport.this.streams.isEmpty()) {
                    OkHttpServerTransport.this.keepAliveEnforcer.onTransportActive();
                    if (OkHttpServerTransport.this.maxConnectionIdleManager != null) {
                        OkHttpServerTransport.this.maxConnectionIdleManager.onTransportActive();
                    }
                }
                OkHttpServerTransport.this.streams.put(Integer.valueOf(streamId), stream);
                if (inFinished) {
                    stream.inboundDataReceived(new Buffer(), 0, true);
                }
                OkHttpServerTransport.this.frameWriter.headers(streamId, headers);
                OkHttpServerTransport.this.outboundFlow.data(true, stream.getOutboundFlowState(), data, true);
                OkHttpServerTransport.this.outboundFlow.notifyWhenNoPendingData(stream.getOutboundFlowState(), new OkHttpServerTransport$FrameHandler$$ExternalSyntheticLambda0(this, stream));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: rstOkAtEndOfHttpError */
        public void m294lambda$respondWithHttpError$0$iogrpcokhttpOkHttpServerTransport$FrameHandler(Http2ErrorStreamState stream) {
            synchronized (OkHttpServerTransport.this.lock) {
                if (!stream.hasReceivedEndOfStream()) {
                    OkHttpServerTransport.this.frameWriter.rstStream(stream.streamId, ErrorCode.NO_ERROR);
                }
                OkHttpServerTransport.this.streamClosed(stream.streamId, true);
            }
        }

        private void respondWithGrpcError(int streamId, boolean inFinished, Status.Code statusCode, String msg) {
            Metadata metadata = new Metadata();
            metadata.put(InternalStatus.CODE_KEY, statusCode.toStatus());
            metadata.put(InternalStatus.MESSAGE_KEY, msg);
            List<Header> headers = Headers.createResponseTrailers(metadata, false);
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.synReply(true, streamId, headers);
                if (!inFinished) {
                    OkHttpServerTransport.this.frameWriter.rstStream(streamId, ErrorCode.NO_ERROR);
                }
                OkHttpServerTransport.this.frameWriter.flush();
            }
        }
    }

    private final class KeepAlivePinger implements KeepAliveManager.KeepAlivePinger {
        private KeepAlivePinger() {
        }

        public void ping() {
            synchronized (OkHttpServerTransport.this.lock) {
                OkHttpServerTransport.this.frameWriter.ping(false, 0, OkHttpServerTransport.KEEPALIVE_PING);
                OkHttpServerTransport.this.frameWriter.flush();
            }
            OkHttpServerTransport.this.tracer.reportKeepAliveSent();
        }

        public void onPingTimeout() {
            synchronized (OkHttpServerTransport.this.lock) {
                Status unused = OkHttpServerTransport.this.goAwayStatus = Status.UNAVAILABLE.withDescription("Keepalive failed. Considering connection dead");
                GrpcUtil.closeQuietly((Closeable) OkHttpServerTransport.this.socket);
            }
        }
    }

    static class Http2ErrorStreamState implements StreamState, OutboundFlowController.Stream {
        private final Object lock;
        private final OutboundFlowController.StreamState outboundFlowState;
        private boolean receivedEndOfStream;
        /* access modifiers changed from: private */
        public final int streamId;
        private int window;

        Http2ErrorStreamState(int streamId2, Object lock2, OutboundFlowController outboundFlow, int initialWindowSize) {
            this.streamId = streamId2;
            this.lock = lock2;
            this.outboundFlowState = outboundFlow.createState(this, streamId2);
            this.window = initialWindowSize;
        }

        public void onSentBytes(int frameBytes) {
        }

        public void inboundDataReceived(Buffer frame, int windowConsumed, boolean endOfStream) {
            synchronized (this.lock) {
                if (endOfStream) {
                    this.receivedEndOfStream = true;
                }
                this.window -= windowConsumed;
                try {
                    frame.skip(frame.size());
                } catch (IOException ex) {
                    throw new AssertionError(ex);
                }
            }
        }

        public boolean hasReceivedEndOfStream() {
            boolean z;
            synchronized (this.lock) {
                z = this.receivedEndOfStream;
            }
            return z;
        }

        public int inboundWindowAvailable() {
            int i;
            synchronized (this.lock) {
                i = this.window;
            }
            return i;
        }

        public void transportReportStatus(Status status) {
        }

        public void inboundRstReceived(Status status) {
        }

        public OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
        }
    }
}
