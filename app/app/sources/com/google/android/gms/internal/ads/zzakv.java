package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakv implements zzaet {
    final /* synthetic */ zzakw zza;

    /* synthetic */ zzakv(zzakw zzakw, zzaku zzaku) {
        this.zza = zzakw;
    }

    public final long zza() {
        zzakw zzakw = this.zza;
        return zzakw.zzd.zzf(zzakw.zzf);
    }

    public final zzaer zzg(long j) {
        zzakw zzakw = this.zza;
        long zzg = zzakw.zzd.zzg(j);
        long zzb = zzakw.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzakw zzakw2 = this.zza;
        long longValue = zzb + valueOf.multiply(BigInteger.valueOf(zzakw2.zzc - zzakw2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzakw zzakw3 = this.zza;
        zzaeu zzaeu = new zzaeu(j, Math.max(zzakw3.zzb, Math.min(longValue - 30000, zzakw3.zzc - 1)));
        return new zzaer(zzaeu, zzaeu);
    }

    public final boolean zzh() {
        return true;
    }
}
