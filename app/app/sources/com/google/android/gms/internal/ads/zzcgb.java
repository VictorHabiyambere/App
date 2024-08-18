package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcgb implements zzlk {
    private final zzzv zzb = new zzzv(true, 65536);
    private long zzc = 15000000;
    private long zzd = 30000000;
    private long zze = 2500000;
    private long zzf = 5000000;
    private int zzg;
    private boolean zzh;

    zzcgb() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzg = 0;
        this.zzh = false;
        if (z) {
            this.zzb.zze();
        }
    }

    public final long zzb(zzpj zzpj) {
        return 0;
    }

    public final void zzc(zzpj zzpj) {
        zza(false);
    }

    public final void zzd(zzpj zzpj) {
        zza(true);
    }

    public final void zze(zzpj zzpj) {
        zza(true);
    }

    public final void zzf(zzpj zzpj, zzdc zzdc, zzvo zzvo, zzmn[] zzmnArr, zzxr zzxr, zzzg[] zzzgArr) {
        int i;
        int i2 = 0;
        this.zzg = 0;
        while (true) {
            int length = zzmnArr.length;
            if (i2 < 2) {
                if (zzzgArr[i2] != null) {
                    int i3 = this.zzg;
                    switch (zzmnArr[i2].zzb()) {
                        case 1:
                            i = 13107200;
                            break;
                        default:
                            i = 131072000;
                            break;
                    }
                    this.zzg = i3 + i;
                }
                i2++;
            } else {
                this.zzb.zzf(this.zzg);
                return;
            }
        }
    }

    public final boolean zzg(zzpj zzpj) {
        return false;
    }

    public final boolean zzh(zzpj zzpj, zzdc zzdc, zzvo zzvo, long j, long j2, float f) {
        boolean z = true;
        boolean z2 = j2 > this.zzd ? false : j2 < this.zzc ? true : true;
        int zza = this.zzb.zza();
        int i = this.zzg;
        if (!z2 && (!z2 || !this.zzh || zza >= i)) {
            z = false;
        }
        this.zzh = z;
        return z;
    }

    public final boolean zzi(zzpj zzpj, zzdc zzdc, zzvo zzvo, long j, float f, boolean z, long j2) {
        long j3 = z ? this.zzf : this.zze;
        return j3 <= 0 || j >= j3;
    }

    public final zzzv zzj() {
        return this.zzb;
    }

    public final synchronized void zzk(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zzf = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzc = ((long) i) * 1000;
    }
}
