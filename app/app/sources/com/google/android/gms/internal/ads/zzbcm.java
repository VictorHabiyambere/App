package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbcm extends zzbae implements zzbcn {
    public zzbcm() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzf();
                break;
            case 2:
                zzc();
                break;
            case 3:
                zzbaf.zzc(parcel);
                zzd((zze) zzbaf.zza(parcel, zze.CREATOR));
                break;
            case 4:
                zze();
                break;
            case 5:
                zzb();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
