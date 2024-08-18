package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzcbc extends zzbae implements zzcbd {
    public zzcbc() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                parcel.readString();
                parcel.readString();
                zzbaf.zzc(parcel);
                break;
            case 2:
                String readString = parcel.readString();
                zzbaf.zzc(parcel);
                zzb(readString);
                break;
            case 3:
                zzbaf.zzc(parcel);
                zzc(parcel.readString(), parcel.readString(), (Bundle) zzbaf.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
