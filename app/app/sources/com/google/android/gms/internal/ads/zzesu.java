package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzesu implements zzexw {
    private final AtomicReference zza = new AtomicReference();
    private final Clock zzb;
    private final zzexw zzc;
    private final long zzd;

    public zzesu(zzexw zzexw, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzexw;
        this.zzd = j;
    }

    public final int zza() {
        return 16;
    }

    public final ListenableFuture zzb() {
        zzest zzest = (zzest) this.zza.get();
        if (zzest == null || zzest.zza()) {
            zzexw zzexw = this.zzc;
            zzest zzest2 = new zzest(zzexw.zzb(), this.zzd, this.zzb);
            this.zza.set(zzest2);
            zzest = zzest2;
        }
        return zzest.zza;
    }
}
