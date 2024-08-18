package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzblx implements zzgfp {
    final /* synthetic */ Map zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbmb zzd;

    zzblx(zzbmb zzbmb, Map map, zza zza2, String str) {
        this.zza = map;
        this.zzb = zza2;
        this.zzc = str;
        this.zzd = zzbmb;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (((Boolean) zzba.zzc().zza(zzbep.zzkb)).booleanValue()) {
            this.zza.put("u", str);
        }
        this.zzd.zzh(str, this.zzb, this.zza, this.zzc);
    }
}
