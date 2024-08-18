package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzbaf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzdo extends zzbad implements zzdq {
    zzdo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final float zze() throws RemoteException {
        throw null;
    }

    public final float zzf() throws RemoteException {
        throw null;
    }

    public final float zzg() throws RemoteException {
        throw null;
    }

    public final int zzh() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        int readInt = zzdb.readInt();
        zzdb.recycle();
        return readInt;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.internal.client.zzdt zzi() throws android.os.RemoteException {
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
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.ads.internal.client.zzdt
            if (r3 == 0) goto L_0x0021
            r1 = r2
            com.google.android.gms.ads.internal.client.zzdt r1 = (com.google.android.gms.ads.internal.client.zzdt) r1
            goto L_0x0027
        L_0x0021:
            com.google.android.gms.ads.internal.client.zzdr r2 = new com.google.android.gms.ads.internal.client.zzdr
            r2.<init>(r1)
            r1 = r2
        L_0x0027:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzdo.zzi():com.google.android.gms.ads.internal.client.zzdt");
    }

    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzbaf.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(3, zza);
    }

    public final void zzk() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzl() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zzm(zzdt zzdt) throws RemoteException {
        Parcel zza = zza();
        zzbaf.zzf(zza, zzdt);
        zzdc(8, zza);
    }

    public final void zzn() throws RemoteException {
        zzdc(13, zza());
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzdb = zzdb(12, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzdb = zzdb(10, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        boolean zzg = zzbaf.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
