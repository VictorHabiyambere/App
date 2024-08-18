package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcho implements zzgez {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzaxd zzb;
    public final /* synthetic */ VersionInfoParcel zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ zzegk zze;
    public final /* synthetic */ zzfhs zzf;
    public final /* synthetic */ String zzg;

    public /* synthetic */ zzcho(Context context, zzaxd zzaxd, VersionInfoParcel versionInfoParcel, zza zza2, zzegk zzegk, zzfhs zzfhs, String str) {
        this.zza = context;
        this.zzb = zzaxd;
        this.zzc = versionInfoParcel;
        this.zzd = zza2;
        this.zze = zzegk;
        this.zzf = zzfhs;
        this.zzg = str;
    }

    public final ListenableFuture zza() {
        zzu.zzz();
        Context context = this.zza;
        zzcix zza2 = zzcix.zza();
        zzaxd zzaxd = this.zzb;
        zzegk zzegk = this.zze;
        zza zza3 = this.zzd;
        zzchd zza4 = zzchq.zza(context, zza2, "", false, false, zzaxd, (zzbfs) null, this.zzc, (zzbfe) null, (zzm) null, zza3, zzbdm.zza(), (zzfgt) null, (zzfgw) null, zzegk, this.zzf);
        zzccm zza5 = zzccm.zza(zza4);
        zza4.zzN().zzB(new zzchn(zza5));
        zza4.loadUrl(this.zzg);
        return zza5;
    }
}
