package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public interface zzbcg extends IInterface {
    zzbu zze() throws RemoteException;

    zzdn zzf() throws RemoteException;

    void zzg(boolean z) throws RemoteException;

    void zzh(zzdg zzdg) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, zzbcn zzbcn) throws RemoteException;
}
