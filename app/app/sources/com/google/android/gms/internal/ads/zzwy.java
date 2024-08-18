package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwy {
    private final zzfu zza = new zzfu(32);
    private zzwx zzb = new zzwx(0, 65536);
    private zzwx zzc;
    private zzwx zzd;
    private long zze;
    private final zzzv zzf;

    public zzwy(zzzv zzzv) {
        this.zzf = zzzv;
        zzwx zzwx = this.zzb;
        this.zzc = zzwx;
        this.zzd = zzwx;
    }

    private final int zzi(int i) {
        zzwx zzwx = this.zzd;
        if (zzwx.zzc == null) {
            zzzo zzb2 = this.zzf.zzb();
            zzwx zzwx2 = new zzwx(this.zzd.zzb, 65536);
            zzwx.zzc = zzb2;
            zzwx.zzd = zzwx2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzwx zzj(zzwx zzwx, long j) {
        while (j >= zzwx.zzb) {
            zzwx = zzwx.zzd;
        }
        return zzwx;
    }

    private static zzwx zzk(zzwx zzwx, long j, ByteBuffer byteBuffer, int i) {
        zzwx zzj = zzj(zzwx, j);
        while (i > 0) {
            int min = Math.min(i, (int) (zzj.zzb - j));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j), min);
            i -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwx zzl(zzwx zzwx, long j, byte[] bArr, int i) {
        zzwx zzj = zzj(zzwx, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (zzj.zzb - j));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzwx zzm(zzwx zzwx, zzin zzin, zzxa zzxa, zzfu zzfu) {
        zzwx zzwx2;
        int i;
        zzin zzin2 = zzin;
        zzxa zzxa2 = zzxa;
        zzfu zzfu2 = zzfu;
        if (zzin.zzk()) {
            long j = zzxa2.zzb;
            zzfu2.zzH(1);
            zzwx zzl = zzl(zzwx, j, zzfu.zzM(), 1);
            long j2 = j + 1;
            byte b = zzfu.zzM()[0];
            byte b2 = b & 128;
            byte b3 = b & Byte.MAX_VALUE;
            zzik zzik = zzin2.zzb;
            byte[] bArr = zzik.zza;
            if (bArr == null) {
                zzik.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = b2 != 0;
            zzwx2 = zzl(zzl, j2, zzik.zza, b3);
            long j3 = j2 + ((long) b3);
            if (z) {
                zzfu2.zzH(2);
                zzwx2 = zzl(zzwx2, j3, zzfu.zzM(), 2);
                j3 += 2;
                i = zzfu.zzq();
            } else {
                i = 1;
            }
            int[] iArr = zzik.zzd;
            if (iArr == null || iArr.length < i) {
                iArr = new int[i];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzik.zze;
            if (iArr3 == null || iArr3.length < i) {
                iArr3 = new int[i];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i2 = i * 6;
                zzfu2.zzH(i2);
                zzwx2 = zzl(zzwx2, j3, zzfu.zzM(), i2);
                j3 += (long) i2;
                zzfu2.zzK(0);
                for (int i3 = 0; i3 < i; i3++) {
                    iArr2[i3] = zzfu.zzq();
                    iArr4[i3] = zzfu.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzxa2.zza - ((int) (j3 - zzxa2.zzb));
            }
            zzaez zzaez = zzxa2.zzc;
            int i4 = zzgd.zza;
            zzik.zzc(i, iArr2, iArr4, zzaez.zzb, zzik.zza, zzaez.zza, zzaez.zzc, zzaez.zzd);
            long j4 = zzxa2.zzb;
            int i5 = (int) (j3 - j4);
            zzxa2.zzb = j4 + ((long) i5);
            zzxa2.zza -= i5;
        } else {
            zzwx2 = zzwx;
        }
        if (zzin.zze()) {
            zzfu2.zzH(4);
            zzwx zzl2 = zzl(zzwx2, zzxa2.zzb, zzfu.zzM(), 4);
            int zzp = zzfu.zzp();
            zzxa2.zzb += 4;
            zzxa2.zza -= 4;
            zzin2.zzi(zzp);
            zzwx zzk = zzk(zzl2, zzxa2.zzb, zzin2.zzc, zzp);
            zzxa2.zzb += (long) zzp;
            int i6 = zzxa2.zza - zzp;
            zzxa2.zza = i6;
            ByteBuffer byteBuffer = zzin2.zzf;
            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                zzin2.zzf = ByteBuffer.allocate(i6);
            } else {
                zzin2.zzf.clear();
            }
            return zzk(zzk, zzxa2.zzb, zzin2.zzf, zzxa2.zza);
        }
        zzin2.zzi(zzxa2.zza);
        return zzk(zzwx2, zzxa2.zzb, zzin2.zzc, zzxa2.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzwx zzwx = this.zzd;
        if (j == zzwx.zzb) {
            this.zzd = zzwx.zzd;
        }
    }

    public final int zza(zzu zzu, int i, boolean z) throws IOException {
        int zzi = zzi(i);
        zzwx zzwx = this.zzd;
        int zza2 = zzu.zza(zzwx.zzc.zza, zzwx.zza(this.zze), zzi);
        if (zza2 != -1) {
            zzn(zza2);
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzwx zzwx;
        if (j != -1) {
            while (true) {
                zzwx = this.zzb;
                if (j < zzwx.zzb) {
                    break;
                }
                this.zzf.zzc(zzwx.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzwx.zza) {
                this.zzc = zzwx;
            }
        }
    }

    public final void zzd(zzin zzin, zzxa zzxa) {
        zzm(this.zzc, zzin, zzxa, this.zza);
    }

    public final void zze(zzin zzin, zzxa zzxa) {
        this.zzc = zzm(this.zzc, zzin, zzxa, this.zza);
    }

    public final void zzf() {
        zzwx zzwx = this.zzb;
        if (zzwx.zzc != null) {
            this.zzf.zzd(zzwx);
            zzwx.zzb();
        }
        this.zzb.zze(0, 65536);
        zzwx zzwx2 = this.zzb;
        this.zzc = zzwx2;
        this.zzd = zzwx2;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfu zzfu, int i) {
        while (i > 0) {
            int zzi = zzi(i);
            zzwx zzwx = this.zzd;
            zzfu.zzG(zzwx.zzc.zza, zzwx.zza(this.zze), zzi);
            i -= zzi;
            zzn(zzi);
        }
    }
}
