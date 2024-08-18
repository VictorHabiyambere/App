package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdzo implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzdzo(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* synthetic */ Object zzb() {
        CookieManager zza2 = zzu.zzq().zza((Context) this.zzb.zzb());
        zzfln zzfln = zzfln.WEBVIEW_COOKIE;
        return zzfld.zza(new zzdzl(zza2), zzfln, (zzflt) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfle(new zzdzm())).zza();
    }
}
