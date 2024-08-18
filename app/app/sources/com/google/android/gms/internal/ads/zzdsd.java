package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsd {
    private final zzchq zza;
    private final Context zzb;
    private final zzaxd zzc;
    private final zzbfs zzd;
    private final VersionInfoParcel zze;
    private final zza zzf;
    private final zzbdm zzg;
    /* access modifiers changed from: private */
    public final zzdca zzh;
    private final zzegk zzi;
    private final zzfhs zzj;

    public zzdsd(zzchq zzchq, Context context, zzaxd zzaxd, zzbfs zzbfs, VersionInfoParcel versionInfoParcel, zza zza2, zzbdm zzbdm, zzdca zzdca, zzegk zzegk, zzfhs zzfhs) {
        this.zza = zzchq;
        this.zzb = context;
        this.zzc = zzaxd;
        this.zzd = zzbfs;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
        this.zzg = zzbdm;
        this.zzh = zzdca;
        this.zzi = zzegk;
        this.zzj = zzfhs;
    }

    public final zzchd zza(zzq zzq, zzfgt zzfgt, zzfgw zzfgw) throws zzchp {
        zzcix zzc2 = zzcix.zzc(zzq);
        String str = zzq.zza;
        zzdrs zzdrs = new zzdrs(this);
        zzegk zzegk = this.zzi;
        zzfhs zzfhs = this.zzj;
        zza zza2 = this.zzf;
        zzbdm zzbdm = this.zzg;
        return zzchq.zza(this.zzb, zzc2, str, false, false, this.zzc, this.zzd, this.zze, (zzbfe) null, zzdrs, zza2, zzbdm, zzfgt, zzfgw, zzegk, zzfhs);
    }
}
