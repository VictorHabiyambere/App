package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdov implements zzgfa {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdov(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return obj != null ? this.zza : zzgft.zzg(new zzelj(1, "Retrieve required value in native ad response failed."));
    }
}
