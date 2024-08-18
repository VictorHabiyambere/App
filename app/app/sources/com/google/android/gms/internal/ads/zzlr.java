package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzlr {
    public final zzvo zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzlr(zzvo zzvo, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        boolean z6 = true;
        if (z4) {
            z5 = z2;
        } else {
            z5 = true;
        }
        zzeq.zzd(z5);
        if (z3 && !z2) {
            z6 = false;
        }
        zzeq.zzd(z6);
        this.zza = zzvo;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = false;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzlr zzlr = (zzlr) obj;
        return this.zzb == zzlr.zzb && this.zzc == zzlr.zzc && this.zzd == zzlr.zzd && this.zze == zzlr.zze && this.zzg == zzlr.zzg && this.zzh == zzlr.zzh && this.zzi == zzlr.zzi && zzgd.zzG(this.zza, zzlr.zza);
    }

    public final int hashCode() {
        long j = this.zze;
        long j2 = this.zzd;
        return ((((((((((((((this.zza.hashCode() + 527) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j2)) * 31) + ((int) j)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzlr zza(long j) {
        if (j == this.zzc) {
            return this;
        }
        return new zzlr(this.zza, this.zzb, j, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzlr zzb(long j) {
        if (j == this.zzb) {
            return this;
        }
        return new zzlr(this.zza, j, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
