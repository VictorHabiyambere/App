package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdon implements zzgfa {
    public final /* synthetic */ ListenableFuture zza;

    public /* synthetic */ zzdon(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        zzchd zzchd = (zzchd) obj;
        if (zzchd != null && zzchd.zzq() != null) {
            return this.zza;
        }
        throw new zzelj(1, "Retrieve video view in html5 ad response failed.");
    }
}
