package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcqv {
    private final String zza;
    private final zzbqq zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcra zzd;
    private final zzblp zze = new zzcqs(this);
    private final zzblp zzf = new zzcqu(this);

    public zzcqv(String str, zzbqq zzbqq, Executor executor) {
        this.zza = str;
        this.zzb = zzbqq;
        this.zzc = executor;
    }

    static /* bridge */ /* synthetic */ boolean zzg(zzcqv zzcqv, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(zzcqv.zza)) {
            return false;
        }
        return true;
    }

    public final void zzc(zzcra zzcra) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcra;
    }

    public final void zzd(zzchd zzchd) {
        zzchd.zzag("/updateActiveView", this.zze);
        zzchd.zzag("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzchd zzchd) {
        zzchd.zzaz("/updateActiveView", this.zze);
        zzchd.zzaz("/untrackActiveViewUnit", this.zzf);
    }
}
