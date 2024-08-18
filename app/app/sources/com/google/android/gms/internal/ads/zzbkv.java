package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbkv implements zzblp {
    zzbkv() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzchd zzchd = (zzchd) obj;
        zzbhj zzK = zzchd.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzchd.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzchd.zze("nativeClickMetaReady", zzb);
        }
    }
}
