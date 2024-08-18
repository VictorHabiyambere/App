package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdwg {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    /* synthetic */ zzdwg(String str, zzdwf zzdwf) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdwg zzdwg) {
        String str = (String) zzba.zzc().zza(zzbep.zzjX);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdwg.zza);
            jSONObject.put("eventCategory", zzdwg.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdwg.zzc);
            jSONObject.putOpt("errorCode", zzdwg.zzd);
            jSONObject.putOpt("rewardType", zzdwg.zze);
            jSONObject.putOpt("rewardAmount", zzdwg.zzf);
        } catch (JSONException e) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
