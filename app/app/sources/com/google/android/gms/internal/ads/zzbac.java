package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbac extends zzhbo implements zzhdf {
    /* access modifiers changed from: private */
    public static final zzbac zza;
    private static volatile zzhdm zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzbac zzbac = new zzbac();
        zza = zzbac;
        zzhbo.zzca(zzbac.class, zzbac);
    }

    private zzbac() {
    }

    public static zzbab zze() {
        return (zzbab) zza.zzaZ();
    }

    public static zzbac zzg() {
        return zza;
    }

    public static zzbac zzh(zzhac zzhac) throws zzhcd {
        return (zzbac) zzhbo.zzbm(zza, zzhac);
    }

    public static zzbac zzi(zzhac zzhac, zzhay zzhay) throws zzhcd {
        return (zzbac) zzhbo.zzbr(zza, zzhac, zzhay);
    }

    static /* synthetic */ void zzl(zzbac zzbac, String str) {
        str.getClass();
        zzbac.zzc |= 1;
        zzbac.zzd = str;
    }

    static /* synthetic */ void zzm(zzbac zzbac, long j) {
        zzbac.zzc |= 16;
        zzbac.zzh = j;
    }

    static /* synthetic */ void zzn(zzbac zzbac, String str) {
        str.getClass();
        zzbac.zzc |= 2;
        zzbac.zze = str;
    }

    static /* synthetic */ void zzo(zzbac zzbac, long j) {
        zzbac.zzc |= 4;
        zzbac.zzf = j;
    }

    static /* synthetic */ void zzp(zzbac zzbac, long j) {
        zzbac.zzc |= 8;
        zzbac.zzg = j;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzh;
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
                return zzbR(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzbac();
            case 4:
                return new zzbab((zzbaa) null);
            case 5:
                return zza;
            case 6:
                zzhdm zzhdm = zzb;
                if (zzhdm == null) {
                    synchronized (zzbac.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
