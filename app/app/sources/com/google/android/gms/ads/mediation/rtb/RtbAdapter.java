package com.google.android.gms.ads.mediation.rtb;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class RtbAdapter extends Adapter {
    public abstract void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks);

    public void loadRtbAppOpenAd(MediationAppOpenAdConfiguration adConfiguration, MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> callback) {
        loadAppOpenAd(adConfiguration, callback);
    }

    public void loadRtbBannerAd(MediationBannerAdConfiguration adConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> callback) {
        loadBannerAd(adConfiguration, callback);
    }

    public void loadRtbInterscrollerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> callback) {
        callback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interscroller ads."), MobileAds.ERROR_DOMAIN));
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration adConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback) {
        loadInterstitialAd(adConfiguration, callback);
    }

    @Deprecated
    public void loadRtbNativeAd(MediationNativeAdConfiguration adConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback) {
        loadNativeAd(adConfiguration, callback);
    }

    public void loadRtbNativeAdMapper(MediationNativeAdConfiguration adConfiguration, MediationAdLoadCallback<NativeAdMapper, MediationNativeAdCallback> callback) throws RemoteException {
        loadNativeAdMapper(adConfiguration, callback);
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration adConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> callback) {
        loadRewardedAd(adConfiguration, callback);
    }

    public void loadRtbRewardedInterstitialAd(MediationRewardedAdConfiguration adConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> callback) {
        loadRewardedInterstitialAd(adConfiguration, callback);
    }
}
