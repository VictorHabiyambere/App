package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeab implements zzgfa {
    public final /* synthetic */ zzeac zza;
    public final /* synthetic */ zzbxu zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzeab(zzeac zzeac, zzbxu zzbxu, int i) {
        this.zza = zzeac;
        this.zzb = zzbxu;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (Throwable) obj);
    }
}
