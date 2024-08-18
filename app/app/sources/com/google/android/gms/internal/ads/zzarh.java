package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzarh {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzaqo zze;
    private final zzaqx zzf;
    private final zzaqy[] zzg;
    private zzaqq zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzaqv zzk;

    public zzarh(zzaqo zzaqo, zzaqx zzaqx, int i) {
        zzaqv zzaqv = new zzaqv(new Handler(Looper.getMainLooper()));
        this.zze = zzaqo;
        this.zzf = zzaqx;
        this.zzg = new zzaqy[4];
        this.zzk = zzaqv;
    }

    public final zzare zza(zzare zzare) {
        zzare.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzare);
        }
        zzare.zzg(this.zza.incrementAndGet());
        zzare.zzm("add-to-queue");
        zzc(zzare, 0);
        this.zzc.add(zzare);
        return zzare;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzare zzare) {
        synchronized (this.zzb) {
            this.zzb.remove(zzare);
        }
        synchronized (this.zzi) {
            for (zzarg zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzare, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzare zzare, int i) {
        synchronized (this.zzj) {
            for (zzarf zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzaqq zzaqq = this.zzh;
        if (zzaqq != null) {
            zzaqq.zzb();
        }
        zzaqy[] zzaqyArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzaqy zzaqy = zzaqyArr[i];
            if (zzaqy != null) {
                zzaqy.zza();
            }
        }
        this.zzh = new zzaqq(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzaqy zzaqy2 = new zzaqy(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i2] = zzaqy2;
            zzaqy2.start();
        }
    }
}
