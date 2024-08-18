package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbhy extends zzbae implements zzbhz {
    public zzbhy() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzbhz zzdA(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzbhz ? (zzbhz) queryLocalInterface : new zzbhx(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v4, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x00a0;
                case 2: goto L_0x008e;
                case 3: goto L_0x007c;
                case 4: goto L_0x0075;
                case 5: goto L_0x0064;
                case 6: goto L_0x0052;
                case 7: goto L_0x0040;
                case 8: goto L_0x0018;
                case 9: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzdy(r2)
            r4.writeNoException()
            goto L_0x00b5
        L_0x0018:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0020
            r2 = 0
            goto L_0x0035
        L_0x0020:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbhs
            if (r0 == 0) goto L_0x002f
            r2 = r5
            com.google.android.gms.internal.ads.zzbhs r2 = (com.google.android.gms.internal.ads.zzbhs) r2
            goto L_0x0035
        L_0x002f:
            com.google.android.gms.internal.ads.zzbhq r5 = new com.google.android.gms.internal.ads.zzbhq
            r5.<init>(r2)
            r2 = r5
        L_0x0035:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzdx(r2)
            r4.writeNoException()
            goto L_0x00b5
        L_0x0040:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzd(r2)
            r4.writeNoException()
            goto L_0x00b5
        L_0x0052:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzdw(r2)
            r4.writeNoException()
            goto L_0x00b5
        L_0x0064:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r3.readInt()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r4.writeNoException()
            goto L_0x00b5
        L_0x0075:
            r1.zzc()
            r4.writeNoException()
            goto L_0x00b5
        L_0x007c:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzdz(r2)
            r4.writeNoException()
            goto L_0x00b5
        L_0x008e:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzb(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r4, r2)
            goto L_0x00b5
        L_0x00a0:
            java.lang.String r2 = r3.readString()
            android.os.IBinder r5 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r5)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzdv(r2, r5)
            r4.writeNoException()
        L_0x00b5:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhy.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
