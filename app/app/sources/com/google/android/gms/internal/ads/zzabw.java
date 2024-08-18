package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzabw {
    private final zzabv zza;
    private final zzabq zzb;
    private final zzabo zzc = new zzabo();
    private final zzga zzd = new zzga(10);
    private final zzga zze = new zzga(10);
    private final zzfm zzf = new zzfm(16);
    private zzdv zzg;
    private zzdv zzh = zzdv.zza;
    private long zzi;
    private long zzj = -9223372036854775807L;

    public zzabw(zzabv zzabv, zzabq zzabq) {
        this.zza = zzabv;
        this.zzb = zzabq;
    }

    private static Object zzf(zzga zzga) {
        boolean z;
        if (zzga.zza() > 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        while (zzga.zza() > 1) {
            zzga.zzb();
        }
        Object zzb2 = zzga.zzb();
        if (zzb2 != null) {
            return zzb2;
        }
        throw null;
    }

    public final void zza() {
        this.zzf.zzc();
        this.zzj = -9223372036854775807L;
        zzga zzga = this.zze;
        if (zzga.zza() > 0) {
            this.zze.zzd(0, Long.valueOf(((Long) zzf(zzga)).longValue()));
        }
        if (this.zzg == null) {
            zzga zzga2 = this.zzd;
            if (zzga2.zza() > 0) {
                this.zzg = (zzdv) zzf(zzga2);
                return;
            }
            return;
        }
        this.zzd.zze();
    }

    public final void zzb(long j, long j2) {
        this.zze.zzd(j, Long.valueOf(j2));
    }

    public final void zzc(long j, long j2) throws zzjh {
        long j3;
        while (true) {
            zzfm zzfm = this.zzf;
            if (!zzfm.zzd()) {
                zzga zzga = this.zze;
                long zza2 = zzfm.zza();
                Long l = (Long) zzga.zzc(zza2);
                if (!(l == null || l.longValue() == this.zzi)) {
                    this.zzi = l.longValue();
                    this.zzb.zzf();
                }
                int zza3 = this.zzb.zza(zza2, j, j2, this.zzi, false, this.zzc);
                switch (zza3) {
                    case 0:
                    case 1:
                        this.zzj = zza2;
                        long longValue = Long.valueOf(this.zzf.zzb()).longValue();
                        zzdv zzdv = (zzdv) this.zzd.zzc(longValue);
                        if (zzdv != null && !zzdv.equals(zzdv.zza) && !zzdv.equals(this.zzh)) {
                            this.zzh = zzdv;
                            this.zza.zzm(this.zzh);
                        }
                        if (zza3 == 0) {
                            j3 = -1;
                        } else {
                            j3 = this.zzc.zzd();
                        }
                        this.zza.zzp(j3, longValue, this.zzi, this.zzb.zzp());
                        break;
                    case 2:
                    case 3:
                    case 4:
                        this.zzj = zza2;
                        this.zzf.zzb();
                        this.zza.zzl();
                        break;
                    default:
                        return;
                }
            } else {
                return;
            }
        }
    }

    public final void zzd(float f) {
        boolean z;
        if (f > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        this.zzb.zzn(f);
    }

    public final boolean zze(long j) {
        long j2 = this.zzj;
        return j2 != -9223372036854775807L && j2 >= j;
    }
}
