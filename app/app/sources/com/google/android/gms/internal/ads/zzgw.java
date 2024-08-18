package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgw extends zzgv {
    private final byte[] zza;
    private Uri zzb;
    private int zzc;
    private int zzd;
    private boolean zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgw(byte[] bArr) {
        super(false);
        boolean z = false;
        zzeq.zzd(bArr.length > 0 ? true : z);
        this.zza = bArr;
    }

    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.zza, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzhh zzhh) throws IOException {
        this.zzb = zzhh.zza;
        zzi(zzhh);
        long j = zzhh.zze;
        int length = this.zza.length;
        if (j <= ((long) length)) {
            int i = (int) j;
            this.zzc = i;
            int i2 = length - i;
            this.zzd = i2;
            long j2 = zzhh.zzf;
            if (j2 != -1) {
                this.zzd = (int) Math.min((long) i2, j2);
            }
            this.zze = true;
            zzj(zzhh);
            long j3 = zzhh.zzf;
            return j3 != -1 ? j3 : (long) this.zzd;
        }
        throw new zzhc(2008);
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() {
        if (this.zze) {
            this.zze = false;
            zzh();
        }
        this.zzb = null;
    }
}
