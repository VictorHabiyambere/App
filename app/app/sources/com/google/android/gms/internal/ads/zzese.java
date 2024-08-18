package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzese implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzese(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    /* renamed from: zza */
    public final zzesc zzb() {
        VersionInfoParcel zza2 = ((zzcjv) this.zza).zza();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        return new zzesc(zza2, zzgge);
    }
}
