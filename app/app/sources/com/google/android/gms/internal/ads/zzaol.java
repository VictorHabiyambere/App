package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaol implements zzaoc {
    private final zzapd zza;
    private final zzaor zzb = new zzaor(7, 128);
    private final zzaor zzc = new zzaor(8, 128);
    private final zzaor zzd = new zzaor(6, 128);
    private long zze;
    private final boolean[] zzf = new boolean[3];
    private String zzg;
    private zzafa zzh;
    private zzaok zzi;
    private boolean zzj;
    private long zzk = -9223372036854775807L;
    private boolean zzl;
    private final zzfu zzm = new zzfu();

    public zzaol(zzapd zzapd, boolean z, boolean z2) {
        this.zza = zzapd;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    public final void zza(zzfu zzfu) {
        int i;
        int i2;
        zzeq.zzb(this.zzh);
        int i3 = zzgd.zza;
        int zzd2 = zzfu.zzd();
        int zze2 = zzfu.zze();
        byte[] zzM = zzfu.zzM();
        this.zze += (long) zzfu.zzb();
        this.zzh.zzq(zzfu, zzfu.zzb());
        while (true) {
            int zza2 = zzgr.zza(zzM, zzd2, zze2, this.zzf);
            if (zza2 != zze2) {
                int i4 = zza2 + 3;
                byte b = zzM[i4] & Ascii.US;
                int i5 = zza2 - zzd2;
                if (i5 > 0) {
                    zzf(zzM, zzd2, zza2);
                }
                int i6 = zze2 - zza2;
                long j = this.zze - ((long) i6);
                int i7 = i5 < 0 ? -i5 : 0;
                long j2 = this.zzk;
                if (this.zzj) {
                    i = zze2;
                    i2 = i4;
                } else {
                    this.zzb.zzd(i7);
                    this.zzc.zzd(i7);
                    if (this.zzj) {
                        i = zze2;
                        i2 = i4;
                        zzaor zzaor = this.zzb;
                        if (zzaor.zze()) {
                            this.zzi.zzb(zzgr.zze(zzaor.zza, 4, zzaor.zzb));
                            this.zzb.zzb();
                        } else {
                            zzaor zzaor2 = this.zzc;
                            if (zzaor2.zze()) {
                                this.zzi.zza(zzgr.zzd(zzaor2.zza, 4, zzaor2.zzb));
                                this.zzc.zzb();
                            }
                        }
                    } else if (!this.zzb.zze() || !this.zzc.zze()) {
                        i = zze2;
                        i2 = i4;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        zzaor zzaor3 = this.zzb;
                        arrayList.add(Arrays.copyOf(zzaor3.zza, zzaor3.zzb));
                        zzaor zzaor4 = this.zzc;
                        arrayList.add(Arrays.copyOf(zzaor4.zza, zzaor4.zzb));
                        zzaor zzaor5 = this.zzb;
                        zzgq zze3 = zzgr.zze(zzaor5.zza, 4, zzaor5.zzb);
                        zzaor zzaor6 = this.zzc;
                        zzgp zzd3 = zzgr.zzd(zzaor6.zza, 4, zzaor6.zzb);
                        i2 = i4;
                        String zza3 = zzes.zza(zze3.zza, zze3.zzb, zze3.zzc);
                        zzafa zzafa = this.zzh;
                        zzal zzal = new zzal();
                        i = zze2;
                        zzal.zzK(this.zzg);
                        zzal.zzX("video/avc");
                        zzal.zzz(zza3);
                        zzal.zzac(zze3.zze);
                        zzal.zzI(zze3.zzf);
                        zzr zzr = new zzr();
                        zzr.zzc(zze3.zzj);
                        zzr.zzb(zze3.zzk);
                        zzr.zzd(zze3.zzl);
                        zzr.zzf(zze3.zzh + 8);
                        zzr.zza(zze3.zzi + 8);
                        zzal.zzA(zzr.zzg());
                        zzal.zzT(zze3.zzg);
                        zzal.zzL(arrayList);
                        zzafa.zzl(zzal.zzad());
                        this.zzj = true;
                        this.zzi.zzb(zze3);
                        this.zzi.zza(zzd3);
                        this.zzb.zzb();
                        this.zzc.zzb();
                    }
                }
                if (this.zzd.zzd(i7)) {
                    zzaor zzaor7 = this.zzd;
                    this.zzm.zzI(this.zzd.zza, zzgr.zzb(zzaor7.zza, zzaor7.zzb));
                    this.zzm.zzK(4);
                    this.zza.zza(j2, this.zzm);
                }
                if (this.zzi.zze(j, i6, this.zzj)) {
                    this.zzl = false;
                }
                long j3 = this.zzk;
                if (!this.zzj) {
                    this.zzb.zzc(b);
                    this.zzc.zzc(b);
                }
                this.zzd.zzc(b);
                this.zzi.zzd(j, b, j3, this.zzl);
                zzd2 = i2;
                zze2 = i;
            } else {
                int i8 = zze2;
                zzf(zzM, zzd2, zze2);
                return;
            }
        }
    }

    public final void zzb(zzadx zzadx, zzapo zzapo) {
        zzapo.zzc();
        this.zzg = zzapo.zzb();
        this.zzh = zzadx.zzw(zzapo.zza(), 2);
        this.zzi = new zzaok(this.zzh, false, false);
        this.zza.zzb(zzadx, zzapo);
    }

    public final void zzc() {
    }

    public final void zzd(long j, int i) {
        this.zzk = j;
        int i2 = i & 2;
        this.zzl = (i2 != 0) | this.zzl;
    }

    public final void zze() {
        this.zze = 0;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzgr.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzaok zzaok = this.zzi;
        if (zzaok != null) {
            zzaok.zzc();
        }
    }
}
