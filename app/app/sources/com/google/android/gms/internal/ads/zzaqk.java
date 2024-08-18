package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaqk {
    public static X509Certificate[][] zza(String str) throws zzaqh, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair zzc = zzaql.zzc(randomAccessFile);
            if (zzc != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) zzc.first;
                long longValue = ((Long) zzc.second).longValue();
                long j = -20 + longValue;
                if (j >= 0) {
                    randomAccessFile.seek(j);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new zzaqh("ZIP64 APK not supported");
                    }
                }
                long zza = zzaql.zza(byteBuffer2);
                if (zza >= longValue) {
                    throw new zzaqh("ZIP Central Directory offset out of range: " + zza + ". ZIP End of Central Directory offset: " + longValue);
                } else if (zzaql.zzb(byteBuffer2) + zza != longValue) {
                    throw new zzaqh("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (zza >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    randomAccessFile.seek(zza - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i = 0;
                        long j2 = allocate.getLong(0);
                        if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                            throw new zzaqh("APK Signing Block size out of range: " + j2);
                        }
                        int i2 = (int) (8 + j2);
                        long j3 = zza - ((long) i2);
                        if (j3 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i2);
                            allocate2.order(ByteOrder.LITTLE_ENDIAN);
                            randomAccessFile.seek(j3);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j4 = allocate2.getLong(0);
                            if (j4 == j2) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j3));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i++;
                                                if (slice.remaining() >= 8) {
                                                    long j5 = slice.getLong();
                                                    if (j5 < 4 || j5 > 2147483647L) {
                                                        throw new zzaqh("APK Signing Block entry #" + i + " size out of range: " + j5);
                                                    }
                                                    int i3 = (int) j5;
                                                    int position2 = slice.position() + i3;
                                                    if (i3 > slice.remaining()) {
                                                        throw new zzaqh("APK Signing Block entry #" + i + " size out of range: " + i3 + ", available: " + slice.remaining());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] zzl = zzl(randomAccessFile.getChannel(), new zzaqg(zze(slice, i3 - 4), longValue2, zza, longValue, byteBuffer2, (zzaqf) null));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException e) {
                                                        }
                                                        return zzl;
                                                    } else {
                                                        slice.position(position2);
                                                    }
                                                } else {
                                                    throw new zzaqh("Insufficient data to read size of APK Signing Block entry #" + i);
                                                }
                                            }
                                            throw new zzaqh("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        throw new IllegalArgumentException("end > capacity: " + capacity + " > " + capacity2);
                                    }
                                    throw new IllegalArgumentException("end < start: " + capacity + " < " + 8);
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            throw new zzaqh("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                        }
                        throw new zzaqh("APK Signing Block offset out of range: " + j3);
                    }
                    throw new zzaqh("No APK Signing Block before ZIP Central Directory");
                } else {
                    throw new zzaqh("APK too small for APK Signing Block. ZIP Central Directory offset: " + zza);
                }
            } else {
                throw new zzaqh("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
            }
            throw th2;
        }
    }

    private static int zzb(int i) {
        switch (i) {
            case 1:
                return 32;
            case 2:
                return 64;
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static int zzc(int i) {
        switch (i) {
            case 257:
            case 259:
            case InputDeviceCompat.SOURCE_DPAD /*513*/:
            case 769:
                return 1;
            case 258:
            case 260:
            case 514:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
        }
    }

    private static String zzd(int i) {
        switch (i) {
            case 1:
                return "SHA-256";
            case 2:
                return "SHA-512";
            default:
                throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
        }
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i <= byteBuffer.remaining()) {
                return zze(byteBuffer, i);
            } else {
                int remaining = byteBuffer.remaining();
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + remaining);
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + remaining2);
        }
    }

    private static void zzg(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >>> 8) & 255);
        bArr[3] = (byte) ((i >>> 16) & 255);
        bArr[4] = (byte) (i >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            zzaqe zzaqe = new zzaqe(fileChannel, 0, j);
            zzaqe zzaqe2 = new zzaqe(fileChannel, j2, j3 - j2);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j4 = j;
            zzaql.zzd(duplicate, j);
            zzaqc zzaqc = new zzaqc(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i = 0;
            int i2 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i2] = intValue.intValue();
                i2++;
            }
            try {
                byte[][] zzk = zzk(iArr, new zzaqd[]{zzaqe, zzaqe2, zzaqc});
                while (i < size) {
                    int i3 = iArr[i];
                    Map map2 = map;
                    if (MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i3)), zzk[i])) {
                        i++;
                    } else {
                        throw new SecurityException(zzd(i3).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e) {
                throw new SecurityException("Failed to compute digest(s) of contents", e);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        } else if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + remaining);
        }
    }

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        ByteBuffer zzf = zzf(byteBuffer);
        ByteBuffer zzf2 = zzf(byteBuffer);
        byte[] zzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        byte[] bArr2 = null;
        int i = -1;
        int i2 = 0;
        while (zzf2.hasRemaining()) {
            i2++;
            try {
                ByteBuffer zzf3 = zzf(zzf2);
                if (zzf3.remaining() >= 8) {
                    int i3 = zzf3.getInt();
                    arrayList.add(Integer.valueOf(i3));
                    switch (i3) {
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                        case InputDeviceCompat.SOURCE_DPAD /*513*/:
                        case 514:
                        case 769:
                            if (i != -1) {
                                int zzc = zzc(i3);
                                int zzc2 = zzc(i);
                                switch (zzc) {
                                    case 1:
                                        break;
                                    default:
                                        switch (zzc2) {
                                            case 1:
                                                break;
                                        }
                                }
                            }
                            bArr2 = zzi(zzf3);
                            i = i3;
                            break;
                    }
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #" + i2, e);
            }
        }
        if (i != -1) {
            switch (i) {
                case 257:
                case 258:
                case 259:
                case 260:
                    str = "RSA";
                    break;
                case InputDeviceCompat.SOURCE_DPAD /*513*/:
                case 514:
                    str = "EC";
                    break;
                case 769:
                    str = "DSA";
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
            }
            switch (i) {
                case 257:
                    pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case 258:
                    pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case 259:
                    pair = Pair.create("SHA256withRSA", (Object) null);
                    break;
                case 260:
                    pair = Pair.create("SHA512withRSA", (Object) null);
                    break;
                case InputDeviceCompat.SOURCE_DPAD /*513*/:
                    pair = Pair.create("SHA256withECDSA", (Object) null);
                    break;
                case 514:
                    pair = Pair.create("SHA512withECDSA", (Object) null);
                    break;
                case 769:
                    pair = Pair.create("SHA256withDSA", (Object) null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString((long) i))));
            }
            String str2 = (String) pair.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(zzi));
                Signature instance = Signature.getInstance(str2);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(zzf);
                if (instance.verify(bArr2)) {
                    zzf.clear();
                    ByteBuffer zzf4 = zzf(zzf);
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (zzf4.hasRemaining()) {
                        i4++;
                        try {
                            ByteBuffer zzf5 = zzf(zzf4);
                            if (zzf5.remaining() >= 8) {
                                int i5 = zzf5.getInt();
                                arrayList2.add(Integer.valueOf(i5));
                                if (i5 == i) {
                                    bArr = zzi(zzf5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e2) {
                            throw new IOException("Failed to parse digest record #" + i4, e2);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int zzc3 = zzc(i);
                        byte[] bArr3 = (byte[]) map.put(Integer.valueOf(zzc3), bArr);
                        if (bArr3 == null || MessageDigest.isEqual(bArr3, bArr)) {
                            ByteBuffer zzf6 = zzf(zzf);
                            ArrayList arrayList3 = new ArrayList();
                            int i6 = 0;
                            while (zzf6.hasRemaining()) {
                                i6++;
                                byte[] zzi2 = zzi(zzf6);
                                try {
                                    arrayList3.add(new zzaqi((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(zzi2)), zzi2));
                                } catch (CertificateException e3) {
                                    throw new SecurityException("Failed to decode certificate #" + i6, e3);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(zzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(zzd(zzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
                throw new SecurityException("Failed to verify " + str2 + " signature", e4);
            }
        } else if (i2 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e9, code lost:
        r20 = r9;
        r22 = r11;
        r2 = (long) r2;
        r5 = r7 + r2;
        r12 = r12 - r2;
        r14 = r14 + 1;
        r2 = 0;
        r7 = 1048576;
        r25 = r5;
        r5 = r19;
        r19 = r25;
        r6 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[][] zzk(int[] r27, com.google.android.gms.internal.ads.zzaqd[] r28) throws java.security.DigestException {
        /*
            r0 = r27
            r1 = 0
            r2 = 0
            r4 = r1
            r5 = r2
        L_0x0007:
            r7 = 1048576(0x100000, double:5.180654E-318)
            r9 = 3
            if (r4 >= r9) goto L_0x001c
            r9 = r28[r4]
            long r9 = r9.zza()
            r11 = 1048575(0xfffff, double:5.18065E-318)
            long r9 = r9 + r11
            long r9 = r9 / r7
            long r5 = r5 + r9
            int r4 = r4 + 1
            goto L_0x0007
        L_0x001c:
            r10 = 2097151(0x1fffff, double:1.0361303E-317)
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x0167
            int r4 = r0.length
            byte[][] r4 = new byte[r4][]
            r10 = r1
        L_0x0027:
            int r11 = r0.length
            r12 = 5
            r13 = 1
            if (r10 >= r11) goto L_0x0043
            int r11 = (int) r5
            r14 = r0[r10]
            int r14 = zzb(r14)
            int r14 = r14 * r11
            int r14 = r14 + r12
            byte[] r12 = new byte[r14]
            r14 = 90
            r12[r1] = r14
            zzg(r11, r12, r13)
            r4[r10] = r12
            int r10 = r10 + 1
            goto L_0x0027
        L_0x0043:
            byte[] r5 = new byte[r12]
            r6 = -91
            r5[r1] = r6
            java.security.MessageDigest[] r6 = new java.security.MessageDigest[r11]
            r10 = r1
        L_0x004c:
            int r14 = r0.length
            java.lang.String r15 = " digest not supported"
            if (r10 >= r14) goto L_0x006b
            r14 = r0[r10]
            java.lang.String r14 = zzd(r14)
            java.security.MessageDigest r16 = java.security.MessageDigest.getInstance(r14)     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            r6[r10] = r16     // Catch:{ NoSuchAlgorithmException -> 0x0060 }
            int r10 = r10 + 1
            goto L_0x004c
        L_0x0060:
            r0 = move-exception
            java.lang.String r1 = r14.concat(r15)
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1, r0)
            throw r2
        L_0x006b:
            r10 = r1
            r14 = r10
        L_0x006d:
            if (r10 >= r9) goto L_0x013e
            r9 = r28[r10]
            long r17 = r9.zza()
            r19 = r2
            r12 = r17
        L_0x0079:
            int r21 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r21 <= 0) goto L_0x0127
            long r2 = java.lang.Math.min(r12, r7)
            int r2 = (int) r2
            r3 = 1
            zzg(r2, r5, r3)
            r3 = 0
        L_0x0087:
            if (r3 >= r11) goto L_0x0094
            r7 = r6[r3]
            r7.update(r5)
            int r3 = r3 + 1
            r7 = 1048576(0x100000, double:5.180654E-318)
            goto L_0x0087
        L_0x0094:
            r7 = r19
            r9.zzb(r6, r7, r2)     // Catch:{ IOException -> 0x0106 }
            r3 = 0
        L_0x009a:
            r19 = r5
            int r5 = r0.length
            if (r3 >= r5) goto L_0x00e9
            r5 = r0[r3]
            r20 = r9
            r9 = r4[r3]
            int r5 = zzb(r5)
            r22 = r11
            r11 = r6[r3]
            int r23 = r14 * r5
            r24 = r6
            r17 = 5
            int r6 = r23 + 5
            int r6 = r11.digest(r9, r6, r5)
            if (r6 != r5) goto L_0x00c6
            int r3 = r3 + 1
            r5 = r19
            r9 = r20
            r11 = r22
            r6 = r24
            goto L_0x009a
        L_0x00c6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = r11.getAlgorithm()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected output size of "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " digest: "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x00e9:
            r24 = r6
            r20 = r9
            r22 = r11
            r17 = 5
            long r2 = (long) r2
            long r5 = r7 + r2
            long r12 = r12 - r2
            int r14 = r14 + 1
            r2 = 0
            r7 = 1048576(0x100000, double:5.180654E-318)
            r25 = r5
            r5 = r19
            r19 = r25
            r6 = r24
            goto L_0x0079
        L_0x0106:
            r0 = move-exception
            r2 = r0
            java.security.DigestException r0 = new java.security.DigestException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to digest chunk #"
            r3.append(r4)
            r3.append(r14)
            java.lang.String r4 = " of section #"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1, r2)
            throw r0
        L_0x0127:
            r19 = r5
            r24 = r6
            r22 = r11
            r17 = 5
            int r1 = r1 + 1
            int r10 = r10 + 1
            r12 = r17
            r2 = 0
            r7 = 1048576(0x100000, double:5.180654E-318)
            r9 = 3
            r13 = 1
            goto L_0x006d
        L_0x013e:
            int r1 = r0.length
            byte[][] r1 = new byte[r1][]
            r2 = 0
        L_0x0142:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x0166
            r3 = r0[r2]
            r5 = r4[r2]
            java.lang.String r3 = zzd(r3)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x015a }
            byte[] r3 = r3.digest(r5)
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0142
        L_0x015a:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = r3.concat(r15)
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0, r1)
            throw r2
        L_0x0166:
            return r1
        L_0x0167:
            java.security.DigestException r0 = new java.security.DigestException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many chunks: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqk.zzk(int[], com.google.android.gms.internal.ads.zzaqd[]):byte[][]");
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzaqg zzaqg) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zzf = zzf(zzaqg.zza);
                int i = 0;
                while (zzf.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(zzj(zzf(zzf), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    zzh(hashMap, fileChannel, zzaqg.zzb, zzaqg.zzc, zzaqg.zzd, zzaqg.zze);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
