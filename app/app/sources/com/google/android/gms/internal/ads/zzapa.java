package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapa implements zzadu {
    public static final zzaea zza = new zzaoy();
    private final zzgb zzb = new zzgb(0);
    private final SparseArray zzc = new SparseArray();
    private final zzfu zzd = new zzfu(4096);
    private final zzaox zze = new zzaox();
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private zzaow zzj;
    private zzadx zzk;
    private boolean zzl;

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        zzadv zzadv2 = zzadv;
        zzaeq zzaeq2 = zzaeq;
        zzeq.zzb(this.zzk);
        long zzd2 = zzadv.zzd();
        int i = (zzd2 > -1 ? 1 : (zzd2 == -1 ? 0 : -1));
        if (i != 0) {
            zzaox zzaox = this.zze;
            if (!zzaox.zze()) {
                return zzaox.zza(zzadv2, zzaeq2);
            }
        }
        if (!this.zzl) {
            this.zzl = true;
            zzaox zzaox2 = this.zze;
            if (zzaox2.zzb() != -9223372036854775807L) {
                this.zzj = new zzaow(zzaox2.zzd(), zzaox2.zzb(), zzd2);
                this.zzk.zzO(this.zzj.zzb());
            } else {
                this.zzk.zzO(new zzaes(zzaox2.zzb(), 0));
            }
        }
        zzaow zzaow = this.zzj;
        if (zzaow != null && zzaow.zze()) {
            return zzaow.zza(zzadv2, zzaeq2);
        }
        zzadv.zzj();
        long zze2 = i != 0 ? zzd2 - zzadv.zze() : -1;
        if ((zze2 != -1 && zze2 < 4) || !zzadv2.zzm(this.zzd.zzM(), 0, 4, true)) {
            return -1;
        }
        this.zzd.zzK(0);
        int zzg2 = this.zzd.zzg();
        if (zzg2 == 441) {
            return -1;
        }
        if (zzg2 == 442) {
            zzadi zzadi = (zzadi) zzadv2;
            zzadi.zzm(this.zzd.zzM(), 0, 10, false);
            this.zzd.zzK(9);
            zzadi.zzo((this.zzd.zzm() & 7) + 14, false);
            return 0;
        } else if (zzg2 == 443) {
            zzadi zzadi2 = (zzadi) zzadv2;
            zzadi2.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            zzadi2.zzo(this.zzd.zzq() + 6, false);
            return 0;
        } else if ((zzg2 >> 8) != 1) {
            ((zzadi) zzadv2).zzo(1, false);
            return 0;
        } else {
            int i2 = zzg2 & 255;
            zzaoz zzaoz = (zzaoz) this.zzc.get(i2);
            if (!this.zzf) {
                if (zzaoz == null) {
                    zzans zzans = null;
                    if (i2 == 189) {
                        zzans zzans2 = new zzans((String) null, 0);
                        this.zzg = true;
                        this.zzi = zzadv.zzf();
                        zzans = zzans2;
                    } else if ((i2 & 224) == 192) {
                        zzaoq zzaoq = new zzaoq((String) null, 0);
                        this.zzg = true;
                        this.zzi = zzadv.zzf();
                        zzans = zzaoq;
                    } else if ((i2 & 240) == 224) {
                        zzaoe zzaoe = new zzaoe((zzapr) null);
                        this.zzh = true;
                        this.zzi = zzadv.zzf();
                        zzans = zzaoe;
                    }
                    if (zzans != null) {
                        zzans.zzb(this.zzk, new zzapo(Integer.MIN_VALUE, i2, 256));
                        zzaoz zzaoz2 = new zzaoz(zzans, this.zzb);
                        this.zzc.put(i2, zzaoz2);
                        zzaoz = zzaoz2;
                    }
                }
                long j = 1048576;
                if (this.zzg && this.zzh) {
                    j = this.zzi + 8192;
                }
                if (zzadv.zzf() > j) {
                    this.zzf = true;
                    this.zzk.zzD();
                }
            }
            zzadi zzadi3 = (zzadi) zzadv2;
            zzadi3.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            int zzq = this.zzd.zzq() + 6;
            if (zzaoz == null) {
                zzadi3.zzo(zzq, false);
            } else {
                this.zzd.zzH(zzq);
                zzadi3.zzn(this.zzd.zzM(), 0, zzq, false);
                this.zzd.zzK(6);
                zzaoz.zza(this.zzd);
                zzfu zzfu = this.zzd;
                zzfu.zzJ(zzfu.zzc());
            }
            return 0;
        }
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzk = zzadx;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != r7) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036 A[LOOP:0: B:12:0x002e->B:14:0x0036, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzgb r5 = r4.zzb
            long r0 = r5.zzf()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0021
            long r0 = r5.zzd()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r5.zzi(r7)
        L_0x0024:
            com.google.android.gms.internal.ads.zzaow r5 = r4.zzj
            r6 = 0
            if (r5 == 0) goto L_0x002d
            r5.zzd(r7)
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            android.util.SparseArray r5 = r4.zzc
            int r5 = r5.size()
            if (r6 >= r5) goto L_0x0044
            android.util.SparseArray r5 = r4.zzc
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzaoz r5 = (com.google.android.gms.internal.ads.zzaoz) r5
            r5.zzb()
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapa.zze(long, long):void");
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        byte[] bArr = new byte[14];
        zzadi zzadi = (zzadi) zzadv;
        zzadi.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzadi.zzl(bArr[13] & 7, false);
        zzadi.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << Ascii.DLE) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
