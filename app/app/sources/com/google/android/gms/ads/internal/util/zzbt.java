package com.google.android.gms.ads.internal.util;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public interface zzbt extends IInterface {
    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException;

    boolean zzg(IObjectWrapper iObjectWrapper, zza zza) throws RemoteException;
}
