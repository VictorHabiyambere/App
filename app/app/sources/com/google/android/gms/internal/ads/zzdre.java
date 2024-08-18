package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdre implements zzbmg {
    private final zzdas zza;
    private final zzbyt zzb;
    private final String zzc;
    private final String zzd;

    public zzdre(zzdas zzdas, zzfgt zzfgt) {
        this.zza = zzdas;
        this.zzb = zzfgt.zzm;
        this.zzc = zzfgt.zzk;
        this.zzd = zzfgt.zzl;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzbyt zzbyt) {
        int i;
        String str;
        zzbyt zzbyt2 = this.zzb;
        if (zzbyt2 != null) {
            zzbyt = zzbyt2;
        }
        if (zzbyt != null) {
            str = zzbyt.zza;
            i = zzbyt.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbye(str, i), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
