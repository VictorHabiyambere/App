package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzbxc extends zzbae implements zzbxd {
    public zzbxc() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r6v5, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r6v6, types: [android.os.IInterface] */
    /* JADX WARNING: type inference failed for: r6v7, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            java.lang.String r6 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            r0 = 0
            switch(r3) {
                case 1: goto L_0x00d5;
                case 2: goto L_0x00b2;
                case 3: goto L_0x0006;
                case 4: goto L_0x0087;
                case 5: goto L_0x005c;
                case 6: goto L_0x0030;
                case 7: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r3 = 0
            return r3
        L_0x0008:
            java.lang.String r3 = r4.readString()
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0013
            goto L_0x0025
        L_0x0013:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxn
            if (r0 == 0) goto L_0x0020
            r0 = r6
            com.google.android.gms.internal.ads.zzbxn r0 = (com.google.android.gms.internal.ads.zzbxn) r0
            goto L_0x0025
        L_0x0020:
            com.google.android.gms.internal.ads.zzbxl r0 = new com.google.android.gms.internal.ads.zzbxl
            r0.<init>(r1)
        L_0x0025:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzh(r3, r0)
            r5.writeNoException()
            goto L_0x00e6
        L_0x0030:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbxu> r3 = com.google.android.gms.internal.ads.zzbxu.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbxu r3 = (com.google.android.gms.internal.ads.zzbxu) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x003f
            goto L_0x0051
        L_0x003f:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxn
            if (r0 == 0) goto L_0x004c
            r0 = r6
            com.google.android.gms.internal.ads.zzbxn r0 = (com.google.android.gms.internal.ads.zzbxn) r0
            goto L_0x0051
        L_0x004c:
            com.google.android.gms.internal.ads.zzbxl r0 = new com.google.android.gms.internal.ads.zzbxl
            r0.<init>(r1)
        L_0x0051:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zze(r3, r0)
            r5.writeNoException()
            goto L_0x00e6
        L_0x005c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbxu> r3 = com.google.android.gms.internal.ads.zzbxu.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbxu r3 = (com.google.android.gms.internal.ads.zzbxu) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x006b
            goto L_0x007d
        L_0x006b:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxn
            if (r0 == 0) goto L_0x0078
            r0 = r6
            com.google.android.gms.internal.ads.zzbxn r0 = (com.google.android.gms.internal.ads.zzbxn) r0
            goto L_0x007d
        L_0x0078:
            com.google.android.gms.internal.ads.zzbxl r0 = new com.google.android.gms.internal.ads.zzbxl
            r0.<init>(r1)
        L_0x007d:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzf(r3, r0)
            r5.writeNoException()
            goto L_0x00e6
        L_0x0087:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbxu> r3 = com.google.android.gms.internal.ads.zzbxu.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbxu r3 = (com.google.android.gms.internal.ads.zzbxu) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0096
            goto L_0x00a8
        L_0x0096:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbxn
            if (r0 == 0) goto L_0x00a3
            r0 = r6
            com.google.android.gms.internal.ads.zzbxn r0 = (com.google.android.gms.internal.ads.zzbxn) r0
            goto L_0x00a8
        L_0x00a3:
            com.google.android.gms.internal.ads.zzbxl r0 = new com.google.android.gms.internal.ads.zzbxl
            r0.<init>(r1)
        L_0x00a8:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzg(r3, r0)
            r5.writeNoException()
            goto L_0x00e6
        L_0x00b2:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbws> r3 = com.google.android.gms.internal.ads.zzbws.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbws r3 = (com.google.android.gms.internal.ads.zzbws) r3
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00c1
            goto L_0x00ce
        L_0x00c1:
            java.lang.String r6 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r3 = r3.queryLocalInterface(r6)
            boolean r6 = r3 instanceof com.google.android.gms.internal.ads.zzbxe
            if (r6 == 0) goto L_0x00ce
            com.google.android.gms.internal.ads.zzbxe r3 = (com.google.android.gms.internal.ads.zzbxe) r3
        L_0x00ce:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r5.writeNoException()
            goto L_0x00e6
        L_0x00d5:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbws> r3 = com.google.android.gms.internal.ads.zzbws.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbws r3 = (com.google.android.gms.internal.ads.zzbws) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zze(r5, r0)
        L_0x00e6:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxc.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
