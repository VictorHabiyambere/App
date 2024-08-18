package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbzh;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzfb implements Runnable {
    public final /* synthetic */ zzbzh zza;

    public /* synthetic */ zzfb(zzbzh zzbzh) {
        this.zza = zzbzh;
    }

    public final void run() {
        zzbzh zzbzh = this.zza;
        if (zzbzh != null) {
            try {
                zzbzh.zze(1);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
