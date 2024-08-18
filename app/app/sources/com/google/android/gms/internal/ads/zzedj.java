package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedj implements zzgfa {
    public final /* synthetic */ zzedq zza;

    public /* synthetic */ zzedj(zzedq zzedq) {
        this.zza = zzedq;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgft.zzh(zzfip.zza((InputStream) obj));
    }
}
