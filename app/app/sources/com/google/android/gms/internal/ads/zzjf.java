package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzjf implements zzlp {
    private final zzmu zza;
    private final zzje zzb;
    private zzmn zzc;
    private zzlp zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzjf(zzje zzje, zzer zzer) {
        this.zzb = zzje;
        this.zza = new zzmu(zzer);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z) {
        zzmn zzmn = this.zzc;
        if (zzmn == null || zzmn.zzW() || ((z && this.zzc.zzcU() != 2) || (!this.zzc.zzX() && (z || this.zzc.zzQ())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzlp zzlp = this.zzd;
            if (zzlp != null) {
                long zza2 = zzlp.zza();
                if (this.zze) {
                    if (zza2 < this.zza.zza()) {
                        this.zza.zze();
                    } else {
                        this.zze = false;
                        if (this.zzf) {
                            this.zza.zzd();
                        }
                    }
                }
                this.zza.zzb(zza2);
                zzcl zzc2 = zzlp.zzc();
                if (!zzc2.equals(this.zza.zzc())) {
                    this.zza.zzg(zzc2);
                    this.zzb.zza(zzc2);
                }
            } else {
                throw null;
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzlp zzlp2 = this.zzd;
        if (zzlp2 != null) {
            return zzlp2.zza();
        }
        throw null;
    }

    public final zzcl zzc() {
        zzlp zzlp = this.zzd;
        return zzlp != null ? zzlp.zzc() : this.zza.zzc();
    }

    public final void zzd(zzmn zzmn) {
        if (zzmn == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzmn zzmn) throws zzjh {
        zzlp zzlp;
        zzlp zzk = zzmn.zzk();
        if (zzk != null && zzk != (zzlp = this.zzd)) {
            if (zzlp == null) {
                this.zzd = zzk;
                this.zzc = zzmn;
                this.zzd.zzg(this.zza.zzc());
                return;
            }
            throw zzjh.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    public final void zzg(zzcl zzcl) {
        zzlp zzlp = this.zzd;
        if (zzlp != null) {
            zzlp.zzg(zzcl);
            zzcl = this.zzd.zzc();
        }
        this.zza.zzg(zzcl);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzlp zzlp = this.zzd;
        if (zzlp != null) {
            return zzlp.zzj();
        }
        throw null;
    }
}
