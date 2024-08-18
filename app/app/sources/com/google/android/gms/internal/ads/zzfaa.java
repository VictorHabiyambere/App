package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfaa implements zzexv {
    private final String zza;

    public zzfaa(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject zzg = zzbw.zzg((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zza)) {
                zzg.put("attok", this.zza);
            }
        } catch (JSONException e) {
            zze.zzb("Failed putting attestation token.", e);
        }
    }
}
