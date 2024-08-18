package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeji extends zzbyr implements zzdav {
    private zzbys zza;
    private zzdau zzb;
    private zzdht zzc;

    public final synchronized void zza(zzdau zzdau) {
        this.zzb = zzdau;
    }

    public final synchronized void zzc(zzbys zzbys) {
        this.zza = zzbys;
    }

    public final synchronized void zzd(zzdht zzdht) {
        this.zzc = zzdht;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            zzbys.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdau zzdau = this.zzb;
        if (zzdau != null) {
            zzdau.zza(i);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdau zzdau = this.zzb;
        if (zzdau != null) {
            zzdau.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zza.zzdr();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdht zzdht = this.zzc;
        if (zzdht != null) {
            zzm.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzemm) zzdht).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdht zzdht = this.zzc;
        if (zzdht != null) {
            Executor zzc2 = ((zzemm) zzdht).zzd.zzb;
            zzeho zzeho = ((zzemm) zzdht).zzc;
            zzfgt zzfgt = ((zzemm) zzdht).zzb;
            zzc2.execute(new zzeml((zzemm) zzdht, ((zzemm) zzdht).zza, zzfgt, zzeho));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbyt zzbyt) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zzd.zza(zzbyt);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbys zzbys = this.zza;
        if (zzbys != null) {
            ((zzemn) zzbys).zzd.zzc();
        }
    }
}
