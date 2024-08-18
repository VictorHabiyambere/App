package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzepo implements zzczo {
    public final /* synthetic */ zzepc zza;
    public final /* synthetic */ zzboi zzb;

    public /* synthetic */ zzepo(zzepc zzepc, zzboi zzboi) {
        this.zza = zzepc;
        this.zzb = zzboi;
    }

    public final void zzdB(zze zze) {
        this.zza.zzdB(zze);
        zzboi zzboi = this.zzb;
        if (zzboi != null) {
            try {
                zzboi.zzf(zze);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzboi != null) {
            try {
                zzboi.zze(zze.zza);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
