package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfad implements zzexw {
    final zzgge zza;
    final Context zzb;
    final zzbdb zzc;

    public zzfad(zzbdb zzbdb, zzgge zzgge, Context context) {
        this.zzc = zzbdb;
        this.zza = zzgge;
        this.zzb = context;
    }

    public final int zza() {
        return 45;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzfac(this));
    }
}
