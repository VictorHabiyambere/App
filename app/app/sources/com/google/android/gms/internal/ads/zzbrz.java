package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzbrz implements InitializationCompleteCallback {
    final /* synthetic */ zzbnr zza;

    zzbrz(zzbsg zzbsg, zzbnr zzbnr) {
        this.zza = zzbnr;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
