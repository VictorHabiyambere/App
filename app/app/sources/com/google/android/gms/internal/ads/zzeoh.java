package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeoh implements zzepr {
    final /* synthetic */ zzeoi zza;

    zzeoh(zzeoi zzeoi) {
        this.zza = zzeoi;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcsf zzcsf = (zzcsf) obj;
        synchronized (this.zza) {
            zzeoi zzeoi = this.zza;
            if (zzeoi.zzi != null) {
                zzeoi.zzi.zzb();
            }
            this.zza.zzi = zzcsf;
            this.zza.zzi.zzj();
        }
    }
}
