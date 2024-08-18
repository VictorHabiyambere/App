package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfal implements zzexw {
    final zzgge zza;
    final String zzb;
    final zzcbm zzc;

    public zzfal(zzcbm zzcbm, zzgge zzgge, String str) {
        this.zzc = zzcbm;
        this.zza = zzgge;
        this.zzb = str;
    }

    public final int zza() {
        return 47;
    }

    public final ListenableFuture zzb() {
        ListenableFuture zzh = zzgft.zzh((Object) null);
        if (((Boolean) zzba.zzc().zza(zzbep.zzfX)).booleanValue()) {
            zzh = zzgft.zzh((Object) null);
        }
        ListenableFuture zzh2 = zzgft.zzh((Object) null);
        return zzgft.zzc(zzh, zzh2).zza(new zzfak(zzh, zzh2), zzcci.zza);
    }
}
