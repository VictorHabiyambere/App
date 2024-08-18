package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaju implements zzajr {
    private final zzfu zza;
    private final int zzb = this.zza.zzp();
    private final int zzc = (this.zza.zzp() & 255);
    private int zzd;
    private int zze;

    public zzaju(zzajn zzajn) {
        this.zza = zzajn.zza;
        this.zza.zzK(12);
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzm();
        }
        if (i == 16) {
            return this.zza.zzq();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzm = this.zza.zzm();
        this.zze = zzm;
        return (zzm & 240) >> 4;
    }
}
