package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcsk implements zzdaz {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzfgt zzc;
    public final /* synthetic */ zzfho zzd;

    public /* synthetic */ zzcsk(Context context, VersionInfoParcel versionInfoParcel, zzfgt zzfgt, zzfho zzfho) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfgt;
        this.zzd = zzfho;
    }

    public final void zzs() {
        zzu.zzs().zzn(this.zza, this.zzb.afmaVersion, this.zzc.zzD.toString(), this.zzd.zzf);
    }
}
