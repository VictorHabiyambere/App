package io.grpc.okhttp;

import androidx.webkit.Profile;
import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.CompositeCallCredentials;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.AtomicBackoff;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.FixedObjectPool;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedChannelImplBuilder;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.SharedResourcePool;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.TlsVersion;
import io.grpc.util.CertificateUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    private static final long AS_LARGE_AS_INFINITE = TimeUnit.DAYS.toNanos(1000);
    public static final int DEFAULT_FLOW_CONTROL_WINDOW = 65535;
    static final ObjectPool<Executor> DEFAULT_TRANSPORT_EXECUTOR_POOL = SharedResourcePool.forResource(SHARED_EXECUTOR);
    static final ConnectionSpec INTERNAL_DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    private static final SharedResourceHolder.Resource<Executor> SHARED_EXECUTOR = new SharedResourceHolder.Resource<Executor>() {
        public Executor create() {
            return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-okhttp-%d", true));
        }

        public void close(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }
    };
    private static final Logger log = Logger.getLogger(OkHttpChannelBuilder.class.getName());
    private static final EnumSet<TlsChannelCredentials.Feature> understoodTlsFeatures = EnumSet.of(TlsChannelCredentials.Feature.MTLS, TlsChannelCredentials.Feature.CUSTOM_MANAGERS);
    private ConnectionSpec connectionSpec;
    private int flowControlWindow;
    private final boolean freezeSecurityConfiguration;
    private HostnameVerifier hostnameVerifier;
    private long keepAliveTimeNanos;
    private long keepAliveTimeoutNanos;
    private boolean keepAliveWithoutCalls;
    private final ManagedChannelImplBuilder managedChannelImplBuilder;
    private int maxInboundMetadataSize;
    private NegotiationType negotiationType;
    private ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private ObjectPool<Executor> transportExecutorPool;
    private TransportTracer.Factory transportTracerFactory;
    private final boolean useGetForSafeMethods;

    private enum NegotiationType {
        TLS,
        PLAINTEXT
    }

    public static OkHttpChannelBuilder forAddress(String host, int port) {
        return new OkHttpChannelBuilder(host, port);
    }

    public static OkHttpChannelBuilder forAddress(String host, int port, ChannelCredentials creds) {
        return forTarget(GrpcUtil.authorityFromHostAndPort(host, port), creds);
    }

    public static OkHttpChannelBuilder forTarget(String target) {
        return new OkHttpChannelBuilder(target);
    }

    public static OkHttpChannelBuilder forTarget(String target, ChannelCredentials creds) {
        SslSocketFactoryResult result = sslSocketFactoryFrom(creds);
        if (result.error == null) {
            return new OkHttpChannelBuilder(target, creds, result.callCredentials, result.factory);
        }
        throw new IllegalArgumentException(result.error);
    }

    private OkHttpChannelBuilder(String host, int port) {
        this(GrpcUtil.authorityFromHostAndPort(host, port));
    }

    private OkHttpChannelBuilder(String target) {
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        this.scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
        this.connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
        this.negotiationType = NegotiationType.TLS;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.useGetForSafeMethods = false;
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(target, new OkHttpChannelTransportFactoryBuilder(), new OkHttpChannelDefaultPortProvider());
        this.freezeSecurityConfiguration = false;
    }

    OkHttpChannelBuilder(String target, ChannelCredentials channelCreds, CallCredentials callCreds, SSLSocketFactory factory) {
        this.transportTracerFactory = TransportTracer.getDefaultFactory();
        this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        this.scheduledExecutorServicePool = SharedResourcePool.forResource(GrpcUtil.TIMER_SERVICE);
        this.connectionSpec = INTERNAL_DEFAULT_CONNECTION_SPEC;
        this.negotiationType = NegotiationType.TLS;
        this.keepAliveTimeNanos = Long.MAX_VALUE;
        this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        this.flowControlWindow = 65535;
        this.maxInboundMetadataSize = Integer.MAX_VALUE;
        this.useGetForSafeMethods = false;
        this.managedChannelImplBuilder = new ManagedChannelImplBuilder(target, channelCreds, callCreds, new OkHttpChannelTransportFactoryBuilder(), new OkHttpChannelDefaultPortProvider());
        this.sslSocketFactory = factory;
        this.negotiationType = factory == null ? NegotiationType.PLAINTEXT : NegotiationType.TLS;
        this.freezeSecurityConfiguration = true;
    }

    private final class OkHttpChannelTransportFactoryBuilder implements ManagedChannelImplBuilder.ClientTransportFactoryBuilder {
        private OkHttpChannelTransportFactoryBuilder() {
        }

        public ClientTransportFactory buildClientTransportFactory() {
            return OkHttpChannelBuilder.this.buildTransportFactory();
        }
    }

    private final class OkHttpChannelDefaultPortProvider implements ManagedChannelImplBuilder.ChannelBuilderDefaultPortProvider {
        private OkHttpChannelDefaultPortProvider() {
        }

        public int getDefaultPort() {
            return OkHttpChannelBuilder.this.getDefaultPort();
        }
    }

    /* access modifiers changed from: protected */
    public ManagedChannelBuilder<?> delegate() {
        return this.managedChannelImplBuilder;
    }

    /* access modifiers changed from: package-private */
    public OkHttpChannelBuilder setTransportTracerFactory(TransportTracer.Factory transportTracerFactory2) {
        this.transportTracerFactory = transportTracerFactory2;
        return this;
    }

    public OkHttpChannelBuilder transportExecutor(@Nullable Executor transportExecutor) {
        if (transportExecutor == null) {
            this.transportExecutorPool = DEFAULT_TRANSPORT_EXECUTOR_POOL;
        } else {
            this.transportExecutorPool = new FixedObjectPool(transportExecutor);
        }
        return this;
    }

    public OkHttpChannelBuilder socketFactory(@Nullable SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
        return this;
    }

    @Deprecated
    public OkHttpChannelBuilder negotiationType(NegotiationType type) {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        Preconditions.checkNotNull(type, "type");
        switch (type) {
            case TLS:
                this.negotiationType = NegotiationType.TLS;
                break;
            case PLAINTEXT:
                this.negotiationType = NegotiationType.PLAINTEXT;
                break;
            default:
                throw new AssertionError("Unknown negotiation type: " + type);
        }
        return this;
    }

    public OkHttpChannelBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTime > 0, "keepalive time must be positive");
        this.keepAliveTimeNanos = timeUnit.toNanos(keepAliveTime);
        this.keepAliveTimeNanos = KeepAliveManager.clampKeepAliveTimeInNanos(this.keepAliveTimeNanos);
        if (this.keepAliveTimeNanos >= AS_LARGE_AS_INFINITE) {
            this.keepAliveTimeNanos = Long.MAX_VALUE;
        }
        return this;
    }

    public OkHttpChannelBuilder keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        Preconditions.checkArgument(keepAliveTimeout > 0, "keepalive timeout must be positive");
        this.keepAliveTimeoutNanos = timeUnit.toNanos(keepAliveTimeout);
        this.keepAliveTimeoutNanos = KeepAliveManager.clampKeepAliveTimeoutInNanos(this.keepAliveTimeoutNanos);
        return this;
    }

    public OkHttpChannelBuilder flowControlWindow(int flowControlWindow2) {
        Preconditions.checkState(flowControlWindow2 > 0, "flowControlWindow must be positive");
        this.flowControlWindow = flowControlWindow2;
        return this;
    }

    public OkHttpChannelBuilder keepAliveWithoutCalls(boolean enable) {
        this.keepAliveWithoutCalls = enable;
        return this;
    }

    public OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory factory) {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.sslSocketFactory = factory;
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public OkHttpChannelBuilder hostnameVerifier(@Nullable HostnameVerifier hostnameVerifier2) {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.hostnameVerifier = hostnameVerifier2;
        return this;
    }

    public OkHttpChannelBuilder connectionSpec(com.squareup.okhttp.ConnectionSpec connectionSpec2) {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        Preconditions.checkArgument(connectionSpec2.isTls(), "plaintext ConnectionSpec is not accepted");
        this.connectionSpec = Utils.convertSpec(connectionSpec2);
        return this;
    }

    public OkHttpChannelBuilder tlsConnectionSpec(String[] tlsVersions, String[] cipherSuites) {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        Preconditions.checkNotNull(tlsVersions, "tls versions must not null");
        Preconditions.checkNotNull(cipherSuites, "ciphers must not null");
        this.connectionSpec = new ConnectionSpec.Builder(true).supportsTlsExtensions(true).tlsVersions(tlsVersions).cipherSuites(cipherSuites).build();
        return this;
    }

    public OkHttpChannelBuilder usePlaintext() {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.negotiationType = NegotiationType.PLAINTEXT;
        return this;
    }

    public OkHttpChannelBuilder useTransportSecurity() {
        Preconditions.checkState(!this.freezeSecurityConfiguration, "Cannot change security when using ChannelCredentials");
        this.negotiationType = NegotiationType.TLS;
        return this;
    }

    public OkHttpChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorServicePool = new FixedObjectPool((ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public OkHttpChannelBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    public OkHttpChannelBuilder maxInboundMessageSize(int max) {
        Preconditions.checkArgument(max >= 0, "negative max");
        this.maxInboundMessageSize = max;
        return this;
    }

    /* access modifiers changed from: package-private */
    public OkHttpTransportFactory buildTransportFactory() {
        OkHttpTransportFactory okHttpTransportFactory = r2;
        OkHttpTransportFactory okHttpTransportFactory2 = new OkHttpTransportFactory(this.transportExecutorPool, this.scheduledExecutorServicePool, this.socketFactory, createSslSocketFactory(), this.hostnameVerifier, this.connectionSpec, this.maxInboundMessageSize, this.keepAliveTimeNanos != Long.MAX_VALUE, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory, false);
        return okHttpTransportFactory;
    }

    /* access modifiers changed from: package-private */
    public OkHttpChannelBuilder disableCheckAuthority() {
        this.managedChannelImplBuilder.disableCheckAuthority();
        return this;
    }

    /* access modifiers changed from: package-private */
    public OkHttpChannelBuilder enableCheckAuthority() {
        this.managedChannelImplBuilder.enableCheckAuthority();
        return this;
    }

    /* access modifiers changed from: package-private */
    public int getDefaultPort() {
        switch (this.negotiationType) {
            case PLAINTEXT:
                return 80;
            case TLS:
                return GrpcUtil.DEFAULT_PORT_SSL;
            default:
                throw new AssertionError(this.negotiationType + " not handled");
        }
    }

    /* access modifiers changed from: package-private */
    public void setStatsEnabled(boolean value) {
        this.managedChannelImplBuilder.setStatsEnabled(value);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public SSLSocketFactory createSslSocketFactory() {
        switch (this.negotiationType) {
            case PLAINTEXT:
                return null;
            case TLS:
                try {
                    if (this.sslSocketFactory == null) {
                        this.sslSocketFactory = SSLContext.getInstance(Profile.DEFAULT_PROFILE_NAME, Platform.get().getProvider()).getSocketFactory();
                    }
                    return this.sslSocketFactory;
                } catch (GeneralSecurityException gse) {
                    throw new RuntimeException("TLS Provider failure", gse);
                }
            default:
                throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
        }
    }

    /* JADX WARNING: type inference failed for: r4v10, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r3v17, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult sslSocketFactoryFrom(io.grpc.ChannelCredentials r8) {
        /*
            boolean r0 = r8 instanceof io.grpc.TlsChannelCredentials
            if (r0 == 0) goto L_0x00f8
            r0 = r8
            io.grpc.TlsChannelCredentials r0 = (io.grpc.TlsChannelCredentials) r0
            java.util.EnumSet<io.grpc.TlsChannelCredentials$Feature> r1 = understoodTlsFeatures
            java.util.Set r1 = r0.incomprehensible(r1)
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "TLS features not understood: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r2 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r2)
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
            goto L_0x0088
        L_0x0041:
            byte[] r3 = r0.getPrivateKey()
            if (r3 == 0) goto L_0x0088
            java.lang.String r3 = r0.getPrivateKeyPassword()
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = "byte[]-based private key with password unsupported. Use unencrypted file or KeyManager"
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r3 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r3)
            return r3
        L_0x0054:
            byte[] r3 = r0.getCertificateChain()     // Catch:{ GeneralSecurityException -> 0x0062 }
            byte[] r5 = r0.getPrivateKey()     // Catch:{ GeneralSecurityException -> 0x0062 }
            javax.net.ssl.KeyManager[] r3 = createKeyManager(r3, r5)     // Catch:{ GeneralSecurityException -> 0x0062 }
            r2 = r3
            goto L_0x0088
        L_0x0062:
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
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r4 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r4)
            return r4
        L_0x0088:
            r3 = 0
            java.util.List r5 = r0.getTrustManagers()
            if (r5 == 0) goto L_0x009d
            java.util.List r5 = r0.getTrustManagers()
            javax.net.ssl.TrustManager[] r4 = new javax.net.ssl.TrustManager[r4]
            java.lang.Object[] r4 = r5.toArray(r4)
            r3 = r4
            javax.net.ssl.TrustManager[] r3 = (javax.net.ssl.TrustManager[]) r3
            goto L_0x00d3
        L_0x009d:
            byte[] r4 = r0.getRootCertificates()
            if (r4 == 0) goto L_0x00d3
            byte[] r4 = r0.getRootCertificates()     // Catch:{ GeneralSecurityException -> 0x00ad }
            javax.net.ssl.TrustManager[] r4 = createTrustManager(r4)     // Catch:{ GeneralSecurityException -> 0x00ad }
            r3 = r4
            goto L_0x00d3
        L_0x00ad:
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
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r5 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r5)
            return r5
        L_0x00d3:
            java.lang.String r4 = "TLS"
            io.grpc.okhttp.internal.Platform r5 = io.grpc.okhttp.internal.Platform.get()     // Catch:{ GeneralSecurityException -> 0x00ef }
            java.security.Provider r5 = r5.getProvider()     // Catch:{ GeneralSecurityException -> 0x00ef }
            javax.net.ssl.SSLContext r4 = javax.net.ssl.SSLContext.getInstance(r4, r5)     // Catch:{ GeneralSecurityException -> 0x00ef }
            r5 = 0
            r4.init(r2, r3, r5)     // Catch:{ GeneralSecurityException -> 0x00ef }
            javax.net.ssl.SSLSocketFactory r5 = r4.getSocketFactory()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r5 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.factory(r5)
            return r5
        L_0x00ef:
            r4 = move-exception
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "TLS Provider failure"
            r5.<init>(r6, r4)
            throw r5
        L_0x00f8:
            boolean r0 = r8 instanceof io.grpc.InsecureChannelCredentials
            if (r0 == 0) goto L_0x0101
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r0 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.plaintext()
            return r0
        L_0x0101:
            boolean r0 = r8 instanceof io.grpc.CompositeChannelCredentials
            if (r0 == 0) goto L_0x0119
            r0 = r8
            io.grpc.CompositeChannelCredentials r0 = (io.grpc.CompositeChannelCredentials) r0
            io.grpc.ChannelCredentials r1 = r0.getChannelCredentials()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r1 = sslSocketFactoryFrom(r1)
            io.grpc.CallCredentials r2 = r0.getCallCredentials()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r1 = r1.withCallCredentials(r2)
            return r1
        L_0x0119:
            boolean r0 = r8 instanceof io.grpc.okhttp.SslSocketFactoryChannelCredentials.ChannelCredentials
            if (r0 == 0) goto L_0x0129
            r0 = r8
            io.grpc.okhttp.SslSocketFactoryChannelCredentials$ChannelCredentials r0 = (io.grpc.okhttp.SslSocketFactoryChannelCredentials.ChannelCredentials) r0
            javax.net.ssl.SSLSocketFactory r1 = r0.getFactory()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r1 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.factory(r1)
            return r1
        L_0x0129:
            boolean r0 = r8 instanceof io.grpc.ChoiceChannelCredentials
            if (r0 == 0) goto L_0x0167
            r0 = r8
            io.grpc.ChoiceChannelCredentials r0 = (io.grpc.ChoiceChannelCredentials) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.List r2 = r0.getCredentialsList()
            java.util.Iterator r2 = r2.iterator()
        L_0x013d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x015d
            java.lang.Object r3 = r2.next()
            io.grpc.ChannelCredentials r3 = (io.grpc.ChannelCredentials) r3
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r4 = sslSocketFactoryFrom(r3)
            java.lang.String r5 = r4.error
            if (r5 != 0) goto L_0x0152
            return r4
        L_0x0152:
            java.lang.String r5 = ", "
            r1.append(r5)
            java.lang.String r5 = r4.error
            r1.append(r5)
            goto L_0x013d
        L_0x015d:
            r2 = 2
            java.lang.String r2 = r1.substring(r2)
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r2 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r2)
            return r2
        L_0x0167:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported credential type: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class r1 = r8.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult r0 = io.grpc.okhttp.OkHttpChannelBuilder.SslSocketFactoryResult.error(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpChannelBuilder.sslSocketFactoryFrom(io.grpc.ChannelCredentials):io.grpc.okhttp.OkHttpChannelBuilder$SslSocketFactoryResult");
    }

    /* JADX INFO: finally extract failed */
    static KeyManager[] createKeyManager(byte[] certChain, byte[] privateKey) throws GeneralSecurityException {
        ByteArrayInputStream inCertChain = new ByteArrayInputStream(certChain);
        try {
            X509Certificate[] chain = CertificateUtils.getX509Certificates(inCertChain);
            GrpcUtil.closeQuietly((Closeable) inCertChain);
            ByteArrayInputStream inPrivateKey = new ByteArrayInputStream(privateKey);
            try {
                PrivateKey key = CertificateUtils.getPrivateKey(inPrivateKey);
                GrpcUtil.closeQuietly((Closeable) inPrivateKey);
                KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
                try {
                    ks.load((InputStream) null, (char[]) null);
                    ks.setKeyEntry("key", key, new char[0], chain);
                    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                    keyManagerFactory.init(ks, new char[0]);
                    return keyManagerFactory.getKeyManagers();
                } catch (IOException ex) {
                    throw new GeneralSecurityException(ex);
                }
            } catch (IOException uee) {
                throw new GeneralSecurityException("Unable to decode private key", uee);
            } catch (Throwable th) {
                GrpcUtil.closeQuietly((Closeable) inPrivateKey);
                throw th;
            }
        } catch (Throwable th2) {
            GrpcUtil.closeQuietly((Closeable) inCertChain);
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    static TrustManager[] createTrustManager(byte[] rootCerts) throws GeneralSecurityException {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            ks.load((InputStream) null, (char[]) null);
            ByteArrayInputStream in = new ByteArrayInputStream(rootCerts);
            try {
                X509Certificate[] certs = CertificateUtils.getX509Certificates(in);
                GrpcUtil.closeQuietly((Closeable) in);
                for (X509Certificate cert : certs) {
                    ks.setCertificateEntry(cert.getSubjectX500Principal().getName("RFC2253"), cert);
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(ks);
                return trustManagerFactory.getTrustManagers();
            } catch (Throwable th) {
                GrpcUtil.closeQuietly((Closeable) in);
                throw th;
            }
        } catch (IOException ex) {
            throw new GeneralSecurityException(ex);
        }
    }

    static final class SslSocketFactoryResult {
        public final CallCredentials callCredentials;
        public final String error;
        public final SSLSocketFactory factory;

        private SslSocketFactoryResult(SSLSocketFactory factory2, CallCredentials creds, String error2) {
            this.factory = factory2;
            this.callCredentials = creds;
            this.error = error2;
        }

        public static SslSocketFactoryResult error(String error2) {
            return new SslSocketFactoryResult((SSLSocketFactory) null, (CallCredentials) null, (String) Preconditions.checkNotNull(error2, "error"));
        }

        public static SslSocketFactoryResult plaintext() {
            return new SslSocketFactoryResult((SSLSocketFactory) null, (CallCredentials) null, (String) null);
        }

        public static SslSocketFactoryResult factory(SSLSocketFactory factory2) {
            return new SslSocketFactoryResult((SSLSocketFactory) Preconditions.checkNotNull(factory2, "factory"), (CallCredentials) null, (String) null);
        }

        public SslSocketFactoryResult withCallCredentials(CallCredentials callCreds) {
            Preconditions.checkNotNull(callCreds, "callCreds");
            if (this.error != null) {
                return this;
            }
            if (this.callCredentials != null) {
                callCreds = new CompositeCallCredentials(this.callCredentials, callCreds);
            }
            return new SslSocketFactoryResult(this.factory, callCreds, (String) null);
        }
    }

    static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        final ConnectionSpec connectionSpec;
        private final boolean enableKeepAlive;
        final Executor executor;
        private final ObjectPool<Executor> executorPool;
        final int flowControlWindow;
        @Nullable
        final HostnameVerifier hostnameVerifier;
        private final AtomicBackoff keepAliveBackoff;
        private final long keepAliveTimeNanos;
        private final long keepAliveTimeoutNanos;
        private final boolean keepAliveWithoutCalls;
        final int maxInboundMetadataSize;
        final int maxMessageSize;
        final ScheduledExecutorService scheduledExecutorService;
        private final ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool;
        final SocketFactory socketFactory;
        @Nullable
        final SSLSocketFactory sslSocketFactory;
        final TransportTracer.Factory transportTracerFactory;
        final boolean useGetForSafeMethods;

        private OkHttpTransportFactory(ObjectPool<Executor> executorPool2, ObjectPool<ScheduledExecutorService> scheduledExecutorServicePool2, @Nullable SocketFactory socketFactory2, @Nullable SSLSocketFactory sslSocketFactory2, @Nullable HostnameVerifier hostnameVerifier2, ConnectionSpec connectionSpec2, int maxMessageSize2, boolean enableKeepAlive2, long keepAliveTimeNanos2, long keepAliveTimeoutNanos2, int flowControlWindow2, boolean keepAliveWithoutCalls2, int maxInboundMetadataSize2, TransportTracer.Factory transportTracerFactory2, boolean useGetForSafeMethods2) {
            long j = keepAliveTimeNanos2;
            this.executorPool = executorPool2;
            this.executor = executorPool2.getObject();
            this.scheduledExecutorServicePool = scheduledExecutorServicePool2;
            this.scheduledExecutorService = scheduledExecutorServicePool2.getObject();
            this.socketFactory = socketFactory2;
            this.sslSocketFactory = sslSocketFactory2;
            this.hostnameVerifier = hostnameVerifier2;
            this.connectionSpec = connectionSpec2;
            this.maxMessageSize = maxMessageSize2;
            this.enableKeepAlive = enableKeepAlive2;
            this.keepAliveTimeNanos = j;
            this.keepAliveBackoff = new AtomicBackoff("keepalive time nanos", j);
            this.keepAliveTimeoutNanos = keepAliveTimeoutNanos2;
            this.flowControlWindow = flowControlWindow2;
            this.keepAliveWithoutCalls = keepAliveWithoutCalls2;
            this.maxInboundMetadataSize = maxInboundMetadataSize2;
            this.useGetForSafeMethods = useGetForSafeMethods2;
            this.transportTracerFactory = (TransportTracer.Factory) Preconditions.checkNotNull(transportTracerFactory2, "transportTracerFactory");
        }

        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            if (!this.closed) {
                final AtomicBackoff.State keepAliveTimeNanosState = this.keepAliveBackoff.getState();
                InetSocketAddress inetSocketAddress = (InetSocketAddress) addr;
                OkHttpClientTransport transport = new OkHttpClientTransport(this, inetSocketAddress, options.getAuthority(), options.getUserAgent(), options.getEagAttributes(), options.getHttpConnectProxiedSocketAddress(), new Runnable() {
                    public void run() {
                        keepAliveTimeNanosState.backoff();
                    }
                });
                if (this.enableKeepAlive) {
                    transport.enableKeepAlive(true, keepAliveTimeNanosState.get(), this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
                }
                return transport;
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            return this.scheduledExecutorService;
        }

        @CheckReturnValue
        @Nullable
        public ClientTransportFactory.SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCreds) {
            SslSocketFactoryResult result = OkHttpChannelBuilder.sslSocketFactoryFrom(channelCreds);
            if (result.error != null) {
                return null;
            }
            return new ClientTransportFactory.SwapChannelCredentialsResult(new OkHttpTransportFactory(this.executorPool, this.scheduledExecutorServicePool, this.socketFactory, result.factory, this.hostnameVerifier, this.connectionSpec, this.maxMessageSize, this.enableKeepAlive, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.flowControlWindow, this.keepAliveWithoutCalls, this.maxInboundMetadataSize, this.transportTracerFactory, this.useGetForSafeMethods), result.callCredentials);
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                this.executorPool.returnObject(this.executor);
                this.scheduledExecutorServicePool.returnObject(this.scheduledExecutorService);
            }
        }
    }
}
