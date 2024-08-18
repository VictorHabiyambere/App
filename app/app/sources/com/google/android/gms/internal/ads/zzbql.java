package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbql implements zzbpx {
    /* access modifiers changed from: private */
    public final zzbpz zza;
    private final zzbqa zzb;
    private final zzbpt zzc;
    private final String zzd;

    zzbql(zzbpt zzbpt, String str, zzbqa zzbqa, zzbpz zzbpz) {
        this.zzc = zzbpt;
        this.zzd = str;
        this.zzb = zzbqa;
        this.zza = zzbpz;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbql zzbql, zzbpn zzbpn, zzbpu zzbpu, Object obj, zzccn zzccn) {
        try {
            zzu.zzp();
            String uuid = UUID.randomUUID().toString();
            zzblo.zzo.zzc(uuid, new zzbqk(zzbql, zzbpn, zzccn));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbql.zzb.zzb(obj));
            zzbpu.zzl(zzbql.zzd, jSONObject);
        } catch (Exception e) {
            zzccn.zzd(e);
            zzm.zzh("Unable to invokeJavascript", e);
            zzbpn.zzb();
        } catch (Throwable th) {
            zzbpn.zzb();
            throw th;
        }
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        zzccn zzccn = new zzccn();
        zzbpn zzb2 = this.zzc.zzb((zzaxd) null);
        zze.zza("callJs > getEngine: Promise created");
        zzb2.zzj(new zzbqi(this, zzb2, obj, zzccn), new zzbqj(this, zzccn, zzb2));
        return zzccn;
    }
}
