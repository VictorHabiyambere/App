package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdzu implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;

    public zzdzu(zzhlg zzhlg, zzhlg zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return Wrappers.packageManager((Context) this.zza.zzb()).getPackageInfo(((zzdzq) this.zzb).zzb().packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }
}
