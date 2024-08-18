package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcms implements zzfez {
    private final zzcla zza;
    private final zzcms zzb = this;
    private final zzhky zzc;
    private final zzhky zzd;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;
    private final zzhky zzi;

    /* synthetic */ zzcms(zzcla zzcla, Context context, String str, zzq zzq, zzcmr zzcmr) {
        this.zza = zzcla;
        this.zzc = zzhkq.zza(context);
        this.zzd = zzhkq.zza(zzq);
        this.zze = zzhkq.zza(str);
        zzcla zzcla2 = this.zza;
        this.zzf = zzhko.zzc(new zzepd(zzcla2.zzM));
        this.zzg = zzhko.zzc(new zzffx(zzcla2.zzaE));
        zzhky zzhky = this.zzc;
        zzhky zzP = zzcla2.zzc;
        zzhky zzL = zzcla2.zzO;
        zzhky zzhky2 = this.zzf;
        zzhky zzhky3 = this.zzg;
        zzhky zzhky4 = zzhky;
        this.zzh = zzhko.zzc(new zzfex(zzhky4, zzP, zzL, zzhky2, zzhky3, zzfhq.zza()));
        this.zzi = zzhko.zzc(new zzepl(zzhky4, this.zzd, this.zze, this.zzh, zzhky2, zzhky3, zzcla2.zzl, zzcla2.zzQ, zzcla2.zzM));
    }

    public final zzepk zza() {
        return (zzepk) this.zzi.zzb();
    }
}
