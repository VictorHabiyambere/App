package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzmg {
    private static final zzvo zzt = new zzvo(new Object(), -1);
    public final zzdc zza;
    public final zzvo zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzjh zzf;
    public final boolean zzg;
    public final zzxr zzh;
    public final zzzn zzi;
    public final List zzj;
    public final zzvo zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzcl zzn;
    public final boolean zzo = false;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzmg(zzdc zzdc, zzvo zzvo, long j, long j2, int i, zzjh zzjh, boolean z, zzxr zzxr, zzzn zzzn, List list, zzvo zzvo2, boolean z2, int i2, zzcl zzcl, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzdc;
        this.zzb = zzvo;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzjh;
        this.zzg = z;
        this.zzh = zzxr;
        this.zzi = zzzn;
        this.zzj = list;
        this.zzk = zzvo2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzcl;
        this.zzp = j3;
        this.zzq = j4;
        this.zzr = j5;
        this.zzs = j6;
    }

    public static zzmg zzg(zzzn zzzn) {
        return new zzmg(zzdc.zza, zzt, -9223372036854775807L, 0, 1, (zzjh) null, false, zzxr.zza, zzzn, zzgbc.zzm(), zzt, false, 0, zzcl.zza, 0, 0, 0, 0, false);
    }

    public static zzvo zzh() {
        return zzt;
    }

    public final zzmg zza(zzvo zzvo) {
        boolean z = this.zzl;
        int i = this.zzm;
        zzcl zzcl = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzmg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzvo, z, i, zzcl, j, j2, j3, j4, false);
    }

    public final zzmg zzb(zzvo zzvo, long j, long j2, long j3, long j4, zzxr zzxr, zzzn zzzn, List list) {
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        zzxr zzxr2 = zzxr;
        zzzn zzzn2 = zzzn;
        List list2 = list;
        zzvo zzvo2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        zzcl zzcl = this.zzn;
        long j8 = this.zzp;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.zze;
        zzjh zzjh = this.zzf;
        boolean z2 = this.zzg;
        return new zzmg(this.zza, zzvo, j5, j6, i2, zzjh, z2, zzxr2, zzzn2, list2, zzvo2, z, i, zzcl, j8, j7, j, elapsedRealtime, false);
    }

    public final zzmg zzc(boolean z, int i) {
        zzcl zzcl = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzmg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, zzcl, j, j2, j3, j4, false);
    }

    public final zzmg zzd(zzjh zzjh) {
        boolean z = this.zzg;
        zzxr zzxr = this.zzh;
        zzzn zzzn = this.zzi;
        List list = this.zzj;
        zzvo zzvo = this.zzk;
        boolean z2 = this.zzl;
        int i = this.zzm;
        zzcl zzcl = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzmg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzjh, z, zzxr, zzzn, list, zzvo, z2, i, zzcl, j, j2, j3, j4, false);
    }

    public final zzmg zze(int i) {
        zzjh zzjh = this.zzf;
        boolean z = this.zzg;
        zzxr zzxr = this.zzh;
        zzzn zzzn = this.zzi;
        List list = this.zzj;
        zzvo zzvo = this.zzk;
        boolean z2 = this.zzl;
        int i2 = this.zzm;
        zzcl zzcl = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzmg(this.zza, this.zzb, this.zzc, this.zzd, i, zzjh, z, zzxr, zzzn, list, zzvo, z2, i2, zzcl, j, j2, j3, j4, false);
    }

    public final zzmg zzf(zzdc zzdc) {
        return new zzmg(zzdc, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final boolean zzi() {
        return this.zze == 3 && this.zzl && this.zzm == 0;
    }
}
