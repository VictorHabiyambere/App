package io.grpc.okhttp;

import io.grpc.internal.InternalServer;
import io.grpc.internal.ServerImplBuilder;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class OkHttpServerBuilder$$ExternalSyntheticLambda0 implements ServerImplBuilder.ClientTransportServersBuilder {
    public final /* synthetic */ OkHttpServerBuilder f$0;

    public /* synthetic */ OkHttpServerBuilder$$ExternalSyntheticLambda0(OkHttpServerBuilder okHttpServerBuilder) {
        this.f$0 = okHttpServerBuilder;
    }

    public final InternalServer buildClientTransportServers(List list) {
        return this.f$0.buildTransportServers(list);
    }
}
