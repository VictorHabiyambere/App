package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.AdRequest;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzd implements Callable {
    public final /* synthetic */ zze zza;
    public final /* synthetic */ AdRequest zzb;
    public final /* synthetic */ zzf zzc;

    public /* synthetic */ zzd(zze zze, AdRequest adRequest, zzf zzf) {
        this.zza = zze;
        this.zzb = adRequest;
        this.zzc = zzf;
    }

    public final Object call() {
        return this.zza.zza(this.zzb, this.zzc);
    }
}
