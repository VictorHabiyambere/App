package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbqs implements zzbme {
    final /* synthetic */ zzbqt zza;
    private final zzccn zzb;

    public zzbqs(zzbqt zzbqt, zzccn zzccn) {
        this.zza = zzbqt;
        this.zzb = zzccn;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzb.zzd(new zzbpw());
            } catch (IllegalStateException e) {
            }
        } else {
            this.zzb.zzd(new zzbpw(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzc(jSONObject);
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.zzb.zzd(e2);
        }
    }
}
