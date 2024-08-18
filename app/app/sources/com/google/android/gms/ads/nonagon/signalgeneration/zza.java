package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zza implements Runnable {
    public final /* synthetic */ zze zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Pair zzc;

    public /* synthetic */ zza(zze zze, Object obj, Pair pair) {
        this.zza = zze;
        this.zzb = obj;
        this.zzc = pair;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc);
    }
}
