package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzecf {
    private final zzgge zza;
    private final zzgge zzb;
    private final zzecx zzc;

    zzecf(zzgge zzgge, zzgge zzgge2, zzecx zzecx) {
        this.zza = zzgge;
        this.zzb = zzgge2;
        this.zzc = zzecx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbwv zzbwv) throws Exception {
        return this.zzc.zza(zzbwv, ((Long) zzba.zzc().zza(zzbep.zzlC)).longValue());
    }

    public final ListenableFuture zzb(zzbwv zzbwv) {
        ListenableFuture listenableFuture;
        String str = zzbwv.zzb;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgft.zzg(new zzebh(1, "Ads signal service force local"));
        } else {
            listenableFuture = zzgft.zzf(zzgft.zzk(new zzecb(this, zzbwv), this.zza), ExecutionException.class, new zzecc(), this.zzb);
        }
        return zzgft.zzn(zzgft.zzf(zzgfk.zzu(listenableFuture), zzebh.class, new zzecd(), this.zzb), new zzece(), this.zzb);
    }
}
