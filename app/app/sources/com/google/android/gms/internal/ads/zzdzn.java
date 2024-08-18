package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdzn implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;

    public zzdzn(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcjj) this.zzb).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        ListenableFuture zzb2 = zzgge.zzb(new zzdzk((zzaxd) this.zza.zzb(), zza2));
        zzhkx.zzb(zzb2);
        return zzb2;
    }
}
