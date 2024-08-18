package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzj implements zzk {
    public final /* synthetic */ int zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzj(int i, Map map) {
        this.zza = i;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzl.zzb(this.zza, this.zzb, jsonWriter);
    }
}
