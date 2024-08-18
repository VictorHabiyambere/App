package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaxg extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzaxh zza;

    zzaxg(zzaxh zzaxh) {
        this.zza = zzaxh;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaxh.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzaxh.class) {
            this.zza.zza = null;
        }
    }
}
