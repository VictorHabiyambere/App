package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqm implements zzexw {
    private final zzgge zza;
    private final zzfho zzb;
    private final zzfid zzc;

    zzeqm(zzgge zzgge, zzfho zzfho, zzfid zzfid) {
        this.zza = zzgge;
        this.zzb = zzfho;
        this.zzc = zzfid;
    }

    public final int zza() {
        return 5;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeql(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqn zzc() throws Exception {
        String str = null;
        if (((Boolean) zzba.zzc().zza(zzbep.zzhr)).booleanValue() && "requester_type_2".equals(zzp.zzc(this.zzb.zzd))) {
            str = zzfid.zza();
        }
        return new zzeqn(str);
    }
}
