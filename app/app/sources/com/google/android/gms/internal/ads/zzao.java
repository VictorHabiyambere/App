package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzao {
    private final zzt zza;
    private final int zzb;
    private final int zzc;
    private float zzd = 1.0f;

    public zzao(zzt zzt, int i, int i2) {
        this.zza = zzt;
        this.zzb = i;
        this.zzc = i2;
    }

    public final zzao zza(float f) {
        this.zzd = f;
        return this;
    }

    public final zzaq zzb() {
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, 0, (zzap) null);
    }
}
