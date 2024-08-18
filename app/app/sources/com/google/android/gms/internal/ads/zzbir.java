package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbir extends zzbad implements zzbit {
    zzbir(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbik zzbik) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbik);
        zzdc(1, zza);
    }
}
