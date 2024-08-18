package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwm implements zzaae, zzvd {
    final /* synthetic */ zzwr zza;
    /* access modifiers changed from: private */
    public final long zzb = zzvf.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzid zzd;
    private final zzwg zze;
    private final zzadx zzf;
    private final zzeu zzg;
    private final zzaeq zzh = new zzaeq();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzhh zzl = zzi(0);
    private zzafa zzm;
    private boolean zzn;

    public zzwm(zzwr zzwr, Uri uri, zzhb zzhb, zzwg zzwg, zzadx zzadx, zzeu zzeu) {
        this.zza = zzwr;
        this.zzc = uri;
        this.zzd = new zzid(zzhb);
        this.zze = zzwg;
        this.zzf = zzadx;
        this.zzg = zzeu;
    }

    static /* bridge */ /* synthetic */ void zzf(zzwm zzwm, long j, long j2) {
        zzwm.zzh.zza = j;
        zzwm.zzk = j2;
        zzwm.zzj = true;
        zzwm.zzn = false;
    }

    private final zzhh zzi(long j) {
        zzhf zzhf = new zzhf();
        zzhf.zzd(this.zzc);
        zzhf.zzc(j);
        zzhf.zza(6);
        zzhf.zzb(zzwr.zzb);
        return zzhf.zze();
    }

    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0234 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01f7 A[EDGE_INSN: B:124:0x01f7->B:106:0x01f7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e9 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f9 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0106 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0140 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017c A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0198 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a1 A[Catch:{ all -> 0x0217 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b1 A[SYNTHETIC, Splitter:B:85:0x01b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh() throws java.io.IOException {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "Invalid metadata interval: "
        L_0x0004:
            boolean r0 = r1.zzi
            if (r0 != 0) goto L_0x0234
            r3 = -1
            r5 = 1
            r6 = 0
            com.google.android.gms.internal.ads.zzaeq r0 = r1.zzh     // Catch:{ all -> 0x0217 }
            long r13 = r0.zza     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzhh r0 = r1.zzi(r13)     // Catch:{ all -> 0x0217 }
            r1.zzl = r0     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzhh r7 = r1.zzl     // Catch:{ all -> 0x0217 }
            long r7 = r0.zzb(r7)     // Catch:{ all -> 0x0217 }
            boolean r0 = r1.zzi     // Catch:{ all -> 0x0217 }
            if (r0 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze
            long r5 = r0.zzb()
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            com.google.android.gms.internal.ads.zzaeq r2 = r1.zzh
            long r3 = r0.zzb()
            r2.zza = r3
        L_0x0034:
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd
            com.google.android.gms.internal.ads.zzhd.zza(r0)
            return
        L_0x003a:
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x0046
            long r7 = r7 + r13
            com.google.android.gms.internal.ads.zzwr r0 = r1.zza     // Catch:{ all -> 0x0217 }
            r0.zzp.post(new com.google.android.gms.internal.ads.zzwh(r0))     // Catch:{ all -> 0x0217 }
            r15 = r7
            goto L_0x0047
        L_0x0046:
            r15 = r7
        L_0x0047:
            com.google.android.gms.internal.ads.zzwr r7 = r1.zza     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd     // Catch:{ all -> 0x0217 }
            java.util.Map r8 = r0.zze()     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = "icy-br"
            java.lang.Object r0 = r8.get(r0)     // Catch:{ all -> 0x0217 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0217 }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r0 == 0) goto L_0x0099
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0217 }
            r11 = r0
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0217 }
            int r0 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0086 }
            int r12 = r0 * 1000
            if (r12 <= 0) goto L_0x006f
            r0 = r5
            r18 = r12
            goto L_0x009c
        L_0x006f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0084 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x0084 }
            java.lang.String r3 = "Invalid bitrate: "
            r0.append(r3)     // Catch:{ NumberFormatException -> 0x0084 }
            r0.append(r11)     // Catch:{ NumberFormatException -> 0x0084 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x0084 }
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r0)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0099
        L_0x0084:
            r0 = move-exception
            goto L_0x0088
        L_0x0086:
            r0 = move-exception
            r12 = r10
        L_0x0088:
            java.lang.String r0 = "Invalid bitrate header: "
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = r0.concat(r3)     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r0)     // Catch:{ all -> 0x0217 }
            r0 = r6
            r18 = r12
            goto L_0x009c
        L_0x0099:
            r0 = r6
            r18 = r10
        L_0x009c:
            java.lang.String r3 = "icy-genre"
            java.lang.Object r3 = r8.get(r3)     // Catch:{ all -> 0x0217 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0217 }
            r4 = 0
            if (r3 == 0) goto L_0x00b1
            java.lang.Object r0 = r3.get(r6)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0217 }
            r19 = r0
            r0 = r5
            goto L_0x00b3
        L_0x00b1:
            r19 = r4
        L_0x00b3:
            java.lang.String r3 = "icy-name"
            java.lang.Object r3 = r8.get(r3)     // Catch:{ all -> 0x0217 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0217 }
            if (r3 == 0) goto L_0x00c7
            java.lang.Object r0 = r3.get(r6)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0217 }
            r20 = r0
            r0 = r5
            goto L_0x00c9
        L_0x00c7:
            r20 = r4
        L_0x00c9:
            java.lang.String r3 = "icy-url"
            java.lang.Object r3 = r8.get(r3)     // Catch:{ all -> 0x0217 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0217 }
            if (r3 == 0) goto L_0x00dd
            java.lang.Object r0 = r3.get(r6)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0217 }
            r21 = r0
            r0 = r5
            goto L_0x00df
        L_0x00dd:
            r21 = r4
        L_0x00df:
            java.lang.String r3 = "icy-pub"
            java.lang.Object r3 = r8.get(r3)     // Catch:{ all -> 0x0217 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0217 }
            if (r3 == 0) goto L_0x00f9
            java.lang.Object r0 = r3.get(r6)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0217 }
            java.lang.String r3 = "1"
            boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0217 }
            r22 = r0
            r3 = r5
            goto L_0x00fc
        L_0x00f9:
            r3 = r0
            r22 = r6
        L_0x00fc:
            java.lang.String r0 = "icy-metaint"
            java.lang.Object r0 = r8.get(r0)     // Catch:{ all -> 0x0217 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0217 }
            if (r0 == 0) goto L_0x013c
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0217 }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0217 }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x012c }
            if (r11 <= 0) goto L_0x0117
            r3 = r5
            r23 = r11
            goto L_0x013e
        L_0x0117:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x012a }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x012a }
            r0.append(r2)     // Catch:{ NumberFormatException -> 0x012a }
            r0.append(r8)     // Catch:{ NumberFormatException -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x012a }
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r0)     // Catch:{ NumberFormatException -> 0x012a }
            goto L_0x013c
        L_0x012a:
            r0 = move-exception
            goto L_0x012e
        L_0x012c:
            r0 = move-exception
            r11 = r10
        L_0x012e:
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0217 }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzfk.zzf(r9, r0)     // Catch:{ all -> 0x0217 }
            r23 = r11
            goto L_0x013e
        L_0x013c:
            r23 = r10
        L_0x013e:
            if (r3 == 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzaha r4 = new com.google.android.gms.internal.ads.zzaha     // Catch:{ all -> 0x0217 }
            r17 = r4
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0217 }
            goto L_0x0149
        L_0x0148:
        L_0x0149:
            r7.zzs = r4     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzwr r3 = r1.zza     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzaha r4 = r3.zzs     // Catch:{ all -> 0x0217 }
            if (r4 == 0) goto L_0x017c
            com.google.android.gms.internal.ads.zzaha r4 = r3.zzs     // Catch:{ all -> 0x0217 }
            int r4 = r4.zzf     // Catch:{ all -> 0x0217 }
            if (r4 == r10) goto L_0x017c
            com.google.android.gms.internal.ads.zzve r4 = new com.google.android.gms.internal.ads.zzve     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzaha r3 = r3.zzs     // Catch:{ all -> 0x0217 }
            int r3 = r3.zzf     // Catch:{ all -> 0x0217 }
            r4.<init>(r0, r3, r1)     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzwr r0 = r1.zza     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzafa r0 = r0.zzv()     // Catch:{ all -> 0x0217 }
            r1.zzm = r0     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzafa r0 = r1.zzm     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzan r3 = com.google.android.gms.internal.ads.zzwr.zzc     // Catch:{ all -> 0x0217 }
            r0.zzl(r3)     // Catch:{ all -> 0x0217 }
            r8 = r4
            goto L_0x017d
        L_0x017c:
            r8 = r0
        L_0x017d:
            com.google.android.gms.internal.ads.zzwg r7 = r1.zze     // Catch:{ all -> 0x0217 }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd     // Catch:{ all -> 0x0217 }
            java.util.Map r10 = r0.zze()     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzadx r0 = r1.zzf     // Catch:{ all -> 0x0217 }
            r11 = r13
            r3 = r13
            r13 = r15
            r15 = r0
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzwr r0 = r1.zza     // Catch:{ all -> 0x0217 }
            com.google.android.gms.internal.ads.zzaha r0 = r0.zzs     // Catch:{ all -> 0x0217 }
            if (r0 == 0) goto L_0x019d
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze     // Catch:{ all -> 0x0217 }
            r0.zzc()     // Catch:{ all -> 0x0217 }
        L_0x019d:
            boolean r0 = r1.zzj     // Catch:{ all -> 0x0217 }
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze     // Catch:{ all -> 0x0217 }
            long r7 = r1.zzk     // Catch:{ all -> 0x0217 }
            r0.zzf(r3, r7)     // Catch:{ all -> 0x0217 }
            r1.zzj = r6     // Catch:{ all -> 0x0217 }
            r13 = r3
            r3 = r6
            goto L_0x01af
        L_0x01ad:
            r13 = r3
            r3 = r6
        L_0x01af:
            if (r3 != 0) goto L_0x01f7
            boolean r0 = r1.zzi     // Catch:{ all -> 0x01f4 }
            if (r0 != 0) goto L_0x01f2
            com.google.android.gms.internal.ads.zzeu r0 = r1.zzg     // Catch:{ InterruptedException -> 0x01eb }
            r0.zza()     // Catch:{ InterruptedException -> 0x01eb }
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze     // Catch:{ all -> 0x01f4 }
            com.google.android.gms.internal.ads.zzaeq r4 = r1.zzh     // Catch:{ all -> 0x01f4 }
            int r3 = r0.zza(r4)     // Catch:{ all -> 0x01f4 }
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze     // Catch:{ all -> 0x01e8 }
            long r7 = r0.zzb()     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzwr r0 = r1.zza     // Catch:{ all -> 0x01e8 }
            long r9 = r0.zzj     // Catch:{ all -> 0x01e8 }
            long r9 = r9 + r13
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x01e7
            com.google.android.gms.internal.ads.zzeu r0 = r1.zzg     // Catch:{ all -> 0x01e8 }
            r0.zzc()     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzwr r0 = r1.zza     // Catch:{ all -> 0x01e8 }
            android.os.Handler r4 = r0.zzp     // Catch:{ all -> 0x01e8 }
            java.lang.Runnable r0 = r0.zzo     // Catch:{ all -> 0x01e8 }
            r4.post(r0)     // Catch:{ all -> 0x01e8 }
            r13 = r7
            goto L_0x01af
        L_0x01e7:
            goto L_0x01af
        L_0x01e8:
            r0 = move-exception
            r6 = r3
            goto L_0x0218
        L_0x01eb:
            r0 = move-exception
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01f4 }
            r0.<init>()     // Catch:{ all -> 0x01f4 }
            throw r0     // Catch:{ all -> 0x01f4 }
        L_0x01f2:
            r3 = r6
            goto L_0x01f7
        L_0x01f4:
            r0 = move-exception
            r6 = r3
            goto L_0x0218
        L_0x01f7:
            if (r3 != r5) goto L_0x01fa
            goto L_0x020f
        L_0x01fa:
            com.google.android.gms.internal.ads.zzwg r0 = r1.zze
            long r4 = r0.zzb()
            r6 = -1
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x020e
            com.google.android.gms.internal.ads.zzaeq r4 = r1.zzh
            long r5 = r0.zzb()
            r4.zza = r5
        L_0x020e:
            r6 = r3
        L_0x020f:
            com.google.android.gms.internal.ads.zzid r0 = r1.zzd
            com.google.android.gms.internal.ads.zzhd.zza(r0)
            if (r6 == 0) goto L_0x0004
            goto L_0x0234
        L_0x0217:
            r0 = move-exception
        L_0x0218:
            if (r6 == r5) goto L_0x022e
            com.google.android.gms.internal.ads.zzwg r2 = r1.zze
            long r3 = r2.zzb()
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x022e
            com.google.android.gms.internal.ads.zzaeq r3 = r1.zzh
            long r4 = r2.zzb()
            r3.zza = r4
        L_0x022e:
            com.google.android.gms.internal.ads.zzid r2 = r1.zzd
            com.google.android.gms.internal.ads.zzhd.zza(r2)
            throw r0
        L_0x0234:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwm.zzh():void");
    }

    public final void zza(zzfu zzfu) {
        long j;
        if (!this.zzn) {
            j = this.zzk;
        } else {
            j = Math.max(this.zza.zzR(true), this.zzk);
        }
        int zzb2 = zzfu.zzb();
        zzafa zzafa = this.zzm;
        if (zzafa != null) {
            zzaey.zzb(zzafa, zzfu, zzb2);
            zzafa.zzs(j, 1, zzb2, 0, (zzaez) null);
            this.zzn = true;
            return;
        }
        throw null;
    }
}
