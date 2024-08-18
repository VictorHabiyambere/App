package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzejn implements zzdjp {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfgt zzd;
    private final zzchd zze;
    private final zzfho zzf;
    private final zzbls zzg;
    private final boolean zzh;
    private final zzegk zzi;

    zzejn(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfgt zzfgt, zzchd zzchd, zzfho zzfho, boolean z, zzbls zzbls, zzegk zzegk) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfgt;
        this.zze = zzchd;
        this.zzf = zzfho;
        this.zzg = zzbls;
        this.zzh = z;
        this.zzi = zzegk;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        boolean z2;
        boolean z3;
        zzegk zzegk;
        zzdih zzdih = (zzdih) zzgft.zzq(this.zzc);
        this.zze.zzaq(true);
        if (this.zzh) {
            z2 = this.zzg.zze(false);
        } else {
            z2 = false;
        }
        zzu.zzp();
        Context context2 = this.zza;
        boolean z4 = this.zzh;
        boolean zzI = zzt.zzI(context2);
        if (z4) {
            z3 = this.zzg.zzd();
        } else {
            z3 = false;
        }
        zzk zzk = new zzk(z2, zzI, z3, this.zzh ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzP, false);
        if (zzczy != null) {
            zzczy.zzf();
        }
        zzu.zzi();
        zzdje zzh2 = zzdih.zzh();
        zzchd zzchd = this.zze;
        zzfgt zzfgt = this.zzd;
        VersionInfoParcel versionInfoParcel = this.zzb;
        int i = zzfgt.zzR;
        String str = zzfgt.zzC;
        zzfgy zzfgy = zzfgt.zzt;
        String str2 = zzfgy.zzb;
        String str3 = zzfgy.zza;
        zzfho zzfho = this.zzf;
        if (zzfgt.zzaj) {
            zzegk = this.zzi;
        } else {
            zzegk = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzh2, (zzaa) null, zzchd, i, versionInfoParcel, str, zzk, str2, str3, zzfho.zzf, zzczy, (zzbuz) zzegk);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
