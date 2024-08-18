package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzti extends zzin {
    private long zzg;
    private int zzh;
    private int zzi = 32;

    public zzti() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzh = 0;
    }

    public final int zzl() {
        return this.zzh;
    }

    public final long zzm() {
        return this.zzg;
    }

    public final void zzn(int i) {
        this.zzi = i;
    }

    public final boolean zzo(zzin zzin) {
        ByteBuffer byteBuffer;
        zzeq.zzd(!zzin.zzd(1073741824));
        zzeq.zzd(!zzin.zzd(268435456));
        zzeq.zzd(!zzin.zzd(4));
        if (zzp()) {
            if (this.zzh >= this.zzi) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzin.zzc;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzc) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000)) {
                return false;
            }
        }
        int i = this.zzh;
        this.zzh = i + 1;
        if (i == 0) {
            this.zze = zzin.zze;
            if (zzin.zzd(1)) {
                zzc(1);
            }
        }
        ByteBuffer byteBuffer3 = zzin.zzc;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzc.put(byteBuffer3);
        }
        this.zzg = zzin.zze;
        return true;
    }

    public final boolean zzp() {
        return this.zzh > 0;
    }
}
