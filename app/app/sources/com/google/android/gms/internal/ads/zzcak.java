package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcak {
    private final Clock zza;
    private final zzcai zzb;

    zzcak(Clock clock, zzcai zzcai) {
        this.zza = clock;
        this.zzb = zzcai;
    }

    public static zzcak zza(Context context) {
        return zzcav.zzd(context).zzb();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(zzff zzff) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
