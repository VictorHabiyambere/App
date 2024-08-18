package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzebz {
    private final zzgge zza;
    private final zzgge zzb;
    private final zzecu zzc;
    private final zzhkj zzd;

    zzebz(zzgge zzgge, zzgge zzgge2, zzecu zzecu, zzhkj zzhkj) {
        this.zza = zzgge;
        this.zzb = zzgge2;
        this.zzc = zzecu;
        this.zzd = zzhkj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbwz zzbwz) throws Exception {
        return this.zzc.zza(zzbwz, ((Long) zzba.zzc().zza(zzbep.zzlD)).longValue());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbwz zzbwz, int i, zzebh zzebh) throws Exception {
        return ((zzeea) this.zzd.zzb()).zzb(zzbwz, i);
    }

    public final ListenableFuture zzc(zzbwz zzbwz) {
        ListenableFuture listenableFuture;
        String str = zzbwz.zzf;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgft.zzg(new zzebh(1, "Ads service proxy force local"));
        } else {
            listenableFuture = zzgft.zzf(zzgft.zzk(new zzebw(this, zzbwz), this.zza), ExecutionException.class, new zzebx(), this.zzb);
        }
        return zzgft.zzf(listenableFuture, zzebh.class, new zzeby(this, zzbwz, Binder.getCallingUid()), this.zzb);
    }
}
