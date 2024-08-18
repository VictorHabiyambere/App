package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zze;
import com.google.android.gms.ads.formats.zzj;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zza extends UnifiedNativeAdMapper {
    private final UnifiedNativeAd zza;

    public zza(UnifiedNativeAd unifiedNativeAd) {
        this.zza = unifiedNativeAd;
        setHeadline(unifiedNativeAd.zzh());
        setImages(unifiedNativeAd.zzk());
        setBody(unifiedNativeAd.zzf());
        setIcon(unifiedNativeAd.zzb());
        setCallToAction(unifiedNativeAd.zzg());
        setAdvertiser(unifiedNativeAd.zze());
        setStarRating(unifiedNativeAd.zzc());
        setStore(unifiedNativeAd.zzj());
        setPrice(unifiedNativeAd.zzi());
        zzd(unifiedNativeAd.zzd());
        setOverrideImpressionRecording(true);
        setOverrideClickHandling(true);
        zze(unifiedNativeAd.zza());
    }

    public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        if (view instanceof zzj) {
            zzj zzj = (zzj) view;
            throw null;
        } else if (((zze) zze.zza.get(view)) != null) {
            throw null;
        }
    }
}
