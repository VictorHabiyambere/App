package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdwz implements Runnable {
    public final /* synthetic */ zzdxf zza;
    public final /* synthetic */ zzbnu zzb;

    public /* synthetic */ zzdwz(zzdxf zzdxf, zzbnu zzbnu) {
        this.zza = zzdxf;
        this.zzb = zzbnu;
    }

    public final void run() {
        zzdxf zzdxf = this.zza;
        try {
            this.zzb.zzb(zzdxf.zzg());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
