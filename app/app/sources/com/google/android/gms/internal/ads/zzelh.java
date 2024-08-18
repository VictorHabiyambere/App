package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzelh {
    private final zzfig zza;
    private final zzdsq zzb;
    private final zzdvc zzc;

    public zzelh(zzfig zzfig, zzdsq zzdsq, zzdvc zzdvc) {
        this.zza = zzfig;
        this.zzb = zzdsq;
        this.zzc = zzdvc;
    }

    public final void zza(zzfgw zzfgw, zzfgt zzfgt, int i, @Nullable zzehp zzehp, long j) {
        zzdsp zzdsp;
        zzdvb zza2 = this.zzc.zza();
        zza2.zzd(zzfgw);
        zza2.zzc(zzfgt);
        zza2.zzb("action", "adapter_status");
        zza2.zzb("adapter_l", String.valueOf(j));
        zza2.zzb("sc", Integer.toString(i));
        if (zzehp != null) {
            zza2.zzb("arec", Integer.toString(zzehp.zzb().zza));
            String zza3 = this.zza.zza(zzehp.getMessage());
            if (zza3 != null) {
                zza2.zzb("areec", zza3);
            }
        }
        zzdsq zzdsq = this.zzb;
        Iterator it = zzfgt.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdsp = null;
                break;
            }
            zzdsp = zzdsq.zza((String) it.next());
            if (zzdsp != null) {
                break;
            }
        }
        if (zzdsp != null) {
            zza2.zzb("ancn", zzdsp.zza);
            zzbtt zzbtt = zzdsp.zzb;
            if (zzbtt != null) {
                zza2.zzb("adapter_v", zzbtt.toString());
            }
            zzbtt zzbtt2 = zzdsp.zzc;
            if (zzbtt2 != null) {
                zza2.zzb("adapter_sv", zzbtt2.toString());
            }
        }
        zza2.zzf();
    }
}
