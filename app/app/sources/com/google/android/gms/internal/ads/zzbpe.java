package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbpe implements zzblp {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbps zzb;
    final /* synthetic */ zzboo zzc;
    final /* synthetic */ zzbpt zzd;

    zzbpe(zzbpt zzbpt, long j, zzbps zzbps, zzboo zzboo) {
        this.zza = j;
        this.zzb = zzbps;
        this.zzc = zzboo;
        this.zzd = zzbpt;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbpu zzbpu = (zzbpu) obj;
        long currentTimeMillis = zzu.zzB().currentTimeMillis() - this.zza;
        zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + currentTimeMillis + " ms.");
        zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1) {
                if (this.zzb.zze() != 1) {
                    this.zzd.zzi = 0;
                    zzboo zzboo = this.zzc;
                    zzboo.zzq("/log", zzblo.zzg);
                    zzboo.zzq("/result", zzblo.zzo);
                    this.zzb.zzi(this.zzc);
                    this.zzd.zzh = this.zzb;
                    zze.zza("Successfully loaded JS Engine.");
                    zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
