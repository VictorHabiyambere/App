package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanl {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(hashMap2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ec, code lost:
        if (r11.equals("i") != false) goto L_0x0104;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.text.SpannedString zza(java.lang.String r17, java.lang.String r18, java.util.List r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder
            r3.<init>()
            java.util.ArrayDeque r4 = new java.util.ArrayDeque
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            r7 = r6
        L_0x0017:
            int r8 = r18.length()
            if (r7 < r8) goto L_0x003d
        L_0x001d:
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x002d
            java.lang.Object r1 = r4.pop()
            com.google.android.gms.internal.ads.zzani r1 = (com.google.android.gms.internal.ads.zzani) r1
            zzg(r0, r1, r5, r3, r2)
            goto L_0x001d
        L_0x002d:
            com.google.android.gms.internal.ads.zzani r1 = com.google.android.gms.internal.ads.zzani.zzb()
            java.util.List r4 = java.util.Collections.emptyList()
            zzg(r0, r1, r4, r3, r2)
            android.text.SpannedString r0 = android.text.SpannedString.valueOf(r3)
            return r0
        L_0x003d:
            int r8 = r7 + 1
            char r9 = r1.charAt(r7)
            r11 = 62
            r12 = 2
            r13 = -1
            r14 = 1
            switch(r9) {
                case 38: goto L_0x014e;
                case 60: goto L_0x0050;
                default: goto L_0x004b;
            }
        L_0x004b:
            r3.append(r9)
            goto L_0x01df
        L_0x0050:
            int r9 = r18.length()
            if (r8 < r9) goto L_0x0058
            goto L_0x01df
        L_0x0058:
            char r9 = r1.charAt(r8)
            int r8 = r1.indexOf(r11, r8)
            if (r8 != r13) goto L_0x0067
            int r8 = r18.length()
            goto L_0x0069
        L_0x0067:
            int r8 = r8 + 1
        L_0x0069:
            int r11 = r8 + -2
            char r15 = r1.charAt(r11)
            r10 = 47
            if (r15 != r10) goto L_0x0075
            r15 = r14
            goto L_0x0076
        L_0x0075:
            r15 = r6
        L_0x0076:
            if (r9 != r10) goto L_0x007b
            r16 = r12
            goto L_0x007d
        L_0x007b:
            r16 = r14
        L_0x007d:
            int r7 = r7 + r16
            if (r15 == 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            int r11 = r8 + -1
        L_0x0084:
            java.lang.String r7 = r1.substring(r7, r11)
            java.lang.String r11 = r7.trim()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0094
            goto L_0x01df
        L_0x0094:
            java.lang.String r11 = r7.trim()
            boolean r16 = r11.isEmpty()
            r16 = r16 ^ 1
            com.google.android.gms.internal.ads.zzeq.zzd(r16)
            int r16 = com.google.android.gms.internal.ads.zzgd.zza
            java.lang.String r14 = "[ \\.]"
            java.lang.String[] r11 = r11.split(r14, r12)
            r11 = r11[r6]
            int r14 = r11.hashCode()
            switch(r14) {
                case 98: goto L_0x00f9;
                case 99: goto L_0x00ef;
                case 105: goto L_0x00e6;
                case 117: goto L_0x00dc;
                case 118: goto L_0x00d2;
                case 3650: goto L_0x00c8;
                case 3314158: goto L_0x00be;
                case 3511770: goto L_0x00b3;
                default: goto L_0x00b2;
            }
        L_0x00b2:
            goto L_0x0103
        L_0x00b3:
            java.lang.String r12 = "ruby"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 4
            goto L_0x0104
        L_0x00be:
            java.lang.String r12 = "lang"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 3
            goto L_0x0104
        L_0x00c8:
            java.lang.String r12 = "rt"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 5
            goto L_0x0104
        L_0x00d2:
            java.lang.String r12 = "v"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 7
            goto L_0x0104
        L_0x00dc:
            java.lang.String r12 = "u"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 6
            goto L_0x0104
        L_0x00e6:
            java.lang.String r14 = "i"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x00b2
            goto L_0x0104
        L_0x00ef:
            java.lang.String r12 = "c"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = 1
            goto L_0x0104
        L_0x00f9:
            java.lang.String r12 = "b"
            boolean r12 = r11.equals(r12)
            if (r12 == 0) goto L_0x00b2
            r12 = r6
            goto L_0x0104
        L_0x0103:
            r12 = r13
        L_0x0104:
            switch(r12) {
                case 0: goto L_0x0109;
                case 1: goto L_0x0109;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0109;
                case 5: goto L_0x0109;
                case 6: goto L_0x0109;
                case 7: goto L_0x0109;
                default: goto L_0x0107;
            }
        L_0x0107:
            goto L_0x01df
        L_0x0109:
            if (r9 != r10) goto L_0x013d
        L_0x010b:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x0113
            goto L_0x01df
        L_0x0113:
            java.lang.Object r7 = r4.pop()
            com.google.android.gms.internal.ads.zzani r7 = (com.google.android.gms.internal.ads.zzani) r7
            zzg(r0, r7, r5, r3, r2)
            boolean r9 = r4.isEmpty()
            if (r9 != 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzanh r9 = new com.google.android.gms.internal.ads.zzanh
            int r10 = r3.length()
            r12 = 0
            r9.<init>(r7, r10, r12)
            r5.add(r9)
            goto L_0x0133
        L_0x0130:
            r5.clear()
        L_0x0133:
            java.lang.String r7 = r7.zza
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x010b
            goto L_0x01df
        L_0x013d:
            if (r15 != 0) goto L_0x014c
            int r9 = r3.length()
            com.google.android.gms.internal.ads.zzani r7 = com.google.android.gms.internal.ads.zzani.zza(r7, r9)
            r4.push(r7)
            goto L_0x01df
        L_0x014c:
            goto L_0x01df
        L_0x014e:
            r7 = 59
            int r7 = r1.indexOf(r7, r8)
            r10 = 32
            int r14 = r1.indexOf(r10, r8)
            if (r7 != r13) goto L_0x015f
            r7 = r14
            goto L_0x0165
        L_0x015f:
            if (r14 == r13) goto L_0x0165
            int r7 = java.lang.Math.min(r7, r14)
        L_0x0165:
            if (r7 == r13) goto L_0x01dc
            java.lang.String r8 = r1.substring(r8, r7)
            int r9 = r8.hashCode()
            switch(r9) {
                case 3309: goto L_0x0192;
                case 3464: goto L_0x0188;
                case 96708: goto L_0x017e;
                case 3374865: goto L_0x0173;
                default: goto L_0x0172;
            }
        L_0x0172:
            goto L_0x019b
        L_0x0173:
            java.lang.String r9 = "nbsp"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0172
            r13 = r12
            goto L_0x019b
        L_0x017e:
            java.lang.String r9 = "amp"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0172
            r13 = 3
            goto L_0x019b
        L_0x0188:
            java.lang.String r9 = "lt"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0172
            r13 = r6
            goto L_0x019b
        L_0x0192:
            java.lang.String r9 = "gt"
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L_0x0172
            r13 = 1
        L_0x019b:
            switch(r13) {
                case 0: goto L_0x01cb;
                case 1: goto L_0x01c6;
                case 2: goto L_0x01c1;
                case 3: goto L_0x01ba;
                default: goto L_0x019e;
            }
        L_0x019e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "ignoring unsupported entity: '&"
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = ";'"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "WebvttCueParser"
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r8)
            goto L_0x01d1
        L_0x01ba:
            r8 = 38
            r3.append(r8)
            goto L_0x01d1
        L_0x01c1:
            r3.append(r10)
            goto L_0x01d1
        L_0x01c6:
            r3.append(r11)
            goto L_0x01d1
        L_0x01cb:
            r8 = 60
            r3.append(r8)
        L_0x01d1:
            if (r7 != r14) goto L_0x01d8
            java.lang.String r8 = " "
            r3.append(r8)
        L_0x01d8:
            int r7 = r7 + 1
            goto L_0x0017
        L_0x01dc:
            r3.append(r9)
        L_0x01df:
            r7 = r8
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanl.zza(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    static zzeg zzb(String str) {
        zzank zzank = new zzank();
        zzh(str, zzank);
        return zzank.zza();
    }

    public static zzane zzc(zzfu zzfu, List list) {
        String zzy = zzfu.zzy(zzfxs.zzc);
        if (zzy != null) {
            Matcher matcher = zza.matcher(zzy);
            if (matcher.matches()) {
                return zze((String) null, matcher, zzfu, list);
            }
            String zzy2 = zzfu.zzy(zzfxs.zzc);
            if (zzy2 != null) {
                Matcher matcher2 = zza.matcher(zzy2);
                if (matcher2.matches()) {
                    return zze(zzy.trim(), matcher2, zzfu, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, String str, zzani zzani) {
        List zzf = zzf(list, str, zzani);
        for (int i = 0; i < zzf.size(); i++) {
            zzand zzand = ((zzanj) zzf.get(i)).zzb;
            if (zzand.zze() != -1) {
                return zzand.zze();
            }
        }
        return -1;
    }

    private static zzane zze(String str, Matcher matcher, zzfu zzfu, List list) {
        zzank zzank = new zzank();
        try {
            String group = matcher.group(1);
            if (group != null) {
                zzank.zza = zzann.zzb(group);
                String group2 = matcher.group(2);
                if (group2 != null) {
                    zzank.zzb = zzann.zzb(group2);
                    String group3 = matcher.group(3);
                    if (group3 != null) {
                        zzh(group3, zzank);
                        StringBuilder sb = new StringBuilder();
                        String zzy = zzfu.zzy(zzfxs.zzc);
                        while (!TextUtils.isEmpty(zzy)) {
                            if (sb.length() > 0) {
                                sb.append("\n");
                            }
                            sb.append(zzy.trim());
                            zzy = zzfu.zzy(zzfxs.zzc);
                        }
                        zzank.zzc = zza(str, sb.toString(), list);
                        return new zzane(zzank.zza().zzp(), zzank.zza, zzank.zzb);
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        } catch (NumberFormatException e) {
            zzfk.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, String str, zzani zzani) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzand zzand = (zzand) list.get(i);
            int zzf = zzand.zzf(str, zzani.zza, zzani.zzd, zzani.zzc);
            if (zzf > 0) {
                arrayList.add(new zzanj(zzf, zzand));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzg(java.lang.String r17, com.google.android.gms.internal.ads.zzani r18, java.util.List r19, android.text.SpannableStringBuilder r20, java.util.List r21) {
        /*
            r0 = r17
            r1 = r18
            r2 = r20
            r3 = r21
            int r4 = r1.zzb
            int r5 = r20.length()
            java.lang.String r6 = r1.zza
            int r7 = r6.hashCode()
            r8 = 2
            r10 = -1
            switch(r7) {
                case 0: goto L_0x0061;
                case 98: goto L_0x0057;
                case 99: goto L_0x004d;
                case 105: goto L_0x0043;
                case 117: goto L_0x0039;
                case 118: goto L_0x002f;
                case 3314158: goto L_0x0025;
                case 3511770: goto L_0x001a;
                default: goto L_0x0019;
            }
        L_0x0019:
            goto L_0x006b
        L_0x001a:
            java.lang.String r7 = "ruby"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = r8
            goto L_0x006c
        L_0x0025:
            java.lang.String r7 = "lang"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 5
            goto L_0x006c
        L_0x002f:
            java.lang.String r7 = "v"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 6
            goto L_0x006c
        L_0x0039:
            java.lang.String r7 = "u"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 3
            goto L_0x006c
        L_0x0043:
            java.lang.String r7 = "i"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 1
            goto L_0x006c
        L_0x004d:
            java.lang.String r7 = "c"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 4
            goto L_0x006c
        L_0x0057:
            java.lang.String r7 = "b"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 0
            goto L_0x006c
        L_0x0061:
            java.lang.String r7 = ""
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0019
            r6 = 7
            goto L_0x006c
        L_0x006b:
            r6 = r10
        L_0x006c:
            r7 = 33
            switch(r6) {
                case 0: goto L_0x0148;
                case 1: goto L_0x013f;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00bf;
                case 4: goto L_0x0073;
                case 5: goto L_0x0151;
                case 6: goto L_0x0151;
                case 7: goto L_0x0151;
                default: goto L_0x0071;
            }
        L_0x0071:
            goto L_0x0209
        L_0x0073:
            java.util.Set r6 = r1.zzd
            java.util.Iterator r6 = r6.iterator()
        L_0x0079:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0151
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            java.util.Map r12 = zzc
            boolean r12 = r12.containsKey(r8)
            if (r12 == 0) goto L_0x00a2
            java.util.Map r12 = zzc
            java.lang.Object r8 = r12.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            android.text.style.ForegroundColorSpan r12 = new android.text.style.ForegroundColorSpan
            r12.<init>(r8)
            r2.setSpan(r12, r4, r5, r7)
            goto L_0x0079
        L_0x00a2:
            java.util.Map r12 = zzd
            boolean r12 = r12.containsKey(r8)
            if (r12 == 0) goto L_0x0079
            java.util.Map r12 = zzd
            java.lang.Object r8 = r12.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            android.text.style.BackgroundColorSpan r12 = new android.text.style.BackgroundColorSpan
            r12.<init>(r8)
            r2.setSpan(r12, r4, r5, r7)
            goto L_0x0079
        L_0x00bf:
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r2.setSpan(r6, r4, r5, r7)
            goto L_0x0151
        L_0x00c9:
            int r6 = zzd(r3, r0, r1)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r12 = r19.size()
            r8.<init>(r12)
            r12 = r19
            r8.addAll(r12)
            java.util.Comparator r12 = com.google.android.gms.internal.ads.zzanh.zza
            java.util.Collections.sort(r8, r12)
            int r12 = r1.zzb
            r13 = 0
            r14 = 0
        L_0x00e6:
            int r15 = r8.size()
            if (r13 >= r15) goto L_0x0151
            java.lang.Object r15 = r8.get(r13)
            com.google.android.gms.internal.ads.zzanh r15 = (com.google.android.gms.internal.ads.zzanh) r15
            com.google.android.gms.internal.ads.zzani r15 = r15.zzb
            java.lang.String r15 = r15.zza
            java.lang.String r9 = "rt"
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x013b
            java.lang.Object r9 = r8.get(r13)
            com.google.android.gms.internal.ads.zzanh r9 = (com.google.android.gms.internal.ads.zzanh) r9
            com.google.android.gms.internal.ads.zzani r15 = r9.zzb
            int r15 = zzd(r3, r0, r15)
            if (r15 == r10) goto L_0x0111
            goto L_0x0116
        L_0x0111:
            if (r6 == r10) goto L_0x0115
            r15 = r6
            goto L_0x0116
        L_0x0115:
            r15 = 1
        L_0x0116:
            com.google.android.gms.internal.ads.zzani r10 = r9.zzb
            int r10 = r10.zzb
            int r10 = r10 - r14
            int r9 = r9.zzc
            int r9 = r9 - r14
            java.lang.CharSequence r16 = r2.subSequence(r10, r9)
            r2.delete(r10, r9)
            com.google.android.gms.internal.ads.zzen r9 = new com.google.android.gms.internal.ads.zzen
            java.lang.String r11 = r16.toString()
            r9.<init>(r11, r15)
            r2.setSpan(r9, r12, r10, r7)
            int r9 = r16.length()
            int r14 = r14 + r9
            r12 = r10
        L_0x013b:
            int r13 = r13 + 1
            r10 = -1
            goto L_0x00e6
        L_0x013f:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r8)
            r2.setSpan(r6, r4, r5, r7)
            goto L_0x0151
        L_0x0148:
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r8 = 1
            r6.<init>(r8)
            r2.setSpan(r6, r4, r5, r7)
        L_0x0151:
            java.util.List r0 = zzf(r3, r0, r1)
            r9 = 0
        L_0x0156:
            int r1 = r0.size()
            if (r9 >= r1) goto L_0x0209
            java.lang.Object r1 = r0.get(r9)
            com.google.android.gms.internal.ads.zzanj r1 = (com.google.android.gms.internal.ads.zzanj) r1
            com.google.android.gms.internal.ads.zzand r1 = r1.zzb
            if (r1 != 0) goto L_0x016a
            r6 = -1
            r10 = 1
            goto L_0x0205
        L_0x016a:
            int r3 = r1.zzg()
            r6 = -1
            if (r3 == r6) goto L_0x017d
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            int r8 = r1.zzg()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
        L_0x017d:
            boolean r3 = r1.zzz()
            if (r3 == 0) goto L_0x018b
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            r2.setSpan(r3, r4, r5, r7)
        L_0x018b:
            boolean r3 = r1.zzy()
            if (r3 == 0) goto L_0x019d
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            int r8 = r1.zzc()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
        L_0x019d:
            boolean r3 = r1.zzx()
            if (r3 == 0) goto L_0x01af
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r8 = r1.zzb()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
        L_0x01af:
            java.lang.String r3 = r1.zzr()
            if (r3 == 0) goto L_0x01c1
            android.text.style.TypefaceSpan r3 = new android.text.style.TypefaceSpan
            java.lang.String r8 = r1.zzr()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
        L_0x01c1:
            int r3 = r1.zzd()
            switch(r3) {
                case 1: goto L_0x01e9;
                case 2: goto L_0x01db;
                case 3: goto L_0x01ca;
                default: goto L_0x01c8;
            }
        L_0x01c8:
            r10 = 1
            goto L_0x01f7
        L_0x01ca:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r8 = r1.zza()
            r10 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 / r10
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
            r10 = 1
            goto L_0x01f7
        L_0x01db:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r8 = r1.zza()
            r3.<init>(r8)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
            r10 = 1
            goto L_0x01f7
        L_0x01e9:
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r8 = r1.zza()
            int r8 = (int) r8
            r10 = 1
            r3.<init>(r8, r10)
            com.google.android.gms.internal.ads.zzeo.zza(r2, r3, r4, r5, r7)
        L_0x01f7:
            boolean r1 = r1.zzw()
            if (r1 == 0) goto L_0x0205
            com.google.android.gms.internal.ads.zzem r1 = new com.google.android.gms.internal.ads.zzem
            r1.<init>()
            r2.setSpan(r1, r4, r5, r7)
        L_0x0205:
            int r9 = r9 + 1
            goto L_0x0156
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanl.zzg(java.lang.String, com.google.android.gms.internal.ads.zzani, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01a3, code lost:
        if (r5.equals("end") != false) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00de, code lost:
        if (r5.equals("middle") != false) goto L_0x00ff;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzh(java.lang.String r18, com.google.android.gms.internal.ads.zzank r19) {
        /*
            r1 = r19
            java.lang.String r2 = "WebvttCueParser"
            java.util.regex.Pattern r0 = zzb
            r3 = r18
            java.util.regex.Matcher r3 = r0.matcher(r3)
        L_0x000c:
            boolean r0 = r3.find()
            if (r0 == 0) goto L_0x020b
            r0 = 1
            java.lang.String r4 = r3.group(r0)
            r5 = 0
            if (r4 == 0) goto L_0x0209
            r6 = 2
            java.lang.String r7 = r3.group(r6)
            if (r7 == 0) goto L_0x0207
            java.lang.String r5 = "line"
            boolean r5 = r5.equals(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r8 = "Invalid anchor value: "
            r9 = 44
            java.lang.String r11 = "start"
            java.lang.String r12 = "end"
            java.lang.String r13 = "middle"
            java.lang.String r14 = "center"
            r15 = 3
            r6 = -1
            r10 = 0
            if (r5 != 0) goto L_0x0181
            java.lang.String r5 = "align"
            boolean r5 = r5.equals(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            r16 = 5
            r17 = 4
            if (r5 != 0) goto L_0x0125
            java.lang.String r5 = "position"
            boolean r5 = r5.equals(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r5 != 0) goto L_0x00b3
            java.lang.String r5 = "size"
            boolean r5 = r5.equals(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r5 == 0) goto L_0x005b
            float r0 = com.google.android.gms.internal.ads.zzann.zza(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zzj = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x005b:
            java.lang.String r5 = "vertical"
            boolean r5 = r5.equals(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r5 != 0) goto L_0x0080
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01f3 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r5 = "Unknown cue setting "
            r0.append(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            r0.append(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r4 = ":"
            r0.append(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            r0.append(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x01f3 }
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x0080:
            int r4 = r7.hashCode()     // Catch:{ NumberFormatException -> 0x01f3 }
            switch(r4) {
                case 3462: goto L_0x0092;
                case 3642: goto L_0x0088;
                default: goto L_0x0087;
            }
        L_0x0087:
            goto L_0x009c
        L_0x0088:
            java.lang.String r4 = "rl"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x009c
            r6 = r10
            goto L_0x009d
        L_0x0092:
            java.lang.String r4 = "lr"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x009c
            r6 = r0
            goto L_0x009d
        L_0x009c:
        L_0x009d:
            switch(r6) {
                case 0: goto L_0x00a3;
                case 1: goto L_0x00a1;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            goto L_0x00a4
        L_0x00a1:
            r0 = 2
            goto L_0x00af
        L_0x00a3:
            goto L_0x00af
        L_0x00a4:
            java.lang.String r0 = "Invalid 'vertical' value: "
            java.lang.String r0 = r0.concat(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)     // Catch:{ NumberFormatException -> 0x01f3 }
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00af:
            r1.zzk = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x00b3:
            int r4 = r7.indexOf(r9)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r4 == r6) goto L_0x011c
            int r5 = r4 + 1
            java.lang.String r5 = r7.substring(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            int r9 = r5.hashCode()     // Catch:{ NumberFormatException -> 0x01f3 }
            switch(r9) {
                case -1842484672: goto L_0x00f4;
                case -1364013995: goto L_0x00ec;
                case -1276788989: goto L_0x00e1;
                case -1074341483: goto L_0x00da;
                case 100571: goto L_0x00d1;
                case 109757538: goto L_0x00c8;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            goto L_0x00fe
        L_0x00c8:
            boolean r9 = r5.equals(r11)
            if (r9 == 0) goto L_0x00c7
            r15 = r0
            goto L_0x00ff
        L_0x00d1:
            boolean r9 = r5.equals(r12)
            if (r9 == 0) goto L_0x00c7
            r15 = r16
            goto L_0x00ff
        L_0x00da:
            boolean r9 = r5.equals(r13)
            if (r9 == 0) goto L_0x00c7
            goto L_0x00ff
        L_0x00e1:
            java.lang.String r9 = "line-right"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x00c7
            r15 = r17
            goto L_0x00ff
        L_0x00ec:
            boolean r9 = r5.equals(r14)
            if (r9 == 0) goto L_0x00c7
            r15 = 2
            goto L_0x00ff
        L_0x00f4:
            java.lang.String r9 = "line-left"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x00c7
            r15 = r10
            goto L_0x00ff
        L_0x00fe:
            r15 = r6
        L_0x00ff:
            switch(r15) {
                case 0: goto L_0x0106;
                case 1: goto L_0x0106;
                case 2: goto L_0x0105;
                case 3: goto L_0x0105;
                case 4: goto L_0x0103;
                case 5: goto L_0x0103;
                default: goto L_0x0102;
            }
        L_0x0102:
            goto L_0x0108
        L_0x0103:
            r0 = 2
            goto L_0x0115
        L_0x0105:
            goto L_0x0115
        L_0x0106:
            r0 = r10
            goto L_0x0115
        L_0x0108:
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r0 = r8.concat(r0)     // Catch:{ NumberFormatException -> 0x01f3 }
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)     // Catch:{ NumberFormatException -> 0x01f3 }
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0115:
            r1.zzi = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r7 = r7.substring(r10, r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x011d
        L_0x011c:
        L_0x011d:
            float r0 = com.google.android.gms.internal.ads.zzann.zza(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zzh = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x0125:
            int r4 = r7.hashCode()     // Catch:{ NumberFormatException -> 0x01f3 }
            switch(r4) {
                case -1364013995: goto L_0x015b;
                case -1074341483: goto L_0x0153;
                case 100571: goto L_0x014a;
                case 3317767: goto L_0x0140;
                case 108511772: goto L_0x0135;
                case 109757538: goto L_0x012d;
                default: goto L_0x012c;
            }
        L_0x012c:
            goto L_0x0163
        L_0x012d:
            boolean r4 = r7.equals(r11)
            if (r4 == 0) goto L_0x0163
            r6 = r10
            goto L_0x0164
        L_0x0135:
            java.lang.String r4 = "right"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0163
            r6 = r16
            goto L_0x0164
        L_0x0140:
            java.lang.String r4 = "left"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0163
            r6 = r0
            goto L_0x0164
        L_0x014a:
            boolean r4 = r7.equals(r12)
            if (r4 == 0) goto L_0x0163
            r6 = r17
            goto L_0x0164
        L_0x0153:
            boolean r4 = r7.equals(r13)
            if (r4 == 0) goto L_0x0163
            r6 = r15
            goto L_0x0164
        L_0x015b:
            boolean r4 = r7.equals(r14)
            if (r4 == 0) goto L_0x0163
            r6 = 2
            goto L_0x0164
        L_0x0163:
        L_0x0164:
            switch(r6) {
                case 0: goto L_0x0172;
                case 1: goto L_0x016f;
                case 2: goto L_0x016d;
                case 3: goto L_0x016d;
                case 4: goto L_0x016b;
                case 5: goto L_0x0168;
                default: goto L_0x0167;
            }
        L_0x0167:
            goto L_0x0173
        L_0x0168:
            r0 = r16
            goto L_0x017d
        L_0x016b:
            r0 = r15
            goto L_0x017d
        L_0x016d:
            r0 = 2
            goto L_0x017d
        L_0x016f:
            r0 = r17
            goto L_0x017d
        L_0x0172:
            goto L_0x017d
        L_0x0173:
            java.lang.String r0 = "Invalid alignment value: "
            java.lang.String r0 = r0.concat(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x016d
        L_0x017d:
            r1.zzd = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x0181:
            int r4 = r7.indexOf(r9)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r4 == r6) goto L_0x01d5
            int r5 = r4 + 1
            java.lang.String r5 = r7.substring(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            int r9 = r5.hashCode()     // Catch:{ NumberFormatException -> 0x01f3 }
            switch(r9) {
                case -1364013995: goto L_0x01ae;
                case -1074341483: goto L_0x01a6;
                case 100571: goto L_0x019f;
                case 109757538: goto L_0x0196;
                default: goto L_0x0195;
            }
        L_0x0195:
            goto L_0x01b6
        L_0x0196:
            boolean r9 = r5.equals(r11)
            if (r9 == 0) goto L_0x0195
            r15 = r10
            goto L_0x01b7
        L_0x019f:
            boolean r9 = r5.equals(r12)
            if (r9 == 0) goto L_0x0195
            goto L_0x01b7
        L_0x01a6:
            boolean r9 = r5.equals(r13)
            if (r9 == 0) goto L_0x0195
            r15 = 2
            goto L_0x01b7
        L_0x01ae:
            boolean r9 = r5.equals(r14)
            if (r9 == 0) goto L_0x0195
            r15 = r0
            goto L_0x01b7
        L_0x01b6:
            r15 = r6
        L_0x01b7:
            switch(r15) {
                case 0: goto L_0x01bf;
                case 1: goto L_0x01bd;
                case 2: goto L_0x01bd;
                case 3: goto L_0x01bb;
                default: goto L_0x01ba;
            }
        L_0x01ba:
            goto L_0x01c1
        L_0x01bb:
            r6 = 2
            goto L_0x01ce
        L_0x01bd:
            r6 = r0
            goto L_0x01ce
        L_0x01bf:
            r6 = r10
            goto L_0x01ce
        L_0x01c1:
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r5 = r8.concat(r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r5)     // Catch:{ NumberFormatException -> 0x01f3 }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01ce:
            r1.zzg = r6     // Catch:{ NumberFormatException -> 0x01f3 }
            java.lang.String r7 = r7.substring(r10, r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x01d6
        L_0x01d5:
        L_0x01d6:
            java.lang.String r4 = "%"
            boolean r4 = r7.endsWith(r4)     // Catch:{ NumberFormatException -> 0x01f3 }
            if (r4 == 0) goto L_0x01e8
            float r0 = com.google.android.gms.internal.ads.zzann.zza(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zze = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zzf = r10     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x01e8:
            int r4 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01f3 }
            float r4 = (float) r4     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zze = r4     // Catch:{ NumberFormatException -> 0x01f3 }
            r1.zzf = r0     // Catch:{ NumberFormatException -> 0x01f3 }
            goto L_0x000c
        L_0x01f3:
            r0 = move-exception
            java.lang.String r0 = r3.group()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = "Skipping bad cue setting: "
            java.lang.String r0 = r4.concat(r0)
            com.google.android.gms.internal.ads.zzfk.zzf(r2, r0)
            goto L_0x000c
        L_0x0207:
            throw r5
        L_0x0209:
            throw r5
        L_0x020b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanl.zzh(java.lang.String, com.google.android.gms.internal.ads.zzank):void");
    }
}
