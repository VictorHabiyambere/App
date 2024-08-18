package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.ConnectionSpec;
import javax.net.ssl.SSLSocketFactory;

public final class SslSocketFactoryServerCredentials {
    private SslSocketFactoryServerCredentials() {
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory factory) {
        return new ServerCredentials(factory);
    }

    public static io.grpc.ServerCredentials create(SSLSocketFactory factory, ConnectionSpec connectionSpec) {
        return new ServerCredentials(factory, Utils.convertSpec(connectionSpec));
    }

    static final class ServerCredentials extends io.grpc.ServerCredentials {
        private final io.grpc.okhttp.internal.ConnectionSpec connectionSpec;
        private final SSLSocketFactory factory;

        ServerCredentials(SSLSocketFactory factory2) {
            this(factory2, OkHttpChannelBuilder.INTERNAL_DEFAULT_CONNECTION_SPEC);
        }

        ServerCredentials(SSLSocketFactory factory2, io.grpc.okhttp.internal.ConnectionSpec connectionSpec2) {
            this.factory = (SSLSocketFactory) Preconditions.checkNotNull(factory2, "factory");
            this.connectionSpec = (io.grpc.okhttp.internal.ConnectionSpec) Preconditions.checkNotNull(connectionSpec2, "connectionSpec");
        }

        public SSLSocketFactory getFactory() {
            return this.factory;
        }

        public io.grpc.okhttp.internal.ConnectionSpec getConnectionSpec() {
            return this.connectionSpec;
        }
    }
}
