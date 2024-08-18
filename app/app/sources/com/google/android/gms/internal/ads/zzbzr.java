package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbzr extends zzbyw {
    private final String zza;
    private final int zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbzr(com.google.android.gms.ads.rewarded.RewardItem r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0007
            java.lang.String r0 = r2.getType()
            goto L_0x0009
        L_0x0007:
            java.lang.String r0 = ""
        L_0x0009:
            if (r2 == 0) goto L_0x0010
            int r2 = r2.getAmount()
            goto L_0x0011
        L_0x0010:
            r2 = 1
        L_0x0011:
            r1.<init>(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzr.<init>(com.google.android.gms.ads.rewarded.RewardItem):void");
    }

    public final int zze() throws RemoteException {
        return this.zzb;
    }

    public final String zzf() throws RemoteException {
        return this.zza;
    }

    public zzbzr(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
