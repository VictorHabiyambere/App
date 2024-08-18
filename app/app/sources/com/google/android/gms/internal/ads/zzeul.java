package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeul implements zzexw {
    private final Context zza;
    private final zzgge zzb;

    public zzeul(Context context, zzgge zzgge) {
        this.zza = context;
        this.zzb = zzgge;
    }

    public final int zza() {
        return 19;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeuk(this));
    }
}
