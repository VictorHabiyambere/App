package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzuj {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0550, code lost:
        if (r1.equals("L90") != false) goto L_0x05a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzan r22) {
        /*
            r0 = r22
            java.lang.String r1 = r0.zzk
            if (r1 != 0) goto L_0x0009
            r2 = 0
            goto L_0x084d
        L_0x0009:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = r0.zzn
            java.lang.String r4 = "video/dolby-vision"
            boolean r3 = r4.equals(r3)
            r5 = 1024(0x400, float:1.435E-42)
            r6 = 512(0x200, float:7.175E-43)
            r7 = 256(0x100, float:3.59E-43)
            r8 = 128(0x80, float:1.794E-43)
            r9 = 64
            r10 = 32
            r12 = 3
            r13 = 8
            r14 = 16
            r15 = 4
            r2 = 2
            java.lang.String r4 = "MediaCodecUtil"
            r11 = 1
            if (r3 == 0) goto L_0x0249
            java.lang.String r0 = r0.zzk
            int r3 = r1.length
            if (r3 >= r12) goto L_0x0044
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0044:
            java.util.regex.Pattern r3 = zzb
            r12 = r1[r11]
            java.util.regex.Matcher r3 = r3.matcher(r12)
            boolean r12 = r3.matches()
            if (r12 != 0) goto L_0x0062
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0062:
            java.lang.String r0 = r3.group(r11)
            if (r0 != 0) goto L_0x006c
            r3 = 0
            goto L_0x012d
        L_0x006c:
            int r3 = r0.hashCode()
            switch(r3) {
                case 1536: goto L_0x011f;
                case 1537: goto L_0x010f;
                case 1538: goto L_0x00ff;
                case 1539: goto L_0x00ef;
                case 1540: goto L_0x00df;
                case 1541: goto L_0x00cf;
                case 1542: goto L_0x00be;
                case 1543: goto L_0x00ac;
                case 1544: goto L_0x009a;
                case 1545: goto L_0x0088;
                case 1567: goto L_0x0076;
                default: goto L_0x0073;
            }
        L_0x0073:
            r3 = 0
            goto L_0x012d
        L_0x0076:
            java.lang.String r3 = "10"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0085
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            goto L_0x012d
        L_0x0085:
            r3 = 0
            goto L_0x012d
        L_0x0088:
            java.lang.String r3 = "09"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0097
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            goto L_0x012d
        L_0x0097:
            r3 = 0
            goto L_0x012d
        L_0x009a:
            java.lang.String r3 = "08"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00a9
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            goto L_0x012d
        L_0x00a9:
            r3 = 0
            goto L_0x012d
        L_0x00ac:
            java.lang.String r3 = "07"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00bb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            goto L_0x012d
        L_0x00bb:
            r3 = 0
            goto L_0x012d
        L_0x00be:
            java.lang.String r3 = "06"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00cd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            goto L_0x012d
        L_0x00cd:
            r3 = 0
            goto L_0x012d
        L_0x00cf:
            java.lang.String r3 = "05"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00dd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            goto L_0x012d
        L_0x00dd:
            r3 = 0
            goto L_0x012d
        L_0x00df:
            java.lang.String r3 = "04"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00ed
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            goto L_0x012d
        L_0x00ed:
            r3 = 0
            goto L_0x012d
        L_0x00ef:
            java.lang.String r3 = "03"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x00fd
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            goto L_0x012d
        L_0x00fd:
            r3 = 0
            goto L_0x012d
        L_0x00ff:
            java.lang.String r3 = "02"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x010d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            goto L_0x012d
        L_0x010d:
            r3 = 0
            goto L_0x012d
        L_0x010f:
            java.lang.String r3 = "01"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x011d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            goto L_0x012d
        L_0x011d:
            r3 = 0
            goto L_0x012d
        L_0x011f:
            java.lang.String r3 = "00"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x012c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            goto L_0x012d
        L_0x012c:
            r3 = 0
        L_0x012d:
            if (r3 != 0) goto L_0x013f
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x013f:
            r0 = r1[r2]
            if (r0 != 0) goto L_0x0147
            r1 = 0
            goto L_0x0230
        L_0x0147:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x0222;
                case 1538: goto L_0x0212;
                case 1539: goto L_0x0202;
                case 1540: goto L_0x01f2;
                case 1541: goto L_0x01e2;
                case 1542: goto L_0x01d2;
                case 1543: goto L_0x01c1;
                case 1544: goto L_0x01af;
                case 1545: goto L_0x019d;
                case 1567: goto L_0x018b;
                case 1568: goto L_0x0179;
                case 1569: goto L_0x0165;
                case 1570: goto L_0x0151;
                default: goto L_0x014e;
            }
        L_0x014e:
            r1 = 0
            goto L_0x0230
        L_0x0151:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0162
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0230
        L_0x0162:
            r1 = 0
            goto L_0x0230
        L_0x0165:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0176
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0230
        L_0x0176:
            r1 = 0
            goto L_0x0230
        L_0x0179:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0188
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x0230
        L_0x0188:
            r1 = 0
            goto L_0x0230
        L_0x018b:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x019a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x0230
        L_0x019a:
            r1 = 0
            goto L_0x0230
        L_0x019d:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01ac
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x0230
        L_0x01ac:
            r1 = 0
            goto L_0x0230
        L_0x01af:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01be
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x0230
        L_0x01be:
            r1 = 0
            goto L_0x0230
        L_0x01c1:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01d0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x0230
        L_0x01d0:
            r1 = 0
            goto L_0x0230
        L_0x01d2:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01e0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x0230
        L_0x01e0:
            r1 = 0
            goto L_0x0230
        L_0x01e2:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01f0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x0230
        L_0x01f0:
            r1 = 0
            goto L_0x0230
        L_0x01f2:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0200
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x0230
        L_0x0200:
            r1 = 0
            goto L_0x0230
        L_0x0202:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0210
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x0230
        L_0x0210:
            r1 = 0
            goto L_0x0230
        L_0x0212:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0220
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x0230
        L_0x0220:
            r1 = 0
            goto L_0x0230
        L_0x0222:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x022f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0230
        L_0x022f:
            r1 = 0
        L_0x0230:
            if (r1 != 0) goto L_0x0242
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0242:
            android.util.Pair r2 = new android.util.Pair
            r2.<init>(r3, r1)
            goto L_0x084d
        L_0x0249:
            r3 = 0
            r9 = r1[r3]
            int r19 = r9.hashCode()
            r20 = 5
            r7 = 6
            r5 = -1
            switch(r19) {
                case 3004662: goto L_0x0296;
                case 3006243: goto L_0x028c;
                case 3006244: goto L_0x0282;
                case 3199032: goto L_0x0278;
                case 3214780: goto L_0x026e;
                case 3356560: goto L_0x0264;
                case 3624515: goto L_0x0259;
                default: goto L_0x0258;
            }
        L_0x0258:
            goto L_0x02a1
        L_0x0259:
            java.lang.String r10 = "vp09"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r2
            goto L_0x02a2
        L_0x0264:
            java.lang.String r10 = "mp4a"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r7
            goto L_0x02a2
        L_0x026e:
            java.lang.String r10 = "hvc1"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r15
            goto L_0x02a2
        L_0x0278:
            java.lang.String r10 = "hev1"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r12
            goto L_0x02a2
        L_0x0282:
            java.lang.String r10 = "avc2"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r11
            goto L_0x02a2
        L_0x028c:
            java.lang.String r10 = "avc1"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r3
            goto L_0x02a2
        L_0x0296:
            java.lang.String r10 = "av01"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x0258
            r9 = r20
            goto L_0x02a2
        L_0x02a1:
            r9 = r5
        L_0x02a2:
            r10 = 8192(0x2000, float:1.14794E-41)
            switch(r9) {
                case 0: goto L_0x0759;
                case 1: goto L_0x0759;
                case 2: goto L_0x06ac;
                case 3: goto L_0x041a;
                case 4: goto L_0x041a;
                case 5: goto L_0x0320;
                case 6: goto L_0x02aa;
                default: goto L_0x02a7;
            }
        L_0x02a7:
            r2 = 0
            goto L_0x084d
        L_0x02aa:
            java.lang.String r6 = r0.zzk
            int r0 = r1.length
            if (r0 == r12) goto L_0x02bf
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x02bf:
            r0 = r1[r11]     // Catch:{ NumberFormatException -> 0x030f }
            int r0 = java.lang.Integer.parseInt(r0, r14)     // Catch:{ NumberFormatException -> 0x030f }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzcg.zzd(r0)     // Catch:{ NumberFormatException -> 0x030f }
            java.lang.String r8 = "audio/mp4a-latm"
            boolean r0 = r8.equals(r0)     // Catch:{ NumberFormatException -> 0x030f }
            if (r0 == 0) goto L_0x030c
            r0 = r1[r2]     // Catch:{ NumberFormatException -> 0x030f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x030f }
            switch(r0) {
                case 1: goto L_0x02f9;
                case 2: goto L_0x02f7;
                case 3: goto L_0x02f6;
                case 4: goto L_0x02f4;
                case 5: goto L_0x02f1;
                case 6: goto L_0x02ef;
                case 17: goto L_0x02ec;
                case 20: goto L_0x02e9;
                case 23: goto L_0x02e6;
                case 29: goto L_0x02e3;
                case 39: goto L_0x02e0;
                case 42: goto L_0x02dd;
                default: goto L_0x02db;
            }     // Catch:{ NumberFormatException -> 0x030f }
        L_0x02db:
            r12 = r5
            goto L_0x02fa
        L_0x02dd:
            r12 = 42
            goto L_0x02fa
        L_0x02e0:
            r12 = 39
            goto L_0x02fa
        L_0x02e3:
            r12 = 29
            goto L_0x02fa
        L_0x02e6:
            r12 = 23
            goto L_0x02fa
        L_0x02e9:
            r12 = 20
            goto L_0x02fa
        L_0x02ec:
            r12 = 17
            goto L_0x02fa
        L_0x02ef:
            r12 = r7
            goto L_0x02fa
        L_0x02f1:
            r12 = r20
            goto L_0x02fa
        L_0x02f4:
            r12 = r15
            goto L_0x02fa
        L_0x02f6:
            goto L_0x02fa
        L_0x02f7:
            r12 = r2
            goto L_0x02fa
        L_0x02f9:
            r12 = r11
        L_0x02fa:
            if (r12 == r5) goto L_0x030c
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x030f }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)     // Catch:{ NumberFormatException -> 0x030f }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x030f }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x030f }
            r2 = r0
            goto L_0x084d
        L_0x030c:
            r2 = 0
            goto L_0x084d
        L_0x030f:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0320:
            java.lang.String r9 = r0.zzk
            com.google.android.gms.internal.ads.zzt r0 = r0.zzz
            int r14 = r1.length
            if (r14 >= r15) goto L_0x0337
            java.lang.String r0 = java.lang.String.valueOf(r9)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0337:
            r14 = r1[r11]     // Catch:{ NumberFormatException -> 0x0409 }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x0409 }
            r8 = r1[r2]     // Catch:{ NumberFormatException -> 0x0409 }
            java.lang.String r3 = r8.substring(r3, r2)     // Catch:{ NumberFormatException -> 0x0409 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x0409 }
            r1 = r1[r12]     // Catch:{ NumberFormatException -> 0x0409 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0409 }
            if (r14 == 0) goto L_0x0367
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0367:
            if (r1 == r13) goto L_0x0399
            r8 = 10
            if (r1 == r8) goto L_0x0384
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unknown AV1 bit depth: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0384:
            if (r0 == 0) goto L_0x0397
            byte[] r1 = r0.zzg
            if (r1 != 0) goto L_0x0394
            int r0 = r0.zzf
            r1 = 7
            if (r0 == r1) goto L_0x0394
            if (r0 != r7) goto L_0x0397
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x039a
        L_0x0394:
            r1 = 4096(0x1000, float:5.74E-42)
            goto L_0x039a
        L_0x0397:
            r1 = r2
            goto L_0x039a
        L_0x0399:
            r1 = r11
        L_0x039a:
            switch(r3) {
                case 0: goto L_0x03e0;
                case 1: goto L_0x03de;
                case 2: goto L_0x03dc;
                case 3: goto L_0x03da;
                case 4: goto L_0x03d7;
                case 5: goto L_0x03d4;
                case 6: goto L_0x03d1;
                case 7: goto L_0x03ce;
                case 8: goto L_0x03cb;
                case 9: goto L_0x03c9;
                case 10: goto L_0x03c6;
                case 11: goto L_0x03c3;
                case 12: goto L_0x03c0;
                case 13: goto L_0x03be;
                case 14: goto L_0x03bb;
                case 15: goto L_0x03b7;
                case 16: goto L_0x03b4;
                case 17: goto L_0x03b1;
                case 18: goto L_0x03ae;
                case 19: goto L_0x03ab;
                case 20: goto L_0x03a8;
                case 21: goto L_0x03a5;
                case 22: goto L_0x03a2;
                case 23: goto L_0x039f;
                default: goto L_0x039d;
            }
        L_0x039d:
            r0 = r5
            goto L_0x03e1
        L_0x039f:
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x03e1
        L_0x03a2:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x03e1
        L_0x03a5:
            r0 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x03e1
        L_0x03a8:
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x03e1
        L_0x03ab:
            r0 = 524288(0x80000, float:7.34684E-40)
            goto L_0x03e1
        L_0x03ae:
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L_0x03e1
        L_0x03b1:
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x03e1
        L_0x03b4:
            r0 = 65536(0x10000, float:9.18355E-41)
            goto L_0x03e1
        L_0x03b7:
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L_0x03e1
        L_0x03bb:
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x03e1
        L_0x03be:
            r0 = r10
            goto L_0x03e1
        L_0x03c0:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x03e1
        L_0x03c3:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x03e1
        L_0x03c6:
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x03e1
        L_0x03c9:
            r0 = r6
            goto L_0x03e1
        L_0x03cb:
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x03e1
        L_0x03ce:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x03e1
        L_0x03d1:
            r0 = 64
            goto L_0x03e1
        L_0x03d4:
            r0 = 32
            goto L_0x03e1
        L_0x03d7:
            r0 = 16
            goto L_0x03e1
        L_0x03da:
            r0 = r13
            goto L_0x03e1
        L_0x03dc:
            r0 = r15
            goto L_0x03e1
        L_0x03de:
            r0 = r2
            goto L_0x03e1
        L_0x03e0:
            r0 = r11
        L_0x03e1:
            if (r0 != r5) goto L_0x03fa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown AV1 level: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x03fa:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.<init>(r1, r0)
            goto L_0x084d
        L_0x0409:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r9)
            java.lang.String r1 = "Ignoring malformed AV1 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x041a:
            java.lang.String r8 = r0.zzk
            com.google.android.gms.internal.ads.zzt r0 = r0.zzz
            int r9 = r1.length
            if (r9 >= r15) goto L_0x0431
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0431:
            java.util.regex.Pattern r9 = zzb
            r14 = r1[r11]
            java.util.regex.Matcher r9 = r9.matcher(r14)
            boolean r14 = r9.matches()
            if (r14 != 0) goto L_0x044f
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "Ignoring malformed HEVC codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x044f:
            java.lang.String r8 = r9.group(r11)
            java.lang.String r9 = "1"
            boolean r9 = r9.equals(r8)
            if (r9 == 0) goto L_0x045e
            r0 = r11
            goto L_0x0471
        L_0x045e:
            java.lang.String r9 = "2"
            boolean r9 = r9.equals(r8)
            if (r9 == 0) goto L_0x069c
            if (r0 == 0) goto L_0x0470
            int r0 = r0.zzf
            if (r0 != r7) goto L_0x0470
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0471
        L_0x0470:
            r0 = r2
        L_0x0471:
            r1 = r1[r12]
            if (r1 != 0) goto L_0x0479
            r2 = 0
            goto L_0x067e
        L_0x0479:
            int r8 = r1.hashCode()
            switch(r8) {
                case 70821: goto L_0x059d;
                case 70914: goto L_0x0592;
                case 70917: goto L_0x0587;
                case 71007: goto L_0x057c;
                case 71010: goto L_0x0571;
                case 74665: goto L_0x0567;
                case 74758: goto L_0x055d;
                case 74761: goto L_0x0553;
                case 74851: goto L_0x054a;
                case 74854: goto L_0x053f;
                case 2193639: goto L_0x0533;
                case 2193642: goto L_0x0527;
                case 2193732: goto L_0x051b;
                case 2193735: goto L_0x050f;
                case 2193738: goto L_0x0503;
                case 2193825: goto L_0x04f7;
                case 2193828: goto L_0x04eb;
                case 2193831: goto L_0x04df;
                case 2312803: goto L_0x04d3;
                case 2312806: goto L_0x04c8;
                case 2312896: goto L_0x04bd;
                case 2312899: goto L_0x04b2;
                case 2312902: goto L_0x04a6;
                case 2312989: goto L_0x049a;
                case 2312992: goto L_0x048e;
                case 2312995: goto L_0x0482;
                default: goto L_0x0480;
            }
        L_0x0480:
            goto L_0x05a8
        L_0x0482:
            java.lang.String r3 = "L186"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 12
            goto L_0x05a9
        L_0x048e:
            java.lang.String r3 = "L183"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 11
            goto L_0x05a9
        L_0x049a:
            java.lang.String r3 = "L180"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 10
            goto L_0x05a9
        L_0x04a6:
            java.lang.String r3 = "L156"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 9
            goto L_0x05a9
        L_0x04b2:
            java.lang.String r3 = "L153"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r13
            goto L_0x05a9
        L_0x04bd:
            java.lang.String r3 = "L150"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 7
            goto L_0x05a9
        L_0x04c8:
            java.lang.String r3 = "L123"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r7
            goto L_0x05a9
        L_0x04d3:
            java.lang.String r3 = "L120"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r20
            goto L_0x05a9
        L_0x04df:
            java.lang.String r3 = "H186"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 25
            goto L_0x05a9
        L_0x04eb:
            java.lang.String r3 = "H183"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 24
            goto L_0x05a9
        L_0x04f7:
            java.lang.String r3 = "H180"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 23
            goto L_0x05a9
        L_0x0503:
            java.lang.String r3 = "H156"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 22
            goto L_0x05a9
        L_0x050f:
            java.lang.String r3 = "H153"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 21
            goto L_0x05a9
        L_0x051b:
            java.lang.String r3 = "H150"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 20
            goto L_0x05a9
        L_0x0527:
            java.lang.String r3 = "H123"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 19
            goto L_0x05a9
        L_0x0533:
            java.lang.String r3 = "H120"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 18
            goto L_0x05a9
        L_0x053f:
            java.lang.String r3 = "L93"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r15
            goto L_0x05a9
        L_0x054a:
            java.lang.String r3 = "L90"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            goto L_0x05a9
        L_0x0553:
            java.lang.String r3 = "L63"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r2
            goto L_0x05a9
        L_0x055d:
            java.lang.String r3 = "L60"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = r11
            goto L_0x05a9
        L_0x0567:
            java.lang.String r7 = "L30"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x05a8
            r12 = r3
            goto L_0x05a9
        L_0x0571:
            java.lang.String r3 = "H93"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 17
            goto L_0x05a9
        L_0x057c:
            java.lang.String r3 = "H90"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 16
            goto L_0x05a9
        L_0x0587:
            java.lang.String r3 = "H63"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 15
            goto L_0x05a9
        L_0x0592:
            java.lang.String r3 = "H60"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 14
            goto L_0x05a9
        L_0x059d:
            java.lang.String r3 = "H30"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x05a8
            r12 = 13
            goto L_0x05a9
        L_0x05a8:
            r12 = r5
        L_0x05a9:
            switch(r12) {
                case 0: goto L_0x067a;
                case 1: goto L_0x0674;
                case 2: goto L_0x066c;
                case 3: goto L_0x0664;
                case 4: goto L_0x065c;
                case 5: goto L_0x0654;
                case 6: goto L_0x064c;
                case 7: goto L_0x0644;
                case 8: goto L_0x063c;
                case 9: goto L_0x0634;
                case 10: goto L_0x062c;
                case 11: goto L_0x0624;
                case 12: goto L_0x061c;
                case 13: goto L_0x0616;
                case 14: goto L_0x060f;
                case 15: goto L_0x0606;
                case 16: goto L_0x05fd;
                case 17: goto L_0x05f6;
                case 18: goto L_0x05ed;
                case 19: goto L_0x05e6;
                case 20: goto L_0x05dc;
                case 21: goto L_0x05d3;
                case 22: goto L_0x05ca;
                case 23: goto L_0x05c1;
                case 24: goto L_0x05b8;
                case 25: goto L_0x05af;
                default: goto L_0x05ac;
            }
        L_0x05ac:
            r2 = 0
            goto L_0x067e
        L_0x05af:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05b8:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05c1:
            r2 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05ca:
            r2 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05d3:
            r2 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05dc:
            r2 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x05e6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x067e
        L_0x05ed:
            r8 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x067e
        L_0x05f6:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            goto L_0x067e
        L_0x05fd:
            r9 = 128(0x80, float:1.794E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x067e
        L_0x0606:
            r14 = 32
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x067e
        L_0x060f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x067e
        L_0x0616:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x061c:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x0624:
            r2 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x062c:
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x0634:
            r2 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x063c:
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x0644:
            r2 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x064c:
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            goto L_0x067e
        L_0x0654:
            r17 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            goto L_0x067e
        L_0x065c:
            r18 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            goto L_0x067e
        L_0x0664:
            r19 = 64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r19)
            goto L_0x067e
        L_0x066c:
            r2 = 16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x067e
        L_0x0674:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x067e
        L_0x067a:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
        L_0x067e:
            if (r2 != 0) goto L_0x0690
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Unknown HEVC level string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0690:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r0, r2)
            r2 = r1
            goto L_0x084d
        L_0x069c:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "Unknown HEVC profile string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x06ac:
            r9 = r8
            r8 = 2048(0x800, float:2.87E-42)
            r14 = 32
            r16 = 4096(0x1000, float:5.74E-42)
            r18 = 256(0x100, float:3.59E-43)
            r19 = 64
            java.lang.String r3 = r0.zzk
            int r0 = r1.length
            if (r0 >= r12) goto L_0x06cc
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x06cc:
            r0 = r1[r11]     // Catch:{ NumberFormatException -> 0x0748 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0748 }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x0748 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0748 }
            switch(r0) {
                case 0: goto L_0x06e4;
                case 1: goto L_0x06e2;
                case 2: goto L_0x06e0;
                case 3: goto L_0x06de;
                default: goto L_0x06dc;
            }
        L_0x06dc:
            r3 = r5
            goto L_0x06e5
        L_0x06de:
            r3 = r13
            goto L_0x06e5
        L_0x06e0:
            r3 = r15
            goto L_0x06e5
        L_0x06e2:
            r3 = r2
            goto L_0x06e5
        L_0x06e4:
            r3 = r11
        L_0x06e5:
            if (r3 != r5) goto L_0x06fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown VP9 profile: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x06fe:
            switch(r1) {
                case 10: goto L_0x071e;
                case 11: goto L_0x071d;
                case 20: goto L_0x071b;
                case 21: goto L_0x0719;
                case 30: goto L_0x0716;
                case 31: goto L_0x0714;
                case 40: goto L_0x0711;
                case 41: goto L_0x070f;
                case 50: goto L_0x070c;
                case 51: goto L_0x070a;
                case 60: goto L_0x0708;
                case 61: goto L_0x0705;
                case 62: goto L_0x0703;
                default: goto L_0x0701;
            }
        L_0x0701:
            r2 = r5
            goto L_0x071f
        L_0x0703:
            r2 = r10
            goto L_0x071f
        L_0x0705:
            r2 = r16
            goto L_0x071f
        L_0x0708:
            r2 = r8
            goto L_0x071f
        L_0x070a:
            r2 = r6
            goto L_0x071f
        L_0x070c:
            r2 = r18
            goto L_0x071f
        L_0x070f:
            r2 = r9
            goto L_0x071f
        L_0x0711:
            r2 = r19
            goto L_0x071f
        L_0x0714:
            r2 = r14
            goto L_0x071f
        L_0x0716:
            r2 = 16
            goto L_0x071f
        L_0x0719:
            r2 = r13
            goto L_0x071f
        L_0x071b:
            r2 = r15
            goto L_0x071f
        L_0x071d:
            goto L_0x071f
        L_0x071e:
            r2 = r11
        L_0x071f:
            if (r2 != r5) goto L_0x0738
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unknown VP9 level: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0738:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r2)
            r2 = r0
            goto L_0x084d
        L_0x0748:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x0759:
            r9 = r8
            r8 = 2048(0x800, float:2.87E-42)
            r14 = 32
            r16 = 4096(0x1000, float:5.74E-42)
            r17 = 1024(0x400, float:1.435E-42)
            r18 = 256(0x100, float:3.59E-43)
            r19 = 64
            java.lang.String r6 = r0.zzk
            int r0 = r1.length
            java.lang.String r8 = "Ignoring malformed AVC codec string: "
            if (r0 >= r2) goto L_0x077b
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r0 = r8.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x077b:
            r21 = r1[r11]     // Catch:{ NumberFormatException -> 0x0840 }
            int r9 = r21.length()     // Catch:{ NumberFormatException -> 0x0840 }
            if (r9 != r7) goto L_0x079b
            r0 = r1[r11]     // Catch:{ NumberFormatException -> 0x0840 }
            java.lang.String r0 = r0.substring(r3, r2)     // Catch:{ NumberFormatException -> 0x0840 }
            r3 = 16
            int r0 = java.lang.Integer.parseInt(r0, r3)     // Catch:{ NumberFormatException -> 0x0840 }
            r1 = r1[r11]     // Catch:{ NumberFormatException -> 0x0840 }
            java.lang.String r1 = r1.substring(r15)     // Catch:{ NumberFormatException -> 0x0840 }
            int r1 = java.lang.Integer.parseInt(r1, r3)     // Catch:{ NumberFormatException -> 0x0840 }
            goto L_0x07ab
        L_0x079b:
            r3 = 16
            if (r0 < r12) goto L_0x082c
            r0 = r1[r11]     // Catch:{ NumberFormatException -> 0x0840 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0840 }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x0840 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0840 }
        L_0x07ab:
            switch(r0) {
                case 66: goto L_0x07bc;
                case 77: goto L_0x07bb;
                case 88: goto L_0x07b9;
                case 100: goto L_0x07b7;
                case 110: goto L_0x07b5;
                case 122: goto L_0x07b3;
                case 244: goto L_0x07b0;
                default: goto L_0x07ae;
            }
        L_0x07ae:
            r2 = r5
            goto L_0x07bd
        L_0x07b0:
            r2 = r19
            goto L_0x07bd
        L_0x07b3:
            r2 = r14
            goto L_0x07bd
        L_0x07b5:
            r2 = r3
            goto L_0x07bd
        L_0x07b7:
            r2 = r13
            goto L_0x07bd
        L_0x07b9:
            r2 = r15
            goto L_0x07bd
        L_0x07bb:
            goto L_0x07bd
        L_0x07bc:
            r2 = r11
        L_0x07bd:
            if (r2 != r5) goto L_0x07d6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown AVC profile: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x07d6:
            switch(r1) {
                case 10: goto L_0x0804;
                case 11: goto L_0x0802;
                case 12: goto L_0x0800;
                case 13: goto L_0x07fe;
                case 20: goto L_0x07fc;
                case 21: goto L_0x07f9;
                case 22: goto L_0x07f6;
                case 30: goto L_0x07f3;
                case 31: goto L_0x07f0;
                case 32: goto L_0x07ed;
                case 40: goto L_0x07ea;
                case 41: goto L_0x07e7;
                case 42: goto L_0x07e5;
                case 50: goto L_0x07e2;
                case 51: goto L_0x07de;
                case 52: goto L_0x07db;
                default: goto L_0x07d9;
            }
        L_0x07d9:
            r0 = r5
            goto L_0x0805
        L_0x07db:
            r0 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0805
        L_0x07de:
            r0 = 32768(0x8000, float:4.5918E-41)
            goto L_0x0805
        L_0x07e2:
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0805
        L_0x07e5:
            r0 = r10
            goto L_0x0805
        L_0x07e7:
            r0 = r16
            goto L_0x0805
        L_0x07ea:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0805
        L_0x07ed:
            r0 = r17
            goto L_0x0805
        L_0x07f0:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0805
        L_0x07f3:
            r0 = r18
            goto L_0x0805
        L_0x07f6:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x0805
        L_0x07f9:
            r0 = r19
            goto L_0x0805
        L_0x07fc:
            r0 = r14
            goto L_0x0805
        L_0x07fe:
            r0 = r3
            goto L_0x0805
        L_0x0800:
            r0 = r13
            goto L_0x0805
        L_0x0802:
            r0 = r15
            goto L_0x0805
        L_0x0804:
            r0 = r11
        L_0x0805:
            if (r0 != r5) goto L_0x081d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unknown AVC level: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
            goto L_0x084d
        L_0x081d:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r2, r0)
            r2 = r1
            goto L_0x084d
        L_0x082c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0840 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x0840 }
            r0.append(r8)     // Catch:{ NumberFormatException -> 0x0840 }
            r0.append(r6)     // Catch:{ NumberFormatException -> 0x0840 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x0840 }
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)     // Catch:{ NumberFormatException -> 0x0840 }
            r2 = 0
            goto L_0x084d
        L_0x0840:
            r0 = move-exception
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r0 = r8.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r4, r0)
            r2 = 0
        L_0x084d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.zza(com.google.android.gms.internal.ads.zzan):android.util.Pair");
    }

    public static zztp zzb() throws zzud {
        List zze = zze("audio/raw", false, false);
        if (zze.isEmpty()) {
            return null;
        }
        return (zztp) zze.get(0);
    }

    public static String zzc(zzan zzan) {
        Pair zza2;
        if ("audio/eac3-joc".equals(zzan.zzn)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzan.zzn) || (zza2 = zza(zzan)) == null) {
            return null;
        }
        int intValue = ((Integer) zza2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List zzd(zztx zztx, zzan zzan, boolean z, boolean z2) throws zzud {
        String zzc2 = zzc(zzan);
        if (zzc2 == null) {
            return zzgbc.zzm();
        }
        return zze(zzc2, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) throws zzud {
        synchronized (zzuj.class) {
            zzub zzub = new zzub(str, z, z2);
            List list = (List) zzc.get(zzub);
            if (list != null) {
                return list;
            }
            int i = zzgd.zza;
            ArrayList zzh = zzh(zzub, new zzuh(z, z2));
            if (z && zzh.isEmpty() && zzgd.zza <= 23) {
                zzh = zzh(zzub, new zzug((zzuf) null));
                if (!zzh.isEmpty()) {
                    String str2 = ((zztp) zzh.get(0)).zza;
                    zzfk.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + str2);
                }
            }
            if ("audio/raw".equals(str)) {
                if (zzgd.zza < 26 && zzgd.zzb.equals("R9") && zzh.size() == 1 && ((zztp) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zztp.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzi(zzh, new zztz());
            }
            if (zzgd.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zztp) zzh.get(0)).zza)) {
                zzh.add((zztp) zzh.remove(0));
            }
            zzgbc zzk = zzgbc.zzk(zzh);
            zzc.put(zzub, zzk);
            return zzk;
        }
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzf(zztx zztx, zzan zzan, boolean z, boolean z2) throws zzud {
        List zze = zze(zzan.zzn, z, z2);
        List zzd = zzd(zztx, zzan, z, z2);
        zzgaz zzgaz = new zzgaz();
        zzgaz.zzh(zze);
        zzgaz.zzh(zzd);
        return zzgaz.zzi();
    }

    public static List zzg(List list, zzan zzan) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zzua(zzan));
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v45 */
    /* JADX WARNING: type inference failed for: r2v48 */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0221, code lost:
        if (r2 != r8) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0227, code lost:
        if (r1.zzb == false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0229, code lost:
        r22 = r12;
        r18 = r13;
        r20 = r14;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r6.add(com.google.android.gms.internal.ads.zztp.zzc(r12, r15, r5, r10, r11, r21, r0, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0245, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x029c A[SYNTHETIC, Splitter:B:162:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02bc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzub r23, com.google.android.gms.internal.ads.zzue r24) throws com.google.android.gms.internal.ads.zzud {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x02f5 }
            r6.<init>()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x02f5 }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x02f5 }
            boolean r16 = r24.zze()     // Catch:{ Exception -> 0x02f5 }
            r17 = 0
            r13 = r17
        L_0x001b:
            if (r13 >= r14) goto L_0x02f4
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x02f5 }
            int r7 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x02f5 }
            r8 = 29
            if (r7 < r8) goto L_0x0034
            boolean r7 = r0.isAlias()     // Catch:{ Exception -> 0x02f5 }
            if (r7 == 0) goto L_0x0034
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x0034:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x02f5 }
            boolean r7 = r0.isEncoder()     // Catch:{ Exception -> 0x02f5 }
            if (r7 != 0) goto L_0x02e4
            java.lang.String r7 = ".secure"
            if (r16 != 0) goto L_0x0050
            boolean r9 = r12.endsWith(r7)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x0049
            goto L_0x0050
        L_0x0049:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x0050:
            int r9 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x02f5 }
            r10 = 24
            if (r9 >= r10) goto L_0x00f9
            java.lang.String r9 = "OMX.SEC.aac.dec"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x0066
            java.lang.String r9 = "OMX.Exynos.AAC.Decoder"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r9 == 0) goto L_0x00f9
        L_0x0066:
            java.lang.String r9 = "samsung"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzc     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 == 0) goto L_0x00f9
            java.lang.String r9 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r10 = "zeroflte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00f2
            java.lang.String r9 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r10 = "zerolte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00eb
            java.lang.String r9 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r10 = "zenlte"
            boolean r9 = r9.startsWith(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00e4
            java.lang.String r9 = "SC-05G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00dd
            java.lang.String r9 = "marinelteatt"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00d6
            java.lang.String r9 = "404SC"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00cf
            java.lang.String r9 = "SC-04G"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00c8
            java.lang.String r9 = "SCV31"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ Exception -> 0x02f5 }
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x00c1
            goto L_0x00f9
        L_0x00c1:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00c8:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00cf:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00d6:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00dd:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00e4:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00eb:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00f2:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x00f9:
            int r9 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x02f5 }
            r11 = 23
            if (r9 > r11) goto L_0x0117
            java.lang.String r9 = "audio/eac3-joc"
            boolean r9 = r9.equals(r15)     // Catch:{ Exception -> 0x02f5 }
            if (r9 == 0) goto L_0x0117
            java.lang.String r9 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r9 = r9.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r9 != 0) goto L_0x0110
            goto L_0x0117
        L_0x0110:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x0117:
            java.lang.String[] r9 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x02f5 }
            int r10 = r9.length     // Catch:{ Exception -> 0x02f5 }
            r11 = r17
        L_0x011e:
            if (r11 >= r10) goto L_0x012d
            r5 = r9[r11]     // Catch:{ Exception -> 0x02f5 }
            boolean r19 = r5.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x02f5 }
            if (r19 == 0) goto L_0x012a
            goto L_0x0190
        L_0x012a:
            int r11 = r11 + 1
            goto L_0x011e
        L_0x012d:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x0156
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x0140
            java.lang.String r5 = "video/hevcdv"
            goto L_0x0190
        L_0x0140:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 != 0) goto L_0x0153
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x0151
            goto L_0x0153
        L_0x0151:
            r5 = 0
            goto L_0x0190
        L_0x0153:
            java.lang.String r5 = "video/dv_hevc"
            goto L_0x0190
        L_0x0156:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x0169
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x0169
            java.lang.String r5 = "audio/x-lg-alac"
            goto L_0x0190
        L_0x0169:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x017c
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x017c
            java.lang.String r5 = "audio/x-lg-flac"
            goto L_0x0190
        L_0x017c:
            java.lang.String r5 = "audio/ac3"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x018f
            java.lang.String r5 = "OMX.lge.ac3.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x02f5 }
            if (r5 == 0) goto L_0x018f
            java.lang.String r5 = "audio/lg-ac3"
            goto L_0x0190
        L_0x018f:
            r5 = 0
        L_0x0190:
            if (r5 == 0) goto L_0x02de
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x028d }
            boolean r9 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x028d }
            boolean r11 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x028d }
            boolean r8 = r1.zzc     // Catch:{ Exception -> 0x028d }
            if (r8 != 0) goto L_0x01ac
            if (r11 != 0) goto L_0x01a5
            goto L_0x01b5
        L_0x01a5:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x01ac:
            if (r9 != 0) goto L_0x01b5
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x01b5:
            boolean r8 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x028d }
            boolean r9 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x028d }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x028d }
            r20 = 1
            if (r11 != 0) goto L_0x01ce
            if (r9 != 0) goto L_0x01c7
            goto L_0x01d2
        L_0x01c7:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x01ce:
            if (r8 == 0) goto L_0x0287
            r8 = r20
        L_0x01d2:
            int r9 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x028d }
            r11 = 29
            if (r9 < r11) goto L_0x01de
            boolean r9 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x028d }
            r11 = r9
            goto L_0x01e9
        L_0x01de:
            boolean r9 = zzj(r0, r15)     // Catch:{ Exception -> 0x028d }
            if (r9 != 0) goto L_0x01e7
            r11 = r20
            goto L_0x01e9
        L_0x01e7:
            r11 = r17
        L_0x01e9:
            boolean r21 = zzj(r0, r15)     // Catch:{ Exception -> 0x028d }
            int r9 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x028d }
            r2 = 29
            if (r9 < r2) goto L_0x01f8
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x028d }
            goto L_0x021d
        L_0x01f8:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x028d }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfxm.zza(r0)     // Catch:{ Exception -> 0x028d }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x028d }
            if (r2 != 0) goto L_0x021b
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x028d }
            if (r2 != 0) goto L_0x021b
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x028d }
            if (r0 != 0) goto L_0x021b
            r0 = r20
            goto L_0x021d
        L_0x021b:
            r0 = r17
        L_0x021d:
            if (r16 == 0) goto L_0x0223
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x028d }
            if (r2 == r8) goto L_0x0229
        L_0x0223:
            if (r16 != 0) goto L_0x0252
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0247 }
            if (r2 != 0) goto L_0x0252
        L_0x0229:
            r2 = 0
            r19 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r22 = r12
            r12 = r21
            r18 = r13
            r13 = r0
            r20 = r14
            r14 = r2
            r2 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zztp r0 = com.google.android.gms.internal.ads.zztp.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0245 }
            r6.add(r0)     // Catch:{ Exception -> 0x0245 }
            goto L_0x02e9
        L_0x0245:
            r0 = move-exception
            goto L_0x024f
        L_0x0247:
            r0 = move-exception
            r22 = r12
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x024f:
            r1 = r22
            goto L_0x0294
        L_0x0252:
            r22 = r12
            r18 = r13
            r20 = r14
            r2 = r15
            if (r16 != 0) goto L_0x02e9
            if (r8 == 0) goto L_0x02e9
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0245 }
            r8.<init>()     // Catch:{ Exception -> 0x0245 }
            r15 = r22
            r8.append(r15)     // Catch:{ Exception -> 0x0284 }
            r8.append(r7)     // Catch:{ Exception -> 0x0284 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0284 }
            r14 = 0
            r19 = 1
            r8 = r2
            r9 = r5
            r12 = r21
            r13 = r0
            r1 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zztp r0 = com.google.android.gms.internal.ads.zztp.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0282 }
            r6.add(r0)     // Catch:{ Exception -> 0x0282 }
            goto L_0x02f4
        L_0x0282:
            r0 = move-exception
            goto L_0x0294
        L_0x0284:
            r0 = move-exception
            r1 = r15
            goto L_0x0294
        L_0x0287:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x028d:
            r0 = move-exception
            r1 = r12
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x0294:
            int r7 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r8 = "MediaCodecUtil"
            r9 = 23
            if (r7 > r9) goto L_0x02bc
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x02f5 }
            if (r7 != 0) goto L_0x02bc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f5 }
            r0.<init>()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r5 = "Skipping codec "
            r0.append(r5)     // Catch:{ Exception -> 0x02f5 }
            r0.append(r1)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f5 }
            com.google.android.gms.internal.ads.zzfk.zzc(r8, r0)     // Catch:{ Exception -> 0x02f5 }
            goto L_0x02e9
        L_0x02bc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02f5 }
            r2.<init>()     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x02f5 }
            r2.append(r1)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x02f5 }
            r2.append(r5)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x02f5 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x02f5 }
            com.google.android.gms.internal.ads.zzfk.zzc(r8, r1)     // Catch:{ Exception -> 0x02f5 }
            throw r0     // Catch:{ Exception -> 0x02f5 }
        L_0x02de:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x02e9
        L_0x02e4:
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x02e9:
            int r13 = r18 + 1
            r1 = r23
            r15 = r2
            r14 = r20
            r2 = r24
            goto L_0x001b
        L_0x02f4:
            return r6
        L_0x02f5:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzud r1 = new com.google.android.gms.internal.ads.zzud
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuj.zzh(com.google.android.gms.internal.ads.zzub, com.google.android.gms.internal.ads.zzue):java.util.ArrayList");
    }

    private static void zzi(List list, zzui zzui) {
        Collections.sort(list, new zzty(zzui));
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzgd.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcg.zzg(str)) {
            return true;
        }
        String zza2 = zzfxm.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        if (zza2.startsWith("omx.")) {
            return false;
        }
        if (!zza2.startsWith("c2.")) {
            return true;
        }
        return false;
    }
}
