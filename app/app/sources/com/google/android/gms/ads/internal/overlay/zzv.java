package com.google.android.gms.ads.internal.overlay;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzv implements Runnable {
    public final /* synthetic */ zzx zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Map zzc;

    public /* synthetic */ zzv(zzx zzx, String str, Map map) {
        this.zza = zzx;
        this.zzb = str;
        this.zzc = map;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc);
    }
}
