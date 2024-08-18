package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbwj;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzao extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbrf zzc;
    final /* synthetic */ zzaw zzd;

    zzao(zzaw zzaw, Context context, String str, zzbrf zzbrf) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbrf;
        this.zzd = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "native_ad");
        return new zzeu();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241806000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbep.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbep.zzkI)).booleanValue()) {
            try {
                IBinder zze = ((zzbr) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", new zzan())).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241806000);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return queryLocalInterface instanceof zzbq ? (zzbq) queryLocalInterface : new zzbo(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzd.zzh = zzbwj.zza(this.zza);
                this.zzd.zzh.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
                return null;
            }
        } else {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
    }
}
