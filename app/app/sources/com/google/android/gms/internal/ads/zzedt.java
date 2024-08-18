package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedt implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        zzeed zzeed = (zzeed) obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("response", zzeed.zza);
            JSONObject jSONObject2 = new JSONObject();
            for (String str : zzeed.zzb.keySet()) {
                if (str != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : (List) zzeed.zzb.get(str)) {
                        if (str2 != null) {
                            jSONArray.put(str2);
                        }
                    }
                    jSONObject2.put(str, jSONArray);
                }
            }
            jSONObject.put("headers", jSONObject2);
            String str3 = zzeed.zzc;
            if (str3 != null) {
                jSONObject.put("body", str3);
            }
            jSONObject.put("latency", zzeed.zzd);
            return zzgft.zzh(new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
        } catch (JSONException e) {
            zzm.zzj("Error converting response to JSONObject: ".concat(String.valueOf(e.getMessage())));
            throw new JSONException("Parsing HTTP Response: ".concat(String.valueOf(String.valueOf(e.getCause()))));
        }
    }
}
