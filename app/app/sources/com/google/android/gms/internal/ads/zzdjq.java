package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdv;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdjq implements zzdaz, zzp, zzdaf {
    zzehg zza;
    private final Context zzb;
    private final zzchd zzc;
    private final zzfgt zzd;
    private final VersionInfoParcel zze;
    private final zzbdv.zza.C0000zza zzf;
    private final zzehe zzg;

    public zzdjq(Context context, zzchd zzchd, zzfgt zzfgt, VersionInfoParcel versionInfoParcel, zzbdv.zza.C0000zza zza2, zzehe zzehe) {
        this.zzb = context;
        this.zzc = zzchd;
        this.zzd = zzfgt;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
        this.zzg = zzehe;
    }

    private final boolean zzg() {
        return ((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && this.zzg.zzd();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final void zzdr() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfh)).booleanValue() && this.zzc != null) {
            if (this.zza == null && !zzg()) {
                return;
            }
            if (this.zza != null) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            } else {
                this.zzg.zzb();
            }
        }
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        this.zza = null;
    }

    public final void zzr() {
        if (zzg()) {
            this.zzg.zzb();
        } else if (this.zza != null && this.zzc != null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzfh)).booleanValue()) {
                this.zzc.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }

    public final void zzs() {
        zzehc zzehc;
        zzehd zzehd;
        zzehd zzehd2;
        zzbdv.zza.C0000zza zza2;
        if ((((Boolean) zzba.zzc().zza(zzbep.zzfk)).booleanValue() || this.zzf == zzbdv.zza.C0000zza.REWARD_BASED_VIDEO_AD || (zza2 = this.zzf) == zzbdv.zza.C0000zza.INTERSTITIAL || zza2 == zzbdv.zza.C0000zza.APP_OPEN) && this.zzd.zzU && this.zzc != null) {
            if (!zzu.zzA().zzl(this.zzb)) {
                return;
            }
            if (zzg()) {
                this.zzg.zzc();
                return;
            }
            VersionInfoParcel versionInfoParcel = this.zze;
            String str = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
            zzfhr zzfhr = this.zzd.zzW;
            String zza3 = zzfhr.zza();
            if (zzfhr.zzc() == 1) {
                zzehc = zzehc.VIDEO;
                zzehd = zzehd.DEFINED_BY_JAVASCRIPT;
            } else {
                if (this.zzd.zzZ == 2) {
                    zzehd2 = zzehd.UNSPECIFIED;
                } else {
                    zzehd2 = zzehd.BEGIN_TO_RENDER;
                }
                zzehd = zzehd2;
                zzehc = zzehc.HTML_DISPLAY;
            }
            this.zza = zzu.zzA().zza(str, this.zzc.zzG(), "", "javascript", zza3, zzehd, zzehc, this.zzd.zzam);
            zzchd zzchd = this.zzc;
            zzehg zzehg = this.zza;
            if (zzehg != null) {
                zzfoj zza4 = zzehg.zza();
                if (((Boolean) zzba.zzc().zza(zzbep.zzfb)).booleanValue()) {
                    zzu.zzA().zzj(zza4, this.zzc.zzG());
                    for (View zzg2 : this.zzc.zzV()) {
                        zzu.zzA().zzg(zza4, zzg2);
                    }
                } else {
                    zzu.zzA().zzj(zza4, (View) zzchd);
                }
                this.zzc.zzat(this.zza);
                zzu.zzA().zzk(zza4);
                this.zzc.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }
}
