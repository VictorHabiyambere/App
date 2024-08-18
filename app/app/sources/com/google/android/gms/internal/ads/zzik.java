package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzik {
    public byte[] zza;
    public byte[] zzb;
    public int zzc;
    public int[] zzd;
    public int[] zze;
    public int zzf;
    public int zzg;
    public int zzh;
    private final MediaCodec.CryptoInfo zzi = new MediaCodec.CryptoInfo();
    private final zzij zzj;

    public zzik() {
        this.zzj = zzgd.zza >= 24 ? new zzij(this.zzi, (zzii) null) : null;
    }

    public final MediaCodec.CryptoInfo zza() {
        return this.zzi;
    }

    public final void zzb(int i) {
        if (i != 0) {
            if (this.zzd == null) {
                this.zzd = new int[1];
                this.zzi.numBytesOfClearData = this.zzd;
            }
            int[] iArr = this.zzd;
            iArr[0] = iArr[0] + i;
        }
    }

    public final void zzc(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.zzf = i;
        this.zzd = iArr;
        this.zze = iArr2;
        this.zzb = bArr;
        this.zza = bArr2;
        this.zzc = i2;
        this.zzg = i3;
        this.zzh = i4;
        this.zzi.numSubSamples = i;
        this.zzi.numBytesOfClearData = iArr;
        this.zzi.numBytesOfEncryptedData = iArr2;
        this.zzi.key = bArr;
        this.zzi.iv = bArr2;
        this.zzi.mode = i2;
        if (zzgd.zza >= 24) {
            zzij zzij = this.zzj;
            if (zzij != null) {
                zzij.zza(zzij, i3, i4);
                return;
            }
            throw null;
        }
    }
}
