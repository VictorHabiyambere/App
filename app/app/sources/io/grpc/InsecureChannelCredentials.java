package io.grpc;

public final class InsecureChannelCredentials extends ChannelCredentials {
    public static ChannelCredentials create() {
        return new InsecureChannelCredentials();
    }

    private InsecureChannelCredentials() {
    }

    public ChannelCredentials withoutBearerTokens() {
        return this;
    }
}
