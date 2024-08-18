package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdlm implements zzgfp {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdlo zzb;

    zzdlm(zzdlo zzdlo, String str, boolean z) {
        this.zzb = zzdlo;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfj)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze.zzT((zzchd) obj);
        zzdlo zzdlo = this.zzb;
        zzccn zzp = zzdlo.zze.zzp();
        zzehg zzf = zzdlo.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
