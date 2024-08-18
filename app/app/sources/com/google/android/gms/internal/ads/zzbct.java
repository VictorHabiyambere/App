package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbct implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbcu zza;

    zzbct(zzbcu zzbcu) {
        this.zza = zzbcu;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbcu zzbcu = this.zza;
            if (zzbcu.zzd != null) {
                zzbcu.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
