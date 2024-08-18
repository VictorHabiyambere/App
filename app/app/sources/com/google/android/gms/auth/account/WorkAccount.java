package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzal;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class WorkAccount {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("WorkAccount.API", zzb, zza);
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzal();
    private static final Api.ClientKey zza = new Api.ClientKey();
    private static final Api.AbstractClientBuilder zzb = new zzf();

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(Context context) {
        return new WorkAccountClient(context);
    }
}
