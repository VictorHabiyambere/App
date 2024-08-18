package io.grpc.internal;

import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.LoadBalancer;

abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    /* access modifiers changed from: package-private */
    public abstract InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel();

    AbstractSubchannel() {
    }
}
