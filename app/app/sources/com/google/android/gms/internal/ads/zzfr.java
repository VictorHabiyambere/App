package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzfr extends BroadcastReceiver {
    final /* synthetic */ zzfs zza;

    /* synthetic */ zzfr(zzfs zzfs, zzfq zzfq) {
        this.zza = zzfs;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            java.lang.String r6 = "connectivity"
            java.lang.Object r6 = r5.getSystemService(r6)
            android.net.ConnectivityManager r6 = (android.net.ConnectivityManager) r6
            r0 = 0
            r1 = 5
            if (r6 != 0) goto L_0x000d
            goto L_0x0048
        L_0x000d:
            android.net.NetworkInfo r6 = r6.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x0047 }
            r2 = 1
            if (r6 == 0) goto L_0x0045
            boolean r3 = r6.isConnected()
            if (r3 != 0) goto L_0x001c
            r0 = r2
            goto L_0x0048
        L_0x001c:
            int r2 = r6.getType()
            r3 = 2
            switch(r2) {
                case 0: goto L_0x002d;
                case 1: goto L_0x002b;
                case 2: goto L_0x0024;
                case 3: goto L_0x0024;
                case 4: goto L_0x002d;
                case 5: goto L_0x002d;
                case 6: goto L_0x0029;
                case 7: goto L_0x0024;
                case 8: goto L_0x0024;
                case 9: goto L_0x0027;
                default: goto L_0x0024;
            }
        L_0x0024:
            r0 = 8
            goto L_0x0048
        L_0x0027:
            r0 = 7
            goto L_0x0048
        L_0x0029:
            r0 = r1
            goto L_0x0048
        L_0x002b:
            r0 = r3
            goto L_0x0048
        L_0x002d:
            int r6 = r6.getSubtype()
            switch(r6) {
                case 1: goto L_0x0043;
                case 2: goto L_0x0043;
                case 3: goto L_0x0041;
                case 4: goto L_0x0041;
                case 5: goto L_0x0041;
                case 6: goto L_0x0041;
                case 7: goto L_0x0041;
                case 8: goto L_0x0041;
                case 9: goto L_0x0041;
                case 10: goto L_0x0041;
                case 11: goto L_0x0041;
                case 12: goto L_0x0041;
                case 13: goto L_0x0029;
                case 14: goto L_0x0041;
                case 15: goto L_0x0041;
                case 16: goto L_0x0034;
                case 17: goto L_0x0041;
                case 18: goto L_0x003f;
                case 19: goto L_0x0034;
                case 20: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            r0 = 6
            goto L_0x0048
        L_0x0036:
            int r6 = com.google.android.gms.internal.ads.zzgd.zza
            r2 = 29
            if (r6 < r2) goto L_0x0048
            r0 = 9
            goto L_0x0048
        L_0x003f:
            r0 = r3
            goto L_0x0048
        L_0x0041:
            r0 = 4
            goto L_0x0048
        L_0x0043:
            r0 = 3
            goto L_0x0048
        L_0x0045:
            r0 = r2
            goto L_0x0048
        L_0x0047:
            r6 = move-exception
        L_0x0048:
            int r6 = com.google.android.gms.internal.ads.zzgd.zza
            r2 = 31
            if (r6 < r2) goto L_0x0074
            if (r0 != r1) goto L_0x0074
            com.google.android.gms.internal.ads.zzfs r6 = r4.zza
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r5.getSystemService(r0)     // Catch:{ RuntimeException -> 0x006f }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ RuntimeException -> 0x006f }
            if (r0 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzfp r2 = new com.google.android.gms.internal.ads.zzfp     // Catch:{ RuntimeException -> 0x006f }
            r2.<init>(r6)     // Catch:{ RuntimeException -> 0x006f }
            java.util.concurrent.Executor r5 = r5.getMainExecutor()     // Catch:{ RuntimeException -> 0x006f }
            r0.registerTelephonyCallback(r5, r2)     // Catch:{ RuntimeException -> 0x006f }
            r0.unregisterTelephonyCallback(r2)     // Catch:{ RuntimeException -> 0x006f }
            return
        L_0x006c:
            r5 = 0
            throw r5     // Catch:{ RuntimeException -> 0x006f }
        L_0x006f:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzfs.zzc(r6, r1)
            return
        L_0x0074:
            com.google.android.gms.internal.ads.zzfs r5 = r4.zza
            com.google.android.gms.internal.ads.zzfs.zzc(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfr.onReceive(android.content.Context, android.content.Intent):void");
    }
}
