package com.google.android.gms.fido.fido2;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;
import com.google.android.gms.fido.zza;
import com.google.android.gms.internal.fido.zzo;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class Fido2ApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey zza = new Api.ClientKey();
    private static final Api zzb = new Api("Fido.FIDO2_API", new zzo(), zza);

    @Deprecated
    public Fido2ApiClient(Activity activity) {
        super(activity, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @Deprecated
    public Task<Fido2PendingIntent> getRegisterIntent(PublicKeyCredentialCreationOptions requestOptions) {
        return doRead(TaskApiCall.builder().setMethodKey(5409).run(new zzd(this, requestOptions)).build());
    }

    public Task<PendingIntent> getRegisterPendingIntent(PublicKeyCredentialCreationOptions requestOptions) {
        return doRead(TaskApiCall.builder().run(new zzc(this, requestOptions)).setMethodKey(5407).build());
    }

    @Deprecated
    public Task<Fido2PendingIntent> getSignIntent(PublicKeyCredentialRequestOptions requestOptions) {
        return doRead(TaskApiCall.builder().setMethodKey(5410).run(new zza(this, requestOptions)).build());
    }

    public Task<PendingIntent> getSignPendingIntent(PublicKeyCredentialRequestOptions requestOptions) {
        return doRead(TaskApiCall.builder().run(new zze(this, requestOptions)).setMethodKey(5408).build());
    }

    public Task<Boolean> isUserVerifyingPlatformAuthenticatorAvailable() {
        return doRead(TaskApiCall.builder().run(new zzb(this)).setFeatures(zza.zzh).setMethodKey(5411).build());
    }

    @Deprecated
    public Fido2ApiClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
