package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zztt extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zztp zzc;
    public final String zzd;
    public final zztt zze;

    public zztt(zzan zzan, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzan.toString(), th, zzan.zzn, false, (zztp) null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), (zztt) null);
    }

    static /* bridge */ /* synthetic */ zztt zza(zztt zztt, zztt zztt2) {
        return new zztt(zztt.getMessage(), zztt.getCause(), zztt.zza, false, zztt.zzc, zztt.zzd, zztt2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zztt(com.google.android.gms.internal.ads.zzan r11, java.lang.Throwable r12, boolean r13, com.google.android.gms.internal.ads.zztp r14) {
        /*
            r10 = this;
            java.lang.String r13 = r14.zza
            java.lang.String r0 = r11.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Decoder init failed: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = ", "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r3 = r1.toString()
            java.lang.String r5 = r11.zzn
            int r11 = com.google.android.gms.internal.ads.zzgd.zza
            boolean r11 = r12 instanceof android.media.MediaCodec.CodecException
            if (r11 == 0) goto L_0x0030
            r11 = r12
            android.media.MediaCodec$CodecException r11 = (android.media.MediaCodec.CodecException) r11
            java.lang.String r11 = r11.getDiagnosticInfo()
            r8 = r11
            goto L_0x0032
        L_0x0030:
            r11 = 0
            r8 = r11
        L_0x0032:
            r6 = 0
            r9 = 0
            r2 = r10
            r4 = r12
            r7 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztt.<init>(com.google.android.gms.internal.ads.zzan, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zztp):void");
    }

    private zztt(String str, Throwable th, String str2, boolean z, zztp zztp, String str3, zztt zztt) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zztp;
        this.zzd = str3;
        this.zze = zztt;
    }
}
