package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbf extends zzbad implements zzbh {
    zzbf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzc() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzd() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zze(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zze);
        zzdc(8, zza);
    }

    public final void zzg() throws RemoteException {
        zzdc(7, zza());
    }

    public final void zzh() throws RemoteException {
        zzdc(3, zza());
    }

    public final void zzi() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzj() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzk() throws RemoteException {
        zzdc(9, zza());
    }
}
