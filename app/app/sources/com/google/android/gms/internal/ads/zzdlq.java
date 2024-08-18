package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdlq {
    private zzbhs zza;

    public zzdlq(zzdlc zzdlc) {
        this.zza = zzdlc;
    }

    public final synchronized zzbhs zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbhs zzbhs) {
        this.zza = zzbhs;
    }
}
