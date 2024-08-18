package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbfc {
    private final Map zza = new HashMap();
    private final zzbfe zzb;

    public zzbfc(zzbfe zzbfe) {
        this.zzb = zzbfe;
    }

    public final zzbfe zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbfb zzbfb) {
        this.zza.put(str, zzbfb);
    }

    public final void zzc(String str, String str2, long j) {
        zzbfb zzbfb = (zzbfb) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbfb != null) {
            this.zzb.zze(zzbfb, j, strArr);
        }
        this.zza.put(str, new zzbfb(j, (String) null, (zzbfb) null));
    }
}
