package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.animation.core.AnimationKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaml implements zzalv {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzamk zzc;
    private final zzfu zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaml() {
        this((List) null);
    }

    private static float zzb(int i) {
        switch (i) {
            case 0:
                return 0.05f;
            case 1:
                return 0.5f;
            case 2:
                return 0.95f;
            default:
                return -3.4028235E38f;
        }
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            } else if (((Long) list.get(size)).longValue() == j) {
                return size;
            } else {
                if (((Long) list.get(size)).longValue() < j) {
                    i = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i = zzgd.zza;
        return (Long.parseLong(group) * 3600000000L) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(matcher.group(3)) * AnimationKt.MillisToNanos) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r3.equals("playresx") != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze(com.google.android.gms.internal.ads.zzfu r7, java.nio.charset.Charset r8) {
        /*
            r6 = this;
        L_0x0001:
            java.lang.String r0 = r7.zzy(r8)
            if (r0 == 0) goto L_0x00e7
            java.lang.String r1 = "[Script Info]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            r2 = 91
            if (r1 == 0) goto L_0x0078
        L_0x0011:
            java.lang.String r0 = r7.zzy(r8)
            if (r0 == 0) goto L_0x0001
            int r1 = r7.zzb()
            if (r1 == 0) goto L_0x0023
            char r1 = r7.zza(r8)
            if (r1 == r2) goto L_0x0001
        L_0x0023:
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r3 = 2
            if (r1 != r3) goto L_0x0011
            r1 = 0
            r3 = r0[r1]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfxm.zza(r3)
            int r4 = r3.hashCode()
            r5 = 1
            switch(r4) {
                case 1879649548: goto L_0x004d;
                case 1879649549: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x0056
        L_0x0042:
            java.lang.String r1 = "playresy"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0041
            r1 = r5
            goto L_0x0057
        L_0x004d:
            java.lang.String r4 = "playresx"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0041
            goto L_0x0057
        L_0x0056:
            r1 = -1
        L_0x0057:
            switch(r1) {
                case 0: goto L_0x0068;
                case 1: goto L_0x005b;
                default: goto L_0x005a;
            }
        L_0x005a:
            goto L_0x0011
        L_0x005b:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0076 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0076 }
            r6.zzg = r0     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0011
        L_0x0068:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0076 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0076 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0076 }
            r6.zzf = r0     // Catch:{ NumberFormatException -> 0x0076 }
            goto L_0x0011
        L_0x0076:
            r0 = move-exception
            goto L_0x0011
        L_0x0078:
            java.lang.String r1 = "[V4+ Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            java.lang.String r3 = "SsaParser"
            if (r1 == 0) goto L_0x00ce
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1 = 0
        L_0x0089:
            java.lang.String r4 = r7.zzy(r8)
            if (r4 == 0) goto L_0x00ca
            int r5 = r7.zzb()
            if (r5 == 0) goto L_0x009b
            char r5 = r7.zza(r8)
            if (r5 == r2) goto L_0x00ca
        L_0x009b:
            java.lang.String r5 = "Format:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x00a9
            com.google.android.gms.internal.ads.zzamm r1 = com.google.android.gms.internal.ads.zzamm.zza(r4)
            goto L_0x0089
        L_0x00a9:
            java.lang.String r5 = "Style:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0089
            if (r1 != 0) goto L_0x00be
            java.lang.String r5 = "Skipping 'Style:' line before 'Format:' line: "
            java.lang.String r4 = r5.concat(r4)
            com.google.android.gms.internal.ads.zzfk.zzf(r3, r4)
            goto L_0x0089
        L_0x00be:
            com.google.android.gms.internal.ads.zzamo r4 = com.google.android.gms.internal.ads.zzamo.zzb(r4, r1)
            if (r4 == 0) goto L_0x0089
            java.lang.String r5 = r4.zza
            r0.put(r5, r4)
            goto L_0x0089
        L_0x00ca:
            r6.zze = r0
            goto L_0x0001
        L_0x00ce:
            java.lang.String r1 = "[V4 Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x00de
            java.lang.String r0 = "[V4 Styles] are not supported"
            com.google.android.gms.internal.ads.zzfk.zze(r3, r0)
            goto L_0x0001
        L_0x00de:
            java.lang.String r1 = "[Events]"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0001
        L_0x00e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaml.zze(com.google.android.gms.internal.ads.zzfu, java.nio.charset.Charset):void");
    }

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        zzamk zzamk;
        zzfu zzfu;
        Charset charset;
        zzamk zzamk2;
        long j;
        int i3;
        Layout.Alignment alignment;
        int i4;
        Integer num;
        int i5;
        zzaml zzaml = this;
        int i6 = i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzaml.zzd.zzI(bArr, i6 + i2);
        zzaml.zzd.zzK(i6);
        Charset zzB = zzaml.zzd.zzB();
        if (zzB == null) {
            zzB = zzfxs.zzc;
        }
        if (!zzaml.zzb) {
            zzaml.zze(zzaml.zzd, zzB);
        }
        zzfu zzfu2 = zzaml.zzd;
        zzamk zzamk3 = zzaml.zzb ? zzaml.zzc : null;
        while (true) {
            String zzy = zzfu2.zzy(zzB);
            if (zzy == null) {
                int i7 = 0;
                while (i7 < arrayList.size()) {
                    List list = (List) arrayList.get(i7);
                    if (list.isEmpty()) {
                        if (i7 != 0) {
                            zzev zzev2 = zzev;
                            i7++;
                        } else {
                            i7 = 0;
                        }
                    }
                    if (i7 != arrayList.size() - 1) {
                        zzev.zza(new zzaln(list, ((Long) arrayList2.get(i7)).longValue(), ((Long) arrayList2.get(i7 + 1)).longValue() - ((Long) arrayList2.get(i7)).longValue()));
                        i7++;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return;
            } else if (zzy.startsWith("Format:")) {
                zzamk2 = zzamk.zza(zzy);
            } else {
                if (!zzy.startsWith("Dialogue:")) {
                    charset = zzB;
                    zzfu = zzfu2;
                    zzamk = zzamk3;
                } else if (zzamk3 == null) {
                    zzfk.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(zzy));
                    charset = zzB;
                    zzfu = zzfu2;
                    zzamk = zzamk3;
                } else {
                    zzeq.zzd(zzy.startsWith("Dialogue:"));
                    String[] split = zzy.substring(9).split(",", zzamk3.zze);
                    if (split.length != zzamk3.zze) {
                        zzfk.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(zzy));
                        charset = zzB;
                        zzfu = zzfu2;
                        zzamk = zzamk3;
                    } else {
                        long zzd2 = zzd(split[zzamk3.zza]);
                        if (zzd2 == -9223372036854775807L) {
                            zzfk.zzf("SsaParser", "Skipping invalid timing: ".concat(zzy));
                            charset = zzB;
                            zzfu = zzfu2;
                            zzamk = zzamk3;
                        } else {
                            String[] strArr = split;
                            long zzd3 = zzd(split[zzamk3.zzb]);
                            if (zzd3 == -9223372036854775807L) {
                                zzfk.zzf("SsaParser", "Skipping invalid timing: ".concat(zzy));
                                charset = zzB;
                                zzfu = zzfu2;
                                zzamk = zzamk3;
                            } else {
                                Map map = zzaml.zze;
                                zzamo zzamo = (map == null || (i5 = zzamk3.zzc) == -1) ? null : (zzamo) map.get(strArr[i5].trim());
                                String str = strArr[zzamk3.zzd];
                                zzamn zza2 = zzamn.zza(str);
                                String replace = zzamn.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                float f = zzaml.zzf;
                                float f2 = zzaml.zzg;
                                SpannableString spannableString = new SpannableString(replace);
                                zzeg zzeg = new zzeg();
                                zzeg.zzl(spannableString);
                                charset = zzB;
                                if (zzamo != null) {
                                    Integer num2 = zzamo.zzc;
                                    zzfu = zzfu2;
                                    if (num2 != null) {
                                        zzamk = zzamk3;
                                        j = zzd3;
                                        spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                    } else {
                                        zzamk = zzamk3;
                                        j = zzd3;
                                    }
                                    if (zzamo.zzj == 3 && (num = zzamo.zzd) != null) {
                                        spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                    }
                                    float f3 = zzamo.zze;
                                    if (!(f3 == -3.4028235E38f || f2 == -3.4028235E38f)) {
                                        zzeg.zzn(f3 / f2, 1);
                                    }
                                    if (zzamo.zzf) {
                                        if (zzamo.zzg) {
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                            i3 = 2;
                                        } else {
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            i3 = 2;
                                        }
                                    } else if (zzamo.zzg) {
                                        i3 = 2;
                                        spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                    } else {
                                        i3 = 2;
                                    }
                                    if (zzamo.zzh) {
                                        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
                                    }
                                    if (zzamo.zzi) {
                                        spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
                                    }
                                } else {
                                    zzfu = zzfu2;
                                    zzamk = zzamk3;
                                    j = zzd3;
                                    i3 = 2;
                                }
                                int i8 = zza2.zza;
                                if (i8 == -1) {
                                    i8 = zzamo != null ? zzamo.zzb : -1;
                                }
                                switch (i8) {
                                    case -1:
                                        alignment = null;
                                        break;
                                    case 1:
                                    case 4:
                                    case 7:
                                        alignment = Layout.Alignment.ALIGN_NORMAL;
                                        break;
                                    case 2:
                                    case 5:
                                    case 8:
                                        alignment = Layout.Alignment.ALIGN_CENTER;
                                        break;
                                    case 3:
                                    case 6:
                                    case 9:
                                        alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                        break;
                                    default:
                                        zzfk.zzf("SsaParser", "Unknown alignment: " + i8);
                                        alignment = null;
                                        break;
                                }
                                zzeg.zzm(alignment);
                                int i9 = Integer.MIN_VALUE;
                                switch (i8) {
                                    case -1:
                                        i4 = Integer.MIN_VALUE;
                                        break;
                                    case 1:
                                    case 4:
                                    case 7:
                                        i4 = 0;
                                        break;
                                    case 2:
                                    case 5:
                                    case 8:
                                        i4 = 1;
                                        break;
                                    case 3:
                                    case 6:
                                    case 9:
                                        i4 = i3;
                                        break;
                                    default:
                                        zzfk.zzf("SsaParser", "Unknown alignment: " + i8);
                                        i4 = Integer.MIN_VALUE;
                                        break;
                                }
                                zzeg.zzi(i4);
                                switch (i8) {
                                    case -1:
                                        break;
                                    case 1:
                                    case 2:
                                    case 3:
                                        i9 = i3;
                                        break;
                                    case 4:
                                    case 5:
                                    case 6:
                                        i9 = 1;
                                        break;
                                    case 7:
                                    case 8:
                                    case 9:
                                        i9 = 0;
                                        break;
                                    default:
                                        zzfk.zzf("SsaParser", "Unknown alignment: " + i8);
                                        break;
                                }
                                zzeg.zzf(i9);
                                PointF pointF = zza2.zzb;
                                if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                    zzeg.zzh(zzb(zzeg.zzb()));
                                    zzeg.zze(zzb(zzeg.zza()), 0);
                                } else {
                                    zzeg.zzh(pointF.x / f);
                                    zzeg.zze(zza2.zzb.y / f2, 0);
                                }
                                zzei zzp = zzeg.zzp();
                                int zzc2 = zzc(j, arrayList2, arrayList);
                                for (int zzc3 = zzc(zzd2, arrayList2, arrayList); zzc3 < zzc2; zzc3++) {
                                    ((List) arrayList.get(zzc3)).add(zzp);
                                }
                            }
                        }
                    }
                }
                zzaml = this;
                zzB = charset;
                zzfu2 = zzfu;
                zzamk2 = zzamk;
            }
        }
    }

    public zzaml(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzfu();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String zzA = zzgd.zzA((byte[]) list.get(0));
        zzeq.zzd(zzA.startsWith("Format:"));
        zzamk zza2 = zzamk.zza(zzA);
        if (zza2 != null) {
            this.zzc = zza2;
            zze(new zzfu((byte[]) list.get(1)), zzfxs.zzc);
            return;
        }
        throw null;
    }
}
