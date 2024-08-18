package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdrh extends zzcup {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdjp zze;
    private final zzdgm zzf;
    private final zzczy zzg;
    private final zzdbf zzh;
    private final zzcvk zzi;
    private final zzbyx zzj;
    private final zzfrp zzk;
    private final zzfhh zzl;
    private boolean zzm = false;

    zzdrh(zzcuo zzcuo, Context context, zzchd zzchd, zzdjp zzdjp, zzdgm zzdgm, zzczy zzczy, zzdbf zzdbf, zzcvk zzcvk, zzfgt zzfgt, zzfrp zzfrp, zzfhh zzfhh) {
        super(zzcuo);
        String str;
        int i;
        this.zzc = context;
        this.zze = zzdjp;
        this.zzd = new WeakReference(zzchd);
        this.zzf = zzdgm;
        this.zzg = zzczy;
        this.zzh = zzdbf;
        this.zzi = zzcvk;
        this.zzk = zzfrp;
        zzbyt zzbyt = zzfgt.zzm;
        if (zzbyt != null) {
            str = zzbyt.zza;
        } else {
            str = "";
        }
        if (zzbyt != null) {
            i = zzbyt.zzb;
        } else {
            i = 1;
        }
        this.zzj = new zzbzr(str, i);
        this.zzl = zzfhh;
    }

    public final void finalize() throws Throwable {
        try {
            zzchd zzchd = (zzchd) this.zzd.get();
            if (((Boolean) zzba.zzc().zza(zzbep.zzgU)).booleanValue()) {
                if (!this.zzm && zzchd != null) {
                    zzgge zzgge = zzcci.zze;
                    Objects.requireNonNull(zzchd);
                    zzgge.execute(new zzdrg(zzchd));
                }
            } else if (zzchd != null) {
                zzchd.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbyx zzc() {
        return this.zzj;
    }

    public final zzfhh zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzchd zzchd = (zzchd) this.zzd.get();
        return zzchd != null && !zzchd.zzaG();
    }

    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzaC)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzG(this.zzc)) {
                zzm.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzba.zzc().zza(zzbep.zzaD)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzm.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfiq.zzd(10, (String) null, (zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdjo e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
