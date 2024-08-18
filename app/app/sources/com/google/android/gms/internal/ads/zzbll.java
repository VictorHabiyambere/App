package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbll implements zzblp {
    zzbll() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzchd.zzdg();
        } else if ("resume".equals(str)) {
            zzchd.zzdh();
        }
    }
}
