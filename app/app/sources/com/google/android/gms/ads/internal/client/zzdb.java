package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbad;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzdb extends zzbad implements zzdd {
    zzdb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    public final void zze() throws RemoteException {
        zzdc(1, zza());
    }
}
