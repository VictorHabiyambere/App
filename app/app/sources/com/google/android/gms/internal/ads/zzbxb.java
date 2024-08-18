package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbxb extends zzbad implements zzbxd {
    zzbxb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzbxu zzbxu, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbxu);
        zzbaf.zzf(zza, zzbxn);
        zzdc(6, zza);
    }

    public final void zzf(zzbxu zzbxu, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbxu);
        zzbaf.zzf(zza, zzbxn);
        zzdc(5, zza);
    }

    public final void zzg(zzbxu zzbxu, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbxu);
        zzbaf.zzf(zza, zzbxn);
        zzdc(4, zza);
    }

    public final void zzh(String str, zzbxn zzbxn) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbaf.zzf(zza, zzbxn);
        zzdc(7, zza);
    }
}
