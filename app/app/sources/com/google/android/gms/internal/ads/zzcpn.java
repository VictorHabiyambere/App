package com.google.android.gms.internal.ads;

import com.google.firebase.database.core.ServerValues;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcpn implements zzcou {
    private final zzcak zza;

    zzcpn(zzcak zzcak) {
        this.zza = zzcak;
    }

    public final void zza(JSONObject jSONObject) {
        int i;
        long optLong = jSONObject.optLong(ServerValues.NAME_OP_TIMESTAMP);
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i, optLong);
    }
}
