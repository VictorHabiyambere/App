package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class RequestConfiguration {
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final String MAX_AD_CONTENT_RATING_UNSPECIFIED = "";
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    public static final List zza = Arrays.asList(new String[]{MAX_AD_CONTENT_RATING_MA, MAX_AD_CONTENT_RATING_T, MAX_AD_CONTENT_RATING_PG, MAX_AD_CONTENT_RATING_G});
    private final int zzb;
    private final int zzc;
    @Nullable
    private final String zzd;
    private final List zze;
    private final PublisherPrivacyPersonalizationState zzf;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static class Builder {
        private int zza = -1;
        private int zzb = -1;
        @Nullable
        private String zzc = null;
        private final List zzd = new ArrayList();
        private PublisherPrivacyPersonalizationState zze = PublisherPrivacyPersonalizationState.DEFAULT;

        public RequestConfiguration build() {
            return new RequestConfiguration(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzh) null);
        }

        public Builder setMaxAdContentRating(@Nullable String maxAdContentRating) {
            if (maxAdContentRating == null || "".equals(maxAdContentRating)) {
                this.zzc = null;
            } else if (RequestConfiguration.MAX_AD_CONTENT_RATING_G.equals(maxAdContentRating) || RequestConfiguration.MAX_AD_CONTENT_RATING_PG.equals(maxAdContentRating) || RequestConfiguration.MAX_AD_CONTENT_RATING_T.equals(maxAdContentRating) || RequestConfiguration.MAX_AD_CONTENT_RATING_MA.equals(maxAdContentRating)) {
                this.zzc = maxAdContentRating;
            } else {
                zzm.zzj("Invalid value passed to setMaxAdContentRating: ".concat(maxAdContentRating));
            }
            return this;
        }

        public Builder setPublisherPrivacyPersonalizationState(PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState) {
            this.zze = publisherPrivacyPersonalizationState;
            return this;
        }

        public Builder setTagForChildDirectedTreatment(int tagForChildDirectedTreatment) {
            if (tagForChildDirectedTreatment == -1 || tagForChildDirectedTreatment == 0 || tagForChildDirectedTreatment == 1) {
                this.zza = tagForChildDirectedTreatment;
            } else {
                zzm.zzj("Invalid value passed to setTagForChildDirectedTreatment: " + tagForChildDirectedTreatment);
            }
            return this;
        }

        public Builder setTagForUnderAgeOfConsent(int tagForUnderAgeOfConsent) {
            if (tagForUnderAgeOfConsent == -1 || tagForUnderAgeOfConsent == 0 || tagForUnderAgeOfConsent == 1) {
                this.zzb = tagForUnderAgeOfConsent;
            } else {
                zzm.zzj("Invalid value passed to setTagForUnderAgeOfConsent: " + tagForUnderAgeOfConsent);
            }
            return this;
        }

        public Builder setTestDeviceIds(@Nullable List<String> testDeviceIds) {
            this.zzd.clear();
            if (testDeviceIds != null) {
                this.zzd.addAll(testDeviceIds);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public @interface MaxAdContentRating {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public enum PublisherPrivacyPersonalizationState {
        DEFAULT(0),
        ENABLED(1),
        DISABLED(2);
        
        private final int zzb;

        private PublisherPrivacyPersonalizationState(int i) {
            this.zzb = i;
        }

        public int getValue() {
            return this.zzb;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public @interface TagForChildDirectedTreatment {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public @interface TagForUnderAgeOfConsent {
    }

    /* synthetic */ RequestConfiguration(int i, int i2, String str, List list, PublisherPrivacyPersonalizationState publisherPrivacyPersonalizationState, zzh zzh) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
        this.zze = list;
        this.zzf = publisherPrivacyPersonalizationState;
    }

    public String getMaxAdContentRating() {
        String str = this.zzd;
        return str == null ? "" : str;
    }

    public PublisherPrivacyPersonalizationState getPublisherPrivacyPersonalizationState() {
        return this.zzf;
    }

    public int getTagForChildDirectedTreatment() {
        return this.zzb;
    }

    public int getTagForUnderAgeOfConsent() {
        return this.zzc;
    }

    public List<String> getTestDeviceIds() {
        return new ArrayList(this.zze);
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setTagForChildDirectedTreatment(this.zzb);
        builder.setTagForUnderAgeOfConsent(this.zzc);
        builder.setMaxAdContentRating(this.zzd);
        builder.setTestDeviceIds(this.zze);
        return builder;
    }
}
