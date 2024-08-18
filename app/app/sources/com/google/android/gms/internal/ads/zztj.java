package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zztj implements zztl {
    private final Context zzb;

    @Deprecated
    public zztj() {
        this.zzb = null;
    }

    public zztj(Context context) {
        this.zzb = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zztm zzd(com.google.android.gms.internal.ads.zztk r5) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
            r1 = 23
            if (r0 < r1) goto L_0x0047
            r1 = 31
            if (r0 < r1) goto L_0x000b
            goto L_0x0022
        L_0x000b:
            android.content.Context r0 = r4.zzb
            if (r0 == 0) goto L_0x0047
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r2 = 28
            if (r1 < r2) goto L_0x0047
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String r1 = "com.amazon.hardware.tv_screen"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0047
        L_0x0022:
            com.google.android.gms.internal.ads.zzan r0 = r5.zzc
            java.lang.String r0 = r0.zzn
            int r0 = com.google.android.gms.internal.ads.zzcg.zzb(r0)
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzC(r0)
            java.lang.String r2 = "Creating an asynchronous MediaCodec adapter for track type "
            java.lang.String r1 = r2.concat(r1)
            java.lang.String r2 = "DMCodecAdapterFactory"
            com.google.android.gms.internal.ads.zzfk.zze(r2, r1)
            com.google.android.gms.internal.ads.zzsz r1 = new com.google.android.gms.internal.ads.zzsz
            r1.<init>(r0)
            r0 = 1
            r1.zze(r0)
            com.google.android.gms.internal.ads.zztb r5 = r1.zzc(r5)
            return r5
        L_0x0047:
            r0 = 0
            com.google.android.gms.internal.ads.zztp r1 = r5.zza     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            java.lang.String r1 = r1.zza     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            java.lang.String r2 = "createCodec:"
            java.lang.String r2 = r2.concat(r1)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0084, RuntimeException -> 0x0082 }
            java.lang.String r2 = "configureCodec"
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            android.media.MediaFormat r2 = r5.zzb     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            android.view.Surface r5 = r5.zzd     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            r3 = 0
            r1.configure(r2, r5, r0, r3)     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            java.lang.String r5 = "startCodec"
            android.os.Trace.beginSection(r5)     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            r1.start()     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            com.google.android.gms.internal.ads.zzul r5 = new com.google.android.gms.internal.ads.zzul     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            r5.<init>(r1, r0)     // Catch:{ IOException -> 0x007f, RuntimeException -> 0x007d }
            return r5
        L_0x007d:
            r5 = move-exception
            goto L_0x0080
        L_0x007f:
            r5 = move-exception
        L_0x0080:
            r0 = r1
            goto L_0x0085
        L_0x0082:
            r5 = move-exception
            goto L_0x0085
        L_0x0084:
            r5 = move-exception
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.release()
        L_0x008a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztj.zzd(com.google.android.gms.internal.ads.zztk):com.google.android.gms.internal.ads.zztm");
    }
}
