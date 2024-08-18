package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbiy extends zzbae implements zzbiz {
    public zzbiy() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public static zzbiz zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
        return queryLocalInterface instanceof zzbiz ? (zzbiz) queryLocalInterface : new zzbix(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 != r6) goto L_0x002e
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x000b
            r3 = 0
            goto L_0x0020
        L_0x000b:
            java.lang.String r0 = "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbip
            if (r1 == 0) goto L_0x001a
            r3 = r0
            com.google.android.gms.internal.ads.zzbip r3 = (com.google.android.gms.internal.ads.zzbip) r3
            goto L_0x0020
        L_0x001a:
            com.google.android.gms.internal.ads.zzbin r0 = new com.google.android.gms.internal.ads.zzbin
            r0.<init>(r3)
            r3 = r0
        L_0x0020:
            java.lang.String r0 = r4.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zze(r3, r0)
            r5.writeNoException()
            return r6
        L_0x002e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiy.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
