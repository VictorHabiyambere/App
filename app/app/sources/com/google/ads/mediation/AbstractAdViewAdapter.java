package com.google.ads.mediation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.zza;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdLoader adLoader;
    protected AdView mAdView;
    protected InterstitialAd mInterstitialAd;

    /* access modifiers changed from: package-private */
    public AdRequest buildAdRequest(Context context, MediationAdRequest mediationAdRequest, Bundle extras, Bundle serverParameters) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            zzay.zzb();
            builder.zza(zzf.zzz(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.zzc(z);
        }
        builder.zzb(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, buildExtrasBundle(extras, serverParameters));
        return builder.build();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle buildExtrasBundle(Bundle bundle, Bundle bundle2);

    public String getAdUnitId(Bundle serverParameters) {
        return serverParameters.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.mAdView;
    }

    /* access modifiers changed from: package-private */
    public InterstitialAd getInterstitialAd() {
        return this.mInterstitialAd;
    }

    public zzdq getVideoController() {
        AdView adView = this.mAdView;
        if (adView != null) {
            return adView.zza().zza();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public AdLoader.Builder newAdLoader(Context context, String adUnitID) {
        return new AdLoader.Builder(context, adUnitID);
    }

    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
            this.mAdView = null;
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        if (this.adLoader != null) {
            this.adLoader = null;
        }
    }

    public void onImmersiveModeUpdated(boolean immersiveModeEnabled) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(immersiveModeEnabled);
        }
    }

    public void onPause() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.mAdView = new AdView(context);
        this.mAdView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.mAdView.setAdUnitId(getAdUnitId(serverParameters));
        this.mAdView.setAdListener(new zzb(this, bannerListener));
        this.mAdView.loadAd(buildAdRequest(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        InterstitialAd.load(context, getAdUnitId(serverParameters), buildAdRequest(context, mediationAdRequest, extras, serverParameters), new zzc(this, interstitialListener));
    }

    public void requestNativeAd(Context context, MediationNativeListener listener, Bundle serverParameters, NativeMediationAdRequest mediationAdRequest, Bundle extras) {
        zze zze;
        zze zze2 = new zze(this, listener);
        AdLoader.Builder withAdListener = newAdLoader(context, serverParameters.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze2);
        withAdListener.zzc(mediationAdRequest.getNativeAdOptions());
        withAdListener.withNativeAdOptions(mediationAdRequest.getNativeAdRequestOptions());
        if (mediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.zzb(zze2);
        }
        if (mediationAdRequest.zzb()) {
            for (String str : mediationAdRequest.zza().keySet()) {
                if (true != ((Boolean) mediationAdRequest.zza().get(str)).booleanValue()) {
                    zze = null;
                } else {
                    zze = zze2;
                }
                withAdListener.zza(str, zze2, zze);
            }
        }
        this.adLoader = withAdListener.build();
        this.adLoader.loadAd(buildAdRequest(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.show((Activity) null);
        }
    }
}
