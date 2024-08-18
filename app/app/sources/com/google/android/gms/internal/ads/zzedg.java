package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedg implements Callable {
    public final /* synthetic */ zzedq zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzbxu zzd;
    public final /* synthetic */ zzfmc zze;

    public /* synthetic */ zzedg(zzedq zzedq, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbxu zzbxu, zzfmc zzfmc) {
        this.zza = zzedq;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzbxu;
        this.zze = zzfmc;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
