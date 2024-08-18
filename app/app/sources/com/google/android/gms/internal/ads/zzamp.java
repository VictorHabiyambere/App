package com.google.android.gms.internal.ads;

import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzamp implements zzalv {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzfu zze = new zzfu();

    public static float zzb(int i) {
        switch (i) {
            case 0:
                return 0.08f;
            case 1:
                return 0.5f;
            case 2:
                return 0.92f;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static long zzc(Matcher matcher, int i) {
        long j;
        String group = matcher.group(i + 1);
        if (group != null) {
            j = Long.parseLong(group) * 3600000;
        } else {
            j = 0;
        }
        String group2 = matcher.group(i + 2);
        if (group2 != null) {
            long parseLong = j + (Long.parseLong(group2) * ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
            String group3 = matcher.group(i + 3);
            if (group3 != null) {
                long parseLong2 = parseLong + (Long.parseLong(group3) * 1000);
                String group4 = matcher.group(i + 4);
                if (group4 != null) {
                    parseLong2 += Long.parseLong(group4);
                }
                return parseLong2 * 1000;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(byte[] r18, int r19, int r20, com.google.android.gms.internal.ads.zzalu r21, com.google.android.gms.internal.ads.zzev r22) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "SubripParser"
            int r3 = r0 + r20
            com.google.android.gms.internal.ads.zzfu r4 = r1.zze
            r5 = r18
            r4.zzI(r5, r3)
            com.google.android.gms.internal.ads.zzfu r3 = r1.zze
            r3.zzK(r0)
            com.google.android.gms.internal.ads.zzfu r0 = r1.zze
            java.nio.charset.Charset r0 = r0.zzB()
            if (r0 != 0) goto L_0x0020
            java.nio.charset.Charset r0 = com.google.android.gms.internal.ads.zzfxs.zzc
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r0
        L_0x0021:
            com.google.android.gms.internal.ads.zzfu r0 = r1.zze
            java.lang.String r4 = r0.zzy(r3)
            if (r4 == 0) goto L_0x01f6
            int r0 = r4.length()
            if (r0 == 0) goto L_0x01f2
            java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x01e4 }
            com.google.android.gms.internal.ads.zzfu r0 = r1.zze
            java.lang.String r0 = r0.zzy(r3)
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = "Unexpected end"
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)
            return
        L_0x0040:
            java.util.regex.Pattern r4 = zza
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r5 = r4.matches()
            if (r5 == 0) goto L_0x01d7
            r0 = 1
            long r7 = zzc(r4, r0)
            r5 = 6
            long r4 = zzc(r4, r5)
            java.lang.StringBuilder r6 = r1.zzc
            r9 = 0
            r6.setLength(r9)
            java.util.ArrayList r6 = r1.zzd
            r6.clear()
            com.google.android.gms.internal.ads.zzfu r6 = r1.zze
            java.lang.String r6 = r6.zzy(r3)
        L_0x0067:
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 != 0) goto L_0x00c1
            java.lang.StringBuilder r10 = r1.zzc
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x007c
            java.lang.StringBuilder r10 = r1.zzc
            java.lang.String r11 = "<br>"
            r10.append(r11)
        L_0x007c:
            java.lang.StringBuilder r10 = r1.zzc
            java.util.ArrayList r11 = r1.zzd
            java.lang.String r6 = r6.trim()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r6)
            java.util.regex.Pattern r13 = zzb
            java.util.regex.Matcher r6 = r13.matcher(r6)
            r13 = r9
        L_0x0090:
            boolean r14 = r6.find()
            if (r14 == 0) goto L_0x00b1
            java.lang.String r14 = r6.group()
            r11.add(r14)
            int r15 = r6.start()
            int r15 = r15 - r13
            int r14 = r14.length()
            int r0 = r15 + r14
            java.lang.String r9 = ""
            r12.replace(r15, r0, r9)
            int r13 = r13 + r14
            r0 = 1
            r9 = 0
            goto L_0x0090
        L_0x00b1:
            java.lang.String r0 = r12.toString()
            r10.append(r0)
            com.google.android.gms.internal.ads.zzfu r0 = r1.zze
            java.lang.String r6 = r0.zzy(r3)
            r0 = 1
            r9 = 0
            goto L_0x0067
        L_0x00c1:
            java.lang.StringBuilder r0 = r1.zzc
            java.lang.String r0 = r0.toString()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r6 = 0
        L_0x00cc:
            java.util.ArrayList r9 = r1.zzd
            int r9 = r9.size()
            if (r6 >= r9) goto L_0x00e8
            java.util.ArrayList r9 = r1.zzd
            java.lang.Object r9 = r9.get(r6)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r10 = "\\{\\\\an[1-9]\\}"
            boolean r10 = r9.matches(r10)
            if (r10 == 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            int r6 = r6 + 1
            goto L_0x00cc
        L_0x00e8:
            r9 = 0
        L_0x00e9:
            com.google.android.gms.internal.ads.zzaln r11 = new com.google.android.gms.internal.ads.zzaln
            com.google.android.gms.internal.ads.zzeg r6 = new com.google.android.gms.internal.ads.zzeg
            r6.<init>()
            r6.zzl(r0)
            if (r9 != 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzei r0 = r6.zzp()
            goto L_0x01c6
        L_0x00fb:
            int r0 = r9.hashCode()
            java.lang.String r14 = "{\\an9}"
            java.lang.String r15 = "{\\an7}"
            java.lang.String r10 = "{\\an3}"
            java.lang.String r12 = "{\\an1}"
            r16 = -1
            r13 = 2
            switch(r0) {
                case -685620710: goto L_0x013a;
                case -685620648: goto L_0x0132;
                case -685620617: goto L_0x0128;
                case -685620555: goto L_0x011e;
                case -685620524: goto L_0x0116;
                case -685620462: goto L_0x010e;
                default: goto L_0x010d;
            }
        L_0x010d:
            goto L_0x0142
        L_0x010e:
            boolean r0 = r9.equals(r14)
            if (r0 == 0) goto L_0x0142
            r0 = 5
            goto L_0x0144
        L_0x0116:
            boolean r0 = r9.equals(r15)
            if (r0 == 0) goto L_0x0142
            r0 = r13
            goto L_0x0144
        L_0x011e:
            java.lang.String r0 = "{\\an6}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0142
            r0 = 4
            goto L_0x0144
        L_0x0128:
            java.lang.String r0 = "{\\an4}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0142
            r0 = 1
            goto L_0x0144
        L_0x0132:
            boolean r0 = r9.equals(r10)
            if (r0 == 0) goto L_0x0142
            r0 = 3
            goto L_0x0144
        L_0x013a:
            boolean r0 = r9.equals(r12)
            if (r0 == 0) goto L_0x0142
            r0 = 0
            goto L_0x0144
        L_0x0142:
            r0 = r16
        L_0x0144:
            switch(r0) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0151;
                case 2: goto L_0x0151;
                case 3: goto L_0x014c;
                case 4: goto L_0x014c;
                case 5: goto L_0x014c;
                default: goto L_0x0147;
            }
        L_0x0147:
            r0 = 1
            r6.zzi(r0)
            goto L_0x0156
        L_0x014c:
            r6.zzi(r13)
            goto L_0x0156
        L_0x0151:
            r0 = 0
            r6.zzi(r0)
        L_0x0156:
            int r0 = r9.hashCode()
            switch(r0) {
                case -685620710: goto L_0x018f;
                case -685620679: goto L_0x0184;
                case -685620648: goto L_0x017b;
                case -685620524: goto L_0x0172;
                case -685620493: goto L_0x0167;
                case -685620462: goto L_0x015e;
                default: goto L_0x015d;
            }
        L_0x015d:
            goto L_0x0198
        L_0x015e:
            boolean r0 = r9.equals(r14)
            if (r0 == 0) goto L_0x0198
            r16 = 5
            goto L_0x0199
        L_0x0167:
            java.lang.String r0 = "{\\an8}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0198
            r16 = 4
            goto L_0x0199
        L_0x0172:
            boolean r0 = r9.equals(r15)
            if (r0 == 0) goto L_0x0198
            r16 = 3
            goto L_0x0199
        L_0x017b:
            boolean r0 = r9.equals(r10)
            if (r0 == 0) goto L_0x0198
            r16 = r13
            goto L_0x0199
        L_0x0184:
            java.lang.String r0 = "{\\an2}"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0198
            r16 = 1
            goto L_0x0199
        L_0x018f:
            boolean r0 = r9.equals(r12)
            if (r0 == 0) goto L_0x0198
            r16 = 0
            goto L_0x0199
        L_0x0198:
        L_0x0199:
            switch(r16) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x01a7;
                case 2: goto L_0x01a7;
                case 3: goto L_0x01a1;
                case 4: goto L_0x01a1;
                case 5: goto L_0x01a1;
                default: goto L_0x019c;
            }
        L_0x019c:
            r0 = 1
            r6.zzf(r0)
            goto L_0x01ab
        L_0x01a1:
            r0 = 0
            r6.zzf(r0)
            goto L_0x01ab
        L_0x01a7:
            r6.zzf(r13)
        L_0x01ab:
            int r0 = r6.zzb()
            float r0 = zzb(r0)
            r6.zzh(r0)
            int r0 = r6.zza()
            float r0 = zzb(r0)
            r9 = 0
            r6.zze(r0, r9)
            com.google.android.gms.internal.ads.zzei r0 = r6.zzp()
        L_0x01c6:
            long r9 = r4 - r7
            com.google.android.gms.internal.ads.zzgbc r6 = com.google.android.gms.internal.ads.zzgbc.zzn(r0)
            r5 = r11
            r5.<init>(r6, r7, r9)
            r5 = r22
            r5.zza(r11)
            goto L_0x0021
        L_0x01d7:
            r5 = r22
            java.lang.String r4 = "Skipping invalid timing: "
            java.lang.String r0 = r4.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)
            goto L_0x0021
        L_0x01e4:
            r0 = move-exception
            r5 = r22
            java.lang.String r0 = "Skipping invalid index: "
            java.lang.String r0 = r0.concat(r4)
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)
            goto L_0x0021
        L_0x01f2:
            r5 = r22
            goto L_0x0021
        L_0x01f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamp.zza(byte[], int, int, com.google.android.gms.internal.ads.zzalu, com.google.android.gms.internal.ads.zzev):void");
    }
}
