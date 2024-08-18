package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaon implements zzaoc {
    private final zzapd zza;
    private String zzb;
    private zzafa zzc;
    private zzaom zzd;
    private boolean zze;
    private final boolean[] zzf = new boolean[3];
    private final zzaor zzg = new zzaor(32, 128);
    private final zzaor zzh = new zzaor(33, 128);
    private final zzaor zzi = new zzaor(34, 128);
    private final zzaor zzj = new zzaor(39, 128);
    private final zzaor zzk = new zzaor(40, 128);
    private long zzl;
    private long zzm = -9223372036854775807L;
    private final zzfu zzn = new zzfu();

    public zzaon(zzapd zzapd) {
        this.zza = zzapd;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzb(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    public final void zza(zzfu zzfu) {
        long j;
        int i;
        byte[] bArr;
        int i2;
        int i3;
        zzeq.zzb(this.zzc);
        int i4 = zzgd.zza;
        while (zzfu.zzb() > 0) {
            int zzd2 = zzfu.zzd();
            int zze2 = zzfu.zze();
            byte[] zzM = zzfu.zzM();
            this.zzl += (long) zzfu.zzb();
            this.zzc.zzq(zzfu, zzfu.zzb());
            while (true) {
                if (zzd2 < zze2) {
                    int zza2 = zzgr.zza(zzM, zzd2, zze2, this.zzf);
                    if (zza2 != zze2) {
                        int i5 = zza2 + 3;
                        byte b = zzM[i5] & 126;
                        int i6 = zza2 - zzd2;
                        if (i6 > 0) {
                            zzf(zzM, zzd2, zza2);
                        }
                        int i7 = zze2 - zza2;
                        long j2 = this.zzl - ((long) i7);
                        int i8 = i6 < 0 ? -i6 : 0;
                        long j3 = this.zzm;
                        this.zzd.zza(j2, i7, this.zze);
                        if (!this.zze) {
                            this.zzg.zzd(i8);
                            this.zzh.zzd(i8);
                            this.zzi.zzd(i8);
                            zzaor zzaor = this.zzg;
                            if (zzaor.zze()) {
                                zzaor zzaor2 = this.zzh;
                                if (zzaor2.zze()) {
                                    zzaor zzaor3 = this.zzi;
                                    if (zzaor3.zze()) {
                                        zzafa zzafa = this.zzc;
                                        i3 = i5;
                                        String str = this.zzb;
                                        int i9 = zzaor.zzb;
                                        i2 = zze2;
                                        bArr = zzM;
                                        byte[] bArr2 = new byte[(zzaor2.zzb + i9 + zzaor3.zzb)];
                                        i = i7;
                                        System.arraycopy(zzaor.zza, 0, bArr2, 0, i9);
                                        j = j2;
                                        System.arraycopy(zzaor2.zza, 0, bArr2, zzaor.zzb, zzaor2.zzb);
                                        System.arraycopy(zzaor3.zza, 0, bArr2, zzaor.zzb + zzaor2.zzb, zzaor3.zzb);
                                        zzgo zzc2 = zzgr.zzc(zzaor2.zza, 5, zzaor2.zzb);
                                        String zzb2 = zzes.zzb(zzc2.zza, zzc2.zzb, zzc2.zzc, zzc2.zzd, zzc2.zzg, zzc2.zzh);
                                        zzal zzal = new zzal();
                                        zzal.zzK(str);
                                        zzal.zzX("video/hevc");
                                        zzal.zzz(zzb2);
                                        zzal.zzac(zzc2.zzi);
                                        zzal.zzI(zzc2.zzj);
                                        zzr zzr = new zzr();
                                        zzr.zzc(zzc2.zzl);
                                        zzr.zzb(zzc2.zzm);
                                        zzr.zzd(zzc2.zzn);
                                        zzr.zzf(zzc2.zze + 8);
                                        zzr.zza(zzc2.zzf + 8);
                                        zzal.zzA(zzr.zzg());
                                        zzal.zzT(zzc2.zzk);
                                        zzal.zzL(Collections.singletonList(bArr2));
                                        zzafa.zzl(zzal.zzad());
                                        this.zze = true;
                                    }
                                }
                            }
                            i2 = zze2;
                            bArr = zzM;
                            i3 = i5;
                            j = j2;
                            i = i7;
                        } else {
                            i2 = zze2;
                            bArr = zzM;
                            i3 = i5;
                            j = j2;
                            i = i7;
                        }
                        if (this.zzj.zzd(i8)) {
                            zzaor zzaor4 = this.zzj;
                            this.zzn.zzI(this.zzj.zza, zzgr.zzb(zzaor4.zza, zzaor4.zzb));
                            this.zzn.zzL(5);
                            this.zza.zza(j3, this.zzn);
                        }
                        if (this.zzk.zzd(i8)) {
                            zzaor zzaor5 = this.zzk;
                            this.zzn.zzI(this.zzk.zza, zzgr.zzb(zzaor5.zza, zzaor5.zzb));
                            this.zzn.zzL(5);
                            this.zza.zza(j3, this.zzn);
                        }
                        int i10 = b >> 1;
                        this.zzd.zzd(j, i, i10, this.zzm, this.zze);
                        if (!this.zze) {
                            this.zzg.zzc(i10);
                            this.zzh.zzc(i10);
                            this.zzi.zzc(i10);
                        }
                        this.zzj.zzc(i10);
                        this.zzk.zzc(i10);
                        zzfu zzfu2 = zzfu;
                        zzd2 = i3;
                        zze2 = i2;
                        zzM = bArr;
                    } else {
                        int i11 = zze2;
                        byte[] bArr3 = zzM;
                        zzf(zzM, zzd2, zze2);
                        return;
                    }
                }
            }
        }
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzb = zzapo.zzb();
        this.zzc = zzadx.zzw(zzapo.zza(), 2);
        this.zzd = new zzaom(this.zzc);
        this.zza.zzb(zzadx, zzapo);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzl = 0;
        this.zzm = -9223372036854775807L;
        zzgr.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzaom zzaom = this.zzd;
        if (zzaom != null) {
            zzaom.zzc();
        }
    }
}
