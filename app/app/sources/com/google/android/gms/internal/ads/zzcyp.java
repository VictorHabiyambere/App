package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcyp {
    private final zzflt zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhkj zzg;
    private final String zzh;
    private final zzexz zzi;
    private final zzg zzj;
    private final zzfho zzk;
    private final zzdeu zzl;

    public zzcyp(zzflt zzflt, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhkj zzhkj, zzg zzg2, String str2, zzexz zzexz, zzfho zzfho, zzdeu zzdeu) {
        this.zza = zzflt;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhkj;
        this.zzh = str2;
        this.zzi = zzexz;
        this.zzj = zzg2;
        this.zzk = zzfho;
        this.zzl = zzdeu;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbxu zza(ListenableFuture listenableFuture, Bundle bundle) throws Exception {
        boolean z;
        Bundle bundle2 = (Bundle) listenableFuture.get();
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhq)).booleanValue() || !this.zzj.zzS()) {
            z = false;
        } else {
            z = true;
        }
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbxu(bundle2, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, (zzfjj) null, (String) null, z, this.zzk.zzb(), bundle);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzl.zza();
        return zzfld.zzc(this.zzi.zza(new Bundle(), bundle), zzfln.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue() && (bundle = this.zzk.zzs) != null) {
            bundle2.putAll(bundle);
        }
        ListenableFuture zzb2 = zzb(bundle2);
        return this.zza.zza(zzfln.REQUEST_PARCEL, zzb2, (ListenableFuture) this.zzg.zzb()).zza(new zzcyo(this, zzb2, bundle2)).zza();
    }
}
