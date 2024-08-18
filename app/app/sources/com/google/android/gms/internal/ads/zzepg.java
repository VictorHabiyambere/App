package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzepg implements zza, zzdhi {
    private zzbe zza;

    public final synchronized void onAdClicked() {
        zzbe zzbe = this.zza;
        if (zzbe != null) {
            try {
                zzbe.zzb();
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zza(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final synchronized void zzdG() {
        zzbe zzbe = this.zza;
        if (zzbe != null) {
            try {
                zzbe.zzb();
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception at onPhysicalClick.", e);
            }
        }
    }

    public final synchronized void zzdf() {
    }
}
