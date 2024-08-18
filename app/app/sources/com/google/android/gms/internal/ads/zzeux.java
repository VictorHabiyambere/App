package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeux implements zzexw {
    private final zzgge zza;
    private final zzfho zzb;

    zzeux(zzgge zzgge, zzfho zzfho) {
        this.zza = zzgge;
        this.zzb = zzfho;
    }

    public final int zza() {
        return 21;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeuw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeuy zzc() throws Exception {
        return new zzeuy("requester_type_2".equals(zzp.zzc(this.zzb.zzd)));
    }
}
