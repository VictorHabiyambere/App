package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzavl extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzavl zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private zzhca zzd = zzbK();
    private zzhac zze = zzhac.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzavl zzavl = new zzavl();
        zza = zzavl;
        zzhbo.zzca(zzavl.class, zzavl);
    }

    private zzavl() {
    }

    public static zzavk zza() {
        return (zzavk) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzavl zzavl, zzhac zzhac) {
        zzhca zzhca = zzavl.zzd;
        if (!zzhca.zzc()) {
            zzavl.zzd = zzhbo.zzbL(zzhca);
        }
        zzavl.zzd.add(zzhac);
    }

    static /* synthetic */ void zze(zzavl zzavl, zzhac zzhac) {
        zzavl.zzc |= 1;
        zzavl.zze = zzhac;
    }

    static /* synthetic */ void zzf(zzavl zzavl, zzauz zzauz) {
        zzavl.zzg = zzauz.zza();
        zzavl.zzc |= 4;
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
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzave.zza, "zzg", zzauy.zza});
            case 3:
                return new zzavl();
            case 4:
                return new zzavk((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzavl.class) {
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
}
