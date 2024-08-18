package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaem implements zzaet {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzaem(long[] jArr, long[] jArr2, long j) {
        boolean z;
        boolean z2;
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        if (length2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzd = z2;
        if (!z2 || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            this.zza = new long[i];
            this.zzb = new long[i];
            System.arraycopy(jArr, 0, this.zza, 1, length2);
            System.arraycopy(jArr2, 0, this.zzb, 1, length2);
        }
        this.zzc = j;
    }

    public final long zza() {
        return this.zzc;
    }

    public final zzaer zzg(long j) {
        if (!this.zzd) {
            zzaeu zzaeu = zzaeu.zza;
            return new zzaer(zzaeu, zzaeu);
        }
        int zzc2 = zzgd.zzc(this.zzb, j, true, true);
        zzaeu zzaeu2 = new zzaeu(this.zzb[zzc2], this.zza[zzc2]);
        if (zzaeu2.zzb != j) {
            long[] jArr = this.zzb;
            if (zzc2 != jArr.length - 1) {
                int i = zzc2 + 1;
                return new zzaer(zzaeu2, new zzaeu(jArr[i], this.zza[i]));
            }
        }
        return new zzaer(zzaeu2, zzaeu2);
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
