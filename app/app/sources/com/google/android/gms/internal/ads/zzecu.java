package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzecu extends zzeda {
    private zzbwz zzh;

    zzecu(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = zzu.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    public final synchronized void onConnected(Bundle bundle) {
        if (!this.zzc) {
            this.zzc = true;
            try {
                this.zzd.zzp().zze(this.zzh, new zzecz(this));
            } catch (RemoteException e) {
                this.zza.zzd(new zzebh(1));
            } catch (Throwable th) {
                zzu.zzo().zzw(th, "RemoteAdsServiceProxyClientTask.onConnected");
                this.zza.zzd(th);
            }
        }
    }

    public final synchronized ListenableFuture zza(zzbwz zzbwz, long j) {
        if (this.zzb) {
            return zzgft.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbwz;
        zzb();
        ListenableFuture zzo = zzgft.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        zzo.addListener(new zzect(this), zzcci.zzf);
        return zzo;
    }
}
