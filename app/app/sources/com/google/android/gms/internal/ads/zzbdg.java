package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbdg implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbcy zza;
    final /* synthetic */ zzccn zzb;
    final /* synthetic */ zzbdi zzc;

    zzbdg(zzbdi zzbdi, zzbcy zzbcy, zzccn zzccn) {
        this.zza = zzbcy;
        this.zzb = zzccn;
        this.zzc = zzbdi;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbdi zzbdi = this.zzc;
            if (!zzbdi.zzb) {
                zzbdi.zzb = true;
                zzbcx zza2 = this.zzc.zza;
                if (zza2 != null) {
                    ListenableFuture zza3 = zzcci.zza.zza(new zzbdd(this, zza2, this.zza, this.zzb));
                    zzccn zzccn = this.zzb;
                    zzccn.addListener(new zzbde(zzccn, zza3), zzcci.zzf);
                }
            }
        }
    }
}
