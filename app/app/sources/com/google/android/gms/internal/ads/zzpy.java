package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpy {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;

    public final zzpy zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzpy zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzpy zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzqa zzd() {
        if (this.zza || (!this.zzb && !this.zzc)) {
            return new zzqa(this, (zzpz) null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
