package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzr {
    private int zza;
    private int zzb;
    private int zzc;
    private byte[] zzd;
    private int zze;
    private int zzf;

    public zzr() {
        this.zza = -1;
        this.zzb = -1;
        this.zzc = -1;
        this.zze = -1;
        this.zzf = -1;
    }

    /* synthetic */ zzr(zzt zzt, zzq zzq) {
        this.zza = zzt.zzd;
        this.zzb = zzt.zze;
        this.zzc = zzt.zzf;
        this.zzd = zzt.zzg;
        this.zze = zzt.zzh;
        this.zzf = zzt.zzi;
    }

    public final zzr zza(int i) {
        this.zzf = i;
        return this;
    }

    public final zzr zzb(int i) {
        this.zzb = i;
        return this;
    }

    public final zzr zzc(int i) {
        this.zza = i;
        return this;
    }

    public final zzr zzd(int i) {
        this.zzc = i;
        return this;
    }

    public final zzr zze(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzr zzf(int i) {
        this.zze = i;
        return this;
    }

    public final zzt zzg() {
        return new zzt(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, (zzs) null);
    }
}
