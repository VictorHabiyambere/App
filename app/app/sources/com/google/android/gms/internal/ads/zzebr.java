package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzebr implements zzgfa {
    public final /* synthetic */ zzebu zza;
    public final /* synthetic */ zzebt zzb;
    public final /* synthetic */ zzbxu zzc;
    public final /* synthetic */ zzgfa zzd;

    public /* synthetic */ zzebr(zzebu zzebu, zzebt zzebt, zzbxu zzbxu, zzgfa zzgfa) {
        this.zza = zzebu;
        this.zzb = zzebt;
        this.zzc = zzbxu;
        this.zzd = zzgfa;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, (zzebh) obj);
    }
}
