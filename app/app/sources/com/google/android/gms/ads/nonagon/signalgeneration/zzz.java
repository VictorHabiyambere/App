package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcbk;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzz implements Callable {
    public final /* synthetic */ zzaj zza;
    public final /* synthetic */ zzcbk zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzz(zzaj zzaj, zzcbk zzcbk, Bundle bundle) {
        this.zza = zzaj;
        this.zzb = zzcbk;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zzq(this.zzb, this.zzc);
    }
}
