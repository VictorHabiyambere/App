package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzch extends zzbae implements zzci {
    public zzch() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbaf.zzc(parcel);
                zzd((zze) zzbaf.zza(parcel, zze.CREATOR));
                break;
            case 2:
                zzf();
                break;
            case 3:
                zzc();
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
