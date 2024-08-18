package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbdu {
    zzbai zza;
    boolean zzb;
    /* access modifiers changed from: private */
    public final ExecutorService zzc = zzb.zzb;

    public zzbdu() {
    }

    public zzbdu(Context context) {
        this.zzc.execute(new zzbdp(this, context));
    }
}
