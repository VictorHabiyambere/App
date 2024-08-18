package io.grpc;

import io.grpc.NameResolver;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

public abstract class NameResolverProvider extends NameResolver.Factory {
    /* access modifiers changed from: protected */
    public abstract boolean isAvailable();

    /* access modifiers changed from: protected */
    public abstract int priority();

    /* access modifiers changed from: protected */
    public String getScheme() {
        return getDefaultScheme();
    }

    /* access modifiers changed from: protected */
    public Collection<Class<? extends SocketAddress>> getProducedSocketAddressTypes() {
        return Collections.singleton(InetSocketAddress.class);
    }
}
