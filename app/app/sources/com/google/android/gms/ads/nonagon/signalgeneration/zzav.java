package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzeac;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgft;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzav implements zzgfa {
    private final Executor zza;
    private final zzeac zzb;

    public zzav(Executor executor, zzeac zzeac) {
        this.zza = executor;
        this.zzb = zzeac;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbxu zzbxu = (zzbxu) obj;
        return zzgft.zzn(this.zzb.zzc(zzbxu), new zzau(zzbxu), this.zza);
    }
}
