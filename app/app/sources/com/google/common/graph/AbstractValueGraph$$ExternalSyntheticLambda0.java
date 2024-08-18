package com.google.common.graph;

import com.google.common.base.Function;
import java.util.Objects;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AbstractValueGraph$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ ValueGraph f$0;

    public /* synthetic */ AbstractValueGraph$$ExternalSyntheticLambda0(ValueGraph valueGraph) {
        this.f$0 = valueGraph;
    }

    public final Object apply(Object obj) {
        return Objects.requireNonNull(this.f$0.edgeValueOrDefault(((EndpointPair) obj).nodeU(), ((EndpointPair) obj).nodeV(), null));
    }
}
