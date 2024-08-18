package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzedo implements zzbqa {
    zzedo() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzedp zzedp = (zzedp) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzba.zzc().zza(zzbep.zzjn)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzedp.zzd.zzg());
            jSONObject2.put("ad_request_post_body", zzedp.zzd.zzf());
        }
        jSONObject2.put("base_url", zzedp.zzd.zzd());
        jSONObject2.put("signals", zzedp.zzc);
        jSONObject3.put("body", zzedp.zzb.zzc);
        jSONObject3.put("headers", zzay.zzb().zzj(zzedp.zzb.zzb));
        jSONObject3.put("response_code", zzedp.zzb.zza);
        jSONObject3.put("latency", zzedp.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzedp.zzd.zzi());
        return jSONObject;
    }
}
