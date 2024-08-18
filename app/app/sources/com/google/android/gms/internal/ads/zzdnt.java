package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdnt implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;

    public zzdnt(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzdns(((zzdmm) this.zza).zza(), ((zzdkv) this.zzb).zzb(), (Executor) this.zzc.zzb(), zzgge);
    }
}
