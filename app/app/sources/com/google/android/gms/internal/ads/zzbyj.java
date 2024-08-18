package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbyj extends zzbae implements zzbyk {
    public zzbyj() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.google.android.gms.internal.ads.zzbyi} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzbyn] */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x0140;
                case 2: goto L_0x0139;
                case 3: goto L_0x0115;
                case 4: goto L_0x0004;
                case 5: goto L_0x0108;
                case 6: goto L_0x0101;
                case 7: goto L_0x00fa;
                case 8: goto L_0x00f3;
                case 9: goto L_0x00e1;
                case 10: goto L_0x00ce;
                case 11: goto L_0x00bb;
                case 12: goto L_0x00af;
                case 13: goto L_0x00a0;
                case 14: goto L_0x008d;
                case 15: goto L_0x0081;
                case 16: goto L_0x005c;
                case 17: goto L_0x0051;
                case 18: goto L_0x003e;
                case 19: goto L_0x002f;
                case 20: goto L_0x0021;
                case 21: goto L_0x0015;
                case 22: goto L_0x0004;
                case 23: goto L_0x0004;
                case 24: goto L_0x0004;
                case 25: goto L_0x0004;
                case 26: goto L_0x0004;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0004;
                case 30: goto L_0x0004;
                case 31: goto L_0x0004;
                case 32: goto L_0x0004;
                case 33: goto L_0x0004;
                case 34: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            boolean r2 = com.google.android.gms.internal.ads.zzbaf.zzg(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzn(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x0015:
            com.google.android.gms.ads.internal.client.zzdn r2 = r1.zzc()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r4, r2)
            goto L_0x0151
        L_0x0021:
            boolean r2 = r1.zzt()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x0151
        L_0x002f:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzm(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x003e:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzr(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x0051:
            r3.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r4.writeNoException()
            goto L_0x0151
        L_0x005c:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0063
            goto L_0x0076
        L_0x0063:
            java.lang.String r5 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbyi
            if (r0 == 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzbyi r5 = (com.google.android.gms.internal.ads.zzbyi) r5
            goto L_0x0076
        L_0x0071:
            com.google.android.gms.internal.ads.zzbyi r5 = new com.google.android.gms.internal.ads.zzbyi
            r5.<init>(r2)
        L_0x0076:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzu(r5)
            r4.writeNoException()
            goto L_0x0151
        L_0x0081:
            android.os.Bundle r2 = r1.zzb()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zze(r4, r2)
            goto L_0x0151
        L_0x008d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzby r2 = com.google.android.gms.ads.internal.client.zzbx.zzb(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzl(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x00a0:
            java.lang.String r2 = r3.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzp(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x00af:
            java.lang.String r2 = r1.zzd()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x0151
        L_0x00bb:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzf(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x00ce:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzk(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x00e1:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzi(r2)
            r4.writeNoException()
            goto L_0x0151
        L_0x00f3:
            r1.zze()
            r4.writeNoException()
            goto L_0x0151
        L_0x00fa:
            r1.zzj()
            r4.writeNoException()
            goto L_0x0151
        L_0x0101:
            r1.zzh()
            r4.writeNoException()
            goto L_0x0151
        L_0x0108:
            boolean r2 = r1.zzs()
            r4.writeNoException()
            int r3 = com.google.android.gms.internal.ads.zzbaf.zza
            r4.writeInt(r2)
            goto L_0x0151
        L_0x0115:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x011c
            goto L_0x012f
        L_0x011c:
            java.lang.String r5 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbyn
            if (r0 == 0) goto L_0x012a
            com.google.android.gms.internal.ads.zzbyn r5 = (com.google.android.gms.internal.ads.zzbyn) r5
            goto L_0x012f
        L_0x012a:
            com.google.android.gms.internal.ads.zzbyl r5 = new com.google.android.gms.internal.ads.zzbyl
            r5.<init>(r2)
        L_0x012f:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzo(r5)
            r4.writeNoException()
            goto L_0x0151
        L_0x0139:
            r1.zzq()
            r4.writeNoException()
            goto L_0x0151
        L_0x0140:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbyo> r2 = com.google.android.gms.internal.ads.zzbyo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzbaf.zza(r3, r2)
            com.google.android.gms.internal.ads.zzbyo r2 = (com.google.android.gms.internal.ads.zzbyo) r2
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzg(r2)
            r4.writeNoException()
        L_0x0151:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyj.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
