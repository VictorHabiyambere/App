package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcyq implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;
    private final zzhlg zzg;
    private final zzhlg zzh;
    private final zzhlg zzi;
    private final zzhlg zzj;
    private final zzhlg zzk;
    private final zzhlg zzl;

    public zzcyq(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6, zzhlg zzhlg7, zzhlg zzhlg8, zzhlg zzhlg9, zzhlg zzhlg10, zzhlg zzhlg11, zzhlg zzhlg12) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
        this.zzg = zzhlg7;
        this.zzh = zzhlg8;
        this.zzi = zzhlg9;
        this.zzj = zzhlg10;
        this.zzk = zzhlg11;
        this.zzl = zzhlg12;
    }

    /* renamed from: zza */
    public final zzcyp zzb() {
        VersionInfoParcel zza2 = ((zzcjv) this.zzb).zza();
        ApplicationInfo zza3 = ((zzdzq) this.zzc).zzb();
        String zza4 = ((zzdzv) this.zzd).zzb();
        zzbeg zzbeg = zzbep.zza;
        return new zzcyp((zzflt) this.zza.zzb(), zza2, zza3, zza4, zzba.zza().zza(), (PackageInfo) this.zzf.zzb(), zzhko.zza(zzhla.zza(this.zzg)), ((zzcjh) this.zzh).zzb(), (String) this.zzi.zzb(), ((zzeya) this.zzj).zzb(), ((zzczc) this.zzk).zza(), (zzdeu) this.zzl.zzb());
    }
}
