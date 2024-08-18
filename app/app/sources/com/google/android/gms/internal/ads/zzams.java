package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzams {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzamy zzf;
    public final String zzg;
    public final String zzh;
    public final zzams zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzams zzb(String str, long j, long j2, zzamy zzamy, String[] strArr, String str2, String str3, zzams zzams) {
        return new zzams(str, (String) null, j, j2, zzamy, strArr, str2, str3, zzams);
    }

    public static zzams zzc(String str) {
        return new zzams((String) null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, (zzamy) null, (String[]) null, "", (String) null, (zzams) null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzeg zzeg = new zzeg();
            zzeg.zzl(new SpannableStringBuilder());
            map.put(str, zzeg);
        }
        CharSequence zzq = ((zzeg) map.get(str)).zzq();
        if (zzq != null) {
            return (SpannableStringBuilder) zzq;
        }
        throw null;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z || equals || (equals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzams zzams = (zzams) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !equals) {
                    z2 = false;
                }
                zzams.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (!zzg(j) || !"div".equals(this.zza) || (str2 = this.zzh) == null) {
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzk(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d9, code lost:
        com.google.android.gms.internal.ads.zzfk.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0154, code lost:
        if (r14 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0156, code lost:
        r3 = new java.util.ArrayDeque();
        r3.push(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0162, code lost:
        if (r3.isEmpty() != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0164, code lost:
        r6 = (com.google.android.gms.internal.ads.zzams) r3.pop();
        r7 = com.google.android.gms.internal.ads.zzamx.zza(r6.zzf, r6.zzj, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0172, code lost:
        if (r7 == null) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0179, code lost:
        if (r7.zzg() != 3) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x017d, code lost:
        r7 = r6.zza() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0185, code lost:
        if (r7 < 0) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0187, code lost:
        r3.push(r6.zzd(r7));
        r7 = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0192, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0193, code lost:
        if (r6 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019a, code lost:
        if (r6.zza() != 1) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a3, code lost:
        if (r6.zzd(0).zzb == null) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        r3 = r6.zzd(0).zzb;
        r7 = com.google.android.gms.internal.ads.zzgd.zza;
        r6 = com.google.android.gms.internal.ads.zzamx.zza(r6.zzf, r6.zzj, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01b5, code lost:
        if (r6 == null) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01b7, code lost:
        r15 = r6.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01bc, code lost:
        r15 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01be, code lost:
        if (r15 != -1) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c0, code lost:
        r6 = com.google.android.gms.internal.ads.zzamx.zza(r14.zzf, r14.zzj, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c8, code lost:
        if (r6 == null) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ca, code lost:
        r15 = r6.zzf();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01ce, code lost:
        r13.setSpan(new com.google.android.gms.internal.ads.zzen(r3, r15), r5, r2, 33);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzl(long r18, java.util.Map r20, java.util.Map r21, java.lang.String r22, java.util.Map r23) {
        /*
            r17 = this;
            r0 = r17
            r8 = r20
            boolean r1 = r17.zzg(r18)
            if (r1 != 0) goto L_0x000c
            goto L_0x0290
        L_0x000c:
            java.lang.String r1 = r0.zzg
            java.lang.String r2 = ""
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x001a
            java.lang.String r1 = r0.zzg
            r9 = r1
            goto L_0x001c
        L_0x001a:
            r9 = r22
        L_0x001c:
            java.util.HashMap r1 = r0.zzl
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0271
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.util.HashMap r5 = r0.zzk
            boolean r5 = r5.containsKey(r4)
            if (r5 == 0) goto L_0x004d
            java.util.HashMap r5 = r0.zzk
            java.lang.Object r5 = r5.get(r4)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r5 == r2) goto L_0x026b
            r10 = r23
            java.lang.Object r4 = r10.get(r4)
            com.google.android.gms.internal.ads.zzeg r4 = (com.google.android.gms.internal.ads.zzeg) r4
            if (r4 == 0) goto L_0x0269
            r11 = r21
            java.lang.Object r7 = r11.get(r9)
            com.google.android.gms.internal.ads.zzamw r7 = (com.google.android.gms.internal.ads.zzamw) r7
            if (r7 == 0) goto L_0x0266
            com.google.android.gms.internal.ads.zzamy r12 = r0.zzf
            java.lang.String[] r13 = r0.zzj
            com.google.android.gms.internal.ads.zzamy r12 = com.google.android.gms.internal.ads.zzamx.zza(r12, r13, r8)
            java.lang.CharSequence r13 = r4.zzq()
            android.text.SpannableStringBuilder r13 = (android.text.SpannableStringBuilder) r13
            if (r13 != 0) goto L_0x0086
            android.text.SpannableStringBuilder r13 = new android.text.SpannableStringBuilder
            r13.<init>()
            r4.zzl(r13)
        L_0x0086:
            if (r12 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzams r14 = r0.zzi
            int r15 = r12.zzh()
            r3 = -1
            r6 = 33
            if (r15 == r3) goto L_0x009f
            android.text.style.StyleSpan r15 = new android.text.style.StyleSpan
            int r3 = r12.zzh()
            r15.<init>(r3)
            r13.setSpan(r15, r5, r2, r6)
        L_0x009f:
            boolean r3 = r12.zzI()
            if (r3 == 0) goto L_0x00ad
            android.text.style.StrikethroughSpan r3 = new android.text.style.StrikethroughSpan
            r3.<init>()
            r13.setSpan(r3, r5, r2, r6)
        L_0x00ad:
            boolean r3 = r12.zzJ()
            if (r3 == 0) goto L_0x00bb
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            r13.setSpan(r3, r5, r2, r6)
        L_0x00bb:
            boolean r3 = r12.zzH()
            if (r3 == 0) goto L_0x00cd
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            int r15 = r12.zzd()
            r3.<init>(r15)
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r6)
        L_0x00cd:
            boolean r3 = r12.zzG()
            if (r3 == 0) goto L_0x00df
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            int r15 = r12.zzc()
            r3.<init>(r15)
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r6)
        L_0x00df:
            java.lang.String r3 = r12.zzD()
            if (r3 == 0) goto L_0x00f1
            android.text.style.TypefaceSpan r3 = new android.text.style.TypefaceSpan
            java.lang.String r15 = r12.zzD()
            r3.<init>(r15)
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r6)
        L_0x00f1:
            com.google.android.gms.internal.ads.zzamr r3 = r12.zzk()
            if (r3 == 0) goto L_0x0127
            com.google.android.gms.internal.ads.zzamr r3 = r12.zzk()
            if (r3 == 0) goto L_0x0124
            int r6 = r3.zza
            r15 = -1
            if (r6 != r15) goto L_0x0111
            int r6 = r7.zzj
            r7 = 2
            if (r6 == r7) goto L_0x010e
            r7 = 1
            if (r6 != r7) goto L_0x010c
            r6 = 3
            goto L_0x010f
        L_0x010c:
            r6 = 1
            goto L_0x010f
        L_0x010e:
            r6 = 3
        L_0x010f:
            r7 = 1
            goto L_0x0113
        L_0x0111:
            int r7 = r3.zzb
        L_0x0113:
            int r3 = r3.zzc
            r15 = -2
            if (r3 != r15) goto L_0x0119
            r3 = 1
        L_0x0119:
            com.google.android.gms.internal.ads.zzep r15 = new com.google.android.gms.internal.ads.zzep
            r15.<init>(r6, r7, r3)
            r3 = 33
            com.google.android.gms.internal.ads.zzeo.zza(r13, r15, r5, r2, r3)
            goto L_0x0127
        L_0x0124:
            r1 = 0
            throw r1
        L_0x0127:
            int r3 = r12.zzg()
            switch(r3) {
                case 2: goto L_0x013c;
                case 3: goto L_0x0130;
                case 4: goto L_0x0130;
                default: goto L_0x012e;
            }
        L_0x012e:
            goto L_0x01e1
        L_0x0130:
            com.google.android.gms.internal.ads.zzamq r3 = new com.google.android.gms.internal.ads.zzamq
            r3.<init>()
            r6 = 33
            r13.setSpan(r3, r5, r2, r6)
            goto L_0x01e1
        L_0x013c:
        L_0x013d:
            if (r14 == 0) goto L_0x0153
            com.google.android.gms.internal.ads.zzamy r3 = r14.zzf
            java.lang.String[] r6 = r14.zzj
            com.google.android.gms.internal.ads.zzamy r3 = com.google.android.gms.internal.ads.zzamx.zza(r3, r6, r8)
            if (r3 == 0) goto L_0x0150
            int r3 = r3.zzg()
            r6 = 1
            if (r3 == r6) goto L_0x0154
        L_0x0150:
            com.google.android.gms.internal.ads.zzams r14 = r14.zzi
            goto L_0x013d
        L_0x0153:
            r14 = 0
        L_0x0154:
            if (r14 == 0) goto L_0x01e1
            java.util.ArrayDeque r3 = new java.util.ArrayDeque
            r3.<init>()
            r3.push(r14)
        L_0x015e:
            boolean r6 = r3.isEmpty()
            if (r6 != 0) goto L_0x0192
            java.lang.Object r6 = r3.pop()
            com.google.android.gms.internal.ads.zzams r6 = (com.google.android.gms.internal.ads.zzams) r6
            com.google.android.gms.internal.ads.zzamy r7 = r6.zzf
            java.lang.String[] r15 = r6.zzj
            com.google.android.gms.internal.ads.zzamy r7 = com.google.android.gms.internal.ads.zzamx.zza(r7, r15, r8)
            if (r7 == 0) goto L_0x017c
            int r7 = r7.zzg()
            r15 = 3
            if (r7 != r15) goto L_0x017d
            goto L_0x0193
        L_0x017c:
            r15 = 3
        L_0x017d:
            int r7 = r6.zza()
            r16 = -1
            int r7 = r7 + -1
        L_0x0185:
            if (r7 < 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzams r15 = r6.zzd(r7)
            r3.push(r15)
            int r7 = r7 + -1
            r15 = 3
            goto L_0x0185
        L_0x0192:
            r6 = 0
        L_0x0193:
            if (r6 == 0) goto L_0x01e1
            int r3 = r6.zza()
            r7 = 1
            if (r3 != r7) goto L_0x01d9
            r3 = 0
            com.google.android.gms.internal.ads.zzams r7 = r6.zzd(r3)
            java.lang.String r7 = r7.zzb
            if (r7 == 0) goto L_0x01d9
            com.google.android.gms.internal.ads.zzams r3 = r6.zzd(r3)
            java.lang.String r3 = r3.zzb
            int r7 = com.google.android.gms.internal.ads.zzgd.zza
            com.google.android.gms.internal.ads.zzamy r7 = r6.zzf
            java.lang.String[] r6 = r6.zzj
            com.google.android.gms.internal.ads.zzamy r6 = com.google.android.gms.internal.ads.zzamx.zza(r7, r6, r8)
            if (r6 == 0) goto L_0x01bc
            int r15 = r6.zzf()
            goto L_0x01bd
        L_0x01bc:
            r15 = -1
        L_0x01bd:
            r6 = -1
            if (r15 != r6) goto L_0x01ce
            com.google.android.gms.internal.ads.zzamy r6 = r14.zzf
            java.lang.String[] r7 = r14.zzj
            com.google.android.gms.internal.ads.zzamy r6 = com.google.android.gms.internal.ads.zzamx.zza(r6, r7, r8)
            if (r6 == 0) goto L_0x01ce
            int r15 = r6.zzf()
        L_0x01ce:
            com.google.android.gms.internal.ads.zzen r6 = new com.google.android.gms.internal.ads.zzen
            r6.<init>(r3, r15)
            r3 = 33
            r13.setSpan(r6, r5, r2, r3)
            goto L_0x01e1
        L_0x01d9:
            java.lang.String r3 = "TtmlRenderUtil"
            java.lang.String r6 = "Skipping rubyText node without exactly one text child."
            com.google.android.gms.internal.ads.zzfk.zze(r3, r6)
        L_0x01e1:
            boolean r3 = r12.zzF()
            if (r3 == 0) goto L_0x01f1
            com.google.android.gms.internal.ads.zzem r3 = new com.google.android.gms.internal.ads.zzem
            r3.<init>()
            r6 = 33
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r6)
        L_0x01f1:
            int r3 = r12.zze()
            r6 = 1120403456(0x42c80000, float:100.0)
            switch(r3) {
                case 1: goto L_0x021a;
                case 2: goto L_0x020b;
                case 3: goto L_0x01fb;
                default: goto L_0x01fa;
            }
        L_0x01fa:
            goto L_0x022a
        L_0x01fb:
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r7 = r12.zza()
            float r7 = r7 / r6
            r3.<init>(r7)
            r7 = 33
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r7)
            goto L_0x022a
        L_0x020b:
            r7 = 33
            android.text.style.RelativeSizeSpan r3 = new android.text.style.RelativeSizeSpan
            float r14 = r12.zza()
            r3.<init>(r14)
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r7)
            goto L_0x022a
        L_0x021a:
            r7 = 33
            android.text.style.AbsoluteSizeSpan r3 = new android.text.style.AbsoluteSizeSpan
            float r14 = r12.zza()
            int r14 = (int) r14
            r15 = 1
            r3.<init>(r14, r15)
            com.google.android.gms.internal.ads.zzeo.zza(r13, r3, r5, r2, r7)
        L_0x022a:
            java.lang.String r2 = r0.zza
            java.lang.String r3 = "p"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0026
            float r2 = r12.zzb()
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x024a
            float r2 = r12.zzb()
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            float r2 = r2 * r3
            float r2 = r2 / r6
            r4.zzj(r2)
        L_0x024a:
            android.text.Layout$Alignment r2 = r12.zzj()
            if (r2 == 0) goto L_0x0257
            android.text.Layout$Alignment r2 = r12.zzj()
            r4.zzm(r2)
        L_0x0257:
            android.text.Layout$Alignment r2 = r12.zzi()
            if (r2 == 0) goto L_0x0026
            android.text.Layout$Alignment r2 = r12.zzi()
            r4.zzg(r2)
            goto L_0x0026
        L_0x0266:
            r1 = 0
            throw r1
        L_0x0269:
            r1 = 0
            throw r1
        L_0x026b:
            r11 = r21
            r10 = r23
            goto L_0x0026
        L_0x0271:
            r11 = r21
            r10 = r23
            r3 = 0
            r12 = r3
        L_0x0277:
            int r1 = r17.zza()
            if (r12 >= r1) goto L_0x0290
            com.google.android.gms.internal.ads.zzams r1 = r0.zzd(r12)
            r2 = r18
            r4 = r20
            r5 = r21
            r6 = r9
            r7 = r23
            r1.zzl(r2, r4, r5, r6, r7)
            int r12 = r12 + 1
            goto L_0x0277
        L_0x0290:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzams.zzl(long, java.util.Map, java.util.Map, java.lang.String, java.util.Map):void");
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        boolean z2;
        Map map2 = map;
        this.zzk.clear();
        this.zzl.clear();
        if (!"metadata".equals(this.zza)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            if (this.zzc && z) {
                SpannableStringBuilder zzi2 = zzi(str2, map2);
                String str3 = this.zzb;
                if (str3 != null) {
                    zzi2.append(str3);
                    return;
                }
                throw null;
            } else if ("br".equals(this.zza) && z) {
                zzi(str2, map2).append(10);
            } else if (zzg(j)) {
                for (Map.Entry entry : map.entrySet()) {
                    HashMap hashMap = this.zzk;
                    String str4 = (String) entry.getKey();
                    CharSequence zzq = ((zzeg) entry.getValue()).zzq();
                    if (zzq != null) {
                        hashMap.put(str4, Integer.valueOf(zzq.length()));
                    } else {
                        throw null;
                    }
                }
                boolean equals = "p".equals(this.zza);
                for (int i = 0; i < zza(); i++) {
                    zzams zzd2 = zzd(i);
                    if (!z) {
                        z2 = equals;
                    } else {
                        z2 = true;
                    }
                    zzd2.zzm(j, z2, str2, map);
                }
                if (equals) {
                    SpannableStringBuilder zzi3 = zzi(str2, map2);
                    int length = zzi3.length() - 1;
                    while (length >= 0 && zzi3.charAt(length) == ' ') {
                        length--;
                    }
                    if (length >= 0 && zzi3.charAt(length) != 10) {
                        zzi3.append(10);
                    }
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    HashMap hashMap2 = this.zzl;
                    String str5 = (String) entry2.getKey();
                    CharSequence zzq2 = ((zzeg) entry2.getValue()).zzq();
                    if (zzq2 != null) {
                        hashMap2.put(str5, Integer.valueOf(zzq2.length()));
                    } else {
                        throw null;
                    }
                }
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzams zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzams) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        zzk(j, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        long j2 = j;
        zzm(j2, false, this.zzg, treeMap);
        zzl(j2, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Pair pair = (Pair) arrayList.get(i3);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                zzamw zzamw = (zzamw) map2.get(pair.first);
                if (zzamw != null) {
                    zzeg zzeg = new zzeg();
                    zzeg.zzc(decodeByteArray);
                    zzeg.zzh(zzamw.zzb);
                    zzeg.zzi(0);
                    zzeg.zze(zzamw.zzc, 0);
                    zzeg.zzf(zzamw.zze);
                    zzeg.zzk(zzamw.zzf);
                    zzeg.zzd(zzamw.zzg);
                    zzeg.zzo(zzamw.zzj);
                    arrayList2.add(zzeg.zzp());
                } else {
                    throw null;
                }
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzamw zzamw2 = (zzamw) map2.get(entry.getKey());
            if (zzamw2 != null) {
                zzeg zzeg2 = (zzeg) entry.getValue();
                CharSequence zzq = zzeg2.zzq();
                if (zzq != null) {
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzq;
                    for (zzamq zzamq : (zzamq[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzamq.class)) {
                        spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzamq), spannableStringBuilder.getSpanEnd(zzamq), "");
                    }
                    int i4 = 0;
                    while (i4 < spannableStringBuilder.length()) {
                        int i5 = i4 + 1;
                        if (spannableStringBuilder.charAt(i4) == ' ') {
                            int i6 = i5;
                            while (i6 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i6) == ' ') {
                                i6++;
                            }
                            int i7 = i6 - i5;
                            if (i7 > 0) {
                                spannableStringBuilder.delete(i4, i7 + i4);
                            }
                        }
                        i4 = i5;
                    }
                    if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(0) != ' ') {
                        i = 0;
                    } else {
                        spannableStringBuilder.delete(0, 1);
                        i = 0;
                    }
                    while (i < spannableStringBuilder.length() - 1) {
                        int i8 = i + 1;
                        if (spannableStringBuilder.charAt(i) == 10 && spannableStringBuilder.charAt(i8) == ' ') {
                            spannableStringBuilder.delete(i8, i + 2);
                        }
                        i = i8;
                    }
                    if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != ' ') {
                        i2 = 0;
                    } else {
                        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                        i2 = 0;
                    }
                    while (i2 < spannableStringBuilder.length() - 1) {
                        int i9 = i2 + 1;
                        if (spannableStringBuilder.charAt(i2) == ' ' && spannableStringBuilder.charAt(i9) == 10) {
                            spannableStringBuilder.delete(i2, i9);
                        }
                        i2 = i9;
                    }
                    if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
                        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                    }
                    zzeg2.zze(zzamw2.zzc, zzamw2.zzd);
                    zzeg2.zzf(zzamw2.zze);
                    zzeg2.zzh(zzamw2.zzb);
                    zzeg2.zzk(zzamw2.zzf);
                    zzeg2.zzn(zzamw2.zzi, zzamw2.zzh);
                    zzeg2.zzo(zzamw2.zzj);
                    arrayList2.add(zzeg2.zzp());
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }
        return arrayList2;
    }

    public final void zzf(zzams zzams) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzams);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i <= 0 && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 == -9223372036854775807L && j < this.zze) {
            return true;
        }
        if (i <= 0) {
            return j < this.zze;
        }
        return false;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    private zzams(String str, String str2, long j, long j2, zzamy zzamy, String[] strArr, String str3, String str4, zzams zzams) {
        boolean z;
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzamy;
        this.zzj = strArr;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        this.zzc = z;
        this.zzd = j;
        this.zze = j2;
        if (str3 != null) {
            this.zzg = str3;
            this.zzi = zzams;
            this.zzk = new HashMap();
            this.zzl = new HashMap();
            return;
        }
        throw null;
    }
}
