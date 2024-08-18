package com.google.android.gms.fido.fido2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialRequestOptions;
import com.google.android.gms.fido.fido2.api.common.FidoCredentialDetails;
import com.google.android.gms.fido.zza;
import com.google.android.gms.internal.fido.zzj;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class Fido2PrivilegedApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey zza = new Api.ClientKey();
    private static final Api zzb = new Api("Fido.FIDO2_PRIVILEGED_API", new zzj(), zza);

    @Deprecated
    public Fido2PrivilegedApiClient(Activity activity) {
        super(activity, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<List<FidoCredentialDetails>> getCredentialList(String rpId) {
        return doRead(TaskApiCall.builder().run(new zzk(this, rpId)).setMethodKey(5430).build());
    }

    @Deprecated
    public Task<Fido2PendingIntent> getRegisterIntent(BrowserPublicKeyCredentialCreationOptions requestOptions) {
        return doRead(TaskApiCall.builder().setMethodKey(5414).run(new zzo(this, requestOptions)).build());
    }

    public Task<PendingIntent> getRegisterPendingIntent(BrowserPublicKeyCredentialCreationOptions requestOptions) {
        return doRead(TaskApiCall.builder().run(new zzl(this, requestOptions)).setMethodKey(5412).build());
    }

    @Deprecated
    public Task<Fido2PendingIntent> getSignIntent(BrowserPublicKeyCredentialRequestOptions requestOptions) {
        return doRead(TaskApiCall.builder().setMethodKey(5415).run(new zzn(this, requestOptions)).build());
    }

    public Task<PendingIntent> getSignPendingIntent(BrowserPublicKeyCredentialRequestOptions requestOptions) {
        return doRead(TaskApiCall.builder().run(new zzm(this, requestOptions)).setMethodKey(5413).build());
    }

    public Task<Boolean> isUserVerifyingPlatformAuthenticatorAvailable() {
        return doRead(TaskApiCall.builder().run(new zzp(this)).setFeatures(zza.zzh).setMethodKey(5416).build());
    }

    @Deprecated
    public Fido2PrivilegedApiClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
