package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzchm implements zzfyw {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcix zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzaxd zzf;
    public final /* synthetic */ zzbfs zzg;
    public final /* synthetic */ VersionInfoParcel zzh;
    public final /* synthetic */ zzm zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbdm zzk;
    public final /* synthetic */ zzfgt zzl;
    public final /* synthetic */ zzfgw zzm;
    public final /* synthetic */ zzfhs zzn;
    public final /* synthetic */ zzegk zzo;

    public /* synthetic */ zzchm(Context context, zzcix zzcix, String str, boolean z, boolean z2, zzaxd zzaxd, zzbfs zzbfs, VersionInfoParcel versionInfoParcel, zzbfe zzbfe, zzm zzm2, zza zza2, zzbdm zzbdm, zzfgt zzfgt, zzfgw zzfgw, zzfhs zzfhs, zzegk zzegk) {
        this.zza = context;
        this.zzb = zzcix;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzaxd;
        this.zzg = zzbfs;
        this.zzh = versionInfoParcel;
        this.zzi = zzm2;
        this.zzj = zza2;
        this.zzk = zzbdm;
        this.zzl = zzfgt;
        this.zzm = zzfgw;
        this.zzn = zzfhs;
        this.zzo = zzegk;
    }

    public final Object zza() {
        zzcix zzcix = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        zzbdm zzbdm = this.zzk;
        boolean z2 = this.zze;
        zzaxd zzaxd = this.zzf;
        zzfgt zzfgt = this.zzl;
        zzbfs zzbfs = this.zzg;
        zzm zzm2 = this.zzi;
        zzfgw zzfgw = this.zzm;
        Context context = this.zza;
        VersionInfoParcel versionInfoParcel = this.zzh;
        zza zza2 = this.zzj;
        zzfhs zzfhs = this.zzn;
        zzegk zzegk = this.zzo;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzcic.zza;
            zzcic zzcic = r2;
            zzegk zzegk2 = zzegk;
            zzfgw zzfgw2 = zzfgw;
            zza zza3 = zza2;
            zzfgt zzfgt2 = zzfgt;
            zzcic zzcic2 = new zzcic(new zzciw(context), zzcix, str, z, z2, zzaxd, zzbfs, versionInfoParcel, (zzbfe) null, zzm2, zza3, zzbdm, zzfgt2, zzfgw2, zzfhs);
            zzchv zzchv = new zzchv(zzcic);
            zzchv.setWebViewClient(zzu.zzq().zzc(zzchv, zzbdm, z2, zzegk2));
            zzchv.setWebChromeClient(new zzchc(zzchv));
            return zzchv;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
