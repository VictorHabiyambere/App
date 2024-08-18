package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzejs implements zzehr {
    private final Context zza;
    private final zzdjh zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzejs(Context context, VersionInfoParcel versionInfoParcel, zzdjh zzdjh, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdjh;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzdih zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdik(new zzejr(this, zzeho), (zzchd) null));
        zze.zzd().zzo(new zzcpt((zzfim) zzeho.zzb), this.zzd);
        ((zzejh) zzeho.zzc).zzc(zze.zzk());
        return zze.zzg();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        zzfho zzfho = zzfhf.zza.zza;
        ((zzfim) zzeho.zzb).zzo(this.zza, zzfho.zzd, zzfgt.zzw.toString(), zzbw.zzm(zzfgt.zzt), (zzbrl) zzeho.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzeho zzeho, boolean z, Context context, zzczy zzczy) throws zzdjo {
        try {
            ((zzfim) zzeho.zzb).zzv(z);
            if (this.zzc.clientJarVersion < ((Integer) zzba.zzc().zza(zzbep.zzaI)).intValue()) {
                ((zzfim) zzeho.zzb).zzx();
            } else {
                ((zzfim) zzeho.zzb).zzy(context);
            }
        } catch (zzfhv e) {
            zzm.zzi("Cannot show interstitial.");
            throw new zzdjo(e.getCause());
        }
    }
}
