package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbqk implements zzbme {
    final /* synthetic */ zzbql zza;
    private final zzbpn zzb;
    private final zzccn zzc;

    public zzbqk(zzbql zzbql, zzbpn zzbpn, zzccn zzccn) {
        this.zza = zzbql;
        this.zzb = zzbpn;
        this.zzc = zzccn;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzc.zzd(new zzbpw());
            } catch (IllegalStateException e) {
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzbpw(str));
        }
        this.zzb.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
        } catch (IllegalStateException e) {
        } catch (JSONException e2) {
            this.zzc.zzd(e2);
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        this.zzb.zzb();
    }
}
