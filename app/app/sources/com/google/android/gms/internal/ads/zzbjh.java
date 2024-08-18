package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbjh extends zzbad implements zzbjj {
    zzbjh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbjs zzbjs) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbjs);
        zzdc(1, zza);
    }
}
