package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwc implements zzzg {
    private final zzzg zza;
    private final zzde zzb;

    public zzwc(zzzg zzzg, zzde zzde) {
        this.zza = zzzg;
        this.zzb = zzde;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwc)) {
            return false;
        }
        zzwc zzwc = (zzwc) obj;
        return this.zza.equals(zzwc.zza) && this.zzb.equals(zzwc.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + 527) * 31) + this.zza.hashCode();
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzan zzd(int i) {
        return this.zzb.zzb(this.zza.zza(i));
    }

    public final zzde zze() {
        return this.zzb;
    }
}
