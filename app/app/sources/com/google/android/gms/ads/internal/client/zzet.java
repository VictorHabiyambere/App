package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzet extends zzbm {
    final /* synthetic */ zzeu zza;

    /* synthetic */ zzet(zzeu zzeu, zzes zzes) {
        this.zza = zzeu;
    }

    public final String zze() throws RemoteException {
        return null;
    }

    public final String zzf() throws RemoteException {
        return null;
    }

    public final void zzg(zzl zzl) throws RemoteException {
        zzh(zzl, 1);
    }

    public final void zzh(zzl zzl, int i) throws RemoteException {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzer(this));
    }

    public final boolean zzi() throws RemoteException {
        return false;
    }
}
