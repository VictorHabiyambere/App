package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdbu extends zzdez implements zzdaf, zzdbk {
    private final zzfgt zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzdbu(Set set, zzfgt zzfgt) {
        super(set);
        this.zzb = zzfgt;
    }

    private final void zzb() {
        zzs zzs;
        if (((Boolean) zzba.zzc().zza(zzbep.zzhT)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzs = this.zzb.zzaf) != null && zzs.zza == 3) {
            zzq(new zzdbt(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdbw zzdbw) throws Exception {
        zzdbw.zzh(this.zzb.zzaf);
    }

    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzr() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
