package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaev implements zzadu {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzadx zzf;
    private zzafa zzg;

    public zzaev(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        switch (this.zze) {
            case 1:
                zzafa zzafa = this.zzg;
                if (zzafa != null) {
                    int zza2 = zzaey.zza(zzafa, zzadv, 1024, true);
                    if (zza2 == -1) {
                        this.zze = 2;
                        this.zzg.zzs(0, 1, this.zzd, 0, (zzaez) null);
                        this.zzd = 0;
                    } else {
                        this.zzd += zza2;
                    }
                    return 0;
                }
                throw null;
            case 2:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzf = zzadx;
        this.zzg = this.zzf.zzw(1024, 4);
        zzafa zzafa = this.zzg;
        zzal zzal = new zzal();
        zzal.zzX(this.zzc);
        zzafa.zzl(zzal.zzad());
        this.zzf.zzD();
        this.zzf.zzO(new zzaew(-9223372036854775807L));
        this.zze = 1;
    }

    public final void zze(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        boolean z;
        if (this.zza == -1 || this.zzb == -1) {
            z = false;
        } else {
            z = true;
        }
        zzeq.zzf(z);
        zzfu zzfu = new zzfu(this.zzb);
        ((zzadi) zzadv).zzm(zzfu.zzM(), 0, this.zzb, false);
        return zzfu.zzq() == this.zza;
    }
}
