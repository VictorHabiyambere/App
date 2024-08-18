package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzf {
    public final zzde zza;
    public final int[] zzb;

    public zzzf(zzde zzde, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzfk.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzde;
        this.zzb = iArr;
    }
}
