package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdad extends zzdez {
    private boolean zzb = false;

    public zzdad(Set set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzq(new zzdac());
            this.zzb = true;
        }
    }
}
