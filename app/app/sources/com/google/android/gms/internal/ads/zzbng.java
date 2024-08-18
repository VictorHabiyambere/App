package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbng extends zzbad implements IInterface {
    zzbng(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbna zzbna, zzbnf zzbnf) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbna);
        zzbaf.zzf(zza, zzbnf);
        zzdd(2, zza);
    }
}
