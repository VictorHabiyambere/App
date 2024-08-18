package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzbiz;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbjg;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnz;
import com.google.android.gms.internal.ads.zzboi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbo extends zzbad implements zzbq {
    zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzbn zze() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 1
            android.os.Parcel r0 = r4.zzdb(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0026
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzbn
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.ads.internal.client.zzbn r1 = (com.google.android.gms.ads.internal.client.zzbn) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.ads.internal.client.zzbl r2 = new com.google.android.gms.ads.internal.client.zzbl
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbo.zze():com.google.android.gms.ads.internal.client.zzbn");
    }

    public final void zzf(zzbit zzbit) throws RemoteException {
        throw null;
    }

    public final void zzg(zzbiw zzbiw) throws RemoteException {
        throw null;
    }

    public final void zzh(String str, zzbjc zzbjc, zzbiz zzbiz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbaf.zzf(zza, zzbjc);
        zzbaf.zzf(zza, zzbiz);
        zzdc(5, zza);
    }

    public final void zzi(zzboi zzboi) throws RemoteException {
        throw null;
    }

    public final void zzj(zzbjg zzbjg, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbjg);
        zzbaf.zzd(zza, zzq);
        zzdc(8, zza);
    }

    public final void zzk(zzbjj zzbjj) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbjj);
        zzdc(10, zza);
    }

    public final void zzl(zzbh zzbh) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzbh);
        zzdc(2, zza);
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, adManagerAdViewOptions);
        zzdc(15, zza);
    }

    public final void zzn(zzbnz zzbnz) throws RemoteException {
        throw null;
    }

    public final void zzo(zzbhk zzbhk) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzd(zza, zzbhk);
        zzdc(6, zza);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        throw null;
    }

    public final void zzq(zzcf zzcf) throws RemoteException {
        throw null;
    }
}
