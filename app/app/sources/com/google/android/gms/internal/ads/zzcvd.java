package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcvd implements zzgfp {
    final /* synthetic */ zzgfp zza;
    final /* synthetic */ zzcve zzb;

    zzcvd(zzcve zzcve, zzgfp zzgfp) {
        this.zza = zzgfp;
        this.zzb = zzcve;
    }

    public final void zza(Throwable th) {
        zzcci.zze.execute(new zzcuy(this.zzb));
        this.zza.zza(th);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcci.zze.execute(new zzcuy(this.zzb));
        this.zza.zzb((zzcup) obj);
    }
}
