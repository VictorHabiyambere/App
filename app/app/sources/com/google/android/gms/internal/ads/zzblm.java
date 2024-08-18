package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzblm implements zzblp {
    zzblm() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        if (map.keySet().contains("start")) {
            zzchd.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzchd.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzchd.zzN().zzk();
        }
    }
}
