package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbtc extends zzbad implements zzbte {
    zzbtc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzdq zze() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbtt zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbtt zzbtt = (zzbtt) zzbaf.zza(zzdb, zzbtt.CREATOR);
        zzdb.recycle();
        return zzbtt;
    }

    public final zzbtt zzg() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        zzbtt zzbtt = (zzbtt) zzbaf.zza(zzdb, zzbtt.CREATOR);
        zzdb.recycle();
        return zzbtt;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbth zzbth) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzbaf.zzd(zza, bundle);
        zzbaf.zzd(zza, bundle2);
        zzbaf.zzd(zza, zzq);
        zzbaf.zzf(zza, zzbth);
        zzdc(1, zza);
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsp zzbsp, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbsp);
        zzbaf.zzf(zza, zzbrl);
        zzdc(23, zza);
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbss);
        zzbaf.zzf(zza, zzbrl);
        zzbaf.zzd(zza, zzq);
        zzdc(13, zza);
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbss);
        zzbaf.zzf(zza, zzbrl);
        zzbaf.zzd(zza, zzq);
        zzdc(21, zza);
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsv zzbsv, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbsv);
        zzbaf.zzf(zza, zzbrl);
        zzdc(14, zza);
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbsy);
        zzbaf.zzf(zza, zzbrl);
        zzdc(18, zza);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl, zzbhk zzbhk) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbsy);
        zzbaf.zzf(zza, zzbrl);
        zzbaf.zzd(zza, zzbhk);
        zzdc(22, zza);
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbtb);
        zzbaf.zzf(zza, zzbrl);
        zzdc(20, zza);
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbtb);
        zzbaf.zzf(zza, zzbrl);
        zzdc(16, zza);
    }

    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(19, zza);
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(24, zza);
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(15, zza);
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(17, zza);
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
