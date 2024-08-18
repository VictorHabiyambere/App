package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzehy implements zzdjp {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfgt zzc;
    private final zzchd zzd;
    private final zzfho zze;
    private final zzbls zzf;
    private final boolean zzg;
    private final zzegk zzh;

    zzehy(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfgt zzfgt, zzchd zzchd, zzfho zzfho, boolean z, zzbls zzbls, zzegk zzegk) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfgt;
        this.zzd = zzchd;
        this.zze = zzfho;
        this.zzg = z;
        this.zzf = zzbls;
        this.zzh = zzegk;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        boolean z2;
        int i;
        zzegk zzegk;
        int i2;
        zzcrq zzcrq = (zzcrq) zzgft.zzq(this.zzb);
        this.zzd.zzaq(true);
        if (this.zzg) {
            z2 = this.zzf.zze(true);
        } else {
            z2 = true;
        }
        boolean z3 = this.zzg;
        zzk zzk = new zzk(z2, true, z3 ? this.zzf.zzd() : false, z3 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzP, false);
        if (zzczy != null) {
            zzczy.zzf();
        }
        zzu.zzi();
        zzdje zzg2 = zzcrq.zzg();
        zzchd zzchd = this.zzd;
        int i3 = this.zzc.zzR;
        if (i3 != -1) {
            i = i3;
        } else {
            zzw zzw = this.zze.zzj;
            if (zzw != null) {
                int i4 = zzw.zza;
                if (i4 == 1) {
                    i2 = 7;
                } else if (i4 == 2) {
                    i2 = 6;
                }
                i = i2;
            }
            zzm.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzR;
        }
        VersionInfoParcel versionInfoParcel = this.zza;
        zzfgt zzfgt = this.zzc;
        String str = zzfgt.zzC;
        zzfgy zzfgy = zzfgt.zzt;
        String str2 = zzfgy.zzb;
        String str3 = zzfgy.zza;
        zzfho zzfho = this.zze;
        if (zzfgt.zzaj) {
            zzegk = this.zzh;
        } else {
            zzegk = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzg2, (zzaa) null, zzchd, i, versionInfoParcel, str, zzk, str2, str3, zzfho.zzf, zzczy, (zzbuz) zzegk);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
