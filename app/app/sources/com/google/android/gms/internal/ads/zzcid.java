package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcid implements Runnable {
    public final /* synthetic */ zzcif zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcid(zzcif zzcif, Map map) {
        this.zza = zzcif;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
