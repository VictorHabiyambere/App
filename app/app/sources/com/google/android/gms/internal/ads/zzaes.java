package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzaes implements zzaet {
    private final long zza;
    private final zzaer zzb;

    public zzaes(long j, long j2) {
        this.zza = j;
        zzaeu zzaeu = j2 == 0 ? zzaeu.zza : new zzaeu(0, j2);
        this.zzb = new zzaer(zzaeu, zzaeu);
    }

    public final long zza() {
        return this.zza;
    }

    public final zzaer zzg(long j) {
        return this.zzb;
    }

    public final boolean zzh() {
        return false;
    }
}
