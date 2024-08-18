package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbzt extends zzbzg {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzbzu zzb;

    public zzbzt(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzbzu zzbzu) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzbzu;
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        zzbzu zzbzu;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzbzu = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzbzu);
        }
    }
}
