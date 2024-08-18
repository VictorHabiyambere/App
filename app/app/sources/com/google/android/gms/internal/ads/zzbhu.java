package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbhu extends zzbae implements zzbhv {
    public zzbhu() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbhv zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzbhv ? (zzbhv) queryLocalInterface : new zzbht(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzf = zzf();
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zzf);
                return true;
            case 2:
                Uri zze = zze();
                parcel2.writeNoException();
                zzbaf.zze(parcel2, zze);
                return true;
            case 3:
                double zzb = zzb();
                parcel2.writeNoException();
                parcel2.writeDouble(zzb);
                return true;
            case 4:
                int zzd = zzd();
                parcel2.writeNoException();
                parcel2.writeInt(zzd);
                return true;
            case 5:
                int zzc = zzc();
                parcel2.writeNoException();
                parcel2.writeInt(zzc);
                return true;
            default:
                return false;
        }
    }
}
