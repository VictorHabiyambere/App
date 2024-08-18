package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbol {
    public static void zza(zzbom zzbom, String str, Map map) {
        try {
            zzbom.zze(str, zzay.zzb().zzj(map));
        } catch (JSONException e) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbom zzbom, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbom.zza(sb.toString());
    }

    public static void zzc(zzbom zzbom, String str, String str2) {
        zzbom.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbom zzbom, String str, JSONObject jSONObject) {
        zzbom.zzb(str, jSONObject.toString());
    }
}
