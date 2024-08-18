package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakx implements zzald {
    private final zzaeg zza;
    private final zzaef zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzakx(zzaeg zzaeg, zzaef zzaef) {
        this.zza = zzaeg;
        this.zzb = zzaef;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final long zzd(zzadv zzadv) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final zzaet zze() {
        zzeq.zzf(this.zzc != -1);
        return new zzaee(this.zza, this.zzc);
    }

    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzgd.zzc(jArr, j, true, true)];
    }
}
