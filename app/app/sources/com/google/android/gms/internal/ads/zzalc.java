package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzalc {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzfu zzg = new zzfu(255);

    zzalc() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzadv zzadv, boolean z) throws IOException {
        zza();
        this.zzg.zzH(27);
        if (!zzady.zzc(zzadv, this.zzg.zzM(), 0, 27, z) || this.zzg.zzu() != 1332176723) {
            return false;
        }
        if (this.zzg.zzm() == 0) {
            this.zza = this.zzg.zzm();
            this.zzb = this.zzg.zzr();
            this.zzg.zzs();
            this.zzg.zzs();
            this.zzg.zzs();
            int zzm = this.zzg.zzm();
            this.zzc = zzm;
            this.zzd = zzm + 27;
            this.zzg.zzH(zzm);
            if (!zzady.zzc(zzadv, this.zzg.zzM(), 0, this.zzc, z)) {
                return false;
            }
            for (int i = 0; i < this.zzc; i++) {
                this.zzf[i] = this.zzg.zzm();
                this.zze += this.zzf[i];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw zzch.zzc("unsupported bit stream revision");
        }
    }

    public final boolean zzc(zzadv zzadv, long j) throws IOException {
        boolean z;
        int i;
        if (zzadv.zzf() == zzadv.zze()) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        this.zzg.zzH(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || zzadv.zzf() + 4 < j) && zzady.zzc(zzadv, this.zzg.zzM(), 0, 4, true)) {
                this.zzg.zzK(0);
                if (this.zzg.zzu() != 1332176723) {
                    ((zzadi) zzadv).zzo(1, false);
                } else {
                    zzadv.zzj();
                    return true;
                }
            }
        }
        do {
            if ((i != 0 && zzadv.zzf() >= j) || zzadv.zzc(1) == -1) {
                return false;
            }
            break;
        } while (zzadv.zzc(1) == -1);
        return false;
    }
}
