package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfsl;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzi implements zzfsl {
    final /* synthetic */ zzj zza;

    zzi(zzj zzj) {
        this.zza = zzj;
    }

    public final void zza(int i, long j) {
        this.zza.zzi.zzd(i, System.currentTimeMillis() - j);
    }

    public final void zzb(int i, long j, String str) {
        this.zza.zzi.zze(i, System.currentTimeMillis() - j, str);
    }
}
