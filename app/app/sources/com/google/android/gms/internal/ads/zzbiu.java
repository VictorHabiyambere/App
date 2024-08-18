package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbiu extends zzbad implements zzbiw {
    zzbiu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbim zzbim) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbim);
        zzdc(1, zza);
    }
}
