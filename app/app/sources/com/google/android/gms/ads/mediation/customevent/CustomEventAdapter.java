package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    static final AdError zza = new AdError(0, "Could not instantiate custom event adapter", MobileAds.ERROR_DOMAIN);
    CustomEventBanner zzb;
    CustomEventInterstitial zzc;
    CustomEventNative zzd;
    /* access modifiers changed from: private */
    public View zze;

    private static Object zzb(Class cls, String str) {
        if (str != null) {
            try {
                return cls.cast(Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Throwable th) {
                String message = th.getMessage();
                zzm.zzj("Could not instantiate custom event adapter: " + str + ". " + message);
                return null;
            }
        } else {
            throw null;
        }
    }

    public View getBannerView() {
        return this.zze;
    }

    public void onDestroy() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzd;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public void onPause() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzd;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public void onResume() {
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzd;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        Bundle bundle;
        this.zzb = (CustomEventBanner) zzb(CustomEventBanner.class, serverParameters.getString("class_name"));
        if (this.zzb == null) {
            listener.onAdFailedToLoad((MediationBannerAdapter) this, zza);
            return;
        }
        if (customEventExtras == null) {
            bundle = null;
        } else {
            bundle = customEventExtras.getBundle(serverParameters.getString("class_name"));
        }
        CustomEventBanner customEventBanner = this.zzb;
        if (customEventBanner != null) {
            customEventBanner.requestBannerAd(context, new zza(this, listener), serverParameters.getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle);
            return;
        }
        throw null;
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        Bundle bundle;
        this.zzc = (CustomEventInterstitial) zzb(CustomEventInterstitial.class, serverParameters.getString("class_name"));
        if (this.zzc == null) {
            listener.onAdFailedToLoad((MediationInterstitialAdapter) this, zza);
            return;
        }
        if (customEventExtras == null) {
            bundle = null;
        } else {
            bundle = customEventExtras.getBundle(serverParameters.getString("class_name"));
        }
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial != null) {
            customEventInterstitial.requestInterstitialAd(context, new zzb(this, this, listener), serverParameters.getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle);
            return;
        }
        throw null;
    }

    public void requestNativeAd(Context context, MediationNativeListener listener, Bundle serverParameters, NativeMediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        Bundle bundle;
        this.zzd = (CustomEventNative) zzb(CustomEventNative.class, serverParameters.getString("class_name"));
        if (this.zzd == null) {
            listener.onAdFailedToLoad((MediationNativeAdapter) this, zza);
            return;
        }
        if (customEventExtras == null) {
            bundle = null;
        } else {
            bundle = customEventExtras.getBundle(serverParameters.getString("class_name"));
        }
        CustomEventNative customEventNative = this.zzd;
        if (customEventNative != null) {
            customEventNative.requestNativeAd(context, new zzc(this, listener), serverParameters.getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle);
            return;
        }
        throw null;
    }

    public void showInterstitial() {
        CustomEventInterstitial customEventInterstitial = this.zzc;
        if (customEventInterstitial != null) {
            customEventInterstitial.showInterstitial();
        }
    }
}
