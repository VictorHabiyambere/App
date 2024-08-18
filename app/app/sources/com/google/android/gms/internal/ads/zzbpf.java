package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzcc;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbpf implements zzblp {
    final /* synthetic */ zzboo zza;
    final /* synthetic */ zzcc zzb;
    final /* synthetic */ zzbpt zzc;

    zzbpf(zzbpt zzbpt, zzaxd zzaxd, zzboo zzboo, zzcc zzcc) {
        this.zza = zzboo;
        this.zzb = zzcc;
        this.zzc = zzbpt;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzblp, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbpu zzbpu = (zzbpu) obj;
        zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            zzm.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zzm.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzaxd) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
        zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
