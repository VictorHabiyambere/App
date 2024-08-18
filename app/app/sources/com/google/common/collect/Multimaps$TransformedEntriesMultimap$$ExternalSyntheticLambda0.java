package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Collection;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Multimaps$TransformedEntriesMultimap$$ExternalSyntheticLambda0 implements Maps.EntryTransformer {
    public final /* synthetic */ Multimaps.TransformedEntriesMultimap f$0;

    public /* synthetic */ Multimaps$TransformedEntriesMultimap$$ExternalSyntheticLambda0(Multimaps.TransformedEntriesMultimap transformedEntriesMultimap) {
        this.f$0 = transformedEntriesMultimap;
    }

    public final Object transformEntry(Object obj, Object obj2) {
        return this.f$0.m2037lambda$createAsMap$0$comgooglecommoncollectMultimaps$TransformedEntriesMultimap(obj, (Collection) obj2);
    }
}
