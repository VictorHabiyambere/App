package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcxe implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;

    public zzcxe(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcjv) this.zzc).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzcxd(((zzcjj) this.zza).zza(), (zzfmq) this.zzb.zzb(), zza2, zzgge);
    }
}
