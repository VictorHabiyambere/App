package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzlq {
    public final zzvm zza;
    public final Object zzb;
    public final zzxf[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzlr zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzmp[] zzi;
    private final zzzm zzj;
    private final zzmf zzk;
    private zzlq zzl;
    private zzxr zzm = zzxr.zza;
    private zzzn zzn;
    private long zzo;

    public zzlq(zzmp[] zzmpArr, long j, zzzm zzzm, zzzv zzzv, zzmf zzmf, zzlr zzlr, zzzn zzzn) {
        this.zzi = zzmpArr;
        this.zzo = j;
        this.zzj = zzzm;
        this.zzk = zzmf;
        this.zzb = zzlr.zza.zza;
        this.zzf = zzlr;
        this.zzn = zzzn;
        this.zzc = new zzxf[2];
        this.zzh = new boolean[2];
        zzvo zzvo = zzlr.zza;
        long j2 = zzlr.zzb;
        long j3 = zzlr.zzd;
        zzvm zzp = zzmf.zzp(zzvo, zzzv, j2);
        this.zza = j3 != -9223372036854775807L ? new zzus(zzp, true, 0, j3) : zzp;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzzn zzzn = this.zzn;
                if (i < zzzn.zza) {
                    zzzn.zzb(i);
                    zzzg zzzg = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzzn zzzn = this.zzn;
                if (i < zzzn.zza) {
                    zzzn.zzb(i);
                    zzzg zzzg = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        return this.zzl == null;
    }

    public final long zza(zzzn zzzn, long j, boolean z) {
        return zzb(zzzn, j, false, new boolean[2]);
    }

    public final long zzb(zzzn zzzn, long j, boolean z, boolean[] zArr) {
        zzzn zzzn2 = zzzn;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzzn2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzzn.zza(this.zzn, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzmp[] zzmpArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzmpArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzzn2;
        zzt();
        long zzf2 = this.zza.zzf(zzzn2.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzmp[] zzmpArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzmpArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzxf[] zzxfArr = this.zzc;
            if (i4 >= 2) {
                return zzf2;
            }
            if (zzxfArr[i4] != null) {
                zzeq.zzf(zzzn.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                zzeq.zzf(zzzn2.zzc[i4] == null);
            }
            i4++;
        }
    }

    public final long zzc() {
        long j;
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        if (this.zze) {
            j = this.zza.zzb();
        } else {
            j = Long.MIN_VALUE;
        }
        return j == Long.MIN_VALUE ? this.zzf.zze : j;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzlq zzg() {
        return this.zzl;
    }

    public final zzxr zzh() {
        return this.zzm;
    }

    public final zzzn zzi() {
        return this.zzn;
    }

    public final zzzn zzj(float f, zzdc zzdc) throws zzjh {
        zzzn zzp = this.zzj.zzp(this.zzi, this.zzm, this.zzf.zza, zzdc);
        for (zzzg zzzg : zzp.zzc) {
        }
        return zzp;
    }

    public final void zzk(long j, float f, long j2) {
        zzeq.zzf(zzu());
        long j3 = j - this.zzo;
        zzlm zzlm = new zzlm();
        zzlm.zze(j3);
        zzlm.zzf(f);
        zzlm.zzd(j2);
        this.zza.zzo(new zzlo(zzlm, (zzln) null));
    }

    public final void zzl(float f, zzdc zzdc) throws zzjh {
        this.zzd = true;
        this.zzm = this.zza.zzh();
        zzzn zzj2 = zzj(f, zzdc);
        zzlr zzlr = this.zzf;
        long j = zzlr.zzb;
        long j2 = zzlr.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zza2 = zza(zzj2, j, false);
        long j3 = this.zzo;
        zzlr zzlr2 = this.zzf;
        this.zzo = j3 + (zzlr2.zzb - zza2);
        this.zzf = zzlr2.zzb(zza2);
    }

    public final void zzm(long j) {
        zzeq.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzvm zzvm = this.zza;
        try {
            boolean z = zzvm instanceof zzus;
            zzmf zzmf = this.zzk;
            if (z) {
                zzmf.zzi(((zzus) zzvm).zza);
            } else {
                zzmf.zzi(zzvm);
            }
        } catch (RuntimeException e) {
            zzfk.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzlq zzlq) {
        if (zzlq != this.zzl) {
            zzs();
            this.zzl = zzlq;
            zzt();
        }
    }

    public final void zzp(long j) {
        this.zzo = 1000000000000L;
    }

    public final void zzq() {
        zzvm zzvm = this.zza;
        if (zzvm instanceof zzus) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzus) zzvm).zzn(0, j);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (this.zze) {
            return this.zza.zzb() == Long.MIN_VALUE;
        }
        return true;
    }
}
