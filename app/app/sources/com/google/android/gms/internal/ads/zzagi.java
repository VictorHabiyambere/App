package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzagi implements zzadu {
    private final zzfu zza = new zzfu(4);
    private final zzaev zzb = new zzaev(-1, -1, "image/heif");

    private final boolean zza(zzadv zzadv, int i) throws IOException {
        this.zza.zzH(4);
        ((zzadi) zzadv).zzm(this.zza.zzM(), 0, 4, false);
        if (this.zza.zzu() == ((long) i)) {
            return true;
        }
        return false;
    }

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
        ((zzadi) zzadv).zzl(4, false);
        if (!zza(zzadv, 1718909296) || !zza(zzadv, 1751476579)) {
            return false;
        }
        return true;
    }
}
