package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzejd implements Callable {
    public final /* synthetic */ zzejf zza;
    public final /* synthetic */ zzfhf zzb;
    public final /* synthetic */ zzfgt zzc;

    public /* synthetic */ zzejd(zzejf zzejf, zzfhf zzfhf, zzfgt zzfgt) {
        this.zza = zzejf;
        this.zzb = zzfhf;
        this.zzc = zzfgt;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
