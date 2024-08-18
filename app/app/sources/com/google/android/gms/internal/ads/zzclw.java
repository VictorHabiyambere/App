package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzclw {
    private zzcjg zza;
    private zzcnj zzb;
    private zzflx zzc;
    private zzcnv zzd;
    private zzfir zze;

    private zzclw() {
        throw null;
    }

    /* synthetic */ zzclw(zzclv zzclv) {
    }

    public final zzcjd zza() {
        zzhkx.zzc(this.zza, zzcjg.class);
        zzhkx.zzc(this.zzb, zzcnj.class);
        if (this.zzc == null) {
            this.zzc = new zzflx();
        }
        if (this.zzd == null) {
            this.zzd = new zzcnv();
        }
        if (this.zze == null) {
            this.zze = new zzfir();
        }
        return new zzcla(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzckz) null);
    }

    public final zzclw zzb(zzcjg zzcjg) {
        this.zza = zzcjg;
        return this;
    }

    public final zzclw zzc(zzcnj zzcnj) {
        this.zzb = zzcnj;
        return this;
    }
}
