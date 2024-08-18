package com.google.ads.mediation.admob;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class AdMobAdapter extends AbstractAdViewAdapter {
    static final String AD_JSON_PARAMETER = "adJson";
    static final String AD_PARAMETER = "_ad";
    static final String HOUSE_ADS_PARAMETER = "mad_hac";
    public static final String NEW_BUNDLE = "_newBundle";

    /* access modifiers changed from: protected */
    public Bundle buildExtrasBundle(Bundle extras, Bundle serverParameters) {
        if (extras == null) {
            extras = new Bundle();
        }
        if (extras.getBoolean(NEW_BUNDLE)) {
            extras = new Bundle(extras);
        }
        extras.putInt("gw", 1);
        extras.putString(HOUSE_ADS_PARAMETER, serverParameters.getString(HOUSE_ADS_PARAMETER));
        if (!TextUtils.isEmpty(serverParameters.getString(AD_JSON_PARAMETER))) {
            extras.putString(AD_PARAMETER, serverParameters.getString(AD_JSON_PARAMETER));
        }
        extras.putBoolean("_noRefresh", true);
        return extras;
    }
}
