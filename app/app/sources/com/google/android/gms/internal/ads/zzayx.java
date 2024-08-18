package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzayx implements Callable {
    private final zzaye zza;
    private final zzatp zzb;

    public zzayx(zzaye zzaye, zzatp zzatp) {
        this.zza = zzaye;
        this.zzb = zzatp;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzaus zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                this.zzb.zzaY(zzc.zzaV(), zzhay.zza());
            }
            return null;
        } catch (zzhcd | NullPointerException e) {
            return null;
        }
    }
}
