package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcor {
    private final Map zza;
    private final Map zzb;

    zzcor(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfhf zzfhf) throws Exception {
        for (zzfhd zzfhd : zzfhf.zzb.zzc) {
            if (this.zza.containsKey(zzfhd.zza)) {
                ((zzcou) this.zza.get(zzfhd.zza)).zza(zzfhd.zzb);
            } else if (this.zzb.containsKey(zzfhd.zza)) {
                zzcot zzcot = (zzcot) this.zzb.get(zzfhd.zza);
                JSONObject jSONObject = zzfhd.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcot.zza(hashMap);
            }
        }
    }
}
