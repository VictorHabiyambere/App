package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbm extends zzbae implements zzbn {
    public zzbm() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbaf.zzc(parcel);
                zzg((zzl) zzbaf.zza(parcel, zzl.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                String zze = zze();
                parcel2.writeNoException();
                parcel2.writeString(zze);
                return true;
            case 3:
                boolean zzi = zzi();
                parcel2.writeNoException();
                int i3 = zzbaf.zza;
                parcel2.writeInt(zzi ? 1 : 0);
                return true;
            case 4:
                String zzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(zzf);
                return true;
            case 5:
                int readInt = parcel.readInt();
                zzbaf.zzc(parcel);
                zzh((zzl) zzbaf.zza(parcel, zzl.CREATOR), readInt);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
