package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbci extends zzbae implements zzbcj {
    public zzbci() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public static zzbcj zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
        return queryLocalInterface instanceof zzbcj ? (zzbcj) queryLocalInterface : new zzbch(iBinder);
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
                case 1: goto L_0x001b;
                case 2: goto L_0x0014;
                case 3: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zze> r2 = com.google.android.gms.ads.internal.client.zze.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzbaf.zza(r3, r2)
            com.google.android.gms.ads.internal.client.zze r2 = (com.google.android.gms.ads.internal.client.zze) r2
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzc(r2)
            goto L_0x003e
        L_0x0014:
            r3.readInt()
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            goto L_0x003e
        L_0x001b:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0023
            r2 = 0
            goto L_0x0038
        L_0x0023:
            java.lang.String r5 = "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd"
            android.os.IInterface r5 = r2.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzbcg
            if (r0 == 0) goto L_0x0032
            r2 = r5
            com.google.android.gms.internal.ads.zzbcg r2 = (com.google.android.gms.internal.ads.zzbcg) r2
            goto L_0x0038
        L_0x0032:
            com.google.android.gms.internal.ads.zzbce r5 = new com.google.android.gms.internal.ads.zzbce
            r5.<init>(r2)
            r2 = r5
        L_0x0038:
            com.google.android.gms.internal.ads.zzbaf.zzc(r3)
            r1.zzd(r2)
        L_0x003e:
            r4.writeNoException()
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbci.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
