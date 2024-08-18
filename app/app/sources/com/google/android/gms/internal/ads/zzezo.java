package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzezo implements zzexw {
    private final Context zza;
    private final String zzb;
    private final zzgge zzc;

    public zzezo(zzbxw zzbxw, Context context, String str, zzgge zzgge) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzgge;
    }

    public final int zza() {
        return 42;
    }

    public final ListenableFuture zzb() {
        return this.zzc.zzb(new zzezn(this));
    }
}
