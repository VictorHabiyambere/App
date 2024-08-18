package com.google.android.gms.fido.u2f;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.fido.u2f.api.common.RegisterRequestParams;
import com.google.android.gms.fido.u2f.api.common.SignRequestParams;
import com.google.android.gms.internal.fido.zzx;
import com.google.android.gms.tasks.Task;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class U2fApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey zza = new Api.ClientKey();
    private static final Api zzb = new Api("Fido.U2F_API", new zzx(), zza);

    public U2fApiClient(Activity activity) {
        super(activity, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<U2fPendingIntent> getRegisterIntent(RegisterRequestParams requestParams) {
        return doRead(TaskApiCall.builder().setMethodKey(5424).run(new zzb(this, requestParams)).build());
    }

    public Task<U2fPendingIntent> getSignIntent(SignRequestParams requestParams) {
        return doRead(TaskApiCall.builder().setMethodKey(5425).run(new zza(this, requestParams)).build());
    }

    public U2fApiClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
