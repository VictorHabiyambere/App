package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzauw extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzauw zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private zzhac zzd = zzhac.zzb;
    private zzhac zze;
    private zzhac zzf;
    private zzhac zzg;

    static {
        zzauw zzauw = new zzauw();
        zza = zzauw;
        zzhbo.zzca(zzauw.class, zzauw);
    }

    private zzauw() {
        zzhac zzhac = zzhac.zzb;
        this.zze = zzhac;
        this.zzf = zzhac;
        this.zzg = zzhac;
    }

    public static zzauv zza() {
        return (zzauv) zza.zzaZ();
    }

    public static zzauw zzd(byte[] bArr, zzhay zzhay) throws zzhcd {
        return (zzauw) zzhbo.zzbx(zza, bArr, zzhay);
    }

    static /* synthetic */ void zzi(zzauw zzauw, zzhac zzhac) {
        zzauw.zzc |= 1;
        zzauw.zzd = zzhac;
    }

    static /* synthetic */ void zzj(zzauw zzauw, zzhac zzhac) {
        zzauw.zzc |= 2;
        zzauw.zze = zzhac;
    }

    static /* synthetic */ void zzk(zzauw zzauw, zzhac zzhac) {
        zzauw.zzc |= 4;
        zzauw.zzf = zzhac;
    }

    static /* synthetic */ void zzl(zzauw zzauw, zzhac zzhac) {
        zzauw.zzc |= 8;
        zzauw.zzg = zzhac;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzhbn zzhbn, Object obj, Object obj2) {
        zzhbn zzhbn2 = zzhbn.GET_MEMOIZED_IS_INITIALIZED;
        switch (zzhbn.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzauw();
            case 4:
                return new zzauv((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzauw.class) {
                        zzhdm = zzb;
                        if (zzhdm == null) {
                            zzhdm = new zzhbj(zza);
                            zzb = zzhdm;
                        }
                    }
                }
                return zzhdm;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzhac zze() {
        return this.zzd;
    }

    public final zzhac zzf() {
        return this.zze;
    }

    public final zzhac zzg() {
        return this.zzg;
    }

    public final zzhac zzh() {
        return this.zzf;
    }
}
