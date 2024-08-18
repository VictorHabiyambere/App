package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbyi extends zzbad implements IInterface {
    zzbyi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbyh zzbyh, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbyh);
        zza.writeString(str);
        zza.writeString(str2);
        zzdc(2, zza);
    }
}
