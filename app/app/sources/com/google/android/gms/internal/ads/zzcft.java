package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcft extends zzcfp {
    public zzcft(zzcee zzcee) {
        super(zzcee);
    }

    public final void zzf() {
    }

    public final boolean zzt(String str) {
        String zzf = zzf.zzf(str);
        zzcee zzcee = (zzcee) this.zzc.get();
        if (!(zzcee == null || zzf == null)) {
            zzcee.zzt(zzf, this);
        }
        zzm.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zzf, "noop", "Noop cache is a noop.");
        return false;
    }
}
