package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzaq;
import com.google.android.gms.internal.auth.zzav;
import com.google.android.gms.internal.auth.zzax;
import com.google.android.gms.internal.auth.zzaz;
import com.google.android.gms.internal.auth.zzbb;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class AccountTransferClient extends GoogleApi<zzr> {
    public static final /* synthetic */ int zza = 0;
    private static final Api.ClientKey zzb = new Api.ClientKey();
    private static final Api.AbstractClientBuilder zzc = new zzb();
    private static final Api zzd = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzc, zzb);

    AccountTransferClient(Activity activity, zzr zzr) {
        super(activity, zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    public Task<DeviceMetaData> getDeviceMetaData(String accountType) {
        Preconditions.checkNotNull(accountType);
        return doRead(new zzg(this, 1608, new zzaq(accountType)));
    }

    public Task<Void> notifyCompletion(String accountType, int completionStatus) {
        Preconditions.checkNotNull(accountType);
        return doWrite(new zzi(this, 1610, new zzav(accountType, completionStatus)));
    }

    public Task<byte[]> retrieveData(String accountType) {
        Preconditions.checkNotNull(accountType);
        return doRead(new zze(this, 1607, new zzax(accountType)));
    }

    public Task<Void> sendData(String accountType, byte[] transferData) {
        Preconditions.checkNotNull(accountType);
        Preconditions.checkNotNull(transferData);
        return doWrite(new zzc(this, 1606, new zzaz(accountType, transferData)));
    }

    public Task<Void> showUserChallenge(String accountType, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(accountType);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new zzh(this, 1609, new zzbb(accountType, pendingIntent)));
    }

    AccountTransferClient(Context context, zzr zzr) {
        super(context, zzd, zzr.zza, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
