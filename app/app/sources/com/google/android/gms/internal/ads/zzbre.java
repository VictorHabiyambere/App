package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbre extends zzbae implements zzbrf {
    public zzbre() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbrf zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzbrf ? (zzbrf) queryLocalInterface : new zzbrd(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String readString = parcel.readString();
                zzbaf.zzc(parcel);
                zzbri zzb = zzb(readString);
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zzb);
                return true;
            case 2:
                String readString2 = parcel.readString();
                zzbaf.zzc(parcel);
                boolean zze = zze(readString2);
                parcel2.writeNoException();
                parcel2.writeInt(zze ? 1 : 0);
                return true;
            case 3:
                String readString3 = parcel.readString();
                zzbaf.zzc(parcel);
                zzbte zzc = zzc(readString3);
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zzc);
                return true;
            case 4:
                String readString4 = parcel.readString();
                zzbaf.zzc(parcel);
                boolean zzd = zzd(readString4);
                parcel2.writeNoException();
                parcel2.writeInt(zzd ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
