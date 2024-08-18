package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbw;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdlx extends zzdly {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdlx(zzfgt zzfgt, JSONObject jSONObject) {
        super(zzfgt);
        boolean z = false;
        this.zzb = zzbw.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzc = zzbw.zzl(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbw.zzl(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbw.zzl(false, jSONObject, "enable_omid");
        this.zzg = zzbw.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
        this.zzh = ((Boolean) zzba.zzc().zza(zzbep.zzfg)).booleanValue() ? jSONObject.optJSONObject("omid_settings") : null;
    }

    public final zzfhr zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzfhr(jSONObject) : this.zza.zzW;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzA);
        } catch (JSONException e) {
            return null;
        }
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
