package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeie implements zzehr {
    private final Context zza;
    private final zzcrt zzb;

    zzeie(Context context, zzcrt zzcrt) {
        this.zza = context;
        this.zzb = zzcrt;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzejq zzejq = new zzejq(zzfgt, (zzbte) zzeho.zzb, AdFormat.APP_OPEN_AD);
        zzcrq zza2 = this.zzb.zza(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdik(zzejq, (zzchd) null), new zzcrr(zzfgt.zzab));
        zzejq.zzb(zza2.zzc());
        ((zzejh) zzeho.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            ((zzbte) zzeho.zzb).zzq(zzfgt.zzaa);
            ((zzbte) zzeho.zzb).zzi(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeid(zzeho, (zzeic) null), (zzbrl) zzeho.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfhv(e);
        }
    }
}
