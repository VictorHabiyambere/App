package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdzq implements zzhkp {
    private final zzhlg zza;

    public zzdzq(zzhlg zzhlg) {
        this.zza = zzhlg;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzhkx.zzb(applicationInfo);
        return applicationInfo;
    }
}
