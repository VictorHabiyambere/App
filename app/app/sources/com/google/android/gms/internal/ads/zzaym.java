package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaym implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzayn zza;

    zzaym(zzayn zzayn) {
        this.zza = zzayn;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzayn zzayn = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        if (zzayn.zzc > 0) {
            zzayn zzayn2 = this.zza;
            if (currentTimeMillis >= zzayn2.zzc) {
                zzayn2.zzd = currentTimeMillis - zzayn2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
