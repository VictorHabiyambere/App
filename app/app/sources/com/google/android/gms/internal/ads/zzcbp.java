package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcbp {
    public final ListenableFuture zza(Context context, int i) {
        zzccn zzccn = new zzccn();
        zzay.zzb();
        if (zzf.zzu(context)) {
            zzcci.zza.execute(new zzcbo(this, context, zzccn));
        }
        return zzccn;
    }
}
