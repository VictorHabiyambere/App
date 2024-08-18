package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzyf implements zzyz {
    public final /* synthetic */ zzze zza;
    public final /* synthetic */ zzys zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int[] zzd;

    public /* synthetic */ zzyf(zzze zzze, zzys zzys, boolean z, int[] iArr) {
        this.zza = zzze;
        this.zzb = zzys;
        this.zzc = z;
        this.zzd = iArr;
    }

    public final List zza(int i, zzde zzde, int[] iArr) {
        zzyc zzyc = new zzyc(this.zza);
        int i2 = this.zzd[i];
        zzgaz zzgaz = new zzgaz();
        for (int i3 = 0; i3 < zzde.zzb; i3++) {
            zzgaz.zzf(new zzyl(i, zzde, i3, this.zzb, iArr[i3], this.zzc, zzyc, i2));
        }
        return zzgaz.zzi();
    }
}
