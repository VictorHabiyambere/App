package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcpz implements zzgfa {
    public final /* synthetic */ Uri.Builder zza;

    public /* synthetic */ zzcpz(Uri.Builder builder) {
        this.zza = builder;
    }

    public final ListenableFuture zza(Object obj) {
        zzbeg zzbeg = zzbep.zzkj;
        Uri.Builder builder = this.zza;
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbeg), "12");
        return zzgft.zzh(builder.toString());
    }
}
