package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcsi extends zzcsf {
    private final Context zzc;
    private final View zzd;
    private final zzchd zze;
    private final zzfgu zzf;
    private final zzcun zzg;
    private final zzdme zzh;
    private final zzdhk zzi;
    private final zzhkj zzj;
    private final Executor zzk;
    private zzq zzl;

    zzcsi(zzcuo zzcuo, Context context, zzfgu zzfgu, View view, zzchd zzchd, zzcun zzcun, zzdme zzdme, zzdhk zzdhk, zzhkj zzhkj, Executor executor) {
        super(zzcuo);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzchd;
        this.zzf = zzfgu;
        this.zzg = zzcun;
        this.zzh = zzdme;
        this.zzi = zzdhk;
        this.zzj = zzhkj;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcsi zzcsi) {
        zzdme zzdme = zzcsi.zzh;
        if (zzdme.zze() != null) {
            try {
                zzdme.zze().zze((zzbu) zzcsi.zzj.zzb(), ObjectWrapper.wrap(zzcsi.zzc));
            } catch (RemoteException e) {
                zzm.zzh("RemoteException when notifyAdLoad is called", e);
            }
        }
    }

    public final int zza() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() && this.zzb.zzah) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzhV)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzc() {
        return this.zzd;
    }

    public final zzdq zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfhv e) {
            return null;
        }
    }

    public final zzfgu zze() {
        zzq zzq = this.zzl;
        if (zzq != null) {
            return zzfhu.zzb(zzq);
        }
        zzfgt zzfgt = this.zzb;
        if (zzfgt.zzad) {
            for (String str : zzfgt.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfgu(view.getWidth(), view.getHeight(), false);
        }
        return (zzfgu) this.zzb.zzs.get(0);
    }

    public final zzfgu zzf() {
        return this.zzf;
    }

    public final void zzg() {
        this.zzi.zza();
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
        zzchd zzchd;
        if (viewGroup != null && (zzchd = this.zze) != null) {
            zzchd.zzaj(zzcix.zzc(zzq));
            viewGroup.setMinimumHeight(zzq.zzc);
            viewGroup.setMinimumWidth(zzq.zzf);
            this.zzl = zzq;
        }
    }

    public final void zzj() {
        this.zzk.execute(new zzcsh(this));
        super.zzj();
    }
}
