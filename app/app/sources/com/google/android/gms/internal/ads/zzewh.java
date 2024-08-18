package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewh implements zzexw {
    private final Bundle zza;

    zzewh(Bundle bundle) {
        this.zza = bundle;
    }

    public final int zza() {
        return 30;
    }

    public final ListenableFuture zzb() {
        return zzgft.zzh(new zzewi(this.zza));
    }
}
