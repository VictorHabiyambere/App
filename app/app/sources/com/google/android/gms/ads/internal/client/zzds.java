package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzds extends zzbae implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzi();
                break;
            case 2:
                zzh();
                break;
            case 3:
                zzg();
                break;
            case 4:
                zze();
                break;
            case 5:
                boolean zzg = zzbaf.zzg(parcel);
                zzbaf.zzc(parcel);
                zzf(zzg);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
