package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.VersionInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class Adapter implements MediationExtrasReceiver {
    public abstract VersionInfo getSDKVersionInfo();

    public abstract VersionInfo getVersionInfo();

    public abstract void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list);

    public void loadAppOpenAd(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support app open ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support banner ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadInterscrollerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interscroller ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interstitial ads."), MobileAds.ERROR_DOMAIN));
    }

    @Deprecated
    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support native ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadNativeAdMapper(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<NativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) throws RemoteException {
        throw new RemoteException("Method is not found");
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support rewarded ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support rewarded interstitial ads."), MobileAds.ERROR_DOMAIN));
    }
}
