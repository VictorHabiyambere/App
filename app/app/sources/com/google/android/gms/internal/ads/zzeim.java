package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeim implements zzehl {
    private final zzctg zza;
    private final Context zzb;
    private final zzdsd zzc;
    private final zzfho zzd;
    private final Executor zze;
    private final zzfxu zzf;

    public zzeim(zzctg zzctg, Context context, Executor executor, zzdsd zzdsd, zzfho zzfho, zzfxu zzfxu) {
        this.zzb = context;
        this.zza = zzctg;
        this.zze = executor;
        this.zzc = zzdsd;
        this.zzd = zzfho;
        this.zzf = zzfxu;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        return zzgft.zzn(zzgft.zzh((Object) null), new zzeil(this, zzfhf, zzfgt), this.zze);
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        zzfgy zzfgy = zzfgt.zzt;
        return (zzfgy == null || zzfgy.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfhf zzfhf, zzfgt zzfgt, Object obj) throws Exception {
        View view;
        zzq zza2 = zzfhu.zza(this.zzb, zzfgt.zzv);
        zzchd zza3 = this.zzc.zza(zza2, zzfgt, zzfhf.zzb.zzb);
        zza3.zzac(zzfgt.zzX);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() || !zzfgt.zzah) {
            view = new zzdsg(this.zzb, (View) zza3, (zzau) this.zzf.apply(zzfgt));
        } else {
            view = zzcub.zza(this.zzb, (View) zza3, zzfgt);
        }
        zzctg zzctg = this.zza;
        zzcvf zzcvf = new zzcvf(zzfhf, zzfgt, (String) null);
        Objects.requireNonNull(zza3);
        zzcsg zza4 = zzctg.zza(zzcvf, new zzcsm(view, zza3, new zzeig(zza3), zzfhu.zzb(zza2)));
        zza4.zzh().zzi(zza3, false, (zzbls) null);
        zza4.zzc().zzo(new zzeih(zza3), zzcci.zzf);
        String str = zzfgt.zzt.zza;
        if (((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && zza4.zzi().zze(true)) {
            str = zzcio.zzb(str, zzcio.zza(zzfgt));
        }
        zza4.zzh();
        ListenableFuture zzj = zzdsc.zzj(zza3, zzfgt.zzt.zzb, str);
        if (zzfgt.zzN) {
            Objects.requireNonNull(zza3);
            zzj.addListener(new zzeii(zza3), this.zze);
        }
        zzj.addListener(new zzeij(this, zza3), this.zze);
        return zzgft.zzm(zzj, new zzeik(zza4), zzcci.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzchd zzchd) {
        zzchd.zzab();
        zzcif zzq = zzchd.zzq();
        zzfk zzfk = this.zzd.zza;
        if (!(zzfk == null || zzq == null)) {
            zzq.zzs(zzfk);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzbj)).booleanValue() && !zzchd.isAttachedToWindow()) {
            zzchd.onPause();
            zzchd.zzav(true);
        }
    }
}
