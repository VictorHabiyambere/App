package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaoq implements zzaoc {
    private final zzfu zza;
    private final zzaen zzb;
    private final String zzc;
    private final int zzd;
    private zzafa zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;

    public zzaoq() {
        throw null;
    }

    public zzaoq(String str, int i) {
        this.zzg = 0;
        this.zza = new zzfu(4);
        this.zza.zzM()[0] = -1;
        this.zzb = new zzaen();
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zza(zzfu zzfu) {
        boolean z;
        boolean z2;
        zzeq.zzb(this.zze);
        while (zzfu.zzb() > 0) {
            boolean z3 = true;
            switch (this.zzg) {
                case 0:
                    byte[] zzM = zzfu.zzM();
                    int zzd2 = zzfu.zzd();
                    int zze2 = zzfu.zze();
                    while (true) {
                        if (zzd2 >= zze2) {
                            zzfu.zzK(zze2);
                            break;
                        } else {
                            int i = zzd2 + 1;
                            byte b = zzM[zzd2];
                            if ((b & 255) == 255) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!this.zzj || (b & 224) != 224) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            this.zzj = z;
                            if (z2) {
                                zzfu.zzK(i);
                                this.zzj = false;
                                this.zza.zzM()[1] = zzM[zzd2];
                                this.zzh = 2;
                                this.zzg = 1;
                                break;
                            } else {
                                zzd2 = i;
                            }
                        }
                    }
                    break;
                case 1:
                    int min = Math.min(zzfu.zzb(), 4 - this.zzh);
                    zzfu.zzG(this.zza.zzM(), this.zzh, min);
                    int i2 = this.zzh + min;
                    this.zzh = i2;
                    if (i2 < 4) {
                        break;
                    } else {
                        this.zza.zzK(0);
                        if (this.zzb.zza(this.zza.zzg())) {
                            zzaen zzaen = this.zzb;
                            this.zzl = zzaen.zzc;
                            if (!this.zzi) {
                                this.zzk = (((long) zzaen.zzg) * AnimationKt.MillisToNanos) / ((long) zzaen.zzd);
                                zzal zzal = new zzal();
                                zzal.zzK(this.zzf);
                                zzal.zzX(this.zzb.zzb);
                                zzal.zzP(4096);
                                zzal.zzy(this.zzb.zze);
                                zzal.zzY(this.zzb.zzd);
                                zzal.zzO(this.zzc);
                                zzal.zzV(this.zzd);
                                this.zze.zzl(zzal.zzad());
                                this.zzi = true;
                            }
                            this.zza.zzK(0);
                            this.zze.zzq(this.zza, 4);
                            this.zzg = 2;
                            break;
                        } else {
                            this.zzh = 0;
                            this.zzg = 1;
                            break;
                        }
                    }
                default:
                    int min2 = Math.min(zzfu.zzb(), this.zzl - this.zzh);
                    this.zze.zzq(zzfu, min2);
                    int i3 = this.zzh + min2;
                    this.zzh = i3;
                    if (i3 >= this.zzl) {
                        if (this.zzm == -9223372036854775807L) {
                            z3 = false;
                        }
                        zzeq.zzf(z3);
                        this.zze.zzs(this.zzm, 1, this.zzl, 0, (zzaez) null);
                        this.zzm += this.zzk;
                        this.zzh = 0;
                        this.zzg = 0;
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzf = zzapo.zzb();
        this.zze = zzadx.zzw(zzapo.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
    }
}
