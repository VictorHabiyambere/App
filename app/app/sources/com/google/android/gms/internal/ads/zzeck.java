package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeck {
    private final zzgge zza;
    private final zzecf zzb;
    private final zzflt zzc;

    zzeck(zzgge zzgge, zzecf zzecf, zzflt zzflt) {
        this.zza = zzgge;
        this.zzb = zzecf;
        this.zzc = zzflt;
    }

    public final ListenableFuture zza(zzbxu zzbxu) {
        zzflk zzb2 = this.zzc.zzb(zzfln.GMS_SIGNALS, zzgft.zzm(zzgft.zzh((Object) null), new zzech(zzbxu), this.zza));
        zzecf zzecf = this.zzb;
        Objects.requireNonNull(zzecf);
        return zzgft.zzm(zzb2.zzf(new zzeci(zzecf)).zza(), new zzecj(this, zzbxu), this.zza);
    }
}
