package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzfac implements Callable {
    public final /* synthetic */ zzfad zza;

    public /* synthetic */ zzfac(zzfad zzfad) {
        this.zza = zzfad;
    }

    public final Object call() {
        return new zzfae(new JSONObject());
    }
}
