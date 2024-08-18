package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapi implements zzapb {
    final /* synthetic */ zzapk zza;
    private final zzft zzb = new zzft(new byte[4], 4);

    public zzapi(zzapk zzapk) {
        this.zza = zzapk;
    }

    public final void zza(zzfu zzfu) {
        if (zzfu.zzm() == 0 && (zzfu.zzm() & 128) != 0) {
            zzfu.zzL(6);
            int zzb2 = zzfu.zzb() / 4;
            for (int i = 0; i < zzb2; i++) {
                zzfu.zzF(this.zzb, 4);
                zzft zzft = this.zzb;
                zzft zzft2 = this.zzb;
                int zzd = zzft.zzd(16);
                zzft2.zzm(3);
                if (zzd == 0) {
                    this.zzb.zzm(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(zzd2) == null) {
                        zzapk zzapk = this.zza;
                        zzapk.zzg.put(zzd2, new zzapc(new zzapj(zzapk, zzd2)));
                        zzapk zzapk2 = this.zza;
                        zzapk2.zzm = zzapk2.zzm + 1;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    public final void zzb(zzgb zzgb, zzadx zzadx, zzapo zzapo) {
    }
}
