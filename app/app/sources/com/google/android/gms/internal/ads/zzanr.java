package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanr implements zzadu {
    public static final zzaea zza = new zzanq();
    private final zzans zzb = new zzans((String) null, 0);
    private final zzfu zzc = new zzfu(2786);
    private boolean zzd;

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        int zza2 = zzadv.zza(this.zzc.zzM(), 0, 2786);
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
        zzfu zzfu = new zzfu(10);
        int i = 0;
        while (true) {
            zzadi = (zzadi) zzadv;
            zzadi.zzm(zzfu.zzM(), 0, 10, false);
            zzfu.zzK(0);
            if (zzfu.zzo() != 4801587) {
                break;
            }
            zzfu.zzL(3);
            int zzl = zzfu.zzl();
            i += zzl + 10;
            zzadi.zzl(zzl, false);
        }
        zzadv.zzj();
        zzadi.zzl(i, false);
        int i2 = 0;
        int i3 = i;
        while (true) {
            zzadi.zzm(zzfu.zzM(), 0, 6, false);
            zzfu.zzK(0);
            if (zzfu.zzq() != 2935) {
                zzadv.zzj();
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                zzadi.zzl(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                int zzb2 = zzact.zzb(zzfu.zzM());
                if (zzb2 == -1) {
                    return false;
                }
                zzadi.zzl(zzb2 - 6, false);
            }
        }
    }
}
