package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgy extends zzgv {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzgy(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgx {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzgx(e, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzgd.zza;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ee, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fb, code lost:
        r3 = 2005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0101, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0101 A[ExcHandler: zzgx (r0v1 'e' com.google.android.gms.internal.ads.zzgx A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzhh r16) throws com.google.android.gms.internal.ads.zzgx {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r3 = 1
            android.net.Uri r4 = r0.zza     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            android.net.Uri r4 = r4.normalizeScheme()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r1.zzb = r4     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r15.zzi(r16)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r5 = "content"
            java.lang.String r6 = r4.getScheme()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            boolean r5 = r5.equals(r6)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            if (r5 == 0) goto L_0x002e
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r5.<init>()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r6 = "android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT"
            r5.putBoolean(r6, r3)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            android.content.ContentResolver r6 = r1.zza     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r7 = "*/*"
            android.content.res.AssetFileDescriptor r5 = r6.openTypedAssetFileDescriptor(r4, r7, r5)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            goto L_0x0036
        L_0x002e:
            android.content.ContentResolver r5 = r1.zza     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r6 = "r"
            android.content.res.AssetFileDescriptor r5 = r5.openAssetFileDescriptor(r4, r6)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
        L_0x0036:
            r1.zzc = r5     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            if (r5 == 0) goto L_0x00cc
            long r6 = r5.getLength()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.io.FileDescriptor r8 = r5.getFileDescriptor()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r4.<init>(r8)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r1.zzd = r4     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r8 = -1
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r11 = 2008(0x7d8, float:2.814E-42)
            r12 = 0
            if (r10 == 0) goto L_0x005f
            long r13 = r0.zze     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 > 0) goto L_0x0059
            goto L_0x005f
        L_0x0059:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r0.<init>(r12, r11)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            throw r0     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
        L_0x005f:
            long r13 = r5.getStartOffset()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            long r2 = r0.zze     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            long r2 = r2 + r13
            long r2 = r4.skip(r2)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            long r2 = r2 - r13
            long r13 = r0.zze     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            int r13 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r13 != 0) goto L_0x00c6
            r13 = 0
            if (r10 != 0) goto L_0x0097
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            long r3 = r2.size()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x0085
            r1.zze = r8     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r3 = r8
            goto L_0x009f
        L_0x0085:
            long r6 = r2.position()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            long r3 = r3 - r6
            r1.zze = r3     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x0091
            goto L_0x009f
        L_0x0091:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r0.<init>(r12, r11)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            throw r0     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
        L_0x0097:
            long r3 = r6 - r2
            r1.zze = r3     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            int r2 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r2 < 0) goto L_0x00c0
        L_0x009f:
            long r5 = r0.zzf
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x00b0
            int r2 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            long r5 = java.lang.Math.min(r3, r5)
        L_0x00ae:
            r1.zze = r5
        L_0x00b0:
            r2 = 1
            r1.zzf = r2
            r15.zzj(r16)
            long r2 = r0.zzf
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x00bd
            return r2
        L_0x00bd:
            long r2 = r1.zze
            return r2
        L_0x00c0:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r0.<init>(r12, r11)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            throw r0     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
        L_0x00c6:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r0.<init>(r12, r11)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            throw r0     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
        L_0x00cc:
            com.google.android.gms.internal.ads.zzgx r0 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r4.<init>()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r6 = "Could not open file descriptor for: "
            r4.append(r6)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r4.append(r3)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            java.lang.String r3 = r4.toString()     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r2.<init>(r3)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00f0 }
            r3 = 2000(0x7d0, float:2.803E-42)
            r0.<init>(r2, r3)     // Catch:{ zzgx -> 0x0101, IOException -> 0x00ee }
            throw r0     // Catch:{ zzgx -> 0x0101, IOException -> 0x00ee }
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f3
        L_0x00f0:
            r0 = move-exception
            r3 = 2000(0x7d0, float:2.803E-42)
        L_0x00f3:
            com.google.android.gms.internal.ads.zzgx r2 = new com.google.android.gms.internal.ads.zzgx
            boolean r4 = r0 instanceof java.io.FileNotFoundException
            r5 = 1
            if (r5 == r4) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            r3 = 2005(0x7d5, float:2.81E-42)
        L_0x00fd:
            r2.<init>(r0, r3)
            throw r2
        L_0x0101:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.zzb(com.google.android.gms.internal.ads.zzhh):long");
    }

    public final Uri zzc() {
        return this.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        throw new com.google.android.gms.internal.ads.zzgx(r3, com.google.android.gms.auth.api.credentials.CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004f, code lost:
        throw new com.google.android.gms.internal.ads.zzgx(r3, com.google.android.gms.auth.api.credentials.CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r5.zzc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
        if (r5.zzf != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5.zzf = false;
        zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x000f, B:14:0x0023, B:23:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzgx {
        /*
            r5 = this;
            r0 = 0
            r5.zzb = r0
            r1 = 0
            r2 = 2000(0x7d0, float:2.803E-42)
            java.io.FileInputStream r3 = r5.zzd     // Catch:{ IOException -> 0x002b }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x002b }
        L_0x000d:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r3 = r5.zzc     // Catch:{ IOException -> 0x0022 }
            if (r3 == 0) goto L_0x0016
            r3.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0016:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0021
            r5.zzf = r1
            r5.zzh()
        L_0x0021:
            return
        L_0x0022:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzgx r4 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ all -> 0x0047 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0047 }
            throw r4     // Catch:{ all -> 0x0047 }
        L_0x0029:
            r3 = move-exception
            goto L_0x0032
        L_0x002b:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzgx r4 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ all -> 0x0029 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0029 }
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0032:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r4 = r5.zzc     // Catch:{ IOException -> 0x0049 }
            if (r4 == 0) goto L_0x003b
            r4.close()     // Catch:{ IOException -> 0x0049 }
        L_0x003b:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0046
            r5.zzf = r1
            r5.zzh()
        L_0x0046:
            throw r3
        L_0x0047:
            r2 = move-exception
            goto L_0x0050
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzgx r4 = new com.google.android.gms.internal.ads.zzgx     // Catch:{ all -> 0x0047 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x0047 }
            throw r4     // Catch:{ all -> 0x0047 }
        L_0x0050:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x005b
            r5.zzf = r1
            r5.zzh()
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgy.zzd():void");
    }
}
