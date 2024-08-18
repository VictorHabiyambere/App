package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbcf extends zzbae implements zzbcg {
    public zzbcf() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
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
                case 2: goto L_0x007b;
                case 3: goto L_0x0060;
                case 4: goto L_0x0031;
                case 5: goto L_0x0026;
                case 6: goto L_0x0018;
                case 7: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r3 = 0
            return r3
        L_0x0005:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdg r3 = com.google.android.gms.ads.internal.client.zzdf.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzh(r3)
            r5.writeNoException()
            goto L_0x0085
        L_0x0018:
            boolean r3 = com.google.android.gms.internal.ads.zzbaf.zzg(r4)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzg(r3)
            r5.writeNoException()
            goto L_0x0085
        L_0x0026:
            com.google.android.gms.ads.internal.client.zzdn r3 = r2.zzf()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0085
        L_0x0031:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r6 = r4.readStrongBinder()
            if (r6 != 0) goto L_0x0041
            r6 = 0
            goto L_0x0056
        L_0x0041:
            java.lang.String r0 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback"
            android.os.IInterface r0 = r6.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzbcn
            if (r1 == 0) goto L_0x0050
            r6 = r0
            com.google.android.gms.internal.ads.zzbcn r6 = (com.google.android.gms.internal.ads.zzbcn) r6
            goto L_0x0056
        L_0x0050:
            com.google.android.gms.internal.ads.zzbcl r0 = new com.google.android.gms.internal.ads.zzbcl
            r0.<init>(r6)
            r6 = r0
        L_0x0056:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzi(r3, r6)
            r5.writeNoException()
            goto L_0x0085
        L_0x0060:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0067
            goto L_0x0074
        L_0x0067:
            java.lang.String r6 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback"
            android.os.IInterface r3 = r3.queryLocalInterface(r6)
            boolean r6 = r3 instanceof com.google.android.gms.internal.ads.zzbck
            if (r6 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzbck r3 = (com.google.android.gms.internal.ads.zzbck) r3
        L_0x0074:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r5.writeNoException()
            goto L_0x0085
        L_0x007b:
            com.google.android.gms.ads.internal.client.zzbu r3 = r2.zze()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
        L_0x0085:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcf.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
