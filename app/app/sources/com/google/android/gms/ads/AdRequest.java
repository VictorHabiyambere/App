package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_AD_STRING = 11;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_REQUEST_ID_MISMATCH = 10;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    protected final zzdx zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static class Builder extends AbstractAdRequestBuilder<Builder> {
        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder self() {
            return this;
        }
    }

    protected AdRequest(AbstractAdRequestBuilder abstractAdRequestBuilder) {
        this.zza = new zzdx(abstractAdRequestBuilder.zza, (SearchAdRequest) null);
    }

    public String getAdString() {
        return this.zza.zzj();
    }

    public String getContentUrl() {
        return this.zza.zzk();
    }

    @Deprecated
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zza.zzd(adapterClass);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zze();
    }

    public Set<String> getKeywords() {
        return this.zza.zzp();
    }

    public List<String> getNeighboringContentUrls() {
        return this.zza.zzn();
    }

    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zza.zzf(adapterClass);
    }

    public String getRequestAgent() {
        return this.zza.zzm();
    }

    public boolean isTestDevice(Context context) {
        return this.zza.zzr(context);
    }

    public final zzdx zza() {
        return this.zza;
    }
}
