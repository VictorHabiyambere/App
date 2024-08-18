package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzn {
    public final int zza;
    public final zzmq[] zzb;
    public final zzzg[] zzc;
    public final zzdp zzd;
    public final Object zze;

    public zzzn(zzmq[] zzmqArr, zzzg[] zzzgArr, zzdp zzdp, Object obj) {
        this.zzb = zzmqArr;
        this.zzc = (zzzg[]) zzzgArr.clone();
        this.zzd = zzdp;
        this.zze = obj;
        this.zza = zzmqArr.length;
    }

    public final boolean zza(zzzn zzzn, int i) {
        if (zzzn != null && zzgd.zzG(this.zzb[i], zzzn.zzb[i]) && zzgd.zzG(this.zzc[i], zzzn.zzc[i])) {
            return true;
        }
        return false;
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}
