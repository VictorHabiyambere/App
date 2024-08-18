package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeau extends zzeas {
    private final Context zzg;
    private final Executor zzh;

    zzeau(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbwr(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzear(this));
                } catch (RemoteException e) {
                } catch (IllegalArgumentException e2) {
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzebh(1));
                }
            }
        }
        this.zza.zzd(new zzebh(1));
    }

    public final ListenableFuture zza(zzbxu zzbxu) {
        synchronized (this.zzb) {
            if (this.zzc) {
                zzccn zzccn = this.zza;
                return zzccn;
            }
            this.zzc = true;
            this.zze = zzbxu;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new zzeat(this), zzcci.zzf);
            zzc(this.zzg, this.zza, this.zzh);
            zzccn zzccn2 = this.zza;
            return zzccn2;
        }
    }
}
