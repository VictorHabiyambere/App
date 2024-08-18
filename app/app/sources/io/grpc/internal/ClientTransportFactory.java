package io.grpc.internal;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.ChannelLogger;
import io.grpc.HttpConnectProxiedSocketAddress;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public interface ClientTransportFactory extends Closeable {
    void close();

    ScheduledExecutorService getScheduledExecutorService();

    ConnectionClientTransport newClientTransport(SocketAddress socketAddress, ClientTransportOptions clientTransportOptions, ChannelLogger channelLogger);

    @CheckReturnValue
    @Nullable
    SwapChannelCredentialsResult swapChannelCredentials(ChannelCredentials channelCredentials);

    public static final class ClientTransportOptions {
        private String authority = "unknown-authority";
        private ChannelLogger channelLogger;
        @Nullable
        private HttpConnectProxiedSocketAddress connectProxiedSocketAddr;
        private Attributes eagAttributes = Attributes.EMPTY;
        @Nullable
        private String userAgent;

        public ChannelLogger getChannelLogger() {
            return this.channelLogger;
        }

        public ClientTransportOptions setChannelLogger(ChannelLogger channelLogger2) {
            this.channelLogger = channelLogger2;
            return this;
        }

        public String getAuthority() {
            return this.authority;
        }

        public ClientTransportOptions setAuthority(String authority2) {
            this.authority = (String) Preconditions.checkNotNull(authority2, "authority");
            return this;
        }

        public Attributes getEagAttributes() {
            return this.eagAttributes;
        }

        public ClientTransportOptions setEagAttributes(Attributes eagAttributes2) {
            Preconditions.checkNotNull(eagAttributes2, "eagAttributes");
            this.eagAttributes = eagAttributes2;
            return this;
        }

        @Nullable
        public String getUserAgent() {
            return this.userAgent;
        }

        public ClientTransportOptions setUserAgent(@Nullable String userAgent2) {
            this.userAgent = userAgent2;
            return this;
        }

        @Nullable
        public HttpConnectProxiedSocketAddress getHttpConnectProxiedSocketAddress() {
            return this.connectProxiedSocketAddr;
        }

        public ClientTransportOptions setHttpConnectProxiedSocketAddress(@Nullable HttpConnectProxiedSocketAddress connectProxiedSocketAddr2) {
            this.connectProxiedSocketAddr = connectProxiedSocketAddr2;
            return this;
        }

        public int hashCode() {
            return Objects.hashCode(this.authority, this.eagAttributes, this.userAgent, this.connectProxiedSocketAddr);
        }

        public boolean equals(Object o) {
            if (!(o instanceof ClientTransportOptions)) {
                return false;
            }
            ClientTransportOptions that = (ClientTransportOptions) o;
            if (!this.authority.equals(that.authority) || !this.eagAttributes.equals(that.eagAttributes) || !Objects.equal(this.userAgent, that.userAgent) || !Objects.equal(this.connectProxiedSocketAddr, that.connectProxiedSocketAddr)) {
                return false;
            }
            return true;
        }
    }

    public static final class SwapChannelCredentialsResult {
        @Nullable
        final CallCredentials callCredentials;
        final ClientTransportFactory transportFactory;

        public SwapChannelCredentialsResult(ClientTransportFactory transportFactory2, @Nullable CallCredentials callCredentials2) {
            this.transportFactory = (ClientTransportFactory) Preconditions.checkNotNull(transportFactory2, "transportFactory");
            this.callCredentials = callCredentials2;
        }
    }
}
