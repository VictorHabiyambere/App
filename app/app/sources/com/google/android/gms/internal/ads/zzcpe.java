package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcpe implements zzcou {
    private final zzdya zza;

    zzcpe(zzdya zzdya) {
        this.zza = zzdya;
    }

    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzjk)).booleanValue()) {
                this.zza.zzn(jSONObject);
            }
        }
    }
}
