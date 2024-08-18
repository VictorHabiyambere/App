package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzabq {
    private final zzabp zza;
    private final zzabu zzb;
    private boolean zzc;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzf;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private boolean zzi;
    private float zzj = 1.0f;
    private zzer zzk = zzer.zza;

    public zzabq(Context context, zzabp zzabp, long j) {
        this.zza = zzabp;
        this.zzb = new zzabu(context);
    }

    private final void zzq(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        if (r12 > 100000) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        if (r3 >= r25) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        if (r0.zzc != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(long r19, long r21, long r23, long r25, boolean r27, com.google.android.gms.internal.ads.zzabo r28) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r21
            r5 = r28
            com.google.android.gms.internal.ads.zzabo.zzg(r28)
            long r6 = r0.zze
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0018
            r0.zze = r3
        L_0x0018:
            long r6 = r0.zzg
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzabu r6 = r0.zzb
            r6.zzd(r1)
            r0.zzg = r1
        L_0x0025:
            long r1 = r1 - r3
            float r6 = r0.zzj
            double r6 = (double) r6
            boolean r10 = r0.zzc
            double r1 = (double) r1
            double r1 = r1 / r6
            long r1 = (long) r1
            if (r10 == 0) goto L_0x003c
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = com.google.android.gms.internal.ads.zzgd.zzr(r6)
            long r6 = r6 - r23
            long r1 = r1 - r6
            goto L_0x003d
        L_0x003c:
        L_0x003d:
            r5.zza = r1
            long r1 = r28.zza
            long r6 = r0.zzh
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r10 = -30000(0xffffffffffff8ad0, double:NaN)
            r7 = 0
            if (r6 == 0) goto L_0x0052
            boolean r6 = r0.zzi
            if (r6 != 0) goto L_0x0052
            goto L_0x0082
        L_0x0052:
            int r6 = r0.zzd
            switch(r6) {
                case 0: goto L_0x007d;
                case 1: goto L_0x0081;
                case 2: goto L_0x0078;
                case 3: goto L_0x005d;
                default: goto L_0x0057;
            }
        L_0x0057:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x005d:
            long r12 = android.os.SystemClock.elapsedRealtime()
            long r12 = com.google.android.gms.internal.ads.zzgd.zzr(r12)
            long r14 = r0.zzf
            long r12 = r12 - r14
            boolean r6 = r0.zzc
            if (r6 == 0) goto L_0x0082
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0082
            r1 = 100000(0x186a0, double:4.94066E-319)
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0082
            goto L_0x0081
        L_0x0078:
            int r1 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r1 < 0) goto L_0x0082
            goto L_0x0081
        L_0x007d:
            boolean r1 = r0.zzc
            if (r1 == 0) goto L_0x0082
        L_0x0081:
            return r7
        L_0x0082:
            boolean r1 = r0.zzc
            r2 = 5
            if (r1 == 0) goto L_0x00f3
            long r12 = r0.zze
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x008e
            goto L_0x00f3
        L_0x008e:
            com.google.android.gms.internal.ads.zzabu r1 = r0.zzb
            long r12 = java.lang.System.nanoTime()
            long r14 = r28.zza
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 * r16
            long r14 = r14 + r12
            long r14 = r1.zza(r14)
            r5.zzb = r14
            long r14 = r28.zzb
            long r14 = r14 - r12
            long r14 = r14 / r16
            r5.zza = r14
            long r12 = r0.zzh
            int r1 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            r6 = 1
            if (r1 == 0) goto L_0x00bb
            boolean r1 = r0.zzi
            if (r1 != 0) goto L_0x00bb
            r7 = r6
            goto L_0x00bc
        L_0x00bb:
        L_0x00bc:
            com.google.android.gms.internal.ads.zzabp r1 = r0.zza
            long r8 = r28.zza
            r12 = -500000(0xfffffffffff85ee0, double:NaN)
            int r8 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r8 >= 0) goto L_0x00d6
            if (r27 != 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzabj r1 = (com.google.android.gms.internal.ads.zzabj) r1
            boolean r1 = r1.zzaP(r3, r7)
            if (r1 != 0) goto L_0x00d4
            goto L_0x00d6
        L_0x00d4:
            r1 = 4
            return r1
        L_0x00d6:
            long r3 = r28.zza
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x00e6
            if (r27 != 0) goto L_0x00e6
            if (r7 == 0) goto L_0x00e4
            r1 = 3
            return r1
        L_0x00e4:
            r1 = 2
            return r1
        L_0x00e6:
            long r3 = r28.zza
            r7 = 50000(0xc350, double:2.47033E-319)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x00f2
            return r2
        L_0x00f2:
            return r6
        L_0x00f3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabq.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzabo):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zzh = -9223372036854775807L;
    }

    public final void zzd() {
        zzq(0);
    }

    public final void zze(boolean z) {
        this.zzd = z ? 1 : 0;
    }

    public final void zzf() {
        zzq(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzgd.zzr(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzq(1);
        this.zzh = -9223372036854775807L;
    }

    public final void zzj(int i) {
        this.zzb.zzj(i);
    }

    public final void zzk(zzer zzer) {
        this.zzk = zzer;
    }

    public final void zzl(float f) {
        this.zzb.zzc(f);
    }

    public final void zzm(Surface surface) {
        this.zzb.zzi(surface);
        zzq(1);
    }

    public final void zzn(float f) {
        this.zzj = f;
        this.zzb.zze(f);
    }

    public final boolean zzo(boolean z) {
        boolean z2 = true;
        if (!z || this.zzd != 3) {
            if (this.zzh == -9223372036854775807L) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.zzh) {
                z2 = false;
            }
            return z2;
        }
        this.zzh = -9223372036854775807L;
        return z2;
    }

    public final boolean zzp() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzgd.zzr(SystemClock.elapsedRealtime());
        return i != 3;
    }
}
