package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzemi implements zzehl {
    private final Context zza;
    private final zzdsd zzb;
    private final zzdrm zzc;
    private final zzfho zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbls zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbep.zziT)).booleanValue();
    private final zzegk zzi;

    public zzemi(Context context, VersionInfoParcel versionInfoParcel, zzfho zzfho, Executor executor, zzdrm zzdrm, zzdsd zzdsd, zzbls zzbls, zzegk zzegk) {
        this.zza = context;
        this.zzd = zzfho;
        this.zzc = zzdrm;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdsd;
        this.zzg = zzbls;
        this.zzi = zzegk;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzdsh zzdsh = new zzdsh();
        ListenableFuture zzn = zzgft.zzn(zzgft.zzh((Object) null), new zzemb(this, zzfgt, zzfhf, zzdsh), this.zze);
        Objects.requireNonNull(zzdsh);
        zzn.addListener(new zzemc(zzdsh), this.zze);
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
        zzchd zza2 = this.zzb.zza(this.zzd.zze, zzfgt2, zzfhf2.zzb.zzb);
        zza2.zzac(zzfgt2.zzX);
        zzdsh.zza(this.zza, (View) zza2);
        zzccn zzccn = new zzccn();
        zzcvf zzcvf = new zzcvf(zzfhf2, zzfgt2, (String) null);
        Context context = this.zza;
        zzdsd zzdsd = this.zzb;
        zzbls zzbls = this.zzg;
        zzbls zzbls2 = zzbls;
        zzemh zzemh = r1;
        zzemh zzemh2 = new zzemh(context, zzdsd, this.zzd, this.zzf, zzfgt, zzccn, zza2, zzbls2, this.zzh, this.zzi);
        zzdri zze2 = this.zzc.zze(zzcvf, new zzdrj(zzemh, zza2));
        zzccn.zzc(zze2);
        zzbmh.zzb(zza2, zze2.zzg());
        zze2.zzc().zzo(new zzemd(zza2), zzcci.zzf);
        zze2.zzl().zzi(zza2, true, this.zzh ? this.zzg : null);
        zzfgt zzfgt3 = zzfgt;
        String str = zzfgt3.zzt.zza;
        if (((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && zze2.zzm().zze(true)) {
            str = zzcio.zzb(str, zzcio.zza(zzfgt));
        }
        zze2.zzl();
        return zzgft.zzm(zzdsc.zzj(zza2, zzfgt3.zzt.zzb, str), new zzeme(this, zza2, zzfgt3, zze2), this.zze);
    }
}
