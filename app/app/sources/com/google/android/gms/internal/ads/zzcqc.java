package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcqc implements zzgfp {
    final /* synthetic */ zzfoe zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcqd zzc;

    zzcqc(zzcqd zzcqd, zzfoe zzfoe, String str) {
        this.zza = zzfoe;
        this.zzb = str;
        this.zzc = zzcqd;
    }

    public final void zza(Throwable th) {
        this.zzc.zzg.zza(new zzcqa(this, th, this.zza, this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzg.zza(new zzcqb(this.zza, (String) obj));
    }
}
