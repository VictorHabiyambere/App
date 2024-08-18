package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzecx extends zzeda {
    private zzbwv zzh;

    zzecx(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = zzu.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    public final synchronized void onConnected(Bundle bundle) {
        if (!this.zzc) {
            this.zzc = true;
            try {
                this.zzd.zzp().zzf(this.zzh, new zzecz(this));
            } catch (RemoteException e) {
                this.zza.zzd(new zzebh(1));
            } catch (Throwable th) {
                zzu.zzo().zzw(th, "RemoteAdsServiceSignalClientTask.onConnected");
                this.zza.zzd(th);
            }
        }
    }

    public final void onConnectionSuspended(int i) {
        String format = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", new Object[]{Integer.valueOf(i)});
        zzm.zze(format);
        this.zza.zzd(new zzebh(1, format));
    }

    public final synchronized ListenableFuture zza(zzbwv zzbwv, long j) {
        if (this.zzb) {
            return zzgft.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbwv;
        zzb();
        ListenableFuture zzo = zzgft.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        zzo.addListener(new zzecw(this), zzcci.zzf);
        return zzo;
    }
}
