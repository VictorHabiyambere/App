package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImmutableSortedMap$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ ImmutableSortedMap$$ExternalSyntheticLambda0(Comparator comparator) {
        this.f$0 = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ImmutableSortedMap.lambda$fromEntries$0(this.f$0, (Map.Entry) obj, (Map.Entry) obj2);
    }
}
