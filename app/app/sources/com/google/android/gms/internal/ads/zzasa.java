package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzasa implements zzaqo {
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final zzarz zzc;
    private final int zzd;

    public zzasa(zzarz zzarz, int i) {
        this.zzc = zzarz;
        this.zzd = 5242880;
    }

    static int zze(InputStream inputStream) throws IOException {
        return (zzn(inputStream) << 24) | zzn(inputStream) | (zzn(inputStream) << 8) | (zzn(inputStream) << 16);
    }

    static long zzf(InputStream inputStream) throws IOException {
        return (((long) zzn(inputStream)) & 255) | ((((long) zzn(inputStream)) & 255) << 8) | ((((long) zzn(inputStream)) & 255) << 16) | ((((long) zzn(inputStream)) & 255) << 24) | ((((long) zzn(inputStream)) & 255) << 32) | ((((long) zzn(inputStream)) & 255) << 40) | ((((long) zzn(inputStream)) & 255) << 48) | ((((long) zzn(inputStream)) & 255) << 56);
    }

    static String zzh(zzary zzary) throws IOException {
        return new String(zzm(zzary, zzf(zzary)), "UTF-8");
    }

    static void zzj(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zzk(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) j));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        zzk(outputStream, (long) length);
        outputStream.write(bytes, 0, length);
    }

    static byte[] zzm(zzary zzary, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        long zza2 = zzary.zza();
        if (i >= 0 && j <= zza2) {
            int i2 = (int) j;
            if (((long) i2) == j) {
                byte[] bArr = new byte[i2];
                new DataInputStream(zzary).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + zza2);
    }

    private static int zzn(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    private final void zzo(String str, zzarx zzarx) {
        if (!this.zza.containsKey(str)) {
            this.zzb += zzarx.zza;
        } else {
            this.zzb += zzarx.zza - ((zzarx) this.zza.get(str)).zza;
        }
        this.zza.put(str, zzarx);
    }

    private final void zzp(String str) {
        zzarx zzarx = (zzarx) this.zza.remove(str);
        if (zzarx != null) {
            this.zzb -= zzarx.zza;
        }
    }

    private static final String zzq(String str) {
        int length = str.length() / 2;
        return String.valueOf(String.valueOf(str.substring(0, length).hashCode())).concat(String.valueOf(String.valueOf(str.substring(length).hashCode())));
    }

    public final synchronized zzaqn zza(String str) {
        zzary zzary;
        zzarx zzarx = (zzarx) this.zza.get(str);
        if (zzarx == null) {
            return null;
        }
        File zzg = zzg(str);
        try {
            zzary = new zzary(new BufferedInputStream(new FileInputStream(zzg)), zzg.length());
            zzarx zza2 = zzarx.zza(zzary);
            if (!TextUtils.equals(str, zza2.zzb)) {
                zzarq.zza("%s: key=%s, found=%s", zzg.getAbsolutePath(), str, zza2.zzb);
                zzp(str);
                zzary.close();
                return null;
            }
            byte[] zzm = zzm(zzary, zzary.zza());
            zzaqn zzaqn = new zzaqn();
            zzaqn.zza = zzm;
            zzaqn.zzb = zzarx.zzc;
            zzaqn.zzc = zzarx.zzd;
            zzaqn.zzd = zzarx.zze;
            zzaqn.zze = zzarx.zzf;
            zzaqn.zzf = zzarx.zzg;
            List<zzaqw> list = zzarx.zzh;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzaqw zzaqw : list) {
                treeMap.put(zzaqw.zza(), zzaqw.zzb());
            }
            zzaqn.zzg = treeMap;
            zzaqn.zzh = Collections.unmodifiableList(zzarx.zzh);
            zzary.close();
            return zzaqn;
        } catch (IOException e) {
            zzarq.zza("%s: %s", zzg.getAbsolutePath(), e.toString());
            zzi(str);
            return null;
        } catch (Throwable th) {
            zzary.close();
            throw th;
        }
    }

    public final synchronized void zzb() {
        zzary zzary;
        File zza2 = this.zzc.zza();
        if (zza2.exists()) {
            File[] listFiles = zza2.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    try {
                        long length = file.length();
                        zzary = new zzary(new BufferedInputStream(new FileInputStream(file)), length);
                        zzarx zza3 = zzarx.zza(zzary);
                        zza3.zza = length;
                        zzo(zza3.zzb, zza3);
                        zzary.close();
                    } catch (IOException e) {
                        file.delete();
                    } catch (Throwable th) {
                        zzary.close();
                        throw th;
                    }
                }
            }
        } else if (!zza2.mkdirs()) {
            zzarq.zzb("Unable to create cache dir %s", zza2.getAbsolutePath());
        }
    }

    public final synchronized void zzc(String str, boolean z) {
        zzaqn zza2 = zza(str);
        if (zza2 != null) {
            zza2.zzf = 0;
            zza2.zze = 0;
            zzd(str, zza2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0180, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(java.lang.String r13, com.google.android.gms.internal.ads.zzaqn r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.zzb     // Catch:{ all -> 0x0181 }
            byte[] r2 = r14.zza     // Catch:{ all -> 0x0181 }
            int r2 = r2.length     // Catch:{ all -> 0x0181 }
            long r3 = (long) r2     // Catch:{ all -> 0x0181 }
            long r0 = r0 + r3
            int r3 = r12.zzd     // Catch:{ all -> 0x0181 }
            long r4 = (long) r3     // Catch:{ all -> 0x0181 }
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r1 = 1063675494(0x3f666666, float:0.9)
            if (r0 <= 0) goto L_0x0019
            float r0 = (float) r2     // Catch:{ all -> 0x0181 }
            float r2 = (float) r3     // Catch:{ all -> 0x0181 }
            float r2 = r2 * r1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x017f
        L_0x0019:
            java.io.File r0 = r12.zzg(r13)     // Catch:{ all -> 0x0181 }
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x014a }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x014a }
            r4.<init>(r0)     // Catch:{ IOException -> 0x014a }
            r3.<init>(r4)     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarx r4 = new com.google.android.gms.internal.ads.zzarx     // Catch:{ IOException -> 0x014a }
            r4.<init>(r13, r14)     // Catch:{ IOException -> 0x014a }
            r5 = 538247942(0x20150306, float:1.2621791E-19)
            zzj(r3, r5)     // Catch:{ IOException -> 0x0126 }
            java.lang.String r5 = r4.zzb     // Catch:{ IOException -> 0x0126 }
            zzl(r3, r5)     // Catch:{ IOException -> 0x0126 }
            java.lang.String r5 = r4.zzc     // Catch:{ IOException -> 0x0126 }
            if (r5 != 0) goto L_0x003e
            java.lang.String r5 = ""
        L_0x003e:
            zzl(r3, r5)     // Catch:{ IOException -> 0x0126 }
            long r5 = r4.zzd     // Catch:{ IOException -> 0x0126 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0126 }
            long r5 = r4.zze     // Catch:{ IOException -> 0x0126 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0126 }
            long r5 = r4.zzf     // Catch:{ IOException -> 0x0126 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0126 }
            long r5 = r4.zzg     // Catch:{ IOException -> 0x0126 }
            zzk(r3, r5)     // Catch:{ IOException -> 0x0126 }
            java.util.List r5 = r4.zzh     // Catch:{ IOException -> 0x0126 }
            if (r5 == 0) goto L_0x007f
            int r6 = r5.size()     // Catch:{ IOException -> 0x0126 }
            zzj(r3, r6)     // Catch:{ IOException -> 0x0126 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0126 }
        L_0x0064:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x0126 }
            if (r6 == 0) goto L_0x0083
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x0126 }
            com.google.android.gms.internal.ads.zzaqw r6 = (com.google.android.gms.internal.ads.zzaqw) r6     // Catch:{ IOException -> 0x0126 }
            java.lang.String r7 = r6.zza()     // Catch:{ IOException -> 0x0126 }
            zzl(r3, r7)     // Catch:{ IOException -> 0x0126 }
            java.lang.String r6 = r6.zzb()     // Catch:{ IOException -> 0x0126 }
            zzl(r3, r6)     // Catch:{ IOException -> 0x0126 }
            goto L_0x0064
        L_0x007f:
            zzj(r3, r2)     // Catch:{ IOException -> 0x0126 }
        L_0x0083:
            r3.flush()     // Catch:{ IOException -> 0x0126 }
            byte[] r14 = r14.zza     // Catch:{ IOException -> 0x014a }
            r3.write(r14)     // Catch:{ IOException -> 0x014a }
            r3.close()     // Catch:{ IOException -> 0x014a }
            long r5 = r0.length()     // Catch:{ IOException -> 0x014a }
            r4.zza = r5     // Catch:{ IOException -> 0x014a }
            r12.zzo(r13, r4)     // Catch:{ IOException -> 0x014a }
            long r13 = r12.zzb     // Catch:{ IOException -> 0x014a }
            int r3 = r12.zzd     // Catch:{ IOException -> 0x014a }
            long r3 = (long) r3     // Catch:{ IOException -> 0x014a }
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a2
            goto L_0x017f
        L_0x00a2:
            boolean r13 = com.google.android.gms.internal.ads.zzarq.zzb     // Catch:{ IOException -> 0x014a }
            if (r13 == 0) goto L_0x00ad
            java.lang.String r13 = "Pruning old cache entries."
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarq.zzd(r13, r14)     // Catch:{ IOException -> 0x014a }
        L_0x00ad:
            long r13 = r12.zzb     // Catch:{ IOException -> 0x014a }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x014a }
            java.util.Map r5 = r12.zza     // Catch:{ IOException -> 0x014a }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x014a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x014a }
            r6 = r2
        L_0x00be:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x014a }
            if (r7 == 0) goto L_0x0103
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x014a }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x014a }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarx r7 = (com.google.android.gms.internal.ads.zzarx) r7     // Catch:{ IOException -> 0x014a }
            java.lang.String r8 = r7.zzb     // Catch:{ IOException -> 0x014a }
            java.io.File r8 = r12.zzg(r8)     // Catch:{ IOException -> 0x014a }
            boolean r8 = r8.delete()     // Catch:{ IOException -> 0x014a }
            if (r8 == 0) goto L_0x00e4
            long r8 = r12.zzb     // Catch:{ IOException -> 0x014a }
            long r10 = r7.zza     // Catch:{ IOException -> 0x014a }
            long r8 = r8 - r10
            r12.zzb = r8     // Catch:{ IOException -> 0x014a }
            goto L_0x00f3
        L_0x00e4:
            java.lang.String r8 = "Could not delete cache entry for key=%s, filename=%s"
            java.lang.String r7 = r7.zzb     // Catch:{ IOException -> 0x014a }
            java.lang.String r9 = zzq(r7)     // Catch:{ IOException -> 0x014a }
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r9}     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarq.zza(r8, r7)     // Catch:{ IOException -> 0x014a }
        L_0x00f3:
            r5.remove()     // Catch:{ IOException -> 0x014a }
            int r6 = r6 + 1
            long r7 = r12.zzb     // Catch:{ IOException -> 0x014a }
            float r7 = (float) r7     // Catch:{ IOException -> 0x014a }
            int r8 = r12.zzd     // Catch:{ IOException -> 0x014a }
            float r8 = (float) r8     // Catch:{ IOException -> 0x014a }
            float r8 = r8 * r1
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00be
        L_0x0103:
            boolean r1 = com.google.android.gms.internal.ads.zzarq.zzb     // Catch:{ IOException -> 0x014a }
            if (r1 == 0) goto L_0x017f
            java.lang.String r1 = "pruned %d files, %d bytes, %d ms"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x014a }
            long r6 = r12.zzb     // Catch:{ IOException -> 0x014a }
            long r6 = r6 - r13
            java.lang.Long r13 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x014a }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x014a }
            long r6 = r6 - r3
            java.lang.Long r14 = java.lang.Long.valueOf(r6)     // Catch:{ IOException -> 0x014a }
            java.lang.Object[] r13 = new java.lang.Object[]{r5, r13, r14}     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarq.zzd(r1, r13)     // Catch:{ IOException -> 0x014a }
            monitor-exit(r12)
            return
        L_0x0126:
            r13 = move-exception
            java.lang.String r14 = "%s"
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x014a }
            java.lang.Object[] r13 = new java.lang.Object[]{r13}     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarq.zza(r14, r13)     // Catch:{ IOException -> 0x014a }
            r3.close()     // Catch:{ IOException -> 0x014a }
            java.lang.String r13 = "Failed to write header for %s"
            java.lang.String r14 = r0.getAbsolutePath()     // Catch:{ IOException -> 0x014a }
            java.lang.Object[] r14 = new java.lang.Object[]{r14}     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.ads.zzarq.zza(r13, r14)     // Catch:{ IOException -> 0x014a }
            java.io.IOException r13 = new java.io.IOException     // Catch:{ IOException -> 0x014a }
            r13.<init>()     // Catch:{ IOException -> 0x014a }
            throw r13     // Catch:{ IOException -> 0x014a }
        L_0x014a:
            r13 = move-exception
            boolean r13 = r0.delete()     // Catch:{ all -> 0x0181 }
            if (r13 != 0) goto L_0x015e
            java.lang.String r13 = r0.getAbsolutePath()     // Catch:{ all -> 0x0181 }
            java.lang.Object[] r13 = new java.lang.Object[]{r13}     // Catch:{ all -> 0x0181 }
            java.lang.String r14 = "Could not clean up file %s"
            com.google.android.gms.internal.ads.zzarq.zza(r14, r13)     // Catch:{ all -> 0x0181 }
        L_0x015e:
            com.google.android.gms.internal.ads.zzarz r13 = r12.zzc     // Catch:{ all -> 0x0181 }
            java.io.File r13 = r13.zza()     // Catch:{ all -> 0x0181 }
            boolean r13 = r13.exists()     // Catch:{ all -> 0x0181 }
            if (r13 != 0) goto L_0x017f
            java.lang.Object[] r13 = new java.lang.Object[r2]     // Catch:{ all -> 0x0181 }
            java.lang.String r14 = "Re-initializing cache after external clearing."
            com.google.android.gms.internal.ads.zzarq.zza(r14, r13)     // Catch:{ all -> 0x0181 }
            java.util.Map r13 = r12.zza     // Catch:{ all -> 0x0181 }
            r13.clear()     // Catch:{ all -> 0x0181 }
            r13 = 0
            r12.zzb = r13     // Catch:{ all -> 0x0181 }
            r12.zzb()     // Catch:{ all -> 0x0181 }
            monitor-exit(r12)
            return
        L_0x017f:
            monitor-exit(r12)
            return
        L_0x0181:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasa.zzd(java.lang.String, com.google.android.gms.internal.ads.zzaqn):void");
    }

    public final File zzg(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public final synchronized void zzi(String str) {
        boolean delete = zzg(str).delete();
        zzp(str);
        if (!delete) {
            zzarq.zza("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
        }
    }

    public zzasa(File file, int i) {
        this.zzc = new zzarw(this, file);
        this.zzd = 20971520;
    }
}
