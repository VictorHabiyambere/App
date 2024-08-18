package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzms {
    private final zzjq zza;

    @Deprecated
    public zzms(Context context, zzcgn zzcgn) {
        this.zza = new zzjq(context, zzcgn);
    }

    @Deprecated
    public final zzms zza(zzlk zzlk) {
        zzjq zzjq = this.zza;
        zzeq.zzf(!zzjq.zzq);
        if (zzlk != null) {
            zzjq.zzf = new zzji(zzlk);
            return this;
        }
        throw null;
    }

    @Deprecated
    public final zzms zzb(zzzm zzzm) {
        zzjq zzjq = this.zza;
        zzeq.zzf(!zzjq.zzq);
        if (zzzm != null) {
            zzjq.zze = new zzjp(zzzm);
            return this;
        }
        throw null;
    }

    @Deprecated
    public final zzmt zzc() {
        zzjq zzjq = this.zza;
        zzeq.zzf(!zzjq.zzq);
        zzjq.zzq = true;
        return new zzmt(zzjq);
    }
}
