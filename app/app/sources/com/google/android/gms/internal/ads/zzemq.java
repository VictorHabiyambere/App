package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzemq implements zzehn {
    private final zzenu zza;
    private final zzdst zzb;

    zzemq(zzenu zzenu, zzdst zzdst) {
        this.zza = zzenu;
        this.zzb = zzdst;
    }

    public final zzeho zza(String str, JSONObject jSONObject) throws zzfhv {
        zzbte zzbte;
        if (((Boolean) zzba.zzc().zza(zzbep.zzbF)).booleanValue()) {
            try {
                zzbte = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzm.zzh("Coundn't create RTB adapter: ", e);
                zzbte = null;
            }
        } else {
            zzbte = this.zza.zza(str);
        }
        if (zzbte == null) {
            return null;
        }
        return new zzeho(zzbte, new zzejh(), str);
    }
}
