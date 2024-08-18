package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfy extends zzcfp implements zzcdu {
    public static final /* synthetic */ int zzd = 0;
    private zzcdv zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcfh zzi;
    private long zzj;
    private long zzk;

    public zzcfy(zzcee zzcee, zzced zzced) {
        super(zzcee);
        zzcgq zzcgq = new zzcgq(zzcee.getContext(), zzced, (zzcee) this.zzc.get(), (Integer) null);
        zzm.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcgq;
        this.zze.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(zzf.zzf(str)));
    }

    private static String zzd(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + DomExceptionUtils.SEPARATOR + canonicalName + ":" + message;
    }

    private final void zzx(long j) {
        zzt.zza.postDelayed(new zzcfx(this), j);
    }

    public final void release() {
        zzcdv zzcdv = this.zze;
        if (zzcdv != null) {
            zzcdv.zzL((zzcdu) null);
            this.zze.zzH();
        }
    }

    public final void zzD(int i, int i2) {
    }

    public final zzcdv zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL((zzcdu) null);
        zzcdv zzcdv = this.zze;
        this.zze = null;
        return zzcdv;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.google.android.gms.internal.ads.zzcfy} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: com.google.android.gms.internal.ads.zzcfy} */
    /* JADX WARNING: type inference failed for: r2v11, types: [boolean] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0110, code lost:
        r2.zzx(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzy)).longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0123, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x016b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016c, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzb() {
        /*
            r32 = this;
            r15 = r32
            java.lang.String r0 = r15.zzf
            java.lang.String r13 = zzc(r0)
            java.lang.String r17 = "error"
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzx     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0171 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ Exception -> 0x0171 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x0171 }
            long r0 = r0.longValue()     // Catch:{ Exception -> 0x0171 }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzw     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0171 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ Exception -> 0x0171 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0171 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0171 }
            long r11 = (long) r2     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzbR     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0171 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ Exception -> 0x0171 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0171 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0171 }
            monitor-enter(r32)     // Catch:{ Exception -> 0x0171 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x0166 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0166 }
            long r5 = r15.zzj     // Catch:{ all -> 0x0166 }
            long r3 = r3 - r5
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0140
            boolean r0 = r15.zzg     // Catch:{ all -> 0x0166 }
            if (r0 != 0) goto L_0x0130
            boolean r0 = r15.zzh     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x005a
            monitor-exit(r32)     // Catch:{ all -> 0x0166 }
            r2 = r15
            goto L_0x01ad
        L_0x005a:
            com.google.android.gms.internal.ads.zzcdv r0 = r15.zze     // Catch:{ all -> 0x0166 }
            boolean r0 = r0.zzV()     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x0124
            com.google.android.gms.internal.ads.zzcdv r0 = r15.zze     // Catch:{ all -> 0x0166 }
            long r9 = r0.zzz()     // Catch:{ all -> 0x0166 }
            r18 = 0
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzcdv r0 = r15.zze     // Catch:{ all -> 0x0166 }
            long r6 = r0.zzv()     // Catch:{ all -> 0x0166 }
            long r0 = r15.zzk     // Catch:{ all -> 0x0166 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x00dd
            int r0 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0081
            r0 = 1
            r8 = r0
            goto L_0x0083
        L_0x0081:
            r0 = 0
            r8 = r0
        L_0x0083:
            java.lang.String r0 = r15.zzf     // Catch:{ all -> 0x00d8 }
            r3 = -1
            if (r2 == 0) goto L_0x0090
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r20 = r1.zzA()     // Catch:{ all -> 0x0166 }
            goto L_0x0092
        L_0x0090:
            r20 = r3
        L_0x0092:
            if (r2 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r22 = r1.zzx()     // Catch:{ all -> 0x0166 }
            goto L_0x009d
        L_0x009b:
            r22 = r3
        L_0x009d:
            if (r2 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r1 = r1.zzB()     // Catch:{ all -> 0x0166 }
            r24 = r1
            goto L_0x00aa
        L_0x00a8:
            r24 = r3
        L_0x00aa:
            int r16 = com.google.android.gms.internal.ads.zzcdv.zzs()     // Catch:{ all -> 0x00d8 }
            int r26 = com.google.android.gms.internal.ads.zzcdv.zzu()     // Catch:{ all -> 0x00d8 }
            r1 = r32
            r2 = r0
            r3 = r13
            r4 = r6
            r27 = r6
            r6 = r9
            r29 = r9
            r9 = r20
            r20 = r11
            r11 = r22
            r31 = r13
            r13 = r24
            r15 = r16
            r16 = r26
            r1.zzo(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x00d4 }
            r2 = r32
            r0 = r27
            r2.zzk = r0     // Catch:{ all -> 0x00f5 }
            goto L_0x00e5
        L_0x00d4:
            r0 = move-exception
            r2 = r32
            goto L_0x00f6
        L_0x00d8:
            r0 = move-exception
            r31 = r13
            r2 = r15
            goto L_0x00f6
        L_0x00dd:
            r0 = r6
            r29 = r9
            r20 = r11
            r31 = r13
            r2 = r15
        L_0x00e5:
            r3 = r29
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00fa
            java.lang.String r0 = r2.zzf     // Catch:{ all -> 0x00f5 }
            r5 = r31
            r2.zzj(r0, r5, r3)     // Catch:{ all -> 0x0164 }
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            goto L_0x01ad
        L_0x00f5:
            r0 = move-exception
        L_0x00f6:
            r5 = r31
            goto L_0x0169
        L_0x00fa:
            r5 = r31
            com.google.android.gms.internal.ads.zzcdv r3 = r2.zze     // Catch:{ all -> 0x0164 }
            long r3 = r3.zzw()     // Catch:{ all -> 0x0164 }
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 < 0) goto L_0x010f
            int r0 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010f
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            goto L_0x01ad
        L_0x010d:
            r5 = r13
            r2 = r15
        L_0x010f:
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzy
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.zzx(r0)
            return
        L_0x0124:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013c }
            java.lang.String r3 = "ExoPlayer was released during preloading."
            r0.<init>(r3)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ all -> 0x013c }
        L_0x0130:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013c }
            java.lang.String r3 = "Abort requested before buffering finished. "
            r0.<init>(r3)     // Catch:{ all -> 0x013c }
            throw r0     // Catch:{ all -> 0x013c }
        L_0x013c:
            r0 = move-exception
            r17 = r1
            goto L_0x0169
        L_0x0140:
            r5 = r13
            r2 = r15
            java.lang.String r3 = "downloadTimeout"
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r6.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r7 = "Timeout reached. Limit: "
            r6.append(r7)     // Catch:{ all -> 0x0160 }
            r6.append(r0)     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = " ms"
            r6.append(r0)     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0160 }
            r4.<init>(r0)     // Catch:{ all -> 0x0160 }
            throw r4     // Catch:{ all -> 0x0160 }
        L_0x0160:
            r0 = move-exception
            r17 = r3
            goto L_0x0169
        L_0x0164:
            r0 = move-exception
            goto L_0x0169
        L_0x0166:
            r0 = move-exception
            r5 = r13
            r2 = r15
        L_0x0169:
            monitor-exit(r32)     // Catch:{ all -> 0x016f }
            throw r0     // Catch:{ Exception -> 0x016b }
        L_0x016b:
            r0 = move-exception
            r1 = r17
            goto L_0x0176
        L_0x016f:
            r0 = move-exception
            goto L_0x0169
        L_0x0171:
            r0 = move-exception
            r5 = r13
            r2 = r15
            r1 = r17
        L_0x0176:
            java.lang.String r3 = r2.zzf
            java.lang.String r4 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to preload url "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " Exception: "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)
            java.lang.String r3 = "VideoStreamExoPlayerCache.preload"
            com.google.android.gms.internal.ads.zzcby r4 = com.google.android.gms.ads.internal.zzu.zzo()
            r4.zzv(r0, r3)
            r32.release()
            java.lang.String r0 = zzd(r1, r0)
            java.lang.String r3 = r2.zzf
            r2.zzg(r3, r5, r1, r0)
        L_0x01ad:
            com.google.android.gms.internal.ads.zzcfi r0 = com.google.android.gms.ads.internal.zzu.zzy()
            com.google.android.gms.internal.ads.zzcfh r1 = r2.zzi
            r0.zzc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfy.zzb():void");
    }

    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    public final void zzi(boolean z, long j) {
        zzcee zzcee = (zzcee) this.zzc.get();
        if (zzcee != null) {
            zzcci.zze.execute(new zzcfw(zzcee, z, j));
        }
    }

    public final void zzk(String str, Exception exc) {
        zzm.zzk("Precache error", exc);
        zzu.zzo().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    public final void zzl(String str, Exception exc) {
        zzm.zzk("Precache exception", exc);
        zzu.zzo().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    public final void zzm(int i) {
    }

    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ce, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        r5 = r45;
        r6 = r46;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.zzj(r6, r7, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01cd, code lost:
        r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzu(java.lang.String r46, java.lang.String[] r47) {
        /*
            r45 = this;
            r15 = r45
            r13 = r46
            r0 = r47
            r15.zzf = r13
            java.lang.String r17 = "error"
            java.lang.String r14 = zzc(r46)
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d3 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d3 }
            r2 = r18
        L_0x0015:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d3 }
            if (r2 >= r3) goto L_0x0023
            r3 = r0[r2]     // Catch:{ Exception -> 0x01d3 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01d3 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01d3 }
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0023:
            com.google.android.gms.internal.ads.zzcdv r0 = r15.zze     // Catch:{ Exception -> 0x01d3 }
            java.lang.String r2 = r15.zzb     // Catch:{ Exception -> 0x01d3 }
            r0.zzF(r1, r2)     // Catch:{ Exception -> 0x01d3 }
            java.lang.ref.WeakReference r0 = r15.zzc     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzcee r0 = (com.google.android.gms.internal.ads.zzcee) r0     // Catch:{ Exception -> 0x01d3 }
            if (r0 == 0) goto L_0x0037
            r0.zzt(r14, r15)     // Catch:{ Exception -> 0x01d3 }
        L_0x0037:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x01d3 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzy     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ Exception -> 0x01d3 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d3 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzx     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ Exception -> 0x01d3 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d3 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d3 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzw     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ Exception -> 0x01d3 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d3 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d3 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzbR     // Catch:{ Exception -> 0x01d3 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x01d3 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ Exception -> 0x01d3 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d3 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d3 }
            r22 = -1
            r1 = r22
        L_0x0088:
            monitor-enter(r45)     // Catch:{ Exception -> 0x01d3 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01c7 }
            long r3 = r3 - r19
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x019c
            boolean r3 = r15.zzg     // Catch:{ all -> 0x01c7 }
            if (r3 != 0) goto L_0x018f
            boolean r3 = r15.zzh     // Catch:{ all -> 0x01c7 }
            r24 = 1
            if (r3 == 0) goto L_0x00a1
            monitor-exit(r45)     // Catch:{ all -> 0x01c7 }
            r5 = r15
            goto L_0x0157
        L_0x00a1:
            com.google.android.gms.internal.ads.zzcdv r3 = r15.zze     // Catch:{ all -> 0x01c7 }
            boolean r3 = r3.zzV()     // Catch:{ all -> 0x01c7 }
            if (r3 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zzcdv r3 = r15.zze     // Catch:{ all -> 0x01c7 }
            long r4 = r3.zzz()     // Catch:{ all -> 0x01c7 }
            r25 = 0
            int r3 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x0159
            com.google.android.gms.internal.ads.zzcdv r3 = r15.zze     // Catch:{ all -> 0x01c7 }
            long r27 = r3.zzv()     // Catch:{ all -> 0x01c7 }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0127
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c6
            r8 = r24
            goto L_0x00c8
        L_0x00c6:
            r8 = r18
        L_0x00c8:
            if (r21 == 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x01c7 }
            long r1 = r1.zzA()     // Catch:{ all -> 0x01c7 }
            r29 = r1
            goto L_0x00d5
        L_0x00d3:
            r29 = r22
        L_0x00d5:
            if (r21 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x01c7 }
            long r1 = r1.zzx()     // Catch:{ all -> 0x01c7 }
            r31 = r1
            goto L_0x00e2
        L_0x00e0:
            r31 = r22
        L_0x00e2:
            if (r21 == 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzcdv r1 = r15.zze     // Catch:{ all -> 0x01c7 }
            long r1 = r1.zzB()     // Catch:{ all -> 0x01c7 }
            r33 = r1
            goto L_0x00ef
        L_0x00ed:
            r33 = r22
        L_0x00ef:
            int r16 = com.google.android.gms.internal.ads.zzcdv.zzs()     // Catch:{ all -> 0x011c }
            int r35 = com.google.android.gms.internal.ads.zzcdv.zzu()     // Catch:{ all -> 0x011c }
            r1 = r45
            r2 = r46
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zzo(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x011a }
            r1 = r27
            goto L_0x0131
        L_0x011a:
            r0 = move-exception
            goto L_0x011f
        L_0x011c:
            r0 = move-exception
            r44 = r14
        L_0x011f:
            r5 = r45
            r6 = r46
            r7 = r44
            goto L_0x01cb
        L_0x0127:
            r36 = r4
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
        L_0x0131:
            r3 = r36
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0142
            r5 = r45
            r6 = r46
            r7 = r44
            r5.zzj(r6, r7, r3)     // Catch:{ all -> 0x01c5 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c5 }
            goto L_0x0157
        L_0x0142:
            r5 = r45
            r6 = r46
            r7 = r44
            com.google.android.gms.internal.ads.zzcdv r3 = r5.zze     // Catch:{ all -> 0x01c5 }
            long r3 = r3.zzw()     // Catch:{ all -> 0x01c5 }
            int r3 = (r3 > r38 ? 1 : (r3 == r38 ? 0 : -1))
            if (r3 < 0) goto L_0x0162
            int r3 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x0158
            monitor-exit(r45)     // Catch:{ all -> 0x01c5 }
        L_0x0157:
            return r24
        L_0x0158:
            goto L_0x0163
        L_0x0159:
            r38 = r6
            r40 = r9
            r42 = r11
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x0162:
        L_0x0163:
            r3 = r42
            r5.wait(r3)     // Catch:{ InterruptedException -> 0x0173 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c5 }
            r11 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x0088
        L_0x0173:
            r0 = move-exception
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x017e }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x017e }
            throw r0     // Catch:{ all -> 0x017e }
        L_0x017e:
            r0 = move-exception
            r17 = r1
            goto L_0x01cb
        L_0x0182:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c1 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x018f:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c1 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x019c:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c1 }
            r2.<init>()     // Catch:{ all -> 0x01c1 }
            java.lang.String r3 = "Timeout reached. Limit: "
            r2.append(r3)     // Catch:{ all -> 0x01c1 }
            r3 = r40
            r2.append(r3)     // Catch:{ all -> 0x01c1 }
            java.lang.String r3 = " ms"
            r2.append(r3)     // Catch:{ all -> 0x01c1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01c1 }
            r0.<init>(r2)     // Catch:{ all -> 0x01c1 }
            throw r0     // Catch:{ all -> 0x01c1 }
        L_0x01c1:
            r0 = move-exception
            r17 = r1
            goto L_0x01cb
        L_0x01c5:
            r0 = move-exception
            goto L_0x01cb
        L_0x01c7:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01cb:
            monitor-exit(r45)     // Catch:{ all -> 0x01d1 }
            throw r0     // Catch:{ Exception -> 0x01cd }
        L_0x01cd:
            r0 = move-exception
            r1 = r17
            goto L_0x01d9
        L_0x01d1:
            r0 = move-exception
            goto L_0x01cb
        L_0x01d3:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
            r1 = r17
        L_0x01d9:
            java.lang.String r2 = r0.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to preload url "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Exception: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r2)
            java.lang.String r2 = "VideoStreamExoPlayerCache.preload"
            com.google.android.gms.internal.ads.zzcby r3 = com.google.android.gms.ads.internal.zzu.zzo()
            r3.zzv(r0, r2)
            r45.release()
            java.lang.String r0 = zzd(r1, r0)
            r5.zzg(r6, r7, r1, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfy.zzu(java.lang.String, java.lang.String[]):boolean");
    }

    public final void zzv() {
        zzm.zzj("Precache onRenderedFirstFrame");
    }

    public final boolean zzw(String str, String[] strArr, zzcfh zzcfh) {
        this.zzf = str;
        this.zzi = zzcfh;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcee zzcee = (zzcee) this.zzc.get();
            if (zzcee != null) {
                zzcee.zzt(zzc, this);
            }
            this.zzj = zzu.zzB().currentTimeMillis();
            this.zzk = -1;
            zzx(0);
            return true;
        } catch (Exception e) {
            zzm.zzj("Failed to preload url " + str + " Exception: " + e.getMessage());
            zzu.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, "error", zzd("error", e));
            return false;
        }
    }
}
