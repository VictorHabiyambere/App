package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzduh implements zzded, zza, zzdaf, zzczp {
    private final Context zza;
    private final zzfig zzb;
    private final zzdvc zzc;
    private final zzfhf zzd;
    private final zzfgt zze;
    private final zzefz zzf;
    private final String zzg;
    private Boolean zzh;
    private final boolean zzi = ((Boolean) zzba.zzc().zza(zzbep.zzha)).booleanValue();

    public zzduh(Context context, zzfig zzfig, zzdvc zzdvc, zzfhf zzfhf, zzfgt zzfgt, zzefz zzefz, String str) {
        this.zza = context;
        this.zzb = zzfig;
        this.zzc = zzdvc;
        this.zzd = zzfhf;
        this.zze = zzfgt;
        this.zzf = zzefz;
        this.zzg = str;
    }

    private final zzdvb zzd(String str) {
        String str2;
        zzdvb zza2 = this.zzc.zza();
        zza2.zzd(this.zzd.zzb.zzb);
        zza2.zzc(this.zze);
        zza2.zzb("action", str);
        zza2.zzb("ad_format", this.zzg.toUpperCase(Locale.ROOT));
        boolean z = false;
        if (!this.zze.zzu.isEmpty()) {
            zza2.zzb("ancn", (String) this.zze.zzu.get(0));
        }
        if (this.zze.zzaj) {
            if (true != zzu.zzo().zzA(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza2.zzb("device_connectivity", str2);
            zza2.zzb("event_timestamp", String.valueOf(zzu.zzB().currentTimeMillis()));
            zza2.zzb("offline_ad", "1");
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzhj)).booleanValue()) {
            if (zzp.zzf(this.zzd.zza.zza) != 1) {
                z = true;
            }
            zza2.zzb("scar", String.valueOf(z));
            if (z) {
                zzl zzl = this.zzd.zza.zza.zzd;
                zza2.zzb("ragent", zzl.zzp);
                zza2.zzb("rtype", zzp.zzb(zzp.zzc(zzl)));
            }
        }
        return zza2;
    }

    private final void zze(zzdvb zzdvb) {
        if (this.zze.zzaj) {
            this.zzf.zzd(new zzegb(zzu.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdvb.zze(), 2));
            return;
        }
        zzdvb.zzf();
    }

    private final boolean zzf() {
        String str;
        if (this.zzh == null) {
            synchronized (this) {
                if (this.zzh == null) {
                    String str2 = (String) zzba.zzc().zza(zzbep.zzbu);
                    zzu.zzp();
                    try {
                        str = zzt.zzp(this.zza);
                    } catch (RemoteException e) {
                        str = null;
                    }
                    boolean z = false;
                    if (!(str2 == null || str == null)) {
                        try {
                            z = Pattern.matches(str2, str);
                        } catch (RuntimeException e2) {
                            zzu.zzo().zzw(e2, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzh = Boolean.valueOf(z);
                }
            }
        }
        return this.zzh.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zze.zzaj) {
            zze(zzd("click"));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzi) {
            zzdvb zzd2 = zzd("ifts");
            zzd2.zzb("reason", "adapter");
            int i = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i = zze4.zza;
                str = zze4.zzb;
            }
            if (i >= 0) {
                zzd2.zzb("arec", String.valueOf(i));
            }
            String zza2 = this.zzb.zza(str);
            if (zza2 != null) {
                zzd2.zzb("areec", zza2);
            }
            zzd2.zzf();
        }
    }

    public final void zzb() {
        if (this.zzi) {
            zzdvb zzd2 = zzd("ifts");
            zzd2.zzb("reason", "blocked");
            zzd2.zzf();
        }
    }

    public final void zzc(zzdjo zzdjo) {
        if (this.zzi) {
            zzdvb zzd2 = zzd("ifts");
            zzd2.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdjo.getMessage())) {
                zzd2.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdjo.getMessage());
            }
            zzd2.zzf();
        }
    }

    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzf();
        }
    }

    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzf();
        }
    }

    public final void zzr() {
        if (zzf() || this.zze.zzaj) {
            zze(zzd("impression"));
        }
    }
}
