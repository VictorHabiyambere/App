package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzao {
    private final String zza;

    /* synthetic */ zzao(zzam zzam, zzan zzan) {
        this.zza = zzam.zza;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbdv.zza.C0000zza zza() {
        /*
            r2 = this;
            java.lang.String r0 = r2.zza
            int r1 = r0.hashCode()
            switch(r1) {
                case -1999289321: goto L_0x0029;
                case -1372958932: goto L_0x001f;
                case 543046670: goto L_0x0015;
                case 1951953708: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0033
        L_0x000a:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x0034
        L_0x0015:
            java.lang.String r1 = "REWARDED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x0034
        L_0x001f:
            java.lang.String r1 = "INTERSTITIAL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x0034
        L_0x0029:
            java.lang.String r1 = "NATIVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            switch(r0) {
                case 0: goto L_0x0043;
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                default: goto L_0x0037;
            }
        L_0x0037:
            com.google.android.gms.internal.ads.zzbdv$zza$zza r0 = com.google.android.gms.internal.ads.zzbdv.zza.C0000zza.AD_INITIATER_UNSPECIFIED
            return r0
        L_0x003a:
            com.google.android.gms.internal.ads.zzbdv$zza$zza r0 = com.google.android.gms.internal.ads.zzbdv.zza.C0000zza.REWARD_BASED_VIDEO_AD
            return r0
        L_0x003d:
            com.google.android.gms.internal.ads.zzbdv$zza$zza r0 = com.google.android.gms.internal.ads.zzbdv.zza.C0000zza.AD_LOADER
            return r0
        L_0x0040:
            com.google.android.gms.internal.ads.zzbdv$zza$zza r0 = com.google.android.gms.internal.ads.zzbdv.zza.C0000zza.INTERSTITIAL
            return r0
        L_0x0043:
            com.google.android.gms.internal.ads.zzbdv$zza$zza r0 = com.google.android.gms.internal.ads.zzbdv.zza.C0000zza.BANNER
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzao.zza():com.google.android.gms.internal.ads.zzbdv$zza$zza");
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    public final Set zzc() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
