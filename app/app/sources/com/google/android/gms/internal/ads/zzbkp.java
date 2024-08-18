package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbkp implements zzgfa {
    public final /* synthetic */ zzcqd zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbkp(zzcqd zzcqd, String str) {
        this.zza = zzcqd;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        zzcqd zzcqd;
        String str = (String) obj;
        zzblp zzblp = zzblo.zza;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzka)).booleanValue() || (zzcqd = this.zza) == null || !zzcqd.zzj(this.zzb)) {
            return zzgft.zzh(str);
        }
        return zzcqd.zzb(str, zzay.zze());
    }
}
