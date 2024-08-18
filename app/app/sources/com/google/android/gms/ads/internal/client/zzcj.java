package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbre;
import com.google.android.gms.internal.ads.zzbrf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzcj extends zzbad implements zzcl {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public final zzbrf getAdapterCreator() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbrf zzf = zzbre.zzf(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzf;
    }

    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel zzdb = zzdb(1, zza());
        zzen zzen = (zzen) zzbaf.zza(zzdb, zzen.CREATOR);
        zzdb.recycle();
        return zzen;
    }
}
