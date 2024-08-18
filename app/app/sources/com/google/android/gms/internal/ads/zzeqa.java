package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqa implements zzexw {
    private final Context zza;

    zzeqa(Context context) {
        this.zza = context;
    }

    public final int zza() {
        return 2;
    }

    public final ListenableFuture zzb() {
        boolean z;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzcR)).booleanValue()) {
            return zzgft.zzh((Object) null);
        }
        if (ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0) {
            z = true;
        } else {
            z = false;
        }
        return zzgft.zzh(new zzeqb(z));
    }
}
