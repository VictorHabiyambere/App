package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzatd extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzatd zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private long zzj;
    private String zzk = "";
    private long zzl;
    private String zzm = "";
    private String zzn = "";
    private zzhca zzo = zzbK();
    private int zzp;

    static {
        zzatd zzatd = new zzatd();
        zza = zzatd;
        zzhbo.zzca(zzatd.class, zzatd);
    }

    private zzatd() {
    }

    public static zzasx zza() {
        return (zzasx) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzatd zzatd, long j) {
        zzatd.zzc |= 2;
        zzatd.zze = j;
    }

    static /* synthetic */ void zze(zzatd zzatd, String str) {
        str.getClass();
        zzatd.zzc |= 4;
        zzatd.zzf = str;
    }

    static /* synthetic */ void zzf(zzatd zzatd, String str) {
        str.getClass();
        zzatd.zzc |= 8;
        zzatd.zzg = str;
    }

    static /* synthetic */ void zzg(zzatd zzatd, String str) {
        zzatd.zzc |= 16;
        zzatd.zzh = str;
    }

    static /* synthetic */ void zzh(zzatd zzatd, String str) {
        zzatd.zzc |= 1024;
        zzatd.zzn = str;
    }

    static /* synthetic */ void zzi(zzatd zzatd, zzatc zzatc) {
        zzatd.zzp = zzatc.zza();
        zzatd.zzc |= 2048;
    }

    static /* synthetic */ void zzj(zzatd zzatd, String str) {
        str.getClass();
        zzatd.zzc |= 1;
        zzatd.zzd = str;
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
                return zzbR(zza, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzasz.class, "zzp", zzatb.zza});
            case 3:
                return new zzatd();
            case 4:
                return new zzasx((zzasw) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzatd.class) {
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
