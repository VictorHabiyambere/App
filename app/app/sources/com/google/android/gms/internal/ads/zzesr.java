package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzesr implements zzexw {
    private final zzfdr zza;

    zzesr(zzfdr zzfdr) {
        this.zza = zzfdr;
    }

    public final int zza() {
        return 15;
    }

    public final ListenableFuture zzb() {
        zzfdr zzfdr = this.zza;
        zzesq zzesq = null;
        if (!(zzfdr == null || zzfdr.zza() == null || zzfdr.zza().isEmpty())) {
            zzesq = new zzesq(this);
        }
        return zzgft.zzh(zzesq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
