package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzbxg extends zzbae implements zzbxh {
    public zzbxg() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbxk zzbxk = null;
        switch (i) {
            case 1:
                zzbwv zzbwv = (zzbwv) zzbaf.zza(parcel, zzbwv.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                    zzbxk = queryLocalInterface instanceof zzbxk ? (zzbxk) queryLocalInterface : new zzbxi(readStrongBinder);
                }
                zzbaf.zzc(parcel);
                zzf(zzbwv, zzbxk);
                break;
            case 2:
                zzbwv zzbwv2 = (zzbwv) zzbaf.zza(parcel, zzbwv.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                    if (queryLocalInterface2 instanceof zzbxk) {
                        zzbxk zzbxk2 = (zzbxk) queryLocalInterface2;
                    }
                }
                zzbaf.zzc(parcel);
                break;
            case 3:
                zzbwz zzbwz = (zzbwz) zzbaf.zza(parcel, zzbwz.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                    zzbxk = queryLocalInterface3 instanceof zzbxk ? (zzbxk) queryLocalInterface3 : new zzbxi(readStrongBinder3);
                }
                zzbaf.zzc(parcel);
                zze(zzbwz, zzbxk);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
