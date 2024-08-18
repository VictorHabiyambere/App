package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzeas implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzccn zza = new zzccn();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzbxu zze;
    protected zzbwr zzf;

    static void zzc(Context context, ListenableFuture listenableFuture, Executor executor) {
        if (((Boolean) zzbgc.zzj.zze()).booleanValue() || ((Boolean) zzbgc.zzh.zze()).booleanValue()) {
            zzgft.zzr(listenableFuture, new zzeaq(context), executor);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Disconnected from remote ad request service.");
        this.zza.zzd(new zzebh(1));
    }

    public final void onConnectionSuspended(int i) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        synchronized (this.zzb) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
