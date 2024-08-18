package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbku implements zzblp {
    zzbku() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzchd zzchd = (zzchd) obj;
        zzbhj zzK = zzchd.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzchd.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzchd.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
