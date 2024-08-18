package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzedm implements zzgfp {
    final /* synthetic */ zzbxn zza;
    final /* synthetic */ zzbxu zzb;

    zzedm(zzedq zzedq, zzbxn zzbxn, zzbxu zzbxu) {
        this.zza = zzbxn;
        this.zzb = zzbxu;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzbb.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
                this.zza.zzg(parcelFileDescriptor, this.zzb);
            } else {
                this.zza.zzf(parcelFileDescriptor);
            }
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
