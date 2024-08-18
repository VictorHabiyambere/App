package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeki implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzeki(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzekh((Context) this.zza.zzb(), (zzdkd) this.zzb.zzb(), (Executor) this.zzc.zzb());
    }
}
