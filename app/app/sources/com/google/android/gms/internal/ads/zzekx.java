package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekx extends zzeku {
    private final zzcjd zza;
    private final zzcyt zzb;
    private final zzenl zzc;
    private final zzdfc zzd;
    private final zzdjy zze;
    private final zzdca zzf;
    private final ViewGroup zzg;
    private final zzdeh zzh;
    private final zzelf zzi;
    private final zzehq zzj;

    public zzekx(zzcjd zzcjd, zzcyt zzcyt, zzenl zzenl, zzdfc zzdfc, zzdjy zzdjy, zzdca zzdca, ViewGroup viewGroup, zzdeh zzdeh, zzelf zzelf, zzehq zzehq) {
        this.zza = zzcjd;
        this.zzb = zzcyt;
        this.zzc = zzenl;
        this.zzd = zzdfc;
        this.zze = zzdjy;
        this.zzf = zzdca;
        this.zzg = viewGroup;
        this.zzh = zzdeh;
        this.zzi = zzelf;
        this.zzj = zzehq;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf) {
        zzcyt zzcyt = this.zzb;
        zzcyt.zzi(zzfho);
        zzcyt.zzf(bundle);
        zzcyt.zzg(new zzcyn(zzfhf, zzfgt, this.zzi));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            this.zzb.zzd(this.zzj);
        }
        zzcjd zzcjd = this.zza;
        zzcyt zzcyt2 = this.zzb;
        zzctf zze2 = zzcjd.zze();
        zze2.zzi(zzcyt2.zzj());
        zze2.zzf(this.zzd);
        zze2.zze(this.zzc);
        zze2.zzd(this.zze);
        zze2.zzg(new zzcuh(this.zzf, this.zzh));
        zze2.zzc(new zzcsc(this.zzg));
        zzcvx zzd2 = zze2.zzk().zzd();
        return zzd2.zzi(zzd2.zzj());
    }
}
