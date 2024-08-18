package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcgm implements Runnable {
    public final /* synthetic */ zzcee zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcgm(zzcee zzcee, Map map) {
        this.zza = zzcee;
        this.zzb = map;
    }

    public final void run() {
        int i = zzcgq.zza;
        this.zza.zzd("onGcacheInfoEvent", this.zzb);
    }
}
