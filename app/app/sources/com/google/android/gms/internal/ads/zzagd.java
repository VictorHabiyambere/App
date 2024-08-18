package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzagd implements zzadu {
    public static final zzaea zza = new zzagc();
    private final zzfu zzb = new zzfu(4);
    private final zzfu zzc = new zzfu(9);
    private final zzfu zzd = new zzfu(11);
    private final zzfu zze = new zzfu();
    private final zzage zzf = new zzage();
    private zzadx zzg;
    private int zzh = 1;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private boolean zzo;
    private zzagb zzp;
    private zzagh zzq;

    private final zzfu zza(zzadv zzadv) throws IOException {
        if (this.zzm > this.zze.zzc()) {
            zzfu zzfu = this.zze;
            int zzc2 = zzfu.zzc();
            zzfu.zzI(new byte[Math.max(zzc2 + zzc2, this.zzm)], 0);
        } else {
            this.zze.zzK(0);
        }
        this.zze.zzJ(this.zzm);
        ((zzadi) zzadv).zzn(this.zze.zzM(), 0, this.zzm, false);
        return this.zze;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzg() {
        if (!this.zzo) {
            this.zzg.zzO(new zzaes(-9223372036854775807L, 0));
            this.zzo = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0008 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzadv r16, com.google.android.gms.internal.ads.zzaeq r17) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzg
            com.google.android.gms.internal.ads.zzeq.zzb(r2)
        L_0x0008:
            int r2 = r0.zzh
            r3 = -1
            r4 = 3
            r5 = 8
            r6 = 2
            r7 = 9
            r8 = 4
            r9 = 1
            r10 = 0
            switch(r2) {
                case 1: goto L_0x011d;
                case 2: goto L_0x010f;
                case 3: goto L_0x00c8;
                case 4: goto L_0x001d;
                default: goto L_0x0017;
            }
        L_0x0017:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x001d:
            boolean r2 = r0.zzi
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x002c
            long r13 = r0.zzj
            long r3 = r0.zzn
            long r13 = r13 + r3
            goto L_0x0038
        L_0x002c:
            com.google.android.gms.internal.ads.zzage r2 = r0.zzf
            long r2 = r2.zzc()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0039
            r13 = 0
        L_0x0038:
            goto L_0x003b
        L_0x0039:
            long r13 = r0.zzn
        L_0x003b:
            int r2 = r0.zzl
            if (r2 != r5) goto L_0x0053
            com.google.android.gms.internal.ads.zzagb r2 = r0.zzp
            if (r2 == 0) goto L_0x0052
            r15.zzg()
            com.google.android.gms.internal.ads.zzagb r2 = r0.zzp
            com.google.android.gms.internal.ads.zzfu r3 = r15.zza(r16)
            boolean r2 = r2.zzf(r3, r13)
            r3 = r9
            goto L_0x00a7
        L_0x0052:
            goto L_0x0054
        L_0x0053:
            r5 = r2
        L_0x0054:
            if (r5 != r7) goto L_0x0069
            com.google.android.gms.internal.ads.zzagh r2 = r0.zzq
            if (r2 == 0) goto L_0x009d
            r15.zzg()
            com.google.android.gms.internal.ads.zzagh r2 = r0.zzq
            com.google.android.gms.internal.ads.zzfu r3 = r15.zza(r16)
            boolean r2 = r2.zzf(r3, r13)
            r3 = r9
            goto L_0x00a7
        L_0x0069:
            r2 = 18
            if (r5 != r2) goto L_0x009d
            boolean r2 = r0.zzo
            if (r2 != 0) goto L_0x009d
            com.google.android.gms.internal.ads.zzage r2 = r0.zzf
            com.google.android.gms.internal.ads.zzfu r3 = r15.zza(r16)
            boolean r2 = r2.zzf(r3, r13)
            com.google.android.gms.internal.ads.zzage r3 = r0.zzf
            long r4 = r3.zzc()
            int r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzadx r7 = r0.zzg
            com.google.android.gms.internal.ads.zzaem r13 = new com.google.android.gms.internal.ads.zzaem
            long[] r14 = r3.zzd()
            long[] r3 = r3.zze()
            r13.<init>(r14, r3, r4)
            r7.zzO(r13)
            r0.zzo = r9
            goto L_0x009b
        L_0x009a:
        L_0x009b:
            r3 = r9
            goto L_0x00a7
        L_0x009d:
            int r2 = r0.zzm
            r3 = r1
            com.google.android.gms.internal.ads.zzadi r3 = (com.google.android.gms.internal.ads.zzadi) r3
            r3.zzo(r2, r10)
            r2 = r10
            r3 = r2
        L_0x00a7:
            boolean r4 = r0.zzi
            if (r4 != 0) goto L_0x00c1
            if (r2 == 0) goto L_0x00c1
            r0.zzi = r9
            com.google.android.gms.internal.ads.zzage r2 = r0.zzf
            long r4 = r2.zzc()
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x00bd
            long r4 = r0.zzn
            long r4 = -r4
            goto L_0x00bf
        L_0x00bd:
            r4 = 0
        L_0x00bf:
            r0.zzj = r4
        L_0x00c1:
            r0.zzk = r8
            r0.zzh = r6
            if (r3 == 0) goto L_0x0008
            return r10
        L_0x00c8:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            byte[] r2 = r2.zzM()
            r5 = 11
            boolean r2 = r1.zzn(r2, r10, r5, r9)
            if (r2 != 0) goto L_0x00d7
            return r3
        L_0x00d7:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            r2.zzK(r10)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            int r2 = r2.zzm()
            r0.zzl = r2
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            int r2 = r2.zzo()
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            int r2 = r2.zzo()
            long r2 = (long) r2
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            int r2 = r2.zzm()
            int r2 = r2 << 24
            long r5 = r0.zzn
            long r2 = (long) r2
            long r2 = r2 | r5
            r5 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r5
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzd
            r2.zzL(r4)
            r0.zzh = r8
            goto L_0x0008
        L_0x010f:
            int r2 = r0.zzk
            r3 = r1
            com.google.android.gms.internal.ads.zzadi r3 = (com.google.android.gms.internal.ads.zzadi) r3
            r3.zzo(r2, r10)
            r0.zzk = r10
            r0.zzh = r4
            goto L_0x0008
        L_0x011d:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzc
            byte[] r2 = r2.zzM()
            boolean r2 = r1.zzn(r2, r10, r7, r9)
            if (r2 != 0) goto L_0x012a
            return r3
        L_0x012a:
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzc
            r2.zzK(r10)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzc
            r2.zzL(r8)
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzc
            int r2 = r2.zzm()
            r3 = r2 & 4
            r2 = r2 & r9
            if (r3 == 0) goto L_0x0150
            com.google.android.gms.internal.ads.zzagb r3 = r0.zzp
            if (r3 != 0) goto L_0x0150
            com.google.android.gms.internal.ads.zzagb r3 = new com.google.android.gms.internal.ads.zzagb
            com.google.android.gms.internal.ads.zzadx r4 = r0.zzg
            com.google.android.gms.internal.ads.zzafa r4 = r4.zzw(r5, r9)
            r3.<init>(r4)
            r0.zzp = r3
        L_0x0150:
            if (r2 == 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzagh r2 = r0.zzq
            if (r2 != 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzagh r2 = new com.google.android.gms.internal.ads.zzagh
            com.google.android.gms.internal.ads.zzadx r3 = r0.zzg
            com.google.android.gms.internal.ads.zzafa r3 = r3.zzw(r7, r6)
            r2.<init>(r3)
            r0.zzq = r2
        L_0x0163:
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzg
            r2.zzD()
            com.google.android.gms.internal.ads.zzfu r2 = r0.zzc
            int r2 = r2.zzg()
            int r2 = r2 + -5
            r0.zzk = r2
            r0.zzh = r6
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagd.zzb(com.google.android.gms.internal.ads.zzadv, com.google.android.gms.internal.ads.zzaeq):int");
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzg = zzadx;
    }

    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        zzadi zzadi = (zzadi) zzadv;
        zzadi.zzm(this.zzb.zzM(), 0, 3, false);
        this.zzb.zzK(0);
        if (this.zzb.zzo() != 4607062) {
            return false;
        }
        zzadi.zzm(this.zzb.zzM(), 0, 2, false);
        this.zzb.zzK(0);
        if ((this.zzb.zzq() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        zzadi.zzm(this.zzb.zzM(), 0, 4, false);
        this.zzb.zzK(0);
        int zzg2 = this.zzb.zzg();
        zzadv.zzj();
        zzadi.zzl(zzg2, false);
        zzadi.zzm(this.zzb.zzM(), 0, 4, false);
        this.zzb.zzK(0);
        if (this.zzb.zzg() == 0) {
            return true;
        }
        return false;
    }
}
