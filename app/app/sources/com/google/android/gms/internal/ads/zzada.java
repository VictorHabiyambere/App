package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzada {
    /* access modifiers changed from: private */
    public final long zza;
    /* access modifiers changed from: private */
    public final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    /* access modifiers changed from: private */
    public long zzf;
    /* access modifiers changed from: private */
    public long zzg;
    /* access modifiers changed from: private */
    public long zzh;

    protected zzada(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.zza = j;
        long j8 = j2;
        this.zzb = j8;
        long j9 = j4;
        this.zze = j9;
        long j10 = j5;
        this.zzf = j10;
        long j11 = j6;
        this.zzg = j11;
        long j12 = j7;
        this.zzc = j12;
        this.zzh = zzf(j8, 0, j9, j10, j11, j12);
    }

    protected static long zzf(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = (long) (((float) (j - j2)) * (((float) (j5 - j4)) / ((float) (j3 - j2))));
        return Math.max(j4, Math.min(((j4 + j7) - j6) - (j7 / 20), j5 - 1));
    }

    static /* bridge */ /* synthetic */ void zzg(zzada zzada, long j, long j2) {
        zzada.zze = j;
        zzada.zzg = j2;
        zzada.zzi();
    }

    static /* bridge */ /* synthetic */ void zzh(zzada zzada, long j, long j2) {
        zzada.zzd = j;
        zzada.zzf = j2;
        zzada.zzi();
    }

    private final void zzi() {
        this.zzh = zzf(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
