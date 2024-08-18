package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazz extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzazz zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private zzbac zzd;
    private zzhac zze = zzhac.zzb;
    private zzhac zzf = zzhac.zzb;

    static {
        zzazz zzazz = new zzazz();
        zza = zzazz;
        zzhbo.zzca(zzazz.class, zzazz);
    }

    private zzazz() {
    }

    public static zzazz zzc(zzhac zzhac, zzhay zzhay) throws zzhcd {
        return (zzazz) zzhbo.zzbr(zza, zzhac, zzhay);
    }

    public final zzbac zzd() {
        zzbac zzbac = this.zzd;
        return zzbac == null ? zzbac.zzg() : zzbac;
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzazz();
            case 4:
                return new zzazy((zzazx) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzazz.class) {
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
        return this.zzf;
    }

    public final zzhac zzf() {
        return this.zze;
    }
}
