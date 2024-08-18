package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzejw implements zzehr {
    private final Context zza;
    private final zzdjh zzb;

    public zzejw(Context context, zzdjh zzdjh) {
        this.zza = context;
        this.zzb = zzdjh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzejq zzejq = new zzejq(zzfgt, (zzbte) zzeho.zzb, AdFormat.INTERSTITIAL);
        zzdih zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdik(zzejq, (zzchd) null));
        zzejq.zzb(zze.zzc());
        ((zzejh) zzeho.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            ((zzbte) zzeho.zzb).zzq(zzfgt.zzaa);
            ((zzbte) zzeho.zzb).zzl(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejv(this, zzeho, (zzeju) null), (zzbrl) zzeho.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfhv(e);
        }
    }
}
