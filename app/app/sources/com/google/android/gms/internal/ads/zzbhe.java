package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbhe extends zzbad implements IInterface {
    zzbhe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbwq zzbwq) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbwq);
        zzdc(1, zza);
    }
}
