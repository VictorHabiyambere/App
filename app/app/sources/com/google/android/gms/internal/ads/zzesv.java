package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzesv implements Callable {
    public final /* synthetic */ zzesw zza;

    public /* synthetic */ zzesv(zzesw zzesw) {
        this.zza = zzesw;
    }

    public final Object call() {
        return new zzesx(Long.valueOf(zzu.zzB().currentTimeMillis() - zzu.zzo().zzi().zzh().zza()).longValue());
    }
}
