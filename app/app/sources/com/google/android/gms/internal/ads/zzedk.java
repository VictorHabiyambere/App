package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedk implements zzgfa {
    public final /* synthetic */ zzexz zza;
    public final /* synthetic */ zzbxu zzb;

    public /* synthetic */ zzedk(zzexz zzexz, zzbxu zzbxu) {
        this.zza = zzexz;
        this.zzb = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(zzay.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
