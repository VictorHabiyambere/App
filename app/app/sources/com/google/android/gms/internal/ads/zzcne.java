package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzao;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcne implements zzq {
    private final zzcla zza;
    private zzcyv zzb;
    private zzao zzc;

    /* synthetic */ zzcne(zzcla zzcla, zzcnd zzcnd) {
        this.zza = zzcla;
    }

    public final /* synthetic */ zzq zza(zzcyv zzcyv) {
        this.zzb = zzcyv;
        return this;
    }

    public final /* synthetic */ zzq zzb(zzao zzao) {
        this.zzc = zzao;
        return this;
    }

    public final zzr zzc() {
        zzhkx.zzc(this.zzb, zzcyv.class);
        zzhkx.zzc(this.zzc, zzao.class);
        return new zzcng(this.zza, this.zzc, new zzcvz(), new zzcxy(), new zzdvq(), this.zzb, (zzfeo) null, (zzfdr) null, (zzcnf) null);
    }
}
