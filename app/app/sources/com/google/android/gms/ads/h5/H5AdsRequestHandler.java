package com.google.android.gms.ads.h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbmv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class H5AdsRequestHandler {
    private final zzbmv zza;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbmv(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    public boolean handleH5AdsRequest(String url) {
        return this.zza.zzb(url);
    }

    public boolean shouldInterceptRequest(String url) {
        return zzbmv.zzc(url);
    }
}
