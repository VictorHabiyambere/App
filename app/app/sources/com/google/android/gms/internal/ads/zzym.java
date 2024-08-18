package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzym extends zzza implements Comparable {
    private final int zze;
    private final int zzf = this.zzd.zza();

    public zzym(int i, zzde zzde, int i2, zzys zzys, int i3) {
        super(i, zzde, i2);
        this.zze = zzze.zzo(i3, zzys.zzT) ? 1 : 0;
    }

    /* renamed from: zza */
    public final int compareTo(zzym zzym) {
        return Integer.compare(this.zzf, zzym.zzf);
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzza zzza) {
        zzym zzym = (zzym) zzza;
        return false;
    }
}
