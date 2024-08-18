package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzagk implements zzadu {
    private final zzfu zza = new zzfu(6);
    private zzadx zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf = -1;
    private zzaie zzg;
    private zzadv zzh;
    private zzagn zzi;
    private zzakj zzj;

    private final int zza(zzadv zzadv) throws IOException {
        this.zza.zzH(2);
        ((zzadi) zzadv).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        String zzx;
        zzagm zza2;
        long j;
        zzadv zzadv2 = zzadv;
        zzaeq zzaeq2 = zzaeq;
        zzaie zzaie = null;
        switch (this.zzc) {
            case 0:
                this.zza.zzH(2);
                ((zzadi) zzadv2).zzn(this.zza.zzM(), 0, 2, false);
                int zzq = this.zza.zzq();
                this.zzd = zzq;
                if (zzq == 65498) {
                    if (this.zzf != -1) {
                        this.zzc = 4;
                    } else {
                        zzg();
                    }
                } else if ((zzq < 65488 || zzq > 65497) && zzq != 65281) {
                    this.zzc = 1;
                }
                return 0;
            case 1:
                this.zza.zzH(2);
                ((zzadi) zzadv2).zzn(this.zza.zzM(), 0, 2, false);
                this.zze = this.zza.zzq() - 2;
                this.zzc = 2;
                return 0;
            case 2:
                if (this.zzd == 65505) {
                    zzfu zzfu = new zzfu(this.zze);
                    ((zzadi) zzadv2).zzn(zzfu.zzM(), 0, this.zze, false);
                    if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzfu.zzx(0)) && (zzx = zzfu.zzx(0)) != null) {
                        long zzd2 = zzadv.zzd();
                        if (!(zzd2 == -1 || (zza2 = zzagq.zza(zzx)) == null || zza2.zzb.size() < 2)) {
                            long j2 = -1;
                            long j3 = -1;
                            long j4 = -1;
                            long j5 = -1;
                            boolean z = false;
                            for (int size = zza2.zzb.size() - 1; size >= 0; size--) {
                                zzagl zzagl = (zzagl) zza2.zzb.get(size);
                                z |= "video/mp4".equals(zzagl.zza);
                                if (size == 0) {
                                    long j6 = zzd2 - zzagl.zzd;
                                    zzd2 = 0;
                                    j = j6;
                                } else {
                                    long j7 = zzd2;
                                    zzd2 -= zzagl.zzc;
                                    j = j7;
                                }
                                if (z && zzd2 != j) {
                                    j5 = j - zzd2;
                                    j4 = zzd2;
                                    z = false;
                                }
                                if (size == 0) {
                                    j3 = j;
                                }
                                if (size == 0) {
                                    j2 = zzd2;
                                }
                            }
                            if (!(j4 == -1 || j5 == -1 || j2 == -1 || j3 == -1)) {
                                zzaie = new zzaie(j2, j3, zza2.zza, j4, j5);
                            }
                        }
                        this.zzg = zzaie;
                        zzaie zzaie2 = this.zzg;
                        if (zzaie2 != null) {
                            this.zzf = zzaie2.zzd;
                        }
                    }
                } else {
                    ((zzadi) zzadv2).zzo(this.zze, false);
                }
                this.zzc = 0;
                return 0;
            case 4:
                long zzf2 = zzadv.zzf();
                long j8 = this.zzf;
                if (zzf2 == j8) {
                    if (!zzadv2.zzm(this.zza.zzM(), 0, 1, true)) {
                        zzg();
                    } else {
                        zzadv.zzj();
                        if (this.zzj == null) {
                            this.zzj = new zzakj(zzalt.zza, 8);
                        }
                        this.zzi = new zzagn(zzadv2, this.zzf);
                        if (this.zzj.zzf(this.zzi)) {
                            zzakj zzakj = this.zzj;
                            long j9 = this.zzf;
                            zzadx zzadx = this.zzb;
                            if (zzadx != null) {
                                zzakj.zzd(new zzagp(j9, zzadx));
                                zzaie zzaie3 = this.zzg;
                                if (zzaie3 != null) {
                                    zzadx zzadx2 = this.zzb;
                                    if (zzadx2 != null) {
                                        zzafa zzw = zzadx2.zzw(1024, 4);
                                        zzal zzal = new zzal();
                                        zzal.zzB("image/jpeg");
                                        zzal.zzQ(new zzcd(-9223372036854775807L, zzaie3));
                                        zzw.zzl(zzal.zzad());
                                        this.zzc = 5;
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            zzg();
                        }
                    }
                    return 0;
                }
                zzaeq2.zza = j8;
                return 1;
            case 5:
                if (this.zzi == null || zzadv2 != this.zzh) {
                    this.zzh = zzadv2;
                    this.zzi = new zzagn(zzadv2, this.zzf);
                }
                zzakj zzakj2 = this.zzj;
                if (zzakj2 != null) {
                    int zzb2 = zzakj2.zzb(this.zzi, zzaeq2);
                    if (zzb2 == 1) {
                        zzaeq2.zza += this.zzf;
                    }
                    return zzb2;
                }
                throw null;
            case 6:
                return -1;
            default:
                throw new IllegalStateException();
        }
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzb = zzadx;
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        if (zza(zzadv) != 65496) {
            return false;
        }
        int zza2 = zza(zzadv);
        this.zzd = zza2;
        if (zza2 == 65504) {
            this.zza.zzH(2);
            zzadi zzadi = (zzadi) zzadv;
            zzadi.zzm(this.zza.zzM(), 0, 2, false);
            zzadi.zzl(this.zza.zzq() - 2, false);
            zza2 = zza(zzadv);
            this.zzd = zza2;
        }
        if (zza2 == 65505) {
            zzadi zzadi2 = (zzadi) zzadv;
            zzadi2.zzl(2, false);
            this.zza.zzH(6);
            zzadi2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzakj zzakj = this.zzj;
            if (zzakj != null) {
                zzakj.zze(j, j2);
                return;
            }
            throw null;
        }
    }

    private final void zzg() {
        zzadx zzadx = this.zzb;
        if (zzadx != null) {
            zzadx.zzD();
            this.zzb.zzO(new zzaes(-9223372036854775807L, 0));
            this.zzc = 6;
            return;
        }
        throw null;
    }
}
