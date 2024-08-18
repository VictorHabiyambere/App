package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdoh implements Callable {
    public final /* synthetic */ zzdoj zza;
    public final /* synthetic */ zzfhf zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ JSONObject zzd;

    public /* synthetic */ zzdoh(zzdoj zzdoj, zzfhf zzfhf, zzfgt zzfgt, JSONObject jSONObject) {
        this.zza = zzdoj;
        this.zzb = zzfhf;
        this.zzc = zzfgt;
        this.zzd = jSONObject;
    }

    public final Object call() {
        zzdlt zzdlt = new zzdlt();
        JSONObject jSONObject = this.zzd;
        zzdlt.zzaa(jSONObject.optInt("template_id", -1));
        zzdlt.zzK(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        String optString = optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null;
        zzfhf zzfhf = this.zzb;
        zzdlt.zzV(optString);
        zzfho zzfho = zzfhf.zza.zza;
        if (zzfho.zzg.contains(Integer.toString(zzdlt.zzc()))) {
            if (zzdlt.zzc() == 3) {
                if (zzdlt.zzA() == null) {
                    throw new zzelj(1, "No custom template id for custom template ad response.");
                } else if (!zzfho.zzh.contains(zzdlt.zzA())) {
                    throw new zzelj(1, "Unexpected custom template id in the response.");
                }
            }
            zzfgt zzfgt = this.zzc;
            zzdlt.zzY(jSONObject.optDouble("rating", -1.0d));
            String optString2 = jSONObject.optString("headline", (String) null);
            if (zzfgt.zzN) {
                zzu.zzp();
                optString2 = zzt.zzy() + " : " + optString2;
            }
            zzdlt.zzZ("headline", optString2);
            zzdlt.zzZ("body", jSONObject.optString("body", (String) null));
            zzdlt.zzZ("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdlt.zzZ("store", jSONObject.optString("store", (String) null));
            zzdlt.zzZ("price", jSONObject.optString("price", (String) null));
            zzdlt.zzZ("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdlt;
        }
        throw new zzelj(1, "Invalid template ID: " + zzdlt.zzc());
    }
}
