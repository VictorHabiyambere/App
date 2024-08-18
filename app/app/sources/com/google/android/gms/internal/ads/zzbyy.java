package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbyy extends zzbad implements zzbza {
    zzbyy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final Bundle zzb() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        Bundle bundle = (Bundle) zzbaf.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzdn zzc() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        zzdn zzb = zzdm.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbyx zzd() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 11
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0027
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.rewarded.client.IRewardItem"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbyx
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.internal.ads.zzbyx r1 = (com.google.android.gms.internal.ads.zzbyx) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.internal.ads.zzbyv r2 = new com.google.android.gms.internal.ads.zzbyv
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyy.zzd():com.google.android.gms.internal.ads.zzbyx");
    }

    public final String zze() throws RemoteException {
        throw null;
    }

    public final void zzf(zzl zzl, zzbzh zzbzh) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, zzbzh);
        zzdc(1, zza);
    }

    public final void zzg(zzl zzl, zzbzh zzbzh) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzl);
        zzbaf.zzf(zza, zzbzh);
        zzdc(14, zza);
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbaf.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(15, zza);
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzdd);
        zzdc(8, zza);
    }

    public final void zzj(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzdg);
        zzdc(13, zza);
    }

    public final void zzk(zzbzd zzbzd) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbzd);
        zzdc(2, zza);
    }

    public final void zzl(zzbzo zzbzo) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbzo);
        zzdc(7, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(5, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    public final boolean zzo() throws RemoteException {
        throw null;
    }

    public final void zzp(zzbzi zzbzi) throws RemoteException {
        throw null;
    }
}
