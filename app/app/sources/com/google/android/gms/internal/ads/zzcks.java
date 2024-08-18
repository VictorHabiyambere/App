package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcks extends zzezk {
    private final zzfar zza;
    private final zzcla zzb;
    private final zzcks zzc = this;
    private final zzhky zzd;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;
    private final zzhky zzi;
    private final zzhky zzj;
    private final zzhky zzk;
    private final zzhky zzl;
    private final zzhky zzm;
    private final zzhky zzn;

    /* synthetic */ zzcks(zzcla zzcla, zzfar zzfar, zzckr zzckr) {
        this.zzb = zzcla;
        this.zza = zzfar;
        this.zzd = new zzfat(zzfar);
        this.zze = zzhko.zzc(zzdtx.zza());
        this.zzf = zzhko.zzc(zzdtv.zza());
        this.zzg = zzhko.zzc(zzdtz.zza());
        this.zzh = zzhko.zzc(zzdub.zza());
        zzhks zzc2 = zzhkt.zzc(4);
        zzc2.zzb(zzfln.GMS_SIGNALS, this.zze);
        zzc2.zzb(zzfln.BUILD_URL, this.zzf);
        zzc2.zzb(zzfln.HTTP, this.zzg);
        zzc2.zzb(zzfln.PRE_PROCESS, this.zzh);
        this.zzi = zzc2.zzc();
        this.zzj = zzhko.zzc(new zzduc(this.zzd, this.zzb.zzh, zzfko.zza(), this.zzi));
        zzhlc zza2 = zzhld.zza(0, 1);
        zza2.zza(this.zzj);
        this.zzk = zza2.zzc();
        this.zzl = new zzflw(this.zzk);
        zzfko zza3 = zzfko.zza();
        zzcla zzcla2 = this.zzb;
        this.zzm = zzhko.zzc(new zzflv(zza3, zzcla2.zze, this.zzl));
        this.zzn = zzhko.zzc(new zzfmo(zzcla2.zzz));
    }

    public final zzexz zza() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhkx.zzb(zzb2);
        zzcbm zzcbm = new zzcbm();
        zzgge zzgge = zzcci.zza;
        zzhkx.zzb(zzgge);
        zzfal zzfal = new zzfal(zzcbm, zzgge, zzfas.zza(this.zza));
        zzgge zzgge2 = zzcci.zza;
        zzhkx.zzb(zzgge2);
        HashSet hashSet = new HashSet();
        hashSet.add(new zzewe(zzfal, 0, (ScheduledExecutorService) this.zzb.zze.zzb()));
        return new zzexz(zzb2, zzgge2, hashSet, (zzfmn) this.zzn.zzb(), (zzdvc) this.zzb.zzM.zzb());
    }

    public final zzflt zzb() {
        return (zzflt) this.zzm.zzb();
    }
}
