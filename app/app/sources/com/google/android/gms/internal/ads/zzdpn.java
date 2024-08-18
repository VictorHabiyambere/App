package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdpn {
    private final Executor zza;
    private final zzcrk zzb;
    private final zzdhc zzc;
    private final zzcqd zzd;

    zzdpn(Executor executor, zzcrk zzcrk, zzdhc zzdhc, zzcqd zzcqd) {
        this.zza = executor;
        this.zzc = zzdhc;
        this.zzb = zzcrk;
        this.zzd = zzcqd;
    }

    public final void zza(zzchd zzchd) {
        if (zzchd != null) {
            this.zzc.zza(zzchd.zzF());
            this.zzc.zzo(new zzdpj(zzchd), this.zza);
            this.zzc.zzo(new zzdpk(zzchd), this.zza);
            this.zzc.zzo(this.zzb, this.zza);
            this.zzb.zzf(zzchd);
            zzciv zzN = zzchd.zzN();
            if (((Boolean) zzba.zzc().zza(zzbep.zzkf)).booleanValue() && zzN != null) {
                zzN.zzJ(this.zzd);
                zzN.zzK(this.zzd, (zzefz) null, (zzdvc) null);
            }
            zzchd.zzag("/trackActiveViewUnit", new zzdpl(this));
            zzchd.zzag("/untrackActiveViewUnit", new zzdpm(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzchd zzchd, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzchd zzchd, Map map) {
        this.zzb.zza();
    }
}
