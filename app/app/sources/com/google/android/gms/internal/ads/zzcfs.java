package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfs extends zzcfp {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcfs(zzcee zzcee) {
        super(zzcee);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzm.zzj("Context.getCacheDir() returned null");
            return;
        }
        this.zzg = new File(zzftv.zza(zzftu.zza(), cacheDir, "admobVideoStreams"));
        if (!this.zzg.isDirectory() && !this.zzg.mkdirs()) {
            zzm.zzj("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        } else if (!this.zzg.setReadable(true, false) || !this.zzg.setExecutable(true, false)) {
            zzm.zzj("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        }
    }

    private final File zza(File file) {
        return new File(zzftv.zza(zzftu.zza(), this.zzg, String.valueOf(file.getName()).concat(".done")));
    }

    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02b5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02b6, code lost:
        r26 = r4;
        r24 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02bc, code lost:
        r23 = r1;
        r25 = r3;
        r26 = r4;
        r20 = r5;
        r27 = r6;
        r28 = r7;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02cc, code lost:
        r2 = r19;
        r5 = r20;
        r15 = r21;
        r1 = r23;
        r14 = r24;
        r3 = r25;
        r4 = r26;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02e0, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02ef, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02f0, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r11 = "Timeout exceeded. Limit: " + java.lang.Long.toString(r10) + " sec";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0319, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x031a, code lost:
        r23 = r1;
        r19 = r2;
        r25 = r3;
        r26 = r4;
        r20 = r5;
        r27 = r6;
        r28 = r7;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x032e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0331, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0339, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r11 = "File too big for full file cache. Size: " + java.lang.Integer.toString(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x035d, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x035e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0361, code lost:
        r2 = r0;
        r3 = r11;
        r1 = r24;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0369, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x036c, code lost:
        r2 = r0;
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0371, code lost:
        r26 = r4;
        r24 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r26.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x037f, code lost:
        if (com.google.android.gms.ads.internal.util.zze.zzm(3) == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0381, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zze("Preloaded " + zzf.format((long) r13) + " bytes from " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03a4, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03ae, code lost:
        if (r0.isFile() == false) goto L_0x03b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03b0, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03d1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03d3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03d4, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03da, code lost:
        r26 = r4;
        r1 = r14;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03e9, code lost:
        r1 = r14;
        r2 = r0;
        r15 = r15;
        r3 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03f5, code lost:
        com.google.android.gms.ads.internal.zzu.zzo().zzw(r2, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0409, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Preload aborted for URL \"" + r9 + "\"");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0423, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzk("Preload failed for URL \"" + r9 + "\"", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0114, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r1 = com.google.android.gms.internal.ads.zzfuq.zza().zzn(new com.google.android.gms.internal.ads.zzcfr(r9), 265, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
        if ((r1 instanceof java.net.HttpURLConnection) == false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x012a, code lost:
        r2 = r1.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0130, code lost:
        if (r2 >= 400) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0133, code lost:
        r15 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r1 = "HTTP request failed. Code: " + java.lang.Integer.toString(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0168, code lost:
        throw new java.io.IOException("HTTP status code " + r2 + " at " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0169, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x016c, code lost:
        r2 = r0;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0172, code lost:
        r2 = r0;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0174, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r7 = r1.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x017b, code lost:
        if (r7 >= 0) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017d, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Stream cache aborted, missing content-length header at " + r9);
        zzg(r9, r12.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x019f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a0, code lost:
        r2 = zzf.format((long) r7);
        r6 = ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzv)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b7, code lost:
        if (r7 <= r6) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01b9, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Content length " + r2 + " exceeds limit at " + r9);
        r0 = new java.lang.StringBuilder();
        r0.append("File too big for full file cache. Size: ");
        r0.append(r2);
        zzg(r9, r12.getAbsolutePath(), "sizeExceeded", r0.toString());
        zze.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f5, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zze("Caching " + r2 + " bytes from " + r9);
        r5 = java.nio.channels.Channels.newChannel(r1.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r3 = r4.getChannel();
        r2 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzu.zzB();
        r17 = r16.currentTimeMillis();
        r1 = new com.google.android.gms.ads.internal.util.zzcb(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzy)).longValue());
        r10 = ((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzx)).longValue();
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0256, code lost:
        r19 = r5.read(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x025a, code lost:
        if (r19 < 0) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x025c, code lost:
        r13 = r13 + r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x025e, code lost:
        if (r13 > r6) goto L_0x0339;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        r2.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0267, code lost:
        if (r3.write(r2) > 0) goto L_0x031a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0269, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0278, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r10)) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x027a, code lost:
        r19 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x027e, code lost:
        if (r8.zzh != false) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0284, code lost:
        if (r1.zzb() == false) goto L_0x02bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0286, code lost:
        r20 = r12.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x028c, code lost:
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0290, code lost:
        r23 = r1;
        r1 = r1;
        r24 = r14;
        r14 = com.google.android.gms.ads.internal.util.client.zzf.zza;
        r25 = r3;
        r26 = r4;
        r4 = r20;
        r20 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzcfj(r29, r30, r4, r13, r7, false);
        r14.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03d1 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r21 r24 r26 
      PHI: (r21v6 java.lang.String) = (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v3 java.lang.String), (r21v15 java.lang.String), (r21v15 java.lang.String) binds: [B:128:0x0377, B:138:0x03bd, B:139:?, B:135:0x03b8, B:136:?, B:93:0x028e, B:96:0x02ac] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 java.lang.String) = (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v9 java.lang.String), (r24v15 java.lang.String) binds: [B:128:0x0377, B:138:0x03bd, B:139:?, B:135:0x03b8, B:136:?, B:93:0x028e, B:96:0x02ac] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r26v7 java.io.FileOutputStream) = (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v4 java.io.FileOutputStream), (r26v12 java.io.FileOutputStream), (r26v18 java.io.FileOutputStream) binds: [B:128:0x0377, B:138:0x03bd, B:139:?, B:135:0x03b8, B:136:?, B:93:0x028e, B:96:0x02ac] A[DONT_GENERATE, DONT_INLINE], Splitter:B:96:0x02ac] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0423  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r30) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            java.io.File r0 = r8.zzg
            r10 = 0
            r11 = 0
            if (r0 == 0) goto L_0x046a
        L_0x000a:
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0010
            r3 = r10
            goto L_0x002c
        L_0x0010:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = r10
            r3 = r2
        L_0x0017:
            if (r2 >= r1) goto L_0x002c
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x0029
            int r3 = r3 + 1
        L_0x0029:
            int r2 = r2 + 1
            goto L_0x0017
        L_0x002c:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzu
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x0093
            java.io.File r0 = r8.zzg
            if (r0 != 0) goto L_0x0043
            goto L_0x0088
        L_0x0043:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = r10
            r5 = r11
        L_0x004f:
            if (r4 >= r1) goto L_0x006e
            r6 = r0[r4]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x006a
            long r12 = r6.lastModified()
            int r7 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x006a
            r5 = r6
            r2 = r12
            goto L_0x006b
        L_0x006a:
        L_0x006b:
            int r4 = r4 + 1
            goto L_0x004f
        L_0x006e:
            if (r5 == 0) goto L_0x0085
            boolean r0 = r5.delete()
            java.io.File r1 = r8.zza(r5)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0084
            boolean r1 = r1.delete()
            r0 = r0 & r1
            goto L_0x0086
        L_0x0084:
            goto L_0x0086
        L_0x0085:
            r0 = r10
        L_0x0086:
            if (r0 != 0) goto L_0x000a
        L_0x0088:
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            java.lang.String r0 = "expireFailed"
            r8.zzg(r9, r11, r0, r11)
            return r10
        L_0x0093:
            java.lang.String r0 = com.google.android.gms.ads.internal.util.client.zzf.zzf(r30)
            java.io.File r12 = new java.io.File
            com.google.android.gms.internal.ads.zzftw r1 = com.google.android.gms.internal.ads.zzftu.zza()
            java.io.File r2 = r8.zzg
            java.lang.String r0 = com.google.android.gms.internal.ads.zzftv.zza(r1, r2, r0)
            r12.<init>(r0)
            java.io.File r0 = r8.zza(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00d2
            boolean r1 = r0.isFile()
            if (r1 != 0) goto L_0x00b8
            goto L_0x00d2
        L_0x00b8:
            long r0 = r12.length()
            int r0 = (int) r0
            java.lang.String r1 = java.lang.String.valueOf(r30)
            java.lang.String r2 = "Stream cache hit at "
            java.lang.String r1 = r2.concat(r1)
            com.google.android.gms.ads.internal.util.client.zzm.zze(r1)
            java.lang.String r1 = r12.getAbsolutePath()
            r8.zzh(r9, r1, r0)
            return r13
        L_0x00d2:
            java.io.File r1 = r8.zzg
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r30)
            java.util.Set r3 = zze
            java.lang.String r14 = r1.concat(r2)
            monitor-enter(r3)
            java.util.Set r1 = zze     // Catch:{ all -> 0x0467 }
            boolean r1 = r1.contains(r14)     // Catch:{ all -> 0x0467 }
            if (r1 == 0) goto L_0x010e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0467 }
            r0.<init>()     // Catch:{ all -> 0x0467 }
            java.lang.String r1 = "Stream cache already in progress at "
            r0.append(r1)     // Catch:{ all -> 0x0467 }
            r0.append(r9)     // Catch:{ all -> 0x0467 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0467 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x0467 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x0467 }
            java.lang.String r1 = "inProgress"
            r8.zzg(r9, r0, r1, r11)     // Catch:{ all -> 0x0467 }
            monitor-exit(r3)     // Catch:{ all -> 0x0467 }
            return r10
        L_0x010e:
            java.util.Set r1 = zze     // Catch:{ all -> 0x0467 }
            r1.add(r14)     // Catch:{ all -> 0x0467 }
            monitor-exit(r3)     // Catch:{ all -> 0x0467 }
            java.lang.String r15 = "error"
            com.google.android.gms.internal.ads.zzfuq r1 = com.google.android.gms.internal.ads.zzfuq.zza()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.internal.ads.zzcfr r2 = new com.google.android.gms.internal.ads.zzcfr     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r3 = 265(0x109, float:3.71E-43)
            r4 = -1
            java.net.HttpURLConnection r1 = r1.zzn(r2, r3, r4)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            boolean r2 = r1 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            if (r2 == 0) goto L_0x0177
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r3 = 400(0x190, float:5.6E-43)
            if (r2 >= r3) goto L_0x0133
            goto L_0x0177
        L_0x0133:
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = java.lang.Integer.toString(r2)     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            r1.<init>()     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            java.lang.String r3 = "HTTP request failed. Code: "
            r1.append(r3)     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            r1.append(r0)     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0171, RuntimeException -> 0x016f }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            r3.<init>()     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            java.lang.String r4 = "HTTP status code "
            r3.append(r4)     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            r3.append(r2)     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            java.lang.String r2 = " at "
            r3.append(r2)     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            r3.append(r9)     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
            throw r0     // Catch:{ IOException -> 0x016b, RuntimeException -> 0x0169 }
        L_0x0169:
            r0 = move-exception
            goto L_0x016c
        L_0x016b:
            r0 = move-exception
        L_0x016c:
            r2 = r0
            r3 = r1
            goto L_0x0174
        L_0x016f:
            r0 = move-exception
            goto L_0x0172
        L_0x0171:
            r0 = move-exception
        L_0x0172:
            r2 = r0
            r3 = r11
        L_0x0174:
            r1 = r14
            goto L_0x03f1
        L_0x0177:
            int r7 = r1.getContentLength()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            if (r7 >= 0) goto L_0x01a0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.<init>()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = "Stream cache aborted, missing content-length header at "
            r0.append(r1)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.append(r9)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = "contentLengthMissing"
            r8.zzg(r9, r0, r1, r11)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.remove(r14)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            return r10
        L_0x01a0:
            java.text.DecimalFormat r2 = zzf     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            long r3 = (long) r7     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzv     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            int r6 = r3.intValue()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            if (r7 <= r6) goto L_0x01f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.<init>()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = "Content length "
            r0.append(r1)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.append(r2)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = " exceeds limit at "
            r0.append(r1)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.append(r9)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.<init>()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = "File too big for full file cache. Size: "
            r0.append(r1)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.append(r2)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r2 = "sizeExceeded"
            r8.zzg(r9, r1, r2, r0)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r0.remove(r14)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            return r10
        L_0x01f5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r3.<init>()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r4 = "Caching "
            r3.append(r4)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r3.append(r2)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r2 = " bytes from "
            r3.append(r2)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r3.append(r9)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r2)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            r4.<init>(r12)     // Catch:{ IOException -> 0x03e8, RuntimeException -> 0x03e6 }
            java.nio.channels.FileChannel r3 = r4.getChannel()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzy     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzben r11 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            java.lang.Object r1 = r11.zza(r1)     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            long r10 = r1.longValue()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.ads.internal.util.zzcb r1 = new com.google.android.gms.ads.internal.util.zzcb     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            r1.<init>(r10)     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzbeg r10 = com.google.android.gms.internal.ads.zzbep.zzx     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzben r11 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            java.lang.Object r10 = r11.zza(r10)     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            long r10 = r10.longValue()     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            r13 = 0
        L_0x0256:
            int r19 = r5.read(r2)     // Catch:{ IOException -> 0x03d9, RuntimeException -> 0x03d7 }
            if (r19 < 0) goto L_0x0371
            int r13 = r13 + r19
            if (r13 > r6) goto L_0x0339
            r2.flip()     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
        L_0x0263:
            int r19 = r3.write(r2)     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            if (r19 > 0) goto L_0x031a
            r2.clear()     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            long r19 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            long r19 = r19 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r10
            int r19 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r19 > 0) goto L_0x02f0
            r19 = r2
            boolean r2 = r8.zzh     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            if (r2 != 0) goto L_0x02e0
            boolean r2 = r1.zzb()     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            if (r2 == 0) goto L_0x02bc
            java.lang.String r20 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            android.os.Handler r2 = com.google.android.gms.ads.internal.util.client.zzf.zza     // Catch:{ IOException -> 0x0330, RuntimeException -> 0x032e }
            r21 = r15
            com.google.android.gms.internal.ads.zzcfj r15 = new com.google.android.gms.internal.ads.zzcfj     // Catch:{ IOException -> 0x02b5, RuntimeException -> 0x02b3 }
            r22 = 0
            r23 = r1
            r1 = r15
            r24 = r14
            r14 = r2
            r2 = r29
            r25 = r3
            r3 = r30
            r26 = r4
            r4 = r20
            r20 = r5
            r5 = r13
            r27 = r6
            r6 = r7
            r28 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r14.post(r15)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            goto L_0x02cc
        L_0x02b3:
            r0 = move-exception
            goto L_0x02b6
        L_0x02b5:
            r0 = move-exception
        L_0x02b6:
            r26 = r4
            r24 = r14
            goto L_0x03d4
        L_0x02bc:
            r23 = r1
            r25 = r3
            r26 = r4
            r20 = r5
            r27 = r6
            r28 = r7
            r24 = r14
            r21 = r15
        L_0x02cc:
            r2 = r19
            r5 = r20
            r15 = r21
            r1 = r23
            r14 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r7 = r28
            goto L_0x0256
        L_0x02e0:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            throw r0     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
        L_0x02f0:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r10)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            r1.<init>()     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r2 = "Timeout exceeded. Limit: "
            r1.append(r2)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            r1.append(r0)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r11 = r1.toString()     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
            throw r0     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
        L_0x031a:
            r23 = r1
            r19 = r2
            r25 = r3
            r26 = r4
            r20 = r5
            r27 = r6
            r28 = r7
            r24 = r14
            r21 = r15
            goto L_0x0263
        L_0x032e:
            r0 = move-exception
            goto L_0x0331
        L_0x0330:
            r0 = move-exception
        L_0x0331:
            r26 = r4
            r24 = r14
            r21 = r15
            goto L_0x03d4
        L_0x0339:
            r26 = r4
            r24 = r14
            r21 = r15
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = java.lang.Integer.toString(r13)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            r1.<init>()     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r2 = "File too big for full file cache. Size: "
            r1.append(r2)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            r1.append(r0)     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.lang.String r11 = r1.toString()     // Catch:{ IOException -> 0x036b, RuntimeException -> 0x0369 }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
            java.lang.String r1 = "stream cache file size limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
            throw r0     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e }
        L_0x035e:
            r0 = move-exception
            goto L_0x0361
        L_0x0360:
            r0 = move-exception
        L_0x0361:
            r2 = r0
            r3 = r11
            r1 = r24
            r11 = r26
            goto L_0x03f1
        L_0x0369:
            r0 = move-exception
            goto L_0x036c
        L_0x036b:
            r0 = move-exception
        L_0x036c:
            r2 = r0
            r1 = r24
            goto L_0x03e2
        L_0x0371:
            r26 = r4
            r24 = r14
            r21 = r15
            r26.close()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r1 = 3
            boolean r1 = com.google.android.gms.ads.internal.util.zze.zzm(r1)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            if (r1 == 0) goto L_0x03a4
            java.text.DecimalFormat r1 = zzf     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            long r2 = (long) r13     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r2.<init>()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.lang.String r3 = "Preloaded "
            r2.append(r3)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r2.append(r1)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.lang.String r1 = " bytes from "
            r2.append(r1)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r2.append(r9)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            com.google.android.gms.ads.internal.util.client.zzm.zze(r1)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
        L_0x03a4:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            if (r1 == 0) goto L_0x03b8
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            goto L_0x03bd
        L_0x03b8:
            r0.createNewFile()     // Catch:{ IOException -> 0x03bc, RuntimeException -> 0x03d1 }
            goto L_0x03bd
        L_0x03bc:
            r0 = move-exception
        L_0x03bd:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r8.zzh(r9, r0, r13)     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            java.util.Set r0 = zze     // Catch:{ IOException -> 0x03d3, RuntimeException -> 0x03d1 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x03cf, RuntimeException -> 0x03cd }
            r1 = 1
            return r1
        L_0x03cd:
            r0 = move-exception
            goto L_0x03df
        L_0x03cf:
            r0 = move-exception
            goto L_0x03df
        L_0x03d1:
            r0 = move-exception
            goto L_0x03d4
        L_0x03d3:
            r0 = move-exception
        L_0x03d4:
            r1 = r24
            goto L_0x03df
        L_0x03d7:
            r0 = move-exception
            goto L_0x03da
        L_0x03d9:
            r0 = move-exception
        L_0x03da:
            r26 = r4
            r1 = r14
            r21 = r15
        L_0x03df:
            r2 = r0
            r15 = r21
        L_0x03e2:
            r11 = r26
            r3 = 0
            goto L_0x03f1
        L_0x03e6:
            r0 = move-exception
            goto L_0x03e9
        L_0x03e8:
            r0 = move-exception
        L_0x03e9:
            r1 = r14
            r21 = r15
            r2 = r0
            r15 = r21
            r3 = 0
            r11 = 0
        L_0x03f1:
            boolean r0 = r2 instanceof java.lang.RuntimeException
            if (r0 == 0) goto L_0x03fe
            java.lang.String r0 = "VideoStreamFullFileCache.preload"
            com.google.android.gms.internal.ads.zzcby r4 = com.google.android.gms.ads.internal.zzu.zzo()
            r4.zzw(r2, r0)
        L_0x03fe:
            r11.close()     // Catch:{ IOException -> 0x0404, NullPointerException -> 0x0402 }
            goto L_0x0405
        L_0x0402:
            r0 = move-exception
            goto L_0x0405
        L_0x0404:
            r0 = move-exception
        L_0x0405:
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0423
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Preload aborted for URL \""
            r0.append(r2)
            r0.append(r9)
            java.lang.String r2 = "\""
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r0)
            goto L_0x043c
        L_0x0423:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Preload failed for URL \""
            r0.append(r4)
            r0.append(r9)
            java.lang.String r4 = "\""
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r0, r2)
        L_0x043c:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x0459
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x0459
            java.lang.String r0 = r12.getAbsolutePath()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "Could not delete partial cache file at "
            java.lang.String r0 = r2.concat(r0)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
        L_0x0459:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.zzg(r9, r0, r15, r3)
            java.util.Set r0 = zze
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x0467:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0467 }
            throw r0
        L_0x046a:
            java.lang.String r0 = "noCacheDir"
            r1 = 0
            r8.zzg(r9, r1, r0, r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfs.zzt(java.lang.String):boolean");
    }
}
