package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbhr extends zzbae implements zzbhs {
    public zzbhr() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
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
                case 2: goto L_0x0085;
                case 3: goto L_0x0073;
                case 4: goto L_0x0068;
                case 5: goto L_0x005d;
                case 6: goto L_0x0052;
                case 7: goto L_0x0047;
                case 8: goto L_0x003a;
                case 9: goto L_0x0013;
                case 10: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            boolean r2 = r1.zzk()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x008f
        L_0x0013:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x001b
            r2 = 0
            goto L_0x0030
        L_0x001b:
            java.lang.String r5 = "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbjd
            if (r0 == 0) goto L_0x002a
            r2 = r5
            com.google.android.gms.internal.ads.zzbjd r2 = (com.google.android.gms.internal.ads.zzbjd) r2
            goto L_0x0030
        L_0x002a:
            com.google.android.gms.internal.ads.zzbjd r5 = new com.google.android.gms.internal.ads.zzbjd
            r5.<init>(r2)
            r2 = r5
        L_0x0030:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x008f
        L_0x003a:
            boolean r2 = r1.zzl()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x008f
        L_0x0047:
            com.google.android.gms.ads.internal.client.zzdq r2 = r1.zzh()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r4, r2)
            goto L_0x008f
        L_0x0052:
            float r2 = r1.zzf()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x008f
        L_0x005d:
            float r2 = r1.zzg()
            r4.writeNoException()
            r4.writeFloat(r2)
            goto L_0x008f
        L_0x0068:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzi()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r4, r2)
            goto L_0x008f
        L_0x0073:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzj(r2)
            r4.writeNoException()
            goto L_0x008f
        L_0x0085:
            float r2 = r1.zze()
            r4.writeNoException()
            r4.writeFloat(r2)
        L_0x008f:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhr.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
