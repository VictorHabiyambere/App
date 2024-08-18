package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbad;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbw extends zzbad implements zzby {
    zzbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public final void zze() throws RemoteException {
        zzdc(1, zza());
    }
}
