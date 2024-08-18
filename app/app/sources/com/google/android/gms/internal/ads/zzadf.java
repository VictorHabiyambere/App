package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzadf {
    public static void zza(long j, zzfu zzfu, zzafa[] zzafaArr) {
        int i;
        boolean z;
        while (true) {
            boolean z2 = true;
            if (zzfu.zzb() > 1) {
                int zzc = zzc(zzfu);
                int zzc2 = zzc(zzfu);
                int zzd = zzfu.zzd() + zzc2;
                if (zzc2 == -1 || zzc2 > zzfu.zzb()) {
                    zzfk.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzd = zzfu.zze();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzm = zzfu.zzm();
                    int zzq = zzfu.zzq();
                    if (zzq == 49) {
                        i = zzfu.zzg();
                        zzq = 49;
                    } else {
                        i = 0;
                    }
                    int zzm2 = zzfu.zzm();
                    if (zzq == 47) {
                        zzfu.zzL(1);
                        zzq = 47;
                    }
                    if (zzm == 181 && ((zzq == 49 || zzq == 47) && zzm2 == 3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (zzq == 49) {
                        if (i != 1195456820) {
                            z2 = false;
                        }
                        z &= z2;
                    }
                    if (z) {
                        zzb(j, zzfu, zzafaArr);
                    }
                }
                zzfu.zzK(zzd);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j, zzfu zzfu, zzafa[] zzafaArr) {
        boolean z;
        zzfu zzfu2 = zzfu;
        zzafa[] zzafaArr2 = zzafaArr;
        int zzm = zzfu.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzfu2.zzL(1);
            int zzd = zzfu.zzd();
            for (zzafa zzafa : zzafaArr2) {
                int i2 = i * 3;
                zzfu2.zzK(zzd);
                zzafa.zzq(zzfu2, i2);
                if (j != -9223372036854775807L) {
                    z = true;
                } else {
                    z = false;
                }
                zzeq.zzf(z);
                zzafa.zzs(j, 1, i2, 0, (zzaez) null);
            }
        }
    }

    private static int zzc(zzfu zzfu) {
        int i = 0;
        while (zzfu.zzb() != 0) {
            int zzm = zzfu.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
