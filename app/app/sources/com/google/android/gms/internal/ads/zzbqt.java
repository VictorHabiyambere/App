package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbqt implements zzgfa {
    private final zzbpz zza;
    private final zzbqa zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzd;

    zzbqt(ListenableFuture listenableFuture, String str, zzbqa zzbqa, zzbpz zzbpz) {
        this.zzd = listenableFuture;
        this.zzb = zzbqa;
        this.zza = zzbpz;
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        return zzgft.zzn(this.zzd, new zzbqr(this, obj), zzcci.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Object obj, zzbpu zzbpu) throws Exception {
        zzccn zzccn = new zzccn();
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        zzblo.zzo.zzc(uuid, new zzbqs(this, zzccn));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbpu.zzl(this.zzc, jSONObject);
        return zzccn;
    }
}
