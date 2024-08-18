package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaov implements zzadd {
    private final zzgb zza;
    private final zzfu zzb = new zzfu();

    /* synthetic */ zzaov(zzgb zzgb, zzaou zzaou) {
        this.zza = zzgb;
    }

    public final zzadc zza(zzadv zzadv, long j) throws IOException {
        int zzh;
        long j2;
        long zzf = zzadv.zzf();
        int min = (int) Math.min(20000, zzadv.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzadi) zzadv).zzm(this.zzb.zzM(), 0, min, false);
        int i = -1;
        long j3 = -9223372036854775807L;
        int i2 = -1;
        while (true) {
            zzfu zzfu = this.zzb;
            if (zzfu.zzb() < 4) {
                return j3 != -9223372036854775807L ? zzadc.zzf(j3, zzf + ((long) i)) : zzadc.zza;
            }
            if (zzaow.zzh(zzfu.zzM(), zzfu.zzd()) != 442) {
                zzfu.zzL(1);
            } else {
                zzfu.zzL(4);
                long zzc = zzaox.zzc(zzfu);
                if (zzc != -9223372036854775807L) {
                    long zzb2 = this.zza.zzb(zzc);
                    if (zzb2 > j) {
                        if (j3 == -9223372036854775807L) {
                            return zzadc.zzd(zzb2, zzf);
                        }
                        j2 = (long) i2;
                    } else if (100000 + zzb2 > j) {
                        j2 = (long) zzfu.zzd();
                        break;
                    } else {
                        i2 = zzfu.zzd();
                        j3 = zzb2;
                    }
                }
                int zze = zzfu.zze();
                if (zzfu.zzb() >= 10) {
                    zzfu.zzL(9);
                    int zzm = zzfu.zzm() & 7;
                    if (zzfu.zzb() >= zzm) {
                        zzfu.zzL(zzm);
                        if (zzfu.zzb() >= 4) {
                            if (zzaow.zzh(zzfu.zzM(), zzfu.zzd()) == 443) {
                                zzfu.zzL(4);
                                int zzq = zzfu.zzq();
                                if (zzfu.zzb() < zzq) {
                                    zzfu.zzK(zze);
                                } else {
                                    zzfu.zzL(zzq);
                                }
                            }
                            while (true) {
                                if (zzfu.zzb() < 4 || (zzh = zzaow.zzh(zzfu.zzM(), zzfu.zzd())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfu.zzL(4);
                                if (zzfu.zzb() < 2) {
                                    zzfu.zzK(zze);
                                    break;
                                }
                                zzfu.zzK(Math.min(zzfu.zze(), zzfu.zzd() + zzfu.zzq()));
                            }
                        } else {
                            zzfu.zzK(zze);
                        }
                    } else {
                        zzfu.zzK(zze);
                    }
                } else {
                    zzfu.zzK(zze);
                }
                i = zzfu.zzd();
            }
        }
        return zzadc.zze(zzf + j2);
    }

    public final void zzb() {
        byte[] bArr = zzgd.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
