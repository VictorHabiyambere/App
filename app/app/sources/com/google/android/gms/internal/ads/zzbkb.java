package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzbkb implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbu zzb;
    final /* synthetic */ zzbkc zzc;

    zzbkb(zzbkc zzbkc, AdManagerAdView adManagerAdView, zzbu zzbu) {
        this.zza = adManagerAdView;
        this.zzb = zzbu;
        this.zzc = zzbkc;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            zzbkc zzbkc = this.zzc;
            zzbkc.zza.onAdManagerAdViewLoaded(this.zza);
            return;
        }
        zzm.zzj("Could not bind.");
    }
}
