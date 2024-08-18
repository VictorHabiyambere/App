package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcuh {
    private final zzdca zza;
    private final zzdeh zzb;

    public zzcuh(zzdca zzdca, zzdeh zzdeh) {
        this.zza = zzdca;
        this.zzb = zzdeh;
    }

    public final zzdca zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzdeh zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzdha zzc() {
        zzdeh zzdeh = this.zzb;
        if (zzdeh != null) {
            return new zzdha(zzdeh, zzcci.zzf);
        }
        return new zzdha(new zzcug(this), zzcci.zzf);
    }
}
