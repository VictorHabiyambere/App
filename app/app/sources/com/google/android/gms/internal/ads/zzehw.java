package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzehw implements zzehl {
    private final zzcrt zza;
    private final Context zzb;
    private final zzdsd zzc;
    private final zzfho zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbls zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbep.zziT)).booleanValue();
    private final zzegk zzi;

    public zzehw(zzcrt zzcrt, Context context, Executor executor, zzdsd zzdsd, zzfho zzfho, VersionInfoParcel versionInfoParcel, zzbls zzbls, zzegk zzegk) {
        this.zzb = context;
        this.zza = zzcrt;
        this.zze = executor;
        this.zzc = zzdsd;
        this.zzd = zzfho;
        this.zzf = versionInfoParcel;
        this.zzg = zzbls;
        this.zzi = zzegk;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzdsh zzdsh = new zzdsh();
        ListenableFuture zzn = zzgft.zzn(zzgft.zzh((Object) null), new zzehs(this, zzfgt, zzfhf, zzdsh), this.zze);
        Objects.requireNonNull(zzdsh);
        zzn.addListener(new zzeht(zzdsh), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        zzfgy zzfgy = zzfgt.zzt;
        return (zzfgy == null || zzfgy.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfgt zzfgt, zzfhf zzfhf, zzdsh zzdsh, Object obj) throws Exception {
        zzfgt zzfgt2 = zzfgt;
        zzfhf zzfhf2 = zzfhf;
        zzchd zza2 = this.zzc.zza(this.zzd.zze, zzfgt2, zzfhf2.zzb.zzb);
        zza2.zzac(zzfgt2.zzX);
        zzdsh.zza(this.zzb, (View) zza2);
        zzccn zzccn = new zzccn();
        zzcvf zzcvf = new zzcvf(zzfhf2, zzfgt2, (String) null);
        zzehy zzehy = r1;
        zzehy zzehy2 = new zzehy(this.zzf, zzccn, zzfgt, zza2, this.zzd, this.zzh, this.zzg, this.zzi);
        zzcrq zza3 = this.zza.zza(zzcvf, new zzdik(zzehy, zza2), new zzcrr(zzfgt2.zzab));
        zza3.zzh().zzi(zza2, false, this.zzh ? this.zzg : null);
        zzccn.zzc(zza3);
        zza3.zzc().zzo(new zzehu(zza2), zzcci.zzf);
        String str = zzfgt2.zzt.zza;
        if (((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && zza3.zzi().zze(true)) {
            str = zzcio.zzb(str, zzcio.zza(zzfgt));
        }
        zza3.zzh();
        return zzgft.zzm(zzdsc.zzj(zza2, zzfgt2.zzt.zzb, str), new zzehv(this, zza2, zzfgt2, zza3), this.zze);
    }
}
