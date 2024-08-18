package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbht extends zzbad implements zzbhv {
    zzbht(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final double zzb() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        double readDouble = zzdb.readDouble();
        zzdb.recycle();
        return readDouble;
    }

    public final int zzc() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        int readInt = zzdb.readInt();
        zzdb.recycle();
        return readInt;
    }

    public final int zzd() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        int readInt = zzdb.readInt();
        zzdb.recycle();
        return readInt;
    }

    public final Uri zze() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        Uri uri = (Uri) zzbaf.zza(zzdb, Uri.CREATOR);
        zzdb.recycle();
        return uri;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }
}
