package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbor implements zzciu {
    public final /* synthetic */ zzbpc zza;

    public /* synthetic */ zzbor(zzbpc zzbpc) {
        this.zza = zzbpc;
    }

    public final void zza() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        zzbpc zzbpc = this.zza;
        long j = zzbpc.zzc;
        ArrayList arrayList = zzbpc.zzb;
        arrayList.add(Long.valueOf(currentTimeMillis - j));
        String valueOf = String.valueOf(arrayList.get(0));
        zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + valueOf + " ms.");
        zzt.zza.postDelayed(new zzboy(zzbpc.zza, zzbpc.zzd, zzbpc.zze, arrayList, j), (long) ((Integer) zzba.zzc().zza(zzbep.zzc)).intValue());
    }
}
