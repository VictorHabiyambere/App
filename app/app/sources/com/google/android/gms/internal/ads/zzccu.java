package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzccu {
    private final zzccn zza = new zzccn();
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzccu() {
        zzgft.zzr(this.zza, new zzccs(this), zzcci.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) zzba.zzc().zza(zzbep.zzhO)).booleanValue()) {
            zzu.zzo().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzccr zzccr, zzccp zzccp) {
        zzgft.zzr(this.zza, new zzcct(this, zzccr, zzccp), zzcci.zzf);
    }
}
