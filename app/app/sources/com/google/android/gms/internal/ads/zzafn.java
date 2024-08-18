package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzafn implements zzadu {
    private final zzfu zza;
    private final zzafm zzb;
    private final zzalt zzc;
    private int zzd;
    private zzadx zze;
    private zzafo zzf;
    private long zzg;
    /* access modifiers changed from: private */
    public zzafq[] zzh;
    private long zzi;
    private zzafq zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private boolean zzo;

    @Deprecated
    public zzafn() {
        this(1, zzalt.zza);
    }

    private final zzafq zzg(int i) {
        for (zzafq zzafq : this.zzh) {
            if (zzafq.zzg(i)) {
                return zzafq;
            }
        }
        return null;
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzd = 0;
        this.zze = zzadx;
        this.zzi = -1;
    }

    public final void zze(long j, long j2) {
        this.zzi = -1;
        this.zzj = null;
        int i = 0;
        for (zzafq zzf2 : this.zzh) {
            zzf2.zzf(j);
        }
        if (j == 0) {
            if (this.zzh.length != 0) {
                i = 3;
            }
            this.zzd = i;
            return;
        }
        this.zzd = 6;
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        ((zzadi) zzadv).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        if (this.zza.zzi() == 541677121) {
            return true;
        }
        return false;
    }

    public zzafn(int i, zzalt zzalt) {
        this.zzc = zzalt;
        this.zza = new zzfu(12);
        this.zzb = new zzafm((zzafl) null);
        this.zze = new zzads();
        this.zzh = new zzafq[0];
        this.zzl = -1;
        this.zzm = -1;
        this.zzk = -1;
        this.zzg = -9223372036854775807L;
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        boolean z;
        zzgbc zzgbc;
        zzafq zzafq;
        int i;
        long j;
        zzadv zzadv2 = zzadv;
        long j2 = this.zzi;
        if (j2 != -1) {
            long zzf2 = zzadv.zzf();
            if (j2 < zzf2 || j2 > 262144 + zzf2) {
                zzaeq.zza = j2;
                z = true;
            } else {
                ((zzadi) zzadv2).zzo((int) (j2 - zzf2), false);
                z = false;
            }
        } else {
            z = false;
        }
        this.zzi = -1;
        if (z) {
            return 1;
        }
        int i2 = 8;
        switch (this.zzd) {
            case 0:
                if (zzf(zzadv)) {
                    ((zzadi) zzadv2).zzo(12, false);
                    this.zzd = 1;
                    return 0;
                }
                throw zzch.zza("AVI Header List not found", (Throwable) null);
            case 1:
                ((zzadi) zzadv2).zzn(this.zza.zzM(), 0, 12, false);
                this.zza.zzK(0);
                zzafm zzafm = this.zzb;
                zzfu zzfu = this.zza;
                zzafm.zza(zzfu);
                int i3 = zzafm.zza;
                if (i3 == 1414744396) {
                    zzafm.zzc = zzfu.zzi();
                    zzafm zzafm2 = this.zzb;
                    int i4 = zzafm2.zzc;
                    if (i4 == 1819436136) {
                        this.zzk = zzafm2.zzb;
                        this.zzd = 2;
                        return 0;
                    }
                    throw zzch.zza("hdrl expected, found: " + i4, (Throwable) null);
                }
                throw zzch.zza("LIST expected, found: " + i3, (Throwable) null);
            case 2:
                int i5 = this.zzk - 4;
                zzfu zzfu2 = new zzfu(i5);
                ((zzadi) zzadv2).zzn(zzfu2.zzM(), 0, i5, false);
                zzafr zzc2 = zzafr.zzc(1819436136, zzfu2);
                if (zzc2.zza() == 1819436136) {
                    zzafo zzafo = (zzafo) zzc2.zzb(zzafo.class);
                    if (zzafo != null) {
                        this.zzf = zzafo;
                        this.zzg = ((long) zzafo.zzc) * ((long) zzafo.zza);
                        ArrayList arrayList = new ArrayList();
                        zzgbc zzgbc2 = zzc2.zza;
                        int size = zzgbc2.size();
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < size) {
                            zzafj zzafj = (zzafj) zzgbc2.get(i6);
                            if (zzafj.zza() == 1819440243) {
                                zzafr zzafr = (zzafr) zzafj;
                                int i8 = i7 + 1;
                                zzafp zzafp = (zzafp) zzafr.zzb(zzafp.class);
                                zzafs zzafs = (zzafs) zzafr.zzb(zzafs.class);
                                if (zzafp == null) {
                                    zzfk.zzf("AviExtractor", "Missing Stream Header");
                                    zzgbc = zzgbc2;
                                    zzafq = null;
                                } else if (zzafs == null) {
                                    zzfk.zzf("AviExtractor", "Missing Stream Format");
                                    zzgbc = zzgbc2;
                                    zzafq = null;
                                } else {
                                    zzgbc = zzgbc2;
                                    long zzt = zzgd.zzt((long) zzafp.zzd, ((long) zzafp.zzb) * AnimationKt.MillisToNanos, (long) zzafp.zzc, RoundingMode.FLOOR);
                                    zzan zzan = zzafs.zza;
                                    zzal zzb2 = zzan.zzb();
                                    zzb2.zzJ(i7);
                                    int i9 = zzafp.zze;
                                    if (i9 != 0) {
                                        zzb2.zzP(i9);
                                    }
                                    zzaft zzaft = (zzaft) zzafr.zzb(zzaft.class);
                                    if (zzaft != null) {
                                        zzb2.zzM(zzaft.zza);
                                    }
                                    int zzb3 = zzcg.zzb(zzan.zzn);
                                    if (zzb3 == 1) {
                                        i = zzb3;
                                    } else if (zzb3 == 2) {
                                        i = 2;
                                    } else {
                                        zzafq = null;
                                    }
                                    zzafa zzw = this.zze.zzw(i7, i);
                                    zzw.zzl(zzb2.zzad());
                                    zzafq zzafq2 = new zzafq(i7, i, zzt, zzafp.zzd, zzw);
                                    this.zzg = zzt;
                                    zzafq = zzafq2;
                                }
                                if (zzafq != null) {
                                    arrayList.add(zzafq);
                                }
                                i7 = i8;
                            } else {
                                zzgbc = zzgbc2;
                            }
                            i6++;
                            zzgbc2 = zzgbc;
                        }
                        this.zzh = (zzafq[]) arrayList.toArray(new zzafq[0]);
                        this.zze.zzD();
                        this.zzd = 3;
                        return 0;
                    }
                    throw zzch.zza("AviHeader not found", (Throwable) null);
                }
                throw zzch.zza("Unexpected header list type " + zzc2.zza(), (Throwable) null);
            case 3:
                long j3 = this.zzl;
                if (j3 == -1 || zzadv.zzf() == j3) {
                    zzadi zzadi = (zzadi) zzadv2;
                    zzadi.zzm(this.zza.zzM(), 0, 12, false);
                    zzadv.zzj();
                    this.zza.zzK(0);
                    this.zzb.zza(this.zza);
                    zzfu zzfu3 = this.zza;
                    zzafm zzafm3 = this.zzb;
                    int zzi2 = zzfu3.zzi();
                    int i10 = zzafm3.zza;
                    if (i10 == 1179011410) {
                        zzadi.zzo(12, false);
                        return 0;
                    } else if (i10 == 1414744396 && zzi2 == 1769369453) {
                        long zzf3 = zzadv.zzf();
                        this.zzl = zzf3;
                        long j4 = zzf3 + ((long) zzafm3.zzb) + 8;
                        this.zzm = j4;
                        if (!this.zzo) {
                            zzafo zzafo2 = this.zzf;
                            if (zzafo2 == null) {
                                throw null;
                            } else if ((zzafo2.zzb & 16) != 16) {
                                this.zze.zzO(new zzaes(this.zzg, 0));
                                this.zzo = true;
                            } else {
                                this.zzd = 4;
                                this.zzi = j4;
                                return 0;
                            }
                        }
                        this.zzi = zzadv.zzf() + 12;
                        this.zzd = 6;
                        return 0;
                    } else {
                        this.zzi = zzadv.zzf() + ((long) zzafm3.zzb) + 8;
                        return 0;
                    }
                } else {
                    this.zzi = j3;
                    return 0;
                }
            case 4:
                ((zzadi) zzadv2).zzn(this.zza.zzM(), 0, 8, false);
                this.zza.zzK(0);
                zzfu zzfu4 = this.zza;
                int zzi3 = zzfu4.zzi();
                int zzi4 = zzfu4.zzi();
                if (zzi3 == 829973609) {
                    this.zzd = 5;
                    this.zzn = zzi4;
                } else {
                    this.zzi = zzadv.zzf() + ((long) zzi4);
                }
                return 0;
            case 5:
                zzfu zzfu5 = new zzfu(this.zzn);
                ((zzadi) zzadv2).zzn(zzfu5.zzM(), 0, this.zzn, false);
                if (zzfu5.zzb() < 16) {
                    j = 0;
                } else {
                    int zzd2 = zzfu5.zzd();
                    zzfu5.zzL(8);
                    long j5 = this.zzl;
                    if (((long) zzfu5.zzi()) > j5) {
                        j = 0;
                    } else {
                        j = j5 + 8;
                    }
                    zzfu5.zzK(zzd2);
                }
                while (zzfu5.zzb() >= 16) {
                    int zzi5 = zzfu5.zzi();
                    int zzi6 = zzfu5.zzi();
                    long zzi7 = ((long) zzfu5.zzi()) + j;
                    zzfu5.zzi();
                    zzafq zzg2 = zzg(zzi5);
                    if (zzg2 != null) {
                        if ((zzi6 & 16) == 16) {
                            zzg2.zzb(zzi7);
                        }
                        zzg2.zzd();
                    }
                }
                for (zzafq zzc3 : this.zzh) {
                    zzc3.zzc();
                }
                this.zzo = true;
                this.zze.zzO(new zzafk(this, this.zzg));
                this.zzd = 6;
                this.zzi = this.zzl;
                return 0;
            default:
                if (zzadv.zzf() >= this.zzm) {
                    return -1;
                }
                zzafq zzafq3 = this.zzj;
                if (zzafq3 == null) {
                    if ((zzadv.zzf() & 1) == 1) {
                        ((zzadi) zzadv2).zzo(1, false);
                    }
                    zzadi zzadi2 = (zzadi) zzadv2;
                    zzadi2.zzm(this.zza.zzM(), 0, 12, false);
                    this.zza.zzK(0);
                    int zzi8 = this.zza.zzi();
                    if (zzi8 == 1414744396) {
                        this.zza.zzK(8);
                        if (this.zza.zzi() == 1769369453) {
                            i2 = 12;
                        }
                        zzadi2.zzo(i2, false);
                        zzadv.zzj();
                        return 0;
                    }
                    int zzi9 = this.zza.zzi();
                    if (zzi8 == 1263424842) {
                        this.zzi = zzadv.zzf() + ((long) zzi9) + 8;
                        return 0;
                    }
                    zzadi2.zzo(8, false);
                    zzadv.zzj();
                    zzafq zzg3 = zzg(zzi8);
                    if (zzg3 == null) {
                        this.zzi = zzadv.zzf() + ((long) zzi9);
                        return 0;
                    }
                    zzg3.zze(zzi9);
                    this.zzj = zzg3;
                    return 0;
                } else if (!zzafq3.zzh(zzadv2)) {
                    return 0;
                } else {
                    this.zzj = null;
                    return 0;
                }
        }
    }
}
