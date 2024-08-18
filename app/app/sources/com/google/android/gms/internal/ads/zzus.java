package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzus implements zzvm, zzvl {
    public final zzvm zza;
    long zzb;
    private zzvl zzc;
    private zzur[] zzd = new zzur[0];
    private long zze = 0;

    public zzus(zzvm zzvm, boolean z, long j, long j2) {
        this.zza = zzvm;
        this.zzb = j2;
    }

    public final long zza(long j, zzmr zzmr) {
        long j2;
        if (j == 0) {
            return 0;
        }
        long max = Math.max(0, Math.min(zzmr.zzf, j));
        long j3 = zzmr.zzg;
        long j4 = this.zzb;
        if (j4 == Long.MIN_VALUE) {
            j2 = Long.MAX_VALUE;
        } else {
            j2 = j4 - j;
        }
        long max2 = Math.max(0, Math.min(j3, j2));
        if (!(max == zzmr.zzf && max2 == zzmr.zzg)) {
            zzmr = new zzmr(max, max2);
        }
        return this.zza.zza(j, zzmr);
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzb2 < j) {
                return zzb2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzc2 < j) {
                return zzc2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzd() {
        boolean z;
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long zzd2 = zzd();
            return zzd2 != -9223372036854775807L ? zzd2 : j;
        }
        long zzd3 = this.zza.zzd();
        if (zzd3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = false;
        if (zzd3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        long j2 = this.zzb;
        if (j2 == Long.MIN_VALUE) {
            z2 = true;
        } else if (zzd3 <= j2) {
            z2 = true;
        }
        zzeq.zzf(z2);
        return zzd3;
    }

    public final long zze(long j) {
        this.zze = -9223372036854775807L;
        boolean z = false;
        for (zzur zzur : this.zzd) {
            if (zzur != null) {
                zzur.zzc();
            }
        }
        long zze2 = this.zza.zze(j);
        if (zze2 != j) {
            if (zze2 >= 0) {
                long j2 = this.zzb;
                if (j2 != Long.MIN_VALUE) {
                    if (zze2 <= j2) {
                        z = true;
                    }
                }
            }
            zzeq.zzf(z);
            return zze2;
        }
        z = true;
        zzeq.zzf(z);
        return zze2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r4 > r6) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzzg[] r15, boolean[] r16, com.google.android.gms.internal.ads.zzxf[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            int r2 = r1.length
            com.google.android.gms.internal.ads.zzur[] r3 = new com.google.android.gms.internal.ads.zzur[r2]
            r0.zzd = r3
            com.google.android.gms.internal.ads.zzxf[] r2 = new com.google.android.gms.internal.ads.zzxf[r2]
            r3 = 0
            r4 = r3
        L_0x000c:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L_0x0023
            com.google.android.gms.internal.ads.zzur[] r5 = r0.zzd
            r6 = r1[r4]
            com.google.android.gms.internal.ads.zzur r6 = (com.google.android.gms.internal.ads.zzur) r6
            r5[r4] = r6
            if (r6 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzxf r11 = r6.zza
            goto L_0x001e
        L_0x001d:
        L_0x001e:
            r2[r4] = r11
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0023:
            com.google.android.gms.internal.ads.zzvm r4 = r0.zza
            r5 = r15
            r6 = r16
            r7 = r2
            r8 = r18
            r9 = r19
            long r4 = r4.zzf(r5, r6, r7, r8, r9)
            boolean r6 = r14.zzq()
            r7 = 0
            if (r6 == 0) goto L_0x003f
            int r6 = (r19 > r7 ? 1 : (r19 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x003f
            r9 = r7
            goto L_0x0042
        L_0x003f:
            r9 = r19
        L_0x0042:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zze = r12
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            r9 = 1
            if (r6 == 0) goto L_0x0061
            int r6 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x005f
            long r6 = r0.zzb
            r12 = -9223372036854775808
            int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0061
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r9 = r3
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            com.google.android.gms.internal.ads.zzeq.zzf(r9)
        L_0x0065:
            int r6 = r1.length
            if (r3 >= r6) goto L_0x008b
            r6 = r2[r3]
            if (r6 != 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzur[] r6 = r0.zzd
            r6[r3] = r11
            goto L_0x0082
        L_0x0071:
            com.google.android.gms.internal.ads.zzur[] r7 = r0.zzd
            r8 = r7[r3]
            if (r8 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzxf r8 = r8.zza
            if (r8 == r6) goto L_0x0082
        L_0x007b:
            com.google.android.gms.internal.ads.zzur r8 = new com.google.android.gms.internal.ads.zzur
            r8.<init>(r14, r6)
            r7[r3] = r8
        L_0x0082:
            com.google.android.gms.internal.ads.zzur[] r6 = r0.zzd
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x0065
        L_0x008b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzus.zzf(com.google.android.gms.internal.ads.zzzg[], boolean[], com.google.android.gms.internal.ads.zzxf[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxh zzxh) {
        zzvm zzvm = (zzvm) zzxh;
        zzvl zzvl = this.zzc;
        if (zzvl != null) {
            zzvl.zzg(this);
            return;
        }
        throw null;
    }

    public final zzxr zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzvl zzvl, long j) {
        this.zzc = zzvl;
        this.zza.zzl(this, j);
    }

    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    public final boolean zzo(zzlo zzlo) {
        return this.zza.zzo(zzlo);
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }

    public final void zzi(zzvm zzvm) {
        zzvl zzvl = this.zzc;
        if (zzvl != null) {
            zzvl.zzi(this);
            return;
        }
        throw null;
    }
}
