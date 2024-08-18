package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaee implements zzaet {
    private final zzaeg zza;
    private final long zzb;

    public zzaee(zzaeg zzaeg, long j) {
        this.zza = zzaeg;
        this.zzb = j;
    }

    private final zzaeu zzb(long j, long j2) {
        return new zzaeu((j * AnimationKt.MillisToNanos) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final zzaer zzg(long j) {
        long j2;
        zzeq.zzb(this.zza.zzk);
        zzaeg zzaeg = this.zza;
        zzaef zzaef = zzaeg.zzk;
        long[] jArr = zzaef.zza;
        long[] jArr2 = zzaef.zzb;
        int zzc = zzgd.zzc(jArr, zzaeg.zzb(j), true, false);
        long j3 = 0;
        if (zzc == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzc];
        }
        if (zzc != -1) {
            j3 = jArr2[zzc];
        }
        zzaeu zzb2 = zzb(j2, j3);
        if (zzb2.zzb == j || zzc == jArr.length - 1) {
            return new zzaer(zzb2, zzb2);
        }
        int i = zzc + 1;
        return new zzaer(zzb2, zzb(jArr[i], jArr2[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
