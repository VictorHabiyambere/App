package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzlw implements Runnable {
    public final /* synthetic */ zzmb zza;
    public final /* synthetic */ Pair zzb;
    public final /* synthetic */ zzvf zzc;
    public final /* synthetic */ zzvk zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzlw(zzmb zzmb, Pair pair, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        this.zza = zzmb;
        this.zzb = pair;
        this.zzc = zzvf;
        this.zzd = zzvk;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        Pair pair = this.zzb;
        this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzvo) pair.second, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
