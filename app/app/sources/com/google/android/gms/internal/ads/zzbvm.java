package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbvm {
    public final boolean zza;
    public final String zzb;

    public zzbvm(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    public static zzbvm zza(JSONObject jSONObject) {
        return new zzbvm(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
