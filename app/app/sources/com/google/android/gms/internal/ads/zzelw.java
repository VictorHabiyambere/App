package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzelw implements zzehr {
    private final Context zza;
    private final zzdrm zzb;

    public zzelw(Context context, zzdrm zzdrm) {
        this.zza = context;
        this.zzb = zzdrm;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        zzejq zzejq = new zzejq(zzfgt, (zzbte) zzeho.zzb, AdFormat.REWARDED);
        zzdri zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdrj(zzejq));
        zzejq.zzb(zze.zzc());
        ((zzejh) zzeho.zzc).zzc(zze.zzo());
        return zze.zzi();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            ((zzbte) zzeho.zzb).zzq(zzfgt.zzaa);
            if (zzfhf.zza.zza.zzo.zza == 3) {
                ((zzbte) zzeho.zzb).zzo(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelv(this, zzeho, (zzelu) null), (zzbrl) zzeho.zzc);
            } else {
                ((zzbte) zzeho.zzb).zzp(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelv(this, zzeho, (zzelu) null), (zzbrl) zzeho.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
