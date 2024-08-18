package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcme implements zzdwe {
    private final Long zza;
    private final String zzb;
    private final zzcla zzc;
    private final zzcmi zzd;
    private final zzcme zze = this;

    /* synthetic */ zzcme(zzcla zzcla, zzcmi zzcmi, Long l, String str, zzcmd zzcmd) {
        this.zzc = zzcla;
        this.zzd = zzcmi;
        this.zza = l;
        this.zzb = str;
    }

    public final zzdwo zza() {
        zzcmi zzcmi = this.zzd;
        return zzdwp.zza(this.zza.longValue(), zzcmi.zza, zzdwi.zzc(zzcmi.zzb), this.zzc, this.zzb);
    }

    public final zzdws zzb() {
        zzcmi zzcmi = this.zzd;
        return zzdwt.zza(this.zza.longValue(), zzcmi.zza, zzdwi.zzc(zzcmi.zzb), this.zzc, this.zzb);
    }
}
