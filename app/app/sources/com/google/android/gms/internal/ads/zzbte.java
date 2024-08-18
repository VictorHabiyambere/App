package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public interface zzbte extends IInterface {
    zzdq zze() throws RemoteException;

    zzbtt zzf() throws RemoteException;

    zzbtt zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbth zzbth) throws RemoteException;

    void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsp zzbsp, zzbrl zzbrl) throws RemoteException;

    void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException;

    void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException;

    void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsv zzbsv, zzbrl zzbrl) throws RemoteException;

    void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl) throws RemoteException;

    void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl, zzbhk zzbhk) throws RemoteException;

    void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException;

    void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
