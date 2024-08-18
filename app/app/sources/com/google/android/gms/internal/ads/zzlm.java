package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzlm {
    /* access modifiers changed from: private */
    public long zza;
    /* access modifiers changed from: private */
    public float zzb;
    /* access modifiers changed from: private */
    public long zzc;

    public zzlm() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    /* synthetic */ zzlm(zzlo zzlo, zzll zzll) {
        this.zza = zzlo.zza;
        this.zzb = zzlo.zzb;
        this.zzc = zzlo.zzc;
    }

    public final zzlm zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzeq.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzlm zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzlm zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzeq.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzlo zzg() {
        return new zzlo(this, (zzln) null);
    }
}
