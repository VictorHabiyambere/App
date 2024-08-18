package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzlf {
    public zzmg zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzlf(zzmg zzmg) {
        this.zza = zzmg;
    }

    public final void zza(int i) {
        boolean z = true;
        if (true != (this.zzg | i)) {
            z = false;
        }
        this.zzg = z;
        this.zzb += i;
    }

    public final void zzb(int i) {
        this.zzg = true;
        this.zze = true;
        this.zzf = i;
    }

    public final void zzc(zzmg zzmg) {
        this.zzg |= this.zza != zzmg;
        this.zza = zzmg;
    }

    public final void zzd(int i) {
        boolean z = true;
        if (!this.zzc || this.zzd == 5) {
            this.zzg = true;
            this.zzc = true;
            this.zzd = i;
            return;
        }
        if (i != 5) {
            z = false;
        }
        zzeq.zzd(z);
    }
}
