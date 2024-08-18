package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzakn {
    private static final zzfyt zza = zzfyt.zzc(zzfxr.zzc(':'));
    private static final zzfyt zzb = zzfyt.zzc(zzfxr.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0129, code lost:
        if (r8.equals("Super_SlowMotion_Deflickering_On") != false) goto L_0x014b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzadv r23, com.google.android.gms.internal.ads.zzaeq r24, java.util.List r25) throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            r2 = r24
            int r3 = r1.zzd
            r5 = 2
            r8 = 8
            r10 = 0
            switch(r3) {
                case 0: goto L_0x00ca;
                case 1: goto L_0x0096;
                case 2: goto L_0x0031;
                default: goto L_0x000f;
            }
        L_0x000f:
            long r3 = r23.zzf()
            long r5 = r23.zzd()
            long r7 = r23.zzf()
            long r5 = r5 - r7
            int r7 = r1.zze
            long r7 = (long) r7
            com.google.android.gms.internal.ads.zzfu r9 = new com.google.android.gms.internal.ads.zzfu
            long r5 = r5 - r7
            int r5 = (int) r5
            r9.<init>((int) r5)
            byte[] r6 = r9.zzM()
            r7 = 0
            r0.zzi(r6, r7, r5)
            r0 = 0
            goto L_0x00eb
        L_0x0031:
            long r11 = r23.zzd()
            int r3 = r1.zze
            int r3 = r3 + -20
            com.google.android.gms.internal.ads.zzfu r13 = new com.google.android.gms.internal.ads.zzfu
            r13.<init>((int) r3)
            byte[] r14 = r13.zzM()
            r0.zzi(r14, r10, r3)
            r0 = r10
        L_0x0046:
            int r14 = r3 / 12
            if (r0 >= r14) goto L_0x0076
            r13.zzL(r5)
            short r14 = r13.zzC()
            switch(r14) {
                case 2192: goto L_0x0058;
                case 2816: goto L_0x0058;
                case 2817: goto L_0x0058;
                case 2819: goto L_0x0058;
                case 2820: goto L_0x0058;
                default: goto L_0x0054;
            }
        L_0x0054:
            r13.zzL(r8)
            goto L_0x0071
        L_0x0058:
            int r15 = r1.zze
            long r9 = (long) r15
            long r9 = r11 - r9
            int r15 = r13.zzi()
            long r4 = (long) r15
            int r15 = r13.zzi()
            java.util.List r6 = r1.zzc
            com.google.android.gms.internal.ads.zzakm r7 = new com.google.android.gms.internal.ads.zzakm
            long r9 = r9 - r4
            r7.<init>(r14, r9, r15)
            r6.add(r7)
        L_0x0071:
            int r0 = r0 + 1
            r5 = 2
            r10 = 0
            goto L_0x0046
        L_0x0076:
            java.util.List r0 = r1.zzc
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0084
            r3 = 0
            r2.zza = r3
            goto L_0x01f7
        L_0x0084:
            r0 = 3
            r1.zzd = r0
            java.util.List r0 = r1.zzc
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzakm r0 = (com.google.android.gms.internal.ads.zzakm) r0
            long r3 = r0.zza
            r2.zza = r3
            goto L_0x01f7
        L_0x0096:
            r3 = r10
            com.google.android.gms.internal.ads.zzfu r4 = new com.google.android.gms.internal.ads.zzfu
            r4.<init>((int) r8)
            byte[] r5 = r4.zzM()
            r0.zzi(r5, r3, r8)
            int r3 = r4.zzi()
            int r3 = r3 + r8
            r1.zze = r3
            int r3 = r4.zzg()
            r4 = 1397048916(0x53454654, float:8.4728847E11)
            if (r3 == r4) goto L_0x00b9
            r3 = 0
            r2.zza = r3
            goto L_0x01f7
        L_0x00b9:
            long r3 = r23.zzf()
            int r0 = r1.zze
            int r0 = r0 + -12
            long r5 = (long) r0
            long r3 = r3 - r5
            r2.zza = r3
            r0 = 2
            r1.zzd = r0
            goto L_0x01f7
        L_0x00ca:
            long r3 = r23.zzd()
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x00e2
            r5 = 8
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00dd
            r6 = 0
            goto L_0x00e4
        L_0x00dd:
            r5 = -8
            long r6 = r3 + r5
            goto L_0x00e4
        L_0x00e2:
            r6 = 0
        L_0x00e4:
            r2.zza = r6
            r0 = 1
            r1.zzd = r0
            goto L_0x01f7
        L_0x00eb:
            java.util.List r5 = r1.zzc
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x01f3
            java.util.List r5 = r1.zzc
            java.lang.Object r5 = r5.get(r0)
            com.google.android.gms.internal.ads.zzakm r5 = (com.google.android.gms.internal.ads.zzakm) r5
            long r6 = r5.zza
            long r6 = r6 - r3
            int r6 = (int) r6
            r9.zzK(r6)
            r6 = 4
            r9.zzL(r6)
            int r7 = r9.zzi()
            java.nio.charset.Charset r8 = com.google.android.gms.internal.ads.zzfxs.zzc
            java.lang.String r8 = r9.zzA(r7, r8)
            int r10 = r8.hashCode()
            r11 = -1
            switch(r10) {
                case -1711564334: goto L_0x0140;
                case -1332107749: goto L_0x0136;
                case -1251387154: goto L_0x012c;
                case -830665521: goto L_0x0123;
                case 1760745220: goto L_0x0119;
                default: goto L_0x0118;
            }
        L_0x0118:
            goto L_0x014a
        L_0x0119:
            java.lang.String r6 = "Super_SlowMotion_BGM"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x014a
            r6 = 2
            goto L_0x014b
        L_0x0123:
            java.lang.String r10 = "Super_SlowMotion_Deflickering_On"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x014a
            goto L_0x014b
        L_0x012c:
            java.lang.String r6 = "Super_SlowMotion_Data"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x014a
            r6 = 1
            goto L_0x014b
        L_0x0136:
            java.lang.String r6 = "Super_SlowMotion_Edit_Data"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x014a
            r6 = 3
            goto L_0x014b
        L_0x0140:
            java.lang.String r6 = "SlowMotion_Data"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x014a
            r6 = 0
            goto L_0x014b
        L_0x014a:
            r6 = r11
        L_0x014b:
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0163;
                case 1: goto L_0x0160;
                case 2: goto L_0x015d;
                case 3: goto L_0x015a;
                case 4: goto L_0x0157;
                default: goto L_0x014f;
            }
        L_0x014f:
            java.lang.String r0 = "Invalid SEF name"
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r0, r8)
            throw r0
        L_0x0157:
            r6 = 2820(0xb04, float:3.952E-42)
            goto L_0x0165
        L_0x015a:
            r6 = 2819(0xb03, float:3.95E-42)
            goto L_0x0165
        L_0x015d:
            r6 = 2817(0xb01, float:3.947E-42)
            goto L_0x0165
        L_0x0160:
            r6 = 2816(0xb00, float:3.946E-42)
            goto L_0x0165
        L_0x0163:
            r6 = 2192(0x890, float:3.072E-42)
        L_0x0165:
            int r5 = r5.zzb
            int r7 = r7 + 8
            int r5 = r5 - r7
            switch(r6) {
                case 2192: goto L_0x0179;
                case 2816: goto L_0x0173;
                case 2817: goto L_0x0173;
                case 2819: goto L_0x0173;
                case 2820: goto L_0x0173;
                default: goto L_0x016d;
            }
        L_0x016d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0173:
            r6 = r25
            r12 = 0
            r13 = 3
            r14 = 2
            goto L_0x01ef
        L_0x0179:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.nio.charset.Charset r7 = com.google.android.gms.internal.ads.zzfxs.zzc
            java.lang.String r5 = r9.zzA(r5, r7)
            com.google.android.gms.internal.ads.zzfyt r7 = zzb
            java.util.List r5 = r7.zzf(r5)
            r7 = 0
        L_0x018b:
            int r10 = r5.size()
            if (r7 >= r10) goto L_0x01e2
            com.google.android.gms.internal.ads.zzfyt r10 = zza
            java.lang.Object r12 = r5.get(r7)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            java.util.List r10 = r10.zzf(r12)
            int r12 = r10.size()
            r13 = 3
            if (r12 != r13) goto L_0x01dd
            r12 = 0
            java.lang.Object r14 = r10.get(r12)     // Catch:{ NumberFormatException -> 0x01d7 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NumberFormatException -> 0x01d7 }
            long r17 = java.lang.Long.parseLong(r14)     // Catch:{ NumberFormatException -> 0x01d7 }
            r14 = 1
            java.lang.Object r15 = r10.get(r14)     // Catch:{ NumberFormatException -> 0x01d7 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ NumberFormatException -> 0x01d7 }
            long r19 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException -> 0x01d7 }
            r14 = 2
            java.lang.Object r10 = r10.get(r14)     // Catch:{ NumberFormatException -> 0x01d7 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x01d7 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01d7 }
            int r10 = r10 + r11
            r15 = 1
            int r21 = r15 << r10
            com.google.android.gms.internal.ads.zzaii r10 = new com.google.android.gms.internal.ads.zzaii     // Catch:{ NumberFormatException -> 0x01d7 }
            r16 = r10
            r16.<init>(r17, r19, r21)     // Catch:{ NumberFormatException -> 0x01d7 }
            r6.add(r10)     // Catch:{ NumberFormatException -> 0x01d7 }
            int r7 = r7 + 1
            goto L_0x018b
        L_0x01d7:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r8, r0)
            throw r0
        L_0x01dd:
            com.google.android.gms.internal.ads.zzch r0 = com.google.android.gms.internal.ads.zzch.zza(r8, r8)
            throw r0
        L_0x01e2:
            r12 = 0
            r13 = 3
            r14 = 2
            com.google.android.gms.internal.ads.zzaij r5 = new com.google.android.gms.internal.ads.zzaij
            r5.<init>(r6)
            r6 = r25
            r6.add(r5)
        L_0x01ef:
            int r0 = r0 + 1
            goto L_0x00eb
        L_0x01f3:
            r3 = 0
            r2.zza = r3
        L_0x01f7:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakn.zza(com.google.android.gms.internal.ads.zzadv, com.google.android.gms.internal.ads.zzaeq, java.util.List):int");
    }
}
