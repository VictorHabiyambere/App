package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbzd;
import com.google.android.gms.internal.ads.zzbzh;
import com.google.android.gms.internal.ads.zzbzi;
import com.google.android.gms.internal.ads.zzbzo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzfc extends zzbyz {
    private static void zzr(zzbzh zzbzh) {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzfb(zzbzh));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdn zzc() {
        return null;
    }

    public final zzbyx zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzl zzl, zzbzh zzbzh) throws RemoteException {
        zzr(zzbzh);
    }

    public final void zzg(zzl zzl, zzbzh zzbzh) throws RemoteException {
        zzr(zzbzh);
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
    }

    public final void zzj(zzdg zzdg) {
    }

    public final void zzk(zzbzd zzbzd) throws RemoteException {
    }

    public final void zzl(zzbzo zzbzo) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzp(zzbzi zzbzi) throws RemoteException {
    }
}
