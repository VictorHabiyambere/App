package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbuv extends zzbji {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbuv(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    public final void zze(zzbjs zzbjs) {
        this.zza.onNativeAdLoaded(new zzbuo(zzbjs));
    }
}
