package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public interface zzbza extends IInterface {
    Bundle zzb() throws RemoteException;

    zzdn zzc() throws RemoteException;

    zzbyx zzd() throws RemoteException;

    String zze() throws RemoteException;

    void zzf(zzl zzl, zzbzh zzbzh) throws RemoteException;

    void zzg(zzl zzl, zzbzh zzbzh) throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(zzdd zzdd) throws RemoteException;

    void zzj(zzdg zzdg) throws RemoteException;

    void zzk(zzbzd zzbzd) throws RemoteException;

    void zzl(zzbzo zzbzo) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    boolean zzo() throws RemoteException;

    void zzp(zzbzi zzbzi) throws RemoteException;
}
