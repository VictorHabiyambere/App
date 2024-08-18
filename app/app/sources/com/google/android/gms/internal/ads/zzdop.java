package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdop implements zzgfa {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdop(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        if (((zzchd) obj) != null) {
            return this.zza;
        }
        throw new zzelj(1, "Retrieve Web View from image ad response failed.");
    }
}
