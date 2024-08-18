package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzcbe extends zzbad implements zzcbg {
    zzcbe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, iObjectWrapper2);
        zza.writeString(str);
        zzbaf.zzf(zza, iObjectWrapper3);
        Parcel zzdb = zzdb(11, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzcbk zzcbk, zzcbd zzcbd) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzcbk);
        zzbaf.zzf(zza, zzcbd);
        zzdc(1, zza);
    }

    public final void zzg(zzbwe zzbwe) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbwe);
        zzdc(7, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbvv);
        zzdc(10, zza);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbvv);
        zzdc(9, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(8, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(2, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbvv);
        zzdc(6, zza);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbvv);
        zzdc(5, zza);
    }
}
