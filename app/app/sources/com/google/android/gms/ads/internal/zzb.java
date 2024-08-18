package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzcaf;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzcaf zzc;
    private final zzbwx zzd = new zzbwx(false, Collections.emptyList());

    public zzb(Context context, zzcaf zzcaf, zzbwx zzbwx) {
        this.zza = context;
        this.zzc = zzcaf;
    }

    private final boolean zzd() {
        zzcaf zzcaf = this.zzc;
        return (zzcaf != null && zzcaf.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcaf zzcaf = this.zzc;
            if (zzcaf != null) {
                zzcaf.zzd(str, (Map) null, 3);
                return;
            }
            zzbwx zzbwx = this.zzd;
            if (zzbwx.zza && (list = zzbwx.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        Context context = this.zza;
                        zzu.zzp();
                        zzt.zzL(context, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
