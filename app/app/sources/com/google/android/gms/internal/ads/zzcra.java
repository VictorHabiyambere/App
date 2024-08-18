package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcra implements zzban, zzdag, zzp, zzdaf {
    private final zzcqv zza;
    private final zzcqw zzb;
    private final Set zzc = new HashSet();
    private final zzbqt zzd;
    private final Executor zze;
    private final Clock zzf;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzcqz zzh = new zzcqz();
    private boolean zzi = false;
    private WeakReference zzj = new WeakReference(this);

    public zzcra(zzbqq zzbqq, zzcqw zzcqw, Executor executor, zzcqv zzcqv, Clock clock) {
        this.zza = zzcqv;
        this.zzd = zzbqq.zza("google.afma.activeView.handleUpdate", zzbqe.zza, zzbqe.zza);
        this.zzb = zzcqw;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        for (zzchd zzf2 : this.zzc) {
            this.zza.zzf(zzf2);
        }
        this.zza.zze();
    }

    public final synchronized void zzdH() {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzdj(Context context) {
        this.zzh.zze = "u";
        zzg();
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzdk() {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzdl(Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzdm(Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzdp(zzbam zzbam) {
        zzcqz zzcqz = this.zzh;
        zzcqz.zza = zzbam.zzj;
        zzcqz.zzf = zzbam;
        zzg();
    }

    public final void zzdq() {
    }

    public final void zzdr() {
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.ref.WeakReference r0 = r5.zzj     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0059
            boolean r0 = r5.zzi     // Catch:{ all -> 0x005e }
            if (r0 != 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzg     // Catch:{ all -> 0x005e }
            boolean r0 = r0.get()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzcqz r0 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.common.util.Clock r1 = r5.zzf     // Catch:{ Exception -> 0x0051 }
            long r1 = r1.elapsedRealtime()     // Catch:{ Exception -> 0x0051 }
            r0.zzd = r1     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqw r0 = r5.zzb     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqz r1 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            org.json.JSONObject r0 = r0.zzb(r1)     // Catch:{ Exception -> 0x0051 }
            java.util.Set r1 = r5.zzc     // Catch:{ Exception -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x002d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzchd r2 = (com.google.android.gms.internal.ads.zzchd) r2     // Catch:{ Exception -> 0x0051 }
            java.util.concurrent.Executor r3 = r5.zze     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqy r4 = new com.google.android.gms.internal.ads.zzcqy     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x0051 }
            r3.execute(r4)     // Catch:{ Exception -> 0x0051 }
            goto L_0x002d
        L_0x0044:
            com.google.android.gms.internal.ads.zzbqt r1 = r5.zzd     // Catch:{ Exception -> 0x0051 }
            com.google.common.util.concurrent.ListenableFuture r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "ActiveViewListener.callActiveViewJs"
            com.google.android.gms.internal.ads.zzccl.zzb(r0, r1)     // Catch:{ Exception -> 0x0051 }
        L_0x004f:
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "Failed to call ActiveViewJS"
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x005e }
            monitor-exit(r5)
            return
        L_0x0059:
            r5.zzj()     // Catch:{ all -> 0x005e }
            monitor-exit(r5)
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcra.zzg():void");
    }

    public final synchronized void zzh(zzchd zzchd) {
        this.zzc.add(zzchd);
        this.zza.zzd(zzchd);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzr() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
