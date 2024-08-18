package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbcu {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbcq(this);
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public zzbcx zzd;
    private Context zze;
    /* access modifiers changed from: private */
    public zzbda zzf;

    static /* bridge */ /* synthetic */ void zzh(zzbcu zzbcu) {
        synchronized (zzbcu.zzc) {
            zzbcx zzbcx = zzbcu.zzd;
            if (zzbcx != null) {
                if (zzbcx.isConnected() || zzbcu.zzd.isConnecting()) {
                    zzbcu.zzd.disconnect();
                }
                zzbcu.zzd = null;
                zzbcu.zzf = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzc
            monitor-enter(r0)
            android.content.Context r1 = r3.zze     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzbcx r1 = r3.zzd     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.zzbcs r1 = new com.google.android.gms.internal.ads.zzbcs     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbct r2 = new com.google.android.gms.internal.ads.zzbct     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbcx r1 = r3.zzd(r1, r2)     // Catch:{ all -> 0x0025 }
            r3.zzd = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbcx r1 = r3.zzd     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcu.zzl():void");
    }

    public final long zza(zzbcy zzbcy) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2;
            }
            if (this.zzd.zzp()) {
                try {
                    long zze2 = this.zzf.zze(zzbcy);
                    return zze2;
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    public final zzbcv zzb(zzbcy zzbcy) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                zzbcv zzbcv = new zzbcv();
                return zzbcv;
            }
            try {
                if (this.zzd.zzp()) {
                    zzbcv zzg = this.zzf.zzg(zzbcy);
                    return zzg;
                }
                zzbcv zzf2 = this.zzf.zzf(zzbcy);
                return zzf2;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call into cache service.", e);
                return new zzbcv();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized zzbcx zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbcx(this.zze, zzu.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzc
            monitor-enter(r0)
            android.content.Context r1 = r2.zze     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zze = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzek     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zza(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzej     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zza(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzbcr r3 = new com.google.android.gms.internal.ads.zzbcr     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbbh r1 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ all -> 0x0048 }
            r1.zzc(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcu.zzi(android.content.Context):void");
    }

    public final void zzj() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzel)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcci.zzd.schedule(this.zzb, ((Long) zzba.zzc().zza(zzbep.zzem)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
