package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrb;
import com.google.android.gms.internal.ads.zzbuz;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class OfflineNotificationPoster extends Worker {
    private final zzbuz zza;

    public OfflineNotificationPoster(Context context, WorkerParameters params) {
        super(context, params);
        this.zza = zzay.zza().zzm(context, new zzbrb());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzj(ObjectWrapper.wrap(getApplicationContext()), new zza(getInputData().getString("uri"), getInputData().getString("gws_query_id"), getInputData().getString("image_url")));
            return ListenableWorker.Result.success();
        } catch (RemoteException e) {
            return ListenableWorker.Result.failure();
        }
    }
}
