package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbxr implements Runnable {
    public final /* synthetic */ OutputStream zza;
    public final /* synthetic */ byte[] zzb;

    public /* synthetic */ zzbxr(OutputStream outputStream, byte[] bArr) {
        this.zza = outputStream;
        this.zzb = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbxs> r0 = com.google.android.gms.internal.ads.zzbxs.CREATOR
            java.io.OutputStream r0 = r5.zza
            byte[] r1 = r5.zzb
            r2 = 0
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            r3.<init>(r0)     // Catch:{ IOException -> 0x001f, all -> 0x001d }
            int r2 = r1.length     // Catch:{ IOException -> 0x001a, all -> 0x0017 }
            r3.writeInt(r2)     // Catch:{ IOException -> 0x001a, all -> 0x0017 }
            r3.write(r1)     // Catch:{ IOException -> 0x001a, all -> 0x0017 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r3)
            return
        L_0x0017:
            r1 = move-exception
            r2 = r3
            goto L_0x0039
        L_0x001a:
            r1 = move-exception
            r2 = r3
            goto L_0x0020
        L_0x001d:
            r1 = move-exception
            goto L_0x0039
        L_0x001f:
            r1 = move-exception
        L_0x0020:
            java.lang.String r3 = "Error transporting the ad response"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r3, r1)     // Catch:{ all -> 0x0038 }
            com.google.android.gms.internal.ads.zzcby r3 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "LargeParcelTeleporter.pipeData.1"
            r3.zzw(r1, r4)     // Catch:{ all -> 0x0038 }
            if (r2 != 0) goto L_0x0034
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r0)
            return
        L_0x0034:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
            return
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            if (r2 != 0) goto L_0x003f
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r0)
            goto L_0x0042
        L_0x003f:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
        L_0x0042:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxr.run():void");
    }
}
