package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzayc implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzaye zzb;

    zzayc(zzaye zzaye, int i, boolean z) {
        this.zza = i;
        this.zzb = zzaye;
    }

    public final void run() {
        zzaus zzaus;
        int i = this.zza;
        zzaye zzaye = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException e) {
            }
        }
        try {
            PackageInfo packageInfo = zzaye.zza.getPackageManager().getPackageInfo(zzaye.zza.getPackageName(), 0);
            Context context = zzaye.zza;
            zzaus = zzfrm.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable th) {
            zzaus = null;
        }
        this.zzb.zzm = zzaus;
        if (this.zza >= 4) {
            return;
        }
        if (zzaus == null || !zzaus.zzar() || zzaus.zzi().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaus.zzas() || !zzaus.zzg().zze() || zzaus.zzg().zza() == -2) {
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
