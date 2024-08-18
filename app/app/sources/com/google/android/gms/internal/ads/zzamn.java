package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamn {
    private static final Pattern zzc = Pattern.compile("\\{([^}]*)\\}");
    private static final Pattern zzd = Pattern.compile(String.format(Locale.US, "\\\\pos\\((%1$s),(%1$s)\\)", new Object[]{"\\s*\\d+(?:\\.\\d+)?\\s*"}));
    private static final Pattern zze = Pattern.compile(String.format(Locale.US, "\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", new Object[]{"\\s*\\d+(?:\\.\\d+)?\\s*"}));
    private static final Pattern zzf = Pattern.compile("\\\\an(\\d+)");
    public final int zza;
    public final PointF zzb;

    private zzamn(int i, PointF pointF) {
        this.zza = i;
        this.zzb = pointF;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ RuntimeException -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x000a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzamn zza(java.lang.String r12) {
        /*
            java.util.regex.Pattern r0 = zzc
            java.util.regex.Matcher r12 = r0.matcher(r12)
            r0 = 0
            r1 = -1
            r3 = r0
            r2 = r1
        L_0x000a:
            boolean r4 = r12.find()
            if (r4 == 0) goto L_0x00aa
            r4 = 1
            java.lang.String r5 = r12.group(r4)
            if (r5 == 0) goto L_0x00a8
            java.util.regex.Pattern r6 = zzd     // Catch:{ RuntimeException -> 0x0085 }
            java.util.regex.Matcher r6 = r6.matcher(r5)     // Catch:{ RuntimeException -> 0x0085 }
            java.util.regex.Pattern r7 = zze     // Catch:{ RuntimeException -> 0x0085 }
            java.util.regex.Matcher r7 = r7.matcher(r5)     // Catch:{ RuntimeException -> 0x0085 }
            boolean r8 = r6.find()     // Catch:{ RuntimeException -> 0x0085 }
            boolean r9 = r7.find()     // Catch:{ RuntimeException -> 0x0085 }
            r10 = 2
            if (r8 == 0) goto L_0x0055
            if (r9 == 0) goto L_0x004b
            java.lang.String r7 = "SsaStyle.Overrides"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0085 }
            r8.<init>()     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r9 = "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='"
            r8.append(r9)     // Catch:{ RuntimeException -> 0x0085 }
            r8.append(r5)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r9 = "'"
            r8.append(r9)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r8 = r8.toString()     // Catch:{ RuntimeException -> 0x0085 }
            com.google.android.gms.internal.ads.zzfk.zze(r7, r8)     // Catch:{ RuntimeException -> 0x0085 }
        L_0x004b:
            java.lang.String r7 = r6.group(r4)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r6 = r6.group(r10)     // Catch:{ RuntimeException -> 0x0085 }
            goto L_0x0062
        L_0x0055:
            if (r9 == 0) goto L_0x0080
            java.lang.String r6 = r7.group(r4)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r7 = r7.group(r10)     // Catch:{ RuntimeException -> 0x0085 }
            r11 = r7
            r7 = r6
            r6 = r11
        L_0x0062:
            android.graphics.PointF r8 = new android.graphics.PointF     // Catch:{ RuntimeException -> 0x0085 }
            if (r7 == 0) goto L_0x007e
            java.lang.String r7 = r7.trim()     // Catch:{ RuntimeException -> 0x0085 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ RuntimeException -> 0x0085 }
            if (r6 == 0) goto L_0x007c
            java.lang.String r6 = r6.trim()     // Catch:{ RuntimeException -> 0x0085 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ RuntimeException -> 0x0085 }
            r8.<init>(r7, r6)     // Catch:{ RuntimeException -> 0x0085 }
            goto L_0x0081
        L_0x007c:
            throw r0     // Catch:{ RuntimeException -> 0x0085 }
        L_0x007e:
            throw r0     // Catch:{ RuntimeException -> 0x0085 }
        L_0x0080:
            r8 = r0
        L_0x0081:
            if (r8 == 0) goto L_0x0086
            r3 = r8
            goto L_0x0086
        L_0x0085:
            r6 = move-exception
        L_0x0086:
            java.util.regex.Pattern r6 = zzf     // Catch:{ RuntimeException -> 0x00a5 }
            java.util.regex.Matcher r5 = r6.matcher(r5)     // Catch:{ RuntimeException -> 0x00a5 }
            boolean r6 = r5.find()     // Catch:{ RuntimeException -> 0x00a5 }
            if (r6 == 0) goto L_0x009f
            java.lang.String r4 = r5.group(r4)     // Catch:{ RuntimeException -> 0x00a5 }
            if (r4 == 0) goto L_0x009d
            int r4 = com.google.android.gms.internal.ads.zzamo.zzd(r4)     // Catch:{ RuntimeException -> 0x00a5 }
            goto L_0x00a0
        L_0x009d:
            throw r0     // Catch:{ RuntimeException -> 0x00a5 }
        L_0x009f:
            r4 = r1
        L_0x00a0:
            if (r4 == r1) goto L_0x000a
            r2 = r4
            goto L_0x000a
        L_0x00a5:
            r4 = move-exception
            goto L_0x000a
        L_0x00a8:
            throw r0
        L_0x00aa:
            com.google.android.gms.internal.ads.zzamn r12 = new com.google.android.gms.internal.ads.zzamn
            r12.<init>(r2, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamn.zza(java.lang.String):com.google.android.gms.internal.ads.zzamn");
    }

    public static String zzb(String str) {
        return zzc.matcher(str).replaceAll("");
    }
}
