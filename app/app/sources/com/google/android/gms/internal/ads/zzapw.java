package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapw implements zzadu {
    public static final zzaea zza = new zzaps();
    private zzadx zzb;
    private zzafa zzc;
    private int zzd = 0;
    private long zze = -1;
    private zzapu zzf;
    private int zzg = -1;
    private long zzh = -1;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00dc, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00de, code lost:
        if (r17 == 0) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e0, code lost:
        r0.zzf = new com.google.android.gms.internal.ads.zzapv(r0.zzb, r0.zzc, r15, "audio/raw", r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0107, code lost:
        throw com.google.android.gms.internal.ads.zzch.zzc("Unsupported WAV format type: " + r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzadv r19, com.google.android.gms.internal.ads.zzaeq r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzc
            com.google.android.gms.internal.ads.zzeq.zzb(r2)
            int r2 = com.google.android.gms.internal.ads.zzgd.zza
            int r2 = r0.zzd
            r3 = -1
            r4 = 0
            r5 = 4
            r6 = 1
            r7 = -1
            r9 = 0
            switch(r2) {
                case 0: goto L_0x013e;
                case 1: goto L_0x0108;
                case 2: goto L_0x008a;
                case 3: goto L_0x001f;
                default: goto L_0x0017;
            }
        L_0x0017:
            long r10 = r0.zzh
            int r2 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0179
            goto L_0x017a
        L_0x001f:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzapz.zza(r19)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            r0.zzg = r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r10 = r0.zze
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0047
            r12 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r6 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x0046
            r2 = r10
            goto L_0x0048
        L_0x0046:
            goto L_0x0048
        L_0x0047:
        L_0x0048:
            int r6 = r0.zzg
            long r10 = (long) r6
            long r10 = r10 + r2
            r0.zzh = r10
            long r1 = r19.zzd()
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x007c
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x007c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Data exceeds input length: "
            r3.append(r6)
            r3.append(r10)
            java.lang.String r6 = ", "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r6 = "WavExtractor"
            com.google.android.gms.internal.ads.zzfk.zzf(r6, r3)
            r0.zzh = r1
            r10 = r1
            goto L_0x007d
        L_0x007c:
        L_0x007d:
            com.google.android.gms.internal.ads.zzapu r1 = r0.zzf
            if (r1 == 0) goto L_0x0089
            int r2 = r0.zzg
            r1.zza(r2, r10)
            r0.zzd = r5
            return r9
        L_0x0089:
            throw r4
        L_0x008a:
            com.google.android.gms.internal.ads.zzapx r15 = com.google.android.gms.internal.ads.zzapz.zzb(r19)
            int r1 = r15.zza
            r2 = 17
            if (r1 != r2) goto L_0x00a0
            com.google.android.gms.internal.ads.zzapt r1 = new com.google.android.gms.internal.ads.zzapt
            com.google.android.gms.internal.ads.zzadx r2 = r0.zzb
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzc
            r1.<init>(r2, r3, r15)
            r0.zzf = r1
            goto L_0x00ee
        L_0x00a0:
            r2 = 6
            if (r1 != r2) goto L_0x00b4
            com.google.android.gms.internal.ads.zzapv r1 = new com.google.android.gms.internal.ads.zzapv
            com.google.android.gms.internal.ads.zzadx r13 = r0.zzb
            com.google.android.gms.internal.ads.zzafa r14 = r0.zzc
            java.lang.String r16 = "audio/g711-alaw"
            r17 = -1
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
            goto L_0x00ee
        L_0x00b4:
            r2 = 7
            if (r1 != r2) goto L_0x00c8
            com.google.android.gms.internal.ads.zzapv r1 = new com.google.android.gms.internal.ads.zzapv
            com.google.android.gms.internal.ads.zzadx r13 = r0.zzb
            com.google.android.gms.internal.ads.zzafa r14 = r0.zzc
            java.lang.String r16 = "audio/g711-mlaw"
            r17 = -1
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
            goto L_0x00ee
        L_0x00c8:
            int r2 = r15.zze
            switch(r1) {
                case 1: goto L_0x00d8;
                case 3: goto L_0x00d0;
                case 65534: goto L_0x00d8;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            r17 = r9
            goto L_0x00de
        L_0x00d0:
            r3 = 32
            if (r2 != r3) goto L_0x00d5
            goto L_0x00dc
        L_0x00d5:
            r17 = r9
            goto L_0x00de
        L_0x00d8:
            int r5 = com.google.android.gms.internal.ads.zzgd.zzl(r2)
        L_0x00dc:
            r17 = r5
        L_0x00de:
            if (r17 == 0) goto L_0x00f2
            com.google.android.gms.internal.ads.zzapv r1 = new com.google.android.gms.internal.ads.zzapv
            com.google.android.gms.internal.ads.zzadx r13 = r0.zzb
            com.google.android.gms.internal.ads.zzafa r14 = r0.zzc
            java.lang.String r16 = "audio/raw"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zzf = r1
        L_0x00ee:
            r1 = 3
            r0.zzd = r1
            return r9
        L_0x00f2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported WAV format type: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zzc(r1)
            throw r1
        L_0x0108:
            com.google.android.gms.internal.ads.zzfu r2 = new com.google.android.gms.internal.ads.zzfu
            r3 = 8
            r2.<init>((int) r3)
            com.google.android.gms.internal.ads.zzapy r4 = com.google.android.gms.internal.ads.zzapy.zza(r1, r2)
            int r5 = r4.zza
            r6 = 1685272116(0x64733634, float:1.7945858E22)
            if (r5 == r6) goto L_0x011e
            r19.zzj()
            goto L_0x0138
        L_0x011e:
            com.google.android.gms.internal.ads.zzadi r1 = (com.google.android.gms.internal.ads.zzadi) r1
            r1.zzl(r3, r9)
            r2.zzK(r9)
            byte[] r5 = r2.zzM()
            r1.zzm(r5, r9, r3, r9)
            long r7 = r2.zzr()
            long r4 = r4.zzb
            int r2 = (int) r4
            int r2 = r2 + r3
            r1.zzo(r2, r9)
        L_0x0138:
            r0.zze = r7
            r1 = 2
            r0.zzd = r1
            return r9
        L_0x013e:
            long r7 = r19.zzf()
            r10 = 0
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x014a
            r2 = r6
            goto L_0x014b
        L_0x014a:
            r2 = r9
        L_0x014b:
            com.google.android.gms.internal.ads.zzeq.zzf(r2)
            int r2 = r0.zzg
            if (r2 == r3) goto L_0x015a
            com.google.android.gms.internal.ads.zzadi r1 = (com.google.android.gms.internal.ads.zzadi) r1
            r1.zzo(r2, r9)
            r0.zzd = r5
            goto L_0x0171
        L_0x015a:
            boolean r2 = com.google.android.gms.internal.ads.zzapz.zzc(r19)
            if (r2 == 0) goto L_0x0172
            long r2 = r19.zze()
            long r4 = r19.zzf()
            long r2 = r2 - r4
            com.google.android.gms.internal.ads.zzadi r1 = (com.google.android.gms.internal.ads.zzadi) r1
            int r2 = (int) r2
            r1.zzo(r2, r9)
            r0.zzd = r6
        L_0x0171:
            return r9
        L_0x0172:
            java.lang.String r1 = "Unsupported or unrecognized wav file type."
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zza(r1, r4)
            throw r1
        L_0x0179:
            r6 = r9
        L_0x017a:
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            long r5 = r0.zzh
            long r7 = r19.zzf()
            long r5 = r5 - r7
            com.google.android.gms.internal.ads.zzapu r2 = r0.zzf
            if (r2 == 0) goto L_0x0190
            boolean r1 = r2.zzc(r1, r5)
            if (r1 == 0) goto L_0x018f
            return r3
        L_0x018f:
            return r9
        L_0x0190:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapw.zzb(com.google.android.gms.internal.ads.zzadv, com.google.android.gms.internal.ads.zzaeq):int");
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzb = zzadx;
        this.zzc = zzadx.zzw(0, 1);
        zzadx.zzD();
    }

    public final void zze(long j, long j2) {
        this.zzd = j == 0 ? 0 : 4;
        zzapu zzapu = this.zzf;
        if (zzapu != null) {
            zzapu.zzb(j2);
        }
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        return zzapz.zzc(zzadv);
    }
}
