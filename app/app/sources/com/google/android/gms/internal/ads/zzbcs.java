package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbcs implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbcu zza;

    zzbcs(zzbcu zzbcu) {
        this.zza = zzbcu;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbcu zzbcu = this.zza;
                if (zzbcu.zzd != null) {
                    zzbcu.zzf = zzbcu.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzm.zzh("Unable to obtain a cache service instance.", e);
                zzbcu.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
