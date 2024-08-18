package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.InternalChannelz;
import java.io.IOException;
import java.net.Socket;

interface HandshakerSocketFactory {
    HandshakeResult handshake(Socket socket, Attributes attributes) throws IOException;

    public static final class HandshakeResult {
        public final Attributes attributes;
        public final InternalChannelz.Security securityInfo;
        public final Socket socket;

        public HandshakeResult(Socket socket2, Attributes attributes2, InternalChannelz.Security securityInfo2) {
            this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
            this.attributes = (Attributes) Preconditions.checkNotNull(attributes2, "attributes");
            this.securityInfo = securityInfo2;
        }
    }
}
