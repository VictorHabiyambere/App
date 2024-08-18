package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbix extends zzbad implements zzbiz {
    zzbix(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbip zzbip, String str) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbip);
        zza.writeString(str);
        zzdc(1, zza);
    }
}
