package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaoh implements zzaoc {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzapr zzb;
    private final zzfu zzc;
    private final boolean[] zzd;
    private final zzaof zze;
    private final zzaor zzf;
    private zzaog zzg;
    private long zzh;
    private String zzi;
    private zzafa zzj;
    private boolean zzk;
    private long zzl;

    public zzaoh() {
        this((zzapr) null);
    }

    public final void zza(zzfu zzfu) {
        int i;
        float f;
        zzeq.zzb(this.zzg);
        zzeq.zzb(this.zzj);
        int zzd2 = zzfu.zzd();
        int zze2 = zzfu.zze();
        byte[] zzM = zzfu.zzM();
        this.zzh += (long) zzfu.zzb();
        this.zzj.zzq(zzfu, zzfu.zzb());
        while (true) {
            int zza2 = zzgr.zza(zzM, zzd2, zze2, this.zzd);
            if (zza2 == zze2) {
                if (!this.zzk) {
                    this.zze.zza(zzM, zzd2, zze2);
                }
                this.zzg.zza(zzM, zzd2, zze2);
                zzaor zzaor = this.zzf;
                if (zzaor != null) {
                    zzaor.zza(zzM, zzd2, zze2);
                    return;
                }
                return;
            }
            int i2 = zza2 + 3;
            byte b = zzfu.zzM()[i2] & 255;
            int i3 = zza2 - zzd2;
            if (!this.zzk) {
                if (i3 > 0) {
                    this.zze.zza(zzM, zzd2, zza2);
                }
                if (this.zze.zzc(b, i3 < 0 ? -i3 : 0)) {
                    zzafa zzafa = this.zzj;
                    zzaof zzaof = this.zze;
                    int i4 = zzaof.zzb;
                    String str = this.zzi;
                    if (str != null) {
                        byte[] copyOf = Arrays.copyOf(zzaof.zzc, zzaof.zza);
                        zzft zzft = new zzft(copyOf, copyOf.length);
                        zzft.zzn(i4);
                        zzft.zzn(4);
                        zzft.zzl();
                        zzft.zzm(8);
                        if (zzft.zzo()) {
                            zzft.zzm(4);
                            zzft.zzm(3);
                        }
                        int zzd3 = zzft.zzd(4);
                        if (zzd3 == 15) {
                            int zzd4 = zzft.zzd(8);
                            int zzd5 = zzft.zzd(8);
                            if (zzd5 == 0) {
                                zzfk.zzf("H263Reader", "Invalid aspect ratio");
                                f = 1.0f;
                            } else {
                                f = ((float) zzd4) / ((float) zzd5);
                            }
                        } else if (zzd3 < 7) {
                            f = zza[zzd3];
                        } else {
                            zzfk.zzf("H263Reader", "Invalid aspect ratio");
                            f = 1.0f;
                        }
                        if (zzft.zzo()) {
                            zzft.zzm(2);
                            zzft.zzm(1);
                            if (zzft.zzo()) {
                                zzft.zzm(15);
                                zzft.zzl();
                                zzft.zzm(15);
                                zzft.zzl();
                                zzft.zzm(15);
                                zzft.zzl();
                                zzft.zzm(3);
                                zzft.zzm(11);
                                zzft.zzl();
                                zzft.zzm(15);
                                zzft.zzl();
                            }
                        }
                        if (zzft.zzd(2) != 0) {
                            zzfk.zzf("H263Reader", "Unhandled video object layer shape");
                        }
                        zzft.zzl();
                        int zzd6 = zzft.zzd(16);
                        zzft.zzl();
                        if (zzft.zzo()) {
                            if (zzd6 == 0) {
                                zzfk.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                            } else {
                                int i5 = zzd6 - 1;
                                int i6 = 0;
                                while (i5 > 0) {
                                    i5 >>= 1;
                                    i6++;
                                }
                                zzft.zzm(i6);
                            }
                        }
                        zzft.zzl();
                        int zzd7 = zzft.zzd(13);
                        zzft.zzl();
                        int zzd8 = zzft.zzd(13);
                        zzft.zzl();
                        zzft.zzl();
                        zzal zzal = new zzal();
                        zzal.zzK(str);
                        zzal.zzX("video/mp4v-es");
                        zzal.zzac(zzd7);
                        zzal.zzI(zzd8);
                        zzal.zzT(f);
                        zzal.zzL(Collections.singletonList(copyOf));
                        zzafa.zzl(zzal.zzad());
                        this.zzk = true;
                    } else {
                        throw null;
                    }
                }
            }
            this.zzg.zza(zzM, zzd2, zza2);
            zzaor zzaor2 = this.zzf;
            if (zzaor2 != null) {
                if (i3 > 0) {
                    zzaor2.zza(zzM, zzd2, zza2);
                    i = 0;
                } else {
                    i = -i3;
                }
                if (this.zzf.zzd(i)) {
                    zzaor zzaor3 = this.zzf;
                    int zzb2 = zzgr.zzb(zzaor3.zza, zzaor3.zzb);
                    zzfu zzfu2 = this.zzc;
                    int i7 = zzgd.zza;
                    zzfu2.zzI(this.zzf.zza, zzb2);
                    this.zzb.zza(this.zzl, this.zzc);
                }
                if (b == 178) {
                    if (zzfu.zzM()[zza2 + 2] == 1) {
                        this.zzf.zzc(178);
                        b = 178;
                    } else {
                        b = 178;
                    }
                }
            }
            int i8 = zze2 - zza2;
            this.zzg.zzb(this.zzh - ((long) i8), i8, this.zzk);
            this.zzg.zzc(b, this.zzl);
            zzfu zzfu3 = zzfu;
            zzd2 = i2;
        }
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzi = zzapo.zzb();
        this.zzj = zzadx.zzw(zzapo.zza(), 2);
        this.zzg = new zzaog(this.zzj);
        zzapr zzapr = this.zzb;
        if (zzapr != null) {
            zzapr.zzb(zzadx, zzapo);
        }
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    public final void zze() {
        zzgr.zzf(this.zzd);
        this.zze.zzb();
        zzaog zzaog = this.zzg;
        if (zzaog != null) {
            zzaog.zzd();
        }
        zzaor zzaor = this.zzf;
        if (zzaor != null) {
            zzaor.zzb();
        }
        this.zzh = 0;
        this.zzl = -9223372036854775807L;
    }

    zzaoh(zzapr zzapr) {
        zzfu zzfu;
        this.zzb = zzapr;
        this.zzd = new boolean[4];
        this.zze = new zzaof(128);
        this.zzl = -9223372036854775807L;
        if (zzapr != null) {
            this.zzf = new zzaor(178, 128);
            zzfu = new zzfu();
        } else {
            zzfu = null;
            this.zzf = null;
        }
        this.zzc = zzfu;
    }
}
