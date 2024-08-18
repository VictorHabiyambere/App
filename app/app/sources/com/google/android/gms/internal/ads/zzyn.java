package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzyn implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzyn(zzan zzan, int i) {
        this.zza = 1 != (zzan.zzf & 1) ? false : true;
        this.zzb = zzze.zzo(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzyn zzyn) {
        return zzgar.zzk().zze(this.zzb, zzyn.zzb).zze(this.zza, zzyn.zza).zza();
    }
}
