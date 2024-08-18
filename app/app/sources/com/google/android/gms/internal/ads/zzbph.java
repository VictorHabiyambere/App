package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbph implements Runnable {
    final /* synthetic */ zzbps zza;
    final /* synthetic */ zzboo zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbpt zze;

    zzbph(zzbpt zzbpt, zzbps zzbps, zzboo zzboo, ArrayList arrayList, long j) {
        this.zza = zzbps;
        this.zzb = zzboo;
        this.zzc = arrayList;
        this.zzd = j;
        this.zze = zzbpt;
    }

    public final void run() {
        String str;
        zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        synchronized (this.zze.zza) {
            zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
            if (this.zza.zze() != -1) {
                if (this.zza.zze() != 1) {
                    if (((Boolean) zzba.zzc().zza(zzbep.zzhO)).booleanValue()) {
                        this.zza.zzh(new TimeoutException("Unable to fully load JS engine."), "SdkJavascriptFactory.loadJavascriptEngine.Runnable");
                    } else {
                        this.zza.zzg();
                    }
                    zzgge zzgge = zzcci.zze;
                    zzboo zzboo = this.zzb;
                    Objects.requireNonNull(zzboo);
                    zzgge.execute(new zzbpg(zzboo));
                    String valueOf = String.valueOf(zzba.zzc().zza(zzbep.zzd));
                    int zze2 = this.zza.zze();
                    int zza2 = this.zze.zzi;
                    if (this.zzc.isEmpty()) {
                        str = ". Still waiting for the engine to be loaded";
                    } else {
                        str = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is " + String.valueOf(this.zzc.get(0));
                    }
                    zze.zza("Could not finish the full JS engine loading in " + valueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + zze2 + ". Update status(fullLoadTimeout) is " + zza2 + str + " ms. Total latency(fullLoadTimeout) is " + (zzu.zzB().currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                    zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
        }
    }
}
