package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbwj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzc implements Runnable {
    public final /* synthetic */ BaseAdView zza;

    public /* synthetic */ zzc(BaseAdView baseAdView) {
        this.zza = baseAdView;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzp();
        } catch (IllegalStateException e) {
            zzbwj.zza(baseAdView.getContext()).zzh(e, "BaseAdView.resume");
        }
    }
}
