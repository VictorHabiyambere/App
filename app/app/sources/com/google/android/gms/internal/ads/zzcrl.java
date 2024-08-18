package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcrl implements zzhkp {
    private final zzhlg zza;

    public zzcrl(zzhlg zzhlg) {
        this.zza = zzhlg;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcvg) this.zza).zza().zzA);
        } catch (JSONException e) {
            return null;
        }
    }
}
