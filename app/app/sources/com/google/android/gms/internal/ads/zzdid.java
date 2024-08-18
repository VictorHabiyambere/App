package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdid extends zzdez {
    private boolean zzb;

    protected zzdid(Set set) {
        super(set);
    }

    public final void zza() {
        zzq(new zzdia());
    }

    public final void zzb() {
        zzq(new zzdhz());
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzq(new zzdib());
            this.zzb = true;
        }
        zzq(new zzdic());
    }

    public final synchronized void zzd() {
        zzq(new zzdib());
        this.zzb = true;
    }
}
