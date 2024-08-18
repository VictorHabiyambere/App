package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeis implements zzcun {
    public final /* synthetic */ zzeho zza;

    public /* synthetic */ zzeis(zzeho zzeho) {
        this.zza = zzeho;
    }

    public final zzdq zza() {
        try {
            return ((zzbte) this.zza.zzb).zze();
        } catch (RemoteException e) {
            throw new zzfhv(e);
        }
    }
}
