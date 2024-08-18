package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdln implements zzgfp {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdlo zzb;

    zzdln(zzdlo zzdlo, View view) {
        this.zza = view;
        this.zzb = zzdlo;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfj)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzehg) obj);
    }
}
