package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcbv extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzcby zza;

    zzcbv(zzcby zzcby) {
        this.zza = zzcby;
    }

    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
