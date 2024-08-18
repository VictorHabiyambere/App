package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcqh implements zzczo {
    private final zzfgw zza;
    private final zzfhf zzb;
    private final zzfoa zzc;
    private final zzfoe zzd;

    public zzcqh(zzfhf zzfhf, zzfoe zzfoe, zzfoa zzfoa) {
        this.zzb = zzfhf;
        this.zzd = zzfoe;
        this.zzc = zzfoa;
        this.zza = zzfhf.zzb.zzb;
    }

    public final void zzdB(zze zze) {
        List list = this.zza.zza;
        this.zzd.zzd(this.zzc.zzc(this.zzb, (zzfgt) null, list));
    }
}
