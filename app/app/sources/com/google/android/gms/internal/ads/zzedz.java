package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzedz implements zzgfp {
    final /* synthetic */ zzbxk zza;

    zzedz(zzeea zzeea, zzbxk zzbxk) {
        this.zza = zzbxk;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzbb.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Ad service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zze.zzb("Ad service can't call client", e);
        }
    }
}
