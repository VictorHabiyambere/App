package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcan {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzcau zzd;

    private zzcan() {
        throw null;
    }

    /* synthetic */ zzcan(zzcam zzcam) {
    }

    public final zzcan zza(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzcan zzb(Context context) {
        if (context != null) {
            this.zza = context;
            return this;
        }
        throw null;
    }

    public final zzcan zzc(Clock clock) {
        if (clock != null) {
            this.zzb = clock;
            return this;
        }
        throw null;
    }

    public final zzcan zzd(zzcau zzcau) {
        this.zzd = zzcau;
        return this;
    }

    public final zzcav zze() {
        zzhkx.zzc(this.zza, Context.class);
        zzhkx.zzc(this.zzb, Clock.class);
        zzhkx.zzc(this.zzc, zzg.class);
        zzhkx.zzc(this.zzd, zzcau.class);
        return new zzcap(this.zza, this.zzb, this.zzc, this.zzd, (zzcao) null);
    }
}
