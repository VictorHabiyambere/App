package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbwc;
import com.google.android.gms.internal.ads.zzbwd;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class ReportingInfo {
    private final zzbwd zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzbwc zza = new zzbwc();

        public Builder(View adView) {
            this.zza.zzb(adView);
        }

        public ReportingInfo build() {
            return new ReportingInfo(this, (zzb) null);
        }

        public Builder setAssetViews(Map<String, View> assetViews) {
            this.zza.zzc(assetViews);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzb) {
        this.zza = new zzbwd(builder.zza);
    }

    public void recordClick(List<Uri> clickUrls) {
        this.zza.zza(clickUrls);
    }

    public void recordImpression(List<Uri> impressionUrls) {
        this.zza.zzb(impressionUrls);
    }

    public void reportTouchEvent(MotionEvent event) {
        this.zza.zzc(event);
    }

    public void updateClickUrl(Uri clickUri, UpdateClickUrlCallback callback) {
        this.zza.zzd(clickUri, callback);
    }

    public void updateImpressionUrls(List<Uri> impressionUris, UpdateImpressionUrlsCallback callback) {
        this.zza.zze(impressionUris, callback);
    }
}
