package io.grpc;

import io.grpc.ManagedChannelProvider;

public final class InternalManagedChannelProvider {
    private InternalManagedChannelProvider() {
    }

    public static boolean isAvailable(ManagedChannelProvider provider) {
        return provider.isAvailable();
    }

    public static ManagedChannelBuilder<?> builderForAddress(ManagedChannelProvider provider, String name, int port) {
        return provider.builderForAddress(name, port);
    }

    public static ManagedChannelBuilder<?> builderForTarget(ManagedChannelProvider provider, String target) {
        return provider.builderForTarget(target);
    }

    public static ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(ManagedChannelProvider provider, String target, ChannelCredentials creds) {
        return provider.newChannelBuilder(target, creds);
    }
}
