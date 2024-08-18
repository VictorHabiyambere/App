package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzekk extends zzbsx {
    final /* synthetic */ zzekl zza;
    private final zzeho zzb;

    /* synthetic */ zzekk(zzekl zzekl, zzeho zzeho, zzekj zzekj) {
        this.zza = zzekl;
        this.zzb = zzeho;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejh) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzejh) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(zzbru zzbru) throws RemoteException {
        this.zza.zzc = zzbru;
        ((zzejh) this.zzb.zzc).zzo();
    }
}
