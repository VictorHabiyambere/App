package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class WorkManagerUtil extends zzbs {
    private static void zzb(Context context) {
        try {
            WorkManager.initialize(context.getApplicationContext(), new Configuration.Builder().build());
        } catch (IllegalStateException e) {
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            WorkManager instance = WorkManager.getInstance(context);
            instance.cancelAllWorkByTag("offline_ping_sender_work");
            instance.enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflinePingSender.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).addTag("offline_ping_sender_work")).build());
        } catch (IllegalStateException e) {
            zzm.zzk("Failed to instantiate WorkManager.", e);
        }
    }

    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        return zzg(iObjectWrapper, new zza(str, str2, ""));
    }

    public final boolean zzg(IObjectWrapper iObjectWrapper, zza zza) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        try {
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).setConstraints(build)).setInputData(new Data.Builder().putString("uri", zza.zza).putString("gws_query_id", zza.zzb).putString("image_url", zza.zzc).build())).addTag("offline_notification_work")).build());
            return true;
        } catch (IllegalStateException e) {
            zzm.zzk("Failed to instantiate WorkManager.", e);
            return false;
        }
    }
}
