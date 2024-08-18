package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdzg implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        return zzgft.zzg(((ExecutionException) obj).getCause());
    }
}
