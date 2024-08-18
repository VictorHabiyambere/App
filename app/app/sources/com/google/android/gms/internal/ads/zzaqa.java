package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaqa implements zzaet {
    private final zzapx zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaqa(zzapx zzapx, int i, long j, long j2) {
        this.zza = zzapx;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzapx.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzgd.zzt(j * ((long) this.zzb), AnimationKt.MillisToNanos, (long) this.zza.zzc, RoundingMode.FLOOR);
    }

    public final long zza() {
        return this.zze;
    }

    public final zzaer zzg(long j) {
        long max = Math.max(0, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * AnimationKt.MillisToNanos), this.zzd - 1));
        long zzb2 = zzb(max);
        zzaeu zzaeu = new zzaeu(zzb2, this.zzc + (((long) this.zza.zzd) * max));
        if (zzb2 >= j || max == this.zzd - 1) {
            return new zzaer(zzaeu, zzaeu);
        }
        long j2 = max + 1;
        return new zzaer(zzaeu, new zzaeu(zzb(j2), this.zzc + (j2 * ((long) this.zza.zzd))));
    }

    public final boolean zzh() {
        return true;
    }
}
