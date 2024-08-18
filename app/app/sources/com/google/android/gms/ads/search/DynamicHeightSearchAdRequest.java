package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzb zza = new zzb();
        private final Bundle zzb = new Bundle();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zza.zzb(adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zza.zzc(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zza.zzd(adapterClass, networkExtras);
            return this;
        }

        public DynamicHeightSearchAdRequest build() {
            this.zza.zzd(AdMobAdapter.class, this.zzb);
            return new DynamicHeightSearchAdRequest(this, (zza) null);
        }

        public Builder setAdBorderSelectors(String adBorderSelectors) {
            this.zzb.putString("csa_adBorderSelectors", adBorderSelectors);
            return this;
        }

        public Builder setAdTest(boolean adTest) {
            this.zzb.putString("csa_adtest", true != adTest ? DebugKt.DEBUG_PROPERTY_VALUE_OFF : DebugKt.DEBUG_PROPERTY_VALUE_ON);
            return this;
        }

        public Builder setAdjustableLineHeight(int adjustableLineHeight) {
            this.zzb.putString("csa_adjustableLineHeight", Integer.toString(adjustableLineHeight));
            return this;
        }

        public Builder setAdvancedOptionValue(String key, String value) {
            this.zzb.putString(key, value);
            return this;
        }

        public Builder setAttributionSpacingBelow(int attributionSpacingBelow) {
            this.zzb.putString("csa_attributionSpacingBelow", Integer.toString(attributionSpacingBelow));
            return this;
        }

        public Builder setBorderSelections(String borderSelections) {
            this.zzb.putString("csa_borderSelections", borderSelections);
            return this;
        }

        public Builder setChannel(String channel) {
            this.zzb.putString("csa_channel", channel);
            return this;
        }

        public Builder setColorAdBorder(String colorAdBorder) {
            this.zzb.putString("csa_colorAdBorder", colorAdBorder);
            return this;
        }

        public Builder setColorAdSeparator(String colorAdSeparator) {
            this.zzb.putString("csa_colorAdSeparator", colorAdSeparator);
            return this;
        }

        public Builder setColorAnnotation(String colorAnnotation) {
            this.zzb.putString("csa_colorAnnotation", colorAnnotation);
            return this;
        }

        public Builder setColorAttribution(String colorAttribution) {
            this.zzb.putString("csa_colorAttribution", colorAttribution);
            return this;
        }

        public Builder setColorBackground(String colorBackground) {
            this.zzb.putString("csa_colorBackground", colorBackground);
            return this;
        }

        public Builder setColorBorder(String colorBorder) {
            this.zzb.putString("csa_colorBorder", colorBorder);
            return this;
        }

        public Builder setColorDomainLink(String colorDomainLink) {
            this.zzb.putString("csa_colorDomainLink", colorDomainLink);
            return this;
        }

        public Builder setColorText(String colorText) {
            this.zzb.putString("csa_colorText", colorText);
            return this;
        }

        public Builder setColorTitleLink(String colorTitleLink) {
            this.zzb.putString("csa_colorTitleLink", colorTitleLink);
            return this;
        }

        public Builder setCssWidth(int width) {
            this.zzb.putString("csa_width", Integer.toString(width));
            return this;
        }

        public Builder setDetailedAttribution(boolean detailedAttribution) {
            this.zzb.putString("csa_detailedAttribution", Boolean.toString(detailedAttribution));
            return this;
        }

        public Builder setFontFamily(String fontFamily) {
            this.zzb.putString("csa_fontFamily", fontFamily);
            return this;
        }

        public Builder setFontFamilyAttribution(String fontFamilyAttribution) {
            this.zzb.putString("csa_fontFamilyAttribution", fontFamilyAttribution);
            return this;
        }

        public Builder setFontSizeAnnotation(int fontSizeAnnotation) {
            this.zzb.putString("csa_fontSizeAnnotation", Integer.toString(fontSizeAnnotation));
            return this;
        }

        public Builder setFontSizeAttribution(int fontSizeAttribution) {
            this.zzb.putString("csa_fontSizeAttribution", Integer.toString(fontSizeAttribution));
            return this;
        }

        public Builder setFontSizeDescription(int fontSizeDescription) {
            this.zzb.putString("csa_fontSizeDescription", Integer.toString(fontSizeDescription));
            return this;
        }

        public Builder setFontSizeDomainLink(int fontSizeDomainLink) {
            this.zzb.putString("csa_fontSizeDomainLink", Integer.toString(fontSizeDomainLink));
            return this;
        }

        public Builder setFontSizeTitle(int fontSizeTitle) {
            this.zzb.putString("csa_fontSizeTitle", Integer.toString(fontSizeTitle));
            return this;
        }

        public Builder setHostLanguage(String hostLanguage) {
            this.zzb.putString("csa_hl", hostLanguage);
            return this;
        }

        public Builder setIsClickToCallEnabled(boolean isClickToCallEnabled) {
            this.zzb.putString("csa_clickToCall", Boolean.toString(isClickToCallEnabled));
            return this;
        }

        public Builder setIsLocationEnabled(boolean isLocationEnabled) {
            this.zzb.putString("csa_location", Boolean.toString(isLocationEnabled));
            return this;
        }

        public Builder setIsPlusOnesEnabled(boolean isPlusOnesEnabled) {
            this.zzb.putString("csa_plusOnes", Boolean.toString(isPlusOnesEnabled));
            return this;
        }

        public Builder setIsSellerRatingsEnabled(boolean isSellerRatingsEnabled) {
            this.zzb.putString("csa_sellerRatings", Boolean.toString(isSellerRatingsEnabled));
            return this;
        }

        public Builder setIsSiteLinksEnabled(boolean isSiteLinksEnabled) {
            this.zzb.putString("csa_siteLinks", Boolean.toString(isSiteLinksEnabled));
            return this;
        }

        public Builder setIsTitleBold(boolean isTitleBold) {
            this.zzb.putString("csa_titleBold", Boolean.toString(isTitleBold));
            return this;
        }

        public Builder setIsTitleUnderlined(boolean isTitleUnderlined) {
            this.zzb.putString("csa_noTitleUnderline", Boolean.toString(!isTitleUnderlined));
            return this;
        }

        public Builder setLocationColor(String locationColor) {
            this.zzb.putString("csa_colorLocation", locationColor);
            return this;
        }

        public Builder setLocationFontSize(int locationFontSize) {
            this.zzb.putString("csa_fontSizeLocation", Integer.toString(locationFontSize));
            return this;
        }

        public Builder setLongerHeadlines(boolean longerHeadlines) {
            this.zzb.putString("csa_longerHeadlines", Boolean.toString(longerHeadlines));
            return this;
        }

        public Builder setNumber(int numberOfAds) {
            this.zzb.putString("csa_number", Integer.toString(numberOfAds));
            return this;
        }

        public Builder setPage(int adPage) {
            this.zzb.putString("csa_adPage", Integer.toString(adPage));
            return this;
        }

        public Builder setQuery(String query) {
            this.zza.zze(query);
            return this;
        }

        public Builder setStyleId(String styleId) {
            this.zzb.putString("csa_styleId", styleId);
            return this;
        }

        public Builder setVerticalSpacing(int verticalSpacing) {
            this.zzb.putString("csa_verticalSpacing", Integer.toString(verticalSpacing));
            return this;
        }
    }

    /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zza2) {
        this.zza = new SearchAdRequest(builder.zza, (zzc) null);
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zza.getCustomEventExtrasBundle(adapterClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zza.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.zza.getQuery();
    }

    public boolean isTestDevice(Context context) {
        return this.zza.isTestDevice(context);
    }

    /* access modifiers changed from: package-private */
    public final zzdx zza() {
        return this.zza.zza();
    }
}
