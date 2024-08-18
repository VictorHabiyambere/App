package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class AvailabilityException extends Exception {
    private final ArrayMap zaa;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> api) {
        boolean z;
        ApiKey<? extends Api.ApiOptions> apiKey = api.getApiKey();
        if (this.zaa.get(apiKey) != null) {
            z = true;
        } else {
            z = false;
        }
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(z, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (ApiKey apiKey : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
            z &= !connectionResult.isSuccess();
            arrayList.add(apiKey.zaa() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> api) {
        boolean z;
        ApiKey<? extends Api.ApiOptions> apiKey = api.getApiKey();
        if (this.zaa.get(apiKey) != null) {
            z = true;
        } else {
            z = false;
        }
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(z, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }
}
