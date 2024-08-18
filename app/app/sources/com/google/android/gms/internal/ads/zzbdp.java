package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzbdp implements Runnable {
    public final /* synthetic */ zzbdu zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbdp(zzbdu zzbdu, Context context) {
        this.zza = zzbdu;
        this.zzb = context;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbep.zzeT)).booleanValue();
        zzbdu zzbdu = this.zza;
        Context context = this.zzb;
        if (booleanValue) {
            try {
                zzbdu.zza = (zzbai) zzq.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", new zzbdq());
                zzbdu.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                zzbdu.zzb = true;
            } catch (RemoteException | zzp | NullPointerException e) {
                zzm.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
