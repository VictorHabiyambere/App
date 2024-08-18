package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzarc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzare zzc;

    zzarc(zzare zzare, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzare;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzare zzare = this.zzc;
        zzare.zza.zzb(zzare.toString());
    }
}
