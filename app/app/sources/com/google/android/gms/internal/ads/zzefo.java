package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzefo extends zzegl {
    private Activity zza;
    private zzm zzb;
    private String zzc;
    private String zzd;

    zzefo() {
    }

    public final zzegl zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    public final zzegl zzb(zzm zzm) {
        this.zzb = zzm;
        return this;
    }

    public final zzegl zzc(String str) {
        this.zzc = str;
        return this;
    }

    public final zzegl zzd(String str) {
        this.zzd = str;
        return this;
    }

    public final zzegm zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzefq(activity, this.zzb, this.zzc, this.zzd, (zzefp) null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
