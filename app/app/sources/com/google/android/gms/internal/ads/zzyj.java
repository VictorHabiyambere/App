package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzyj implements zzyz {
    public final /* synthetic */ zzys zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzyj(zzys zzys, String str) {
        this.zza = zzys;
        this.zzb = str;
    }

    public final List zza(int i, zzde zzde, int[] iArr) {
        zzgaz zzgaz = new zzgaz();
        for (int i2 = 0; i2 < zzde.zzb; i2++) {
            int i3 = i;
            zzde zzde2 = zzde;
            int i4 = i2;
            zzgaz.zzf(new zzyy(i3, zzde2, i4, this.zza, iArr[i2], this.zzb));
        }
        return zzgaz.zzi();
    }
}
