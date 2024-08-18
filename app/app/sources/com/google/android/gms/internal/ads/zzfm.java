package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfm {
    private int zza;
    private int zzb;
    private long[] zzc;
    private int zzd;

    public zzfm() {
        throw null;
    }

    public zzfm(int i) {
        int i2 = 16;
        if (Integer.bitCount(16) != 1) {
            int highestOneBit = Integer.highestOneBit(15);
            i2 = highestOneBit + highestOneBit;
        }
        this.zza = 0;
        this.zzb = 0;
        this.zzc = new long[i2];
        this.zzd = this.zzc.length - 1;
    }

    public final long zza() {
        if (this.zzb != 0) {
            return this.zzc[this.zza];
        }
        throw new NoSuchElementException();
    }

    public final long zzb() {
        int i = this.zzb;
        if (i != 0) {
            long[] jArr = this.zzc;
            int i2 = this.zza;
            long j = jArr[i2];
            this.zza = this.zzd & (i2 + 1);
            this.zzb = i - 1;
            return j;
        }
        throw new NoSuchElementException();
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = 0;
    }

    public final boolean zzd() {
        return this.zzb == 0;
    }
}
