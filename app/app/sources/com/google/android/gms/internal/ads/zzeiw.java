package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeiw implements zzehr {
    private final Context zza;
    private final zzctg zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbro zzd;

    public zzeiw(Context context, zzctg zzctg) {
        this.zza = context;
        this.zzb = zzctg;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv, zzelj {
        View view;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() || !zzfgt.zzah) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfhv(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzgft.zzn(zzgft.zzh((Object) null), new zzeit(this, view, zzfgt), zzcci.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfhv(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfhv(e2);
            }
        }
        zzcsg zza2 = this.zzb.zza(new zzcvf(zzfhf, zzfgt, zzeho.zza), new zzcsm(view, (zzchd) null, new zzeis(zzeho), (zzfgu) zzfgt.zzv.get(0)));
        zza2.zzg().zza(view);
        ((zzejh) zzeho.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        try {
            ((zzbte) zzeho.zzb).zzq(zzfgt.zzaa);
            if (!((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() || !zzfgt.zzah) {
                ((zzbte) zzeho.zzb).zzj(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeiv(this, zzeho, (zzeiu) null), (zzbrl) zzeho.zzc, zzfhf.zza.zza.zze);
            } else {
                ((zzbte) zzeho.zzb).zzk(zzfgt.zzV, zzfgt.zzw.toString(), zzfhf.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeiv(this, zzeho, (zzeiu) null), (zzbrl) zzeho.zzc, zzfhf.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzfhv(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzfgt zzfgt, Object obj) throws Exception {
        return zzgft.zzh(zzcub.zza(this.zza, view, zzfgt));
    }
}
