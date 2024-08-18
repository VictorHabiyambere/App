package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcpu implements zzgfa {
    public final /* synthetic */ zzcqd zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzcpu(zzcqd zzcqd, String str) {
        this.zza = zzcqd;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (Throwable) obj);
    }
}
