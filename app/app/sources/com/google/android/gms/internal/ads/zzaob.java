package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaob implements zzaoc {
    private final List zza;
    private final zzafa[] zzb;
    private boolean zzc;
    private int zzd;
    private int zze;
    private long zzf = -9223372036854775807L;

    public zzaob(List list) {
        this.zza = list;
        this.zzb = new zzafa[list.size()];
    }

    private final boolean zzf(zzfu zzfu, int i) {
        if (zzfu.zzb() == 0) {
            return false;
        }
        if (zzfu.zzm() != i) {
            this.zzc = false;
        }
        this.zzd--;
        return this.zzc;
    }

    public final void zza(zzfu zzfu) {
        if (!this.zzc) {
            return;
        }
        if (this.zzd != 2 || zzf(zzfu, 32)) {
            if (this.zzd != 1 || zzf(zzfu, 0)) {
                int zzd2 = zzfu.zzd();
                int zzb2 = zzfu.zzb();
                zzafa[] zzafaArr = this.zzb;
                for (zzafa zzq : zzafaArr) {
                    zzfu.zzK(zzd2);
                    zzq.zzq(zzfu, zzb2);
                }
                this.zze += zzb2;
            }
        }
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzapl zzapl = (zzapl) this.zza.get(i);
            zzapo.zzc();
            zzafa zzw = zzadx.zzw(zzapo.zza(), 3);
            zzal zzal = new zzal();
            zzal.zzK(zzapo.zzb());
            zzal.zzX("application/dvbsubs");
            zzal.zzL(Collections.singletonList(zzapl.zzb));
            zzal.zzO(zzapl.zza);
            zzw.zzl(zzal.zzad());
            this.zzb[i] = zzw;
        }
    }

    public final void zzc() {
        boolean z;
        if (this.zzc) {
            if (this.zzf != -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzf(z);
            zzafa[] zzafaArr = this.zzb;
            for (zzafa zzs : zzafaArr) {
                zzs.zzs(this.zzf, 1, this.zze, 0, (zzaez) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzf = j;
            this.zze = 0;
            this.zzd = 2;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzf = -9223372036854775807L;
    }
}
