package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzala implements zzadu {
    public static final zzaea zza = new zzakz();
    private zzadx zzb;
    private zzali zzc;
    private boolean zzd;

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zza(zzadv zzadv) throws IOException {
        zzalc zzalc = new zzalc();
        if (!zzalc.zzb(zzadv, true) || (zzalc.zza & 2) != 2) {
            return false;
        }
        int min = Math.min(zzalc.zze, 8);
        zzfu zzfu = new zzfu(min);
        ((zzadi) zzadv).zzm(zzfu.zzM(), 0, min, false);
        zzfu.zzK(0);
        if (zzfu.zzb() >= 5 && zzfu.zzm() == 127 && zzfu.zzu() == 1179402563) {
            this.zzc = new zzaky();
        } else {
            zzfu.zzK(0);
            try {
                if (zzafg.zzd(1, zzfu, true)) {
                    this.zzc = new zzalk();
                }
            } catch (zzch e) {
            }
            zzfu.zzK(0);
            if (!zzale.zzd(zzfu)) {
                return false;
            }
            this.zzc = new zzale();
        }
        return true;
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        zzeq.zzb(this.zzb);
        if (this.zzc == null) {
            if (zza(zzadv)) {
                zzadv.zzj();
            } else {
                throw zzch.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzd) {
            zzafa zzw = this.zzb.zzw(0, 1);
            this.zzb.zzD();
            this.zzc.zzh(this.zzb, zzw);
            this.zzd = true;
        }
        return this.zzc.zze(zzadv, zzaeq);
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzb = zzadx;
    }

    public final void zze(long j, long j2) {
        zzali zzali = this.zzc;
        if (zzali != null) {
            zzali.zzj(j, j2);
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        try {
            return zza(zzadv);
        } catch (zzch e) {
            return false;
        }
    }
}
