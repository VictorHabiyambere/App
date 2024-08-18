package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaqb implements zzadu {
    private final zzfu zza = new zzfu(4);
    private final zzaev zzb = new zzaev(-1, -1, "image/webp");

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        return this.zzb.zzb(zzadv, zzaeq);
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzb.zzd(zzadx);
    }

    public final void zze(long j, long j2) {
        this.zzb.zze(j, j2);
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        this.zza.zzH(4);
        zzadi zzadi = (zzadi) zzadv;
        zzadi.zzm(this.zza.zzM(), 0, 4, false);
        if (this.zza.zzu() == 1380533830) {
            zzadi.zzl(4, false);
            this.zza.zzH(4);
            zzadi.zzm(this.zza.zzM(), 0, 4, false);
            if (this.zza.zzu() == 1464156752) {
                return true;
            }
        }
        return false;
    }
}
