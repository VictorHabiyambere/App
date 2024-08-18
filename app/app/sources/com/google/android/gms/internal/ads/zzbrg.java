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
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbrg extends zzbad implements zzbri {
    zzbrg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zzbaf.zzf(zza, zzbrl);
        zzdc(28, zza);
    }

    public final void zzB(zzl zzl, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zzbaf.zzf(zza, zzbrl);
        zzdc(32, zza);
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(21, zza);
    }

    public final void zzE() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzF() throws RemoteException {
        zzdc(9, zza());
    }

    public final void zzG(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbaf.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(25, zza);
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(39, zza);
    }

    public final void zzI() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(37, zza);
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzdc(30, zza);
    }

    public final void zzL() throws RemoteException {
        zzdc(12, zza());
    }

    public final boolean zzM() throws RemoteException {
        Parcel zzdb = zzdb(22, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzN() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbrq zzO() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 15
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0027
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbrq
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.internal.ads.zzbrq r1 = (com.google.android.gms.internal.ads.zzbrq) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.internal.ads.zzbrq r2 = new com.google.android.gms.internal.ads.zzbrq
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrg.zzO():com.google.android.gms.internal.ads.zzbrq");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbrr zzP() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 16
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0027
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbrr
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.internal.ads.zzbrr r1 = (com.google.android.gms.internal.ads.zzbrr) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.internal.ads.zzbrr r2 = new com.google.android.gms.internal.ads.zzbrr
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrg.zzP():com.google.android.gms.internal.ads.zzbrr");
    }

    public final Bundle zze() throws RemoteException {
        throw null;
    }

    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    public final zzdq zzh() throws RemoteException {
        Parcel zzdb = zzdb(26, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbip zzi() throws RemoteException {
        throw null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbro zzj() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 36
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0027
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbro
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.internal.ads.zzbro r1 = (com.google.android.gms.internal.ads.zzbro) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.internal.ads.zzbrm r2 = new com.google.android.gms.internal.ads.zzbrm
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrg.zzj():com.google.android.gms.internal.ads.zzbro");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbru zzk() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 27
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0027
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbru
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.internal.ads.zzbru r1 = (com.google.android.gms.internal.ads.zzbru) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.internal.ads.zzbrs r2 = new com.google.android.gms.internal.ads.zzbrs
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrg.zzk():com.google.android.gms.internal.ads.zzbru");
    }

    public final zzbtt zzl() throws RemoteException {
        Parcel zzdb = zzdb(33, zza());
        zzbtt zzbtt = (zzbtt) zzbaf.zza(zzdb, zzbtt.CREATOR);
        zzdb.recycle();
        return zzbtt;
    }

    public final zzbtt zzm() throws RemoteException {
        Parcel zzdb = zzdb(34, zza());
        zzbtt zzbtt = (zzbtt) zzbaf.zza(zzdb, zzbtt.CREATOR);
        zzdb.recycle();
        return zzbtt;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbys zzbys, String str2) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString((String) null);
        zzbaf.zzf(zza, zzbys);
        zza.writeString(str2);
        zzdc(10, zza);
    }

    public final void zzq(IObjectWrapper iObjectWrapper, zzbnr zzbnr, List list) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbnr);
        zza.writeTypedList(list);
        zzdc(31, zza);
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbys zzbys, List list) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzf(zza, zzbys);
        zza.writeStringList(list);
        zzdc(23, zza);
    }

    public final void zzs(zzl zzl, String str) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zzdc(11, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zzbaf.zzf(zza, zzbrl);
        zzdc(38, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, zzbrl zzbrl) throws RemoteException {
        throw null;
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzq);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzf(zza, zzbrl);
        zzdc(6, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl, String str, String str2, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzq);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzf(zza, zzbrl);
        zzdc(35, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl, String str, zzbrl zzbrl) throws RemoteException {
        throw null;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbrl zzbrl) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzf(zza, zzbrl);
        zzdc(7, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl, String str, String str2, zzbrl zzbrl, zzbhk zzbhk, List list) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, iObjectWrapper);
        zzbaf.zzd(zza, zzl);
        zza.writeString(str);
        zza.writeString(str2);
        zzbaf.zzf(zza, zzbrl);
        zzbaf.zzd(zza, zzbhk);
        zza.writeStringList(list);
        zzdc(14, zza);
    }
}
