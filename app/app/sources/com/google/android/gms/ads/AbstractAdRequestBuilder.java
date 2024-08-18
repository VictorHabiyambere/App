package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AbstractAdRequestBuilder;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class AbstractAdRequestBuilder<T extends AbstractAdRequestBuilder<T>> {
    protected final zzdw zza = new zzdw();

    protected AbstractAdRequestBuilder() {
        this.zza.zzt("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    @Deprecated
    public T addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
        this.zza.zzo(adapterClass, customEventExtras);
        return self();
    }

    public T addKeyword(String keyword) {
        this.zza.zzq(keyword);
        return self();
    }

    public T addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> adapterClass, Bundle networkExtras) {
        this.zza.zzr(adapterClass, networkExtras);
        if (adapterClass.equals(AdMobAdapter.class) && networkExtras.getBoolean("_emulatorLiveAds")) {
            this.zza.zzu("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return self();
    }

    /* access modifiers changed from: protected */
    public abstract T self();

    public T setAdString(String adString) {
        this.zza.zzv(adString);
        return self();
    }

    public T setContentUrl(String contentUrl) {
        boolean z;
        Preconditions.checkNotNull(contentUrl, "Content URL must be non-null.");
        Preconditions.checkNotEmpty(contentUrl, "Content URL must be non-empty.");
        int length = contentUrl.length();
        Object[] objArr = {512, Integer.valueOf(contentUrl.length())};
        if (length <= 512) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
        this.zza.zzw(contentUrl);
        return self();
    }

    public T setHttpTimeoutMillis(int httpTimeoutMillis) {
        this.zza.zzx(httpTimeoutMillis);
        return self();
    }

    public T setNeighboringContentUrls(List<String> neighboringContentUrls) {
        if (neighboringContentUrls == null) {
            zzm.zzj("neighboring content URLs list should not be null");
            return self();
        }
        this.zza.zzz(neighboringContentUrls);
        return self();
    }

    public T setRequestAgent(String requestAgent) {
        this.zza.zzB(requestAgent);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zza(String str) {
        this.zza.zzt(str);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zzb(boolean z) {
        this.zza.zzy(z);
        return self();
    }

    @Deprecated
    public final AbstractAdRequestBuilder zzc(boolean z) {
        this.zza.zzC(z);
        return self();
    }
}
