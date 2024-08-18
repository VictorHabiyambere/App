package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbnl implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzccn zza;

    zzbnl(zzbnm zzbnm, zzccn zzccn) {
        this.zza = zzccn;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zzd(new RuntimeException("Connection failed."));
    }
}
