package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzagh extends zzagg {
    private final zzfu zzb = new zzfu(zzgr.zza);
    private final zzfu zzc = new zzfu(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzagh(zzafa zzafa) {
        super(zzafa);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfu zzfu) throws zzagf {
        int zzm = zzfu.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzagf("Video format not supported: " + i2);
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfu zzfu, long j) throws zzch {
        int i;
        zzfu zzfu2 = zzfu;
        int zzm = zzfu.zzm();
        long zzh = (long) zzfu.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzfu zzfu3 = new zzfu(new byte[zzfu.zzb()]);
                zzfu2.zzG(zzfu3.zzM(), 0, zzfu.zzb());
                zzacx zza = zzacx.zza(zzfu3);
                this.zzd = zza.zzb;
                zzal zzal = new zzal();
                zzal.zzX("video/avc");
                zzal.zzz(zza.zzk);
                zzal.zzac(zza.zzc);
                zzal.zzI(zza.zzd);
                zzal.zzT(zza.zzj);
                zzal.zzL(zza.zza);
                this.zza.zzl(zzal.zzad());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            byte[] zzM = this.zzc.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzfu.zzb() > 0) {
                zzfu2.zzG(this.zzc.zzM(), i3, this.zzd);
                this.zzc.zzK(0);
                zzfu zzfu4 = this.zzc;
                zzfu zzfu5 = this.zzb;
                int zzp = zzfu4.zzp();
                zzfu5.zzK(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzfu2, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzs(j + (zzh * 1000), i, i4, 0, (zzaez) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
