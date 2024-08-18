package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzafk implements zzaet {
    final /* synthetic */ zzafn zza;
    private final long zzb;

    public zzafk(zzafn zzafn, long j) {
        this.zza = zzafn;
        this.zzb = j;
    }

    public final long zza() {
        return this.zzb;
    }

    public final zzaer zzg(long j) {
        zzaer zza2 = this.zza.zzh[0].zza(j);
        int i = 1;
        while (true) {
            zzafn zzafn = this.zza;
            if (i >= zzafn.zzh.length) {
                return zza2;
            }
            zzaer zza3 = zzafn.zzh[i].zza(j);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
