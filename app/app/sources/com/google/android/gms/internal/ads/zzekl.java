package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzekl implements zzehr {
    private final Context zza;
    private final zzdkd zzb;
    /* access modifiers changed from: private */
    public zzbru zzc;
    private final VersionInfoParcel zzd;

    public zzekl(Context context, zzdkd zzdkd, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdkd;
        this.zzd = versionInfoParcel;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        if (zzfhf.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdlt zzt = zzdlt.zzt(this.zzc);
            zzfho zzfho = zzfhf.zza.zza;
            if (zzfho.zzg.contains(Integer.toString(zzt.zzc()))) {
                zzdlv zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzdmf(zzt), new zzdnw((zzbrr) null, (zzbrq) null, this.zzc));
                ((zzejh) zzeho.zzc).zzc(zze.zzj());
                return zze.zza();
            }
            throw new zzelj(1, "No corresponding native ad listener");
        }
        throw new zzelj(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            ((zzbte) zzeho.zzb).zzq(zzfgt.zzaa);
            if (this.zzd.clientJarVersion < ((Integer) zzba.zzc().zza(zzbep.zzbI)).intValue()) {
                ((zzbte) zzeho.zzb).zzm(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekk(this, zzeho, (zzekj) null), (zzbrl) zzeho.zzc);
            } else {
                ((zzbte) zzeho.zzb).zzn(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekk(this, zzeho, (zzekj) null), (zzbrl) zzeho.zzc, zzfhf.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfhv(e);
        }
    }
}
