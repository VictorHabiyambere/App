package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcn {
    private final zzaf zza = new zzaf();

    public final zzcn zza(int i) {
        this.zza.zza(i);
        return this;
    }

    public final zzcn zzb(zzcp zzcp) {
        zzah zza2 = zzcp.zzd;
        for (int i = 0; i < zza2.zzb(); i++) {
            this.zza.zza(zza2.zza(i));
        }
        return this;
    }

    public final zzcn zzc(int... iArr) {
        for (int i = 0; i < 20; i++) {
            this.zza.zza(iArr[i]);
        }
        return this;
    }

    public final zzcn zzd(int i, boolean z) {
        if (z) {
            this.zza.zza(i);
        }
        return this;
    }

    public final zzcp zze() {
        return new zzcp(this.zza.zzb(), (zzco) null);
    }
}
