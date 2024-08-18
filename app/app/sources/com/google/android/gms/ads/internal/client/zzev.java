package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    zzev(zzew zzew) {
        this.zza = zzew;
    }

    public final void run() {
        zzew zzew = this.zza;
        if (zzew.zza != null) {
            try {
                zzew.zza.zze(1);
            } catch (RemoteException e) {
                zzm.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
