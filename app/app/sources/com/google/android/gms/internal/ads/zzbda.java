package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbda extends zzbad implements IInterface {
    zzbda(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbcy zzbcy) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbcy);
        Parcel zzdb = zzdb(3, zza);
        long readLong = zzdb.readLong();
        zzdb.recycle();
        return readLong;
    }

    public final zzbcv zzf(zzbcy zzbcy) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbcy);
        Parcel zzdb = zzdb(1, zza);
        zzbcv zzbcv = (zzbcv) zzbaf.zza(zzdb, zzbcv.CREATOR);
        zzdb.recycle();
        return zzbcv;
    }

    public final zzbcv zzg(zzbcy zzbcy) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbcy);
        Parcel zzdb = zzdb(2, zza);
        zzbcv zzbcv = (zzbcv) zzbaf.zza(zzdb, zzbcv.CREATOR);
        zzdb.recycle();
        return zzbcv;
    }
}
