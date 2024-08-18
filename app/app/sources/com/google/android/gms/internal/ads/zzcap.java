package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcap extends zzcav {
    private final Clock zzb;
    private final zzcap zzc = this;
    private final zzhky zzd;
    private final zzhky zze;
    private final zzhky zzf;
    private final zzhky zzg;
    private final zzhky zzh;
    private final zzhky zzi;
    private final zzhky zzj;
    private final zzhky zzk;

    /* synthetic */ zzcap(Context context, Clock clock, zzg zzg2, zzcau zzcau, zzcao zzcao) {
        this.zzb = clock;
        this.zzd = zzhkq.zza(context);
        this.zze = zzhkq.zza(zzg2);
        this.zzf = zzhko.zzc(new zzcah(this.zzd, this.zze));
        this.zzg = zzhkq.zza(clock);
        this.zzh = zzhkq.zza(zzcau);
        zzhky zzhky = this.zzg;
        this.zzi = zzhko.zzc(new zzcaj(zzhky, this.zze, this.zzh));
        this.zzj = new zzcal(zzhky, this.zzi);
        this.zzk = zzhko.zzc(new zzcba(this.zzd, this.zzj));
    }

    /* access modifiers changed from: package-private */
    public final zzcag zza() {
        return (zzcag) this.zzf.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzcak zzb() {
        return new zzcak(this.zzb, (zzcai) this.zzi.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzcaz zzc() {
        return (zzcaz) this.zzk.zzb();
    }
}
