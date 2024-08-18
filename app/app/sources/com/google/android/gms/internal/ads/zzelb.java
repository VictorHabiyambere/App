package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzelb extends zzeku {
    private final zzcjd zza;
    private final zzcyt zzb;
    private final zzdfc zzc;
    private final zzelf zzd;
    @Nullable
    private final zzfhg zze;
    private final zzehq zzf;

    public zzelb(zzcjd zzcjd, zzcyt zzcyt, zzdfc zzdfc, @Nullable zzfhg zzfhg, zzelf zzelf, zzehq zzehq) {
        this.zza = zzcjd;
        this.zzb = zzcyt;
        this.zzc = zzdfc;
        this.zze = zzfhg;
        this.zzd = zzelf;
        this.zzf = zzehq;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf) {
        zzfhg zzfhg;
        zzcyt zzcyt = this.zzb;
        zzcyt.zzi(zzfho);
        zzcyt.zzf(bundle);
        zzcyt.zzg(new zzcyn(zzfhf, zzfgt, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdz)).booleanValue() && (zzfhg = this.zze) != null) {
            this.zzb.zzh(zzfhg);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcjd zzcjd = this.zza;
        zzcyt zzcyt2 = this.zzb;
        zzdrl zzi = zzcjd.zzi();
        zzi.zzd(zzcyt2.zzj());
        zzi.zzc(this.zzc);
        zzcvx zzb2 = zzi.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
