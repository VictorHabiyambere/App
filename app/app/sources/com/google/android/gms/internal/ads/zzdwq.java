package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdwq extends zzbzg {
    final /* synthetic */ zzdws zza;

    zzdwq(zzdws zzdws) {
        this.zza = zzdws;
    }

    public final void zze(int i) throws RemoteException {
        zzdws zzdws = this.zza;
        zzdws.zzb.zzm(zzdws.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzdws zzdws = this.zza;
        zzdws.zzb.zzm(zzdws.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzdws zzdws = this.zza;
        zzdws.zzb.zzp(zzdws.zza);
    }
}
