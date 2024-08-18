package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzema implements zzehn {
    private final Map zza = new HashMap();
    private final zzdst zzb;

    public zzema(zzdst zzdst) {
        this.zzb = zzdst;
    }

    public final zzeho zza(String str, JSONObject jSONObject) throws zzfhv {
        zzeho zzeho;
        synchronized (this) {
            zzeho = (zzeho) this.zza.get(str);
            if (zzeho == null) {
                zzeho = new zzeho(this.zzb.zzc(str, jSONObject), new zzeji(), str);
                this.zza.put(str, zzeho);
            }
        }
        return zzeho;
    }
}
