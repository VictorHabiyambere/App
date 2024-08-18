package com.google.common.hash;

import com.google.common.base.Preconditions;

@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    Fingerprint2011() {
    }

    public HashCode hashBytes(byte[] input, int off, int len) {
        Preconditions.checkPositionIndexes(off, off + len, input.length);
        return HashCode.fromLong(fingerprint(input, off, len));
    }

    public int bits() {
        return 64;
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }

    static long fingerprint(byte[] bytes, int offset, int length) {
        long result;
        if (length <= 32) {
            result = murmurHash64WithSeed(bytes, offset, length, -1397348546323613475L);
        } else if (length <= 64) {
            result = hashLength33To64(bytes, offset, length);
        } else {
            result = fullFingerprint(bytes, offset, length);
        }
        long v = K0;
        long u = length >= 8 ? LittleEndianByteArray.load64(bytes, offset) : -6505348102511208375L;
        if (length >= 9) {
            v = LittleEndianByteArray.load64(bytes, (offset + length) - 8);
        }
        long result2 = hash128to64(result + v, u);
        return (result2 == 0 || result2 == 1) ? -2 + result2 : result2;
    }

    private static long shiftMix(long val) {
        return (val >>> 47) ^ val;
    }

    static long hash128to64(long high, long low) {
        long a = (low ^ high) * K3;
        long b = (high ^ (a ^ (a >>> 47))) * K3;
        return (b ^ (b >>> 47)) * K3;
    }

    private static void weakHashLength32WithSeeds(byte[] bytes, int offset, long seedA, long seedB, long[] output) {
        byte[] bArr = bytes;
        long part1 = LittleEndianByteArray.load64(bytes, offset);
        long part2 = LittleEndianByteArray.load64(bArr, offset + 8);
        long part3 = LittleEndianByteArray.load64(bArr, offset + 16);
        long part4 = LittleEndianByteArray.load64(bArr, offset + 24);
        long seedA2 = seedA + part1;
        long c = seedA2;
        long seedA3 = seedA2 + part2 + part3;
        output[0] = seedA3 + part4;
        output[1] = Long.rotateRight(seedB + seedA2 + part4, 51) + Long.rotateRight(seedA3, 23) + c;
    }

    private static long fullFingerprint(byte[] bytes, int offset, int length) {
        byte[] bArr = bytes;
        int i = length;
        long x = LittleEndianByteArray.load64(bytes, offset);
        long y = LittleEndianByteArray.load64(bArr, (offset + i) - 16) ^ K1;
        long z = LittleEndianByteArray.load64(bArr, (offset + i) - 56) ^ K0;
        long[] v = new long[2];
        long[] w = new long[2];
        long[] v2 = v;
        weakHashLength32WithSeeds(bytes, (offset + i) - 64, (long) i, y, v);
        weakHashLength32WithSeeds(bytes, (offset + i) - 32, ((long) i) * K1, K0, w);
        long z2 = z + (shiftMix(v2[1]) * K1);
        long x2 = Long.rotateRight(z2 + x, 39) * K1;
        long x3 = Long.rotateRight(y, 33) * K1;
        int offset2 = offset;
        int length2 = (i - 1) & -64;
        while (true) {
            long x4 = Long.rotateRight(x2 + x3 + v2[0] + LittleEndianByteArray.load64(bArr, offset2 + 16), 37) * K1;
            long y2 = Long.rotateRight(v2[1] + x3 + LittleEndianByteArray.load64(bArr, offset2 + 48), 42) * K1;
            long x5 = x4 ^ w[1];
            long y3 = y2 ^ v2[0];
            long z3 = Long.rotateRight(w[0] ^ z2, 33);
            byte[] bArr2 = bytes;
            weakHashLength32WithSeeds(bArr2, offset2, v2[1] * K1, x5 + w[0], v2);
            weakHashLength32WithSeeds(bArr2, offset2 + 32, w[1] + z3, y3, w);
            z2 = x5;
            long x6 = z3;
            offset2 += 64;
            length2 -= 64;
            if (length2 == 0) {
                return hash128to64(hash128to64(v2[0], w[0]) + (shiftMix(y3) * K1) + z2, hash128to64(v2[1], w[1]) + x6);
            }
            x2 = x6;
            x3 = y3;
        }
    }

    private static long hashLength33To64(byte[] bytes, int offset, int length) {
        byte[] bArr = bytes;
        int i = length;
        long z = LittleEndianByteArray.load64(bArr, offset + 24);
        long a = LittleEndianByteArray.load64(bytes, offset) + ((((long) i) + LittleEndianByteArray.load64(bArr, (offset + i) - 16)) * K0);
        long b = Long.rotateRight(a + z, 52);
        long c = Long.rotateRight(a, 37);
        long a2 = a + LittleEndianByteArray.load64(bArr, offset + 8);
        long c2 = c + Long.rotateRight(a2, 7);
        long a3 = a2 + LittleEndianByteArray.load64(bArr, offset + 16);
        long vf = a3 + z;
        long vs = b + Long.rotateRight(a3, 31) + c2;
        long a4 = LittleEndianByteArray.load64(bArr, offset + 16) + LittleEndianByteArray.load64(bArr, (offset + i) - 32);
        long z2 = LittleEndianByteArray.load64(bArr, (offset + i) - 8);
        long b2 = Long.rotateRight(a4 + z2, 52);
        long c3 = Long.rotateRight(a4, 37);
        long a5 = a4 + LittleEndianByteArray.load64(bArr, (offset + i) - 24);
        long c4 = c3 + Long.rotateRight(a5, 7);
        long a6 = a5 + LittleEndianByteArray.load64(bArr, (offset + i) - 16);
        return shiftMix((K0 * shiftMix(((vf + Long.rotateRight(a6, 31) + b2 + c4) * K2) + ((a6 + z2 + vs) * K0))) + vs) * K2;
    }

    static long murmurHash64WithSeed(byte[] bytes, int offset, int length, long seed) {
        byte[] bArr = bytes;
        int i = length;
        int lengthAligned = (~7) & i;
        int lengthRemainder = i & 7;
        long hash = seed ^ (((long) i) * K3);
        for (int i2 = 0; i2 < lengthAligned; i2 += 8) {
            hash = (hash ^ (shiftMix(LittleEndianByteArray.load64(bytes, offset + i2) * K3) * K3)) * K3;
        }
        if (lengthRemainder != 0) {
            hash = (hash ^ LittleEndianByteArray.load64Safely(bytes, offset + lengthAligned, lengthRemainder)) * K3;
        }
        return shiftMix(shiftMix(hash) * K3);
    }
}
