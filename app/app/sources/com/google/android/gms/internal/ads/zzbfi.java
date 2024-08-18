package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbfi extends zzbad implements zzbfk {
    zzbfi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzbfh zzbfh) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbfh);
        zzdc(1, zza);
    }
}
