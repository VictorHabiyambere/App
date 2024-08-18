package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajj implements zzaji {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzajj(long[] jArr, long[] jArr2, long j, long j2, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
    }

    public static zzajj zzb(long j, long j2, zzaen zzaen, zzfu zzfu) {
        int i;
        long j3 = j;
        zzaen zzaen2 = zzaen;
        zzfu zzfu2 = zzfu;
        zzfu2.zzL(10);
        int zzg = zzfu.zzg();
        if (zzg <= 0) {
            return null;
        }
        int i2 = zzaen2.zzd;
        long zzt = zzgd.zzt((long) zzg, ((long) (i2 >= 32000 ? 1152 : 576)) * AnimationKt.MillisToNanos, (long) i2, RoundingMode.FLOOR);
        int zzq = zzfu.zzq();
        int zzq2 = zzfu.zzq();
        int zzq3 = zzfu.zzq();
        zzfu2.zzL(2);
        long j4 = j2 + ((long) zzaen2.zzc);
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i3 = 0;
        long j5 = j2;
        while (i3 < zzq) {
            long j6 = zzt;
            jArr[i3] = (((long) i3) * zzt) / ((long) zzq);
            jArr2[i3] = Math.max(j5, j4);
            switch (zzq3) {
                case 1:
                    i = zzfu.zzm();
                    break;
                case 2:
                    i = zzfu.zzq();
                    break;
                case 3:
                    i = zzfu.zzo();
                    break;
                case 4:
                    i = zzfu.zzp();
                    break;
                default:
                    return null;
            }
            j5 += ((long) i) * ((long) zzq2);
            i3++;
            zzaen zzaen3 = zzaen;
            zzfu zzfu3 = zzfu;
            zzt = j6;
            zzq = zzq;
        }
        long j7 = zzt;
        if (!(j3 == -1 || j3 == j5)) {
            zzfk.zzf("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j5);
        }
        return new zzajj(jArr, jArr2, j7, j5, zzaen.zzf);
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zze;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final long zze(long j) {
        return this.zza[zzgd.zzc(this.zzb, j, true, true)];
    }

    public final zzaer zzg(long j) {
        long[] jArr = this.zza;
        int zzc2 = zzgd.zzc(jArr, j, true, true);
        zzaeu zzaeu = new zzaeu(jArr[zzc2], this.zzb[zzc2]);
        if (zzaeu.zzb < j) {
            long[] jArr2 = this.zza;
            if (zzc2 != jArr2.length - 1) {
                int i = zzc2 + 1;
                return new zzaer(zzaeu, new zzaeu(jArr2[i], this.zzb[i]));
            }
        }
        return new zzaer(zzaeu, zzaeu);
    }

    public final boolean zzh() {
        return true;
    }
}
