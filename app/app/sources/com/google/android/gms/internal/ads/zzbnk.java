package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbnk implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzccn zza;
    final /* synthetic */ zzbnm zzb;

    zzbnk(zzbnm zzbnm, zzccn zzccn) {
        this.zza = zzccn;
        this.zzb = zzbnm;
    }

    public final void onConnected(Bundle bundle) {
        try {
            this.zza.zzc(this.zzb.zza.zzp());
        } catch (DeadObjectException e) {
            this.zza.zzd(e);
        }
    }

    public final void onConnectionSuspended(int i) {
        this.zza.zzd(new RuntimeException("onConnectionSuspended: " + i));
    }
}
