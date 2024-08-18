package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzanc {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzfu zzc = new zzfu();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzfu zzfu, StringBuilder sb) {
        zzc(zzfu);
        if (zzfu.zzb() == 0) {
            return null;
        }
        String zzd2 = zzd(zzfu, sb);
        if (!"".equals(zzd2)) {
            return zzd2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) zzfu.zzm());
        return sb2.toString();
    }

    static void zzc(zzfu zzfu) {
        boolean z = true;
        while (zzfu.zzb() > 0 && z) {
            switch ((char) zzfu.zzM()[zzfu.zzd()]) {
                case 9:
                case 10:
                case 12:
                case 13:
                case ' ':
                    zzfu.zzL(1);
                    z = true;
                    break;
                default:
                    int zzd2 = zzfu.zzd();
                    int zze = zzfu.zze();
                    byte[] zzM = zzfu.zzM();
                    if (zzd2 + 2 <= zze) {
                        int i = zzd2 + 1;
                        if (zzM[zzd2] == 47) {
                            int i2 = i + 1;
                            if (zzM[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= zze) {
                                        zzfu.zzL(zze - zzfu.zzd());
                                        z = true;
                                        break;
                                    } else if (((char) zzM[i2]) == '*' && ((char) zzM[i3]) == '/') {
                                        zze = i3 + 1;
                                        i2 = zze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    break;
            }
        }
    }

    private static String zzd(zzfu zzfu, StringBuilder sb) {
        sb.setLength(0);
        int zzd2 = zzfu.zzd();
        int zze = zzfu.zze();
        boolean z = false;
        while (zzd2 < zze && !z) {
            char c = (char) zzfu.zzM()[zzd2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                sb.append(c);
                zzd2++;
                z = false;
            }
        }
        zzfu.zzL(zzd2 - zzfu.zzd());
        return sb.toString();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzb(com.google.android.gms.internal.ads.zzfu r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = r0.zzd
            r2 = 0
            r1.setLength(r2)
            int r1 = r18.zzd()
        L_0x000c:
            java.nio.charset.Charset r3 = com.google.android.gms.internal.ads.zzfxs.zzc
            r4 = r18
            java.lang.String r3 = r4.zzy(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0355
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzc
            byte[] r5 = r18.zzM()
            int r4 = r18.zzd()
            r3.zzI(r5, r4)
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzc
            r3.zzK(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0031:
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzc
            java.lang.StringBuilder r4 = r0.zzd
            zzc(r3)
            int r5 = r3.zzb()
            java.lang.String r6 = "{"
            r7 = 5
            java.lang.String r8 = ""
            r9 = 0
            r10 = 1
            if (r5 >= r7) goto L_0x0048
            r5 = r9
            goto L_0x00b8
        L_0x0048:
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzfxs.zzc
            java.lang.String r5 = r3.zzA(r7, r5)
            java.lang.String r7 = "::cue"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x0059
            r5 = r9
            goto L_0x00b8
        L_0x0059:
            int r5 = r3.zzd()
            java.lang.String r7 = zza(r3, r4)
            if (r7 != 0) goto L_0x0065
            r5 = r9
            goto L_0x00b8
        L_0x0065:
            boolean r11 = r6.equals(r7)
            if (r11 == 0) goto L_0x0070
            r3.zzK(r5)
            r5 = r8
            goto L_0x00b8
        L_0x0070:
            java.lang.String r5 = "("
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x00aa
            int r5 = r3.zzd()
            int r7 = r3.zze()
            r11 = r2
        L_0x0082:
            if (r5 >= r7) goto L_0x0098
            if (r11 != 0) goto L_0x0098
            byte[] r11 = r3.zzM()
            int r12 = r5 + 1
            byte r5 = r11[r5]
            char r5 = (char) r5
            r11 = 41
            if (r5 != r11) goto L_0x0095
            r11 = r10
            goto L_0x0096
        L_0x0095:
            r11 = r2
        L_0x0096:
            r5 = r12
            goto L_0x0082
        L_0x0098:
            int r5 = r5 + -1
            int r7 = r3.zzd()
            int r5 = r5 - r7
            java.nio.charset.Charset r7 = com.google.android.gms.internal.ads.zzfxs.zzc
            java.lang.String r5 = r3.zzA(r5, r7)
            java.lang.String r5 = r5.trim()
            goto L_0x00ab
        L_0x00aa:
            r5 = r9
        L_0x00ab:
            java.lang.String r3 = zza(r3, r4)
            java.lang.String r4 = ")"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00b8
            r5 = r9
        L_0x00b8:
            if (r5 == 0) goto L_0x0354
            com.google.android.gms.internal.ads.zzfu r3 = r0.zzc
            java.lang.StringBuilder r4 = r0.zzd
            java.lang.String r3 = zza(r3, r4)
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x00ca
            goto L_0x0354
        L_0x00ca:
            com.google.android.gms.internal.ads.zzand r3 = new com.google.android.gms.internal.ads.zzand
            r3.<init>()
            boolean r4 = r8.equals(r5)
            r6 = -1
            if (r4 == 0) goto L_0x00d9
            r4 = r2
            r5 = r9
            goto L_0x0139
        L_0x00d9:
            r4 = 91
            int r4 = r5.indexOf(r4)
            if (r4 == r6) goto L_0x0103
            java.util.regex.Pattern r7 = zza
            java.lang.String r11 = r5.substring(r4)
            java.util.regex.Matcher r7 = r7.matcher(r11)
            boolean r11 = r7.matches()
            if (r11 == 0) goto L_0x00fe
            java.lang.String r7 = r7.group(r10)
            if (r7 == 0) goto L_0x00fc
            r3.zzv(r7)
            goto L_0x00fe
        L_0x00fc:
            throw r9
        L_0x00fe:
            java.lang.String r5 = r5.substring(r2, r4)
        L_0x0103:
            int r4 = com.google.android.gms.internal.ads.zzgd.zza
            java.lang.String r4 = "\\."
            java.lang.String[] r4 = r5.split(r4, r6)
            r5 = r4[r2]
            r7 = 35
            int r7 = r5.indexOf(r7)
            if (r7 == r6) goto L_0x0126
            java.lang.String r11 = r5.substring(r2, r7)
            r3.zzu(r11)
            int r7 = r7 + 1
            java.lang.String r5 = r5.substring(r7)
            r3.zzt(r5)
            goto L_0x0129
        L_0x0126:
            r3.zzu(r5)
        L_0x0129:
            int r5 = r4.length
            if (r5 <= r10) goto L_0x0136
            java.lang.Object[] r4 = java.util.Arrays.copyOfRange(r4, r10, r5)
            java.lang.String[] r4 = (java.lang.String[]) r4
            r3.zzs(r4)
            goto L_0x0137
        L_0x0136:
        L_0x0137:
            r4 = r2
            r5 = r9
        L_0x0139:
            java.lang.String r7 = "}"
            if (r4 != 0) goto L_0x0344
            com.google.android.gms.internal.ads.zzfu r4 = r0.zzc
            java.lang.StringBuilder r5 = r0.zzd
            int r11 = r4.zzd()
            java.lang.String r5 = zza(r4, r5)
            if (r5 == 0) goto L_0x0155
            boolean r4 = r7.equals(r5)
            if (r4 == 0) goto L_0x0153
            r4 = r10
            goto L_0x0156
        L_0x0153:
            r4 = r2
            goto L_0x0156
        L_0x0155:
            r4 = r10
        L_0x0156:
            if (r4 != 0) goto L_0x033e
            com.google.android.gms.internal.ads.zzfu r12 = r0.zzc
            r12.zzK(r11)
            com.google.android.gms.internal.ads.zzfu r11 = r0.zzc
            java.lang.StringBuilder r12 = r0.zzd
            zzc(r11)
            java.lang.String r13 = zzd(r11, r12)
            boolean r14 = r8.equals(r13)
            if (r14 == 0) goto L_0x0171
            r2 = r9
            goto L_0x033f
        L_0x0171:
            java.lang.String r14 = zza(r11, r12)
            java.lang.String r15 = ":"
            boolean r14 = r15.equals(r14)
            if (r14 != 0) goto L_0x0180
            r2 = r9
            goto L_0x033f
        L_0x0180:
            zzc(r11)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r15 = r2
        L_0x0189:
            java.lang.String r2 = ";"
            if (r15 != 0) goto L_0x01b6
            int r6 = r11.zzd()
            java.lang.String r9 = zza(r11, r12)
            if (r9 != 0) goto L_0x0199
            r6 = 0
            goto L_0x01ba
        L_0x0199:
            boolean r16 = r7.equals(r9)
            if (r16 != 0) goto L_0x01ae
            boolean r2 = r2.equals(r9)
            if (r2 == 0) goto L_0x01a7
            goto L_0x01ae
        L_0x01a7:
            r14.append(r9)
            r2 = 0
            r6 = -1
            r9 = 0
            goto L_0x0189
        L_0x01ae:
            r11.zzK(r6)
            r15 = r10
            r2 = 0
            r6 = -1
            r9 = 0
            goto L_0x0189
        L_0x01b6:
            java.lang.String r6 = r14.toString()
        L_0x01ba:
            if (r6 == 0) goto L_0x033c
            boolean r9 = r8.equals(r6)
            if (r9 == 0) goto L_0x01c5
            r2 = 0
            goto L_0x033f
        L_0x01c5:
            int r9 = r11.zzd()
            java.lang.String r12 = zza(r11, r12)
            boolean r2 = r2.equals(r12)
            if (r2 == 0) goto L_0x01d4
            goto L_0x01de
        L_0x01d4:
            boolean r2 = r7.equals(r12)
            if (r2 == 0) goto L_0x033c
            r11.zzK(r9)
        L_0x01de:
            java.lang.String r2 = "color"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x01f1
            int r2 = com.google.android.gms.internal.ads.zzet.zza(r6)
            r3.zzk(r2)
            r2 = 0
            goto L_0x033f
        L_0x01f1:
            java.lang.String r2 = "background-color"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0204
            int r2 = com.google.android.gms.internal.ads.zzet.zza(r6)
            r3.zzh(r2)
            r2 = 0
            goto L_0x033f
        L_0x0204:
            java.lang.String r2 = "ruby-position"
            boolean r2 = r2.equals(r13)
            r7 = 2
            if (r2 == 0) goto L_0x022d
            java.lang.String r2 = "over"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x021c
            r3.zzp(r10)
            r2 = 0
            goto L_0x033f
        L_0x021c:
            java.lang.String r2 = "under"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0229
            r3.zzp(r7)
            goto L_0x022a
        L_0x0229:
        L_0x022a:
            r2 = 0
            goto L_0x033f
        L_0x022d:
            java.lang.String r2 = "text-combine-upright"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0250
            java.lang.String r2 = "all"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0249
            java.lang.String r2 = "digits"
            boolean r2 = r6.startsWith(r2)
            if (r2 == 0) goto L_0x0247
            goto L_0x0249
        L_0x0247:
            r2 = 0
            goto L_0x024a
        L_0x0249:
            r2 = r10
        L_0x024a:
            r3.zzj(r2)
            r2 = 0
            goto L_0x033f
        L_0x0250:
            java.lang.String r2 = "text-decoration"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0269
            java.lang.String r2 = "underline"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0265
            r3.zzq(r10)
            goto L_0x0266
        L_0x0265:
        L_0x0266:
            r2 = 0
            goto L_0x033f
        L_0x0269:
            java.lang.String r2 = "font-family"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0278
            r3.zzl(r6)
            r2 = 0
            goto L_0x033f
        L_0x0278:
            java.lang.String r2 = "font-weight"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0291
            java.lang.String r2 = "bold"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x028d
            r3.zzi(r10)
            goto L_0x028e
        L_0x028d:
        L_0x028e:
            r2 = 0
            goto L_0x033f
        L_0x0291:
            java.lang.String r2 = "font-style"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x02aa
            java.lang.String r2 = "italic"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x02a6
            r3.zzo(r10)
            goto L_0x02a7
        L_0x02a6:
        L_0x02a7:
            r2 = 0
            goto L_0x033f
        L_0x02aa:
            java.lang.String r2 = "font-size"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x033a
            java.util.regex.Pattern r2 = zzb
            java.lang.String r9 = com.google.android.gms.internal.ads.zzfxm.zza(r6)
            java.util.regex.Matcher r2 = r2.matcher(r9)
            boolean r9 = r2.matches()
            if (r9 != 0) goto L_0x02e0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "Invalid font-size: '"
            r2.append(r7)
            r2.append(r6)
            java.lang.String r6 = "'."
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "WebvttCssParser"
            com.google.android.gms.internal.ads.zzfk.zzf(r6, r2)
            r2 = 0
            goto L_0x033f
        L_0x02e0:
            java.lang.String r6 = r2.group(r7)
            if (r6 == 0) goto L_0x0338
            int r9 = r6.hashCode()
            switch(r9) {
                case 37: goto L_0x0303;
                case 3240: goto L_0x02f9;
                case 3592: goto L_0x02ef;
                default: goto L_0x02ee;
            }
        L_0x02ee:
            goto L_0x030d
        L_0x02ef:
            java.lang.String r9 = "px"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x030d
            r6 = 0
            goto L_0x030e
        L_0x02f9:
            java.lang.String r9 = "em"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x030d
            r6 = r10
            goto L_0x030e
        L_0x0303:
            java.lang.String r9 = "%"
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x030d
            r6 = r7
            goto L_0x030e
        L_0x030d:
            r6 = -1
        L_0x030e:
            switch(r6) {
                case 0: goto L_0x0322;
                case 1: goto L_0x031d;
                case 2: goto L_0x0317;
                default: goto L_0x0311;
            }
        L_0x0311:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0317:
            r6 = 3
            r3.zzn(r6)
            goto L_0x0325
        L_0x031d:
            r3.zzn(r7)
            goto L_0x0325
        L_0x0322:
            r3.zzn(r10)
        L_0x0325:
            java.lang.String r2 = r2.group(r10)
            if (r2 == 0) goto L_0x0335
            float r2 = java.lang.Float.parseFloat(r2)
            r3.zzm(r2)
            r2 = 0
            goto L_0x033f
        L_0x0335:
            r2 = 0
            throw r2
        L_0x0338:
            r2 = 0
            throw r2
        L_0x033a:
            r2 = 0
            goto L_0x033f
        L_0x033c:
            r2 = 0
            goto L_0x033f
        L_0x033e:
            r2 = r9
        L_0x033f:
            r9 = r2
            r2 = 0
            r6 = -1
            goto L_0x0139
        L_0x0344:
            boolean r2 = r7.equals(r5)
            if (r2 == 0) goto L_0x0351
            r1.add(r3)
            r2 = 0
            goto L_0x0031
        L_0x0351:
            r2 = 0
            goto L_0x0031
        L_0x0354:
            return r1
        L_0x0355:
            r2 = 0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanc.zzb(com.google.android.gms.internal.ads.zzfu):java.util.List");
    }
}
