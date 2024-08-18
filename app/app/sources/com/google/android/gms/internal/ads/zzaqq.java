package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaqq extends Thread {
    private static final boolean zza = zzarq.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzaqo zzd;
    private volatile boolean zze = false;
    private final zzarr zzf;
    private final zzaqv zzg;

    public zzaqq(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaqo zzaqo, zzaqv zzaqv) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaqo;
        this.zzg = zzaqv;
        this.zzf = new zzarr(this, blockingQueue2, zzaqv);
    }

    private void zzc() throws InterruptedException {
        zzare zzare = (zzare) this.zzb.take();
        zzare.zzm("cache-queue-take");
        zzare.zzt(1);
        try {
            zzare.zzw();
            zzaqn zza2 = this.zzd.zza(zzare.zzj());
            if (zza2 == null) {
                zzare.zzm("cache-miss");
                if (!this.zzf.zzc(zzare)) {
                    this.zzc.put(zzare);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (zza2.zza(currentTimeMillis)) {
                    zzare.zzm("cache-hit-expired");
                    zzare.zze(zza2);
                    if (!this.zzf.zzc(zzare)) {
                        this.zzc.put(zzare);
                    }
                } else {
                    zzare.zzm("cache-hit");
                    zzark zzh = zzare.zzh(new zzara(zza2.zza, zza2.zzg));
                    zzare.zzm("cache-hit-parsed");
                    if (!zzh.zzc()) {
                        zzare.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzare.zzj(), true);
                        zzare.zze((zzaqn) null);
                        if (!this.zzf.zzc(zzare)) {
                            this.zzc.put(zzare);
                        }
                    } else if (zza2.zzf < currentTimeMillis) {
                        zzare.zzm("cache-hit-refresh-needed");
                        zzare.zze(zza2);
                        zzh.zzd = true;
                        if (!this.zzf.zzc(zzare)) {
                            this.zzg.zzb(zzare, zzh, new zzaqp(this, zzare));
                        } else {
                            this.zzg.zzb(zzare, zzh, (Runnable) null);
                        }
                    } else {
                        this.zzg.zzb(zzare, zzh, (Runnable) null);
                    }
                }
            }
        } finally {
            zzare.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzarq.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException e) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarq.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
