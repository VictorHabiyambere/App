package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzemh implements zzdjp {
    private final Context zza;
    private final zzdsd zzb;
    private final zzfho zzc;
    private final VersionInfoParcel zzd;
    private final zzfgt zze;
    private final ListenableFuture zzf;
    private final zzchd zzg;
    private final zzbls zzh;
    private final boolean zzi;
    private final zzegk zzj;

    zzemh(Context context, zzdsd zzdsd, zzfho zzfho, VersionInfoParcel versionInfoParcel, zzfgt zzfgt, ListenableFuture listenableFuture, zzchd zzchd, zzbls zzbls, boolean z, zzegk zzegk) {
        this.zza = context;
        this.zzb = zzdsd;
        this.zzc = zzfho;
        this.zzd = versionInfoParcel;
        this.zze = zzfgt;
        this.zzf = listenableFuture;
        this.zzg = zzchd;
        this.zzh = zzbls;
        this.zzi = z;
        this.zzj = zzegk;
    }

    public final void zza(boolean z, Context context, zzczy zzczy) {
        zzchd zzchd;
        boolean z2;
        boolean z3;
        zzegk zzegk;
        zzbls zzbls;
        zzdri zzdri = (zzdri) zzgft.zzq(this.zzf);
        try {
            zzfgt zzfgt = this.zze;
            if (!this.zzg.zzaG()) {
                zzchd = this.zzg;
            } else {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzaN)).booleanValue()) {
                    zzchd = this.zzg;
                } else {
                    zzchd zza2 = this.zzb.zza(this.zzc.zze, (zzfgt) null, (zzfgw) null);
                    zzbmh.zzb(zza2, zzdri.zzg());
                    zzdsh zzdsh = new zzdsh();
                    zzdsh.zza(this.zza, (View) zza2);
                    zzdsc zzl = zzdri.zzl();
                    if (this.zzi) {
                        zzbls = this.zzh;
                    } else {
                        zzbls = null;
                    }
                    zzl.zzi(zza2, true, zzbls);
                    zza2.zzN().zzB(new zzemf(zzdsh, zza2));
                    zzciv zzN = zza2.zzN();
                    Objects.requireNonNull(zza2);
                    zzN.zzH(new zzemg(zza2));
                    zzfgy zzfgy = zzfgt.zzt;
                    zza2.zzae(zzfgy.zzb, zzfgy.zza, (String) null);
                    zzchd = zza2;
                }
            }
            zzchd.zzaq(true);
            if (this.zzi) {
                z2 = this.zzh.zze(false);
            } else {
                z2 = false;
            }
            zzu.zzp();
            Context context2 = this.zza;
            boolean z4 = this.zzi;
            boolean zzI = zzt.zzI(context2);
            if (z4) {
                z3 = this.zzh.zzd();
            } else {
                z3 = false;
            }
            float zza3 = this.zzi ? this.zzh.zza() : 0.0f;
            zzfgt zzfgt2 = this.zze;
            zzk zzk = new zzk(z2, zzI, z3, zza3, -1, z, zzfgt2.zzP, zzfgt2.zzQ);
            if (zzczy != null) {
                zzczy.zzf();
            }
            zzu.zzi();
            zzdje zzh2 = zzdri.zzh();
            zzfgt zzfgt3 = this.zze;
            VersionInfoParcel versionInfoParcel = this.zzd;
            int i = zzfgt3.zzR;
            String str = zzfgt3.zzC;
            zzfgy zzfgy2 = zzfgt3.zzt;
            String str2 = zzfgy2.zzb;
            String str3 = zzfgy2.zza;
            zzfho zzfho = this.zzc;
            if (zzfgt3.zzaj) {
                zzegk = this.zzj;
            } else {
                zzegk = null;
            }
            zzn.zza(context, new AdOverlayInfoParcel((zza) null, (zzp) zzh2, (zzaa) null, zzchd, i, versionInfoParcel, str, zzk, str2, str3, zzfho.zzf, zzczy, (zzbuz) zzegk), true);
        } catch (zzchp e) {
            zzm.zzh("", e);
        }
    }
}
