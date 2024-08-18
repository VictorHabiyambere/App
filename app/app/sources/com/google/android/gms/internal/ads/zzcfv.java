package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfv extends zzcfp implements zzie {
    private String zzd;
    private final zzced zze;
    private boolean zzf;
    private final zzcfu zzg = new zzcfu();
    private final zzcfa zzh = new zzcfa();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcfv(zzcee zzcee, zzced zzced) {
        super(zzcee);
        String str;
        this.zze = zzced;
        if (zzcee != null) {
            str = zzcee.zzr();
        } else {
            str = null;
        }
        this.zzl = (String) zzfyb.zzd(str).zzb("");
        this.zzm = zzcee != null ? zzcee.zzf() : 0;
    }

    protected static final String zzm(String str) {
        return "cache:".concat(String.valueOf(zzf.zzf(str)));
    }

    private final void zzv() {
        boolean z;
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(((float) zza2) * (((float) position) / ((float) zza)));
        int zzs = zzcdv.zzs();
        int zzu = zzcdv.zzu();
        String str = this.zzd;
        String zzm2 = zzm(str);
        long j = (long) round;
        if (round > 0) {
            z = true;
        } else {
            z = false;
        }
        zzn(str, zzm2, position, zza, j, (long) zza2, z, zzs, zzu);
    }

    public final void zza(zzhb zzhb, zzhh zzhh, boolean z, int i) {
    }

    public final void zzb(zzhb zzhb, zzhh zzhh, boolean z) {
    }

    public final void zzc(zzhb zzhb, zzhh zzhh, boolean z) {
    }

    public final void zzd(zzhb zzhb, zzhh zzhh, boolean z) {
        if (zzhb instanceof zzhp) {
            this.zzg.zzb((zzhp) zzhb);
        }
    }

    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.google.android.gms.internal.ads.zzhp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.google.android.gms.internal.ads.zzhp} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.google.android.gms.internal.ads.zzcey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.google.android.gms.internal.ads.zzhp} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d8, code lost:
        if (r1.zzi.remaining() > 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
        zzv();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e2, code lost:
        if (r1.zzf != false) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e4, code lost:
        r5 = r0.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ec, code lost:
        if ((r5 - r16) < r10) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ee, code lost:
        zzv();
        r16 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fc, code lost:
        if ((r5 - r7) > (1000 * r12)) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0122, code lost:
        throw new java.io.IOException("Timeout exceeded. Limit: " + r12 + " sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0123, code lost:
        r3 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0146, code lost:
        throw new java.io.IOException("Precache abort at " + r1.zzi.limit() + " bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0147, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0149, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r1.zzd = r2
            java.lang.String r3 = "error"
            java.lang.String r4 = zzm(r22)
            r5 = 0
            com.google.android.gms.internal.ads.zzhk r0 = new com.google.android.gms.internal.ads.zzhk     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r6 = r1.zzb     // Catch:{ Exception -> 0x0152 }
            r0.zzf(r6)     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzced r6 = r1.zze     // Catch:{ Exception -> 0x0152 }
            int r6 = r6.zzd     // Catch:{ Exception -> 0x0152 }
            r0.zzc(r6)     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzced r6 = r1.zze     // Catch:{ Exception -> 0x0152 }
            int r6 = r6.zzf     // Catch:{ Exception -> 0x0152 }
            r0.zzd(r6)     // Catch:{ Exception -> 0x0152 }
            r6 = 1
            r0.zzb(r6)     // Catch:{ Exception -> 0x0152 }
            r0.zze(r1)     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzhp r9 = r0.zza()     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzced r0 = r1.zze     // Catch:{ Exception -> 0x0152 }
            boolean r0 = r0.zzj     // Catch:{ Exception -> 0x0152 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzcey r0 = new com.google.android.gms.internal.ads.zzcey     // Catch:{ Exception -> 0x0152 }
            android.content.Context r8 = r1.zza     // Catch:{ Exception -> 0x0152 }
            java.lang.String r10 = r1.zzl     // Catch:{ Exception -> 0x0152 }
            int r11 = r1.zzm     // Catch:{ Exception -> 0x0152 }
            r12 = 0
            r13 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0152 }
            r9 = r0
        L_0x0045:
            android.net.Uri r11 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzhh r0 = new com.google.android.gms.internal.ads.zzhh     // Catch:{ Exception -> 0x0152 }
            r12 = 0
            r14 = -1
            r16 = 0
            r10 = r0
            r10.<init>(r11, r12, r14, r16)     // Catch:{ Exception -> 0x0152 }
            r9.zzb(r0)     // Catch:{ Exception -> 0x0152 }
            java.lang.ref.WeakReference r0 = r1.zzc     // Catch:{ Exception -> 0x0152 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzcee r0 = (com.google.android.gms.internal.ads.zzcee) r0     // Catch:{ Exception -> 0x0152 }
            if (r0 == 0) goto L_0x0065
            r0.zzt(r4, r1)     // Catch:{ Exception -> 0x0152 }
        L_0x0065:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0152 }
            long r7 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzbeg r10 = com.google.android.gms.internal.ads.zzbep.zzy     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzben r11 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0152 }
            java.lang.Object r10 = r11.zza(r10)     // Catch:{ Exception -> 0x0152 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ Exception -> 0x0152 }
            long r10 = r10.longValue()     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzbeg r12 = com.google.android.gms.internal.ads.zzbep.zzx     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzben r13 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0152 }
            java.lang.Object r12 = r13.zza(r12)     // Catch:{ Exception -> 0x0152 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ Exception -> 0x0152 }
            long r12 = r12.longValue()     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzced r14 = r1.zze     // Catch:{ Exception -> 0x0152 }
            int r14 = r14.zzc     // Catch:{ Exception -> 0x0152 }
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r14)     // Catch:{ Exception -> 0x0152 }
            r1.zzi = r14     // Catch:{ Exception -> 0x0152 }
            r14 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r14]     // Catch:{ Exception -> 0x0152 }
            r16 = r7
        L_0x009d:
            java.nio.ByteBuffer r6 = r1.zzi     // Catch:{ Exception -> 0x0152 }
            int r6 = r6.remaining()     // Catch:{ Exception -> 0x0152 }
            int r6 = java.lang.Math.min(r6, r14)     // Catch:{ Exception -> 0x0152 }
            int r6 = r9.zza(r15, r5, r6)     // Catch:{ Exception -> 0x0152 }
            r14 = -1
            if (r6 != r14) goto L_0x00bf
            r0 = 1
            r1.zzn = r0     // Catch:{ Exception -> 0x0152 }
            com.google.android.gms.internal.ads.zzcfa r0 = r1.zzh     // Catch:{ Exception -> 0x0152 }
            java.nio.ByteBuffer r6 = r1.zzi     // Catch:{ Exception -> 0x0152 }
            long r6 = r0.zza(r6)     // Catch:{ Exception -> 0x0152 }
            int r0 = (int) r6     // Catch:{ Exception -> 0x0152 }
            long r6 = (long) r0     // Catch:{ Exception -> 0x0152 }
            r1.zzj(r2, r4, r6)     // Catch:{ Exception -> 0x0152 }
            goto L_0x00dd
        L_0x00bf:
            java.lang.Object r14 = r1.zzk     // Catch:{ Exception -> 0x0152 }
            monitor-enter(r14)     // Catch:{ Exception -> 0x0152 }
            boolean r5 = r1.zzf     // Catch:{ all -> 0x014d }
            if (r5 != 0) goto L_0x00cf
            java.nio.ByteBuffer r5 = r1.zzi     // Catch:{ all -> 0x014d }
            r18 = r3
            r3 = 0
            r5.put(r15, r3, r6)     // Catch:{ all -> 0x014b }
            goto L_0x00d1
        L_0x00cf:
            r18 = r3
        L_0x00d1:
            monitor-exit(r14)     // Catch:{ all -> 0x014b }
            java.nio.ByteBuffer r3 = r1.zzi     // Catch:{ Exception -> 0x0149 }
            int r3 = r3.remaining()     // Catch:{ Exception -> 0x0149 }
            if (r3 > 0) goto L_0x00df
            r21.zzv()     // Catch:{ Exception -> 0x0149 }
        L_0x00dd:
            r3 = 1
            return r3
        L_0x00df:
            r3 = 1
            boolean r5 = r1.zzf     // Catch:{ Exception -> 0x0149 }
            if (r5 != 0) goto L_0x0123
            long r5 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x0149 }
            long r19 = r5 - r16
            int r14 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r14 < 0) goto L_0x00f4
            r21.zzv()     // Catch:{ Exception -> 0x0149 }
            r16 = r5
            goto L_0x00f5
        L_0x00f4:
        L_0x00f5:
            long r5 = r5 - r7
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r12
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 > 0) goto L_0x0105
            r6 = r3
            r3 = r18
            r5 = 0
            r14 = 8192(0x2000, float:1.14794E-41)
            goto L_0x009d
        L_0x0105:
            java.lang.String r3 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
            r0.<init>()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r5 = "Timeout exceeded. Limit: "
            r0.append(r5)     // Catch:{ Exception -> 0x0147 }
            r0.append(r12)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r5 = " sec"
            r0.append(r5)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0147 }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ Exception -> 0x0147 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0147 }
            throw r5     // Catch:{ Exception -> 0x0147 }
        L_0x0123:
            java.lang.String r3 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0147 }
            java.nio.ByteBuffer r5 = r1.zzi     // Catch:{ Exception -> 0x0147 }
            int r5 = r5.limit()     // Catch:{ Exception -> 0x0147 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
            r6.<init>()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r7 = "Precache abort at "
            r6.append(r7)     // Catch:{ Exception -> 0x0147 }
            r6.append(r5)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r5 = " bytes"
            r6.append(r5)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0147 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0147 }
            throw r0     // Catch:{ Exception -> 0x0147 }
        L_0x0147:
            r0 = move-exception
            goto L_0x0157
        L_0x0149:
            r0 = move-exception
            goto L_0x0155
        L_0x014b:
            r0 = move-exception
            goto L_0x0150
        L_0x014d:
            r0 = move-exception
            r18 = r3
        L_0x0150:
            monitor-exit(r14)     // Catch:{ all -> 0x014b }
            throw r0     // Catch:{ Exception -> 0x0149 }
        L_0x0152:
            r0 = move-exception
            r18 = r3
        L_0x0155:
            r3 = r18
        L_0x0157:
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = ":"
            r6.append(r5)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to preload url "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r6 = " Exception: "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            r1.zzg(r2, r4, r3, r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfv.zzt(java.lang.String):boolean");
    }
}
