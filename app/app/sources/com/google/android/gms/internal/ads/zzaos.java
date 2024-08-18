package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaos implements zzapb {
    private zzan zza;
    private zzgb zzb;
    private zzafa zzc;

    public zzaos(String str) {
        zzal zzal = new zzal();
        zzal.zzX(str);
        this.zza = zzal.zzad();
    }

    public final void zza(zzfu zzfu) {
        zzeq.zzb(this.zzb);
        int i = zzgd.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze != -9223372036854775807L && zzf != -9223372036854775807L) {
            zzan zzan = this.zza;
            if (zzf != zzan.zzr) {
                zzal zzb2 = zzan.zzb();
                zzb2.zzab(zzf);
                this.zza = zzb2.zzad();
                this.zzc.zzl(this.zza);
            }
            int zzb3 = zzfu.zzb();
            this.zzc.zzq(zzfu, zzb3);
            this.zzc.zzs(zze, 1, zzb3, 0, (zzaez) null);
        }
    }

    public final void zzb(zzgb zzgb, zzadx zzadx, zzapo zzapo) {
        this.zzb = zzgb;
        zzapo.zzc();
        this.zzc = zzadx.zzw(zzapo.zza(), 5);
        this.zzc.zzl(this.zza);
    }
}
