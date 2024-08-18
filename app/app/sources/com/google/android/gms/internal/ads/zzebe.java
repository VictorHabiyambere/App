package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzebe implements zzebg {
    private final Map zza;
    private final zzgge zzb;
    /* access modifiers changed from: private */
    public final zzdce zzc;

    public zzebe(Map map, zzgge zzgge, zzdce zzdce) {
        this.zza = map;
        this.zzb = zzgge;
        this.zzc = zzdce;
    }

    public final ListenableFuture zzb(zzbxu zzbxu) {
        this.zzc.zzdn(zzbxu);
        ListenableFuture zzg = zzgft.zzg(new zzdzd(3));
        for (String trim : ((String) zzba.zzc().zza(zzbep.zzin)).split(",")) {
            zzhlg zzhlg = (zzhlg) this.zza.get(trim.trim());
            if (zzhlg != null) {
                zzg = zzgft.zzf(zzg, zzdzd.class, new zzebc(zzhlg, zzbxu), this.zzb);
            }
        }
        zzgft.zzr(zzg, new zzebd(this), zzcci.zzf);
        return zzg;
    }
}
