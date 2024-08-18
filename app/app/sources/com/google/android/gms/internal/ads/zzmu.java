package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzmu implements zzlp {
    private final zzer zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzcl zze = zzcl.zza;

    public zzmu(zzer zzer) {
        this.zza = zzer;
    }

    public final long zza() {
        long j = this.zzc;
        if (!this.zzb) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzcl zzcl = this.zze;
        if (zzcl.zzc == 1.0f) {
            return j + zzgd.zzr(elapsedRealtime);
        }
        return j + zzcl.zza(elapsedRealtime);
    }

    public final void zzb(long j) {
        this.zzc = j;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final zzcl zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    public final void zzg(zzcl zzcl) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzcl;
    }

    public final /* synthetic */ boolean zzj() {
        throw null;
    }
}
