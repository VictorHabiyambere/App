package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
final class zzs extends GmsClientSupervisor {
    /* access modifiers changed from: private */
    public final HashMap zzb = new HashMap();
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public volatile Handler zzd;
    private final zzr zze = new zzr(this, (zzq) null);
    /* access modifiers changed from: private */
    public final ConnectionTracker zzf;
    private final long zzg;
    /* access modifiers changed from: private */
    public final long zzh;
    private volatile Executor zzi;

    zzs(Context context, Looper looper, Executor executor) {
        this.zzc = context.getApplicationContext();
        this.zzd = new zzi(looper, this.zze);
        this.zzf = ConnectionTracker.getInstance();
        this.zzg = 5000;
        this.zzh = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.zzi = executor;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzo zzo, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzp = (zzp) this.zzb.get(zzo);
            if (zzp == null) {
                String obj = zzo.toString();
                throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
            } else if (zzp.zzh(serviceConnection)) {
                zzp.zzf(serviceConnection, str);
                if (zzp.zzi()) {
                    this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzo), this.zzg);
                }
            } else {
                String obj2 = zzo.toString();
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc(zzo zzo, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zzj;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            zzp zzp = (zzp) this.zzb.get(zzo);
            if (executor == null) {
                executor = this.zzi;
            }
            if (zzp == null) {
                zzp = new zzp(this, zzo);
                zzp.zzd(serviceConnection, serviceConnection, str);
                zzp.zze(str, executor);
                this.zzb.put(zzo, zzp);
            } else {
                this.zzd.removeMessages(0, zzo);
                if (!zzp.zzh(serviceConnection)) {
                    zzp.zzd(serviceConnection, serviceConnection, str);
                    switch (zzp.zza()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzp.zzb(), zzp.zzc());
                            break;
                        case 2:
                            zzp.zze(str, executor);
                            break;
                    }
                } else {
                    String obj = zzo.toString();
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                }
            }
            zzj = zzp.zzj();
        }
        return zzj;
    }

    /* access modifiers changed from: package-private */
    public final void zzi(Executor executor) {
        synchronized (this.zzb) {
            this.zzi = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(Looper looper) {
        synchronized (this.zzb) {
            this.zzd = new zzi(looper, this.zze);
        }
    }
}
