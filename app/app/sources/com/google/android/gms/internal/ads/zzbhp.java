package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbhp extends NativeAd.AdChoicesInfo {
    private final zzbho zza;
    private final List zzb = new ArrayList();
    private String zzc;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbhp(com.google.android.gms.internal.ads.zzbho r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.zzb = r1
            r4.zza = r5
            com.google.android.gms.internal.ads.zzbho r1 = r4.zza     // Catch:{ RemoteException -> 0x0017 }
            java.lang.String r1 = r1.zzg()     // Catch:{ RemoteException -> 0x0017 }
            r4.zzc = r1     // Catch:{ RemoteException -> 0x0017 }
            goto L_0x001d
        L_0x0017:
            r1 = move-exception
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r1)
            r4.zzc = r0
        L_0x001d:
            java.util.List r5 = r5.zzh()     // Catch:{ RemoteException -> 0x005b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ RemoteException -> 0x005b }
        L_0x0025:
            boolean r1 = r5.hasNext()     // Catch:{ RemoteException -> 0x005b }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r5.next()     // Catch:{ RemoteException -> 0x005b }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005b }
            r3 = 0
            if (r2 == 0) goto L_0x004c
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x005b }
            if (r1 != 0) goto L_0x0039
            goto L_0x004d
        L_0x0039:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x005b }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzbhv     // Catch:{ RemoteException -> 0x005b }
            if (r3 == 0) goto L_0x0047
            r3 = r2
            com.google.android.gms.internal.ads.zzbhv r3 = (com.google.android.gms.internal.ads.zzbhv) r3     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004c
        L_0x0047:
            com.google.android.gms.internal.ads.zzbht r3 = new com.google.android.gms.internal.ads.zzbht     // Catch:{ RemoteException -> 0x005b }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x005b }
        L_0x004c:
        L_0x004d:
            if (r3 == 0) goto L_0x0025
            java.util.List r1 = r4.zzb     // Catch:{ RemoteException -> 0x005b }
            com.google.android.gms.internal.ads.zzbhw r2 = new com.google.android.gms.internal.ads.zzbhw     // Catch:{ RemoteException -> 0x005b }
            r2.<init>(r3)     // Catch:{ RemoteException -> 0x005b }
            r1.add(r2)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x0025
        L_0x005a:
            return
        L_0x005b:
            r5 = move-exception
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhp.<init>(com.google.android.gms.internal.ads.zzbho):void");
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final CharSequence getText() {
        return this.zzc;
    }
}
