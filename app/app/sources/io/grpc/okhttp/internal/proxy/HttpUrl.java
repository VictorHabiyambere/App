package io.grpc.okhttp.internal.proxy;

import androidx.webkit.ProxyConfig;
import io.grpc.internal.GrpcUtil;
import java.io.EOFException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import okio.Buffer;

public final class HttpUrl {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String host;
    private final int port;
    private final String scheme;
    private final String url;

    private HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.url = builder.toString();
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals(ProxyConfig.MATCH_HTTPS);
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(String scheme2) {
        if (scheme2.equals(ProxyConfig.MATCH_HTTP)) {
            return 80;
        }
        if (scheme2.equals(ProxyConfig.MATCH_HTTPS)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    public Builder newBuilder() {
        Builder result = new Builder();
        result.scheme = this.scheme;
        result.host = this.host;
        result.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        return result;
    }

    public boolean equals(Object o) {
        return (o instanceof HttpUrl) && ((HttpUrl) o).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public static final class Builder {
        String host;
        int port = -1;
        String scheme;

        public Builder scheme(String scheme2) {
            if (scheme2 != null) {
                if (scheme2.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
                    this.scheme = ProxyConfig.MATCH_HTTP;
                } else if (scheme2.equalsIgnoreCase(ProxyConfig.MATCH_HTTPS)) {
                    this.scheme = ProxyConfig.MATCH_HTTPS;
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme2);
                }
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public Builder host(String host2) {
            if (host2 != null) {
                String encoded = canonicalizeHost(host2, 0, host2.length());
                if (encoded != null) {
                    this.host = encoded;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + host2);
            }
            throw new IllegalArgumentException("host == null");
        }

        public Builder port(int port2) {
            if (port2 <= 0 || port2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + port2);
            }
            this.port = port2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public int effectivePort() {
            return this.port != -1 ? this.port : HttpUrl.defaultPort(this.scheme);
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.host != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append(this.scheme);
            result.append("://");
            if (this.host.indexOf(58) != -1) {
                result.append('[');
                result.append(this.host);
                result.append(']');
            } else {
                result.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.defaultPort(this.scheme)) {
                result.append(':');
                result.append(effectivePort);
            }
            return result.toString();
        }

        private static String canonicalizeHost(String input, int pos, int limit) {
            String percentDecoded = HttpUrl.percentDecode(input, pos, limit, false);
            if (!percentDecoded.startsWith("[") || !percentDecoded.endsWith("]")) {
                return domainToAscii(percentDecoded);
            }
            InetAddress inetAddress = decodeIpv6(percentDecoded, 1, percentDecoded.length() - 1);
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError();
        }

        private static InetAddress decodeIpv6(String input, int pos, int limit) {
            byte[] address = new byte[16];
            int b = 0;
            int compress = -1;
            int groupOffset = -1;
            int i = pos;
            while (true) {
                if (i >= limit) {
                    break;
                } else if (b == address.length) {
                    return null;
                } else {
                    if (i + 2 <= limit && input.regionMatches(i, "::", 0, 2)) {
                        if (compress == -1) {
                            i += 2;
                            b += 2;
                            compress = b;
                            if (i == limit) {
                                break;
                            }
                        } else {
                            return null;
                        }
                    } else if (b != 0) {
                        if (input.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!input.regionMatches(i, ".", 0, 1) || !decodeIpv4Suffix(input, groupOffset, limit, address, b - 2)) {
                            return null;
                        } else {
                            b += 2;
                        }
                    }
                    int value = 0;
                    groupOffset = i;
                    while (i < limit) {
                        int hexDigit = HttpUrl.decodeHexDigit(input.charAt(i));
                        if (hexDigit == -1) {
                            break;
                        }
                        value = (value << 4) + hexDigit;
                        i++;
                    }
                    int groupLength = i - groupOffset;
                    if (groupLength == 0 || groupLength > 4) {
                        return null;
                    }
                    int b2 = b + 1;
                    address[b] = (byte) ((value >>> 8) & 255);
                    b = b2 + 1;
                    address[b2] = (byte) (value & 255);
                }
            }
            if (b != address.length) {
                if (compress == -1) {
                    return null;
                }
                System.arraycopy(address, compress, address, address.length - (b - compress), b - compress);
                Arrays.fill(address, compress, (address.length - b) + compress, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(address);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        private static boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
            int b = addressOffset;
            int i = pos;
            while (i < limit) {
                if (b == address.length) {
                    return false;
                }
                if (b != addressOffset) {
                    if (input.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int value = 0;
                int groupOffset = i;
                while (i < limit) {
                    char c = input.charAt(i);
                    if (c < '0' || c > '9') {
                        break;
                    } else if ((value == 0 && groupOffset != i) || ((value * 10) + c) - 48 > 255) {
                        return false;
                    } else {
                        i++;
                    }
                }
                if (i - groupOffset == 0) {
                    return false;
                }
                address[b] = (byte) value;
                b++;
            }
            if (b != addressOffset + 4) {
                return false;
            }
            return true;
        }

        private static String domainToAscii(String input) {
            try {
                String result = IDN.toASCII(input).toLowerCase(Locale.US);
                if (!result.isEmpty() && !containsInvalidHostnameAsciiCodes(result)) {
                    return result;
                }
                return null;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        private static boolean containsInvalidHostnameAsciiCodes(String hostnameAscii) {
            for (int i = 0; i < hostnameAscii.length(); i++) {
                char c = hostnameAscii.charAt(i);
                if (c <= 31 || c >= 127 || " #%/:?@[\\]".indexOf(c) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static String inet6AddressToAscii(byte[] address) {
            int longestRunOffset = -1;
            int longestRunLength = 0;
            int i = 0;
            while (i < address.length) {
                int currentRunOffset = i;
                while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                    i += 2;
                }
                int currentRunLength = i - currentRunOffset;
                if (currentRunLength > longestRunLength) {
                    longestRunOffset = currentRunOffset;
                    longestRunLength = currentRunLength;
                }
                i += 2;
            }
            Buffer result = new Buffer();
            int i2 = 0;
            while (i2 < address.length) {
                if (i2 == longestRunOffset) {
                    result.writeByte(58);
                    i2 += longestRunLength;
                    if (i2 == 16) {
                        result.writeByte(58);
                    }
                } else {
                    if (i2 > 0) {
                        result.writeByte(58);
                    }
                    result.writeHexadecimalUnsignedLong((long) (((address[i2] & 255) << 8) | (address[i2 + 1] & 255)));
                    i2 += 2;
                }
            }
            return result.readUtf8();
        }
    }

    static String percentDecode(String encoded, int pos, int limit, boolean plusIsSpace) {
        for (int i = pos; i < limit; i++) {
            char c = encoded.charAt(i);
            if (c == '%' || (c == '+' && plusIsSpace)) {
                Buffer out = new Buffer();
                out.writeUtf8(encoded, pos, i);
                percentDecode(out, encoded, i, limit, plusIsSpace);
                return out.readUtf8();
            }
        }
        return encoded.substring(pos, limit);
    }

    static void percentDecode(Buffer out, String encoded, int pos, int limit, boolean plusIsSpace) {
        int i = pos;
        while (i < limit) {
            int codePoint = encoded.codePointAt(i);
            if (codePoint == 37 && i + 2 < limit) {
                int d1 = decodeHexDigit(encoded.charAt(i + 1));
                int d2 = decodeHexDigit(encoded.charAt(i + 2));
                if (!(d1 == -1 || d2 == -1)) {
                    out.writeByte((d1 << 4) + d2);
                    i += 2;
                    i += Character.charCount(codePoint);
                }
            } else if (codePoint == 43 && plusIsSpace) {
                out.writeByte(32);
                i += Character.charCount(codePoint);
            }
            out.writeUtf8CodePoint(codePoint);
            i += Character.charCount(codePoint);
        }
    }

    static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return (c - 'A') + 10;
    }

    static void canonicalize(Buffer out, String input, int pos, int limit, String encodeSet, boolean alreadyEncoded, boolean plusIsSpace, boolean asciiOnly) {
        Buffer utf8Buffer = null;
        int i = pos;
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (!alreadyEncoded || !(codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                if (codePoint == 43 && plusIsSpace) {
                    out.writeUtf8(alreadyEncoded ? "+" : "%2B");
                } else if (codePoint < 32 || codePoint == 127 || ((codePoint >= 128 && asciiOnly) || encodeSet.indexOf(codePoint) != -1 || (codePoint == 37 && !alreadyEncoded))) {
                    if (utf8Buffer == null) {
                        utf8Buffer = new Buffer();
                    }
                    utf8Buffer.writeUtf8CodePoint(codePoint);
                    while (!utf8Buffer.exhausted()) {
                        try {
                            fakeEofExceptionMethod();
                            int b = utf8Buffer.readByte() & 255;
                            out.writeByte(37);
                            out.writeByte((int) HEX_DIGITS[(b >> 4) & 15]);
                            out.writeByte((int) HEX_DIGITS[b & 15]);
                        } catch (EOFException e) {
                            throw new IndexOutOfBoundsException(e.getMessage());
                        }
                    }
                } else {
                    out.writeUtf8CodePoint(codePoint);
                }
            }
            i += Character.charCount(codePoint);
        }
    }

    private static void fakeEofExceptionMethod() throws EOFException {
    }
}
