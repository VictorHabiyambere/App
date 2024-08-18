package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeby implements zzgfa {
    public final /* synthetic */ zzebz zza;
    public final /* synthetic */ zzbwz zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzeby(zzebz zzebz, zzbwz zzbwz, int i) {
        this.zza = zzebz;
        this.zzb = zzbwz;
        this.zzc = i;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, (zzebh) obj);
    }
}
