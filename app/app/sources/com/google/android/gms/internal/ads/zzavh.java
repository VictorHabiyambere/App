package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzavh extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzavh zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzhac zzf = zzhac.zzb;

    static {
        zzavh zzavh = new zzavh();
        zza = zzavh;
        zzhbo.zzca(zzavh.class, zzavh);
    }

    private zzavh() {
    }

    public static zzavh zzd() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzavh();
            case 4:
                return new zzavg((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzavh.class) {
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

    public final boolean zze() {
        return (this.zzc & 1) != 0;
    }
}
