package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzdik {
    private final zzdjp zza;
    private final zzchd zzb;

    public zzdik(zzdjp zzdjp, zzchd zzchd) {
        this.zza = zzdjp;
        this.zzb = zzchd;
    }

    public static final zzdha zzh(zzflz zzflz) {
        return new zzdha(zzflz, zzcci.zzf);
    }

    public static final zzdha zzi(zzdju zzdju) {
        return new zzdha(zzdju, zzcci.zzf);
    }

    public final View zza() {
        zzchd zzchd = this.zzb;
        if (zzchd == null) {
            return null;
        }
        return zzchd.zzG();
    }

    public final View zzb() {
        zzchd zzchd = this.zzb;
        if (zzchd != null) {
            return zzchd.zzG();
        }
        return null;
    }

    public final zzchd zzc() {
        return this.zzb;
    }

    public final zzdha zzd(Executor executor) {
        return new zzdha(new zzdij(this.zzb), executor);
    }

    public final zzdjp zze() {
        return this.zza;
    }

    public Set zzf(zzcyi zzcyi) {
        return Collections.singleton(new zzdha(zzcyi, zzcci.zzf));
    }

    public Set zzg(zzcyi zzcyi) {
        return Collections.singleton(new zzdha(zzcyi, zzcci.zzf));
    }
}
