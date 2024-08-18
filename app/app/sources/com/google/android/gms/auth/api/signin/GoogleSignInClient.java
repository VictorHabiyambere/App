package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    static int zba = 1;
    private static final zbb zbb = new zbb((zba) null);

    GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    private final synchronized int zba() {
        int i;
        i = zba;
        if (i == 1) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, 12451000);
            if (isGooglePlayServicesAvailable == 0) {
                i = 4;
                zba = 4;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, (String) null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                i = 2;
                zba = 2;
            } else {
                i = 3;
                zba = 3;
            }
        }
        return i;
    }

    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int zba2 = zba();
        int i = zba2 - 1;
        if (zba2 != 0) {
            switch (i) {
                case 2:
                    return zbm.zba(applicationContext, (GoogleSignInOptions) getApiOptions());
                case 3:
                    return zbm.zbc(applicationContext, (GoogleSignInOptions) getApiOptions());
                default:
                    return zbm.zbb(applicationContext, (GoogleSignInOptions) getApiOptions());
            }
        } else {
            throw null;
        }
    }

    public Task<Void> revokeAccess() {
        boolean z;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z = true;
        } else {
            z = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbf(asGoogleApiClient, applicationContext, z));
    }

    public Task<Void> signOut() {
        boolean z;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (zba() == 3) {
            z = true;
        } else {
            z = false;
        }
        return PendingResultUtil.toVoidTask(zbm.zbg(asGoogleApiClient, applicationContext, z));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        boolean z;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) getApiOptions();
        if (zba() == 3) {
            z = true;
        } else {
            z = false;
        }
        return PendingResultUtil.toTask(zbm.zbe(asGoogleApiClient, applicationContext, googleSignInOptions, z), zbb);
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
