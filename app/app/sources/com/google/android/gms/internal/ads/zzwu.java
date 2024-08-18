package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzwu implements zzwa {
    private final zzha zzc;
    private int zzd = 1048576;
    private final zzwt zze;
    private final zzzz zzf;
    private final zzsl zzg;

    public zzwu(zzha zzha, zzwt zzwt) {
        zzsl zzsl = new zzsl();
        zzzz zzzz = new zzzz(-1);
        this.zzc = zzha;
        this.zze = zzwt;
        this.zzg = zzsl;
        this.zzf = zzzz;
    }

    public final zzwu zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzww zzb(zzbu zzbu) {
        if (zzbu.zzd != null) {
            return new zzww(zzbu, this.zzc, this.zze, zzst.zza, this.zzf, this.zzd, (zzwv) null);
        }
        throw null;
    }
}
