package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzebi;
import com.google.android.gms.internal.ads.zzgfa;
import com.google.android.gms.internal.ads.zzgft;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzau implements zzgfa {
    public final /* synthetic */ zzbxu zza;

    public /* synthetic */ zzau(zzbxu zzbxu) {
        this.zza = zzbxu;
    }

    public final ListenableFuture zza(Object obj) {
        zzebi zzebi = (zzebi) obj;
        zzax zzax = new zzax(new JsonReader(new InputStreamReader(zzebi.zzb())), zzebi.zza());
        try {
            zzax.zzb = zzay.zzb().zzi(this.zza.zza).toString();
        } catch (JSONException e) {
            zzax.zzb = "{}";
        }
        return zzgft.zzh(zzax);
    }
}
