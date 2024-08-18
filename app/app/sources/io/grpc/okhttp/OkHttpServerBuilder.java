package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.ForwardingServerBuilder;
import io.grpc.ServerBuilder;
import io.grpc.ServerCredentials;
import io.grpc.ServerStreamTracer;
import io.grpc.TlsServerCredentials;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.InternalServer;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerImplBuilder;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class OkHttpServerBuilder extends ForwardingServerBuilder<OkHttpServerBuilder> {
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);
    private static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    private static final ObjectPool<Executor> DEFAULT_TRANSPORT_EXECUTOR_POOL = OkHttpChannelBuilder.DEFAULT_TRANSPORT_EXECUTOR_POOL;
    static final long MAX_CONNECTION_AGE_GRACE_NANOS_INFINITE = Long.MAX_VALUE;
    static final long MAX_CONNECTION_AGE_NANOS_DISABLED = Long.MAX_VALUE;
    static final long MAX_CONNECTION_IDLE_NANOS_DISABLED = Long.MAX_VALUE;
    private static final long MIN_MAX_CONNECTION_AGE_NANO = TimeUnit.SECONDS.toNanos(1);
    private static final long MIN_MAX_CONNECTION_IDLE_NANO = TimeUnit.SECONDS.toNanos(1);
    private static final Logger log = Logger.getLogger(OkHttpServerBuilder.class.getName());
    private static final EnumSet<TlsServerCredentials.Feature> understoodTlsFeatures = EnumSet.of(TlsServerCredentials.Feature.MTLS, TlsServerCredentials.Feature.CUSTOM_MANAGERS);
    int flowControlWindow = 65535;
    final HandshakerSocketFactory handshakerSocketFactory;
    long keepAliveTimeNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
    long keepAliveTimeoutNanos = GrpcUtil.DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
    final SocketAddress listenAddress;
    long maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
    long maxConnectionAgeInNanos = Long.MAX_VALUE;
    long maxConnectionIdleInNanos = Long.MAX_VALUE;
    int maxInboundMessageSize = 4194304;
    int maxInboundMetadataSize = 8192;
    long permitKeepAliveTimeInNanos = TimeUnit.MINUTES.toNanos(5);
    boolean permitKeepAliveWithoutCalls;
    ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
    final ServerImplBuilder serverImplBuilder = new ServerImplBuilder(new OkHttpServerBuilder$$ExternalSyntheticLambda0(this));
    ServerSocketFactory socketFactory = ServerSocketFactory.getDefault();
    ObjectPool<Executor> transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
    TransportTracer.Factory transportTracerFactory = TransportTracer.getDefaultFactory();

    @Deprecated
    public static OkHttpServerBuilder forPort(int port) {
        throw new UnsupportedOperationException();
    }

    public static OkHttpServerBuilder forPort(int port, ServerCredentials creds) {
        return forPort((SocketAddress) new InetSocketAddress(port), creds);
    }

    public static OkHttpServerBuilder forPort(SocketAddress address, ServerCredentials creds) {
        HandshakerSocketFactoryResult result = handshakerSocketFactoryFrom(creds);
        if (result.error == null) {
            return new OkHttpServerBuilder(address, result.factory);
        }
        throw new IllegalArgumentException(result.error);
    }

    OkHttpServerBuilder(SocketAddress address, HandshakerSocketFactory handshakerSocketFactory2) {
        this.listenAddress = (SocketAddress) Preconditions.checkNotNull(address, "address");
        this.handshakerSocketFactory = (HandshakerSocketFactory) Preconditions.checkNotNull(handshakerSocketFactory2, "handshakerSocketFactory");
    }

    /* access modifiers changed from: protected */
    public ServerBuilder<?> delegate() {
        return this.serverImplBuilder;
    }

    /* access modifiers changed from: package-private */
    public OkHttpServerBuilder setTransportTracerFactory(TransportTracer.Factory transportTracerFactory2) {
        this.transportTracerFactory = transportTracerFactory2;
        return this;
    }

    public OkHttpServerBuilder transportExecutor(Executor transportExecutor) {
        if (transportExecutor == null) {
            this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        } else {
            this.transportExecutorPool = new FixedObjectPool(transportExecutor);
        }
        return this;
    }

    public OkHttpServerBuilder socketFactory(ServerSocketFactory socketFactory2) {
        if (socketFactory2 == null) {
            this.socketFactory = ServerSocketFactory.getDefault();
        } else {
            this.socketFactory = socketFactory2;
        }
        return this;
    }

    public OkHttpServerBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTime > 0, "keepalive time must be positive");
        this.keepAliveTimeNanos = timeUnit.toNanos(keepAliveTime);
        this.keepAliveTimeNanos = KeepAliveManager.clampKeepAliveTimeInNanos(this.keepAliveTimeNanos);
        if (this.keepAliveTimeNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    public OkHttpServerBuilder maxConnectionIdle(long maxConnectionIdle, TimeUnit timeUnit) {
        Preconditions.checkArgument(maxConnectionIdle > 0, "max connection idle must be positive: %s", maxConnectionIdle);
        this.maxConnectionIdleInNanos = timeUnit.toNanos(maxConnectionIdle);
        if (this.maxConnectionIdleInNanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionIdleInNanos = Long.MAX_VALUE;
        }
        if (this.maxConnectionIdleInNanos < MIN_MAX_CONNECTION_IDLE_NANO) {
            this.maxConnectionIdleInNanos = MIN_MAX_CONNECTION_IDLE_NANO;
        }
        return this;
    }

    public OkHttpServerBuilder maxConnectionAge(long maxConnectionAge, TimeUnit timeUnit) {
        Preconditions.checkArgument(maxConnectionAge > 0, "max connection age must be positive: %s", maxConnectionAge);
        this.maxConnectionAgeInNanos = timeUnit.toNanos(maxConnectionAge);
        if (this.maxConnectionAgeInNanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeInNanos = Long.MAX_VALUE;
        }
        if (this.maxConnectionAgeInNanos < MIN_MAX_CONNECTION_AGE_NANO) {
            this.maxConnectionAgeInNanos = MIN_MAX_CONNECTION_AGE_NANO;
        }
        return this;
    }

    public OkHttpServerBuilder maxConnectionAgeGrace(long maxConnectionAgeGrace, TimeUnit timeUnit) {
        Preconditions.checkArgument(maxConnectionAgeGrace >= 0, "max connection age grace must be non-negative: %s", maxConnectionAgeGrace);
        this.maxConnectionAgeGraceInNanos = timeUnit.toNanos(maxConnectionAgeGrace);
        if (this.maxConnectionAgeGraceInNanos >= AS_LARGE_AS_INFINITE) {
            this.maxConnectionAgeGraceInNanos = Long.MAX_VALUE;
        }
        return this;
    }

    public OkHttpServerBuilder keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTimeout > 0, "keepalive timeout must be positive");
        this.keepAliveTimeoutNanos = timeUnit.toNanos(keepAliveTimeout);
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(this.keepAliveTimeoutNanos);
        return this;
    }

    public OkHttpServerBuilder permitKeepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTime >= 0, "permit keepalive time must be non-negative: %s", keepAliveTime);
        this.permitKeepAliveTimeInNanos = timeUnit.toNanos(keepAliveTime);
        return this;
    }

    public OkHttpServerBuilder permitKeepAliveWithoutCalls(boolean permit) {
        this.permitKeepAliveWithoutCalls = permit;
        return this;
    }

    public OkHttpServerBuilder flowControlWindow(int flowControlWindow2) {
        Preconditions.checkState(flowControlWindow2 > 0, "flowControlWindow must be positive");
        this.flowControlWindow = flowControlWindow2;
        return this;
    }

    public OkHttpServerBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorServicePool = new FixedObjectPool((ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public OkHttpServerBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    public OkHttpServerBuilder maxInboundMessageSize(int bytes) {
        Preconditions.checkArgument(bytes >= 0, "negative max bytes");
        this.maxInboundMessageSize = bytes;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setStatsEnabled(boolean value) {
        this.serverImplBuilder.setStatsEnabled(value);
    }

    /* access modifiers changed from: package-private */
    public InternalServer buildTransportServers(List<? extends ServerStreamTracer.Factory> streamTracerFactories) {
        return new OkHttpServer(this, streamTracerFactories, this.serverImplBuilder.getChannelz());
    }

    /* JADX WARNING: type inference failed for: r5v17, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v17, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult handshakerSocketFactoryFrom(io.grpc.ServerCredentials r9) {
        /*
            boolean r0 = r9 instanceof io.grpc.TlsServerCredentials
            if (r0 == 0) goto L_0x013e
            r0 = r9
            io.grpc.TlsServerCredentials r0 = (io.grpc.TlsServerCredentials) r0
            java.util.EnumSet<io.grpc.TlsServerCredentials$Feature> r1 = understoodTlsFeatures
            java.util.Set r1 = r0.incomprehensible(r1)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "TLS features not understood: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r2 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r2)
            return r2
        L_0x002b:
            r2 = 0
            java.util.List r3 = r0.getKeyManagers()
            r4 = 0
            if (r3 == 0) goto L_0x0041
            java.util.List r3 = r0.getKeyManagers()
            javax.net.ssl.KeyManager[] r5 = new javax.net.ssl.KeyManager[r4]
            java.lang.Object[] r3 = r3.toArray(r5)
            r2 = r3
            javax.net.ssl.KeyManager[] r2 = (javax.net.ssl.KeyManager[]) r2
            goto L_0x0089
        L_0x0041:
            byte[] r3 = r0.getPrivateKey()
            if (r3 == 0) goto L_0x0089
            java.lang.String r3 = r0.getPrivateKeyPassword()
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = "byte[]-based private key with password unsupported. Use unencrypted file or KeyManager"
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r3 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r3)
            return r3
        L_0x0054:
            byte[] r3 = r0.getCertificateChain()     // Catch:{ GeneralSecurityException -> 0x0063 }
            byte[] r5 = r0.getPrivateKey()     // Catch:{ GeneralSecurityException -> 0x0063 }
            javax.net.ssl.KeyManager[] r3 = io.grpc.okhttp.OkHttpChannelBuilder.createKeyManager(r3, r5)     // Catch:{ GeneralSecurityException -> 0x0063 }
            r2 = r3
            goto L_0x0089
        L_0x0063:
            r3 = move-exception
            java.util.logging.Logger r4 = log
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            java.lang.String r6 = "Exception loading private key from credential"
            r4.log(r5, r6, r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unable to load private key: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r3.getMessage()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r4 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r4)
            return r4
        L_0x0089:
            r3 = 0
            java.util.List r5 = r0.getTrustManagers()
            if (r5 == 0) goto L_0x009e
            java.util.List r5 = r0.getTrustManagers()
            javax.net.ssl.TrustManager[] r6 = new javax.net.ssl.TrustManager[r4]
            java.lang.Object[] r5 = r5.toArray(r6)
            r3 = r5
            javax.net.ssl.TrustManager[] r3 = (javax.net.ssl.TrustManager[]) r3
            goto L_0x00d4
        L_0x009e:
            byte[] r5 = r0.getRootCertificates()
            if (r5 == 0) goto L_0x00d4
            byte[] r5 = r0.getRootCertificates()     // Catch:{ GeneralSecurityException -> 0x00ae }
            javax.net.ssl.TrustManager[] r5 = io.grpc.okhttp.OkHttpChannelBuilder.createTrustManager(r5)     // Catch:{ GeneralSecurityException -> 0x00ae }
            r3 = r5
            goto L_0x00d4
        L_0x00ae:
            r4 = move-exception
            java.util.logging.Logger r5 = log
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            java.lang.String r7 = "Exception loading root certificates from credential"
            r5.log(r6, r7, r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Unable to load root certificates: "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r4.getMessage()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r5 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r5)
            return r5
        L_0x00d4:
            java.lang.String r5 = "TLS"
            io.grpc.okhttp.internal.Platform r6 = io.grpc.okhttp.internal.Platform.get()     // Catch:{ GeneralSecurityException -> 0x0135 }
            java.security.Provider r6 = r6.getProvider()     // Catch:{ GeneralSecurityException -> 0x0135 }
            javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r5, r6)     // Catch:{ GeneralSecurityException -> 0x0135 }
            r6 = 0
            r5.init(r2, r3, r6)     // Catch:{ GeneralSecurityException -> 0x0135 }
            javax.net.ssl.SSLSocketFactory r6 = r5.getSocketFactory()
            int[] r7 = io.grpc.okhttp.OkHttpServerBuilder.AnonymousClass1.$SwitchMap$io$grpc$TlsServerCredentials$ClientAuth
            io.grpc.TlsServerCredentials$ClientAuth r8 = r0.getClientAuth()
            int r8 = r8.ordinal()
            r7 = r7[r8]
            switch(r7) {
                case 1: goto L_0x011f;
                case 2: goto L_0x0117;
                case 3: goto L_0x0116;
                default: goto L_0x00fa;
            }
        L_0x00fa:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = "Unknown TlsServerCredentials.ClientAuth value: "
            java.lang.StringBuilder r4 = r4.append(r7)
            io.grpc.TlsServerCredentials$ClientAuth r7 = r0.getClientAuth()
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r4 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r4)
            return r4
        L_0x0116:
            goto L_0x0126
        L_0x0117:
            io.grpc.okhttp.OkHttpServerBuilder$ClientCertRequestingSocketFactory r4 = new io.grpc.okhttp.OkHttpServerBuilder$ClientCertRequestingSocketFactory
            r7 = 1
            r4.<init>(r6, r7)
            r6 = r4
            goto L_0x0126
        L_0x011f:
            io.grpc.okhttp.OkHttpServerBuilder$ClientCertRequestingSocketFactory r7 = new io.grpc.okhttp.OkHttpServerBuilder$ClientCertRequestingSocketFactory
            r7.<init>(r6, r4)
            r6 = r7
        L_0x0126:
            io.grpc.okhttp.TlsServerHandshakerSocketFactory r4 = new io.grpc.okhttp.TlsServerHandshakerSocketFactory
            io.grpc.okhttp.SslSocketFactoryServerCredentials$ServerCredentials r7 = new io.grpc.okhttp.SslSocketFactoryServerCredentials$ServerCredentials
            r7.<init>(r6)
            r4.<init>(r7)
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r4 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.factory(r4)
            return r4
        L_0x0135:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "TLS Provider failure"
            r5.<init>(r6, r4)
            throw r5
        L_0x013e:
            boolean r0 = r9 instanceof io.grpc.InsecureServerCredentials
            if (r0 == 0) goto L_0x014c
            io.grpc.okhttp.PlaintextHandshakerSocketFactory r0 = new io.grpc.okhttp.PlaintextHandshakerSocketFactory
            r0.<init>()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r0 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.factory(r0)
            return r0
        L_0x014c:
            boolean r0 = r9 instanceof io.grpc.okhttp.SslSocketFactoryServerCredentials.ServerCredentials
            if (r0 == 0) goto L_0x015d
            r0 = r9
            io.grpc.okhttp.SslSocketFactoryServerCredentials$ServerCredentials r0 = (io.grpc.okhttp.SslSocketFactoryServerCredentials.ServerCredentials) r0
            io.grpc.okhttp.TlsServerHandshakerSocketFactory r1 = new io.grpc.okhttp.TlsServerHandshakerSocketFactory
            r1.<init>(r0)
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r1 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.factory(r1)
            return r1
        L_0x015d:
            boolean r0 = r9 instanceof io.grpc.ChoiceServerCredentials
            if (r0 == 0) goto L_0x019b
            r0 = r9
            io.grpc.ChoiceServerCredentials r0 = (io.grpc.ChoiceServerCredentials) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.List r2 = r0.getCredentialsList()
            java.util.Iterator r2 = r2.iterator()
        L_0x0171:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0191
            java.lang.Object r3 = r2.next()
            io.grpc.ServerCredentials r3 = (io.grpc.ServerCredentials) r3
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r4 = handshakerSocketFactoryFrom(r3)
            java.lang.String r5 = r4.error
            if (r5 != 0) goto L_0x0186
            return r4
        L_0x0186:
            java.lang.String r5 = ", "
            r1.append(r5)
            java.lang.String r5 = r4.error
            r1.append(r5)
            goto L_0x0171
        L_0x0191:
            r2 = 2
            java.lang.String r2 = r1.substring(r2)
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r2 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r2)
            return r2
        L_0x019b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported credential type: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult r0 = io.grpc.okhttp.OkHttpServerBuilder.HandshakerSocketFactoryResult.error(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpServerBuilder.handshakerSocketFactoryFrom(io.grpc.ServerCredentials):io.grpc.okhttp.OkHttpServerBuilder$HandshakerSocketFactoryResult");
    }

    static final class HandshakerSocketFactoryResult {
        public final String error;
        public final HandshakerSocketFactory factory;

        private HandshakerSocketFactoryResult(HandshakerSocketFactory factory2, String error2) {
            this.factory = factory2;
            this.error = error2;
        }

        public static HandshakerSocketFactoryResult error(String error2) {
            return new HandshakerSocketFactoryResult((HandshakerSocketFactory) null, (String) Preconditions.checkNotNull(error2, "error"));
        }

        public static HandshakerSocketFactoryResult factory(HandshakerSocketFactory factory2) {
            return new HandshakerSocketFactoryResult((HandshakerSocketFactory) Preconditions.checkNotNull(factory2, "factory"), (String) null);
        }
    }

    static final class ClientCertRequestingSocketFactory extends SSLSocketFactory {
        private final boolean required;
        private final SSLSocketFactory socketFactory;

        public ClientCertRequestingSocketFactory(SSLSocketFactory socketFactory2, boolean required2) {
            this.socketFactory = (SSLSocketFactory) Preconditions.checkNotNull(socketFactory2, "socketFactory");
            this.required = required2;
        }

        private Socket apply(Socket s) throws IOException {
            if (s instanceof SSLSocket) {
                SSLSocket sslSocket = (SSLSocket) s;
                if (this.required) {
                    sslSocket.setNeedClientAuth(true);
                } else {
                    sslSocket.setWantClientAuth(true);
                }
                return sslSocket;
            }
            throw new IOException("SocketFactory " + this.socketFactory + " did not produce an SSLSocket: " + s.getClass());
        }

        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            return apply(this.socketFactory.createSocket(s, host, port, autoClose));
        }

        public Socket createSocket(String host, int port) throws IOException {
            return apply(this.socketFactory.createSocket(host, port));
        }

        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
            return apply(this.socketFactory.createSocket(host, port, localHost, localPort));
        }

        public Socket createSocket(InetAddress host, int port) throws IOException {
            return apply(this.socketFactory.createSocket(host, port));
        }

        public Socket createSocket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException {
            return apply(this.socketFactory.createSocket(host, port, localAddress, localPort));
        }

        public String[] getDefaultCipherSuites() {
            return this.socketFactory.getDefaultCipherSuites();
        }

        public String[] getSupportedCipherSuites() {
            return this.socketFactory.getSupportedCipherSuites();
        }
    }
}
