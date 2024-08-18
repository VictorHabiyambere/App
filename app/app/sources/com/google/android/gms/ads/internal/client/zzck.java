package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbrf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzck extends zzbae implements zzcl {
    public zzck() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static zzcl asInterface(IBinder obj) {
        if (obj == null) {
            return null;
        }
        IInterface queryLocalInterface = obj.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        return queryLocalInterface instanceof zzcl ? (zzcl) queryLocalInterface : new zzcj(obj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzen liteSdkVersion = getLiteSdkVersion();
                parcel2.writeNoException();
                zzbaf.zze(parcel2, liteSdkVersion);
                return true;
            case 2:
                zzbrf adapterCreator = getAdapterCreator();
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, adapterCreator);
                return true;
            default:
                return false;
        }
    }
}
