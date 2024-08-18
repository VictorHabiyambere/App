package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzclu implements zzfdi {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzcla zzd;
    private final zzclu zze = this;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;
    private final zzhky zzi;
    private final zzhky zzj;
    private final zzhky zzk;

    /* synthetic */ zzclu(zzcla zzcla, Context context, String str, zzq zzq, zzclt zzclt) {
        this.zzd = zzcla;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzf = zzhkq.zza(context);
        this.zzg = zzhkq.zza(zzq);
        zzcla zzcla2 = this.zzd;
        this.zzh = zzhko.zzc(new zzepd(zzcla2.zzM));
        this.zzi = zzhko.zzc(zzepi.zza());
        this.zzj = zzhko.zzc(zzdej.zza());
        this.zzk = zzhko.zzc(new zzfdg(this.zzf, zzcla2.zzc, this.zzg, zzcla2.zzO, this.zzh, this.zzi, zzfhq.zza(), this.zzj));
    }

    public final zzeoi zza() {
        VersionInfoParcel zze2 = this.zzd.zza.zze();
        zzhkx.zzb(zze2);
        return new zzeoi(this.zza, this.zzb, this.zzc, (zzfdf) this.zzk.zzb(), (zzepc) this.zzh.zzb(), zze2, (zzdvc) this.zzd.zzM.zzb());
    }
}
