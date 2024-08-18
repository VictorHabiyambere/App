package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzejo implements zzehl {
    private final Context zza;
    private final zzdsd zzb;
    private final zzdjh zzc;
    private final zzfho zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbls zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbep.zziT)).booleanValue();
    private final zzegk zzi;

    public zzejo(Context context, VersionInfoParcel versionInfoParcel, zzfho zzfho, Executor executor, zzdjh zzdjh, zzdsd zzdsd, zzbls zzbls, zzegk zzegk) {
        this.zza = context;
        this.zzd = zzfho;
        this.zzc = zzdjh;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdsd;
        this.zzg = zzbls;
        this.zzi = zzegk;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzdsh zzdsh = new zzdsh();
        ListenableFuture zzn = zzgft.zzn(zzgft.zzh((Object) null), new zzejl(this, zzfgt, zzfhf, zzdsh), this.zze);
        Objects.requireNonNull(zzdsh);
        zzn.addListener(new zzejm(zzdsh), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        zzfgy zzfgy = zzfgt.zzt;
        return (zzfgy == null || zzfgy.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfgt zzfgt, zzfhf zzfhf, zzdsh zzdsh, Object obj) throws Exception {
        zzbls zzbls;
        zzfgt zzfgt2 = zzfgt;
        zzfhf zzfhf2 = zzfhf;
        zzchd zza2 = this.zzb.zza(this.zzd.zze, zzfgt2, zzfhf2.zzb.zzb);
        zza2.zzac(zzfgt2.zzX);
        zzdsh.zza(this.zza, (View) zza2);
        zzccn zzccn = new zzccn();
        zzcvf zzcvf = new zzcvf(zzfhf2, zzfgt2, (String) null);
        zzfho zzfho = this.zzd;
        boolean z = this.zzh;
        Context context = this.zza;
        zzbls zzbls2 = this.zzg;
        zzbls zzbls3 = zzbls2;
        zzejn zzejn = r1;
        zzejn zzejn2 = new zzejn(context, this.zzf, zzccn, zzfgt, zza2, zzfho, z, zzbls3, this.zzi);
        zzdih zze2 = this.zzc.zze(zzcvf, new zzdik(zzejn, zza2));
        zzccn.zzc(zze2);
        zze2.zzc().zzo(new zzejj(zza2), zzcci.zzf);
        zzfgt zzfgt3 = zzfgt;
        String str = zzfgt3.zzt.zza;
        if (((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && zze2.zzl().zze(true)) {
            str = zzcio.zzb(str, zzcio.zza(zzfgt));
        }
        zzdsc zzi2 = zze2.zzi();
        if (this.zzh) {
            zzbls = this.zzg;
        } else {
            zzbls = null;
        }
        zzi2.zzi(zza2, true, zzbls);
        zze2.zzi();
        return zzgft.zzm(zzdsc.zzj(zza2, zzfgt3.zzt.zzb, str), new zzejk(this, zza2, zzfgt3, zze2), this.zze);
    }
}
