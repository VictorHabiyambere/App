package com.google.android.gms.dynamite;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzb {
    private static ClassLoader zza = null;
    private static Thread zzb = null;

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        if (r1 == null) goto L_0x00ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.ClassLoader zza() {
        /*
            java.lang.Class<com.google.android.gms.dynamite.zzb> r0 = com.google.android.gms.dynamite.zzb.class
            monitor-enter(r0)
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00d7 }
            if (r1 != 0) goto L_0x00d3
            java.lang.Thread r1 = zzb     // Catch:{ all -> 0x00d7 }
            r2 = 0
            if (r1 != 0) goto L_0x00a8
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x00d7 }
            java.lang.Thread r1 = r1.getThread()     // Catch:{ all -> 0x00d7 }
            java.lang.ThreadGroup r1 = r1.getThreadGroup()     // Catch:{ all -> 0x00d7 }
            if (r1 != 0) goto L_0x001d
            r5 = r2
            goto L_0x009f
        L_0x001d:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            monitor-enter(r3)     // Catch:{ all -> 0x00d7 }
            int r4 = r1.activeGroupCount()     // Catch:{ SecurityException -> 0x0081 }
            java.lang.ThreadGroup[] r5 = new java.lang.ThreadGroup[r4]     // Catch:{ SecurityException -> 0x0081 }
            r1.enumerate(r5)     // Catch:{ SecurityException -> 0x0081 }
            r6 = 0
            r7 = r6
        L_0x002b:
            if (r7 >= r4) goto L_0x003f
            r8 = r5[r7]     // Catch:{ SecurityException -> 0x0081 }
            java.lang.String r9 = "dynamiteLoader"
            java.lang.String r10 = r8.getName()     // Catch:{ SecurityException -> 0x0081 }
            boolean r9 = r9.equals(r10)     // Catch:{ SecurityException -> 0x0081 }
            if (r9 == 0) goto L_0x003c
            goto L_0x0040
        L_0x003c:
            int r7 = r7 + 1
            goto L_0x002b
        L_0x003f:
            r8 = r2
        L_0x0040:
            if (r8 != 0) goto L_0x0049
            java.lang.ThreadGroup r8 = new java.lang.ThreadGroup     // Catch:{ SecurityException -> 0x0081 }
            java.lang.String r4 = "dynamiteLoader"
            r8.<init>(r1, r4)     // Catch:{ SecurityException -> 0x0081 }
        L_0x0049:
            int r1 = r8.activeCount()     // Catch:{ SecurityException -> 0x0081 }
            java.lang.Thread[] r4 = new java.lang.Thread[r1]     // Catch:{ SecurityException -> 0x0081 }
            r8.enumerate(r4)     // Catch:{ SecurityException -> 0x0081 }
        L_0x0052:
            if (r6 >= r1) goto L_0x0066
            r5 = r4[r6]     // Catch:{ SecurityException -> 0x0081 }
            java.lang.String r7 = "GmsDynamite"
            java.lang.String r9 = r5.getName()     // Catch:{ SecurityException -> 0x0081 }
            boolean r7 = r7.equals(r9)     // Catch:{ SecurityException -> 0x0081 }
            if (r7 == 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            int r6 = r6 + 1
            goto L_0x0052
        L_0x0066:
            r5 = r2
        L_0x0067:
            if (r5 != 0) goto L_0x007e
            com.google.android.gms.dynamite.zza r1 = new com.google.android.gms.dynamite.zza     // Catch:{ SecurityException -> 0x007b }
            java.lang.String r4 = "GmsDynamite"
            r1.<init>(r8, r4)     // Catch:{ SecurityException -> 0x007b }
            r1.setContextClassLoader(r2)     // Catch:{ SecurityException -> 0x0078 }
            r1.start()     // Catch:{ SecurityException -> 0x0078 }
            r5 = r1
            goto L_0x009e
        L_0x0078:
            r4 = move-exception
            r5 = r1
            goto L_0x0084
        L_0x007b:
            r1 = move-exception
            r4 = r1
            goto L_0x0084
        L_0x007e:
            goto L_0x009e
        L_0x007f:
            r1 = move-exception
            goto L_0x00a6
        L_0x0081:
            r1 = move-exception
            r4 = r1
            r5 = r2
        L_0x0084:
            java.lang.String r1 = "DynamiteLoaderV2CL"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r6.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r7 = "Failed to enumerate thread/threadgroup "
            r6.append(r7)     // Catch:{ all -> 0x007f }
            r6.append(r4)     // Catch:{ all -> 0x007f }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x007f }
            android.util.Log.w(r1, r4)     // Catch:{ all -> 0x007f }
        L_0x009e:
            monitor-exit(r3)     // Catch:{ all -> 0x007f }
        L_0x009f:
            zzb = r5     // Catch:{ all -> 0x00d7 }
            java.lang.Thread r1 = zzb     // Catch:{ all -> 0x00d7 }
            if (r1 != 0) goto L_0x00a8
            goto L_0x00ce
        L_0x00a6:
            monitor-exit(r3)     // Catch:{ all -> 0x007f }
            throw r1     // Catch:{ all -> 0x00d7 }
        L_0x00a8:
            monitor-enter(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.Thread r3 = zzb     // Catch:{ SecurityException -> 0x00b2 }
            java.lang.ClassLoader r2 = r3.getContextClassLoader()     // Catch:{ SecurityException -> 0x00b2 }
            goto L_0x00cd
        L_0x00b0:
            r2 = move-exception
            goto L_0x00d1
        L_0x00b2:
            r3 = move-exception
            java.lang.String r4 = "DynamiteLoaderV2CL"
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r5.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = "Failed to get thread context classloader "
            r5.append(r6)     // Catch:{ all -> 0x00b0 }
            r5.append(r3)     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00b0 }
            android.util.Log.w(r4, r3)     // Catch:{ all -> 0x00b0 }
        L_0x00cd:
            monitor-exit(r1)     // Catch:{ all -> 0x00b0 }
        L_0x00ce:
            zza = r2     // Catch:{ all -> 0x00d7 }
            goto L_0x00d3
        L_0x00d1:
            monitor-exit(r1)     // Catch:{ all -> 0x00b0 }
            throw r2     // Catch:{ all -> 0x00d7 }
        L_0x00d3:
            java.lang.ClassLoader r1 = zza     // Catch:{ all -> 0x00d7 }
            monitor-exit(r0)
            return r1
        L_0x00d7:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.zzb.zza():java.lang.ClassLoader");
    }
}
