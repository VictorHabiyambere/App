package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzefc implements zzgfp {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzefd zzb;

    zzefc(zzefd zzefd, boolean z) {
        this.zza = z;
        this.zzb = zzefd;
    }

    public final void zza(Throwable th) {
        zzm.zzg("Failed to get signals bundle");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzefd r0 = r7.zzb
            android.os.Bundle r8 = (android.os.Bundle) r8
            boolean r0 = r0.zzf()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r0 = "ad_types"
            java.lang.Object r0 = r8.get(r0)
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L_0x0018
            java.util.List r0 = (java.util.List) r0
            goto L_0x0022
        L_0x0018:
            boolean r1 = r0 instanceof java.lang.String[]
            if (r1 == 0) goto L_0x0048
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.util.List r0 = java.util.Arrays.asList(r0)
        L_0x0022:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r0.next()
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x002f
            java.lang.String r2 = (java.lang.String) r2
            r1.add(r2)
            goto L_0x002f
        L_0x0043:
            java.util.List r0 = java.util.Collections.unmodifiableList(r1)
            goto L_0x004c
        L_0x0048:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x004c:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0055:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.hashCode()
            switch(r2) {
                case -1396342996: goto L_0x0088;
                case -1052618729: goto L_0x007e;
                case -239580146: goto L_0x0074;
                case 604727084: goto L_0x0069;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x0092
        L_0x0069:
            java.lang.String r2 = "interstitial"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0068
            r1 = 1
            goto L_0x0093
        L_0x0074:
            java.lang.String r2 = "rewarded"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0068
            r1 = 3
            goto L_0x0093
        L_0x007e:
            java.lang.String r2 = "native"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0068
            r1 = 2
            goto L_0x0093
        L_0x0088:
            java.lang.String r2 = "banner"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0068
            r1 = 0
            goto L_0x0093
        L_0x0092:
            r1 = -1
        L_0x0093:
            switch(r1) {
                case 0: goto L_0x00a2;
                case 1: goto L_0x009f;
                case 2: goto L_0x009c;
                case 3: goto L_0x0099;
                default: goto L_0x0096;
            }
        L_0x0096:
            com.google.android.gms.internal.ads.zzbdv$zzd$zza r1 = com.google.android.gms.internal.ads.zzbdv.zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x00a4
        L_0x0099:
            com.google.android.gms.internal.ads.zzbdv$zzd$zza r1 = com.google.android.gms.internal.ads.zzbdv.zzd.zza.REWARD_BASED_VIDEO_AD
            goto L_0x00a4
        L_0x009c:
            com.google.android.gms.internal.ads.zzbdv$zzd$zza r1 = com.google.android.gms.internal.ads.zzbdv.zzd.zza.NATIVE_APP_INSTALL
            goto L_0x00a4
        L_0x009f:
            com.google.android.gms.internal.ads.zzbdv$zzd$zza r1 = com.google.android.gms.internal.ads.zzbdv.zzd.zza.INTERSTITIAL
            goto L_0x00a4
        L_0x00a2:
            com.google.android.gms.internal.ads.zzbdv$zzd$zza r1 = com.google.android.gms.internal.ads.zzbdv.zzd.zza.BANNER
        L_0x00a4:
            r4.add(r1)
            goto L_0x0055
        L_0x00a8:
            com.google.android.gms.internal.ads.zzefd r0 = r7.zzb
            com.google.android.gms.internal.ads.zzbdv$zzaf$zzd r6 = com.google.android.gms.internal.ads.zzefd.zzb(r0, r8)
            com.google.android.gms.internal.ads.zzefd r0 = r7.zzb
            com.google.android.gms.internal.ads.zzbdv$zzab r5 = com.google.android.gms.internal.ads.zzefd.zza(r0, r8)
            com.google.android.gms.internal.ads.zzefd r8 = r7.zzb
            boolean r3 = r7.zza
            com.google.android.gms.internal.ads.zzefb r0 = new com.google.android.gms.internal.ads.zzefb
            r1 = r0
            r2 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            com.google.android.gms.internal.ads.zzeer r8 = r8.zza
            r8.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefc.zzb(java.lang.Object):void");
    }
}
