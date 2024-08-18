package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzasu extends zzhjy {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk = 1.0d;
    private float zzl = 1.0f;
    private zzhki zzm = zzhki.zza;
    private long zzn;

    public zzasu() {
        super("mvhd");
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzj;
    }

    public final long zze() {
        return this.zzi;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzhkd.zza(zzasq.zzf(byteBuffer));
            this.zzh = zzhkd.zza(zzasq.zzf(byteBuffer));
            this.zzi = zzasq.zze(byteBuffer);
            this.zzj = zzasq.zzf(byteBuffer);
        } else {
            this.zza = zzhkd.zza(zzasq.zze(byteBuffer));
            this.zzh = zzhkd.zza(zzasq.zze(byteBuffer));
            this.zzi = zzasq.zze(byteBuffer);
            this.zzj = zzasq.zze(byteBuffer);
        }
        this.zzk = zzasq.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((float) ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8)))))) / 256.0f;
        zzasq.zzd(byteBuffer);
        zzasq.zze(byteBuffer);
        zzasq.zze(byteBuffer);
        double zzb = zzasq.zzb(byteBuffer);
        double zzb2 = zzasq.zzb(byteBuffer);
        double zza2 = zzasq.zza(byteBuffer);
        this.zzm = new zzhki(zzb, zzb2, zzasq.zzb(byteBuffer), zzasq.zzb(byteBuffer), zza2, zzasq.zza(byteBuffer), zzasq.zza(byteBuffer), zzasq.zzb(byteBuffer), zzasq.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzasq.zze(byteBuffer);
    }
}
