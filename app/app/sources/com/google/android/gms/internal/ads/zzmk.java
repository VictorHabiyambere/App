package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzmk extends zzvc {
    private final zzdb zzd = new zzdb();

    zzmk(zzml zzml, zzdc zzdc) {
        super(zzdc);
    }

    public final zzcz zzd(int i, zzcz zzcz, boolean z) {
        zzcz zzd2 = this.zzc.zzd(i, zzcz, z);
        if (this.zzc.zze(zzd2.zzd, this.zzd, 0).zzb()) {
            Object obj = zzcz.zzb;
            Object obj2 = zzcz.zzc;
            int i2 = zzcz.zzd;
            long j = zzcz.zze;
            long j2 = zzcz.zzf;
            zzd2.zzl(obj, obj2, i2, j, 0, zzd.zza, true);
        } else {
            zzd2.zzg = true;
        }
        return zzd2;
    }
}
