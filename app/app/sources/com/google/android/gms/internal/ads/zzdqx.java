package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqx {
    private final zzczj zza;
    private final zzdas zzb;
    private final zzdbf zzc;
    private final zzdbr zzd;
    private final zzdef zze;
    private final zzdhg zzf;
    private final zzdvc zzg;
    private final zzfoe zzh;
    private final zzefz zzi;
    private final zzcqd zzj;

    zzdqx(zzczj zzczj, zzdas zzdas, zzdbf zzdbf, zzdbr zzdbr, zzdef zzdef, zzdhg zzdhg, zzdvc zzdvc, zzfoe zzfoe, zzefz zzefz, zzcqd zzcqd) {
        this.zza = zzczj;
        this.zzb = zzdas;
        this.zzc = zzdbf;
        this.zzd = zzdbr;
        this.zze = zzdef;
        this.zzf = zzdhg;
        this.zzg = zzdvc;
        this.zzh = zzfoe;
        this.zzi = zzefz;
        this.zzj = zzcqd;
    }

    public final void zza(zzdqy zzdqy, zzchd zzchd) {
        zzdqv zza2 = zzdqy.zza;
        zzdas zzdas = this.zzb;
        Objects.requireNonNull(zzdas);
        zza2.zzi(this.zza, this.zzc, this.zzd, this.zze, new zzdqw(zzdas), this.zzf);
        if (((Boolean) zzba.zzc().zza(zzbep.zzkg)).booleanValue() && zzchd != null && zzchd.zzN() != null) {
            zzciv zzN = zzchd.zzN();
            zzN.zzI(this.zzj, this.zzi, this.zzh);
            zzN.zzK(this.zzj, this.zzi, this.zzg);
        }
    }
}
