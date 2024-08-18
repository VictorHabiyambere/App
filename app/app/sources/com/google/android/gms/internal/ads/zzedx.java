package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedx implements zzgfa {
    public final /* synthetic */ zzeea zza;

    public /* synthetic */ zzedx(zzeea zzeea) {
        this.zza = zzeea;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgft.zzh(zzfip.zza((InputStream) obj));
    }
}
