package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzelk implements zzgfa {
    public final /* synthetic */ zzelm zza;
    public final /* synthetic */ zzfgt zzb;
    public final /* synthetic */ zzfhf zzc;
    public final /* synthetic */ zzehl zzd;

    public /* synthetic */ zzelk(zzelm zzelm, zzfgt zzfgt, zzfhf zzfhf, zzehl zzehl) {
        this.zza = zzelm;
        this.zzb = zzfgt;
        this.zzc = zzfhf;
        this.zzd = zzehl;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, (Throwable) obj);
    }
}
