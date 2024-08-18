package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeaq implements zzgfp {
    final /* synthetic */ Context zza;

    zzeaq(Context context) {
        this.zza = context;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbgc.zzh.zze()).booleanValue() && (th instanceof zzba)) {
            zzbdz.zze(this.zza);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzebi zzebi = (zzebi) obj;
        if (((Boolean) zzbgc.zzj.zze()).booleanValue()) {
            zzbdz.zze(this.zza);
        }
    }
}
