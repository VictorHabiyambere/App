package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzam;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzexd implements zzexw {
    private final String zza;
    private final zzgge zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfho zze;
    private final zzcjd zzf;

    zzexd(zzgge zzgge, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfho zzfho, zzcjd zzcjd) {
        this.zzb = zzgge;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfho;
        this.zzf = zzcjd;
    }

    public static /* synthetic */ ListenableFuture zzc(zzexd zzexd) {
        zzq zzp = zzexd.zzf.zzp();
        zzcyt zzcyt = new zzcyt();
        zzcyt.zze(zzexd.zzd);
        zzfhm zzfhm = new zzfhm();
        zzfhm.zzt("adUnitId");
        zzfhm.zzH(zzexd.zze.zzd);
        zzfhm.zzs(new com.google.android.gms.ads.internal.client.zzq());
        zzfhm.zzz(true);
        zzcyt.zzi(zzfhm.zzJ());
        zzp.zza(zzcyt.zzj());
        zzam zzam = new zzam();
        zzam.zza(zzexd.zza);
        zzp.zzb(zzam.zzb());
        new zzdfa();
        return zzgft.zze(zzgft.zzm((zzgfk) zzgft.zzo(zzgfk.zzu(zzp.zzc().zzb()), ((Long) zzba.zzc().zza(zzbep.zzhp)).longValue(), TimeUnit.MILLISECONDS, zzexd.zzc), new zzexa(), zzexd.zzb), Exception.class, new zzexb(), zzexd.zzb);
    }

    public final int zza() {
        return 33;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzho)).booleanValue() || this.zze.zzr) {
            return zzgft.zzh(new zzexe((String) null));
        }
        return zzgft.zzk(new zzexc(this), this.zzb);
    }
}
