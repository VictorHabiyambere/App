package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcux implements zzelg {
    public final List zza;

    public zzcux(zzcup zzcup) {
        this.zza = Collections.singletonList(zzgft.zzh(zzcup));
    }

    public zzcux(List list) {
        this.zza = list;
    }

    public final void zzq() {
        for (ListenableFuture zzr : this.zza) {
            zzgft.zzr(zzr, new zzcuw(this), zzggk.zzb());
        }
    }
}
