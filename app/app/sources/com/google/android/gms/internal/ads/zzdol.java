package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdol implements zzgfa {
    public final /* synthetic */ zzdow zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdol(zzdow zzdow, String str) {
        this.zza = zzdow;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, obj);
    }
}
