package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeiv extends zzbsr {
    final /* synthetic */ zzeiw zza;
    private final zzeho zzb;

    /* synthetic */ zzeiv(zzeiw zzeiw, zzeho zzeho, zzeiu zzeiu) {
        this.zza = zzeiw;
        this.zzb = zzeho;
    }

    public final void zze(String str) throws RemoteException {
        ((zzejh) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzejh) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzejh) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbro zzbro) throws RemoteException {
        this.zza.zzd = zzbro;
        ((zzejh) this.zzb.zzc).zzo();
    }
}
