package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgz extends zzgv {
    private zzhh zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgz() {
        super(false);
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
        byte[] bArr2 = this.zzb;
        int i4 = zzgd.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    public final long zzb(zzhh zzhh) throws IOException {
        zzi(zzhh);
        this.zza = zzhh;
        Uri normalizeScheme = zzhh.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzeq.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        int i = zzgd.zza;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length == 2) {
            String str = split[1];
            if (split[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str, 0);
                } catch (IllegalArgumentException e) {
                    throw zzch.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
                }
            } else {
                this.zzb = URLDecoder.decode(str, zzfxs.zza.name()).getBytes(zzfxs.zzc);
            }
            long j = zzhh.zze;
            int length = this.zzb.length;
            if (j <= ((long) length)) {
                int i2 = (int) j;
                this.zzc = i2;
                int i3 = length - i2;
                this.zzd = i3;
                long j2 = zzhh.zzf;
                if (j2 != -1) {
                    this.zzd = (int) Math.min((long) i3, j2);
                }
                zzj(zzhh);
                long j3 = zzhh.zzf;
                return j3 != -1 ? j3 : (long) this.zzd;
            }
            this.zzb = null;
            throw new zzhc(2008);
        }
        throw zzch.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(normalizeScheme))), (Throwable) null);
    }

    public final Uri zzc() {
        zzhh zzhh = this.zza;
        if (zzhh != null) {
            return zzhh.zza;
        }
        return null;
    }

    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
