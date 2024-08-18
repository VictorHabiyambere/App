package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbxf extends zzbad implements zzbxh {
    zzbxf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final void zze(zzbwz zzbwz, zzbxk zzbxk) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbwz);
        zzbaf.zzf(zza, zzbxk);
        zzdc(3, zza);
    }

    public final void zzf(zzbwv zzbwv, zzbxk zzbxk) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbwv);
        zzbaf.zzf(zza, zzbxk);
        zzdc(1, zza);
    }
}
