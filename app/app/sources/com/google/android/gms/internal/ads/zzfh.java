package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzfh {
    private final zzer zza;
    private final zzfb zzb;
    private final zzff zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzfh(Looper looper, zzer zzer, zzff zzff) {
        this(new CopyOnWriteArraySet(), looper, zzer, zzff, true);
    }

    public static /* synthetic */ boolean zzg(zzfh zzfh, Message message) {
        Iterator it = zzfh.zzd.iterator();
        while (it.hasNext()) {
            ((zzfg) it.next()).zzb(zzfh.zzc);
            if (zzfh.zzb.zzg(0)) {
                return true;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzeq.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzfh zza(Looper looper, zzff zzff) {
        return new zzfh(this.zzd, looper, this.zza, zzff, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (!this.zzh) {
                this.zzd.add(new zzfg(obj));
            }
        }
    }

    public final void zzc() {
        zzh();
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzg(0)) {
                zzfb zzfb = this.zzb;
                zzfb.zzk(zzfb.zzb(0));
            }
            boolean z = !this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!z) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i, zzfe zzfe) {
        zzh();
        this.zzf.add(new zzfd(new CopyOnWriteArraySet(this.zzd), i, zzfe));
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzfg) it.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            zzfg zzfg = (zzfg) it.next();
            if (zzfg.zza.equals(obj)) {
                zzfg.zzc(this.zzc);
                this.zzd.remove(zzfg);
            }
        }
    }

    private zzfh(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzer zzer, zzff zzff, boolean z) {
        this.zza = zzer;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzff;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzer.zzb(looper, new zzfc(this));
        this.zzi = z;
    }
}
