package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekv extends zzeku {
    private final zzcjd zza;
    private final zzcyt zzb;
    private final zzdfc zzc;
    private final zzelf zzd;
    private final zzehq zze;

    zzekv(zzcjd zzcjd, zzcyt zzcyt, zzdfc zzdfc, zzelf zzelf, zzehq zzehq) {
        this.zza = zzcjd;
        this.zzb = zzcyt;
        this.zzc = zzdfc;
        this.zzd = zzelf;
        this.zze = zzehq;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf) {
        zzcyt zzcyt = this.zzb;
        zzcyt.zzi(zzfho);
        zzcyt.zzf(bundle);
        zzcyt.zzg(new zzcyn(zzfhf, zzfgt, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcjd zzcjd = this.zza;
        zzcyt zzcyt2 = this.zzb;
        zzcrs zzd2 = zzcjd.zzd();
        zzd2.zzd(zzcyt2.zzj());
        zzd2.zzc(this.zzc);
        zzcvx zzb2 = zzd2.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
