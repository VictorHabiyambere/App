package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekz extends zzeku {
    private final zzcjd zza;
    private final zzcyt zzb;
    private final zzenl zzc;
    private final zzdfc zzd;
    private final zzelf zze;
    private final zzehq zzf;

    public zzekz(zzcjd zzcjd, zzcyt zzcyt, zzenl zzenl, zzdfc zzdfc, zzelf zzelf, zzehq zzehq) {
        this.zza = zzcjd;
        this.zzb = zzcyt;
        this.zzc = zzenl;
        this.zzd = zzdfc;
        this.zze = zzelf;
        this.zzf = zzehq;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf) {
        zzcyt zzcyt = this.zzb;
        zzcyt.zzi(zzfho);
        zzcyt.zzf(bundle);
        zzcyt.zzg(new zzcyn(zzfhf, zzfgt, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcjd zzcjd = this.zza;
        zzcyt zzcyt2 = this.zzb;
        zzdjg zzg = zzcjd.zzg();
        zzg.zze(zzcyt2.zzj());
        zzg.zzd(this.zzd);
        zzg.zzc(this.zzc);
        zzcvx zza2 = zzg.zzf().zza();
        return zza2.zzi(zza2.zzj());
    }
}
