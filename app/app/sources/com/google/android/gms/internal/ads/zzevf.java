package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzevf implements zzexw {
    private final zzgge zza;
    private final zzdya zzb;

    zzevf(zzgge zzgge, zzdya zzdya) {
        this.zza = zzgge;
        this.zzb = zzdya;
    }

    public final int zza() {
        return 23;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeve(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzevg zzc() throws Exception {
        zzdya zzdya = this.zzb;
        String zzc = zzdya.zzc();
        boolean zzr = zzdya.zzr();
        boolean zzl = zzu.zzs().zzl();
        zzdya zzdya2 = this.zzb;
        return new zzevg(zzc, zzr, zzl, zzdya2.zzp(), zzdya2.zzs());
    }
}
