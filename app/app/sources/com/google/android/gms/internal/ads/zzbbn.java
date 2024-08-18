package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbbn {
    private final float zza;
    private final float zzb;
    private final float zzc;
    private final float zzd;
    private final int zze;

    public zzbbn(float f, float f2, float f3, float f4, int i) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = f + f3;
        this.zzd = f2 + f4;
        this.zze = i;
    }

    /* access modifiers changed from: package-private */
    public final float zza() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final float zzb() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final float zzc() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final float zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zze;
    }
}
