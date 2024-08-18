package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzepj implements zzepr {
    final /* synthetic */ zzepk zza;

    zzepj(zzepk zzepk) {
        this.zza = zzepk;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdig zzdig = (zzdig) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdig;
            this.zza.zzj.zzj();
        }
    }
}
