package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanu implements zzadu {
    public static final zzaea zza = new zzant();
    private final zzanv zzb = new zzanv((String) null, 0);
    private final zzfu zzc = new zzfu(16384);
    private boolean zzd;

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        int zza2 = zzadv.zza(this.zzc.zzM(), 0, 16384);
        if (zza2 == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(zza2);
        if (!this.zzd) {
            this.zzb.zzd(0, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzb.zzb(zzadx, new zzapo(Integer.MIN_VALUE, 0, 1));
        zzadx.zzD();
        zzadx.zzO(new zzaes(-9223372036854775807L, 0));
    }

    public final void zze(long j, long j2) {
        this.zzd = false;
        this.zzb.zze();
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        zzadi zzadi;
        int i;
        zzfu zzfu = new zzfu(10);
        int i2 = 0;
        while (true) {
            zzadi = (zzadi) zzadv;
            zzadi.zzm(zzfu.zzM(), 0, 10, false);
            zzfu.zzK(0);
            if (zzfu.zzo() != 4801587) {
                break;
            }
            zzfu.zzL(3);
            int zzl = zzfu.zzl();
            i2 += zzl + 10;
            zzadi.zzl(zzl, false);
        }
        zzadv.zzj();
        zzadi.zzl(i2, false);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            zzadi.zzm(zzfu.zzM(), 0, 7, false);
            zzfu.zzK(0);
            int zzq = zzfu.zzq();
            if (zzq == 44096 || zzq == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] zzM = zzfu.zzM();
                int i6 = zzacw.zza;
                if (zzM.length < 7) {
                    i = -1;
                } else {
                    byte b = ((zzM[2] & 255) << 8) | (zzM[3] & 255);
                    if (b == 65535) {
                        b = ((zzM[4] & 255) << Ascii.DLE) | ((zzM[5] & 255) << 8) | (zzM[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (zzq == 44097) {
                        i5 += 2;
                    }
                    i = b + i5;
                }
                if (i == -1) {
                    return false;
                }
                zzadi.zzl(i - 7, false);
            } else {
                zzadv.zzj();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                zzadi.zzl(i4, false);
                i3 = 0;
            }
        }
    }
}
