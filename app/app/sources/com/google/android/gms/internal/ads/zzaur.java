package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaur extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzaur zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzaur zzaur = new zzaur();
        zza = zzaur;
        zzhbo.zzca(zzaur.class, zzaur);
    }

    private zzaur() {
    }

    public static zzauq zza() {
        return (zzauq) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzaur zzaur, long j) {
        zzaur.zzc |= 1;
        zzaur.zzd = j;
    }

    static /* synthetic */ void zze(zzaur zzaur, long j) {
        zzaur.zzc |= 4;
        zzaur.zzf = j;
    }

    static /* synthetic */ void zzf(zzaur zzaur, long j) {
        zzaur.zzc |= 8;
        zzaur.zzg = j;
    }

    static /* synthetic */ void zzg(zzaur zzaur, long j) {
        zzaur.zzc |= 16;
        zzaur.zzh = j;
    }

    static /* synthetic */ void zzh(zzaur zzaur, long j) {
        zzaur.zzc |= 32;
        zzaur.zzi = j;
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
                return zzbR(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzaur();
            case 4:
                return new zzauq((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzaur.class) {
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
