package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwx implements zzzp {
    public long zza;
    public long zzb;
    public zzzo zzc;
    public zzwx zzd;

    public zzwx(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzwx zzb() {
        this.zzc = null;
        zzwx zzwx = this.zzd;
        this.zzd = null;
        return zzwx;
    }

    public final zzzo zzc() {
        zzzo zzzo = this.zzc;
        if (zzzo != null) {
            return zzzo;
        }
        throw null;
    }

    public final zzzp zzd() {
        zzwx zzwx = this.zzd;
        if (zzwx == null || zzwx.zzc == null) {
            return null;
        }
        return zzwx;
    }

    public final void zze(long j, int i) {
        zzeq.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }
}
