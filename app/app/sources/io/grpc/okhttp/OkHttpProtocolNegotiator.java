package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.internal.GrpcUtil;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

class OkHttpProtocolNegotiator {
    private static final Platform DEFAULT_PLATFORM = Platform.get();
    private static OkHttpProtocolNegotiator NEGOTIATOR;
    /* access modifiers changed from: private */
    public static final Logger logger;
    protected final Platform platform;

    static {
        Class<OkHttpProtocolNegotiator> cls = OkHttpProtocolNegotiator.class;
        logger = Logger.getLogger(cls.getName());
        NEGOTIATOR = createNegotiator(cls.getClassLoader());
    }

    OkHttpProtocolNegotiator(Platform platform2) {
        this.platform = (Platform) Preconditions.checkNotNull(platform2, "platform");
    }

    public static OkHttpProtocolNegotiator get() {
        return NEGOTIATOR;
    }

    static OkHttpProtocolNegotiator createNegotiator(ClassLoader loader) {
        boolean android2 = true;
        try {
            loader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e1) {
            logger.log(Level.FINE, "Unable to find Conscrypt. Skipping", e1);
            try {
                loader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", e2);
                android2 = false;
            }
        }
        if (android2) {
            return new AndroidNegotiator(DEFAULT_PLATFORM);
        }
        return new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
    }

    public String negotiate(SSLSocket sslSocket, String hostname, @Nullable List<Protocol> protocols) throws IOException {
        if (protocols != null) {
            configureTlsExtensions(sslSocket, hostname, protocols);
        }
        try {
            sslSocket.startHandshake();
            String negotiatedProtocol = getSelectedProtocol(sslSocket);
            if (negotiatedProtocol != null) {
                return negotiatedProtocol;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + protocols);
        } finally {
            this.platform.afterHandshake(sslSocket);
        }
    }

    /* access modifiers changed from: protected */
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<Protocol> protocols) {
        this.platform.configureTlsExtensions(sslSocket, hostname, protocols);
    }

    public String getSelectedProtocol(SSLSocket socket) {
        return this.platform.getSelectedProtocol(socket);
    }

    static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
        private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOL;
        private static final Method GET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL;
        private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS;
        private static final Method SET_APPLICATION_PROTOCOLS;
        private static final OptionalMethod<Socket> SET_HOSTNAME = new OptionalMethod<>((Class<?>) null, "setHostname", String.class);
        private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS;
        private static final Method SET_SERVER_NAMES;
        private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS = new OptionalMethod<>((Class<?>) null, "setUseSessionTickets", Boolean.TYPE);
        private static final Constructor<?> SNI_HOST_NAME;
        private static final Method SSL_SOCKETS_IS_SUPPORTED_SOCKET;
        private static final Method SSL_SOCKETS_SET_USE_SESSION_TICKET;

        static {
            Class<byte[]> cls = byte[].class;
            GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod<>(cls, "getAlpnSelectedProtocol", new Class[0]);
            SET_ALPN_PROTOCOLS = new OptionalMethod<>((Class<?>) null, "setAlpnProtocols", cls);
            GET_NPN_SELECTED_PROTOCOL = new OptionalMethod<>(cls, "getNpnSelectedProtocol", new Class[0]);
            SET_NPN_PROTOCOLS = new OptionalMethod<>((Class<?>) null, "setNpnProtocols", cls);
            Method setApplicationProtocolsMethod = null;
            Method getApplicationProtocolsMethod = null;
            Method getApplicationProtocolMethod = null;
            Method sslSocketsIsSupportedSocketMethod = null;
            Method sslSocketsSetUseSessionTicketsMethod = null;
            Class<SSLParameters> cls2 = SSLParameters.class;
            try {
                setApplicationProtocolsMethod = cls2.getMethod("setApplicationProtocols", new Class[]{String[].class});
                getApplicationProtocolsMethod = cls2.getMethod("getApplicationProtocols", new Class[0]);
                getApplicationProtocolMethod = SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                Class<?> sslSockets = Class.forName("android.net.ssl.SSLSockets");
                sslSocketsIsSupportedSocketMethod = sslSockets.getMethod("isSupportedSocket", new Class[]{SSLSocket.class});
                sslSocketsSetUseSessionTicketsMethod = sslSockets.getMethod("setUseSessionTickets", new Class[]{SSLSocket.class, Boolean.TYPE});
            } catch (ClassNotFoundException e) {
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
            } catch (NoSuchMethodException e2) {
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", e2);
            }
            SET_APPLICATION_PROTOCOLS = setApplicationProtocolsMethod;
            GET_APPLICATION_PROTOCOLS = getApplicationProtocolsMethod;
            GET_APPLICATION_PROTOCOL = getApplicationProtocolMethod;
            SSL_SOCKETS_IS_SUPPORTED_SOCKET = sslSocketsIsSupportedSocketMethod;
            SSL_SOCKETS_SET_USE_SESSION_TICKET = sslSocketsSetUseSessionTicketsMethod;
            Method setServerNamesMethod = null;
            Constructor<?> sniHostNameConstructor = null;
            try {
                setServerNamesMethod = SSLParameters.class.getMethod("setServerNames", new Class[]{List.class});
                sniHostNameConstructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{String.class});
            } catch (ClassNotFoundException e3) {
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", e3);
            } catch (NoSuchMethodException e4) {
                OkHttpProtocolNegotiator.logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", e4);
            }
            SET_SERVER_NAMES = setServerNamesMethod;
            SNI_HOST_NAME = sniHostNameConstructor;
        }

        AndroidNegotiator(Platform platform) {
            super(platform);
        }

        public String negotiate(SSLSocket sslSocket, String hostname, List<Protocol> protocols) throws IOException {
            String negotiatedProtocol = getSelectedProtocol(sslSocket);
            if (negotiatedProtocol == null) {
                return OkHttpProtocolNegotiator.super.negotiate(sslSocket, hostname, protocols);
            }
            return negotiatedProtocol;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e9, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ef, code lost:
            throw new java.lang.RuntimeException(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f7, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fd, code lost:
            throw new java.lang.RuntimeException(r2);
         */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e9 A[ExcHandler: InstantiationException (r2v2 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7 A[ExcHandler: IllegalAccessException (r2v0 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void configureTlsExtensions(javax.net.ssl.SSLSocket r10, java.lang.String r11, java.util.List<io.grpc.okhttp.internal.Protocol> r12) {
            /*
                r9 = this;
                java.lang.String[] r0 = io.grpc.okhttp.OkHttpProtocolNegotiator.protocolIds(r12)
                javax.net.ssl.SSLParameters r1 = r10.getSSLParameters()
                if (r11 == 0) goto L_0x006c
                boolean r2 = isValidHostName(r11)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r2 == 0) goto L_0x006c
                java.lang.reflect.Method r2 = SSL_SOCKETS_IS_SUPPORTED_SOCKET     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r3 = 1
                if (r2 == 0) goto L_0x0036
                java.lang.reflect.Method r2 = SSL_SOCKETS_IS_SUPPORTED_SOCKET     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r4 = new java.lang.Object[]{r10}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r5 = 0
                java.lang.Object r2 = r2.invoke(r5, r4)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                boolean r2 = r2.booleanValue()     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r2 == 0) goto L_0x0036
                java.lang.reflect.Method r2 = SSL_SOCKETS_SET_USE_SESSION_TICKET     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r3 = new java.lang.Object[]{r10, r3}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r2.invoke(r5, r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                goto L_0x0043
            L_0x0036:
                io.grpc.okhttp.internal.OptionalMethod<java.net.Socket> r2 = SET_USE_SESSION_TICKETS     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r2.invokeOptionalWithoutCheckedException(r10, r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
            L_0x0043:
                java.lang.reflect.Method r2 = SET_SERVER_NAMES     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r2 == 0) goto L_0x0063
                java.lang.reflect.Constructor<?> r2 = SNI_HOST_NAME     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r2 == 0) goto L_0x0063
                java.lang.reflect.Method r2 = SET_SERVER_NAMES     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.reflect.Constructor<?> r3 = SNI_HOST_NAME     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r4 = new java.lang.Object[]{r11}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.util.List r3 = java.util.Collections.singletonList(r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r2.invoke(r1, r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                goto L_0x006c
            L_0x0063:
                io.grpc.okhttp.internal.OptionalMethod<java.net.Socket> r2 = SET_HOSTNAME     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r3 = new java.lang.Object[]{r11}     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r2.invokeOptionalWithoutCheckedException(r10, r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
            L_0x006c:
                r2 = 0
                java.lang.reflect.Method r3 = GET_APPLICATION_PROTOCOL     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                r4 = 0
                if (r3 == 0) goto L_0x009b
                java.lang.reflect.Method r3 = GET_APPLICATION_PROTOCOL     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                r3.invoke(r10, r5)     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                java.lang.reflect.Method r3 = SET_APPLICATION_PROTOCOLS     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                java.lang.Object[] r5 = new java.lang.Object[]{r0}     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                r3.invoke(r1, r5)     // Catch:{ InvocationTargetException -> 0x0084, IllegalAccessException -> 0x00f7, InstantiationException -> 0x00e9 }
                r2 = 1
                goto L_0x009b
            L_0x0084:
                r3 = move-exception
                java.lang.Throwable r5 = r3.getTargetException()     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                boolean r6 = r5 instanceof java.lang.UnsupportedOperationException     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r6 == 0) goto L_0x0099
                java.util.logging.Logger r6 = io.grpc.okhttp.OkHttpProtocolNegotiator.logger     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.util.logging.Level r7 = java.util.logging.Level.FINER     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.String r8 = "setApplicationProtocol unsupported, will try old methods"
                r6.log(r7, r8)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                goto L_0x009b
            L_0x0099:
                throw r3     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
            L_0x009b:
                r10.setSSLParameters(r1)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r2 == 0) goto L_0x00b9
                java.lang.reflect.Method r3 = GET_APPLICATION_PROTOCOLS     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r3 == 0) goto L_0x00b9
                java.lang.reflect.Method r3 = GET_APPLICATION_PROTOCOLS     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                javax.net.ssl.SSLParameters r5 = r10.getSSLParameters()     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.Object r3 = r3.invoke(r5, r4)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                boolean r4 = java.util.Arrays.equals(r0, r3)     // Catch:{ IllegalAccessException -> 0x00f7, InvocationTargetException -> 0x00f0, InstantiationException -> 0x00e9 }
                if (r4 == 0) goto L_0x00b9
                return
            L_0x00b9:
                byte[] r2 = io.grpc.okhttp.internal.Platform.concatLengthPrefixed(r12)
                java.lang.Object[] r2 = new java.lang.Object[]{r2}
                io.grpc.okhttp.internal.Platform r3 = r9.platform
                io.grpc.okhttp.internal.Platform$TlsExtensionType r3 = r3.getTlsExtensionType()
                io.grpc.okhttp.internal.Platform$TlsExtensionType r4 = io.grpc.okhttp.internal.Platform.TlsExtensionType.ALPN_AND_NPN
                if (r3 != r4) goto L_0x00d1
                io.grpc.okhttp.internal.OptionalMethod<java.net.Socket> r3 = SET_ALPN_PROTOCOLS
                r3.invokeWithoutCheckedException(r10, r2)
            L_0x00d1:
                io.grpc.okhttp.internal.Platform r3 = r9.platform
                io.grpc.okhttp.internal.Platform$TlsExtensionType r3 = r3.getTlsExtensionType()
                io.grpc.okhttp.internal.Platform$TlsExtensionType r4 = io.grpc.okhttp.internal.Platform.TlsExtensionType.NONE
                if (r3 == r4) goto L_0x00e1
                io.grpc.okhttp.internal.OptionalMethod<java.net.Socket> r3 = SET_NPN_PROTOCOLS
                r3.invokeWithoutCheckedException(r10, r2)
                return
            L_0x00e1:
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                java.lang.String r4 = "We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS"
                r3.<init>(r4)
                throw r3
            L_0x00e9:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            L_0x00f0:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            L_0x00f7:
                r2 = move-exception
                java.lang.RuntimeException r3 = new java.lang.RuntimeException
                r3.<init>(r2)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpProtocolNegotiator.AndroidNegotiator.configureTlsExtensions(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        public String getSelectedProtocol(SSLSocket socket) {
            if (GET_APPLICATION_PROTOCOL != null) {
                try {
                    return (String) GET_APPLICATION_PROTOCOL.invoke(socket, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    if (e2.getTargetException() instanceof UnsupportedOperationException) {
                        OkHttpProtocolNegotiator.logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                    } else {
                        throw new RuntimeException(e2);
                    }
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] alpnResult = (byte[]) GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(socket, new Object[0]);
                    if (alpnResult != null) {
                        return new String(alpnResult, Util.UTF_8);
                    }
                } catch (Exception e3) {
                    OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", e3);
                }
            }
            if (this.platform.getTlsExtensionType() == Platform.TlsExtensionType.NONE) {
                return null;
            }
            try {
                byte[] npnResult = (byte[]) GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(socket, new Object[0]);
                if (npnResult != null) {
                    return new String(npnResult, Util.UTF_8);
                }
                return null;
            } catch (Exception e4) {
                OkHttpProtocolNegotiator.logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", e4);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static String[] protocolIds(List<Protocol> protocols) {
        List<String> result = new ArrayList<>();
        for (Protocol protocol : protocols) {
            result.add(protocol.toString());
        }
        return (String[]) result.toArray(new String[0]);
    }

    static boolean isValidHostName(String name) {
        if (name.contains("_")) {
            return false;
        }
        try {
            GrpcUtil.checkAuthority(name);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
