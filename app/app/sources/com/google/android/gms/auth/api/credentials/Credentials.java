package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.Auth;

@Deprecated
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class Credentials {
    public static CredentialsClient getClient(Activity activity) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    public static CredentialsClient getClient(Activity activity, CredentialsOptions options) {
        return new CredentialsClient(activity, (Auth.AuthCredentialsOptions) options);
    }

    public static CredentialsClient getClient(Context context) {
        return new CredentialsClient(context, (Auth.AuthCredentialsOptions) CredentialsOptions.DEFAULT);
    }

    public static CredentialsClient getClient(Context context, CredentialsOptions options) {
        return new CredentialsClient(context, (Auth.AuthCredentialsOptions) options);
    }
}
