package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapg {
    private final zzgb zza = new zzgb(0);
    private final zzfu zzb = new zzfu();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    zzapg(int i) {
    }

    private final int zze(zzadv zzadv) {
        byte[] bArr = zzgd.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzadv.zzj();
        return 0;
    }

    public final int zza(zzadv zzadv, zzaeq zzaeq, int i) throws IOException {
        if (i <= 0) {
            zze(zzadv);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzadv.zzd();
            int min = (int) Math.min(112800, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzadv.zzf() != j2) {
                zzaeq.zza = j2;
                return 1;
            }
            this.zzb.zzH(min);
            zzadv.zzj();
            ((zzadi) zzadv).zzm(this.zzb.zzM(), 0, min, false);
            zzfu zzfu = this.zzb;
            int zzd3 = zzfu.zzd();
            int zze2 = zzfu.zze();
            int i2 = zze2 - 188;
            while (true) {
                if (i2 < zzd3) {
                    break;
                }
                byte[] zzM = zzfu.zzM();
                int i3 = -4;
                int i4 = 0;
                while (true) {
                    if (i3 > 4) {
                        break;
                    }
                    int i5 = (i3 * 188) + i2;
                    if (i5 < zzd3 || i5 >= zze2) {
                        i4 = 0;
                    } else if (zzM[i5] != 71) {
                        i4 = 0;
                    } else {
                        i4++;
                        if (i4 == 5) {
                            long zzb2 = zzapq.zzb(zzfu, i2, i);
                            if (zzb2 != -9223372036854775807L) {
                                j = zzb2;
                                break;
                            }
                        }
                    }
                    i3++;
                }
                i2--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zze(zzadv);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzadv.zzd());
            if (zzadv.zzf() != 0) {
                zzaeq.zza = 0;
                return 1;
            }
            this.zzb.zzH(min2);
            zzadv.zzj();
            ((zzadi) zzadv).zzm(this.zzb.zzM(), 0, min2, false);
            zzfu zzfu2 = this.zzb;
            int zzd4 = zzfu2.zzd();
            int zze3 = zzfu2.zze();
            while (true) {
                if (zzd4 >= zze3) {
                    break;
                }
                if (zzfu2.zzM()[zzd4] == 71) {
                    long zzb3 = zzapq.zzb(zzfu2, zzd4, i);
                    if (zzb3 != -9223372036854775807L) {
                        j = zzb3;
                        break;
                    }
                }
                zzd4++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zze(zzadv);
                return 0;
            }
            zzgb zzgb = this.zza;
            this.zzh = zzgb.zzc(this.zzg) - zzgb.zzb(j3);
            zze(zzadv);
            return 0;
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzgb zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
