package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaup extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzaup zza;
    private static volatile zzhdm zzb;
    private long zzA = -1;
    private long zzB = -1;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private int zzj = 1000;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;
    private int zzn = 1000;
    private long zzo = -1;
    private long zzp = -1;
    private long zzu = -1;
    private long zzv = -1;
    private long zzw;
    private long zzx;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzaup zzaup = new zzaup();
        zza = zzaup;
        zzhbo.zzca(zzaup.class, zzaup);
    }

    private zzaup() {
    }

    public static zzauo zza() {
        return (zzauo) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzaup zzaup, long j) {
        zzaup.zzc |= 1;
        zzaup.zzd = j;
    }

    static /* synthetic */ void zze(zzaup zzaup, long j) {
        zzaup.zzc |= 2;
        zzaup.zze = j;
    }

    static /* synthetic */ void zzf(zzaup zzaup, long j) {
        zzaup.zzc |= 4;
        zzaup.zzf = j;
    }

    static /* synthetic */ void zzg(zzaup zzaup, long j) {
        zzaup.zzc |= 8;
        zzaup.zzg = j;
    }

    static /* synthetic */ void zzh(zzaup zzaup) {
        zzaup.zzc &= -9;
        zzaup.zzg = -1;
    }

    static /* synthetic */ void zzi(zzaup zzaup, long j) {
        zzaup.zzc |= 16;
        zzaup.zzh = j;
    }

    static /* synthetic */ void zzj(zzaup zzaup, long j) {
        zzaup.zzc |= 32;
        zzaup.zzi = j;
    }

    static /* synthetic */ void zzk(zzaup zzaup, zzavc zzavc) {
        zzaup.zzj = zzavc.zza();
        zzaup.zzc |= 64;
    }

    static /* synthetic */ void zzl(zzaup zzaup, long j) {
        zzaup.zzc |= 128;
        zzaup.zzk = j;
    }

    static /* synthetic */ void zzm(zzaup zzaup, long j) {
        zzaup.zzc |= 256;
        zzaup.zzl = j;
    }

    static /* synthetic */ void zzn(zzaup zzaup, long j) {
        zzaup.zzc |= 512;
        zzaup.zzm = j;
    }

    static /* synthetic */ void zzo(zzaup zzaup, zzavc zzavc) {
        zzaup.zzn = zzavc.zza();
        zzaup.zzc |= 1024;
    }

    static /* synthetic */ void zzp(zzaup zzaup, long j) {
        zzaup.zzc |= 2048;
        zzaup.zzo = j;
    }

    static /* synthetic */ void zzq(zzaup zzaup, long j) {
        zzaup.zzc |= 4096;
        zzaup.zzp = j;
    }

    static /* synthetic */ void zzr(zzaup zzaup, long j) {
        zzaup.zzc |= 8192;
        zzaup.zzu = j;
    }

    static /* synthetic */ void zzs(zzaup zzaup, long j) {
        zzaup.zzc |= 16384;
        zzaup.zzv = j;
    }

    static /* synthetic */ void zzt(zzaup zzaup, long j) {
        zzaup.zzc |= 32768;
        zzaup.zzw = j;
    }

    static /* synthetic */ void zzu(zzaup zzaup, long j) {
        zzaup.zzc |= 65536;
        zzaup.zzx = j;
    }

    static /* synthetic */ void zzv(zzaup zzaup, long j) {
        zzaup.zzc |= 131072;
        zzaup.zzy = j;
    }

    static /* synthetic */ void zzw(zzaup zzaup, long j) {
        zzaup.zzc |= 262144;
        zzaup.zzz = j;
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
                return zzbR(zza, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzavb.zza, "zzk", "zzl", "zzm", "zzn", zzavb.zza, "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB"});
            case 3:
                return new zzaup();
            case 4:
                return new zzauo((zzato) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzaup.class) {
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
