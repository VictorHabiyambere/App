package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeqr implements zzgfa {
    public final ListenableFuture zza(Object obj) {
        if (((Throwable) obj) instanceof TimeoutException) {
            return zzgft.zzh(new zzeqs());
        }
        return zzgft.zzh(new zzeqt());
    }
}
