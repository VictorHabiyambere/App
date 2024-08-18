package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzly implements Runnable {
    public final /* synthetic */ zzmb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzvf zzc;
    public final /* synthetic */ zzvk zzd;

    public /* synthetic */ zzly(zzmb zzmb, Pair pair, zzvf zzvf, zzvk zzvk) {
        this.zza = zzmb;
        this.zzb = pair;
        this.zzc = zzvf;
        this.zzd = zzvk;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzvo) pair.second, this.zzc, this.zzd);
    }
}
