package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzalb {
    private final zzalc zza = new zzalc();
    private final zzfu zzb = new zzfu(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzalb() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzalc zzalc = this.zza;
            if (i5 >= zzalc.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzalc.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzfu zza() {
        return this.zzb;
    }

    public final zzalc zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfu zzfu = this.zzb;
        if (zzfu.zzM().length != 65025) {
            zzfu.zzI(Arrays.copyOf(zzfu.zzM(), Math.max(65025, zzfu.zze())), this.zzb.zze());
        }
    }

    public final boolean zze(zzadv zzadv) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzH(0);
        }
        while (true) {
            boolean z = true;
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzadv, -1) || !this.zza.zzb(zzadv, true)) {
                    return false;
                }
                zzalc zzalc = this.zza;
                int i2 = zzalc.zzd;
                if ((zzalc.zza & 1) == 1 && this.zzb.zze() == 0) {
                    i2 += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzady.zze(zzadv, i2)) {
                    return false;
                }
                this.zzc = i;
            }
            int zzf = zzf(i);
            int i3 = this.zzc + this.zzd;
            if (zzf > 0) {
                zzfu zzfu = this.zzb;
                zzfu.zzE(zzfu.zze() + zzf);
                zzfu zzfu2 = this.zzb;
                if (!zzady.zzd(zzadv, zzfu2.zzM(), zzfu2.zze(), zzf)) {
                    return false;
                }
                zzfu zzfu3 = this.zzb;
                zzfu3.zzJ(zzfu3.zze() + zzf);
                if (this.zza.zzf[i3 - 1] == 255) {
                    z = false;
                }
                this.zze = z;
            }
            if (i3 == this.zza.zzc) {
                i3 = -1;
            }
            this.zzc = i3;
        }
        return false;
    }
}
