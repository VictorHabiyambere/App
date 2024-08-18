package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzblc implements zzblp {
    zzblc() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfxm.zzc("true", str)) {
                if (!zzfxm.zzc("false", str)) {
                    return;
                }
            }
            zzfvh.zzi(zzchd.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
