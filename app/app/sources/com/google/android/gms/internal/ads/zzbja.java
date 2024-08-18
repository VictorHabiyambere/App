package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbja extends zzbad implements zzbjc {
    zzbja(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbip zzbip) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbip);
        zzdc(1, zza);
    }
}
