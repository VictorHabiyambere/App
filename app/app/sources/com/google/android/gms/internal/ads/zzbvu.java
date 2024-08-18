package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbvu extends zzbae implements zzbvv {
    public zzbvu() {
        super("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    public static zzbvv zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
        return queryLocalInterface instanceof zzbvv ? (zzbvv) queryLocalInterface : new zzbvt(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                ArrayList createTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                zzbaf.zzc(parcel);
                zzf(createTypedArrayList);
                break;
            case 2:
                String readString = parcel.readString();
                zzbaf.zzc(parcel);
                zze(readString);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
