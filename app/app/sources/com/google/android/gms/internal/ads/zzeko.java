package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeko implements zzgfp {
    final /* synthetic */ zzfgt zza;
    final /* synthetic */ zzekp zzb;

    zzeko(zzekp zzekp, zzfgt zzfgt) {
        this.zza = zzfgt;
        this.zzb = zzekp;
    }

    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            zzfgt zza2 = this.zzb.zzh.zza();
            if (this.zza.zzaw) {
                while (zza2 != null) {
                    this.zzb.zze(zza2);
                    zza2 = this.zzb.zzh.zza();
                }
            } else if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzelg zzelg = (zzelg) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzelg, this.zza);
            zzfgt zza2 = this.zzb.zzh.zza();
            if (zza2 != null) {
                this.zzb.zze(zza2);
            }
        }
    }
}
