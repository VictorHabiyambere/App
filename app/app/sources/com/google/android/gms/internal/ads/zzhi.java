package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhi implements zzha {
    private final Context zza;
    private final zzha zzb;

    public zzhi(Context context) {
        zzhk zzhk = new zzhk();
        this.zza = context.getApplicationContext();
        this.zzb = zzhk;
    }

    public final /* bridge */ /* synthetic */ zzhb zza() {
        return new zzhj(this.zza, ((zzhk) this.zzb).zza());
    }
}
