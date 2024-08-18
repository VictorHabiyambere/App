package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaqu implements Runnable {
    private final zzare zza;
    private final zzark zzb;
    private final Runnable zzc;

    public zzaqu(zzare zzare, zzark zzark, Runnable runnable) {
        this.zza = zzare;
        this.zzb = zzark;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzark zzark = this.zzb;
        if (zzark.zzc()) {
            this.zza.zzo(zzark.zza);
        } else {
            this.zza.zzn(zzark.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
