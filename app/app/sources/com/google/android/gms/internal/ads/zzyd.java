package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzyd implements zzyz {
    public final /* synthetic */ zzys zza;

    public /* synthetic */ zzyd(zzys zzys) {
        this.zza = zzys;
    }

    public final List zza(int i, zzde zzde, int[] iArr) {
        zzgaz zzgaz = new zzgaz();
        for (int i2 = 0; i2 < zzde.zzb; i2++) {
            zzgaz.zzf(new zzym(i, zzde, i2, this.zza, iArr[i2]));
        }
        return zzgaz.zzi();
    }
}
