package io.grpc.okhttp;

import io.grpc.Attributes;
import io.grpc.Grpc;
import io.grpc.InternalChannelz;
import io.grpc.SecurityLevel;
import io.grpc.internal.GrpcAttributes;
import io.grpc.okhttp.HandshakerSocketFactory;
import io.grpc.okhttp.SslSocketFactoryServerCredentials;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class TlsServerHandshakerSocketFactory implements HandshakerSocketFactory {
    private final ConnectionSpec connectionSpec;
    private final PlaintextHandshakerSocketFactory delegate = new PlaintextHandshakerSocketFactory();
    private final SSLSocketFactory socketFactory;

    public TlsServerHandshakerSocketFactory(SslSocketFactoryServerCredentials.ServerCredentials credentials) {
        this.socketFactory = credentials.getFactory();
        this.connectionSpec = credentials.getConnectionSpec();
    }

    public HandshakerSocketFactory.HandshakeResult handshake(Socket socket, Attributes attributes) throws IOException {
        List list;
        HandshakerSocketFactory.HandshakeResult result = this.delegate.handshake(socket, attributes);
        Socket socket2 = this.socketFactory.createSocket(result.socket, (String) null, -1, true);
        if (socket2 instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket2;
            sslSocket.setUseClientMode(false);
            this.connectionSpec.apply(sslSocket, false);
            Protocol expectedProtocol = Protocol.HTTP_2;
            OkHttpProtocolNegotiator okHttpProtocolNegotiator = OkHttpProtocolNegotiator.get();
            if (this.connectionSpec.supportsTlsExtensions()) {
                list = Arrays.asList(new Protocol[]{expectedProtocol});
            } else {
                list = null;
            }
            String negotiatedProtocol = okHttpProtocolNegotiator.negotiate(sslSocket, (String) null, list);
            if (expectedProtocol.toString().equals(negotiatedProtocol)) {
                return new HandshakerSocketFactory.HandshakeResult(socket2, result.attributes.toBuilder().set(GrpcAttributes.ATTR_SECURITY_LEVEL, SecurityLevel.PRIVACY_AND_INTEGRITY).set(Grpc.TRANSPORT_ATTR_SSL_SESSION, sslSocket.getSession()).build(), new InternalChannelz.Security(new InternalChannelz.Tls(sslSocket.getSession())));
            }
            throw new IOException("Expected NPN/ALPN " + expectedProtocol + ": " + negotiatedProtocol);
        }
        throw new IOException("SocketFactory " + this.socketFactory + " did not produce an SSLSocket: " + socket2.getClass());
    }
}
