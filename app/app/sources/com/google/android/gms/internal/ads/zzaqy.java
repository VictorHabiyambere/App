package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaqy extends Thread {
    private final BlockingQueue zza;
    private final zzaqx zzb;
    private final zzaqo zzc;
    private volatile boolean zzd = false;
    private final zzaqv zze;

    public zzaqy(BlockingQueue blockingQueue, zzaqx zzaqx, zzaqo zzaqo, zzaqv zzaqv) {
        this.zza = blockingQueue;
        this.zzb = zzaqx;
        this.zzc = zzaqo;
        this.zze = zzaqv;
    }

    private void zzb() throws InterruptedException {
        zzare zzare = (zzare) this.zza.take();
        SystemClock.elapsedRealtime();
        zzare.zzt(3);
        try {
            zzare.zzm("network-queue-take");
            zzare.zzw();
            TrafficStats.setThreadStatsTag(zzare.zzc());
            zzara zza2 = this.zzb.zza(zzare);
            zzare.zzm("network-http-complete");
            if (!zza2.zze || !zzare.zzv()) {
                zzark zzh = zzare.zzh(zza2);
                zzare.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzare.zzj(), zzh.zzb);
                    zzare.zzm("network-cache-written");
                }
                zzare.zzq();
                this.zze.zzb(zzare, zzh, (Runnable) null);
                zzare.zzs(zzh);
                zzare.zzt(4);
            }
            zzare.zzp("not-modified");
            zzare.zzr();
            zzare.zzt(4);
        } catch (zzarn e) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzare, e);
            zzare.zzr();
        } catch (Exception e2) {
            zzarq.zzc(e2, "Unhandled exception %s", e2.toString());
            zzarn zzarn = new zzarn((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzare, zzarn);
            zzare.zzr();
        } catch (Throwable th) {
            zzare.zzt(4);
            throw th;
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException e) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarq.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
