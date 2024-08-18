package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbbt extends zzbbo {
    private MessageDigest zzb;

    public final byte[] zzb(String str) {
        byte[] bArr;
        String[] split = str.split(" ");
        int length = split.length;
        int i = 4;
        if (length == 1) {
            int zza = zzbbs.zza(split[0]);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(zza);
            bArr = allocate.array();
        } else if (length < 5) {
            byte[] bArr2 = new byte[(length + length)];
            for (int i2 = 0; i2 < split.length; i2++) {
                int zza2 = zzbbs.zza(split[i2]);
                char c = (zza2 >> 16) ^ ((char) zza2);
                byte b = (byte) c;
                byte b2 = (byte) (c >> 8);
                int i3 = i2 + i2;
                bArr2[i3] = new byte[]{b, b2}[0];
                bArr2[i3 + 1] = b2;
            }
            bArr = bArr2;
        } else {
            byte[] bArr3 = new byte[length];
            for (int i4 = 0; i4 < split.length; i4++) {
                int zza3 = zzbbs.zza(split[i4]);
                bArr3[i4] = (byte) ((zza3 >> 24) ^ (((zza3 & 255) ^ ((zza3 >> 8) & 255)) ^ ((zza3 >> 16) & 255)));
            }
            bArr = bArr3;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            MessageDigest messageDigest = this.zzb;
            if (messageDigest == null) {
                byte[] bArr4 = new byte[0];
                return bArr4;
            }
            messageDigest.reset();
            this.zzb.update(bArr);
            byte[] digest = this.zzb.digest();
            int length2 = digest.length;
            if (length2 <= 4) {
                i = length2;
            }
            byte[] bArr5 = new byte[i];
            System.arraycopy(digest, 0, bArr5, 0, i);
            return bArr5;
        }
    }
}
