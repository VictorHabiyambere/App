package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdhm {
    private final List zza;
    private final zzfoe zzb;
    private boolean zzc;

    public zzdhm(zzfgt zzfgt, zzfoe zzfoe) {
        this.zza = zzfgt.zzq;
        this.zzb = zzfoe;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
