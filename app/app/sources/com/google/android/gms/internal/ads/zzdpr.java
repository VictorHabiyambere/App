package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdpr implements Runnable {
    public final /* synthetic */ zzdpt zza;

    public /* synthetic */ zzdpr(zzdpt zzdpt) {
        this.zza = zzdpt;
    }

    public final void run() {
        try {
            this.zza.zzd();
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
