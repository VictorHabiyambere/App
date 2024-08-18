package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbce extends zzbad implements zzbcg {
    zzbce(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbu zze() throws RemoteException {
        throw null;
    }

    public final zzdn zzf() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdn zzb = zzdm.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final void zzg(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbaf.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(6, zza);
    }

    public final void zzh(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzdg);
        zzdc(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbcn zzbcn) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbcn);
        zzdc(4, zza);
    }
}
