package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzecj implements zzfxu {
    public final /* synthetic */ zzeck zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzecj(zzeck zzeck, zzbxu zzbxu) {
        this.zza = zzeck;
        this.zzb = zzbxu;
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zzb.zza;
        if (bundle == null) {
            return jSONObject;
        }
        try {
            JSONObject zzi = zzay.zzb().zzi(bundle);
            try {
                zzay.zzb().zzl(jSONObject, zzi);
                return jSONObject;
            } catch (JSONException e) {
                return zzi;
            }
        } catch (JSONException e2) {
            return jSONObject;
        }
    }
}
