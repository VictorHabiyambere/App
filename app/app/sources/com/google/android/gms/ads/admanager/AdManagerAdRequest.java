package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.AdRequest;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class AdManagerAdRequest extends AdRequest {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static final class Builder extends AbstractAdRequestBuilder<Builder> {
        public Builder addCategoryExclusion(String categoryExclusion) {
            this.zza.zzn(categoryExclusion);
            return this;
        }

        public Builder addCustomTargeting(String key, String value) {
            this.zza.zzp(key, value);
            return this;
        }

        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, (zza) null);
        }

        public Builder self() {
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.zza.zzA(publisherProvidedId);
            return this;
        }

        public Builder addCustomTargeting(String key, List<String> values) {
            if (values != null) {
                this.zza.zzp(key, TextUtils.join(",", values));
            }
            return this;
        }
    }

    /* synthetic */ AdManagerAdRequest(Builder builder, zza zza) {
        super(builder);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zze();
    }

    public String getPublisherProvidedId() {
        return this.zza.zzl();
    }
}
