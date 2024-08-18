package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzadn implements zzaea {
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20};
    private static final zzadm zzc = new zzadm(new zzadj());
    private static final zzadm zzd = new zzadm(new zzadk());
    private zzgbc zze;
    private final zzalt zzf = new zzalo();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x03c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzadu[] zza(android.net.Uri r25, java.util.Map r26) {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x03d6 }
            r2 = 20
            r0.<init>(r2)     // Catch:{ all -> 0x03d6 }
            java.lang.String r3 = "Content-Type"
            r4 = r26
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x03d6 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x03d6 }
            r4 = 0
            if (r3 == 0) goto L_0x0026
            boolean r5 = r3.isEmpty()     // Catch:{ all -> 0x03d6 }
            if (r5 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x03d6 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x03d6 }
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            r7 = 16
            r8 = 7
            r9 = 5
            r10 = 4
            r11 = 3
            r12 = 19
            r13 = 14
            r14 = 13
            r15 = 12
            r16 = 11
            r17 = 9
            r18 = 6
            r19 = 15
            r20 = 1
            r21 = 10
            r22 = 8
            r4 = -1
            if (r3 != 0) goto L_0x0049
            r3 = r4
            goto L_0x01df
        L_0x0049:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzcg.zze(r3)     // Catch:{ all -> 0x03d6 }
            int r23 = r3.hashCode()     // Catch:{ all -> 0x03d6 }
            switch(r23) {
                case -2123537834: goto L_0x019f;
                case -1662384011: goto L_0x0195;
                case -1662384007: goto L_0x018a;
                case -1662095187: goto L_0x0180;
                case -1606874997: goto L_0x0175;
                case -1487464690: goto L_0x016a;
                case -1487394660: goto L_0x015f;
                case -1487018032: goto L_0x0154;
                case -1248337486: goto L_0x0149;
                case -1079884372: goto L_0x013d;
                case -1004728940: goto L_0x0131;
                case -879272239: goto L_0x0125;
                case -879258763: goto L_0x0119;
                case -387023398: goto L_0x010d;
                case -43467528: goto L_0x0102;
                case 13915911: goto L_0x00f6;
                case 187078296: goto L_0x00eb;
                case 187078297: goto L_0x00e0;
                case 187078669: goto L_0x00d5;
                case 187090232: goto L_0x00c9;
                case 187091926: goto L_0x00be;
                case 187099443: goto L_0x00b2;
                case 1331848029: goto L_0x00a7;
                case 1503095341: goto L_0x009c;
                case 1504578661: goto L_0x0090;
                case 1504619009: goto L_0x0085;
                case 1504824762: goto L_0x0079;
                case 1504831518: goto L_0x006d;
                case 1505118770: goto L_0x0062;
                case 2039520277: goto L_0x0056;
                default: goto L_0x0054;
            }     // Catch:{ all -> 0x03d6 }
        L_0x0054:
            goto L_0x01a9
        L_0x0056:
            java.lang.String r5 = "video/x-matroska"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r21
            goto L_0x01aa
        L_0x0062:
            java.lang.String r5 = "audio/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r14
            goto L_0x01aa
        L_0x006d:
            java.lang.String r5 = "audio/mpeg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r19
            goto L_0x01aa
        L_0x0079:
            java.lang.String r5 = "audio/midi"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r17
            goto L_0x01aa
        L_0x0085:
            java.lang.String r5 = "audio/flac"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r8
            goto L_0x01aa
        L_0x0090:
            java.lang.String r5 = "audio/eac3"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r20
            goto L_0x01aa
        L_0x009c:
            java.lang.String r5 = "audio/3gpp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r9
            goto L_0x01aa
        L_0x00a7:
            java.lang.String r5 = "video/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r7
            goto L_0x01aa
        L_0x00b2:
            java.lang.String r5 = "audio/wav"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 22
            goto L_0x01aa
        L_0x00be:
            java.lang.String r5 = "audio/ogg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r12
            goto L_0x01aa
        L_0x00c9:
            java.lang.String r5 = "audio/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 17
            goto L_0x01aa
        L_0x00d5:
            java.lang.String r5 = "audio/amr"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r10
            goto L_0x01aa
        L_0x00e0:
            java.lang.String r5 = "audio/ac4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r11
            goto L_0x01aa
        L_0x00eb:
            java.lang.String r5 = "audio/ac3"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 0
            goto L_0x01aa
        L_0x00f6:
            java.lang.String r5 = "video/x-flv"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r22
            goto L_0x01aa
        L_0x0102:
            java.lang.String r5 = "application/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r13
            goto L_0x01aa
        L_0x010d:
            java.lang.String r5 = "audio/x-matroska"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r16
            goto L_0x01aa
        L_0x0119:
            java.lang.String r5 = "image/png"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 26
            goto L_0x01aa
        L_0x0125:
            java.lang.String r5 = "image/bmp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 28
            goto L_0x01aa
        L_0x0131:
            java.lang.String r5 = "text/vtt"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 23
            goto L_0x01aa
        L_0x013d:
            java.lang.String r5 = "video/x-msvideo"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 25
            goto L_0x01aa
        L_0x0149:
            java.lang.String r5 = "application/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 18
            goto L_0x01aa
        L_0x0154:
            java.lang.String r5 = "image/webp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 27
            goto L_0x01aa
        L_0x015f:
            java.lang.String r5 = "image/jpeg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 24
            goto L_0x01aa
        L_0x016a:
            java.lang.String r5 = "image/heif"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 29
            goto L_0x01aa
        L_0x0175:
            java.lang.String r5 = "audio/amr-wb"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r18
            goto L_0x01aa
        L_0x0180:
            java.lang.String r5 = "video/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r15
            goto L_0x01aa
        L_0x018a:
            java.lang.String r5 = "video/mp2t"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 21
            goto L_0x01aa
        L_0x0195:
            java.lang.String r5 = "video/mp2p"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = r2
            goto L_0x01aa
        L_0x019f:
            java.lang.String r5 = "audio/eac3-joc"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x03d6 }
            if (r3 == 0) goto L_0x0054
            r3 = 2
            goto L_0x01aa
        L_0x01a9:
            r3 = r4
        L_0x01aa:
            switch(r3) {
                case 0: goto L_0x01de;
                case 1: goto L_0x01de;
                case 2: goto L_0x01de;
                case 3: goto L_0x01db;
                case 4: goto L_0x01d9;
                case 5: goto L_0x01d9;
                case 6: goto L_0x01d9;
                case 7: goto L_0x01d7;
                case 8: goto L_0x01d5;
                case 9: goto L_0x01d2;
                case 10: goto L_0x01cf;
                case 11: goto L_0x01cf;
                case 12: goto L_0x01cf;
                case 13: goto L_0x01cf;
                case 14: goto L_0x01cf;
                case 15: goto L_0x01cd;
                case 16: goto L_0x01ca;
                case 17: goto L_0x01ca;
                case 18: goto L_0x01ca;
                case 19: goto L_0x01c7;
                case 20: goto L_0x01c4;
                case 21: goto L_0x01c1;
                case 22: goto L_0x01bf;
                case 23: goto L_0x01bd;
                case 24: goto L_0x01bb;
                case 25: goto L_0x01b9;
                case 26: goto L_0x01b6;
                case 27: goto L_0x01b3;
                case 28: goto L_0x01b1;
                case 29: goto L_0x01af;
                default: goto L_0x01ad;
            }     // Catch:{ all -> 0x03d6 }
        L_0x01ad:
            r3 = r4
            goto L_0x01df
        L_0x01af:
            r3 = r2
            goto L_0x01df
        L_0x01b1:
            r3 = r12
            goto L_0x01df
        L_0x01b3:
            r3 = 18
            goto L_0x01df
        L_0x01b6:
            r3 = 17
            goto L_0x01df
        L_0x01b9:
            r3 = r7
            goto L_0x01df
        L_0x01bb:
            r3 = r13
            goto L_0x01df
        L_0x01bd:
            r3 = r14
            goto L_0x01df
        L_0x01bf:
            r3 = r15
            goto L_0x01df
        L_0x01c1:
            r3 = r16
            goto L_0x01df
        L_0x01c4:
            r3 = r21
            goto L_0x01df
        L_0x01c7:
            r3 = r17
            goto L_0x01df
        L_0x01ca:
            r3 = r22
            goto L_0x01df
        L_0x01cd:
            r3 = r8
            goto L_0x01df
        L_0x01cf:
            r3 = r18
            goto L_0x01df
        L_0x01d2:
            r3 = r19
            goto L_0x01df
        L_0x01d5:
            r3 = r9
            goto L_0x01df
        L_0x01d7:
            r3 = r10
            goto L_0x01df
        L_0x01d9:
            r3 = r11
            goto L_0x01df
        L_0x01db:
            r3 = r20
            goto L_0x01df
        L_0x01de:
            r3 = 0
        L_0x01df:
            if (r3 == r4) goto L_0x01e4
            r1.zzb(r3, r0)     // Catch:{ all -> 0x03d6 }
        L_0x01e4:
            java.lang.String r5 = r25.getLastPathSegment()     // Catch:{ all -> 0x03d6 }
            if (r5 != 0) goto L_0x01ed
            r5 = r4
            goto L_0x03a4
        L_0x01ed:
            java.lang.String r6 = ".ac3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x03a3
            java.lang.String r6 = ".ec3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0200
            r5 = 0
            goto L_0x03a4
        L_0x0200:
            java.lang.String r6 = ".ac4"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x020c
            r5 = r20
            goto L_0x03a4
        L_0x020c:
            java.lang.String r6 = ".adts"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x03a1
            java.lang.String r6 = ".aac"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x021f
            r5 = 2
            goto L_0x03a4
        L_0x021f:
            java.lang.String r6 = ".amr"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x022a
            r5 = r11
            goto L_0x03a4
        L_0x022a:
            java.lang.String r6 = ".flac"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0235
            r5 = r10
            goto L_0x03a4
        L_0x0235:
            java.lang.String r6 = ".flv"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0240
            r5 = r9
            goto L_0x03a4
        L_0x0240:
            java.lang.String r6 = ".mid"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x039e
            java.lang.String r6 = ".midi"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x039e
            java.lang.String r6 = ".smf"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x025c
            r5 = r19
            goto L_0x03a4
        L_0x025c:
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            java.lang.String r9 = ".mk"
            int r6 = r6 + -4
            boolean r6 = r5.startsWith(r9, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x039b
            java.lang.String r6 = ".webm"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0276
            r5 = r18
            goto L_0x03a4
        L_0x0276:
            java.lang.String r6 = ".mp3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0281
            r5 = r8
            goto L_0x03a4
        L_0x0281:
            java.lang.String r6 = ".mp4"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0398
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + -4
            java.lang.String r8 = ".m4"
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0398
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            java.lang.String r8 = ".mp4"
            int r6 = r6 + -5
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0398
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + -5
            java.lang.String r8 = ".cmf"
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x02b7
            r5 = r22
            goto L_0x03a4
        L_0x02b7:
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + -4
            java.lang.String r8 = ".og"
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0395
            java.lang.String r6 = ".opus"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x02d1
            r5 = r17
            goto L_0x03a4
        L_0x02d1:
            java.lang.String r6 = ".ps"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0392
            java.lang.String r6 = ".mpeg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0392
            java.lang.String r6 = ".mpg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0392
            java.lang.String r6 = ".m2p"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x02f5
            r5 = r21
            goto L_0x03a4
        L_0x02f5:
            java.lang.String r6 = ".ts"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x038f
            int r6 = r5.length()     // Catch:{ all -> 0x03d6 }
            int r6 = r6 + -4
            java.lang.String r8 = ".ts"
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x030f
            r5 = r16
            goto L_0x03a4
        L_0x030f:
            java.lang.String r6 = ".wav"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x038d
            java.lang.String r6 = ".wave"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0322
            r5 = r15
            goto L_0x03a4
        L_0x0322:
            java.lang.String r6 = ".vtt"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x038b
            java.lang.String r6 = ".webvtt"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0335
            r5 = r14
            goto L_0x03a4
        L_0x0335:
            java.lang.String r6 = ".jpg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0389
            java.lang.String r6 = ".jpeg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0348
            r5 = r13
            goto L_0x03a4
        L_0x0348:
            java.lang.String r6 = ".avi"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0353
            r5 = r7
            goto L_0x03a4
        L_0x0353:
            java.lang.String r6 = ".png"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x035e
            r5 = 17
            goto L_0x03a4
        L_0x035e:
            java.lang.String r6 = ".webp"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x0369
            r5 = 18
            goto L_0x03a4
        L_0x0369:
            java.lang.String r6 = ".bmp"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 != 0) goto L_0x0387
            java.lang.String r6 = ".dib"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r6 == 0) goto L_0x037b
            r5 = r12
            goto L_0x03a4
        L_0x037b:
            java.lang.String r6 = ".heic"
            boolean r5 = r5.endsWith(r6)     // Catch:{ all -> 0x03d6 }
            if (r5 == 0) goto L_0x0385
            r5 = r2
            goto L_0x03a4
        L_0x0385:
            r5 = r4
            goto L_0x03a4
        L_0x0387:
            r5 = r12
            goto L_0x03a4
        L_0x0389:
            r5 = r13
            goto L_0x03a4
        L_0x038b:
            r5 = r14
            goto L_0x03a4
        L_0x038d:
            r5 = r15
            goto L_0x03a4
        L_0x038f:
            r5 = r16
            goto L_0x03a4
        L_0x0392:
            r5 = r21
            goto L_0x03a4
        L_0x0395:
            r5 = r17
            goto L_0x03a4
        L_0x0398:
            r5 = r22
            goto L_0x03a4
        L_0x039b:
            r5 = r18
            goto L_0x03a4
        L_0x039e:
            r5 = r19
            goto L_0x03a4
        L_0x03a1:
            r5 = 2
            goto L_0x03a4
        L_0x03a3:
            r5 = 0
        L_0x03a4:
            if (r5 == r4) goto L_0x03ab
            if (r5 == r3) goto L_0x03ab
            r1.zzb(r5, r0)     // Catch:{ all -> 0x03d6 }
        L_0x03ab:
            int[] r4 = zzb     // Catch:{ all -> 0x03d6 }
            r6 = 0
        L_0x03ae:
            if (r6 >= r2) goto L_0x03bc
            r7 = r4[r6]     // Catch:{ all -> 0x03d6 }
            if (r7 == r3) goto L_0x03b9
            if (r7 == r5) goto L_0x03b9
            r1.zzb(r7, r0)     // Catch:{ all -> 0x03d6 }
        L_0x03b9:
            int r6 = r6 + 1
            goto L_0x03ae
        L_0x03bc:
            int r2 = r0.size()     // Catch:{ all -> 0x03d6 }
            com.google.android.gms.internal.ads.zzadu[] r2 = new com.google.android.gms.internal.ads.zzadu[r2]     // Catch:{ all -> 0x03d6 }
            r4 = 0
        L_0x03c3:
            int r3 = r0.size()     // Catch:{ all -> 0x03d6 }
            if (r4 >= r3) goto L_0x03d4
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x03d6 }
            com.google.android.gms.internal.ads.zzadu r3 = (com.google.android.gms.internal.ads.zzadu) r3     // Catch:{ all -> 0x03d6 }
            r2[r4] = r3     // Catch:{ all -> 0x03d6 }
            int r4 = r4 + 1
            goto L_0x03c3
        L_0x03d4:
            monitor-exit(r24)
            return r2
        L_0x03d6:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadn.zza(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzadu[]");
    }

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzanr());
                return;
            case 1:
                list.add(new zzanu());
                return;
            case 2:
                list.add(new zzanx(0));
                return;
            case 3:
                list.add(new zzafi(0));
                return;
            case 4:
                zzadu zza = zzc.zza(0);
                if (zza != null) {
                    list.add(zza);
                    return;
                } else {
                    list.add(new zzaga(0));
                    return;
                }
            case 5:
                list.add(new zzagd());
                return;
            case 6:
                list.add(new zzaiy(this.zzf, 2));
                return;
            case 7:
                list.add(new zzajg(0));
                return;
            case 8:
                list.add(new zzakd(this.zzf, 32));
                list.add(new zzakj(this.zzf, 16));
                return;
            case 9:
                list.add(new zzala());
                return;
            case 10:
                list.add(new zzapa());
                return;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgbc.zzm();
                }
                list.add(new zzapk(1, 1, this.zzf, new zzgb(0), new zzanz(0, this.zze), 112800));
                return;
            case 12:
                list.add(new zzapw());
                return;
            case 14:
                list.add(new zzagj(0));
                return;
            case 15:
                zzadu zza2 = zzd.zza(new Object[0]);
                if (zza2 != null) {
                    list.add(zza2);
                    return;
                }
                return;
            case 16:
                list.add(new zzafn(1, this.zzf));
                return;
            case 17:
                list.add(new zzall());
                return;
            case 18:
                list.add(new zzaqb());
                return;
            case 19:
                list.add(new zzafu());
                return;
            case 20:
                list.add(new zzagi());
                return;
            default:
                return;
        }
    }
}
