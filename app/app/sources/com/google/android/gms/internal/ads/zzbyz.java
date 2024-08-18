package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbyz extends zzbae implements zzbza {
    public zzbyz() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbza zzq(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return queryLocalInterface instanceof zzbza ? (zzbza) queryLocalInterface : new zzbyy(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzbzi} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzbzh] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzbzd] */
    /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.internal.ads.zzbzh] */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* JADX WARNING: type inference failed for: r0v27 */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            r0 = 0
            switch(r3) {
                case 1: goto L_0x012c;
                case 2: goto L_0x0107;
                case 3: goto L_0x00fa;
                case 4: goto L_0x00ef;
                case 5: goto L_0x00dd;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00a4;
                case 8: goto L_0x0091;
                case 9: goto L_0x0085;
                case 10: goto L_0x006e;
                case 11: goto L_0x0062;
                case 12: goto L_0x0056;
                case 13: goto L_0x0043;
                case 14: goto L_0x0017;
                case 15: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r3 = 0
            return r3
        L_0x0008:
            boolean r3 = com.google.android.gms.internal.ads.zzbaf.zzg(r4)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzh(r3)
            r5.writeNoException()
            goto L_0x0156
        L_0x0017:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x0026
            goto L_0x0038
        L_0x0026:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbzh
            if (r0 == 0) goto L_0x0033
            r0 = r6
            com.google.android.gms.internal.ads.zzbzh r0 = (com.google.android.gms.internal.ads.zzbzh) r0
            goto L_0x0038
        L_0x0033:
            com.google.android.gms.internal.ads.zzbzf r0 = new com.google.android.gms.internal.ads.zzbzf
            r0.<init>(r1)
        L_0x0038:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzg(r3, r0)
            r5.writeNoException()
            goto L_0x0156
        L_0x0043:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdg r3 = com.google.android.gms.ads.internal.client.zzdf.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzj(r3)
            r5.writeNoException()
            goto L_0x0156
        L_0x0056:
            com.google.android.gms.ads.internal.client.zzdn r3 = r2.zzc()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0156
        L_0x0062:
            com.google.android.gms.internal.ads.zzbyx r3 = r2.zzd()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0156
        L_0x006e:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r6 = com.google.android.gms.internal.ads.zzbaf.zzg(r4)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzn(r3, r6)
            r5.writeNoException()
            goto L_0x0156
        L_0x0085:
            android.os.Bundle r3 = r2.zzb()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zze(r5, r3)
            goto L_0x0156
        L_0x0091:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.ads.internal.client.zzdd r3 = com.google.android.gms.ads.internal.client.zzdc.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzi(r3)
            r5.writeNoException()
            goto L_0x0156
        L_0x00a4:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbzo> r3 = com.google.android.gms.internal.ads.zzbzo.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.internal.ads.zzbzo r3 = (com.google.android.gms.internal.ads.zzbzo) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzl(r3)
            r5.writeNoException()
            goto L_0x0156
        L_0x00b7:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00be
            goto L_0x00d2
        L_0x00be:
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbzi
            if (r0 == 0) goto L_0x00cd
            r0 = r6
            com.google.android.gms.internal.ads.zzbzi r0 = (com.google.android.gms.internal.ads.zzbzi) r0
            goto L_0x00d2
        L_0x00cd:
            com.google.android.gms.internal.ads.zzbzi r0 = new com.google.android.gms.internal.ads.zzbzi
            r0.<init>(r3)
        L_0x00d2:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzp(r0)
            r5.writeNoException()
            goto L_0x0156
        L_0x00dd:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzm(r3)
            r5.writeNoException()
            goto L_0x0156
        L_0x00ef:
            java.lang.String r3 = r2.zze()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0156
        L_0x00fa:
            boolean r3 = r2.zzo()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzbaf.zza
            r5.writeInt(r3)
            goto L_0x0156
        L_0x0107:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x010e
            goto L_0x0122
        L_0x010e:
            java.lang.String r6 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbzd
            if (r0 == 0) goto L_0x011d
            r0 = r6
            com.google.android.gms.internal.ads.zzbzd r0 = (com.google.android.gms.internal.ads.zzbzd) r0
            goto L_0x0122
        L_0x011d:
            com.google.android.gms.internal.ads.zzbzb r0 = new com.google.android.gms.internal.ads.zzbzb
            r0.<init>(r3)
        L_0x0122:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzk(r0)
            r5.writeNoException()
            goto L_0x0156
        L_0x012c:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            android.os.IBinder r1 = r4.readStrongBinder()
            if (r1 != 0) goto L_0x013b
            goto L_0x014d
        L_0x013b:
            android.os.IInterface r6 = r1.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.ads.zzbzh
            if (r0 == 0) goto L_0x0148
            r0 = r6
            com.google.android.gms.internal.ads.zzbzh r0 = (com.google.android.gms.internal.ads.zzbzh) r0
            goto L_0x014d
        L_0x0148:
            com.google.android.gms.internal.ads.zzbzf r0 = new com.google.android.gms.internal.ads.zzbzf
            r0.<init>(r1)
        L_0x014d:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzf(r3, r0)
            r5.writeNoException()
        L_0x0156:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyz.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
