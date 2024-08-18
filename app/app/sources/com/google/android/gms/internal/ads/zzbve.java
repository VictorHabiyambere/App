package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbve extends zzbad implements zzbvg {
    zzbve(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final boolean zzH() throws RemoteException {
        Parcel zzdb = zzdb(11, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzbaf.zzd(zza, intent);
        zzdc(12, zza);
    }

    public final void zzi() throws RemoteException {
        zzdc(10, zza());
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(13, zza);
    }

    public final void zzl(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, bundle);
        zzdc(1, zza);
    }

    public final void zzm() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzp(int i, String[] strArr, int[] iArr) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzdc(15, zza);
    }

    public final void zzq() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzr() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzs(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, bundle);
        Parcel zzdb = zzdb(6, zza);
        if (zzdb.readInt() != 0) {
            bundle.readFromParcel(zzdb);
        }
        zzdb.recycle();
    }

    public final void zzt() throws RemoteException {
        zzdc(3, zza());
    }

    public final void zzu() throws RemoteException {
        zzdc(7, zza());
    }

    public final void zzv() throws RemoteException {
        zzdc(14, zza());
    }

    public final void zzx() throws RemoteException {
        zzdc(9, zza());
    }
}
