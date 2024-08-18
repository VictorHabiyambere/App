package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzsh extends zzea {
    private zzdx zzd = zzdx.zza;
    private int zze;
    private boolean zzf;
    private int zzg;
    private long zzh;
    private int zzi = 0;
    private byte[] zzj = zzgd.zzf;
    private int zzk = 0;
    private int zzl = 0;
    private byte[] zzm = zzgd.zzf;

    private final int zzq(int i) {
        boolean z = true;
        int zzr = ((zzr(2000000) - this.zzi) * this.zze) - (this.zzj.length >> 1);
        if (zzr < 0) {
            z = false;
        }
        zzeq.zzf(z);
        int i2 = this.zze;
        return (((int) Math.min((((float) i) * 0.2f) + 0.5f, (float) zzr)) / i2) * i2;
    }

    private final int zzr(long j) {
        return (int) ((j * ((long) this.zzd.zzb)) / AnimationKt.MillisToNanos);
    }

    private static int zzs(byte b, byte b2) {
        return (b << 8) | (b2 & 255);
    }

    private final void zzt(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = this.zzl;
        int length = this.zzj.length;
        boolean z3 = true;
        if (i3 != length) {
            if (z) {
                z = true;
            } else {
                return;
            }
        }
        if (this.zzi != 0) {
            int i4 = length >> 1;
            int i5 = i3 - i4;
            if (z) {
                int zzq = zzq(i5) + (this.zzj.length >> 1);
                zzu(zzq, 2);
                int i6 = i4 + i5;
                i2 = zzq;
                i = i6;
            } else {
                int zzq2 = zzq(i5);
                zzu(zzq2, 1);
                i2 = zzq2;
                i = i5;
            }
        } else if (z) {
            zzu(i3, 3);
            i = i3;
            i2 = i;
        } else {
            zzeq.zzf(i3 >= (length >> 1));
            i = this.zzj.length >> 1;
            zzu(i, 0);
            i2 = i;
        }
        if (i % this.zze == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzeq.zzg(z2, "bytesConsumed is not aligned to frame size: %s" + i);
        if (i3 < i2) {
            z3 = false;
        }
        zzeq.zzf(z3);
        this.zzl -= i;
        int i7 = this.zzk + i;
        this.zzk = i7;
        this.zzk = i7 % this.zzj.length;
        int i8 = this.zzi;
        int i9 = this.zze;
        this.zzi = i8 + (i2 / i9);
        this.zzh += (long) ((i - i2) / i9);
    }

    private final void zzu(int i, int i2) {
        boolean z;
        int i3;
        if (i != 0) {
            boolean z2 = true;
            if (this.zzl >= i) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzd(z);
            if (i2 == 2) {
                int i4 = this.zzk;
                int i5 = this.zzl;
                int i6 = i4 + i5;
                byte[] bArr = this.zzj;
                int length = bArr.length;
                if (i6 <= length) {
                    System.arraycopy(bArr, i6 - i, this.zzm, 0, i);
                } else {
                    int i7 = i5 - (length - i4);
                    if (i7 >= i) {
                        System.arraycopy(bArr, i7 - i, this.zzm, 0, i);
                    } else {
                        int i8 = i - i7;
                        System.arraycopy(bArr, length - i8, this.zzm, 0, i8);
                        System.arraycopy(this.zzj, 0, this.zzm, i8, i7);
                    }
                }
            } else {
                int i9 = this.zzk;
                int i10 = i9 + i;
                byte[] bArr2 = this.zzj;
                int length2 = bArr2.length;
                if (i10 <= length2) {
                    System.arraycopy(bArr2, i9, this.zzm, 0, i);
                } else {
                    int i11 = length2 - i9;
                    System.arraycopy(bArr2, i9, this.zzm, 0, i11);
                    System.arraycopy(this.zzj, 0, this.zzm, i11, i - i11);
                }
            }
            zzeq.zze(i % this.zze == 0, "sizeToOutput is not aligned to frame size: " + i);
            zzeq.zzf(this.zzk < this.zzj.length);
            byte[] bArr3 = this.zzm;
            String str = "byteOutput size is not aligned to frame size " + i;
            if (i % this.zze != 0) {
                z2 = false;
            }
            zzeq.zze(z2, str);
            if (i2 != 3) {
                for (int i12 = 0; i12 < i; i12 += 2) {
                    int i13 = i12 + 1;
                    int zzs = zzs(bArr3[i13], bArr3[i12]);
                    if (i2 == 0) {
                        i3 = ((((i12 * 1000) / (i - 1)) * -90) / 1000) + 100;
                    } else {
                        i3 = 10;
                        if (i2 == 2) {
                            i3 = 10 + (((90000 * i12) / (i - 1)) / 1000);
                        }
                    }
                    int i14 = (zzs * i3) / 100;
                    if (i14 >= 32767) {
                        bArr3[i12] = -1;
                        bArr3[i13] = Byte.MAX_VALUE;
                    } else if (i14 <= -32768) {
                        bArr3[i12] = 0;
                        bArr3[i13] = Byte.MIN_VALUE;
                    } else {
                        bArr3[i12] = (byte) (i14 & 255);
                        bArr3[i13] = (byte) (i14 >> 8);
                    }
                }
            }
            zzj(i).put(bArr3, 0, i).flip();
        }
    }

    private static final boolean zzv(byte b, byte b2) {
        return Math.abs(zzs(b, b2)) > 1024;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int position;
        boolean z;
        int limit;
        int i;
        boolean z2;
        while (byteBuffer.hasRemaining() && !zzn()) {
            boolean z3 = true;
            switch (this.zzg) {
                case 0:
                    int limit2 = byteBuffer.limit();
                    byteBuffer.limit(Math.min(limit2, byteBuffer.position() + this.zzj.length));
                    int limit3 = byteBuffer.limit() - 1;
                    while (true) {
                        if (limit3 < byteBuffer.position()) {
                            position = byteBuffer.position();
                        } else if (zzv(byteBuffer.get(limit3), byteBuffer.get(limit3 - 1))) {
                            int i2 = this.zze;
                            position = ((limit3 / i2) * i2) + i2;
                        } else {
                            limit3 -= 2;
                        }
                    }
                    if (position == byteBuffer.position()) {
                        this.zzg = 1;
                    } else {
                        byteBuffer.limit(Math.min(position, byteBuffer.capacity()));
                        zzj(byteBuffer.remaining()).put(byteBuffer).flip();
                    }
                    byteBuffer.limit(limit2);
                    break;
                default:
                    if (this.zzk < this.zzj.length) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzeq.zzf(z);
                    int limit4 = byteBuffer.limit();
                    int position2 = byteBuffer.position() + 1;
                    while (true) {
                        if (position2 >= byteBuffer.limit()) {
                            limit = byteBuffer.limit();
                        } else if (zzv(byteBuffer.get(position2), byteBuffer.get(position2 - 1))) {
                            int i3 = this.zze;
                            limit = i3 * (position2 / i3);
                        } else {
                            position2 += 2;
                        }
                    }
                    int position3 = limit - byteBuffer.position();
                    int i4 = this.zzk;
                    int i5 = this.zzl;
                    int i6 = i4 + i5;
                    int length = this.zzj.length;
                    if (i6 < length) {
                        i = length - i6;
                    } else {
                        i6 = i5 - (length - i4);
                        i = i4 - i6;
                    }
                    int min = Math.min(position3, i);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.zzj, i6, min);
                    int i7 = this.zzl + min;
                    this.zzl = i7;
                    if (i7 <= this.zzj.length) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzeq.zzf(z2);
                    if (limit >= limit4 || position3 >= i) {
                        z3 = false;
                    }
                    zzt(z3);
                    if (z3) {
                        this.zzg = 0;
                        this.zzi = 0;
                    }
                    byteBuffer.limit(limit4);
                    break;
            }
        }
    }

    public final boolean zzg() {
        return this.zzd.zzb != -1 && this.zzf;
    }

    /* access modifiers changed from: protected */
    public final zzdx zzi(zzdx zzdx) throws zzdy {
        if (zzdx.zzd == 2) {
            this.zzd = zzdx;
            int i = zzdx.zzc;
            this.zze = i + i;
            return zzdx;
        }
        throw new zzdy("Unhandled input format:", zzdx);
    }

    public final void zzk() {
        if (zzg()) {
            int i = this.zze;
            int zzr = ((zzr(100000) / 2) / i) * i;
            int i2 = zzr + zzr;
            if (this.zzj.length != i2) {
                this.zzj = new byte[i2];
                this.zzm = new byte[i2];
            }
        }
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzk = 0;
        this.zzl = 0;
    }

    public final void zzl() {
        if (this.zzl > 0) {
            zzt(true);
            this.zzi = 0;
        }
    }

    public final void zzm() {
        this.zzf = false;
        this.zzd = zzdx.zza;
        this.zzj = zzgd.zzf;
        this.zzm = zzgd.zzf;
    }

    public final long zzo() {
        return this.zzh;
    }

    public final void zzp(boolean z) {
        this.zzf = z;
    }
}
