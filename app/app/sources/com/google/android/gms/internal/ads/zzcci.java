package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcci {
    public static final zzgge zza;
    public static final zzgge zzb;
    public static final zzgge zzc;
    public static final ScheduledExecutorService zzd = new zzccd(3, new zzcce("Schedule"));
    public static final zzgge zze = new zzcch(new zzccf(), (zzccg) null);
    public static final zzgge zzf = new zzcch(zzggk.zzb(), (zzccg) null);

    /* JADX WARNING: type inference failed for: r0v11, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v14, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: type inference failed for: r0v29, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Default"
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzfuu.zza()
            com.google.android.gms.internal.ads.zzcce r0 = new com.google.android.gms.internal.ads.zzcce
            r0.<init>(r1)
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool(r0)
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            goto L_0x00b0
        L_0x001a:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlm
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            if (r0 == 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlm
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzln
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            if (r0 == 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlo
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            if (r0 == 0) goto L_0x0098
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzln
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzln
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r4.zzb(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r4 = r2.intValue()
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r8 = new java.util.concurrent.LinkedBlockingQueue
            r8.<init>()
            com.google.android.gms.internal.ads.zzcce r9 = new com.google.android.gms.internal.ads.zzcce
            r9.<init>(r1)
            r5 = 10
            r2 = r0
            r2.<init>(r3, r4, r5, r7, r8, r9)
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzlo
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.allowCoreThreadTimeOut(r1)
            goto L_0x00b0
        L_0x0098:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.SynchronousQueue r8 = new java.util.concurrent.SynchronousQueue
            r8.<init>()
            com.google.android.gms.internal.ads.zzcce r9 = new com.google.android.gms.internal.ads.zzcce
            r9.<init>(r1)
            r3 = 2
            r4 = 2147483647(0x7fffffff, float:NaN)
            r5 = 10
            r2 = r0
            r2.<init>(r3, r4, r5, r7, r8, r9)
        L_0x00b0:
            com.google.android.gms.internal.ads.zzcch r1 = new com.google.android.gms.internal.ads.zzcch
            r2 = 0
            r1.<init>(r0, r2)
            zza = r1
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Loader"
            r3 = 1
            if (r0 == 0) goto L_0x00d0
            com.google.android.gms.internal.ads.zzfur r0 = com.google.android.gms.internal.ads.zzfuu.zza()
            com.google.android.gms.internal.ads.zzcce r4 = new com.google.android.gms.internal.ads.zzcce
            r4.<init>(r1)
            r1 = 5
            java.util.concurrent.ExecutorService r0 = r0.zzc(r1, r4, r3)
            goto L_0x00e9
        L_0x00d0:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzcce r11 = new com.google.android.gms.internal.ads.zzcce
            r11.<init>(r1)
            r5 = 5
            r6 = 5
            r7 = 10
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11)
            r0.allowCoreThreadTimeOut(r3)
        L_0x00e9:
            com.google.android.gms.internal.ads.zzcch r1 = new com.google.android.gms.internal.ads.zzcch
            r1.<init>(r0, r2)
            zzb = r1
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            java.lang.String r1 = "Activeview"
            if (r0 == 0) goto L_0x0106
            com.google.android.gms.internal.ads.zzfur r0 = com.google.android.gms.internal.ads.zzfuu.zza()
            com.google.android.gms.internal.ads.zzcce r4 = new com.google.android.gms.internal.ads.zzcce
            r4.<init>(r1)
            java.util.concurrent.ExecutorService r0 = r0.zzb(r4, r3)
            goto L_0x011f
        L_0x0106:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            com.google.android.gms.internal.ads.zzcce r11 = new com.google.android.gms.internal.ads.zzcce
            r11.<init>(r1)
            r5 = 1
            r6 = 1
            r7 = 10
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10, r11)
            r0.allowCoreThreadTimeOut(r3)
        L_0x011f:
            com.google.android.gms.internal.ads.zzcch r1 = new com.google.android.gms.internal.ads.zzcch
            r1.<init>(r0, r2)
            zzc = r1
            com.google.android.gms.internal.ads.zzccd r0 = new com.google.android.gms.internal.ads.zzccd
            com.google.android.gms.internal.ads.zzcce r1 = new com.google.android.gms.internal.ads.zzcce
            java.lang.String r3 = "Schedule"
            r1.<init>(r3)
            r3 = 3
            r0.<init>(r3, r1)
            zzd = r0
            com.google.android.gms.internal.ads.zzccf r0 = new com.google.android.gms.internal.ads.zzccf
            r0.<init>()
            com.google.android.gms.internal.ads.zzcch r1 = new com.google.android.gms.internal.ads.zzcch
            r1.<init>(r0, r2)
            zze = r1
            java.util.concurrent.Executor r0 = com.google.android.gms.internal.ads.zzggk.zzb()
            com.google.android.gms.internal.ads.zzcch r1 = new com.google.android.gms.internal.ads.zzcch
            r1.<init>(r0, r2)
            zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcci.<clinit>():void");
    }
}
