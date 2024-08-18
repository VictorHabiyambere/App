package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzedw implements zzgfa {
    public final /* synthetic */ zzezm zza;

    public /* synthetic */ zzedw(zzezm zzezm) {
        this.zza = zzezm;
    }

    public final ListenableFuture zza(Object obj) {
        Void voidR = (Void) obj;
        return this.zza.zza().zza(new JSONObject(), new Bundle());
    }
}
