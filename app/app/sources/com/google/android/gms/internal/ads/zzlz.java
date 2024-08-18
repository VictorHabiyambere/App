package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzlz implements Runnable {
    public final /* synthetic */ zzmb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzvk zzc;

    public /* synthetic */ zzlz(zzmb zzmb, Pair pair, zzvk zzvk) {
        this.zza = zzmb;
        this.zzb = pair;
        this.zzc = zzvk;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzvo) pair.second, this.zzc);
    }
}
