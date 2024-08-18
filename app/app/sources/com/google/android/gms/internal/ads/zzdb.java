package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdb {
    private static final String zzA = Integer.toString(8, 36);
    private static final String zzB = Integer.toString(9, 36);
    private static final String zzC = Integer.toString(10, 36);
    private static final String zzD = Integer.toString(11, 36);
    private static final String zzE = Integer.toString(12, 36);
    private static final String zzF = Integer.toString(13, 36);
    public static final Object zza = new Object();
    @Deprecated
    public static final zzn zzb = new zzda();
    private static final Object zzr = new Object();
    private static final zzbu zzs;
    private static final String zzt = Integer.toString(1, 36);
    private static final String zzu = Integer.toString(2, 36);
    private static final String zzv = Integer.toString(3, 36);
    private static final String zzw = Integer.toString(4, 36);
    private static final String zzx = Integer.toString(5, 36);
    private static final String zzy = Integer.toString(6, 36);
    private static final String zzz = Integer.toString(7, 36);
    public Object zzc = zza;
    @Deprecated
    public Object zzd;
    public zzbu zze = zzs;
    public long zzf;
    public long zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    @Deprecated
    public boolean zzk;
    public zzbk zzl;
    public boolean zzm;
    public long zzn;
    public long zzo;
    public int zzp;
    public int zzq;

    static {
        zzaw zzaw = new zzaw();
        zzaw.zza("androidx.media3.common.Timeline");
        zzaw.zzb(Uri.EMPTY);
        zzs = zzaw.zzc();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        zzdb zzdb = (zzdb) obj;
        return zzgd.zzG(this.zzc, zzdb.zzc) && zzgd.zzG(this.zze, zzdb.zze) && zzgd.zzG((Object) null, (Object) null) && zzgd.zzG(this.zzl, zzdb.zzl) && this.zzf == zzdb.zzf && this.zzg == zzdb.zzg && this.zzh == zzdb.zzh && this.zzi == zzdb.zzi && this.zzj == zzdb.zzj && this.zzm == zzdb.zzm && this.zzo == zzdb.zzo && this.zzp == zzdb.zzp && this.zzq == zzdb.zzq;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zzc.hashCode() + 217) * 31) + this.zze.hashCode();
        zzbk zzbk = this.zzl;
        if (zzbk == null) {
            i = 0;
        } else {
            i = zzbk.hashCode();
        }
        long j = this.zzf;
        long j2 = this.zzg;
        long j3 = this.zzh;
        int i2 = (((((((((((((hashCode * 961) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzm ? 1 : 0);
        long j4 = this.zzo;
        return ((((((i2 * 961) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.zzp) * 31) + this.zzq) * 31;
    }

    public final zzdb zza(Object obj, zzbu zzbu, Object obj2, long j, long j2, long j3, boolean z, boolean z2, zzbk zzbk, long j4, long j5, int i, int i2, long j6) {
        zzbk zzbk2 = zzbk;
        this.zzc = obj;
        this.zze = zzbu == null ? zzs : zzbu;
        this.zzd = null;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = -9223372036854775807L;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = zzbk2 != null;
        this.zzl = zzbk2;
        this.zzn = 0;
        this.zzo = j5;
        this.zzp = 0;
        this.zzq = 0;
        this.zzm = false;
        return this;
    }

    public final boolean zzb() {
        zzeq.zzf(this.zzk == (this.zzl != null));
        return this.zzl != null;
    }
}
