package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcvb implements zzgfa {
    public final /* synthetic */ zzcve zza;
    public final /* synthetic */ zzgfp zzb;
    public final /* synthetic */ ListenableFuture zzc;

    public /* synthetic */ zzcvb(zzcve zzcve, zzgfp zzgfp, ListenableFuture listenableFuture) {
        this.zza = zzcve;
        this.zzb = zzgfp;
        this.zzc = listenableFuture;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(this.zzb, this.zzc, (zzcup) obj);
    }
}
