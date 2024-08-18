package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzgge;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzal implements Runnable {
    public final /* synthetic */ zzau zza;
    public final /* synthetic */ zzgge zzb;

    public /* synthetic */ zzal(zzau zzau, zzgge zzgge) {
        this.zza = zzau;
        this.zzb = zzgge;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
