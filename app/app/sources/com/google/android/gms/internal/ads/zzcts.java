package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcts implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzcts(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzctr zzb() {
        return new zzctr(((zzctb) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
