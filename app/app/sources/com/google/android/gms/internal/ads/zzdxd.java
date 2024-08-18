package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdxd implements zzgfp {
    final /* synthetic */ zzdxf zza;

    zzdxd(zzdxf zzdxf) {
        this.zza = zzdxf;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzu.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zzd(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (zzu.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzdxc(this, str));
        }
    }
}
