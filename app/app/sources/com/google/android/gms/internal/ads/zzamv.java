package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzamv implements zzalv {
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzamt zzh = new zzamt(30.0f, 1, 1);
    private final XmlPullParserFactory zzi;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        if (r14.equals("t") != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f4, code lost:
        r10 = r10 / r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ff, code lost:
        r10 = r10 * r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0102, code lost:
        return (long) (r10 * 1000000.0d);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.lang.String r14, com.google.android.gms.internal.ads.zzamt r15) throws com.google.android.gms.internal.ads.zzalr {
        /*
            java.util.regex.Pattern r0 = zzc
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0082
            java.lang.String r14 = r0.group(r8)
            if (r14 == 0) goto L_0x0080
            long r10 = java.lang.Long.parseLong(r14)
            r12 = 3600(0xe10, double:1.7786E-320)
            long r10 = r10 * r12
            java.lang.String r14 = r0.group(r7)
            if (r14 == 0) goto L_0x007e
            double r7 = (double) r10
            long r10 = java.lang.Long.parseLong(r14)
            r12 = 60
            long r10 = r10 * r12
            java.lang.String r14 = r0.group(r6)
            if (r14 == 0) goto L_0x007c
            double r9 = (double) r10
            double r7 = r7 + r9
            long r9 = java.lang.Long.parseLong(r14)
            double r9 = (double) r9
            java.lang.String r14 = r0.group(r5)
            r5 = 0
            if (r14 == 0) goto L_0x004c
            double r11 = java.lang.Double.parseDouble(r14)
            goto L_0x004d
        L_0x004c:
            r11 = r5
        L_0x004d:
            double r7 = r7 + r9
            java.lang.String r14 = r0.group(r4)
            if (r14 == 0) goto L_0x005e
            long r9 = java.lang.Long.parseLong(r14)
            float r14 = (float) r9
            float r1 = r15.zza
            float r14 = r14 / r1
            double r9 = (double) r14
            goto L_0x005f
        L_0x005e:
            r9 = r5
        L_0x005f:
            double r7 = r7 + r11
            r14 = 6
            java.lang.String r14 = r0.group(r14)
            if (r14 == 0) goto L_0x0076
            long r0 = java.lang.Long.parseLong(r14)
            double r0 = (double) r0
            int r14 = r15.zzb
            double r4 = (double) r14
            float r14 = r15.zza
            double r14 = (double) r14
            double r0 = r0 / r4
            double r5 = r0 / r14
            goto L_0x0077
        L_0x0076:
        L_0x0077:
            double r7 = r7 + r9
            double r7 = r7 + r5
            double r7 = r7 * r2
            long r14 = (long) r7
            return r14
        L_0x007c:
            throw r9
        L_0x007e:
            throw r9
        L_0x0080:
            throw r9
        L_0x0082:
            java.util.regex.Pattern r0 = zzd
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0107
            java.lang.String r14 = r0.group(r8)
            if (r14 == 0) goto L_0x0105
            double r10 = java.lang.Double.parseDouble(r14)
            java.lang.String r14 = r0.group(r7)
            if (r14 == 0) goto L_0x0103
            int r0 = r14.hashCode()
            switch(r0) {
                case 102: goto L_0x00d7;
                case 104: goto L_0x00cd;
                case 109: goto L_0x00c3;
                case 115: goto L_0x00b9;
                case 116: goto L_0x00b0;
                case 3494: goto L_0x00a6;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            goto L_0x00e1
        L_0x00a6:
            java.lang.String r0 = "ms"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            r4 = r6
            goto L_0x00e2
        L_0x00b0:
            java.lang.String r0 = "t"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00b9:
            java.lang.String r0 = "s"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            r4 = r7
            goto L_0x00e2
        L_0x00c3:
            java.lang.String r0 = "m"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            r4 = r8
            goto L_0x00e2
        L_0x00cd:
            java.lang.String r0 = "h"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            r4 = 0
            goto L_0x00e2
        L_0x00d7:
            java.lang.String r0 = "f"
            boolean r14 = r14.equals(r0)
            if (r14 == 0) goto L_0x00e1
            r4 = r5
            goto L_0x00e2
        L_0x00e1:
            r4 = -1
        L_0x00e2:
            switch(r4) {
                case 0: goto L_0x00fa;
                case 1: goto L_0x00f7;
                case 2: goto L_0x00f6;
                case 3: goto L_0x00ef;
                case 4: goto L_0x00ea;
                case 5: goto L_0x00e6;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            goto L_0x0100
        L_0x00e6:
            int r14 = r15.zzc
            double r14 = (double) r14
            goto L_0x00f4
        L_0x00ea:
            float r14 = r15.zza
            double r14 = (double) r14
            double r10 = r10 / r14
            goto L_0x0100
        L_0x00ef:
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00f4:
            double r10 = r10 / r14
            goto L_0x0100
        L_0x00f6:
            goto L_0x0100
        L_0x00f7:
            r14 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x00ff
        L_0x00fa:
            r14 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x00ff:
            double r10 = r10 * r14
        L_0x0100:
            double r10 = r10 * r2
            long r14 = (long) r10
            return r14
        L_0x0103:
            throw r9
        L_0x0105:
            throw r9
        L_0x0107:
            java.lang.String r14 = java.lang.String.valueOf(r14)
            com.google.android.gms.internal.ads.zzalr r15 = new com.google.android.gms.internal.ads.zzalr
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r14 = r0.concat(r14)
            r15.<init>(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zzc(java.lang.String, com.google.android.gms.internal.ads.zzamt):long");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.text.Layout.Alignment zzd(java.lang.String r1) {
        /*
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfxm.zza(r1)
            int r0 = r1.hashCode()
            switch(r0) {
                case -1364013995: goto L_0x0034;
                case 100571: goto L_0x002a;
                case 3317767: goto L_0x0020;
                case 108511772: goto L_0x0016;
                case 109757538: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "start"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000b
            r1 = 1
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "right"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000b
            r1 = 2
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "left"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000b
            r1 = 0
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "end"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000b
            r1 = 3
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "center"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x000b
            r1 = 4
            goto L_0x003f
        L_0x003e:
            r1 = -1
        L_0x003f:
            switch(r1) {
                case 0: goto L_0x004a;
                case 1: goto L_0x004a;
                case 2: goto L_0x0047;
                case 3: goto L_0x0047;
                case 4: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            r1 = 0
            return r1
        L_0x0044:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
            return r1
        L_0x0047:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r1
        L_0x004a:
            android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zzd(java.lang.String):android.text.Layout$Alignment");
    }

    private static zzamy zze(zzamy zzamy) {
        return zzamy == null ? new zzamy() : zzamy;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ed, code lost:
        if (r3.equals("delimiter") != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0158, code lost:
        if (r3.equals("nounderline") != false) goto L_0x015c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzamy zzf(org.xmlpull.v1.XmlPullParser r14, com.google.android.gms.internal.ads.zzamy r15) {
        /*
            int r0 = r14.getAttributeCount()
            r1 = 0
            r2 = r1
        L_0x0006:
            if (r2 >= r0) goto L_0x03d2
            java.lang.String r3 = r14.getAttributeValue(r2)
            java.lang.String r4 = r14.getAttributeName(r2)
            int r5 = r4.hashCode()
            r6 = 5
            r7 = 4
            r8 = 3
            r9 = -1
            r10 = 2
            r11 = 1
            switch(r5) {
                case -1550943582: goto L_0x00b9;
                case -1224696685: goto L_0x00af;
                case -1065511464: goto L_0x00a5;
                case -879295043: goto L_0x009a;
                case -734428249: goto L_0x0090;
                case 3355: goto L_0x0086;
                case 3511770: goto L_0x007b;
                case 94842723: goto L_0x0071;
                case 109403361: goto L_0x0066;
                case 110138194: goto L_0x005a;
                case 365601008: goto L_0x004f;
                case 921125321: goto L_0x0043;
                case 1115953443: goto L_0x0037;
                case 1287124693: goto L_0x002c;
                case 1754920356: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00c3
        L_0x001f:
            java.lang.String r5 = "multiRowAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 8
            goto L_0x00c4
        L_0x002c:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r11
            goto L_0x00c4
        L_0x0037:
            java.lang.String r5 = "rubyPosition"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 11
            goto L_0x00c4
        L_0x0043:
            java.lang.String r5 = "textEmphasis"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 13
            goto L_0x00c4
        L_0x004f:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r7
            goto L_0x00c4
        L_0x005a:
            java.lang.String r5 = "textCombine"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 9
            goto L_0x00c4
        L_0x0066:
            java.lang.String r5 = "shear"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 14
            goto L_0x00c4
        L_0x0071:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r10
            goto L_0x00c4
        L_0x007b:
            java.lang.String r5 = "ruby"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 10
            goto L_0x00c4
        L_0x0086:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r1
            goto L_0x00c4
        L_0x0090:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r6
            goto L_0x00c4
        L_0x009a:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 12
            goto L_0x00c4
        L_0x00a5:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 7
            goto L_0x00c4
        L_0x00af:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = r8
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x001d
            r4 = 6
            goto L_0x00c4
        L_0x00c3:
            r4 = r9
        L_0x00c4:
            r5 = 0
            java.lang.String r12 = "TtmlParser"
            switch(r4) {
                case 0: goto L_0x03bb;
                case 1: goto L_0x03a0;
                case 2: goto L_0x0385;
                case 3: goto L_0x037d;
                case 4: goto L_0x029d;
                case 5: goto L_0x028e;
                case 6: goto L_0x027f;
                case 7: goto L_0x0272;
                case 8: goto L_0x0265;
                case 9: goto L_0x022e;
                case 10: goto L_0x01bc;
                case 11: goto L_0x0185;
                case 12: goto L_0x0127;
                case 13: goto L_0x011a;
                case 14: goto L_0x00cc;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x03ce
        L_0x00cc:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            java.util.regex.Pattern r4 = zza
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r6 = r4.matches()
            r7 = 2139095039(0x7f7fffff, float:3.4028235E38)
            if (r6 != 0) goto L_0x00ed
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Invalid value for shear: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r3)
            goto L_0x0115
        L_0x00ed:
            java.lang.String r4 = r4.group(r11)     // Catch:{ NumberFormatException -> 0x0107 }
            if (r4 == 0) goto L_0x0105
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x0107 }
            r5 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r4 = java.lang.Math.max(r5, r4)     // Catch:{ NumberFormatException -> 0x0107 }
            r5 = 1120403456(0x42c80000, float:100.0)
            float r7 = java.lang.Math.min(r5, r4)     // Catch:{ NumberFormatException -> 0x0107 }
            goto L_0x0115
        L_0x0105:
            throw r5     // Catch:{ NumberFormatException -> 0x0107 }
        L_0x0107:
            r4 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "Failed to parse shear: "
            java.lang.String r3 = r5.concat(r3)
            com.google.android.gms.internal.ads.zzfk.zzg(r12, r3, r4)
        L_0x0115:
            r15.zzy(r7)
            goto L_0x03ce
        L_0x011a:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            com.google.android.gms.internal.ads.zzamr r3 = com.google.android.gms.internal.ads.zzamr.zza(r3)
            r15.zzB(r3)
            goto L_0x03ce
        L_0x0127:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfxm.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x0152;
                case -1026963764: goto L_0x0148;
                case 913457136: goto L_0x013e;
                case 1679736913: goto L_0x0133;
                default: goto L_0x0132;
            }
        L_0x0132:
            goto L_0x015b
        L_0x0133:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0132
            r8 = r1
            goto L_0x015c
        L_0x013e:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0132
            r8 = r11
            goto L_0x015c
        L_0x0148:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0132
            r8 = r10
            goto L_0x015c
        L_0x0152:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0132
            goto L_0x015c
        L_0x015b:
            r8 = r9
        L_0x015c:
            switch(r8) {
                case 0: goto L_0x017c;
                case 1: goto L_0x0173;
                case 2: goto L_0x016a;
                case 3: goto L_0x0161;
                default: goto L_0x015f;
            }
        L_0x015f:
            goto L_0x03ce
        L_0x0161:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzC(r1)
            goto L_0x03ce
        L_0x016a:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzC(r11)
            goto L_0x03ce
        L_0x0173:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzu(r1)
            goto L_0x03ce
        L_0x017c:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzu(r11)
            goto L_0x03ce
        L_0x0185:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfxm.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1392885889: goto L_0x019c;
                case 92734940: goto L_0x0191;
                default: goto L_0x0190;
            }
        L_0x0190:
            goto L_0x01a5
        L_0x0191:
            java.lang.String r4 = "after"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0190
            r9 = r11
            goto L_0x01a5
        L_0x019c:
            java.lang.String r4 = "before"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0190
            r9 = r1
        L_0x01a5:
            switch(r9) {
                case 0: goto L_0x01b3;
                case 1: goto L_0x01aa;
                default: goto L_0x01a8;
            }
        L_0x01a8:
            goto L_0x03ce
        L_0x01aa:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzw(r10)
            goto L_0x03ce
        L_0x01b3:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzw(r11)
            goto L_0x03ce
        L_0x01bc:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfxm.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -618561360: goto L_0x01fa;
                case -410956671: goto L_0x01f0;
                case -250518009: goto L_0x01e7;
                case -136074796: goto L_0x01dd;
                case 3016401: goto L_0x01d3;
                case 3556653: goto L_0x01c8;
                default: goto L_0x01c7;
            }
        L_0x01c7:
            goto L_0x0204
        L_0x01c8:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            r6 = r8
            goto L_0x0205
        L_0x01d3:
            java.lang.String r4 = "base"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            r6 = r11
            goto L_0x0205
        L_0x01dd:
            java.lang.String r4 = "textContainer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            r6 = r7
            goto L_0x0205
        L_0x01e7:
            java.lang.String r4 = "delimiter"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            goto L_0x0205
        L_0x01f0:
            java.lang.String r4 = "container"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            r6 = r1
            goto L_0x0205
        L_0x01fa:
            java.lang.String r4 = "baseContainer"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c7
            r6 = r10
            goto L_0x0205
        L_0x0204:
            r6 = r9
        L_0x0205:
            switch(r6) {
                case 0: goto L_0x0225;
                case 1: goto L_0x021c;
                case 2: goto L_0x021c;
                case 3: goto L_0x0213;
                case 4: goto L_0x0213;
                case 5: goto L_0x020a;
                default: goto L_0x0208;
            }
        L_0x0208:
            goto L_0x03ce
        L_0x020a:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzx(r7)
            goto L_0x03ce
        L_0x0213:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzx(r8)
            goto L_0x03ce
        L_0x021c:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzx(r10)
            goto L_0x03ce
        L_0x0225:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzx(r11)
            goto L_0x03ce
        L_0x022e:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfxm.zza(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case 96673: goto L_0x0245;
                case 3387192: goto L_0x023a;
                default: goto L_0x0239;
            }
        L_0x0239:
            goto L_0x024e
        L_0x023a:
            java.lang.String r4 = "none"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0239
            r9 = r1
            goto L_0x024e
        L_0x0245:
            java.lang.String r4 = "all"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0239
            r9 = r11
        L_0x024e:
            switch(r9) {
                case 0: goto L_0x025c;
                case 1: goto L_0x0253;
                default: goto L_0x0251;
            }
        L_0x0251:
            goto L_0x03ce
        L_0x0253:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzA(r11)
            goto L_0x03ce
        L_0x025c:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzA(r1)
            goto L_0x03ce
        L_0x0265:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            android.text.Layout$Alignment r3 = zzd(r3)
            r15.zzv(r3)
            goto L_0x03ce
        L_0x0272:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            android.text.Layout$Alignment r3 = zzd(r3)
            r15.zzz(r3)
            goto L_0x03ce
        L_0x027f:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            r15.zzt(r3)
            goto L_0x03ce
        L_0x028e:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            r15.zzn(r3)
            goto L_0x03ce
        L_0x029d:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)     // Catch:{ zzalr -> 0x036e }
            java.lang.String r4 = "\\s+"
            int r6 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ zzalr -> 0x036c }
            java.lang.String[] r4 = r3.split(r4, r9)     // Catch:{ zzalr -> 0x036c }
            int r6 = r4.length     // Catch:{ zzalr -> 0x036c }
            if (r6 != r11) goto L_0x02b3
            java.util.regex.Pattern r4 = zze     // Catch:{ zzalr -> 0x036c }
            java.util.regex.Matcher r4 = r4.matcher(r3)     // Catch:{ zzalr -> 0x036c }
            goto L_0x02c2
        L_0x02b3:
            if (r6 != r10) goto L_0x0350
            java.util.regex.Pattern r6 = zze     // Catch:{ zzalr -> 0x036c }
            r4 = r4[r11]     // Catch:{ zzalr -> 0x036c }
            java.util.regex.Matcher r4 = r6.matcher(r4)     // Catch:{ zzalr -> 0x036c }
            java.lang.String r6 = "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first."
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r6)     // Catch:{ zzalr -> 0x036c }
        L_0x02c2:
            boolean r6 = r4.matches()     // Catch:{ zzalr -> 0x036c }
            java.lang.String r7 = "'."
            if (r6 == 0) goto L_0x0336
            java.lang.String r6 = r4.group(r8)     // Catch:{ zzalr -> 0x036c }
            if (r6 == 0) goto L_0x0334
            int r13 = r6.hashCode()     // Catch:{ zzalr -> 0x036c }
            switch(r13) {
                case 37: goto L_0x02ec;
                case 3240: goto L_0x02e2;
                case 3592: goto L_0x02d8;
                default: goto L_0x02d7;
            }
        L_0x02d7:
            goto L_0x02f6
        L_0x02d8:
            java.lang.String r13 = "px"
            boolean r13 = r6.equals(r13)
            if (r13 == 0) goto L_0x02f6
            r9 = r1
            goto L_0x02f7
        L_0x02e2:
            java.lang.String r13 = "em"
            boolean r13 = r6.equals(r13)
            if (r13 == 0) goto L_0x02f6
            r9 = r11
            goto L_0x02f7
        L_0x02ec:
            java.lang.String r13 = "%"
            boolean r13 = r6.equals(r13)
            if (r13 == 0) goto L_0x02f6
            r9 = r10
            goto L_0x02f7
        L_0x02f6:
        L_0x02f7:
            switch(r9) {
                case 0: goto L_0x0307;
                case 1: goto L_0x0302;
                case 2: goto L_0x02fd;
                default: goto L_0x02fa;
            }
        L_0x02fa:
            com.google.android.gms.internal.ads.zzalr r4 = new com.google.android.gms.internal.ads.zzalr     // Catch:{ zzalr -> 0x036c }
            goto L_0x031c
        L_0x02fd:
            r15.zzr(r8)     // Catch:{ zzalr -> 0x036c }
            goto L_0x030a
        L_0x0302:
            r15.zzr(r10)     // Catch:{ zzalr -> 0x036c }
            goto L_0x030a
        L_0x0307:
            r15.zzr(r11)     // Catch:{ zzalr -> 0x036c }
        L_0x030a:
            java.lang.String r4 = r4.group(r11)     // Catch:{ zzalr -> 0x036c }
            if (r4 == 0) goto L_0x031a
            float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ zzalr -> 0x036c }
            r15.zzq(r4)     // Catch:{ zzalr -> 0x036c }
            goto L_0x03ce
        L_0x031a:
            throw r5     // Catch:{ zzalr -> 0x036c }
        L_0x031c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzalr -> 0x036c }
            r5.<init>()     // Catch:{ zzalr -> 0x036c }
            java.lang.String r8 = "Invalid unit for fontSize: '"
            r5.append(r8)     // Catch:{ zzalr -> 0x036c }
            r5.append(r6)     // Catch:{ zzalr -> 0x036c }
            r5.append(r7)     // Catch:{ zzalr -> 0x036c }
            java.lang.String r5 = r5.toString()     // Catch:{ zzalr -> 0x036c }
            r4.<init>(r5)     // Catch:{ zzalr -> 0x036c }
            throw r4     // Catch:{ zzalr -> 0x036c }
        L_0x0334:
            throw r5     // Catch:{ zzalr -> 0x036c }
        L_0x0336:
            com.google.android.gms.internal.ads.zzalr r4 = new com.google.android.gms.internal.ads.zzalr     // Catch:{ zzalr -> 0x036c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzalr -> 0x036c }
            r5.<init>()     // Catch:{ zzalr -> 0x036c }
            java.lang.String r6 = "Invalid expression for fontSize: '"
            r5.append(r6)     // Catch:{ zzalr -> 0x036c }
            r5.append(r3)     // Catch:{ zzalr -> 0x036c }
            r5.append(r7)     // Catch:{ zzalr -> 0x036c }
            java.lang.String r5 = r5.toString()     // Catch:{ zzalr -> 0x036c }
            r4.<init>(r5)     // Catch:{ zzalr -> 0x036c }
            throw r4     // Catch:{ zzalr -> 0x036c }
        L_0x0350:
            com.google.android.gms.internal.ads.zzalr r4 = new com.google.android.gms.internal.ads.zzalr     // Catch:{ zzalr -> 0x036c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ zzalr -> 0x036c }
            r5.<init>()     // Catch:{ zzalr -> 0x036c }
            java.lang.String r7 = "Invalid number of entries for fontSize: "
            r5.append(r7)     // Catch:{ zzalr -> 0x036c }
            r5.append(r6)     // Catch:{ zzalr -> 0x036c }
            java.lang.String r6 = "."
            r5.append(r6)     // Catch:{ zzalr -> 0x036c }
            java.lang.String r5 = r5.toString()     // Catch:{ zzalr -> 0x036c }
            r4.<init>(r5)     // Catch:{ zzalr -> 0x036c }
            throw r4     // Catch:{ zzalr -> 0x036c }
        L_0x036c:
            r4 = move-exception
            goto L_0x036f
        L_0x036e:
            r4 = move-exception
        L_0x036f:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing fontSize value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r3)
            goto L_0x03ce
        L_0x037d:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzp(r3)
            goto L_0x03ce
        L_0x0385:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            int r4 = com.google.android.gms.internal.ads.zzet.zzb(r3)     // Catch:{ IllegalArgumentException -> 0x0391 }
            r15.zzo(r4)     // Catch:{ IllegalArgumentException -> 0x0391 }
            goto L_0x03ce
        L_0x0391:
            r4 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing color value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r3)
            goto L_0x03ce
        L_0x03a0:
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            int r4 = com.google.android.gms.internal.ads.zzet.zzb(r3)     // Catch:{ IllegalArgumentException -> 0x03ac }
            r15.zzm(r4)     // Catch:{ IllegalArgumentException -> 0x03ac }
            goto L_0x03ce
        L_0x03ac:
            r4 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Failed parsing background value: "
            java.lang.String r3 = r4.concat(r3)
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r3)
            goto L_0x03ce
        L_0x03bb:
            java.lang.String r4 = r14.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x03ce
            com.google.android.gms.internal.ads.zzamy r15 = zze(r15)
            r15.zzs(r3)
        L_0x03ce:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x03d2:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zzf(org.xmlpull.v1.XmlPullParser, com.google.android.gms.internal.ads.zzamy):com.google.android.gms.internal.ads.zzamy");
    }

    private static String[] zzg(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return new String[0];
        }
        int i = zzgd.zza;
        return trim.split("\\s+", -1);
    }

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        zzalp.zza(zzb(bArr, i, i2), zzalu, zzev);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v145, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v36, resolved type: int} */
    /* JADX WARNING: type inference failed for: r15v17, types: [int] */
    /* JADX WARNING: type inference failed for: r15v31 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x05b8, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x05b9, code lost:
        switch(r1) {
            case 0: goto L_0x0605;
            case 1: goto L_0x05fd;
            case 2: goto L_0x05f5;
            case 3: goto L_0x05e3;
            case 4: goto L_0x05d7;
            case 5: goto L_0x05c0;
            default: goto L_0x05bc;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x05bc, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x05c0, code lost:
        r1 = "#";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x05c2, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x05c6, code lost:
        if (r2.startsWith(r1) == false) goto L_0x05d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x05c8, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:?, code lost:
        r35 = r2.substring(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x05cf, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x05d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x05d5, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x05dc, code lost:
        if (r6.containsKey(r2) == false) goto L_0x05e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x05de, code lost:
        r34 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x05e0, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x05e3, code lost:
        r2 = zzg(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x05e9, code lost:
        if (r2.length <= 0) goto L_0x05ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x05eb, code lost:
        r33 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x05ed, code lost:
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x05f0, code lost:
        r0 = e;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x05f1, code lost:
        r2 = r0;
        r11 = r16;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x05f5, code lost:
        r1 = 1;
        r11 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        r29 = zzc(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x05fd, code lost:
        r11 = r16;
        r13 = zzc(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x0605, code lost:
        r11 = r16;
        r27 = zzc(r2, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x060c, code lost:
        r9 = r9 + 1;
        r16 = r11;
        r1 = r17;
        r17 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x064c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x066b, code lost:
        if (r13 != -9223372036854775807L) goto L_0x0671;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f6 A[SYNTHETIC, Splitter:B:102:0x01f6] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0288 A[Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }, LOOP:1: B:135:0x0288->B:302:0x051f, LOOP_START, PHI: r2 r9 r11 
      PHI: (r2v21 java.lang.String) = (r2v8 java.lang.String), (r2v22 java.lang.String) binds: [B:134:0x0286, B:302:0x051f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v10 java.lang.String) = (r9v6 java.lang.String), (r9v11 java.lang.String) binds: [B:134:0x0286, B:302:0x051f] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v30 com.google.android.gms.internal.ads.zzamt) = (r11v6 com.google.android.gms.internal.ads.zzamt), (r11v31 com.google.android.gms.internal.ads.zzamt) binds: [B:134:0x0286, B:302:0x051f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x050d A[Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x051f A[LOOP:1: B:135:0x0288->B:302:0x051f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0686 A[Catch:{ zzalr -> 0x068f }] */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x051b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x018d A[Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018f A[Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzalq zzb(byte[] r40, int r41, int r42) {
        /*
            r39 = this;
            java.lang.String r1 = ""
            java.lang.String r2 = "http://www.w3.org/ns/ttml#parameter"
            r3 = r39
            org.xmlpull.v1.XmlPullParserFactory r4 = r3.zzi     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            org.xmlpull.v1.XmlPullParser r4 = r4.newPullParser()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r5.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r7.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzamw r15 = new com.google.android.gms.internal.ads.zzamw     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r9 = ""
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r18 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r15
            r10 = r17
            r11 = r17
            r12 = r18
            r13 = r18
            r14 = r17
            r19 = r15
            r15 = r17
            r16 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r8 = r19
            r6.put(r1, r8)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.io.ByteArrayInputStream r8 = new java.io.ByteArrayInputStream     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r9 = r40
            r10 = r41
            r11 = r42
            r8.<init>(r9, r10, r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r9 = 0
            r4.setInput(r8, r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.ArrayDeque r8 = new java.util.ArrayDeque     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r8.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r10 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzamt r11 = zzh     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r14 = r9
            r16 = r14
            r15 = 0
            r17 = 15
        L_0x005d:
            r12 = 1
            if (r10 == r12) goto L_0x0714
            java.lang.Object r18 = r8.peek()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r9 = r18
            com.google.android.gms.internal.ads.zzams r9 = (com.google.android.gms.internal.ads.zzams) r9     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r12 = 2
            if (r15 != 0) goto L_0x06ea
            java.lang.String r13 = r4.getName()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r20 = r1
            java.lang.String r1 = "tt"
            if (r10 != r12) goto L_0x06a9
            boolean r10 = r1.equals(r13)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r21 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r12 = "TtmlParser"
            if (r10 == 0) goto L_0x01d7
            java.lang.String r10 = "frameRate"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r10 == 0) goto L_0x008c
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            goto L_0x008e
        L_0x008c:
            r10 = 30
        L_0x008e:
            java.lang.String r11 = "frameRateMultiplier"
            java.lang.String r11 = r4.getAttributeValue(r2, r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r3 = " "
            if (r11 == 0) goto L_0x00c2
            int r16 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r22 = r14
            r14 = -1
            java.lang.String[] r11 = r11.split(r3, r14)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r14 = r11.length     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r23 = r15
            r15 = 2
            if (r14 != r15) goto L_0x00a9
            r14 = 1
            goto L_0x00aa
        L_0x00a9:
            r14 = 0
        L_0x00aa:
            java.lang.String r15 = "frameRateMultiplier doesn't have 2 parts"
            com.google.android.gms.internal.ads.zzeq.zze(r14, r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r15 = 0
            r14 = r11[r15]     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r14 = java.lang.Integer.parseInt(r14)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            float r14 = (float) r14     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r16 = 1
            r11 = r11[r16]     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            float r11 = (float) r11     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            float r14 = r14 / r11
            goto L_0x00c9
        L_0x00c2:
            r22 = r14
            r23 = r15
            r15 = 0
            r14 = r21
        L_0x00c9:
            com.google.android.gms.internal.ads.zzamt r11 = zzh     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r11 = r11.zzb     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r15 = "subFrameRate"
            java.lang.String r15 = r4.getAttributeValue(r2, r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r15 == 0) goto L_0x00d9
            int r11 = java.lang.Integer.parseInt(r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x00d9:
            com.google.android.gms.internal.ads.zzamt r15 = zzh     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r15 = r15.zzc     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r16 = r15
            java.lang.String r15 = "tickRate"
            java.lang.String r15 = r4.getAttributeValue(r2, r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r15 == 0) goto L_0x00ec
            int r15 = java.lang.Integer.parseInt(r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            goto L_0x00ee
        L_0x00ec:
            r15 = r16
        L_0x00ee:
            r24 = r8
            com.google.android.gms.internal.ads.zzamt r8 = new com.google.android.gms.internal.ads.zzamt     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            float r10 = (float) r10     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            float r10 = r10 * r14
            r8.<init>(r10, r11, r15)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r10 = "cellResolution"
            java.lang.String r10 = r4.getAttributeValue(r2, r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r10 != 0) goto L_0x0107
            r25 = r2
            r16 = r8
            r15 = 15
            goto L_0x0185
        L_0x0107:
            java.util.regex.Pattern r11 = zzg     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r11 = r11.matcher(r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r14 = r11.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r14 != 0) goto L_0x0123
            java.lang.String r3 = "Ignoring malformed cell resolution: "
            java.lang.String r3 = r3.concat(r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r3)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r25 = r2
            r16 = r8
            r15 = 15
            goto L_0x0185
        L_0x0123:
            r14 = 1
            java.lang.String r15 = r11.group(r14)     // Catch:{ NumberFormatException -> 0x0175 }
            if (r15 == 0) goto L_0x016d
            int r14 = java.lang.Integer.parseInt(r15)     // Catch:{ NumberFormatException -> 0x0175 }
            r15 = 2
            java.lang.String r11 = r11.group(r15)     // Catch:{ NumberFormatException -> 0x0175 }
            if (r11 == 0) goto L_0x0167
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0175 }
            if (r14 == 0) goto L_0x0144
            if (r11 == 0) goto L_0x0141
            r15 = r11
            r11 = 1
            goto L_0x0146
        L_0x0141:
            r11 = 0
            r15 = 0
            goto L_0x0146
        L_0x0144:
            r15 = r11
            r11 = 0
        L_0x0146:
            r25 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0165 }
            r2.<init>()     // Catch:{ NumberFormatException -> 0x0165 }
            r16 = r8
            java.lang.String r8 = "Invalid cell resolution "
            r2.append(r8)     // Catch:{ NumberFormatException -> 0x0173 }
            r2.append(r14)     // Catch:{ NumberFormatException -> 0x0173 }
            r2.append(r3)     // Catch:{ NumberFormatException -> 0x0173 }
            r2.append(r15)     // Catch:{ NumberFormatException -> 0x0173 }
            java.lang.String r2 = r2.toString()     // Catch:{ NumberFormatException -> 0x0173 }
            com.google.android.gms.internal.ads.zzeq.zze(r11, r2)     // Catch:{ NumberFormatException -> 0x0173 }
            goto L_0x0185
        L_0x0165:
            r0 = move-exception
            goto L_0x0178
        L_0x0167:
            r25 = r2
            r16 = r8
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x0173 }
        L_0x016d:
            r25 = r2
            r16 = r8
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x0173 }
        L_0x0173:
            r0 = move-exception
            goto L_0x017a
        L_0x0175:
            r0 = move-exception
            r25 = r2
        L_0x0178:
            r16 = r8
        L_0x017a:
            java.lang.String r2 = "Ignoring malformed cell resolution: "
            java.lang.String r2 = r2.concat(r10)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r15 = 15
        L_0x0185:
            java.lang.String r2 = "extent"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzge.zza(r4, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r2 != 0) goto L_0x018f
            r10 = 0
            goto L_0x01d4
        L_0x018f:
            java.util.regex.Pattern r3 = zzf     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r3 = r3.matcher(r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r8 = r3.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r8 != 0) goto L_0x01a6
            java.lang.String r3 = "Ignoring non-pixel tts extent: "
            java.lang.String r2 = r3.concat(r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r10 = 0
            goto L_0x01d4
        L_0x01a6:
            r8 = 1
            java.lang.String r10 = r3.group(r8)     // Catch:{ NumberFormatException -> 0x01c9 }
            if (r10 == 0) goto L_0x01c6
            int r8 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01c9 }
            r10 = 2
            java.lang.String r3 = r3.group(r10)     // Catch:{ NumberFormatException -> 0x01c9 }
            if (r3 == 0) goto L_0x01c3
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x01c9 }
            com.google.android.gms.internal.ads.zzamu r10 = new com.google.android.gms.internal.ads.zzamu     // Catch:{ NumberFormatException -> 0x01c9 }
            r10.<init>(r8, r3)     // Catch:{ NumberFormatException -> 0x01c9 }
            goto L_0x01d4
        L_0x01c3:
            r3 = 0
            throw r3     // Catch:{ NumberFormatException -> 0x01c9 }
        L_0x01c6:
            r3 = 0
            throw r3     // Catch:{ NumberFormatException -> 0x01c9 }
        L_0x01c9:
            r0 = move-exception
            java.lang.String r3 = "Ignoring malformed tts extent: "
            java.lang.String r2 = r3.concat(r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r10 = 0
        L_0x01d4:
            r11 = r16
            goto L_0x01e3
        L_0x01d7:
            r25 = r2
            r24 = r8
            r22 = r14
            r23 = r15
            r10 = r16
            r15 = r17
        L_0x01e3:
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r2 = "image"
            java.lang.String r3 = "metadata"
            java.lang.String r8 = "region"
            java.lang.String r14 = "head"
            r26 = r9
            java.lang.String r9 = "style"
            if (r1 != 0) goto L_0x0281
            boolean r1 = r13.equals(r14)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "body"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "div"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "p"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "span"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "br"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            boolean r1 = r13.equals(r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "styling"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "layout"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            boolean r1 = r13.equals(r8)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            boolean r1 = r13.equals(r3)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            boolean r1 = r13.equals(r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "data"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 != 0) goto L_0x0281
            java.lang.String r1 = "information"
            boolean r1 = r13.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x025d
            goto L_0x0281
        L_0x025d:
            java.lang.String r1 = r4.getName()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r3 = "Ignoring unsupported tag: "
            r2.append(r3)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r2.append(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r1 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zze(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r16 = r10
            r17 = r15
            r14 = r22
            r8 = r24
            r15 = 1
            goto L_0x0704
        L_0x0281:
            boolean r1 = r14.equals(r13)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x0525
        L_0x0288:
            r4.next()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzc(r4, r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02d3
            java.lang.String r1 = com.google.android.gms.internal.ads.zzge.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzamy r13 = new com.google.android.gms.internal.ads.zzamy     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r13.<init>()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzamy r13 = zzf(r4, r13)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02be
            java.lang.String[] r1 = zzg(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r16 = r11
            int r11 = r1.length     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r17 = r9
            r9 = 0
        L_0x02aa:
            if (r9 >= r11) goto L_0x02c2
            r18 = r11
            r11 = r1[r9]     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.Object r11 = r5.get(r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzamy r11 = (com.google.android.gms.internal.ads.zzamy) r11     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r13.zzl(r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r9 = r9 + 1
            r11 = r18
            goto L_0x02aa
        L_0x02be:
            r17 = r9
            r16 = r11
        L_0x02c2:
            java.lang.String r1 = r13.zzE()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02cf
            r5.put(r1, r13)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r37 = r2
            goto L_0x0512
        L_0x02cf:
            r37 = r2
            goto L_0x0512
        L_0x02d3:
            r17 = r9
            r16 = r11
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzc(r4, r8)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.String r9 = "id"
            if (r1 != 0) goto L_0x030a
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzc(r4, r3)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x0306
        L_0x02e5:
            r4.next()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzc(r4, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02fb
            java.lang.String r1 = com.google.android.gms.internal.ads.zzge.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02fb
            java.lang.String r11 = r4.nextText()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r7.put(r1, r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x02fb:
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzb(r4, r3)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x02e5
            r37 = r2
            goto L_0x0512
        L_0x0306:
            r37 = r2
            goto L_0x0512
        L_0x030a:
            java.lang.String r27 = com.google.android.gms.internal.ads.zzge.zza(r4, r9)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r27 != 0) goto L_0x0316
            r37 = r2
            r1 = 0
            goto L_0x050b
        L_0x0316:
            java.lang.String r1 = "origin"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzge.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x0503
            java.util.regex.Pattern r9 = zzb     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r9 = r9.matcher(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Pattern r11 = zzf     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r11 = r11.matcher(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r13 = r9.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r18 = 1120403456(0x42c80000, float:100.0)
            if (r13 == 0) goto L_0x0364
            r11 = 1
            java.lang.String r13 = r9.group(r11)     // Catch:{ NumberFormatException -> 0x0355 }
            if (r13 == 0) goto L_0x0352
            float r11 = java.lang.Float.parseFloat(r13)     // Catch:{ NumberFormatException -> 0x0355 }
            float r11 = r11 / r18
            r13 = 2
            java.lang.String r9 = r9.group(r13)     // Catch:{ NumberFormatException -> 0x0355 }
            if (r9 == 0) goto L_0x034f
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0355 }
            float r9 = r9 / r18
            r28 = r11
            goto L_0x039e
        L_0x034f:
            r9 = 0
            throw r9     // Catch:{ NumberFormatException -> 0x0355 }
        L_0x0352:
            r9 = 0
            throw r9     // Catch:{ NumberFormatException -> 0x0355 }
        L_0x0355:
            r0 = move-exception
            java.lang.String r9 = "Ignoring region with malformed origin: "
            java.lang.String r1 = r9.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r37 = r2
            r1 = 0
            goto L_0x050b
        L_0x0364:
            boolean r9 = r11.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r9 == 0) goto L_0x04f6
            if (r10 != 0) goto L_0x037a
            java.lang.String r9 = "Ignoring region with missing tts:extent: "
            java.lang.String r1 = r9.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r37 = r2
            r1 = 0
            goto L_0x050b
        L_0x037a:
            r9 = 1
            java.lang.String r13 = r11.group(r9)     // Catch:{ NumberFormatException -> 0x04e8 }
            if (r13 == 0) goto L_0x04e2
            int r9 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x04e8 }
            r13 = 2
            java.lang.String r11 = r11.group(r13)     // Catch:{ NumberFormatException -> 0x04e8 }
            if (r11 == 0) goto L_0x04de
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x04e8 }
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x04e8 }
            int r13 = r10.zza     // Catch:{ NumberFormatException -> 0x04e8 }
            float r13 = (float) r13     // Catch:{ NumberFormatException -> 0x04e8 }
            float r9 = r9 / r13
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x04e8 }
            int r13 = r10.zzb     // Catch:{ NumberFormatException -> 0x04e8 }
            float r13 = (float) r13
            float r11 = r11 / r13
            r28 = r9
            r9 = r11
        L_0x039e:
            java.lang.String r11 = "extent"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzge.zza(r4, r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r11 == 0) goto L_0x04d5
            java.util.regex.Pattern r13 = zzb     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r13 = r13.matcher(r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r37 = r2
            java.util.regex.Pattern r2 = zzf     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.util.regex.Matcher r2 = r2.matcher(r11)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r11 = r13.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r11 == 0) goto L_0x03ec
            r2 = 1
            java.lang.String r11 = r13.group(r2)     // Catch:{ NumberFormatException -> 0x03df }
            if (r11 == 0) goto L_0x03dc
            float r2 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x03df }
            float r2 = r2 / r18
            r11 = 2
            java.lang.String r13 = r13.group(r11)     // Catch:{ NumberFormatException -> 0x03df }
            if (r13 == 0) goto L_0x03d9
            float r1 = java.lang.Float.parseFloat(r13)     // Catch:{ NumberFormatException -> 0x03df }
            float r1 = r1 / r18
            r33 = r1
            r32 = r2
            goto L_0x0425
        L_0x03d9:
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x03df }
        L_0x03dc:
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x03df }
        L_0x03df:
            r0 = move-exception
            java.lang.String r2 = "Ignoring region with malformed extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x03ec:
            boolean r11 = r2.matches()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r11 == 0) goto L_0x04ca
            if (r10 != 0) goto L_0x0400
            java.lang.String r2 = "Ignoring region with missing tts:extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x0400:
            r11 = 1
            java.lang.String r13 = r2.group(r11)     // Catch:{ NumberFormatException -> 0x04be }
            if (r13 == 0) goto L_0x04bb
            int r11 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x04be }
            r13 = 2
            java.lang.String r2 = r2.group(r13)     // Catch:{ NumberFormatException -> 0x04be }
            if (r2 == 0) goto L_0x04b8
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x04be }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x04be }
            int r13 = r10.zza     // Catch:{ NumberFormatException -> 0x04be }
            float r13 = (float) r13     // Catch:{ NumberFormatException -> 0x04be }
            float r11 = r11 / r13
            float r2 = (float) r2     // Catch:{ NumberFormatException -> 0x04be }
            int r1 = r10.zzb     // Catch:{ NumberFormatException -> 0x04be }
            float r1 = (float) r1
            float r2 = r2 / r1
            r33 = r2
            r32 = r11
        L_0x0425:
            java.lang.String r1 = "displayAlign"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzge.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x0464
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfxm.zza(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r2 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            switch(r2) {
                case -1364013995: goto L_0x0444;
                case 92734940: goto L_0x0439;
                default: goto L_0x0438;
            }
        L_0x0438:
            goto L_0x044e
        L_0x0439:
            java.lang.String r2 = "after"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0438
            r1 = 1
            goto L_0x044f
        L_0x0444:
            java.lang.String r2 = "center"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0438
            r1 = 0
            goto L_0x044f
        L_0x044e:
            r1 = -1
        L_0x044f:
            switch(r1) {
                case 0: goto L_0x045a;
                case 1: goto L_0x0453;
                default: goto L_0x0452;
            }
        L_0x0452:
            goto L_0x0464
        L_0x0453:
            float r9 = r9 + r33
            r29 = r9
            r31 = 2
            goto L_0x0468
        L_0x045a:
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r33 / r1
            float r9 = r9 + r1
            r29 = r9
            r31 = 1
            goto L_0x0468
        L_0x0464:
            r29 = r9
            r31 = 0
        L_0x0468:
            float r1 = (float) r15
            float r35 = r21 / r1
            java.lang.String r1 = "writingMode"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzge.zza(r4, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x04a8
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfxm.zza(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r2 = r1.hashCode()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            switch(r2) {
                case 3694: goto L_0x0493;
                case 3553396: goto L_0x0489;
                case 3553576: goto L_0x047f;
                default: goto L_0x047e;
            }
        L_0x047e:
            goto L_0x049d
        L_0x047f:
            java.lang.String r2 = "tbrl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x047e
            r1 = 2
            goto L_0x049e
        L_0x0489:
            java.lang.String r2 = "tblr"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x047e
            r1 = 1
            goto L_0x049e
        L_0x0493:
            java.lang.String r2 = "tb"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x047e
            r1 = 0
            goto L_0x049e
        L_0x049d:
            r1 = -1
        L_0x049e:
            switch(r1) {
                case 0: goto L_0x04a5;
                case 1: goto L_0x04a5;
                case 2: goto L_0x04a2;
                default: goto L_0x04a1;
            }
        L_0x04a1:
            goto L_0x04a8
        L_0x04a2:
            r36 = 1
            goto L_0x04ac
        L_0x04a5:
            r36 = 2
            goto L_0x04ac
        L_0x04a8:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r36 = r1
        L_0x04ac:
            com.google.android.gms.internal.ads.zzamw r1 = new com.google.android.gms.internal.ads.zzamw     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r30 = 0
            r34 = 1
            r26 = r1
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            goto L_0x050b
        L_0x04b8:
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x04be }
        L_0x04bb:
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x04be }
        L_0x04be:
            r0 = move-exception
            java.lang.String r2 = "Ignoring region with malformed extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x04ca:
            java.lang.String r2 = "Ignoring region with unsupported extent: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x04d5:
            r37 = r2
            java.lang.String r1 = "Ignoring region without an extent"
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x04de:
            r37 = r2
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x04e6 }
        L_0x04e2:
            r37 = r2
            r2 = 0
            throw r2     // Catch:{ NumberFormatException -> 0x04e6 }
        L_0x04e6:
            r0 = move-exception
            goto L_0x04eb
        L_0x04e8:
            r0 = move-exception
            r37 = r2
        L_0x04eb:
            java.lang.String r2 = "Ignoring region with malformed origin: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x04f6:
            r37 = r2
            java.lang.String r2 = "Ignoring region with unsupported origin: "
            java.lang.String r1 = r2.concat(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
            goto L_0x050b
        L_0x0503:
            r37 = r2
            java.lang.String r1 = "Ignoring region without an origin"
            com.google.android.gms.internal.ads.zzfk.zzf(r12, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r1 = 0
        L_0x050b:
            if (r1 == 0) goto L_0x0512
            java.lang.String r2 = r1.zza     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r6.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x0512:
            boolean r1 = com.google.android.gms.internal.ads.zzge.zzb(r4, r14)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r11 = r16
            if (r1 == 0) goto L_0x051f
            r8 = r24
            goto L_0x0689
        L_0x051f:
            r9 = r17
            r2 = r37
            goto L_0x0288
        L_0x0525:
            r17 = r9
            r16 = r11
            int r1 = r4.getAttributeCount()     // Catch:{ zzalr -> 0x0695 }
            r2 = 0
            com.google.android.gms.internal.ads.zzamy r32 = zzf(r4, r2)     // Catch:{ zzalr -> 0x0695 }
            r34 = r20
            r9 = 0
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r27 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r29 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r33 = 0
            r35 = 0
        L_0x0548:
            if (r9 >= r1) goto L_0x061f
            java.lang.String r11 = r4.getAttributeName(r9)     // Catch:{ zzalr -> 0x0616 }
            java.lang.String r2 = r4.getAttributeValue(r9)     // Catch:{ zzalr -> 0x0616 }
            int r3 = r11.hashCode()     // Catch:{ zzalr -> 0x0616 }
            switch(r3) {
                case -934795532: goto L_0x05ac;
                case 99841: goto L_0x059e;
                case 100571: goto L_0x0590;
                case 93616297: goto L_0x0582;
                case 109780401: goto L_0x0576;
                case 1292595405: goto L_0x055f;
                default: goto L_0x0559;
            }
        L_0x0559:
            r3 = r17
            r17 = r1
            goto L_0x05b8
        L_0x055f:
            java.lang.String r3 = "backgroundImage"
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x0571
            r3 = 5
            r38 = r17
            r17 = r1
            r1 = r3
            r3 = r38
            goto L_0x05b9
        L_0x0571:
            r3 = r17
            r17 = r1
            goto L_0x05b8
        L_0x0576:
            r3 = r17
            boolean r11 = r11.equals(r3)
            r17 = r1
            if (r11 == 0) goto L_0x05b8
            r1 = 3
            goto L_0x05b9
        L_0x0582:
            r3 = r17
            r17 = r1
            java.lang.String r1 = "begin"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x05b8
            r1 = 0
            goto L_0x05b9
        L_0x0590:
            r3 = r17
            r17 = r1
            java.lang.String r1 = "end"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x05b8
            r1 = 1
            goto L_0x05b9
        L_0x059e:
            r3 = r17
            r17 = r1
            java.lang.String r1 = "dur"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x05b8
            r1 = 2
            goto L_0x05b9
        L_0x05ac:
            r3 = r17
            r17 = r1
            boolean r1 = r11.equals(r8)
            if (r1 == 0) goto L_0x05b8
            r1 = 4
            goto L_0x05b9
        L_0x05b8:
            r1 = -1
        L_0x05b9:
            switch(r1) {
                case 0: goto L_0x0605;
                case 1: goto L_0x05fd;
                case 2: goto L_0x05f5;
                case 3: goto L_0x05e3;
                case 4: goto L_0x05d7;
                case 5: goto L_0x05c0;
                default: goto L_0x05bc;
            }
        L_0x05bc:
            r11 = r16
            r1 = 1
            goto L_0x060c
        L_0x05c0:
            java.lang.String r1 = "#"
            boolean r1 = r2.startsWith(r1)     // Catch:{ zzalr -> 0x05d4 }
            if (r1 == 0) goto L_0x05d2
            r1 = 1
            java.lang.String r2 = r2.substring(r1)     // Catch:{ zzalr -> 0x05f0 }
            r35 = r2
        L_0x05cf:
            r11 = r16
            goto L_0x060c
        L_0x05d2:
            r1 = 1
            goto L_0x05cf
        L_0x05d4:
            r0 = move-exception
            r1 = 1
            goto L_0x05f1
        L_0x05d7:
            r1 = 1
            boolean r11 = r6.containsKey(r2)     // Catch:{ zzalr -> 0x05f0 }
            if (r11 == 0) goto L_0x05e0
            r34 = r2
        L_0x05e0:
            r11 = r16
            goto L_0x060c
        L_0x05e3:
            r1 = 1
            java.lang.String[] r2 = zzg(r2)     // Catch:{ zzalr -> 0x05f0 }
            int r11 = r2.length     // Catch:{ zzalr -> 0x05f0 }
            if (r11 <= 0) goto L_0x05ed
            r33 = r2
        L_0x05ed:
            r11 = r16
            goto L_0x060c
        L_0x05f0:
            r0 = move-exception
        L_0x05f1:
            r2 = r0
            r11 = r16
            goto L_0x061b
        L_0x05f5:
            r1 = 1
            r11 = r16
            long r29 = zzc(r2, r11)     // Catch:{ zzalr -> 0x064c }
            goto L_0x060c
        L_0x05fd:
            r11 = r16
            r1 = 1
            long r13 = zzc(r2, r11)     // Catch:{ zzalr -> 0x064c }
            goto L_0x060c
        L_0x0605:
            r11 = r16
            r1 = 1
            long r27 = zzc(r2, r11)     // Catch:{ zzalr -> 0x064c }
        L_0x060c:
            int r9 = r9 + 1
            r16 = r11
            r1 = r17
            r17 = r3
            goto L_0x0548
        L_0x0616:
            r0 = move-exception
            r11 = r16
            r1 = 1
        L_0x061a:
            r2 = r0
        L_0x061b:
            r8 = r24
            goto L_0x069c
        L_0x061f:
            r11 = r16
            r1 = 1
            if (r26 == 0) goto L_0x064e
            r2 = r26
            long r8 = r2.zzd     // Catch:{ zzalr -> 0x064c }
            r36 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r8 > r36 ? 1 : (r8 == r36 ? 0 : -1))
            if (r3 == 0) goto L_0x0648
            int r3 = (r27 > r36 ? 1 : (r27 == r36 ? 0 : -1))
            if (r3 == 0) goto L_0x0638
            long r16 = r27 + r8
            goto L_0x063a
        L_0x0638:
            r16 = r36
        L_0x063a:
            int r3 = (r13 > r36 ? 1 : (r13 == r36 ? 0 : -1))
            if (r3 == 0) goto L_0x0641
            long r13 = r13 + r8
            r3 = r2
            goto L_0x0653
        L_0x0641:
            r3 = r2
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0653
        L_0x0648:
            r3 = r2
            r16 = r27
            goto L_0x0653
        L_0x064c:
            r0 = move-exception
            goto L_0x061a
        L_0x064e:
            r2 = r26
            r16 = r27
            r3 = 0
        L_0x0653:
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r18 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r18 != 0) goto L_0x0671
            int r13 = (r29 > r8 ? 1 : (r29 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x0665
            long r29 = r16 + r29
            r30 = r29
            goto L_0x0673
        L_0x0665:
            if (r3 == 0) goto L_0x066e
            long r13 = r3.zze     // Catch:{ zzalr -> 0x064c }
            int r18 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r18 == 0) goto L_0x066e
            goto L_0x0671
        L_0x066e:
            r30 = r8
            goto L_0x0673
        L_0x0671:
            r30 = r13
        L_0x0673:
            java.lang.String r27 = r4.getName()     // Catch:{ zzalr -> 0x0691 }
            r28 = r16
            r36 = r3
            com.google.android.gms.internal.ads.zzams r3 = com.google.android.gms.internal.ads.zzams.zzb(r27, r28, r30, r32, r33, r34, r35, r36)     // Catch:{ zzalr -> 0x0691 }
            r8 = r24
            r8.push(r3)     // Catch:{ zzalr -> 0x068f }
            if (r2 == 0) goto L_0x0689
            r2.zzf(r3)     // Catch:{ zzalr -> 0x068f }
        L_0x0689:
            r16 = r10
            r17 = r15
            goto L_0x0700
        L_0x068f:
            r0 = move-exception
            goto L_0x069b
        L_0x0691:
            r0 = move-exception
            r8 = r24
            goto L_0x069b
        L_0x0695:
            r0 = move-exception
            r11 = r16
            r8 = r24
            r1 = 1
        L_0x069b:
            r2 = r0
        L_0x069c:
            java.lang.String r3 = "Suppressing parser error"
            com.google.android.gms.internal.ads.zzfk.zzg(r12, r3, r2)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r16 = r10
            r17 = r15
            r14 = r22
            r15 = r1
            goto L_0x0704
        L_0x06a9:
            r25 = r2
            r2 = r9
            r22 = r14
            r23 = r15
            r3 = 4
            if (r10 != r3) goto L_0x06c4
            if (r2 == 0) goto L_0x06c1
            java.lang.String r1 = r4.getText()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzams r1 = com.google.android.gms.internal.ads.zzams.zzc(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r2.zzf(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            goto L_0x0700
        L_0x06c1:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x06c4:
            r2 = 3
            if (r10 != r2) goto L_0x0700
            java.lang.String r2 = r4.getName()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            boolean r1 = r2.equals(r1)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x06e2
            com.google.android.gms.internal.ads.zzamz r14 = new com.google.android.gms.internal.ads.zzamz     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            java.lang.Object r1 = r8.peek()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            com.google.android.gms.internal.ads.zzams r1 = (com.google.android.gms.internal.ads.zzams) r1     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            if (r1 == 0) goto L_0x06df
            r14.<init>(r1, r5, r6, r7)     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            goto L_0x06e4
        L_0x06df:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x06e2:
            r14 = r22
        L_0x06e4:
            r8.pop()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r15 = r23
            goto L_0x0704
        L_0x06ea:
            r20 = r1
            r25 = r2
            r22 = r14
            r23 = r15
            r1 = 2
            if (r10 != r1) goto L_0x06fa
            int r15 = r23 + 1
        L_0x06f7:
            r14 = r22
            goto L_0x0704
        L_0x06fa:
            r1 = 3
            if (r10 != r1) goto L_0x0700
            int r15 = r23 + -1
            goto L_0x06f7
        L_0x0700:
            r14 = r22
            r15 = r23
        L_0x0704:
            r4.next()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            int r10 = r4.getEventType()     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
            r3 = r39
            r1 = r20
            r2 = r25
            r9 = 0
            goto L_0x005d
        L_0x0714:
            r22 = r14
            if (r22 == 0) goto L_0x0719
            return r22
        L_0x0719:
            r1 = 0
            throw r1     // Catch:{ XmlPullParserException -> 0x0725, IOException -> 0x071b }
        L_0x071b:
            r0 = move-exception
            r1 = r0
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Unexpected error when reading input."
            r2.<init>(r3, r1)
            throw r2
        L_0x0725:
            r0 = move-exception
            r1 = r0
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Unable to decode source"
            r2.<init>(r3, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.zzb(byte[], int, int):com.google.android.gms.internal.ads.zzalq");
    }

    public zzamv() {
        try {
            this.zzi = XmlPullParserFactory.newInstance();
            this.zzi.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
