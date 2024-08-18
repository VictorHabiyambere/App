package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakw implements zzald {
    private final zzalc zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzali zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzakw(zzali zzali, long j, long j2, long j3, long j4, boolean z) {
        boolean z2;
        if (j < 0 || j2 <= j) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzeq.zzd(z2);
        this.zzd = zzali;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzalc();
    }

    public final /* bridge */ /* synthetic */ zzaet zze() {
        if (this.zzf != 0) {
            return new zzakv(this, (zzaku) null);
        }
        return null;
    }

    public final void zzg(long j) {
        this.zzh = Math.max(0, Math.min(j, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        r0.zza.zzc(r1, -1);
        r0.zza.zzb(r1, false);
        r2 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        if (r2.zzb <= r0.zzh) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
        r25.zzj();
        r0.zze = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c6, code lost:
        return -(r0.zzk + 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        ((com.google.android.gms.internal.ads.zzadi) r1).zzo(r2.zzd + r2.zze, false);
        r0.zzi = r25.zzf();
        r0.zzk = r0.zza.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f4, code lost:
        r0.zza.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ff, code lost:
        if (r0.zza.zzc(r1, -1) == false) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0101, code lost:
        r0.zza.zzb(r1, false);
        r2 = r0.zza;
        ((com.google.android.gms.internal.ads.zzadi) r1).zzo(r2.zzd + r2.zze, false);
        r2 = r0.zza.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0117, code lost:
        r4 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011c, code lost:
        if ((r4.zza & 4) == 4) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0122, code lost:
        if (r4.zzc(r1, -1) == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012c, code lost:
        if (r25.zzf() >= r0.zzc) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0134, code lost:
        if (r0.zza.zzb(r1, true) == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0136, code lost:
        r4 = r0.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0141, code lost:
        if (com.google.android.gms.internal.ads.zzady.zze(r1, r4.zzd + r4.zze) != false) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0144, code lost:
        r2 = r0.zza.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0149, code lost:
        r0.zzf = r2;
        r0.zze = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014f, code lost:
        return r0.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0155, code lost:
        throw new java.io.EOFException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzadv r25) throws java.io.IOException {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            int r2 = r0.zze
            r5 = 1
            r6 = 4
            r7 = 0
            r8 = -1
            switch(r2) {
                case 0: goto L_0x00e1;
                case 1: goto L_0x00f4;
                case 2: goto L_0x000f;
                case 3: goto L_0x00a7;
                default: goto L_0x000e;
            }
        L_0x000e:
            return r8
        L_0x000f:
            long r10 = r0.zzi
            long r12 = r0.zzj
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x001a
            r12 = r8
            goto L_0x009f
        L_0x001a:
            long r10 = r25.zzf()
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            boolean r2 = r2.zzc(r1, r12)
            if (r2 != 0) goto L_0x0036
            long r12 = r0.zzi
            int r2 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x002e
            goto L_0x009f
        L_0x002e:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0036:
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            r2.zzb(r1, r7)
            r25.zzj()
            long r12 = r0.zzh
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            long r14 = r2.zzb
            long r12 = r12 - r14
            int r5 = r2.zzd
            int r2 = r2.zze
            int r5 = r5 + r2
            r16 = 0
            int r2 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r2 < 0) goto L_0x0059
            r16 = 72000(0x11940, double:3.55727E-319)
            int r16 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r16 >= 0) goto L_0x0059
            r12 = r8
            goto L_0x009f
        L_0x0059:
            if (r2 >= 0) goto L_0x0060
            r0.zzj = r10
            r0.zzl = r14
            goto L_0x006b
        L_0x0060:
            long r10 = (long) r5
            long r16 = r25.zzf()
            long r10 = r16 + r10
            r0.zzi = r10
            r0.zzk = r14
        L_0x006b:
            long r10 = r0.zzj
            long r14 = r0.zzi
            long r16 = r10 - r14
            r18 = 100000(0x186a0, double:4.94066E-319)
            int r18 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r18 >= 0) goto L_0x007c
            r0.zzj = r14
            r12 = r14
            goto L_0x009f
        L_0x007c:
            long r3 = (long) r5
            if (r2 > 0) goto L_0x0082
            r20 = 2
            goto L_0x0084
        L_0x0082:
            r20 = 1
        L_0x0084:
            long r22 = r25.zzf()
            long r3 = r3 * r20
            long r22 = r22 - r3
            long r12 = r12 * r16
            long r2 = r0.zzl
            long r4 = r0.zzk
            long r2 = r2 - r4
            long r12 = r12 / r2
            long r2 = r22 + r12
            long r10 = r10 + r8
            long r2 = java.lang.Math.min(r2, r10)
            long r12 = java.lang.Math.max(r14, r2)
        L_0x009f:
            int r2 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00a4
            return r12
        L_0x00a4:
            r2 = 3
            r0.zze = r2
        L_0x00a7:
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            r2.zzc(r1, r8)
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            r2.zzb(r1, r7)
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            long r3 = r2.zzb
            long r10 = r0.zzh
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c7
            r25.zzj()
            r0.zze = r6
            long r1 = r0.zzk
            r3 = 2
            long r1 = r1 + r3
            long r1 = -r1
            return r1
        L_0x00c7:
            r3 = 2
            int r5 = r2.zzd
            int r2 = r2.zze
            int r5 = r5 + r2
            r2 = r1
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzo(r5, r7)
            long r10 = r25.zzf()
            r0.zzi = r10
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            long r10 = r2.zzb
            r0.zzk = r10
            goto L_0x00a7
        L_0x00e1:
            long r2 = r25.zzf()
            r0.zzg = r2
            r0.zze = r5
            long r10 = r0.zzc
            r12 = -65307(0xffffffffffff00e5, double:NaN)
            long r10 = r10 + r12
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f4
            return r10
        L_0x00f4:
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            boolean r2 = r2.zzc(r1, r8)
            if (r2 == 0) goto L_0x0150
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            r2.zzb(r1, r7)
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            int r3 = r2.zzd
            int r2 = r2.zze
            int r3 = r3 + r2
            r2 = r1
            com.google.android.gms.internal.ads.zzadi r2 = (com.google.android.gms.internal.ads.zzadi) r2
            r2.zzo(r3, r7)
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            long r2 = r2.zzb
        L_0x0117:
            com.google.android.gms.internal.ads.zzalc r4 = r0.zza
            int r7 = r4.zza
            r7 = r7 & r6
            if (r7 == r6) goto L_0x0149
            boolean r4 = r4.zzc(r1, r8)
            if (r4 == 0) goto L_0x0149
            long r10 = r25.zzf()
            long r12 = r0.zzc
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 >= 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzalc r4 = r0.zza
            boolean r4 = r4.zzb(r1, r5)
            if (r4 == 0) goto L_0x0149
            com.google.android.gms.internal.ads.zzalc r4 = r0.zza
            int r7 = r4.zzd
            int r4 = r4.zze
            int r7 = r7 + r4
            boolean r4 = com.google.android.gms.internal.ads.zzady.zze(r1, r7)
            if (r4 != 0) goto L_0x0144
            goto L_0x0149
        L_0x0144:
            com.google.android.gms.internal.ads.zzalc r2 = r0.zza
            long r2 = r2.zzb
            goto L_0x0117
        L_0x0149:
            r0.zzf = r2
            r0.zze = r6
            long r1 = r0.zzg
            return r1
        L_0x0150:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakw.zzd(com.google.android.gms.internal.ads.zzadv):long");
    }
}
