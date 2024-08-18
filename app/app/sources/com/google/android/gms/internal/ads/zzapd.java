package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapd {
    private final List zza;
    private final zzafa[] zzb;

    public zzapd(List list) {
        this.zza = list;
        this.zzb = new zzafa[list.size()];
    }

    public final void zza(long j, zzfu zzfu) {
        zzadf.zza(j, zzfu, this.zzb);
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzapo.zzc();
            zzafa zzw = zzadx.zzw(zzapo.zza(), 3);
            zzan zzan = (zzan) this.zza.get(i);
            String str = zzan.zzn;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzeq.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            String str2 = zzan.zzb;
            if (str2 == null) {
                str2 = zzapo.zzb();
            }
            zzal zzal = new zzal();
            zzal.zzK(str2);
            zzal.zzX(str);
            zzal.zzZ(zzan.zzf);
            zzal.zzO(zzan.zze);
            zzal.zzw(zzan.zzF);
            zzal.zzL(zzan.zzp);
            zzw.zzl(zzal.zzad());
            this.zzb[i] = zzw;
        }
    }
}
