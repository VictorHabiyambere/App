package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcpy implements zzgfa {
    public final /* synthetic */ zzcqd zza;
    public final /* synthetic */ Uri.Builder zzb;

    public /* synthetic */ zzcpy(zzcqd zzcqd, Uri.Builder builder) {
        this.zza = zzcqd;
        this.zzb = builder;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zze(this.zzb, (Throwable) obj);
    }
}
