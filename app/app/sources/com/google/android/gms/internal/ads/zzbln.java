package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbln implements zzblp {
    zzbln() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        if (map.keySet().contains("start")) {
            zzchd.zzax(true);
        }
        if (map.keySet().contains("stop")) {
            zzchd.zzax(false);
        }
    }
}
