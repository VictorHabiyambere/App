package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzafq {
    protected final zzafa zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzafq(int i, int i2, long j, int i3, zzafa zzafa) {
        i2 = i2 != 1 ? 2 : i2;
        this.zzd = j;
        this.zze = i3;
        this.zza = zzafa;
        this.zzb = zzi(i, i2 == 2 ? 1667497984 : 1651965952);
        this.zzc = i2 == 2 ? zzi(i, 1650720768) : -1;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzj(int i) {
        return (this.zzd * ((long) i)) / ((long) this.zze);
    }

    private final zzaeu zzk(int i) {
        return new zzaeu(((long) this.zzl[i]) * zzj(1), this.zzk[i]);
    }

    public final zzaer zza(long j) {
        int zzj2 = (int) (j / zzj(1));
        int zzb2 = zzgd.zzb(this.zzl, zzj2, true, true);
        if (this.zzl[zzb2] == zzj2) {
            zzaeu zzk2 = zzk(zzb2);
            return new zzaer(zzk2, zzk2);
        }
        zzaeu zzk3 = zzk(zzb2);
        int i = zzb2 + 1;
        return i < this.zzk.length ? new zzaer(zzk3, zzk(i)) : new zzaer(zzk3, zzk3);
    }

    public final void zzb(long j) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i = this.zzj;
        jArr2[i] = j;
        this.zzl[i] = this.zzi;
        this.zzj = i + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i) {
        this.zzf = i;
        this.zzg = i;
    }

    public final void zzf(long j) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzl[zzgd.zzc(this.zzk, j, true, true)];
    }

    public final boolean zzg(int i) {
        return this.zzb == i || this.zzc == i;
    }

    public final boolean zzh(zzadv zzadv) throws IOException {
        boolean z;
        int i;
        int i2 = this.zzg;
        int zzf2 = i2 - this.zza.zzf(zzadv, i2, false);
        this.zzg = zzf2;
        if (zzf2 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.zzf > 0) {
                zzafa zzafa = this.zza;
                long zzj2 = zzj(this.zzh);
                if (Arrays.binarySearch(this.zzl, this.zzh) >= 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                zzafa.zzs(zzj2, i, this.zzf, 0, (zzaez) null);
            }
            this.zzh++;
        }
        return z;
    }
}
