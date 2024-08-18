package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdod implements zzhkp {
    private final zzdnw zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzdod(zzdnw zzdnw, zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzdnw;
        this.zzb = zzhlg;
        this.zzc = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdha(((zzdrd) this.zzb).zzb(), (Executor) this.zzc.zzb());
    }
}
