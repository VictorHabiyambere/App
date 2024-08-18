package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajt implements zzajr {
    private final int zza;
    private final int zzb;
    private final zzfu zzc;

    public zzajt(zzajn zzajn, zzan zzan) {
        this.zzc = zzajn.zza;
        this.zzc.zzK(12);
        int zzp = this.zzc.zzp();
        if ("audio/raw".equals(zzan.zzn)) {
            int zzm = zzgd.zzm(zzan.zzC, zzan.zzA);
            if (zzp == 0 || zzp % zzm != 0) {
                zzfk.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzm + ", stsz sample size: " + zzp);
                zzp = zzm;
            }
        }
        this.zza = zzp == 0 ? -1 : zzp;
        this.zzb = this.zzc.zzp();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
