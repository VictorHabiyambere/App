package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdvc {
    /* access modifiers changed from: private */
    public final zzdvh zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzdvc(zzdvh zzdvh, Executor executor) {
        this.zza = zzdvh;
        this.zzc = zzdvh.zza();
        this.zzb = executor;
    }

    public final zzdvb zza() {
        zzdvb zzdvb = new zzdvb(this);
        zzdvb unused = zzdvb.zzb.putAll(zzdvb.zza.zzc);
        return zzdvb;
    }

    public final void zze() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlG)).booleanValue()) {
            zzdvb zza2 = zza();
            zza2.zzb("action", "pecr");
            zza2.zzf();
        }
    }
}
