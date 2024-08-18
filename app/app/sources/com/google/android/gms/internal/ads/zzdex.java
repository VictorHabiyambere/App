package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdex implements Runnable {
    public final /* synthetic */ zzdey zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdex(zzdey zzdey, Object obj) {
        this.zza = zzdey;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzu.zzo().zzv(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
