package io.grpc.okhttp;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.webkit.ProxyConfig;
import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

class Headers {
    public static final Header CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
    public static final Header HTTPS_SCHEME_HEADER = new Header(Header.TARGET_SCHEME, ProxyConfig.MATCH_HTTPS);
    public static final Header HTTP_SCHEME_HEADER = new Header(Header.TARGET_SCHEME, ProxyConfig.MATCH_HTTP);
    public static final Header METHOD_GET_HEADER = new Header(Header.TARGET_METHOD, ShareTarget.METHOD_GET);
    public static final Header METHOD_HEADER = new Header(Header.TARGET_METHOD, "POST");
    public static final Header TE_HEADER = new Header("te", GrpcUtil.TE_TRAILERS);

    Headers() {
    }

    public static List<Header> createRequestHeaders(Metadata headers, String defaultPath, String authority, String userAgent, boolean useGet, boolean usePlaintext) {
        Preconditions.checkNotNull(headers, "headers");
        Preconditions.checkNotNull(defaultPath, "defaultPath");
        Preconditions.checkNotNull(authority, "authority");
        stripNonApplicationHeaders(headers);
        List<Header> okhttpHeaders = new ArrayList<>(InternalMetadata.headerCount(headers) + 7);
        if (usePlaintext) {
            okhttpHeaders.add(HTTP_SCHEME_HEADER);
        } else {
            okhttpHeaders.add(HTTPS_SCHEME_HEADER);
        }
        if (useGet) {
            okhttpHeaders.add(METHOD_GET_HEADER);
        } else {
            okhttpHeaders.add(METHOD_HEADER);
        }
        okhttpHeaders.add(new Header(Header.TARGET_AUTHORITY, authority));
        okhttpHeaders.add(new Header(Header.TARGET_PATH, defaultPath));
        okhttpHeaders.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), userAgent));
        okhttpHeaders.add(CONTENT_TYPE_HEADER);
        okhttpHeaders.add(TE_HEADER);
        return addMetadata(okhttpHeaders, headers);
    }

    public static List<Header> createResponseHeaders(Metadata headers) {
        stripNonApplicationHeaders(headers);
        List<Header> okhttpHeaders = new ArrayList<>(InternalMetadata.headerCount(headers) + 2);
        okhttpHeaders.add(new Header(Header.RESPONSE_STATUS, "200"));
        okhttpHeaders.add(CONTENT_TYPE_HEADER);
        return addMetadata(okhttpHeaders, headers);
    }

    public static List<Header> createResponseTrailers(Metadata trailers, boolean headersSent) {
        if (!headersSent) {
            return createResponseHeaders(trailers);
        }
        stripNonApplicationHeaders(trailers);
        return addMetadata(new ArrayList<>(InternalMetadata.headerCount(trailers)), trailers);
    }

    public static List<Header> createHttpResponseHeaders(int httpCode, String contentType, Metadata headers) {
        List<Header> okhttpHeaders = new ArrayList<>(InternalMetadata.headerCount(headers) + 2);
        okhttpHeaders.add(new Header(Header.RESPONSE_STATUS, "" + httpCode));
        okhttpHeaders.add(new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), contentType));
        return addMetadata(okhttpHeaders, headers);
    }

    private static List<Header> addMetadata(List<Header> okhttpHeaders, Metadata toAdd) {
        byte[][] serializedHeaders = TransportFrameUtil.toHttp2Headers(toAdd);
        for (int i = 0; i < serializedHeaders.length; i += 2) {
            ByteString key = ByteString.of(serializedHeaders[i]);
            if (!(key.size() == 0 || key.getByte(0) == 58)) {
                okhttpHeaders.add(new Header(key, ByteString.of(serializedHeaders[i + 1])));
            }
        }
        return okhttpHeaders;
    }

    private static void stripNonApplicationHeaders(Metadata headers) {
        headers.discardAll(GrpcUtil.CONTENT_TYPE_KEY);
        headers.discardAll(GrpcUtil.TE_HEADER);
        headers.discardAll(GrpcUtil.USER_AGENT_KEY);
    }
}
