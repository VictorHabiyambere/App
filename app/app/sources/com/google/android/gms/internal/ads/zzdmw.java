package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.firebase.database.core.ServerValues;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdmw implements zzblp {
    public final /* synthetic */ zzdmx zza;
    public final /* synthetic */ zzbjp zzb;

    public /* synthetic */ zzdmw(zzdmx zzdmx, zzbjp zzbjp) {
        this.zza = zzdmx;
        this.zzb = zzbjp;
    }

    public final void zza(Object obj, Map map) {
        zzdmx zzdmx = this.zza;
        try {
            zzdmx.zzb = Long.valueOf(Long.parseLong((String) map.get(ServerValues.NAME_OP_TIMESTAMP)));
        } catch (NumberFormatException e) {
            zzm.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzbjp zzbjp = this.zzb;
        zzdmx.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzbjp == null) {
            zzm.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbjp.zzf(str);
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }
}
