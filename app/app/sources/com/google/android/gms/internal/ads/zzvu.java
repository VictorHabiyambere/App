package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzvu implements Runnable {
    public final /* synthetic */ zzvx zza;
    public final /* synthetic */ zzvy zzb;
    public final /* synthetic */ zzvf zzc;
    public final /* synthetic */ zzvk zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzvu(zzvx zzvx, zzvy zzvy, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        this.zza = zzvx;
        this.zzb = zzvy;
        this.zzc = zzvf;
        this.zzd = zzvk;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        this.zzb.zzah(0, this.zza.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
