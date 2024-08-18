package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbkn implements zzblp {
    public final /* synthetic */ zzdhi zza;
    public final /* synthetic */ zzcqd zzb;

    public /* synthetic */ zzbkn(zzdhi zzdhi, zzcqd zzcqd) {
        this.zza = zzdhi;
        this.zzb = zzcqd;
    }

    public final void zza(Object obj, Map map) {
        zzchd zzchd = (zzchd) obj;
        zzblo.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzgft.zzr(zzgft.zzn(zzgfk.zzu(zzblo.zza(zzchd, str)), new zzbkp(this.zzb, str), zzcci.zza), new zzbld(zzchd), zzcci.zza);
    }
}
