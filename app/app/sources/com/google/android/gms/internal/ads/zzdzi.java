package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdzi {
    private final zzgge zza;
    private final zzgge zzb;
    private final zzeap zzc;
    private final zzhkj zzd;

    public zzdzi(zzgge zzgge, zzgge zzgge2, zzeap zzeap, zzhkj zzhkj) {
        this.zza = zzgge;
        this.zzb = zzgge2;
        this.zzc = zzeap;
        this.zzd = zzhkj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebi zza(zzbxu zzbxu) throws Exception {
        return (zzebi) this.zzc.zza(zzbxu).get((long) ((Integer) zzba.zzc().zza(zzbep.zzfF)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbxu zzbxu, int i, zzebh zzebh) throws Exception {
        return zzgft.zzn(((zzedq) this.zzd.zzb()).zzc(zzbxu, i), new zzdze(zzbxu), this.zzb);
    }

    public final ListenableFuture zzc(zzbxu zzbxu) {
        ListenableFuture listenableFuture;
        String str = zzbxu.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgft.zzg(new zzebh(1));
        } else {
            listenableFuture = zzgft.zzf(this.zza.zzb(new zzdzf(this, zzbxu)), ExecutionException.class, new zzdzg(), this.zzb);
        }
        return zzgft.zzf(listenableFuture, zzebh.class, new zzdzh(this, zzbxu, Binder.getCallingUid()), this.zzb);
    }
}
