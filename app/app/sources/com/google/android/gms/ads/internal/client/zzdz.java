package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzdz extends zzaz {
    final /* synthetic */ zzea zza;

    zzdz(zzea zzea) {
        this.zza = zzea;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzea zzea = this.zza;
        zzea.zze.zzb(zzea.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        zzea zzea = this.zza;
        zzea.zze.zzb(zzea.zzi());
        super.onAdLoaded();
    }
}
