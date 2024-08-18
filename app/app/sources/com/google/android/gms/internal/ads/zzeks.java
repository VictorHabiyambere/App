package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeks extends zzeku {
    private final zzcjd zza;
    private final zzdjy zzb;
    private final zzcyt zzc;
    private final zzdfc zzd;
    private final zzelf zze;
    private final zzehq zzf;

    public zzeks(zzcjd zzcjd, zzdjy zzdjy, zzcyt zzcyt, zzdfc zzdfc, zzelf zzelf, zzehq zzehq) {
        this.zza = zzcjd;
        this.zzb = zzdjy;
        this.zzc = zzcyt;
        this.zzd = zzdfc;
        this.zze = zzelf;
        this.zzf = zzehq;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf) {
        zzcyt zzcyt = this.zzc;
        zzcyt.zzi(zzfho);
        zzcyt.zzf(bundle);
        zzcyt.zzg(new zzcyn(zzfhf, zzfgt, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzcjd zzcjd = this.zza;
        zzcyt zzcyt2 = this.zzc;
        zzdkc zzh = zzcjd.zzh();
        zzh.zzf(zzcyt2.zzj());
        zzh.zze(this.zzd);
        zzh.zzd(this.zzb);
        zzh.zzc(new zzcsc((ViewGroup) null));
        zzcvx zza2 = zzh.zzg().zza();
        return zza2.zzi(zza2.zzj());
    }
}
