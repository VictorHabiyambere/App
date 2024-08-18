package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzawx implements Runnable {
    final /* synthetic */ zzawy zza;

    zzawx(zzawy zzawy) {
        this.zza = zzawy;
    }

    public final void run() {
        boolean z;
        if (this.zza.zzb == null) {
            synchronized (zzawy.zzc) {
                if (this.zza.zzb == null) {
                    boolean z2 = false;
                    try {
                        z = ((Boolean) zzbep.zzcy.zze()).booleanValue();
                    } catch (IllegalStateException e) {
                        z = false;
                    }
                    if (z) {
                        try {
                            zzawy.zza = zzftk.zzb(this.zza.zze.zza, "ADSHIELD", (String) null);
                        } catch (Throwable th) {
                        }
                    }
                    z2 = z;
                    this.zza.zzb = Boolean.valueOf(z2);
                    zzawy.zzc.open();
                }
            }
        }
    }
}
