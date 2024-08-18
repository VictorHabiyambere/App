package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzart implements zzaqx {
    protected final zzarv zza;
    @Deprecated
    protected final zzars zzb;
    private final zzars zzc;

    public zzart(zzars zzars) {
        zzarv zzarv = new zzarv(4096);
        this.zzc = zzars;
        this.zzb = zzars;
        this.zza = zzarv;
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ac A[SYNTHETIC, Splitter:B:142:0x02ac] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02af A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzara zza(com.google.android.gms.internal.ads.zzare r24) throws com.google.android.gms.internal.ads.zzarn {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r2 = "Error occurred when closing InputStream"
            java.lang.String r3 = "Content-Type"
            long r4 = android.os.SystemClock.elapsedRealtime()
        L_0x000a:
            java.util.Collections.emptyList()
            r6 = 0
            com.google.android.gms.internal.ads.zzaqn r0 = r24.zzd()     // Catch:{ IOException -> 0x02b2 }
            if (r0 != 0) goto L_0x0019
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x02b2 }
            goto L_0x003a
        L_0x0019:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ IOException -> 0x02b2 }
            r7.<init>()     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r8 = r0.zzb     // Catch:{ IOException -> 0x02b2 }
            if (r8 == 0) goto L_0x0027
            java.lang.String r9 = "If-None-Match"
            r7.put(r9, r8)     // Catch:{ IOException -> 0x02b2 }
        L_0x0027:
            long r8 = r0.zzd     // Catch:{ IOException -> 0x02b2 }
            r10 = 0
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            java.lang.String r0 = "If-Modified-Since"
            java.lang.String r8 = com.google.android.gms.internal.ads.zzasb.zzc(r8)     // Catch:{ IOException -> 0x02b2 }
            r7.put(r0, r8)     // Catch:{ IOException -> 0x02b2 }
        L_0x0038:
            r0 = r7
        L_0x003a:
            java.lang.String r7 = "application/x-www-form-urlencoded; charset=UTF-8"
            java.lang.String r8 = r24.zzk()     // Catch:{ IOException -> 0x02b2 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x02b2 }
            r9.<init>()     // Catch:{ IOException -> 0x02b2 }
            r9.putAll(r0)     // Catch:{ IOException -> 0x02b2 }
            java.util.Map r0 = r24.zzl()     // Catch:{ IOException -> 0x02b2 }
            r9.putAll(r0)     // Catch:{ IOException -> 0x02b2 }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02b2 }
            r0.<init>(r8)     // Catch:{ IOException -> 0x02b2 }
            java.net.URLConnection r8 = r0.openConnection()     // Catch:{ IOException -> 0x02b2 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ IOException -> 0x02b2 }
            boolean r10 = java.net.HttpURLConnection.getFollowRedirects()     // Catch:{ IOException -> 0x02b2 }
            r8.setInstanceFollowRedirects(r10)     // Catch:{ IOException -> 0x02b2 }
            int r10 = r24.zzb()     // Catch:{ IOException -> 0x02b2 }
            r8.setConnectTimeout(r10)     // Catch:{ IOException -> 0x02b2 }
            r8.setReadTimeout(r10)     // Catch:{ IOException -> 0x02b2 }
            r10 = 0
            r8.setUseCaches(r10)     // Catch:{ IOException -> 0x02b2 }
            r11 = 1
            r8.setDoInput(r11)     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r0 = r0.getProtocol()     // Catch:{ IOException -> 0x02b2 }
            java.lang.String r12 = "https"
            r12.equals(r0)     // Catch:{ IOException -> 0x02b2 }
            java.util.Set r0 = r9.keySet()     // Catch:{ all -> 0x02a7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02a7 }
        L_0x0084:
            boolean r12 = r0.hasNext()     // Catch:{ all -> 0x02a7 }
            if (r12 == 0) goto L_0x009a
            java.lang.Object r12 = r0.next()     // Catch:{ all -> 0x02a7 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x02a7 }
            java.lang.Object r13 = r9.get(r12)     // Catch:{ all -> 0x02a7 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x02a7 }
            r8.setRequestProperty(r12, r13)     // Catch:{ all -> 0x02a7 }
            goto L_0x0084
        L_0x009a:
            int r0 = r24.zza()     // Catch:{ all -> 0x02a7 }
            switch(r0) {
                case 0: goto L_0x00a4;
                default: goto L_0x00a1;
            }     // Catch:{ all -> 0x02a7 }
        L_0x00a1:
            java.lang.String r0 = "POST"
            goto L_0x00aa
        L_0x00a4:
            java.lang.String r0 = "GET"
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x02a7 }
            goto L_0x00d2
        L_0x00aa:
            r8.setRequestMethod(r0)     // Catch:{ all -> 0x02a7 }
            byte[] r0 = r24.zzx()     // Catch:{ all -> 0x02a7 }
            if (r0 == 0) goto L_0x00d2
            r8.setDoOutput(r11)     // Catch:{ all -> 0x02a7 }
            java.util.Map r9 = r8.getRequestProperties()     // Catch:{ all -> 0x02a7 }
            boolean r9 = r9.containsKey(r3)     // Catch:{ all -> 0x02a7 }
            if (r9 != 0) goto L_0x00c3
            r8.setRequestProperty(r3, r7)     // Catch:{ all -> 0x02a7 }
        L_0x00c3:
            java.io.DataOutputStream r7 = new java.io.DataOutputStream     // Catch:{ all -> 0x02a7 }
            java.io.OutputStream r9 = r8.getOutputStream()     // Catch:{ all -> 0x02a7 }
            r7.<init>(r9)     // Catch:{ all -> 0x02a7 }
            r7.write(r0)     // Catch:{ all -> 0x02a7 }
            r7.close()     // Catch:{ all -> 0x02a7 }
        L_0x00d2:
            int r0 = r8.getResponseCode()     // Catch:{ all -> 0x02a7 }
            r7 = -1
            if (r0 == r7) goto L_0x029b
            r24.zza()     // Catch:{ all -> 0x02a7 }
            r9 = 100
            r12 = 304(0x130, float:4.26E-43)
            r13 = 200(0xc8, float:2.8E-43)
            if (r0 < r9) goto L_0x00e6
            if (r0 < r13) goto L_0x0109
        L_0x00e6:
            r9 = 204(0xcc, float:2.86E-43)
            if (r0 == r9) goto L_0x0109
            if (r0 == r12) goto L_0x0109
            com.google.android.gms.internal.ads.zzasc r9 = new com.google.android.gms.internal.ads.zzasc     // Catch:{ all -> 0x0103 }
            java.util.Map r14 = r8.getHeaderFields()     // Catch:{ all -> 0x0103 }
            java.util.List r14 = com.google.android.gms.internal.ads.zzasf.zza(r14)     // Catch:{ all -> 0x0103 }
            int r15 = r8.getContentLength()     // Catch:{ all -> 0x0103 }
            com.google.android.gms.internal.ads.zzasd r11 = new com.google.android.gms.internal.ads.zzasd     // Catch:{ all -> 0x0103 }
            r11.<init>(r8)     // Catch:{ all -> 0x0103 }
            r9.<init>(r0, r14, r15, r11)     // Catch:{ all -> 0x0103 }
            goto L_0x0119
        L_0x0103:
            r0 = move-exception
            r10 = 1
            r12 = r23
            goto L_0x02aa
        L_0x0109:
            com.google.android.gms.internal.ads.zzasc r9 = new com.google.android.gms.internal.ads.zzasc     // Catch:{ all -> 0x02a7 }
            java.util.Map r11 = r8.getHeaderFields()     // Catch:{ all -> 0x02a7 }
            java.util.List r11 = com.google.android.gms.internal.ads.zzasf.zza(r11)     // Catch:{ all -> 0x02a7 }
            r9.<init>(r0, r11, r7, r6)     // Catch:{ all -> 0x02a7 }
            r8.disconnect()     // Catch:{ IOException -> 0x02b2 }
        L_0x0119:
            int r15 = r9.zzb()     // Catch:{ IOException -> 0x0296 }
            java.util.List r8 = r9.zzd()     // Catch:{ IOException -> 0x0296 }
            if (r15 != r12) goto L_0x01e5
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0296 }
            long r10 = r10 - r4
            com.google.android.gms.internal.ads.zzaqn r0 = r24.zzd()     // Catch:{ IOException -> 0x0296 }
            if (r0 != 0) goto L_0x0141
            com.google.android.gms.internal.ads.zzara r0 = new com.google.android.gms.internal.ads.zzara     // Catch:{ IOException -> 0x0296 }
            r17 = 304(0x130, float:4.26E-43)
            r18 = 0
            r19 = 1
            r16 = r0
            r20 = r10
            r22 = r8
            r16.<init>((int) r17, (byte[]) r18, (boolean) r19, (long) r20, (java.util.List) r22)     // Catch:{ IOException -> 0x0296 }
            goto L_0x01e4
        L_0x0141:
            java.util.TreeSet r7 = new java.util.TreeSet     // Catch:{ IOException -> 0x0296 }
            java.util.Comparator r12 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ IOException -> 0x0296 }
            r7.<init>(r12)     // Catch:{ IOException -> 0x0296 }
            boolean r12 = r8.isEmpty()     // Catch:{ IOException -> 0x0296 }
            if (r12 != 0) goto L_0x0166
            java.util.Iterator r12 = r8.iterator()     // Catch:{ IOException -> 0x0296 }
        L_0x0152:
            boolean r13 = r12.hasNext()     // Catch:{ IOException -> 0x0296 }
            if (r13 == 0) goto L_0x0166
            java.lang.Object r13 = r12.next()     // Catch:{ IOException -> 0x0296 }
            com.google.android.gms.internal.ads.zzaqw r13 = (com.google.android.gms.internal.ads.zzaqw) r13     // Catch:{ IOException -> 0x0296 }
            java.lang.String r13 = r13.zza()     // Catch:{ IOException -> 0x0296 }
            r7.add(r13)     // Catch:{ IOException -> 0x0296 }
            goto L_0x0152
        L_0x0166:
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ IOException -> 0x0296 }
            r15.<init>(r8)     // Catch:{ IOException -> 0x0296 }
            java.util.List r8 = r0.zzh     // Catch:{ IOException -> 0x0296 }
            if (r8 == 0) goto L_0x0195
            boolean r8 = r8.isEmpty()     // Catch:{ IOException -> 0x0296 }
            if (r8 != 0) goto L_0x01d2
            java.util.List r8 = r0.zzh     // Catch:{ IOException -> 0x0296 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0296 }
        L_0x017b:
            boolean r12 = r8.hasNext()     // Catch:{ IOException -> 0x0296 }
            if (r12 == 0) goto L_0x01d2
            java.lang.Object r12 = r8.next()     // Catch:{ IOException -> 0x0296 }
            com.google.android.gms.internal.ads.zzaqw r12 = (com.google.android.gms.internal.ads.zzaqw) r12     // Catch:{ IOException -> 0x0296 }
            java.lang.String r13 = r12.zza()     // Catch:{ IOException -> 0x0296 }
            boolean r13 = r7.contains(r13)     // Catch:{ IOException -> 0x0296 }
            if (r13 != 0) goto L_0x017b
            r15.add(r12)     // Catch:{ IOException -> 0x0296 }
            goto L_0x017b
        L_0x0195:
            java.util.Map r8 = r0.zzg     // Catch:{ IOException -> 0x0296 }
            boolean r8 = r8.isEmpty()     // Catch:{ IOException -> 0x0296 }
            if (r8 != 0) goto L_0x01d2
            java.util.Map r8 = r0.zzg     // Catch:{ IOException -> 0x0296 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ IOException -> 0x0296 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0296 }
        L_0x01a7:
            boolean r12 = r8.hasNext()     // Catch:{ IOException -> 0x0296 }
            if (r12 == 0) goto L_0x01d2
            java.lang.Object r12 = r8.next()     // Catch:{ IOException -> 0x0296 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IOException -> 0x0296 }
            java.lang.Object r13 = r12.getKey()     // Catch:{ IOException -> 0x0296 }
            boolean r13 = r7.contains(r13)     // Catch:{ IOException -> 0x0296 }
            if (r13 != 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzaqw r13 = new com.google.android.gms.internal.ads.zzaqw     // Catch:{ IOException -> 0x0296 }
            java.lang.Object r14 = r12.getKey()     // Catch:{ IOException -> 0x0296 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ IOException -> 0x0296 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ IOException -> 0x0296 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x0296 }
            r13.<init>(r14, r12)     // Catch:{ IOException -> 0x0296 }
            r15.add(r13)     // Catch:{ IOException -> 0x0296 }
            goto L_0x01a7
        L_0x01d2:
            com.google.android.gms.internal.ads.zzara r7 = new com.google.android.gms.internal.ads.zzara     // Catch:{ IOException -> 0x0296 }
            byte[] r14 = r0.zza     // Catch:{ IOException -> 0x0296 }
            r13 = 304(0x130, float:4.26E-43)
            r0 = 1
            r12 = r7
            r8 = r15
            r15 = r0
            r16 = r10
            r18 = r8
            r12.<init>((int) r13, (byte[]) r14, (boolean) r15, (long) r16, (java.util.List) r18)     // Catch:{ IOException -> 0x0296 }
            r0 = r7
        L_0x01e4:
            return r0
        L_0x01e5:
            java.io.InputStream r11 = r9.zzc()     // Catch:{ IOException -> 0x0296 }
            if (r11 == 0) goto L_0x0234
            int r0 = r9.zza()     // Catch:{ IOException -> 0x0296 }
            r12 = r23
            com.google.android.gms.internal.ads.zzarv r14 = r12.zza     // Catch:{ IOException -> 0x0294 }
            com.google.android.gms.internal.ads.zzasi r6 = new com.google.android.gms.internal.ads.zzasi     // Catch:{ IOException -> 0x0294 }
            r6.<init>(r14, r0)     // Catch:{ IOException -> 0x0294 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r13 = r14.zzb(r0)     // Catch:{ all -> 0x0220 }
        L_0x01fe:
            int r0 = r11.read(r13)     // Catch:{ all -> 0x021d }
            if (r0 == r7) goto L_0x0208
            r6.write(r13, r10, r0)     // Catch:{ all -> 0x021d }
            goto L_0x01fe
        L_0x0208:
            byte[] r7 = r6.toByteArray()     // Catch:{ all -> 0x021d }
            r11.close()     // Catch:{ IOException -> 0x0210 }
            goto L_0x0216
        L_0x0210:
            r0 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x0294 }
            com.google.android.gms.internal.ads.zzarq.zzd(r2, r0)     // Catch:{ IOException -> 0x0294 }
        L_0x0216:
            r14.zza(r13)     // Catch:{ IOException -> 0x0294 }
            r6.close()     // Catch:{ IOException -> 0x0294 }
            goto L_0x0239
        L_0x021d:
            r0 = move-exception
            r7 = r0
            goto L_0x0223
        L_0x0220:
            r0 = move-exception
            r7 = r0
            r13 = 0
        L_0x0223:
            r11.close()     // Catch:{ IOException -> 0x0227 }
            goto L_0x022d
        L_0x0227:
            r0 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r10]     // Catch:{ IOException -> 0x0294 }
            com.google.android.gms.internal.ads.zzarq.zzd(r2, r0)     // Catch:{ IOException -> 0x0294 }
        L_0x022d:
            r14.zza(r13)     // Catch:{ IOException -> 0x0294 }
            r6.close()     // Catch:{ IOException -> 0x0294 }
            throw r7     // Catch:{ IOException -> 0x0294 }
        L_0x0234:
            r12 = r23
            byte[] r0 = new byte[r10]     // Catch:{ IOException -> 0x0294 }
            r7 = r0
        L_0x0239:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0291 }
            long r10 = r10 - r4
            boolean r0 = com.google.android.gms.internal.ads.zzarq.zzb     // Catch:{ IOException -> 0x0291 }
            if (r0 != 0) goto L_0x0248
            r13 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 <= 0) goto L_0x0270
        L_0x0248:
            java.lang.String r0 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0291 }
            if (r7 == 0) goto L_0x0256
            int r10 = r7.length     // Catch:{ IOException -> 0x0291 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ IOException -> 0x0291 }
            goto L_0x0258
        L_0x0256:
            java.lang.String r10 = "null"
        L_0x0258:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r15)     // Catch:{ IOException -> 0x0291 }
            com.google.android.gms.internal.ads.zzaqs r13 = r24.zzy()     // Catch:{ IOException -> 0x0291 }
            int r13 = r13.zza()     // Catch:{ IOException -> 0x0291 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ IOException -> 0x0291 }
            java.lang.Object[] r6 = new java.lang.Object[]{r1, r6, r10, r11, r13}     // Catch:{ IOException -> 0x0291 }
            com.google.android.gms.internal.ads.zzarq.zza(r0, r6)     // Catch:{ IOException -> 0x0291 }
        L_0x0270:
            r6 = 200(0xc8, float:2.8E-43)
            if (r15 < r6) goto L_0x028b
            r0 = 299(0x12b, float:4.19E-43)
            if (r15 > r0) goto L_0x028b
            com.google.android.gms.internal.ads.zzara r0 = new com.google.android.gms.internal.ads.zzara     // Catch:{ IOException -> 0x0291 }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0291 }
            long r18 = r10 - r4
            r17 = 0
            r14 = r0
            r16 = r7
            r20 = r8
            r14.<init>((int) r15, (byte[]) r16, (boolean) r17, (long) r18, (java.util.List) r20)     // Catch:{ IOException -> 0x0291 }
            return r0
        L_0x028b:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0291 }
            r0.<init>()     // Catch:{ IOException -> 0x0291 }
            throw r0     // Catch:{ IOException -> 0x0291 }
        L_0x0291:
            r0 = move-exception
            r15 = r7
            goto L_0x02b7
        L_0x0294:
            r0 = move-exception
            goto L_0x0299
        L_0x0296:
            r0 = move-exception
            r12 = r23
        L_0x0299:
            r15 = 0
            goto L_0x02b7
        L_0x029b:
            r12 = r23
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x02a5 }
            java.lang.String r6 = "Could not retrieve response code from HttpUrlConnection."
            r0.<init>(r6)     // Catch:{ all -> 0x02a5 }
            throw r0     // Catch:{ all -> 0x02a5 }
        L_0x02a5:
            r0 = move-exception
            goto L_0x02aa
        L_0x02a7:
            r0 = move-exception
            r12 = r23
        L_0x02aa:
            if (r10 != 0) goto L_0x02af
            r8.disconnect()     // Catch:{ IOException -> 0x02b0 }
        L_0x02af:
            throw r0     // Catch:{ IOException -> 0x02b0 }
        L_0x02b0:
            r0 = move-exception
            goto L_0x02b5
        L_0x02b2:
            r0 = move-exception
            r12 = r23
        L_0x02b5:
            r9 = 0
            r15 = 0
        L_0x02b7:
            boolean r6 = r0 instanceof java.net.SocketTimeoutException
            if (r6 == 0) goto L_0x02cb
            com.google.android.gms.internal.ads.zzash r0 = new com.google.android.gms.internal.ads.zzash
            com.google.android.gms.internal.ads.zzarm r6 = new com.google.android.gms.internal.ads.zzarm
            r6.<init>()
            java.lang.String r7 = "socket"
            r8 = 0
            r0.<init>(r7, r6, r8)
            r6 = r0
            goto L_0x0335
        L_0x02cb:
            boolean r6 = r0 instanceof java.net.MalformedURLException
            if (r6 != 0) goto L_0x0378
            if (r9 == 0) goto L_0x0372
            int r0 = r9.zzb()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            java.lang.String r7 = r24.zzk()
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}
            java.lang.String r7 = "Unexpected response code %d for %s"
            com.google.android.gms.internal.ads.zzarq.zzb(r7, r6)
            if (r15 == 0) goto L_0x0327
            java.util.List r19 = r9.zzd()
            com.google.android.gms.internal.ads.zzara r6 = new com.google.android.gms.internal.ads.zzara
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r17 = r7 - r4
            r16 = 0
            r13 = r6
            r14 = r0
            r13.<init>((int) r14, (byte[]) r15, (boolean) r16, (long) r17, (java.util.List) r19)
            r7 = 401(0x191, float:5.62E-43)
            if (r0 == r7) goto L_0x0318
            r7 = 403(0x193, float:5.65E-43)
            if (r0 != r7) goto L_0x0304
            goto L_0x0318
        L_0x0304:
            r1 = 400(0x190, float:5.6E-43)
            if (r0 < r1) goto L_0x0312
            r1 = 499(0x1f3, float:6.99E-43)
            if (r0 > r1) goto L_0x0312
            com.google.android.gms.internal.ads.zzaqr r0 = new com.google.android.gms.internal.ads.zzaqr
            r0.<init>(r6)
            throw r0
        L_0x0312:
            com.google.android.gms.internal.ads.zzarl r0 = new com.google.android.gms.internal.ads.zzarl
            r0.<init>(r6)
            throw r0
        L_0x0318:
            com.google.android.gms.internal.ads.zzash r0 = new com.google.android.gms.internal.ads.zzash
            com.google.android.gms.internal.ads.zzaqm r7 = new com.google.android.gms.internal.ads.zzaqm
            r7.<init>(r6)
            java.lang.String r6 = "auth"
            r8 = 0
            r0.<init>(r6, r7, r8)
            r6 = r0
            goto L_0x0335
        L_0x0327:
            r8 = 0
            com.google.android.gms.internal.ads.zzash r0 = new com.google.android.gms.internal.ads.zzash
            com.google.android.gms.internal.ads.zzaqz r6 = new com.google.android.gms.internal.ads.zzaqz
            r6.<init>()
            java.lang.String r7 = "network"
            r0.<init>(r7, r6, r8)
            r6 = r0
        L_0x0335:
            com.google.android.gms.internal.ads.zzaqs r0 = r24.zzy()
            int r7 = r24.zzb()
            com.google.android.gms.internal.ads.zzarn r8 = r6.zzb     // Catch:{ zzarn -> 0x035b }
            r0.zzc(r8)     // Catch:{ zzarn -> 0x035b }
            java.lang.String r0 = r6.zza
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r6}
            java.lang.String r6 = "%s-retry [timeout=%s]"
            java.lang.String r0 = java.lang.String.format(r6, r0)
            r1.zzm(r0)
            goto L_0x000a
        L_0x035b:
            r0 = move-exception
            java.lang.String r2 = r6.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r1.zzm(r2)
            throw r0
        L_0x0372:
            com.google.android.gms.internal.ads.zzarb r1 = new com.google.android.gms.internal.ads.zzarb
            r1.<init>(r0)
            throw r1
        L_0x0378:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r1 = r24.zzk()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Bad URL "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzart.zza(com.google.android.gms.internal.ads.zzare):com.google.android.gms.internal.ads.zzara");
    }
}
