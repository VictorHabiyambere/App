package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
abstract class zzagg {
    protected final zzafa zza;

    protected zzagg(zzafa zzafa) {
        this.zza = zzafa;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzfu zzfu) throws zzch;

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzfu zzfu, long j) throws zzch;

    public final boolean zzf(zzfu zzfu, long j) throws zzch {
        return zza(zzfu) && zzb(zzfu, j);
    }
}
