package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzago extends zzaei {
    final /* synthetic */ zzaet zza;
    final /* synthetic */ zzagp zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzago(zzagp zzagp, zzaet zzaet, zzaet zzaet2) {
        super(zzaet);
        this.zza = zzaet2;
        this.zzb = zzagp;
    }

    public final zzaer zzg(long j) {
        zzaer zzg = this.zza.zzg(j);
        zzaeu zzaeu = zzg.zza;
        zzaeu zzaeu2 = new zzaeu(zzaeu.zzb, zzaeu.zzc + this.zzb.zzb);
        zzaeu zzaeu3 = zzg.zzb;
        return new zzaer(zzaeu2, new zzaeu(zzaeu3.zzb, zzaeu3.zzc + this.zzb.zzb));
    }
}
