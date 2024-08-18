package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzape implements zzadd {
    private final zzgb zza;
    private final zzfu zzb = new zzfu();
    private final int zzc;

    public zzape(int i, zzgb zzgb, int i2) {
        this.zzc = i;
        this.zza = zzgb;
    }

    public final zzadc zza(zzadv zzadv, long j) throws IOException {
        int zza2;
        int i;
        long zzf = zzadv.zzf();
        int min = (int) Math.min(112800, zzadv.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzadi) zzadv).zzm(this.zzb.zzM(), 0, min, false);
        zzfu zzfu = this.zzb;
        int zze = zzfu.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzfu.zzb() >= 188 && (i = zza2 + 188) <= zze) {
            long zzb2 = zzapq.zzb(zzfu, (zza2 = zzapq.zza(zzfu.zzM(), zzfu.zzd(), zze)), this.zzc);
            if (zzb2 != -9223372036854775807L) {
                long zzb3 = this.zza.zzb(zzb2);
                if (zzb3 <= j) {
                    j4 = (long) zza2;
                    if (100000 + zzb3 <= j) {
                        j3 = zzb3;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzadc.zzd(zzb3, zzf);
                }
                return zzadc.zze(zzf + j4);
            }
            zzfu.zzK(i);
            j2 = (long) i;
        }
        return j3 != -9223372036854775807L ? zzadc.zzf(j3, zzf + j2) : zzadc.zza;
    }

    public final void zzb() {
        byte[] bArr = zzgd.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
