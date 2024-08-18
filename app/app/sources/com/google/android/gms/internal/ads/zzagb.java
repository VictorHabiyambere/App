package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzagb extends zzagg {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzagb(zzafa zzafa) {
        super(zzafa);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzfu zzfu) throws zzagf {
        String str;
        if (!this.zzc) {
            int zzm = zzfu.zzm();
            int i = zzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(zzm >> 2) & 3];
                zzal zzal = new zzal();
                zzal.zzX("audio/mpeg");
                zzal.zzy(1);
                zzal.zzY(i2);
                this.zza.zzl(zzal.zzad());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzal zzal2 = new zzal();
                if (i == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zzal2.zzX(str);
                zzal2.zzy(1);
                zzal2.zzY(8000);
                this.zza.zzl(zzal2.zzad());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzagf("Audio format not supported: " + i);
            }
            this.zzc = true;
        } else {
            zzfu.zzL(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(zzfu zzfu, long j) throws zzch {
        if (this.zze == 2) {
            int zzb2 = zzfu.zzb();
            this.zza.zzq(zzfu, zzb2);
            this.zza.zzs(j, 1, zzb2, 0, (zzaez) null);
            return true;
        }
        int zzm = zzfu.zzm();
        if (zzm == 0 && !this.zzd) {
            int zzb3 = zzfu.zzb();
            byte[] bArr = new byte[zzb3];
            zzfu.zzG(bArr, 0, zzb3);
            zzacp zza = zzacq.zza(bArr);
            zzal zzal = new zzal();
            zzal.zzX("audio/mp4a-latm");
            zzal.zzz(zza.zzc);
            zzal.zzy(zza.zzb);
            zzal.zzY(zza.zza);
            zzal.zzL(Collections.singletonList(bArr));
            this.zza.zzl(zzal.zzad());
            this.zzd = true;
            return false;
        } else if (this.zze == 10 && zzm != 1) {
            return false;
        } else {
            int zzb4 = zzfu.zzb();
            this.zza.zzq(zzfu, zzb4);
            this.zza.zzs(j, 1, zzb4, 0, (zzaez) null);
            return true;
        }
    }
}
