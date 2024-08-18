package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzvh extends zzvc {
    public static final Object zzd = new Object();
    private final Object zze;
    /* access modifiers changed from: private */
    public final Object zzf;

    private zzvh(zzdc zzdc, Object obj, Object obj2) {
        super(zzdc);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzvh zzq(zzbu zzbu) {
        return new zzvh(new zzvi(zzbu), zzdb.zza, zzd);
    }

    public static zzvh zzr(zzdc zzdc, Object obj, Object obj2) {
        return new zzvh(zzdc, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return this.zzc.zza(obj);
    }

    public final zzcz zzd(int i, zzcz zzcz, boolean z) {
        this.zzc.zzd(i, zzcz, z);
        if (zzgd.zzG(zzcz.zzc, this.zzf) && z) {
            zzcz.zzc = zzd;
        }
        return zzcz;
    }

    public final zzdb zze(int i, zzdb zzdb, long j) {
        this.zzc.zze(i, zzdb, j);
        if (zzgd.zzG(zzdb.zzc, this.zze)) {
            zzdb.zzc = zzdb.zza;
        }
        return zzdb;
    }

    public final Object zzf(int i) {
        Object zzf2 = this.zzc.zzf(i);
        return zzgd.zzG(zzf2, this.zzf) ? zzd : zzf2;
    }

    public final zzvh zzp(zzdc zzdc) {
        return new zzvh(zzdc, this.zze, this.zzf);
    }
}
