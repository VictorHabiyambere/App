package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcvc implements zzgfp {
    final /* synthetic */ zzgfp zza;
    final /* synthetic */ zzcve zzb;

    zzcvc(zzcve zzcve, zzgfp zzgfp) {
        this.zza = zzgfp;
        this.zzb = zzcve;
    }

    public final void zza(Throwable th) {
        this.zza.zza(th);
        zzcci.zze.execute(new zzcuy(this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcve.zzb(this.zzb, ((zzcux) obj).zza, this.zza);
    }
}
