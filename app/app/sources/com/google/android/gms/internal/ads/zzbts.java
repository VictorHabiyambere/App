package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzbts implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationRewardedAdCallback, MediationNativeAdCallback, MediationAppOpenAdCallback {
    final zzbrl zza;

    zzbts(zzbrl zzbrl) {
        this.zza = zzbrl;
    }

    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        try {
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            zzm.zzj("Mediated ad failed to show: Error Code = " + code + ". Error Message = " + message + " Error Domain = " + domain);
            this.zza.zzk(adError.zza());
        } catch (RemoteException e) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zza.zzn();
        } catch (RemoteException e) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zza.zzp();
        } catch (RemoteException e) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zza.zzt(new zzbzr(rewardItem));
        } catch (RemoteException e) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zza.zzv();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        try {
            this.zza.zzw();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzx();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zza.zzy();
        } catch (RemoteException e) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException e) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zza.zzm();
        } catch (RemoteException e) {
        }
    }

    public final void onAdFailedToShow(String str) {
        try {
            zzm.zzj("Mediated ad failed to show: " + str);
            this.zza.zzl(str);
        } catch (RemoteException e) {
        }
    }
}
