package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzexx implements Runnable {
    public final /* synthetic */ zzexz zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzexw zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzexx(zzexz zzexz, long j, zzexw zzexw, Bundle bundle) {
        this.zza = zzexz;
        this.zzb = j;
        this.zzc = zzexw;
        this.zzd = bundle;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
