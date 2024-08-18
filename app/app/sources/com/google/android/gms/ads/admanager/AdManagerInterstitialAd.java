package com.google.android.gms.ads.admanager;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzboj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class AdManagerInterstitialAd extends InterstitialAd {
    public static void load(Context context, String adUnitId, AdManagerAdRequest adManagerAdRequest, AdManagerInterstitialAdLoadCallback loadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(adUnitId, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(loadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbep.zza(context);
        if (((Boolean) zzbgi.zzi.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlg)).booleanValue()) {
                zzb.zzb.execute(new zzc(context, adUnitId, adManagerAdRequest, loadCallback));
                return;
            }
        }
        new zzboj(context, adUnitId).zza(adManagerAdRequest.zza(), loadCallback);
    }

    public abstract AppEventListener getAppEventListener();

    public abstract void setAppEventListener(AppEventListener appEventListener);
}
