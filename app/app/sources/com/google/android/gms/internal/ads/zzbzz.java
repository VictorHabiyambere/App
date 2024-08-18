package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbzz implements zzgfp {
    final /* synthetic */ ListenableFuture zza;

    zzbzz(zzcaa zzcaa, ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    public final void zza(Throwable th) {
        zzcaa.zzc.remove(this.zza);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        zzcaa.zzc.remove(this.zza);
    }
}
