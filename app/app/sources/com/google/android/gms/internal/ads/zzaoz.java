package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaoz {
    private final zzaoc zza;
    private final zzgb zzb;
    private final zzft zzc = new zzft(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzaoz(zzaoc zzaoc, zzgb zzgb) {
        this.zza = zzaoc;
        this.zzb = zzgb;
    }

    public final void zza(zzfu zzfu) throws zzch {
        long j;
        zzfu zzfu2 = zzfu;
        zzfu2.zzG(this.zzc.zza, 0, 3);
        this.zzc.zzk(0);
        this.zzc.zzm(8);
        this.zzd = this.zzc.zzo();
        this.zze = this.zzc.zzo();
        this.zzc.zzm(6);
        zzft zzft = this.zzc;
        zzfu2.zzG(zzft.zza, 0, zzft.zzd(8));
        this.zzc.zzk(0);
        if (this.zzd) {
            this.zzc.zzm(4);
            long zzd2 = (long) this.zzc.zzd(3);
            this.zzc.zzm(1);
            int zzd3 = this.zzc.zzd(15) << 15;
            this.zzc.zzm(1);
            long zzd4 = (long) this.zzc.zzd(15);
            this.zzc.zzm(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzm(4);
                this.zzc.zzm(1);
                this.zzc.zzm(1);
                long zzd5 = (long) this.zzc.zzd(15);
                this.zzc.zzm(1);
                this.zzb.zzb(((long) (this.zzc.zzd(15) << 15)) | (((long) this.zzc.zzd(3)) << 30) | zzd5);
                this.zzf = true;
            }
            j = this.zzb.zzb((zzd2 << 30) | ((long) zzd3) | zzd4);
        } else {
            j = 0;
        }
        this.zza.zzd(j, 4);
        this.zza.zza(zzfu2);
        this.zza.zzc();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
