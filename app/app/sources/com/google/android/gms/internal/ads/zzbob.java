package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbob extends zzbae implements zzboc {
    public zzbob() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            switch(r3) {
                case 3: goto L_0x0058;
                case 4: goto L_0x0051;
                case 5: goto L_0x0022;
                case 6: goto L_0x0010;
                case 7: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r3 = 0
            return r3
        L_0x0005:
            com.google.android.gms.internal.ads.zzbhs r3 = r2.zzc()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0062
        L_0x0010:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zze(r3)
            r5.writeNoException()
            goto L_0x0062
        L_0x0022:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x0032
            r6 = 0
            goto L_0x0047
        L_0x0032:
            java.lang.String r0 = "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbof
            if (r1 == 0) goto L_0x0041
            r6 = r0
            com.google.android.gms.internal.ads.zzbof r6 = (com.google.android.gms.internal.ads.zzbof) r6
            goto L_0x0047
        L_0x0041:
            com.google.android.gms.internal.ads.zzbod r0 = new com.google.android.gms.internal.ads.zzbod
            r0.<init>(r6)
            r6 = r0
        L_0x0047:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzf(r3, r6)
            r5.writeNoException()
            goto L_0x0062
        L_0x0051:
            r2.zzd()
            r5.writeNoException()
            goto L_0x0062
        L_0x0058:
            com.google.android.gms.ads.internal.client.zzdq r3 = r2.zzb()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
        L_0x0062:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbob.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
