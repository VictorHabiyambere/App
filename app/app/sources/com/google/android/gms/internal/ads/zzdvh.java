package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdvh extends zzdvk {
    private final CsiParamDefaults zzg;

    public zzdvh(Executor executor, zzr zzr, CsiParamDefaults csiParamDefaults, CsiUrlBuilder csiUrlBuilder, Context context) {
        super(executor, zzr, csiUrlBuilder, context);
        this.zzg = csiParamDefaults;
        this.zzg.set(this.zzb);
    }

    public final Map zza() {
        return new HashMap(this.zzb);
    }
}
