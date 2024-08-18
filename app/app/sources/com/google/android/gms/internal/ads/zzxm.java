package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzxm implements zzxf {
    private final zzxf zza;
    private final long zzb;

    public zzxm(zzxf zzxf, long j) {
        this.zza = zzxf;
        this.zzb = j;
    }

    public final int zza(zzlj zzlj, zzin zzin, int i) {
        int zza2 = this.zza.zza(zzlj, zzin, i);
        if (zza2 != -4) {
            return zza2;
        }
        zzin.zze += this.zzb;
        return -4;
    }

    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzxf zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
