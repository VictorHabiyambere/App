package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzezp implements zzexv {
    private final JSONObject zza;

    public zzezp(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject zzg = zzbw.zzg((JSONObject) obj, "content_info");
            JSONObject jSONObject = this.zza;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzg.put(next, jSONObject.get(next));
            }
        } catch (JSONException e) {
            zze.zza("Failed putting app indexing json.");
        }
    }
}
