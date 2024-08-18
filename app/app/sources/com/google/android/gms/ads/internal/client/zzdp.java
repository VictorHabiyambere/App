package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbae;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzdp extends zzbae implements zzdq {
    public zzdp() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzdq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzdq ? (zzdq) queryLocalInterface : new zzdo(iBinder);
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a4;
                case 3: goto L_0x0096;
                case 4: goto L_0x0089;
                case 5: goto L_0x007e;
                case 6: goto L_0x0073;
                case 7: goto L_0x0068;
                case 8: goto L_0x0041;
                case 9: goto L_0x0035;
                case 10: goto L_0x0027;
                case 11: goto L_0x001b;
                case 12: goto L_0x000d;
                case 13: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            r1.zzn()
            r4.writeNoException()
            goto L_0x00b1
        L_0x000d:
            boolean r2 = r1.zzo()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x00b1
        L_0x001b:
            com.google.android.gms.ads.internal.client.zzdt r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r4, r2)
            goto L_0x00b1
        L_0x0027:
            boolean r2 = r1.zzp()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x00b1
        L_0x0035:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00b1
        L_0x0041:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0049
            r2 = 0
            goto L_0x005e
        L_0x0049:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.ads.internal.client.zzdt
            if (r0 == 0) goto L_0x0058
            r2 = r5
            com.google.android.gms.ads.internal.client.zzdt r2 = (com.google.android.gms.ads.internal.client.zzdt) r2
            goto L_0x005e
        L_0x0058:
            com.google.android.gms.ads.internal.client.zzdr r5 = new com.google.android.gms.ads.internal.client.zzdr
            r5.<init>(r2)
            r2 = r5
        L_0x005e:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x00b1
        L_0x0068:
            float r2 = r1.zzf()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00b1
        L_0x0073:
            float r2 = r1.zzg()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x00b1
        L_0x007e:
            int r2 = r1.zzh()
            r4.writeNoException()
            r4.writeInt(r2)
            goto L_0x00b1
        L_0x0089:
            boolean r2 = r1.zzq()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x00b1
        L_0x0096:
            boolean r2 = com.google.android.gms.internal.ads.zzbaf.zzg(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x00b1
        L_0x00a4:
            r1.zzk()
            r4.writeNoException()
            goto L_0x00b1
        L_0x00ab:
            r1.zzl()
            r4.writeNoException()
        L_0x00b1:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzdp.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
