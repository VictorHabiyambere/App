package io.grpc.okhttp.internal.proxy;

import io.grpc.okhttp.internal.Headers;

public final class Request {
    private final Headers headers;
    private final HttpUrl url;

    private Request(Builder builder) {
        this.url = builder.url;
        this.headers = builder.headers.build();
    }

    public HttpUrl httpUrl() {
        return this.url;
    }

    public Headers headers() {
        return this.headers;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "Request{url=" + this.url + '}';
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Headers.Builder headers = new Headers.Builder();
        /* access modifiers changed from: private */
        public HttpUrl url;

        public Builder url(HttpUrl url2) {
            if (url2 != null) {
                this.url = url2;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public Builder header(String name, String value) {
            this.headers.set(name, value);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
