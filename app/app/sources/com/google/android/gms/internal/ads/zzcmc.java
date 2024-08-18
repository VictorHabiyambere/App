package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcmc implements zzdwd {
    private final zzcla zza;
    private final zzcmi zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcmc(zzcla zzcla, zzcmi zzcmi, zzcmb zzcmb) {
        this.zza = zzcla;
        this.zzb = zzcmi;
    }

    public final /* synthetic */ zzdwd zza(String str) {
        if (str != null) {
            this.zzd = str;
            return this;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ zzdwd zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzdwe zzc() {
        zzhkx.zzc(this.zzc, Long.class);
        zzhkx.zzc(this.zzd, String.class);
        return new zzcme(this.zza, this.zzb, this.zzc, this.zzd, (zzcmd) null);
    }
}
