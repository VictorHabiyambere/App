package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzra extends zzea {
    private int[] zzd;
    private int[] zze;

    zzra() {
    }

    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        if (iArr != null) {
            int position = byteBuffer.position();
            int limit = byteBuffer.limit();
            ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
            while (position < limit) {
                for (int i : iArr) {
                    zzj.putShort(byteBuffer.getShort(i + i + position));
                }
                position += this.zzb.zze;
            }
            byteBuffer.position(limit);
            zzj.flip();
            return;
        }
        throw null;
    }

    public final zzdx zzi(zzdx zzdx) throws zzdy {
        boolean z;
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdx.zza;
        }
        if (zzdx.zzd == 2) {
            if (zzdx.zzc != iArr.length) {
                z = true;
            } else {
                z = false;
            }
            int i = 0;
            while (true) {
                int length = iArr.length;
                if (i >= length) {
                    return z ? new zzdx(zzdx.zzb, length, 2) : zzdx.zza;
                }
                int i2 = iArr[i];
                if (i2 < zzdx.zzc) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new zzdy("Unhandled input format:", zzdx);
                }
            }
        } else {
            throw new zzdy("Unhandled input format:", zzdx);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zze = this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(int[] iArr) {
        this.zzd = iArr;
    }
}
