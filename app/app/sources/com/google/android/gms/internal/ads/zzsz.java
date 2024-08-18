package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzsz implements zztl {
    private final zzfyw zzb;
    private final zzfyw zzc;
    private boolean zzd = true;

    public zzsz(int i) {
        zzsx zzsx = new zzsx(i);
        zzsy zzsy = new zzsy(i);
        this.zzb = zzsx;
        this.zzc = zzsy;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zztb.zzr(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zztb.zzr(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zztb zzc(com.google.android.gms.internal.ads.zztk r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zztp r0 = r7.zza
            java.lang.String r0 = r0.zza
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006e }
            r2.<init>()     // Catch:{ Exception -> 0x006e }
            java.lang.String r3 = "createCodec:"
            r2.append(r3)     // Catch:{ Exception -> 0x006e }
            r2.append(r0)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x006e }
            android.os.Trace.beginSection(r2)     // Catch:{ Exception -> 0x006e }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x006e }
            boolean r2 = r6.zzd     // Catch:{ Exception -> 0x006c }
            if (r2 == 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzan r2 = r7.zzc     // Catch:{ Exception -> 0x006c }
            int r3 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x006c }
            r4 = 34
            if (r3 >= r4) goto L_0x002a
            goto L_0x003f
        L_0x002a:
            int r3 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x006c }
            r4 = 35
            if (r3 >= r4) goto L_0x0038
            java.lang.String r2 = r2.zzn     // Catch:{ Exception -> 0x006c }
            boolean r2 = com.google.android.gms.internal.ads.zzcg.zzh(r2)     // Catch:{ Exception -> 0x006c }
            if (r2 == 0) goto L_0x003f
        L_0x0038:
            com.google.android.gms.internal.ads.zzum r2 = new com.google.android.gms.internal.ads.zzum     // Catch:{ Exception -> 0x006c }
            r2.<init>(r0)     // Catch:{ Exception -> 0x006c }
            r3 = 4
            goto L_0x004f
        L_0x003f:
            com.google.android.gms.internal.ads.zztf r2 = new com.google.android.gms.internal.ads.zztf     // Catch:{ Exception -> 0x006c }
            com.google.android.gms.internal.ads.zzfyw r3 = r6.zzc     // Catch:{ Exception -> 0x006c }
            com.google.android.gms.internal.ads.zzsy r3 = (com.google.android.gms.internal.ads.zzsy) r3     // Catch:{ Exception -> 0x006c }
            int r3 = r3.zza     // Catch:{ Exception -> 0x006c }
            android.os.HandlerThread r3 = zzb(r3)     // Catch:{ Exception -> 0x006c }
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x006c }
            r3 = 0
        L_0x004f:
            com.google.android.gms.internal.ads.zztb r4 = new com.google.android.gms.internal.ads.zztb     // Catch:{ Exception -> 0x006c }
            com.google.android.gms.internal.ads.zzfyw r5 = r6.zzb     // Catch:{ Exception -> 0x006c }
            com.google.android.gms.internal.ads.zzsx r5 = (com.google.android.gms.internal.ads.zzsx) r5     // Catch:{ Exception -> 0x006c }
            int r5 = r5.zza     // Catch:{ Exception -> 0x006c }
            android.os.HandlerThread r5 = zza(r5)     // Catch:{ Exception -> 0x006c }
            r4.<init>(r0, r5, r2, r1)     // Catch:{ Exception -> 0x006c }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0069 }
            android.media.MediaFormat r2 = r7.zzb     // Catch:{ Exception -> 0x0069 }
            android.view.Surface r7 = r7.zzd     // Catch:{ Exception -> 0x0069 }
            com.google.android.gms.internal.ads.zztb.zzh(r4, r2, r7, r1, r3)     // Catch:{ Exception -> 0x0069 }
            return r4
        L_0x0069:
            r7 = move-exception
            r1 = r4
            goto L_0x0070
        L_0x006c:
            r7 = move-exception
            goto L_0x0070
        L_0x006e:
            r7 = move-exception
            r0 = r1
        L_0x0070:
            if (r1 != 0) goto L_0x0078
            if (r0 == 0) goto L_0x007b
            r0.release()
            goto L_0x007b
        L_0x0078:
            r1.zzl()
        L_0x007b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsz.zzc(com.google.android.gms.internal.ads.zztk):com.google.android.gms.internal.ads.zztb");
    }

    public final /* bridge */ /* synthetic */ zztm zzd(zztk zztk) throws IOException {
        throw null;
    }

    public final void zze(boolean z) {
        this.zzd = true;
    }
}
