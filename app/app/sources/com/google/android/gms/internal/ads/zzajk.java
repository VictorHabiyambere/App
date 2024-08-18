package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajk {
    public final zzaen zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzajk(zzaen zzaen, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = zzaen;
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzajk zza(zzaen zzaen, zzfu zzfu) {
        int i;
        long j;
        long[] jArr;
        int i2;
        int i3;
        int zzg = zzfu.zzg();
        if ((zzg & 1) != 0) {
            i = zzfu.zzp();
        } else {
            i = -1;
        }
        if ((zzg & 2) != 0) {
            j = zzfu.zzu();
        } else {
            j = -1;
        }
        if ((zzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i4 = 0; i4 < 100; i4++) {
                jArr2[i4] = (long) zzfu.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((zzg & 8) != 0) {
            zzfu.zzL(4);
        }
        if (zzfu.zzb() >= 24) {
            zzfu.zzL(21);
            int zzo = zzfu.zzo();
            i2 = zzo & 4095;
            i3 = zzo >> 12;
        } else {
            i3 = -1;
            i2 = -1;
        }
        return new zzajk(zzaen, (long) i, j, jArr, i3, i2);
    }
}
