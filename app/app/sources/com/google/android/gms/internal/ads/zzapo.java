package com.google.android.gms.internal.ads;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzapo {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzapo(int i, int i2, int i3) {
        String str;
        if (i != Integer.MIN_VALUE) {
            str = i + DomExceptionUtils.SEPARATOR;
        } else {
            str = "";
        }
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    public final int zza() {
        zzd();
        return this.zzd;
    }

    public final String zzb() {
        zzd();
        return this.zze;
    }

    public final void zzc() {
        int i = this.zzd;
        int i2 = i == Integer.MIN_VALUE ? this.zzb : i + this.zzc;
        this.zzd = i2;
        String str = this.zza;
        this.zze = str + i2;
    }
}
