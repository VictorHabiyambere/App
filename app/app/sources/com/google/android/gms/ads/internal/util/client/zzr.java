package com.google.android.gms.ads.internal.util.client;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzr implements zze {
    private final String zza;

    public zzr() {
        throw null;
    }

    public zzr(String str) {
        this.zza = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e3, code lost:
        if (com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide() != false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
        return r1;
     */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x00c1=Splitter:B:34:0x00c1, B:29:0x009b=Splitter:B:29:0x009b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ". "
            r1 = 0
            boolean r2 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            if (r2 == 0) goto L_0x000e
            r2 = 263(0x107, float:3.69E-43)
            android.net.TrafficStats.setThreadStatsTag(r2)     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            java.lang.String r3 = "Pinging URL: "
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            r2.append(r7)     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r2)     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            java.net.URL r2 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            r2.<init>(r7)     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r6.zza     // Catch:{ all -> 0x0091 }
            r4 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r4)     // Catch:{ all -> 0x0091 }
            r5 = 1
            r2.setInstanceFollowRedirects(r5)     // Catch:{ all -> 0x0091 }
            r2.setReadTimeout(r4)     // Catch:{ all -> 0x0091 }
            if (r3 == 0) goto L_0x0046
            java.lang.String r4 = "User-Agent"
            r2.setRequestProperty(r4, r3)     // Catch:{ all -> 0x0091 }
        L_0x0046:
            r2.setUseCaches(r1)     // Catch:{ all -> 0x0091 }
            com.google.android.gms.ads.internal.util.client.zzl r3 = new com.google.android.gms.ads.internal.util.client.zzl     // Catch:{ all -> 0x0091 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0091 }
            r3.zzc(r2, r4)     // Catch:{ all -> 0x0091 }
            int r4 = r2.getResponseCode()     // Catch:{ all -> 0x0091 }
            r3.zze(r2, r4)     // Catch:{ all -> 0x0091 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r4 < r3) goto L_0x0065
            r3 = 300(0x12c, float:4.2E-43)
            if (r4 < r3) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r1 = r5
            goto L_0x0081
        L_0x0065:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r3.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = "Received non-success response code "
            r3.append(r5)     // Catch:{ all -> 0x0091 }
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = " from pinging URL: "
            r3.append(r4)     // Catch:{ all -> 0x0091 }
            r3.append(r7)     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0091 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)     // Catch:{ all -> 0x0091 }
        L_0x0081:
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x008f, IOException -> 0x008d, RuntimeException -> 0x008b }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 == 0) goto L_0x00ea
            goto L_0x00e5
        L_0x008b:
            r2 = move-exception
            goto L_0x009b
        L_0x008d:
            r2 = move-exception
            goto L_0x009b
        L_0x008f:
            r2 = move-exception
            goto L_0x00c1
        L_0x0091:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x00c0, IOException -> 0x009a, RuntimeException -> 0x0098 }
        L_0x0096:
            r7 = move-exception
            goto L_0x00eb
        L_0x0098:
            r2 = move-exception
            goto L_0x009b
        L_0x009a:
            r2 = move-exception
        L_0x009b:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r3.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "Error while pinging URL: "
            r3.append(r4)     // Catch:{ all -> 0x0096 }
            r3.append(r7)     // Catch:{ all -> 0x0096 }
            r3.append(r0)     // Catch:{ all -> 0x0096 }
            r3.append(r2)     // Catch:{ all -> 0x0096 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r7)     // Catch:{ all -> 0x0096 }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 == 0) goto L_0x00e9
            goto L_0x00e5
        L_0x00c0:
            r2 = move-exception
        L_0x00c1:
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r3.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "Error while parsing ping URL: "
            r3.append(r4)     // Catch:{ all -> 0x0096 }
            r3.append(r7)     // Catch:{ all -> 0x0096 }
            r3.append(r0)     // Catch:{ all -> 0x0096 }
            r3.append(r2)     // Catch:{ all -> 0x0096 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r7)     // Catch:{ all -> 0x0096 }
            boolean r7 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r7 == 0) goto L_0x00e9
        L_0x00e5:
            android.net.TrafficStats.clearThreadStatsTag()
            return r1
        L_0x00e9:
        L_0x00ea:
            return r1
        L_0x00eb:
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x00f4
            android.net.TrafficStats.clearThreadStatsTag()
        L_0x00f4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzr.zza(java.lang.String):boolean");
    }
}
