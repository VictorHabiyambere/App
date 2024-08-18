package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeje implements zzgfp {
    final /* synthetic */ zzejf zza;

    zzeje(zzejf zzejf) {
        this.zza = zzejf;
    }

    public final void zza(Throwable th) {
        zze zza2 = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzdB(zza2);
        zzfil.zzb(zza2.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* synthetic */ void zzb(Object obj) {
        ((zzcsf) obj).zzj();
    }
}
