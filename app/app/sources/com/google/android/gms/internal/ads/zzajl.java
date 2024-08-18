package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajl implements zzaji {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzajl(long j, int i, long j2, int i2, long j3, long[] jArr) {
        this.zza = j;
        this.zzb = i;
        this.zzc = j2;
        this.zzd = i2;
        this.zze = j3;
        this.zzg = jArr;
        this.zzf = j3 != -1 ? j + j3 : -1;
    }

    public static zzajl zzb(long j, zzajk zzajk, long j2) {
        long j3 = j;
        zzajk zzajk2 = zzajk;
        long j4 = zzajk2.zzb;
        if (j4 == -1) {
            j4 = -1;
        }
        zzaen zzaen = zzajk2.zza;
        long zzs = zzgd.zzs((j4 * ((long) zzaen.zzg)) - 1, zzaen.zzd);
        long j5 = zzajk2.zzc;
        if (j5 == -1 || zzajk2.zzf == null) {
            zzaen zzaen2 = zzajk2.zza;
            return new zzajl(j2, zzaen2.zzc, zzs, zzaen2.zzf, -1, (long[]) null);
        }
        if (j3 != -1) {
            long j6 = j2 + j5;
            if (j3 != j6) {
                zzfk.zzf("XingSeeker", "XING data size mismatch: " + j3 + ", " + j6);
            }
        }
        zzaen zzaen3 = zzajk2.zza;
        return new zzajl(j2, zzaen3.zzc, zzs, zzaen3.zzf, zzajk2.zzc, zzajk2.zzf);
    }

    private final long zzf(int i) {
        return (this.zzc * ((long) i)) / 100;
    }

    public final long zza() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze(long j) {
        long j2;
        double d;
        if (!zzh()) {
            return 0;
        }
        long j3 = j - this.zza;
        if (j3 <= ((long) this.zzb)) {
            return 0;
        }
        long[] jArr = this.zzg;
        zzeq.zzb(jArr);
        double d2 = (((double) j3) * 256.0d) / ((double) this.zze);
        int zzc2 = zzgd.zzc(jArr, (long) d2, true, true);
        long zzf2 = zzf(zzc2);
        long j4 = jArr[zzc2];
        int i = zzc2 + 1;
        long zzf3 = zzf(i);
        if (zzc2 == 99) {
            j2 = 256;
        } else {
            j2 = jArr[i];
        }
        if (j4 == j2) {
            d = 0.0d;
        } else {
            d = (d2 - ((double) j4)) / ((double) (j2 - j4));
        }
        return zzf2 + Math.round(d * ((double) (zzf3 - zzf2)));
    }

    public final zzaer zzg(long j) {
        double d;
        if (!zzh()) {
            zzaeu zzaeu = new zzaeu(0, this.zza + ((long) this.zzb));
            return new zzaer(zzaeu, zzaeu);
        }
        long max = Math.max(0, Math.min(j, this.zzc));
        double d2 = (((double) max) * 100.0d) / ((double) this.zzc);
        double d3 = 0.0d;
        if (d2 > 0.0d) {
            if (d2 >= 100.0d) {
                d3 = 256.0d;
            } else {
                int i = (int) d2;
                long[] jArr = this.zzg;
                zzeq.zzb(jArr);
                double d4 = (double) jArr[i];
                if (i == 99) {
                    d = 256.0d;
                } else {
                    d = (double) jArr[i + 1];
                }
                d3 = d4 + ((d2 - ((double) i)) * (d - d4));
            }
        }
        long j2 = this.zze;
        zzaeu zzaeu2 = new zzaeu(max, this.zza + Math.max((long) this.zzb, Math.min(Math.round((d3 / 256.0d) * ((double) j2)), j2 - 1)));
        return new zzaer(zzaeu2, zzaeu2);
    }

    public final boolean zzh() {
        return this.zzg != null;
    }
}
