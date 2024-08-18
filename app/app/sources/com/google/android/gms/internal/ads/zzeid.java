package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeid extends zzbso {
    private final zzeho zza;

    /* synthetic */ zzeid(zzeho zzeho, zzeic zzeic) {
        this.zza = zzeho;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejh) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzejh) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzejh) this.zza.zzc).zzo();
    }
}
