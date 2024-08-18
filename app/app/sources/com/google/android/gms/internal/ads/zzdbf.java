package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdbf extends zzdez implements zzbkf {
    private final Bundle zzb = new Bundle();

    zzdbf(Set set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzq(new zzdbe());
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
