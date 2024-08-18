package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeee implements zzfkw {
    protected final Context zza;
    protected final String zzb;
    protected final zzbyd zzc;

    public zzeee(Context context, String str, zzbyd zzbyd, int i) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbyd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2 = new java.io.InputStreamReader(r7.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        com.google.android.gms.ads.internal.zzu.zzp();
        r0 = com.google.android.gms.ads.internal.util.zzt.zzN(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2);
        r4.zzg(r0);
        r5.zzc = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0144, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0156, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzfB)).booleanValue() == false) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015f, code lost:
        throw new com.google.android.gms.internal.ads.zzdzd(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0160, code lost:
        r5.zzd = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0224 A[SYNTHETIC, Splitter:B:101:0x0224] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0215 A[Catch:{ all -> 0x0225 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:98:0x0220=Splitter:B:98:0x0220, B:104:0x0226=Splitter:B:104:0x0226} */
    /* renamed from: zzb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzeed zza(com.google.android.gms.internal.ads.zzeec r20) throws com.google.android.gms.internal.ads.zzdzd {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.String r3 = r0.zza
            int r11 = r0.zzb
            java.util.Map r12 = r0.zzc
            byte[] r13 = r0.zzd
            java.lang.String r0 = r0.zze
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzu.zzB()
            long r14 = r4.elapsedRealtime()
            r10 = 1
            com.google.android.gms.internal.ads.zzeed r9 = new com.google.android.gms.internal.ads.zzeed     // Catch:{ IOException -> 0x022c }
            r9.<init>()     // Catch:{ IOException -> 0x022c }
            java.lang.String r4 = r1.zzb     // Catch:{ IOException -> 0x022c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
            r5.<init>()     // Catch:{ IOException -> 0x022c }
            java.lang.String r6 = "SDK version: "
            r5.append(r6)     // Catch:{ IOException -> 0x022c }
            r5.append(r4)     // Catch:{ IOException -> 0x022c }
            java.lang.String r4 = r5.toString()     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r4)     // Catch:{ IOException -> 0x022c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x022c }
            r4.<init>()     // Catch:{ IOException -> 0x022c }
            java.lang.String r5 = "AdRequestServiceImpl: Sending request: "
            r4.append(r5)     // Catch:{ IOException -> 0x022c }
            r4.append(r3)     // Catch:{ IOException -> 0x022c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r4)     // Catch:{ IOException -> 0x022c }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x022c }
            r4.<init>(r3)     // Catch:{ IOException -> 0x022c }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x022c }
            r3.<init>()     // Catch:{ IOException -> 0x022c }
            r5 = 0
            r16 = r5
        L_0x0055:
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x022c }
            r8 = r4
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x022c }
            com.google.android.gms.ads.internal.util.zzt r4 = com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ zzdzd -> 0x01ff, all -> 0x01fb }
            android.content.Context r5 = r1.zza     // Catch:{ zzdzd -> 0x01ff, all -> 0x01fb }
            java.lang.String r6 = r1.zzb     // Catch:{ zzdzd -> 0x01ff, all -> 0x01fb }
            r7 = 0
            r17 = 0
            r20 = r8
            r18 = r9
            r9 = r17
            r1 = r10
            r10 = r11
            r4.zzf(r5, r6, r7, r8, r9, r10)     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.util.Set r4 = r12.entrySet()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
        L_0x007a:
            boolean r5 = r4.hasNext()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            if (r5 == 0) goto L_0x009a
            java.lang.Object r5 = r4.next()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ zzdzd -> 0x01f5, all -> 0x01f1 }
            r7 = r20
            r7.addRequestProperty(r6, r5)     // Catch:{ zzdzd -> 0x01ef }
            r20 = r7
            goto L_0x007a
        L_0x009a:
            r7 = r20
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzdzd -> 0x01ef }
            if (r4 != 0) goto L_0x00a7
            java.lang.String r4 = "Content-Type"
            r7.setRequestProperty(r4, r0)     // Catch:{ zzdzd -> 0x01ef }
        L_0x00a7:
            int r4 = r13.length     // Catch:{ zzdzd -> 0x01ef }
            r5 = 0
            if (r4 <= 0) goto L_0x00c9
            r7.setDoOutput(r1)     // Catch:{ zzdzd -> 0x01ef }
            r7.setFixedLengthStreamingMode(r4)     // Catch:{ zzdzd -> 0x01ef }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00c4 }
            java.io.OutputStream r6 = r7.getOutputStream()     // Catch:{ all -> 0x00c4 }
            r4.<init>(r6)     // Catch:{ all -> 0x00c4 }
            r4.write(r13)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)     // Catch:{ zzdzd -> 0x01ef }
            goto L_0x00c9
        L_0x00c1:
            r0 = move-exception
            r5 = r4
            goto L_0x00c5
        L_0x00c4:
            r0 = move-exception
        L_0x00c5:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r5)     // Catch:{ zzdzd -> 0x01ef }
            throw r0     // Catch:{ zzdzd -> 0x01ef }
        L_0x00c9:
            com.google.android.gms.ads.internal.util.client.zzl r4 = new com.google.android.gms.ads.internal.util.client.zzl     // Catch:{ zzdzd -> 0x01ef }
            r4.<init>(r5)     // Catch:{ zzdzd -> 0x01ef }
            r4.zzc(r7, r13)     // Catch:{ zzdzd -> 0x01ef }
            int r6 = r7.getResponseCode()     // Catch:{ zzdzd -> 0x01ef }
            java.util.Map r8 = r7.getHeaderFields()     // Catch:{ zzdzd -> 0x01ef }
            java.util.Set r8 = r8.entrySet()     // Catch:{ zzdzd -> 0x01ef }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ zzdzd -> 0x01ef }
        L_0x00e1:
            boolean r9 = r8.hasNext()     // Catch:{ zzdzd -> 0x01ef }
            if (r9 == 0) goto L_0x0113
            java.lang.Object r9 = r8.next()     // Catch:{ zzdzd -> 0x01ef }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ zzdzd -> 0x01ef }
            java.lang.Object r10 = r9.getKey()     // Catch:{ zzdzd -> 0x01ef }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ zzdzd -> 0x01ef }
            java.lang.Object r9 = r9.getValue()     // Catch:{ zzdzd -> 0x01ef }
            java.util.List r9 = (java.util.List) r9     // Catch:{ zzdzd -> 0x01ef }
            boolean r17 = r3.containsKey(r10)     // Catch:{ zzdzd -> 0x01ef }
            if (r17 == 0) goto L_0x0109
            java.lang.Object r10 = r3.get(r10)     // Catch:{ zzdzd -> 0x01ef }
            java.util.List r10 = (java.util.List) r10     // Catch:{ zzdzd -> 0x01ef }
            r10.addAll(r9)     // Catch:{ zzdzd -> 0x01ef }
            goto L_0x00e1
        L_0x0109:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ zzdzd -> 0x01ef }
            r5.<init>(r9)     // Catch:{ zzdzd -> 0x01ef }
            r3.put(r10, r5)     // Catch:{ zzdzd -> 0x01ef }
            r5 = 0
            goto L_0x00e1
        L_0x0113:
            r4.zze(r7, r6)     // Catch:{ zzdzd -> 0x01ef }
            r5 = r18
            r5.zza = r6     // Catch:{ zzdzd -> 0x01ed }
            r5.zzb = r3     // Catch:{ zzdzd -> 0x01ed }
            java.lang.String r8 = ""
            r5.zzc = r8     // Catch:{ zzdzd -> 0x01ed }
            r8 = 200(0xc8, float:2.8E-43)
            r9 = 300(0x12c, float:4.2E-43)
            if (r6 < r8) goto L_0x0175
            if (r6 >= r9) goto L_0x0175
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x016f }
            java.io.InputStream r0 = r7.getInputStream()     // Catch:{ all -> 0x016f }
            r2.<init>(r0)     // Catch:{ all -> 0x016f }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x016d }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzt.zzN(r2)     // Catch:{ all -> 0x016d }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzdzd -> 0x01ed }
            r4.zzg(r0)     // Catch:{ zzdzd -> 0x01ed }
            r5.zzc = r0     // Catch:{ zzdzd -> 0x01ed }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ zzdzd -> 0x01ed }
            if (r0 == 0) goto L_0x0160
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzfB     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzdzd -> 0x01ed }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ zzdzd -> 0x01ed }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ zzdzd -> 0x01ed }
            boolean r0 = r0.booleanValue()     // Catch:{ zzdzd -> 0x01ed }
            if (r0 == 0) goto L_0x0159
            goto L_0x0160
        L_0x0159:
            com.google.android.gms.internal.ads.zzdzd r0 = new com.google.android.gms.internal.ads.zzdzd     // Catch:{ zzdzd -> 0x01ed }
            r2 = 3
            r0.<init>(r2)     // Catch:{ zzdzd -> 0x01ed }
            throw r0     // Catch:{ zzdzd -> 0x01ed }
        L_0x0160:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ zzdzd -> 0x01ed }
            long r2 = r0.elapsedRealtime()     // Catch:{ zzdzd -> 0x01ed }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ zzdzd -> 0x01ed }
            goto L_0x0220
        L_0x016d:
            r0 = move-exception
            goto L_0x0171
        L_0x016f:
            r0 = move-exception
            r2 = 0
        L_0x0171:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)     // Catch:{ zzdzd -> 0x01ed }
            throw r0     // Catch:{ zzdzd -> 0x01ed }
        L_0x0175:
            if (r6 < r9) goto L_0x01c6
            r4 = 400(0x190, float:5.6E-43)
            if (r6 >= r4) goto L_0x01c6
            java.lang.String r4 = "Location"
            java.lang.String r4 = r7.getHeaderField(r4)     // Catch:{ zzdzd -> 0x01ed }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ zzdzd -> 0x01ed }
            if (r6 != 0) goto L_0x01b9
            java.net.URL r6 = new java.net.URL     // Catch:{ zzdzd -> 0x01ed }
            r6.<init>(r4)     // Catch:{ zzdzd -> 0x01ed }
            int r4 = r16 + 1
            com.google.android.gms.internal.ads.zzbeg r8 = com.google.android.gms.internal.ads.zzbep.zzeY     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.internal.ads.zzben r9 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzdzd -> 0x01ed }
            java.lang.Object r8 = r9.zza(r8)     // Catch:{ zzdzd -> 0x01ed }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ zzdzd -> 0x01ed }
            int r8 = r8.intValue()     // Catch:{ zzdzd -> 0x01ed }
            if (r4 > r8) goto L_0x01ac
            r7.disconnect()     // Catch:{ IOException -> 0x022a }
            r10 = r1
            r16 = r4
            r9 = r5
            r4 = r6
            r1 = r19
            goto L_0x0055
        L_0x01ac:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.internal.ads.zzdzd r0 = new com.google.android.gms.internal.ads.zzdzd     // Catch:{ zzdzd -> 0x01ed }
            java.lang.String r2 = "Too many redirects"
            r0.<init>(r1, r2)     // Catch:{ zzdzd -> 0x01ed }
            throw r0     // Catch:{ zzdzd -> 0x01ed }
        L_0x01b9:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.internal.ads.zzdzd r0 = new com.google.android.gms.internal.ads.zzdzd     // Catch:{ zzdzd -> 0x01ed }
            java.lang.String r2 = "No location header to follow redirect"
            r0.<init>(r1, r2)     // Catch:{ zzdzd -> 0x01ed }
            throw r0     // Catch:{ zzdzd -> 0x01ed }
        L_0x01c6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ zzdzd -> 0x01ed }
            r0.<init>()     // Catch:{ zzdzd -> 0x01ed }
            r0.append(r2)     // Catch:{ zzdzd -> 0x01ed }
            r0.append(r6)     // Catch:{ zzdzd -> 0x01ed }
            java.lang.String r0 = r0.toString()     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ zzdzd -> 0x01ed }
            com.google.android.gms.internal.ads.zzdzd r0 = new com.google.android.gms.internal.ads.zzdzd     // Catch:{ zzdzd -> 0x01ed }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ zzdzd -> 0x01ed }
            r3.<init>()     // Catch:{ zzdzd -> 0x01ed }
            r3.append(r2)     // Catch:{ zzdzd -> 0x01ed }
            r3.append(r6)     // Catch:{ zzdzd -> 0x01ed }
            java.lang.String r2 = r3.toString()     // Catch:{ zzdzd -> 0x01ed }
            r0.<init>(r1, r2)     // Catch:{ zzdzd -> 0x01ed }
            throw r0     // Catch:{ zzdzd -> 0x01ed }
        L_0x01ed:
            r0 = move-exception
            goto L_0x0203
        L_0x01ef:
            r0 = move-exception
            goto L_0x01f8
        L_0x01f1:
            r0 = move-exception
            r7 = r20
            goto L_0x0226
        L_0x01f5:
            r0 = move-exception
            r7 = r20
        L_0x01f8:
            r5 = r18
            goto L_0x0203
        L_0x01fb:
            r0 = move-exception
            r7 = r8
            r1 = r10
            goto L_0x0226
        L_0x01ff:
            r0 = move-exception
            r7 = r8
            r5 = r9
            r1 = r10
        L_0x0203:
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzis     // Catch:{ all -> 0x0225 }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0225 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ all -> 0x0225 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0225 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0225 }
            if (r2 == 0) goto L_0x0224
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x0225 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0225 }
            long r2 = r2 - r14
            r5.zzd = r2     // Catch:{ all -> 0x0225 }
        L_0x0220:
            r7.disconnect()     // Catch:{ IOException -> 0x022a }
            return r5
        L_0x0224:
            throw r0     // Catch:{ all -> 0x0225 }
        L_0x0225:
            r0 = move-exception
        L_0x0226:
            r7.disconnect()     // Catch:{ IOException -> 0x022a }
            throw r0     // Catch:{ IOException -> 0x022a }
        L_0x022a:
            r0 = move-exception
            goto L_0x022e
        L_0x022c:
            r0 = move-exception
            r1 = r10
        L_0x022e:
            java.lang.String r2 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r3.concat(r2)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)
            com.google.android.gms.internal.ads.zzdzd r3 = new com.google.android.gms.internal.ads.zzdzd
            r3.<init>(r1, r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeee.zza(com.google.android.gms.internal.ads.zzeec):com.google.android.gms.internal.ads.zzeed");
    }
}
