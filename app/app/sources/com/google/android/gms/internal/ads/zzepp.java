package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzbh;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzepp {
    private final zzdme zza;
    private final zzepc zzb;
    private final zzczo zzc = new zzepo(this.zzb, this.zza.zzg());

    public zzepp(zzdme zzdme, zzdvc zzdvc) {
        this.zza = zzdme;
        this.zzb = new zzepc(zzdvc);
    }

    public final zzczo zza() {
        return this.zzc;
    }

    public final zzdaz zzb() {
        return this.zzb;
    }

    public final zzdjy zzc() {
        return new zzdjy(this.zza, this.zzb.zzg());
    }

    public final zzepc zzd() {
        return this.zzb;
    }

    public final void zze(zzbh zzbh) {
        this.zzb.zzj(zzbh);
    }
}
