package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqj implements zzexv {
    final zzfho zza;
    private final long zzb;

    public zzeqj(zzfho zzfho, long j) {
        Preconditions.checkNotNull(zzfho, "the targeting must not be null");
        this.zza = zzfho;
        this.zzb = j;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        boolean z;
        Bundle bundle = (Bundle) obj;
        zzl zzl = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzl.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i = this.zza.zzo.zza;
        if (i != 0) {
            boolean z2 = true;
            switch (i - 1) {
                case 1:
                    bundle.putBoolean("is_new_rewarded", true);
                    break;
                case 2:
                    bundle.putBoolean("is_rewarded_interstitial", true);
                    break;
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            zzfic.zzf(bundle, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzl.zzb)), zzl.zzb != -1);
            zzfic.zzb(bundle, "extras", zzl.zzc);
            int i2 = zzl.zzd;
            zzfic.zze(bundle, "cust_gender", i2, i2 != -1);
            zzfic.zzd(bundle, "kw", zzl.zze);
            int i3 = zzl.zzg;
            zzfic.zze(bundle, "tag_for_child_directed_treatment", i3, i3 != -1);
            if (zzl.zzf) {
                bundle.putBoolean("test_request", true);
            }
            bundle.putInt("ppt_p13n", zzl.zzy);
            zzfic.zze(bundle, "d_imp_hdr", 1, zzl.zza >= 2 && zzl.zzh);
            String str = zzl.zzi;
            zzfic.zzf(bundle, "ppid", str, zzl.zza >= 2 && !TextUtils.isEmpty(str));
            Location location = zzl.zzk;
            if (location != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", location.getAccuracy() * 1000.0f);
                bundle2.putLong("lat", (long) (location.getLatitude() * 1.0E7d));
                bundle2.putLong("long", (long) (location.getLongitude() * 1.0E7d));
                bundle2.putLong("time", location.getTime() * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzfic.zzc(bundle, ImagesContract.URL, zzl.zzl);
            zzfic.zzd(bundle, "neighboring_content_urls", zzl.zzv);
            zzfic.zzb(bundle, "custom_targeting", zzl.zzn);
            zzfic.zzd(bundle, "category_exclusions", zzl.zzo);
            zzfic.zzc(bundle, "request_agent", zzl.zzp);
            zzfic.zzc(bundle, "request_pkg", zzl.zzq);
            boolean z3 = zzl.zzr;
            if (zzl.zza >= 7) {
                z = true;
            } else {
                z = false;
            }
            zzfic.zzg(bundle, "is_designed_for_families", z3, z);
            if (zzl.zza >= 8) {
                int i4 = zzl.zzt;
                if (i4 == -1) {
                    z2 = false;
                }
                zzfic.zze(bundle, "tag_for_under_age_of_consent", i4, z2);
                zzfic.zzc(bundle, "max_ad_content_rating", zzl.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}
