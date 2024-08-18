package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbpn extends zzccu {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbps zzb;
    private boolean zzc;

    public zzbpn(zzbps zzbps) {
        this.zzb = zzbps;
    }

    public final void zzb() {
        zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("release: Lock acquired");
            if (this.zzc) {
                zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zzj(new zzbpk(this), new zzccq());
            zzj(new zzbpl(this), new zzbpm(this));
            zze.zza("release: Lock released");
        }
    }
}
